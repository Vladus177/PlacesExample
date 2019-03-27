package vladus177.ru.placesexample.places.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import vladus177.ru.placesexample.R;
import vladus177.ru.placesexample.core.BaseFragmentActivity;
import vladus177.ru.placesexample.places.view.fragment.PlacesListFragment;

public class PlacesActivity extends BaseFragmentActivity {

    PlacesListFragment fragment;

    @Override
    protected int getContainerViewId() {
        return R.id.container;
    }

    @Override
    protected Fragment getFragmentInstance() {
        fragment = new PlacesListFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_places;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
