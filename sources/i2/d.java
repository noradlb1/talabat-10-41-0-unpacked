package i2;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f44346b;

    public /* synthetic */ d(Context context) {
        this.f44346b = context;
    }

    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.f44346b);
    }
}
