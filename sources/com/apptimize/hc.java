package com.apptimize;

import android.app.Activity;
import android.view.View;
import com.apptimize.gy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class hc implements he {

    /* renamed from: b  reason: collision with root package name */
    private static final String f42909b = "hc";

    /* renamed from: a  reason: collision with root package name */
    public final hf f42910a;

    /* renamed from: c  reason: collision with root package name */
    private jp f42911c;

    /* renamed from: d  reason: collision with root package name */
    private db f42912d;

    private hc(db dbVar, View view, jp jpVar, hg hgVar) {
        hgVar.b().b();
        this.f42912d = dbVar;
        this.f42911c = b(jpVar);
        hf a11 = hgVar.a(view, (he) this, (Integer) null);
        this.f42910a = a11;
        a11.d();
    }

    public static hc a(Activity activity, jp jpVar, hg hgVar) {
        return new hc(da.a("activityClass", activity.getClass(), (Class<?>) null), js.a(activity), jpVar, hgVar);
    }

    private jp b(jp jpVar) {
        return jpVar.a(b(), (bf) new jo());
    }

    public JSONObject e() throws JSONException {
        return a();
    }

    public jp g() {
        return this.f42911c;
    }

    public List<db> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b());
        return arrayList;
    }

    private db b() {
        return this.f42912d;
    }

    public static hc a(gy.a aVar, Activity activity, View view, jp jpVar, hg hgVar) {
        return new hc(da.a("popupClass", aVar.a().getClass(), activity.getClass()), view, jpVar, hgVar);
    }

    public static hc a(Object obj, View view, Integer num, jp jpVar, hg hgVar) {
        hc hcVar = new hc(da.a("fragmentClass", obj.getClass(), (Class<?>) null, num), view, jpVar, hgVar);
        hcVar.f42910a.c();
        return hcVar;
    }

    public void a(Set<he> set) {
        set.add(this.f42910a);
        this.f42910a.a(set);
    }

    private JSONObject a() throws JSONException {
        return this.f42910a.e();
    }

    public void a(db dbVar, jp jpVar) {
        this.f42912d = dbVar;
        a(jpVar);
    }

    public void a(boolean z11, Set<he> set) {
        this.f42910a.a(true, set);
    }

    public void a(jp jpVar) {
        this.f42911c = b(jpVar);
        this.f42910a.d();
    }
}
