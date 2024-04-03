package b7;

import android.os.Bundle;
import com.facebook.login.LoginClient;
import com.facebook.login.NativeAppLoginMethodHandler;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeAppLoginMethodHandler f29346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f29347c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f29348d;

    public /* synthetic */ o(NativeAppLoginMethodHandler nativeAppLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        this.f29346b = nativeAppLoginMethodHandler;
        this.f29347c = request;
        this.f29348d = bundle;
    }

    public final void run() {
        NativeAppLoginMethodHandler.m9002processSuccessResponse$lambda0(this.f29346b, this.f29347c, this.f29348d);
    }
}
