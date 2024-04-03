package com.uxcam.internals;

import android.graphics.Rect;
import com.apptimize.c;
import com.google.firebase.perf.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fi {

    /* renamed from: a  reason: collision with root package name */
    public final int f13315a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13316b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13317c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13318d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13319e;

    /* renamed from: f  reason: collision with root package name */
    public final String f13320f;

    /* renamed from: g  reason: collision with root package name */
    public final hr f13321g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f13322h;

    /* renamed from: i  reason: collision with root package name */
    public String f13323i;

    /* renamed from: j  reason: collision with root package name */
    public String f13324j;

    /* renamed from: k  reason: collision with root package name */
    public JSONArray f13325k = new JSONArray();

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public int f13326a;

        /* renamed from: b  reason: collision with root package name */
        public int f13327b;

        /* renamed from: c  reason: collision with root package name */
        public String f13328c;

        /* renamed from: d  reason: collision with root package name */
        public Rect f13329d;

        /* renamed from: e  reason: collision with root package name */
        public String f13330e;

        /* renamed from: f  reason: collision with root package name */
        public String f13331f;

        /* renamed from: g  reason: collision with root package name */
        public float f13332g;

        /* renamed from: h  reason: collision with root package name */
        public int f13333h;

        /* renamed from: i  reason: collision with root package name */
        public String f13334i;

        /* renamed from: j  reason: collision with root package name */
        public hr f13335j;

        /* renamed from: k  reason: collision with root package name */
        public ArrayList f13336k;

        /* renamed from: l  reason: collision with root package name */
        public String f13337l = "";

        /* renamed from: m  reason: collision with root package name */
        public JSONArray f13338m = new JSONArray();

        public static /* synthetic */ fi d(aa aaVar) {
            return null;
        }

        public aa a(String str) {
            if (str.length() < 128) {
                this.f13330e = str;
            } else {
                this.f13330e = str.substring(0, 128).concat("...");
            }
            return this;
        }

        public aa a(Class cls) {
            this.f13334i = cls.getName();
            ArrayList arrayList = new ArrayList();
            while (cls.getSuperclass() != null) {
                cls = cls.getSuperclass();
                arrayList.add(cls);
            }
            int i11 = 0;
            arrayList.remove(0);
            if (arrayList.size() > 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Class cls2 = (Class) it.next();
                if (i11 >= 4) {
                    break;
                }
                jSONArray.put((Object) cls2.getName());
                i11++;
            }
            this.f13338m = jSONArray;
            return this;
        }
    }

    public fi(aa aaVar) {
        this.f13315a = aaVar.f13326a;
        this.f13322h = aaVar.f13329d;
        this.f13316b = aaVar.f13327b;
        this.f13317c = aaVar.f13328c;
        this.f13323i = aaVar.f13330e;
        this.f13318d = aaVar.f13331f;
        float unused = aaVar.f13332g;
        this.f13319e = aaVar.f13333h;
        this.f13320f = aaVar.f13334i;
        this.f13321g = aaVar.f13335j;
        ArrayList unused2 = aaVar.f13336k;
        aa.d(aaVar);
        this.f13324j = aaVar.f13337l;
        this.f13325k = aaVar.f13338m;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vt", this.f13315a);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f13322h.left);
            jSONArray.put(this.f13322h.top);
            jSONArray.put(this.f13322h.width());
            jSONArray.put(this.f13322h.height());
            jSONObject.put("rec", (Object) jSONArray);
            int i11 = this.f13316b;
            if (i11 > 0) {
                jSONObject.put("i", i11);
            }
            String str = this.f13317c;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("is", (Object) this.f13317c);
            }
            jSONObject.putOpt("n", this.f13323i);
            jSONObject.put("v", (Object) this.f13318d);
            jSONObject.put("p", this.f13319e);
            jSONObject.put(c.f41585a, (Object) this.f13320f);
            jSONObject.put("isViewGroup", this.f13321g.f13599k);
            jSONObject.put(Constants.ENABLE_DISABLE, this.f13321g.f13594f);
            jSONObject.put("isClickable", this.f13321g.f13593e);
            jSONObject.put("hasOnClickListeners", this.f13321g.f13601m);
            jSONObject.put("isScrollable", this.f13321g.a());
            jSONObject.put("isScrollContainer", this.f13321g.f13600l);
            jSONObject.put("detectorType", (Object) this.f13324j);
            jSONObject.put("parentClasses", (Object) this.f13325k);
            jSONObject.put("parentClassesCount", this.f13325k.length());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
