package vladus177.ru.placesexample.places.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import vladus177.ru.placesexample.App;
import vladus177.ru.placesexample.R;
import vladus177.ru.placesexample.common.view.LoadingDialogFragment;
import vladus177.ru.placesexample.core.BaseFragment;
import vladus177.ru.placesexample.places.di.DaggerPlacesComponent;
import vladus177.ru.placesexample.places.di.PlacesModule;
import vladus177.ru.placesexample.places.view.adapter.PlaceListAdapter;
import vladus177.ru.placesexample.places.view.listener.ItemClickListener;
import vladus177.ru.placesexample.places.view.listener.OnLoadPlacesListener;
import vladus177.ru.placesexample.places.view.presenter.PlacesListContract;
import vladus177.ru.placesexample.places.view.presenter.PlacesListPresenter;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesResultView;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesListFragment extends BaseFragment implements PlacesListContract.View, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ItemClickListener, OnLoadPlacesListener {

    @Inject
    PlacesListPresenter presenter;

    @Inject
    LoadingDialogFragment loadingDialogFragment;

    @Inject
    protected FusedLocationProviderClient fusedLocationClient;

    @Inject
    protected GoogleApiClient googleApiClient;

    @Inject
    protected LocationRequest locationRequest;

    @Inject
    protected PlaceListAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private static final int REQUEST_CODE_CHECK_LOCATION_PERMISSION = 11;
    private static final int INITIAL_PAGE = 0;
    private RecyclerView.LayoutManager layoutManager;

    List<PlacesResultView> places = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_places_list;
    }

    @Override
    protected void onPrepareFragment(@NonNull View view) {
        super.onPrepareFragment(view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        googleApiClient.connect();
    }

    @Override
    protected void onPreparePresenter() {
        attachPresenter(presenter, this);
    }

    @Override
    public void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter.checkLocationPermission()) {
            getLastLocation();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    // GPS location can be null if GPS is switched off
                    if (location != null) {
                        presenter.setUserLocationAndRequestPlaces(location.getLatitude(), location.getLongitude());
                    } else {
                        askForGpsEnable();
                    }
                })
                .addOnFailureListener(e -> showError("Error trying to get last GPS location")
                );
    }

    @Override
    public void setPlaces(PlacesView places) {
        this.places.clear();
        this.places.addAll(places.results);
        adapter.onNewDataReceived(places.results);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void askForLocationPermission() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.title_location_permission_dialog));
        builder.setMessage(getResources().getString(R.string.message_location_permission_dialog));
        builder.setPositiveButton(getResources().getString(R.string.label_ok), (dialog, which) -> ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_CODE_CHECK_LOCATION_PERMISSION));
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void askForGpsEnable() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.title_gps_enable_dialog));
        builder.setMessage(getResources().getString(R.string.message_gps_enable_dialog));
        builder.setPositiveButton(getResources().getString(R.string.label_enable), (dialog, which) -> {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            getActivity().startActivity(intent);
        });
        builder.setNegativeButton(getResources().getString(R.string.label_cancel), (dialog, which) -> {
            dialog.cancel();

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public boolean locationPermissionsGranted() {
        return ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading() {
        if (!loadingDialogFragment.isVisible()) {
            loadingDialogFragment.show(getActivity().getSupportFragmentManager(), "loading");
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialogFragment.isVisible()) {
            loadingDialogFragment.dismiss();
        }
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }

    @Override
    public void showInformation(String information) {
        showInformationDialog(information);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_CHECK_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.

            } else {
                // User refused to grant permission.
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onItemClick(int pos) {

    }

    @Override
    public void onLoadMorePlacess() {

    }

    @Override
    protected void onInjection() {
        DaggerPlacesComponent.builder()
                .appComponent(App.getApplicationComponent())
                .placesModule(new PlacesModule())
                .build()
                .inject(this);
    }
}
