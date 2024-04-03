package com.instabug.survey.ui.survey.welcomepage;

import com.instabug.library.core.ui.BasePresenter;
import java.lang.ref.WeakReference;

class d extends BasePresenter {
    public d(c cVar) {
        super(cVar);
    }

    public void a() {
        c cVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (cVar = (c) weakReference.get()) != null) {
            cVar.a();
        }
    }
}
