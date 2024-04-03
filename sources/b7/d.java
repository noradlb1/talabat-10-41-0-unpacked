package b7;

import com.facebook.login.DeviceAuthDialog;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f29329b;

    public /* synthetic */ d(DeviceAuthDialog deviceAuthDialog) {
        this.f29329b = deviceAuthDialog;
    }

    public final void run() {
        DeviceAuthDialog.m8992schedulePoll$lambda3(this.f29329b);
    }
}
