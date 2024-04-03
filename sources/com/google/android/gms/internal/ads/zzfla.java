package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;

public final class zzfla implements zzfky {
    private final zzfky zza;

    public zzfla(zzfky zzfky) {
        this.zza = zzfky;
    }

    public final JSONObject zza(View view) {
        throw null;
    }

    public final void zzb(View view, JSONObject jSONObject, zzfkx zzfkx, boolean z11) {
        ArrayList arrayList = new ArrayList();
        zzfkp zza2 = zzfkp.zza();
        if (zza2 != null) {
            Collection<zzfke> zzb = zza2.zzb();
            int size = zzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            for (zzfke zzf : zzb) {
                View zzf2 = zzf.zzf();
                if (zzf2 != null && zzf2.isAttachedToWindow() && zzf2.isShown()) {
                    View view2 = zzf2;
                    while (true) {
                        if (view2 != null) {
                            if (view2.getAlpha() == 0.0f) {
                                break;
                            }
                            ViewParent parent = view2.getParent();
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            } else {
                                view2 = null;
                            }
                        } else {
                            View rootView = zzf2.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float zza3 = zzflj.zza(rootView);
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i11 = size2 - 1;
                                    if (zzflj.zza((View) arrayList.get(i11)) <= zza3) {
                                        break;
                                    }
                                    size2 = i11;
                                }
                                arrayList.add(size2, rootView);
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i12 = 0; i12 < size3; i12++) {
            zzfkx.zza((View) arrayList.get(i12), this.zza, jSONObject);
        }
    }
}
