package com.apptimize;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.apptimize.it;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ik implements jj<JSONObject, it> {

    /* renamed from: a  reason: collision with root package name */
    public static hm<JSONArray> f43064a = new hp(Cif.f43019a);

    /* renamed from: b  reason: collision with root package name */
    private static final String f43065b = "ik";

    /* renamed from: c  reason: collision with root package name */
    private Cif f43066c;

    public ik(ih ihVar) {
        this.f43066c = Cif.b(ihVar);
    }

    /* renamed from: a */
    public JSONObject b(it itVar) throws JSONException, hk {
        JSONArray jSONArray = new JSONArray();
        try {
            int c11 = itVar.c();
            for (int i11 = 0; i11 < c11; i11++) {
                int[] b11 = itVar.b(i11);
                Drawable a11 = itVar.a(i11);
                JSONArray jSONArray2 = new JSONArray();
                for (int put : b11) {
                    jSONArray2.put(put);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("states", (Object) jSONArray2);
                jSONObject.put("value", (Object) this.f43066c.b(ip.a(a11)));
                jSONArray.put((Object) jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("contents", (Object) jSONArray);
            return jSONObject2;
        } catch (it.a unused) {
            throw new hk("Reflection failure when accessing StateListDrawable. May lead to deleted images");
        }
    }

    public Class<it> b() {
        return it.class;
    }

    public it a(JSONObject jSONObject) throws JSONException, hk {
        JSONArray jSONArray = jSONObject.getJSONArray("contents");
        StateListDrawable stateListDrawable = new StateListDrawable();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            List list = (List) fh.a((Object) jSONObject2.getJSONArray("states"));
            int[] iArr = new int[list.size()];
            for (int i12 = 0; i12 < list.size(); i12++) {
                iArr[i12] = ((Number) list.get(i12)).intValue();
            }
            if (!jSONObject2.has("useOriginal") || !jSONObject2.getBoolean("useOriginal")) {
                stateListDrawable.addState(iArr, ((io) this.f43066c.a(jSONObject2.getJSONObject("value"))).b((io) null));
            } else {
                arrayList.add(iArr);
            }
        }
        return new it((iq) null, stateListDrawable, arrayList);
    }

    public Class<JSONObject> a() {
        return JSONObject.class;
    }
}
