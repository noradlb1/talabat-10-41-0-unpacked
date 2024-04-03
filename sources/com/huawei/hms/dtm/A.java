package com.huawei.hms.dtm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.dtm.provider.api.IDtmCreator;
import com.huawei.hms.dtm.provider.api.IDtmDelegate;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.b;
import java.util.ArrayList;

public class A {

    /* renamed from: a  reason: collision with root package name */
    public Context f48241a;

    /* renamed from: b  reason: collision with root package name */
    public IDtmCreator f48242b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f48243c;

    /* renamed from: d  reason: collision with root package name */
    public a f48244d = new t(this);

    public interface a {
        Context a(Context context, Bundle bundle, boolean z11);

        String a();
    }

    public A() {
        ArrayList<a> arrayList = new ArrayList<>();
        this.f48243c = arrayList;
        u uVar = new u(this);
        v vVar = new v(this);
        w wVar = new w(this);
        x xVar = new x(this);
        y yVar = new y(this);
        z zVar = new z(this);
        arrayList.add(uVar);
        arrayList.add(vVar);
        arrayList.add(wVar);
        arrayList.add(xVar);
        arrayList.add(yVar);
        arrayList.add(zVar);
    }

    public Context a() {
        return this.f48241a;
    }

    public final Context a(Context context) {
        try {
            Thread.sleep(5000);
            B.a("RemoteDtmDelegate", "handleLoadingExceptionInitializing DynamicModule.load");
            DynamicModule.enable3rdPhone("huawei_module_hwdtm", true);
            DynamicModule.enableLowEMUI("huawei_module_hwdtm", true);
            return DynamicModule.load(context, DynamicModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "huawei_module_hwdtm").getModuleContext();
        } catch (InterruptedException | NullPointerException e11) {
            B.a("RemoteDtmDelegate", "load again but still failed: " + e11.getMessage());
            return null;
        } catch (DynamicModule.LoadingException e12) {
            a(context, e12.getBundle(), true);
            return null;
        }
    }

    public final Context a(Context context, Bundle bundle, boolean z11) {
        int i11;
        a aVar;
        if (bundle == null) {
            bundle = new Bundle();
            i11 = 0;
        } else {
            i11 = new E(bundle).b(b.f48765h);
        }
        try {
            aVar = this.f48243c.get(i11);
        } catch (IndexOutOfBoundsException unused) {
            aVar = this.f48244d;
        }
        B.b("RemoteDtmDelegate", aVar.a());
        return aVar.a(context, bundle, z11);
    }

    public final void a(Context context, Bundle bundle) {
        if (((Intent) new E(bundle).c("resolution")) == null) {
            B.b("RemoteDtmDelegate", "null intent,please check it.");
        } else {
            B.d("RemoteDtmDelegate", "get intent successfully. do nothing.");
        }
    }

    public final IDtmCreator b(Context context) {
        IDtmCreator iDtmCreator = this.f48242b;
        if (iDtmCreator != null) {
            return iDtmCreator;
        }
        try {
            Context d11 = d(context);
            if (d11 == null) {
                return null;
            }
            this.f48242b = IDtmCreator.Stub.asInterface((IBinder) d11.getClassLoader().loadClass("com.huawei.hms.feature.provider.Creator").newInstance());
            return this.f48242b;
        } catch (Exception unused) {
            B.b("RemoteDtmDelegate", "newCreator Exception");
        }
    }

    public IDtmDelegate c(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            IDtmCreator b11 = b(context);
            if (b11 == null) {
                return null;
            }
            return b11.newDtmDelegate(ObjectWrapper.wrap(context));
        } catch (NoClassDefFoundError unused) {
            str = "no class found.";
            B.b("RemoteDtmDelegate", str);
            return null;
        } catch (Exception unused2) {
            str = "new Creator error.";
            B.b("RemoteDtmDelegate", str);
            return null;
        }
    }

    public final Context d(Context context) {
        Context context2 = this.f48241a;
        if (context2 != null) {
            return context2;
        }
        try {
            B.a("RemoteDtmDelegate", "newRemoteContext DynamicModule.load");
            DynamicModule.enable3rdPhone("huawei_module_hwdtm", true);
            DynamicModule.enableLowEMUI("huawei_module_hwdtm", true);
            this.f48241a = DynamicModule.load(context, DynamicModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "huawei_module_hwdtm").getModuleContext();
        } catch (DynamicModule.LoadingException e11) {
            this.f48241a = a(context, e11.getBundle(), false);
        } catch (Exception unused) {
            B.b("RemoteDtmDelegate", "newRemoteContext Exception");
        }
        return this.f48241a;
    }
}
