package l6;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventQueue;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f34549b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppEvent f34550c;

    public /* synthetic */ g(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.f34549b = accessTokenAppIdPair;
        this.f34550c = appEvent;
    }

    public final void run() {
        AppEventQueue.m8880add$lambda3(this.f34549b, this.f34550c);
    }
}
