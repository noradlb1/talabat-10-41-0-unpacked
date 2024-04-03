package i2;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f44347b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f44348c;

    public /* synthetic */ e(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f44347b = profileInstallerInitializer;
        this.f44348c = context;
    }

    public final void run() {
        this.f44347b.lambda$delayAfterFirstFrame$0(this.f44348c);
    }
}
