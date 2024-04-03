package v6;

import android.content.Context;
import com.facebook.internal.FetchedAppGateKeepersManager;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34745c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34746d;

    public /* synthetic */ e(String str, Context context, String str2) {
        this.f34744b = str;
        this.f34745c = context;
        this.f34746d = str2;
    }

    public final void run() {
        FetchedAppGateKeepersManager.m8950loadAppGateKeepersAsync$lambda0(this.f34744b, this.f34745c, this.f34746d);
    }
}
