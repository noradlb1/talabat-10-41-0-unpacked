package b7;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.LoginClient;

public final /* synthetic */ class h implements PlatformServiceClient.CompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GetTokenLoginMethodHandler f29333a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f29334b;

    public /* synthetic */ h(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
        this.f29333a = getTokenLoginMethodHandler;
        this.f29334b = request;
    }

    public final void completed(Bundle bundle) {
        GetTokenLoginMethodHandler.m8994tryAuthorize$lambda1(this.f29333a, this.f29334b, bundle);
    }
}
