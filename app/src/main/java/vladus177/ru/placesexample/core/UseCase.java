package vladus177.ru.placesexample.core;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T> extends BaseUseCase<T> {

    public void execute(DisposableObserver<T> disposableObserver) {
        final Observable<T> observable = buildUseCaseObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    protected abstract Observable<T> buildUseCaseObservable();
}
