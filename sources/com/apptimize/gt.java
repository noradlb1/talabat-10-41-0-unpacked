package com.apptimize;

import android.view.View;
import android.widget.AdapterView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class gt extends gu {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<AdapterView> f42816b;

    /* renamed from: c  reason: collision with root package name */
    private final hg f42817c;

    public gt(AdapterView adapterView, he heVar, Integer num, hg hgVar) {
        super(adapterView, heVar, num, hgVar);
        this.f42816b = new WeakReference<>(adapterView);
        this.f42817c = hgVar;
    }

    public List<hf> a() {
        ArrayList arrayList = new ArrayList();
        AdapterView adapterView = this.f42816b.get();
        if (adapterView == null) {
            return arrayList;
        }
        int childCount = adapterView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (this.f42817c.a(adapterView.getChildAt(i11))) {
                View childAt = adapterView.getChildAt(i11);
                arrayList.add(this.f42817c.b(childAt, this, Integer.valueOf(adapterView.getPositionForView(childAt))));
            }
        }
        return arrayList;
    }

    public JSONArray a(View view) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (view.isClickable()) {
            jSONArray.put((Object) "itemClick");
        }
        return jSONArray;
    }
}
