package com.instabug.bug.view.extrafields;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.bug.extendedbugreport.a;
import com.instabug.bug.model.e;
import com.instabug.bug.n;
import com.instabug.bug.settings.b;
import com.instabug.library.core.ui.BasePresenter;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
class g extends BasePresenter {
    public g(a aVar) {
        super(aVar);
    }

    private void m() {
        for (e a11 : b.f().e()) {
            a11.a((String) null);
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONArray a(@Nullable String str, List list) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", (Object) "description");
            jSONObject.put("name", (Object) "Description");
            if (str == null) {
                str = "";
            }
            jSONObject.put("value", (Object) str);
            jSONArray.put((Object) jSONObject);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", (Object) eVar.c());
                jSONObject2.put("name", (Object) eVar.d());
                jSONObject2.put("value", (Object) eVar.e() != null ? eVar.e() : "");
                jSONArray.put((Object) jSONObject2);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONArray;
    }

    public void a(List list) {
        a d11 = b.f().d();
        if (d11 == a.ENABLED_WITH_OPTIONAL_FIELDS || d11 == a.ENABLED_WITH_REQUIRED_FIELDS) {
            b(list);
        } else {
            c(list);
        }
    }

    @VisibleForTesting
    public void b(List list) {
        if (n.e().c() != null) {
            JSONArray a11 = a(n.e().c().g(), list);
            n.e().c().d(!(a11 instanceof JSONArray) ? a11.toString() : JSONArrayInstrumentation.toString(a11));
            m();
        }
    }

    @VisibleForTesting
    public void c(List list) {
        if (n.e().c() != null) {
            String g11 = n.e().c().g();
            StringBuilder sb2 = new StringBuilder();
            if (g11 != null) {
                sb2.append(g11);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (sb2.length() > 0) {
                    sb2.append(StringUtils.LF);
                }
                sb2.append(eVar.b());
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append(StringUtils.LF);
                sb2.append(eVar.e());
            }
            n.e().c().d(sb2.toString());
            m();
        }
    }

    @VisibleForTesting
    public void d(List list) {
        a aVar = (a) this.f34200f.get();
        if (aVar != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                aVar.a(i11);
            }
        }
    }

    @Nullable
    public List l() {
        if (n.e().c() == null) {
            return null;
        }
        List e11 = n.e().c().e();
        if (e11 != null) {
            return e11;
        }
        a d11 = b.f().d();
        int i11 = f.f45839a[d11.ordinal()];
        if (i11 == 1 || i11 == 2) {
            a aVar = (a) this.f34200f.get();
            if (!(aVar == null || aVar.getViewContext() == null || ((Fragment) aVar.getViewContext()).getContext() == null)) {
                e11 = com.instabug.bug.extendedbugreport.b.a(((Fragment) aVar.getViewContext()).getContext(), d11);
            }
        } else {
            e11 = b.f().e();
        }
        n.e().c().b(e11);
        return e11;
    }

    public boolean n() {
        if (n.e().c() == null) {
            return false;
        }
        List e11 = n.e().c().e();
        if (e11 != null && !e11.isEmpty()) {
            d(e11);
        }
        a aVar = (a) this.f34200f.get();
        if (aVar == null) {
            return true;
        }
        int i11 = 0;
        while (e11 != null && i11 < e11.size()) {
            e eVar = (e) e11.get(i11);
            if (eVar.f()) {
                if (eVar.e() == null) {
                    aVar.b(i11);
                    return false;
                } else if (eVar.e().trim().isEmpty()) {
                    aVar.b(i11);
                    return false;
                }
            }
            i11++;
        }
        return true;
    }
}
