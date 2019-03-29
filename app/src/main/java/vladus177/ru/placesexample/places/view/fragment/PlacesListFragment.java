package vladus177.ru.placesexample.places.view.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;

import vladus177.ru.placesexample.App;
import vladus177.ru.placesexample.R;
import vladus177.ru.placesexample.common.view.LoadingDialogFragment;
import vladus177.ru.placesexample.core.BaseFragment;
import vladus177.ru.placesexample.places.di.DaggerPlacesComponent;
import vladus177.ru.placesexample.places.di.PlacesModule;
import vladus177.ru.placesexample.places.view.presenter.PlacesListContract;
import vladus177.ru.placesexample.places.view.presenter.PlacesListPresenter;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesView;

public class PlacesListFragment extends BaseFragment implements PlacesListContract.View {

    @Inject
    PlacesListPresenter presenter;

    @Inject
    LoadingDialogFragment loadingDialogFragment;

    private static final int REQUEST_CODE_CHECK_LOCATION_PERMISSION = 11;
    PlacesView placesView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_places_list;
    }

    @Override
    protected void onPreparePresenter() {
        attachPresenter(presenter, this);
        presenter.getPlacesFromRemoteRepository();
    }

    @Override
    public void onResume() {
        super.onResume();
        //presenter.checkLocationPermission();
    }


    @Override
    public void setPlaces(PlacesView places) {
        showToast("OK");
        this.placesView = places;
    }

    @Override //Todo check if location permission needed to make requests for Places Api
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
    protected void onInjection() {
        DaggerPlacesComponent.builder()
                .appComponent(App.getApplicationComponent())
                .placesModule(new PlacesModule())
                .build()
                .inject(this);
    }
}
