package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.dtm.provider.api.IDtmDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import java.util.Map;

public class o implements q {

    /* renamed from: a  reason: collision with root package name */
    public final IDtmDelegate f48665a;

    /* renamed from: b  reason: collision with root package name */
    public C0472d f48666b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48667c = true;

    public o(IDtmDelegate iDtmDelegate) {
        this.f48665a = iDtmDelegate;
    }

    public void a(Context context, Context context2, Map<Object, Object> map) {
        try {
            if (!C.a() && this.f48665a.getDtmCoreVersion() < 60200301) {
                B.c("HMS-DTM", "dtm.apk is low version, disable dtm");
                this.f48667c = false;
            } else if (map == null) {
                this.f48665a.init(ObjectWrapper.wrap(context), ObjectWrapper.wrap(context2));
            } else {
                this.f48665a.initWithConfig(ObjectWrapper.wrap(context), ObjectWrapper.wrap(context2), map);
            }
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#initialize");
        }
    }

    public void a(C0472d dVar) {
        try {
            this.f48666b = dVar;
            if (this.f48667c) {
                this.f48665a.registFilter(new n(this, dVar));
            }
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#registerCallback");
        }
    }

    public void logAutoEvent(String str, Bundle bundle) {
        try {
            if (this.f48666b != null && this.f48667c) {
                this.f48665a.logAutoEvent(str, bundle);
            }
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#logAutoEvent");
        }
    }

    public void logEvent(String str, Bundle bundle) {
        try {
            C0472d dVar = this.f48666b;
            if (dVar != null) {
                if (this.f48667c) {
                    this.f48665a.logEvent(str, bundle);
                } else {
                    dVar.onFiltered(str, bundle);
                }
            }
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#logEvent");
        }
    }

    public void preview(String str) {
        try {
            this.f48665a.preview(str);
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#preview");
        }
    }

    public void setParameter(Map<Object, Object> map) {
        try {
            if (this.f48667c) {
                this.f48665a.setParameter(map);
            }
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#setParameter");
        }
    }

    public void startVisualTrace(String str) {
        try {
            this.f48665a.startVisualTrace(str);
        } catch (RemoteException unused) {
            B.b("HMS-DTM", "RemoteException#preview");
        }
    }
}
