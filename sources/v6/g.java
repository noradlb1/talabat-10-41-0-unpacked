package v6;

import android.content.Context;
import com.facebook.internal.FetchedAppSettingsManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f34748b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34749c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34750d;

    public /* synthetic */ g(Context context, String str, String str2) {
        this.f34748b = context;
        this.f34749c = str;
        this.f34750d = str2;
    }

    public final void run() {
        FetchedAppSettingsManager.m8952loadAppSettingsAsync$lambda0(this.f34748b, this.f34749c, this.f34750d);
    }
}
