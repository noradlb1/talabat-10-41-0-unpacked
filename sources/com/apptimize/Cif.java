package com.apptimize;

import com.apptimize.hq;
import com.apptimize.io;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apptimize.if  reason: invalid class name */
public class Cif extends jl<io> {

    /* renamed from: a  reason: collision with root package name */
    public static hm<JSONObject> f43019a;

    /* renamed from: b  reason: collision with root package name */
    public static hm<JSONObject> f43020b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, jj<?, ? extends io>> f43021c;

    static {
        hq.a aVar = new hq.a();
        hm<JSONObject> hmVar = hm.f42955d;
        hq.a a11 = aVar.a("image", hmVar);
        hm<JSONObject> hmVar2 = hm.f42952a;
        hq.a a12 = a11.a("color", hmVar2);
        hm<Void> hmVar3 = hm.f42958g;
        f43019a = a12.a("null", hmVar3).a();
        f43020b = new hq.a().a("image", hmVar).a("color", hmVar2).a("null", hmVar3).a("stateful", ik.f43064a).a();
    }

    private Cif(Map<String, jj<?, ? extends io>> map) {
        super(map);
        this.f43021c = map;
    }

    public static Cif a(ih ihVar) {
        return new Cif(d(ihVar));
    }

    private static Map<String, jj<?, ? extends io>> c(ih ihVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("image", io.a.a(new id(ihVar)));
        hashMap.put("color", io.a.a(jc.a(new ij(), new iz())));
        hashMap.put("null", new is());
        return hashMap;
    }

    private static Map<String, jj<?, ? extends io>> d(ih ihVar) {
        Map<String, jj<?, ? extends io>> c11 = c(ihVar);
        c11.put("stateful", io.a.a(new ik(ihVar)));
        return c11;
    }

    public static Cif b(ih ihVar) {
        return new Cif(c(ihVar));
    }

    /* renamed from: a */
    public JSONObject b(io ioVar) throws JSONException, hk {
        return a(ioVar.b(), ioVar.a(this));
    }

    public jj<?, ? extends io> a(String str) {
        return this.f43021c.get(str);
    }
}
