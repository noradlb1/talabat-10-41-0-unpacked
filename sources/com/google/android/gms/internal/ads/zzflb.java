package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

public final class zzflb implements zzfky {
    private final int[] zza = new int[2];

    public final JSONObject zza(View view) {
        if (view == null) {
            return zzflg.zza(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.zza);
        int[] iArr = this.zza;
        return zzflg.zza(iArr[0], iArr[1], width, height);
    }

    public final void zzb(View view, JSONObject jSONObject, zzfkx zzfkx, boolean z11) {
        int i11;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z11) {
                HashMap hashMap = new HashMap();
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    View childAt = viewGroup.getChildAt(i12);
                    ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                    }
                    arrayList.add(childAt);
                }
                ArrayList arrayList2 = new ArrayList(hashMap.keySet());
                Collections.sort(arrayList2);
                int size = arrayList2.size();
                int i13 = 0;
                while (i13 < size) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get((Float) arrayList2.get(i13));
                    int size2 = arrayList3.size();
                    int i14 = 0;
                    while (true) {
                        i11 = i13 + 1;
                        if (i14 >= size2) {
                            break;
                        }
                        zzfkx.zza((View) arrayList3.get(i14), this, jSONObject);
                        i14++;
                    }
                    i13 = i11;
                }
                return;
            }
            for (int i15 = 0; i15 < viewGroup.getChildCount(); i15++) {
                zzfkx.zza(viewGroup.getChildAt(i15), this, jSONObject);
            }
        }
    }
}
