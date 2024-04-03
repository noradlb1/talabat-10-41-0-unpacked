package d;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class j implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f11584a;

    public /* synthetic */ j(Runnable runnable) {
        this.f11584a = runnable;
    }

    public final void onBackInvoked() {
        this.f11584a.run();
    }
}
