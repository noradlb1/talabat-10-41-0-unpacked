package com.iab.omid.library.deliveryhero3.processor;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.deliveryhero3.processor.a;
import com.iab.omid.library.deliveryhero3.utils.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f44979a = new int[2];

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.C0050a aVar, boolean z11) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            aVar.a(viewGroup.getChildAt(i11), this, jSONObject, z11);
        }
    }

    @TargetApi(21)
    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.C0050a aVar, boolean z11) {
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.a((View) it2.next(), this, jSONObject, z11);
            }
        }
    }

    public JSONObject a(View view) {
        if (view == null) {
            return c.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f44979a);
        int[] iArr = this.f44979a;
        return c.a(iArr[0], iArr[1], width, height);
    }

    public void a(View view, JSONObject jSONObject, a.C0050a aVar, boolean z11, boolean z12) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z11) {
                b(viewGroup, jSONObject, aVar, z12);
            } else {
                a(viewGroup, jSONObject, aVar, z12);
            }
        }
    }
}
