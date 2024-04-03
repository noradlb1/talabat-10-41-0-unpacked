package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class a implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f640a;

    public /* synthetic */ a(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f640a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f640a.B();
    }
}
