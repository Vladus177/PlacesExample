package vladus177.ru.placesexample.core;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    private BasePresenter basePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onInjection();
        onPrepareFragment(view);
        onPreparePresenter();
    }

    protected void bindViews(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    protected void onPreparePresenter() {

    }

    protected void onPrepareFragment(@NonNull View view) {

    }

    protected void onInjection() {

    }

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        releasePresenter();
    }

    public void showToast(String message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_SHORT).show();
    }

    public void showInformationDialog(String information) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(information)
                .setCancelable(false)
                .setNeutralButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void attachPresenter(BasePresenter basePresenter, BasePresenter.View view) {
        this.basePresenter = basePresenter;
        this.basePresenter.attachView(view);
    }

    private void releasePresenter() {
        if (basePresenter != null) {
            basePresenter.release();
        }
    }
}
