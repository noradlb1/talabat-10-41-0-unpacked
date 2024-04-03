package b7;

import android.os.Bundle;
import com.facebook.login.LoginLogger;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginLogger f29337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f29338c;

    public /* synthetic */ k(LoginLogger loginLogger, Bundle bundle) {
        this.f29337b = loginLogger;
        this.f29338c = bundle;
    }

    public final void run() {
        LoginLogger.m8997logHeartbeatEvent$lambda0(this.f29337b, this.f29338c);
    }
}
