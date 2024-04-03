package com.uxcam.internals;

import androidx.annotation.NonNull;
import com.uxcam.internals.gu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ca {

    /* renamed from: a  reason: collision with root package name */
    public final List f13101a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List f13102b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f13103c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f13104d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f13105e;

    /* renamed from: f  reason: collision with root package name */
    public int f13106f;

    /* renamed from: g  reason: collision with root package name */
    public int f13107g;

    public ca(@NonNull List list, JSONArray jSONArray, boolean z11, int i11, int i12) {
        this.f13105e = z11;
        this.f13106f = i11;
        this.f13107g = i12;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            be beVar = (be) it.next();
            gu.ab a11 = gu.a("filter11");
            beVar.b();
            beVar.a();
            a11.getClass();
            if (beVar.a() == 1) {
                this.f13101a.add(beVar);
            } else if (beVar.a() == 2) {
                this.f13102b.add(beVar);
            }
        }
        int i13 = 0;
        while (i13 < jSONArray.length()) {
            try {
                this.f13103c.add(jSONArray.getJSONObject(i13));
                i13++;
            } catch (JSONException e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    public boolean a() {
        if (this.f13101a.isEmpty()) {
            return true;
        }
        Iterator it = this.f13103c.iterator();
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase("screen")) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if (string.equalsIgnoreCase("is")) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        if (a(jSONArray.getString(i11), this.f13101a)) {
                            return true;
                        }
                    }
                    return false;
                } else if (string.equalsIgnoreCase("isNot")) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= jSONArray.length()) {
                            break;
                        } else if (!b(jSONArray.getString(i12), this.f13101a)) {
                            z11 = true;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    return !z11;
                } else {
                    z12 = true;
                }
            }
        }
        if (!z12) {
            return true;
        }
        return false;
    }

    public boolean b(String str, List list) {
        Iterator it = list.iterator();
        boolean z11 = true;
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(((be) it.next()).b())) {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean c() {
        Iterator it = this.f13103c.iterator();
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase("event")) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if (string.equalsIgnoreCase("is")) {
                    if (this.f13102b.isEmpty()) {
                        return false;
                    }
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        if (a(jSONArray.getString(i11), this.f13102b)) {
                            return true;
                        }
                    }
                    return false;
                } else if (string.equalsIgnoreCase("isNot")) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= jSONArray.length()) {
                            break;
                        } else if (!b(jSONArray.getString(i12), this.f13102b)) {
                            z11 = true;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    return !z11;
                } else {
                    z12 = true;
                }
            }
        }
        if (!z12) {
            return true;
        }
        return false;
    }

    public boolean d() {
        boolean z11 = true;
        try {
            if (!a("noOfInteraction", this.f13107g)) {
                this.f13104d.add(1);
                gu.a("filter11").getClass();
                z11 = false;
            }
            if (!a("duration", this.f13106f)) {
                this.f13104d.add(2);
                gu.a("filter11").getClass();
                z11 = false;
            }
            if (!b()) {
                this.f13104d.add(3);
                gu.a("filter11").getClass();
                z11 = false;
            }
            if (!c()) {
                this.f13104d.add(4);
                gu.a("filter11").getClass();
                z11 = false;
            }
            if (!a()) {
                this.f13104d.add(5);
                gu.a("filter11").getClass();
                return false;
            }
            gu.a("filter11").getClass();
            return z11;
        } catch (JSONException unused) {
            return true;
        }
    }

    public boolean b() {
        Iterator it = this.f13103c.iterator();
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                return true;
            }
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase("isCrashed")) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if ((!string.equalsIgnoreCase("is") || this.f13105e != jSONArray.getBoolean(0)) && (!string.equalsIgnoreCase("isNot") || this.f13105e != jSONArray.getBoolean(0))) {
                    z11 = false;
                }
                if (!z11) {
                    return false;
                }
            }
        }
    }

    public boolean a(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(((be) it.next()).b())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(String str, int i11) {
        Iterator it = this.f13103c.iterator();
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                return true;
            }
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase(str)) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if ((!string.equalsIgnoreCase("is") || i11 != jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("isNot") || i11 == jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("gt") || i11 <= jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("gteq") || i11 < jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("lt") || i11 >= jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("lteq") || i11 > jSONArray.getInt(0)) && (!string.equalsIgnoreCase("gt&lt") || i11 <= jSONArray.getInt(0) || i11 >= jSONArray.getInt(1)))))))) {
                    z11 = false;
                }
                if (!z11) {
                    return false;
                }
            }
        }
    }
}
