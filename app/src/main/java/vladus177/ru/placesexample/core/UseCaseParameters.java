package vladus177.ru.placesexample.core;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseParameters<T, P> extends BaseUseCase {

    public void execute(DisposableObserver<T> disposableObserver, P parameters) {
        final Observable<T> observable = buildUseCase(parameters).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected abstract Observable<T> buildUseCase(P params);
}
