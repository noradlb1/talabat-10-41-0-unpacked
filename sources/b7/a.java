package b7;

import android.os.Bundle;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomTabLoginMethodHandler f29321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f29322c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f29323d;

    public /* synthetic */ a(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        this.f29321b = customTabLoginMethodHandler;
        this.f29322c = request;
        this.f29323d = bundle;
    }

    public final void run() {
        CustomTabLoginMethodHandler.m8986onCustomTabComplete$lambda0(this.f29321b, this.f29322c, this.f29323d);
    }
}
