package com.huawei.hms.dtm;

import android.content.Context;
import android.os.RemoteException;
import com.huawei.hms.dtm.provider.api.IDtmDelegate;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.e  reason: case insensitive filesystem */
public class C0473e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f48642a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f48643b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f48644c;

    public C0473e(l lVar, Context context, Map map) {
        this.f48644c = lVar;
        this.f48642a = context;
        this.f48643b = map;
    }

    public void run() {
        if (this.f48644c.f48660b instanceof p) {
            A a11 = new A();
            IDtmDelegate c11 = a11.c(this.f48642a);
            boolean a12 = C.a();
            if (c11 != null || a12) {
                if (c11 == null) {
                    B.c("HMS-DTM", "impl null, use api core");
                    q unused = this.f48644c.f48660b = new m();
                } else {
                    try {
                        int dtmCoreVersion = c11.getDtmCoreVersion();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("remote version = ");
                        sb2.append(dtmCoreVersion);
                        B.c("HMS-DTM", sb2.toString());
                        B.c("HMS-DTM", "local version = 60600302");
                        if (60600302 < dtmCoreVersion || !a12) {
                            B.a("HMS-DTM", "hms newer, use hms core");
                            q unused2 = this.f48644c.f48660b = new o(c11);
                        } else {
                            B.a("HMS-DTM", "api newer, use api core");
                            q unused3 = this.f48644c.f48660b = new m();
                        }
                    } catch (RemoteException unused4) {
                        B.b("HMS-DTM", "RemoteException#initialize");
                    }
                }
                this.f48644c.f48660b.a(this.f48642a, a11.a(), this.f48643b);
                return;
            }
            B.c("HMS-DTM", "dtm.apk and dtm-core not exist");
        }
    }
}
