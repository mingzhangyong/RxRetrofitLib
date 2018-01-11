package com.rxretrofit.mingzhangyong.rxretrofit;


import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zx on 2017/6/20.
 */

public class RxSchedulersHelper<T> {
    /**
     * ！！！注意：此处传入的是(Activity)this.不是Context；
     * @param rxActivity
     * @return
     */
    public ObservableTransformer<T, T> io_main(final RxActivity rxActivity) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(rxActivity.<T>bindUntilEvent(ActivityEvent.DESTROY));
            }

        };
    }

    public static <T> ObservableTransformer<T, T> compose(final BaseActivity rxActivity){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(rxActivity.<T>bindUntilEvent(ActivityEvent.STOP));
            }
        };
    }

    public ObservableTransformer<T, T> io_main(final BaseActivity rxActivity) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(rxActivity.<T>bindUntilEvent(ActivityEvent.DESTROY));
            }

        };
    }

    public ObservableTransformer<T, T> io_io(final BaseActivity rxActivity) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .compose(rxActivity.<T>bindUntilEvent(ActivityEvent.DESTROY));
            }

        };
    }
}
