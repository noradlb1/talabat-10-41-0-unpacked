package com.apptimize;

import com.apptimize.ap;
import com.apptimize.bd;
import com.apptimize.ec;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import org.json.JSONException;
import org.json.JSONObject;

public class ea implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42204a = "ea";

    /* renamed from: b  reason: collision with root package name */
    private final ec f42205b;

    /* renamed from: c  reason: collision with root package name */
    private ap f42206c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public dz f42207d = new dz();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Boolean> f42208e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final au f42209f;

    public ea(bd.a aVar, au auVar) {
        Class<Map> cls = Map.class;
        Class<ea> cls2 = ea.class;
        this.f42209f = auVar;
        ec ecVar = new ec(this, aVar, auVar);
        this.f42205b = ecVar;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "NAMED_FILTER_VALUES__ea171960-0d73-11e4-9191-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return ea.this.f42207d.a();
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    bo.c(ea.f42204a, "This is the first time we've run; no previous NamedFilterValues");
                } else {
                    dz unused = ea.this.f42207d = dz.a(jSONObject);
                }
            }
        });
        try {
            this.f42206c = new ap.a(this).a("setTransientNamedFilters", cls2.getDeclaredMethod("a", new Class[]{cls})).a("setPersistentNamedFilters", cls2.getDeclaredMethod("b", new Class[]{cls})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42204a, "Error", e11);
        }
        b();
    }

    public void c() {
        this.f42205b.b();
    }

    public void d() {
        this.f42206c.b(a());
    }

    public dy e() {
        return new dx(this.f42208e, Collections.EMPTY_MAP);
    }

    public void b() {
        this.f42205b.a();
    }

    private void b(Map<String, Boolean> map) {
        this.f42207d = new dz(map);
        this.f42206c.a("setPersistentNamedFilters", a(), map);
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                Adler32 adler32 = new Adler32();
                fd.a((Checksum) adler32, fd.a((Map<?, ?>) ea.this.f42208e));
                fd.a((Checksum) adler32, fd.a((Map<?, ?>) ea.this.f42207d.b()));
                return Long.valueOf(adler32.getValue());
            }
        };
    }

    public void a(List<ce> list, bb bbVar) {
        Map<String, Boolean> b11 = this.f42207d.b();
        HashMap hashMap = new HashMap(list.size());
        for (ce next : list) {
            hashMap.put(next.b(), next);
        }
        dx dxVar = new dx(Collections.EMPTY_MAP, hashMap);
        bb a11 = bbVar.a((dy) dxVar);
        for (ce next2 : list) {
            dxVar.a(next2.b(), next2.a(a11, b11));
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next3 : dxVar.a().entrySet()) {
            ce ceVar = (ce) hashMap.get(next3.getKey());
            if (ceVar == null) {
                String str = f42204a;
                bo.b(str, "Failed to find the filter with name " + ((String) next3.getKey()));
            } else if (ceVar.a((Boolean) next3.getValue())) {
                hashMap2.put(next3.getKey(), next3.getValue());
            }
        }
        a(dxVar.a());
        b((Map<String, Boolean>) hashMap2);
    }

    private void a(Map<String, Boolean> map) {
        this.f42208e = Collections.unmodifiableMap(new HashMap(map));
        this.f42206c.b("setTransientNamedFilters", a(), map);
    }
}
