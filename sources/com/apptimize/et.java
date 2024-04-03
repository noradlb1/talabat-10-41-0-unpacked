package com.apptimize;

import com.apptimize.bd;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class et extends er<ed> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f42343d = "et";

    /* renamed from: e  reason: collision with root package name */
    private final es f42344e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f42345f = true;

    /* renamed from: g  reason: collision with root package name */
    private AtomicReference<ed> f42346g = new AtomicReference<>((Object) null);

    public et(bd.a aVar, au auVar, String str) {
        super(aVar, auVar, str);
        this.f42344e = new es(aVar, auVar, str);
    }

    public String e() {
        return "PROCESSED_META_DATA_f2872b0a-6ce8-4bd3-8bf8-32bedee3961d";
    }

    /* renamed from: g */
    public ed f() {
        if (this.f42344e == null) {
            return null;
        }
        bo.b(f42343d, "Illegal call. Use getItem(boolean, boolean)");
        return null;
    }

    /* renamed from: b */
    public ed a(JSONObject jSONObject) throws Exception {
        return ed.a(jSONObject, this.f42335a);
    }

    public void c() {
        ed edVar = (ed) super.f();
        if (edVar == null) {
            bo.k(f42343d, "requestPersist with null data");
        } else if (edVar.k() == null || edVar.b() == edVar.k().f()) {
            super.c();
            if (this.f42345f && edVar.k() != null) {
                this.f42344e.b(edVar.k());
            }
            this.f42345f = true;
        } else {
            bo.g(f42343d, String.format("Inconsistent ProcessedMetaData %d, MD %d", new Object[]{Integer.valueOf(edVar.b()), Integer.valueOf(edVar.k().f())}));
        }
    }

    public JSONObject a(ed edVar) throws JSONException {
        return edVar.a(false);
    }

    public void b(ed edVar) {
        bo.b(f42343d, "Illegal call. Use setItem(ProcessedMetaData, boolean)");
    }

    public void a(cc ccVar, boolean z11) {
        ed a11 = a(z11, true);
        if (a11 != null) {
            cb k11 = a11.k();
            by f11 = ccVar.f();
            if (k11 == null || !(f11 == null || k11.f() == f11.f())) {
                this.f42345f = true;
            } else if (!z11) {
                this.f42345f = false;
            } else {
                this.f42345f = true;
            }
            b(a11.a(ccVar), z11);
        }
    }

    public void b(ed edVar, boolean z11) {
        String str = f42343d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setItem newItem:");
        sb2.append(edVar == null ? "null" : "not-null");
        sb2.append(" temporary:");
        sb2.append(z11);
        bo.k(str, sb2.toString());
        if (z11) {
            this.f42346g.set(edVar);
        } else {
            super.b(edVar);
        }
    }

    public ed a(ed edVar, boolean z11) {
        String str = f42343d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getAndSet newItem:");
        sb2.append(edVar == null ? "null" : "not-null");
        sb2.append(" temporary:");
        sb2.append(z11);
        bo.k(str, sb2.toString());
        if (z11) {
            return this.f42346g.getAndSet(edVar);
        }
        return (ed) super.c(edVar);
    }

    public ed c(ed edVar) {
        bo.b(f42343d, "Illegal call. Use getAndSet(ProcessedMetaData, boolean)");
        return null;
    }

    public ed a(boolean z11, boolean z12) {
        if (z11) {
            return this.f42346g.get();
        }
        ed edVar = (ed) super.f();
        if (!z12 || edVar == null || edVar.k() != null) {
            return edVar;
        }
        cb cbVar = (cb) this.f42344e.f();
        if (cbVar == null || edVar.c() == null) {
            bo.g(f42343d, "Data inconsistency. No stored metadata found");
            return null;
        }
        if (cbVar.f() != edVar.b()) {
            this.f42344e.b();
            cbVar = (cb) this.f42344e.f();
        }
        if (cbVar.f() != edVar.b()) {
            bo.g(f42343d, String.format("MetaData version mismatch ProcessedMetaData for verions %d but store MetaData %d", new Object[]{Integer.valueOf(edVar.b()), Integer.valueOf(cbVar.f())}));
            return null;
        }
        bo.k(f42343d, "updating with persisted metaData");
        ed a11 = edVar.a((by) cbVar);
        this.f42337c.set(a11);
        return a11;
    }
}
