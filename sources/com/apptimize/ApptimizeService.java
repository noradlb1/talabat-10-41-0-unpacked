package com.apptimize;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

public class ApptimizeService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f40979a = "ApptimizeService";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Messenger f40980b = ((Messenger) fe.a(f40979a, null, new fk<Messenger>() {
        /* renamed from: a */
        public Messenger b() {
            Messenger a11 = Apptimize.b().a();
            if (a11 == null) {
                bo.b(ApptimizeService.f40979a, "Error creating ApptimizeService");
            }
            return a11;
        }
    }));

    public IBinder onBind(Intent intent) {
        return (IBinder) fe.a(f40979a, null, new fk<IBinder>() {
            /* renamed from: a */
            public IBinder b() {
                if (ApptimizeService.this.f40980b != null) {
                    return ApptimizeService.this.f40980b.getBinder();
                }
                return null;
            }
        });
    }
}
