package o6;

import android.os.Bundle;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34604b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f34605c;

    public /* synthetic */ a(String str, Bundle bundle) {
        this.f34604b = str;
        this.f34605c = bundle;
    }

    public final void run() {
        CodelessLoggingEventListener.m8904logEvent$lambda0(this.f34604b, this.f34605c);
    }
}
