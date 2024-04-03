package com.instabug.library.tracking;

import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.m;
import com.instabug.library.model.o;
import com.instabug.library.model.p;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;

public class n {

    /* renamed from: b  reason: collision with root package name */
    private static n f51941b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f51942a = new ArrayList(100);

    private n() {
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (f51941b == null) {
                f51941b = new n();
            }
            nVar = f51941b;
        }
        return nVar;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.f51942a.size() >= 100) {
            try {
                this.f51942a.remove(0);
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "Error while removing step from userTracking steps", "IBG-Core");
            }
        }
    }

    public ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.f51942a.size(); i11++) {
            try {
                p pVar = (p) this.f51942a.get(i11);
                if (pVar != null) {
                    o oVar = new o();
                    oVar.a(pVar.b());
                    oVar.a(pVar.d());
                    oVar.b(pVar.c());
                    oVar.a(new m(oVar.d(), pVar.a(), pVar.e(), pVar.f()));
                    arrayList.add(oVar);
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "Error while getting user tracking steps: ", "IBG-Core");
            }
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        PoolProvider.postIOTask(new l(this, str2, str));
    }

    public void a(String str, String str2, String str3) {
        a(str, str2, (String) null, str3);
    }

    public void a(String str, String str2, @Nullable String str3, String str4) {
        PoolProvider.postIOTask(new m(this, str4, str, str2, str3));
    }

    /* access modifiers changed from: private */
    public p a(String str) {
        p pVar = new p();
        pVar.a(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds());
        pVar.c(str);
        return pVar;
    }

    public void a(String str, String str2, String str3, @Nullable String str4, String str5) {
        p pVar = new p();
        pVar.c(str);
        pVar.b(str2);
        pVar.a(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds());
        pVar.d(str3);
        pVar.a(str4);
        pVar.e(str5);
        c();
        try {
            this.f51942a.add(pVar);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, "Error while adding step to userTracking steps", "IBG-Core");
        }
    }
}
