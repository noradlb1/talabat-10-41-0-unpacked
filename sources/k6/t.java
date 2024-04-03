package k6;

import com.facebook.UserSettingsManager;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f34523b;

    public /* synthetic */ t(long j11) {
        this.f34523b = j11;
    }

    public final void run() {
        UserSettingsManager.m8876initializeCodelessSetupEnabledAsync$lambda0(this.f34523b);
    }
}
