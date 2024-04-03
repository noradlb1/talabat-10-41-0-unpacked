package s6;

import android.content.Context;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f34664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34665c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34666d;

    public /* synthetic */ a(Context context, String str, String str2) {
        this.f34664b = context;
        this.f34665c = str;
        this.f34666d = str2;
    }

    public final void run() {
        OnDeviceProcessingManager.m8927sendInstallEventAsync$lambda0(this.f34664b, this.f34665c, this.f34666d);
    }
}
