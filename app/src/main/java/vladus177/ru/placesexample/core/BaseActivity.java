package vladus177.ru.placesexample.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInjection();
        setContentView(getLayoutId());
        bindViews();
        onPreparePresenter();
        onPrepareActivity();
    }

    private void bindViews() {
        unbinder = ButterKnife.bind(this);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected void onPreparePresenter() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void onInjection() {

    }

    protected void onPrepareActivity() {

    }
}
