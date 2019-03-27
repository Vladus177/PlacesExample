package vladus177.ru.placesexample.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import vladus177.ru.placesexample.R;
import vladus177.ru.placesexample.core.BaseDialogFragment;

public class LoadingDialogFragment extends BaseDialogFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_fragment_loading;
    }

    public static DialogFragment getInstance() {
        LoadingDialogFragment loadingDialogFragment = new LoadingDialogFragment();
        loadingDialogFragment.setCancelable(false);
        return loadingDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
    }
}
