package com.instabug.bug.view.visualusersteps.steppreview;

import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;

public class h extends BasePresenter {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Disposable f45958a;

    public h(c cVar) {
        super(cVar);
    }

    private Observable e(String str) {
        return Observable.fromCallable(new g(this, str));
    }

    public void d(String str) {
        c cVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (cVar = (c) weakReference.get()) != null) {
            cVar.a(true);
            this.f45958a = e(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new f(this, cVar)).subscribe(new e(this, cVar));
        }
    }

    public void l() {
        Disposable disposable = this.f45958a;
        if (disposable != null && !disposable.isDisposed()) {
            this.f45958a.dispose();
        }
    }
}
