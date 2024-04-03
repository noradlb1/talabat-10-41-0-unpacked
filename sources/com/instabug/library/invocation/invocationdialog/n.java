package com.instabug.library.invocation.invocationdialog;

import com.instabug.library.core.ui.BasePresenter;
import java.lang.ref.WeakReference;

public class n extends BasePresenter {
    public n(m mVar) {
        super(mVar);
    }

    private void c() {
        m mVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (mVar = (m) weakReference.get()) != null) {
            mVar.d();
        }
    }

    public void a() {
        m mVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (mVar = (m) weakReference.get()) != null) {
            c();
            mVar.b();
        }
    }

    public void b() {
    }
}
