package b7;

import android.os.Bundle;
import com.facebook.LoginStatusCallback;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginLogger;
import com.facebook.login.LoginManager;

public final /* synthetic */ class m implements PlatformServiceClient.CompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f29341a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginLogger f29342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginStatusCallback f29343c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f29344d;

    public /* synthetic */ m(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2) {
        this.f29341a = str;
        this.f29342b = loginLogger;
        this.f29343c = loginStatusCallback;
        this.f29344d = str2;
    }

    public final void completed(Bundle bundle) {
        LoginManager.m8999retrieveLoginStatusImpl$lambda2(this.f29341a, this.f29342b, this.f29343c, this.f29344d, bundle);
    }
}
