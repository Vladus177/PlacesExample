package vladus177.ru.placesexample.core;

import io.reactivex.observers.DisposableObserver;

public class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
