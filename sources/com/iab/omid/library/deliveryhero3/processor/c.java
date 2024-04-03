package com.iab.omid.library.deliveryhero3.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.deliveryhero3.adsession.a;
import com.iab.omid.library.deliveryhero3.processor.a;
import com.iab.omid.library.deliveryhero3.utils.e;
import com.iab.omid.library.deliveryhero3.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f44978a;

    public c(a aVar) {
        this.f44978a = aVar;
    }

    @NonNull
    public ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.deliveryhero3.internal.c c11 = com.iab.omid.library.deliveryhero3.internal.c.c();
        if (c11 != null) {
            Collection<a> a11 = c11.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a11.size() * 2) + 3);
            for (a c12 : a11) {
                View c13 = c12.c();
                if (c13 != null && h.e(c13) && (rootView = c13.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float c14 = h.c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.c(arrayList.get(size - 1)) > c14) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public JSONObject a(View view) {
        JSONObject a11 = com.iab.omid.library.deliveryhero3.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.deliveryhero3.utils.c.a(a11, e.a());
        return a11;
    }

    public void a(View view, JSONObject jSONObject, a.C0050a aVar, boolean z11, boolean z12) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            aVar.a(it.next(), this.f44978a, jSONObject, z12);
        }
    }
}
