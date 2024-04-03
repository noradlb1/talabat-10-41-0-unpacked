package l6;

import com.facebook.appevents.AnalyticsUserIDStore;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34541b;

    public /* synthetic */ b(String str) {
        this.f34541b = str;
    }

    public final void run() {
        AnalyticsUserIDStore.m8879setUserID$lambda1(this.f34541b);
    }
}
