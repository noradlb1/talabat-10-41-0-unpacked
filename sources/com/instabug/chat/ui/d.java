package com.instabug.chat.ui;

import com.instabug.chat.ChatsDelegate;
import com.instabug.chat.cache.k;
import com.instabug.chat.model.a;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.core.ui.BasePresenter;
import java.lang.ref.WeakReference;

public class d extends BasePresenter implements b {
    public d(c cVar) {
        super(cVar);
    }

    private void b(String str, a aVar) {
        WeakReference<V> weakReference = this.f34200f;
        c cVar = weakReference != null ? (c) weakReference.get() : null;
        if (l() && cVar != null) {
            cVar.i();
        }
        if (cVar != null) {
            cVar.a(str, aVar);
        }
    }

    private void c(String str) {
        WeakReference<V> weakReference = this.f34200f;
        c cVar = weakReference != null ? (c) weakReference.get() : null;
        if (l() && cVar != null) {
            cVar.i();
        }
        if (cVar != null) {
            cVar.c(str);
        }
    }

    private void k() {
        WeakReference<V> weakReference;
        c cVar;
        if (l() && (weakReference = this.f34200f) != null && (cVar = (c) weakReference.get()) != null) {
            cVar.i();
        }
    }

    private boolean l() {
        return k.i().size() > 0;
    }

    public void a(int i11) {
        WeakReference<V> weakReference;
        c cVar;
        c cVar2;
        if (i11 == 160) {
            k();
        } else if (i11 == 161) {
            WeakReference<V> weakReference2 = this.f34200f;
            if (weakReference2 != null && (cVar2 = (c) weakReference2.get()) != null && cVar2.q() != null) {
                c(cVar2.q());
            }
        } else if (i11 == 164 && (weakReference = this.f34200f) != null && (cVar = (c) weakReference.get()) != null && cVar.q() != null && cVar.m() != null) {
            b(cVar.q(), cVar.m());
        }
    }

    public void a(String str) {
        c(str);
    }

    public void f() {
        OnSdkDismissCallback e11 = com.instabug.chat.settings.a.e();
        if (e11 != null) {
            e11.call(OnSdkDismissCallback.DismissType.CANCEL, OnSdkDismissCallback.ReportType.OTHER);
        }
    }

    public void i() {
        ChatsDelegate.dismissSystemNotification();
    }
}
