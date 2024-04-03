package zr;

import android.app.NotificationManager;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NotificationManager f63125b;

    public /* synthetic */ z(NotificationManager notificationManager) {
        this.f63125b = notificationManager;
    }

    public final void run() {
        this.f63125b.cancel(9999);
    }
}
