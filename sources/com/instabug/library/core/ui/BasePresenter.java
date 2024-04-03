package com.instabug.library.core.ui;

import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseContract.View;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<V> f34200f;

    public BasePresenter(V v11) {
        this.f34200f = new WeakReference<>(v11);
    }

    public void onDestroy() {
        this.f34200f = null;
    }
}
