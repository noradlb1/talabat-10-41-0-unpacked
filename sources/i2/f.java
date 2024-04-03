package i2;

import android.content.Context;
import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f44349b;

    public /* synthetic */ f(Context context) {
        this.f44349b = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.f44349b);
    }
}
