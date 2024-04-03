package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@Instrumented
public final class zzblc {
    private final Collection<zzblb<?>> zza = new ArrayList();
    private final Collection<zzblb<String>> zzb = new ArrayList();
    private final Collection<zzblb<String>> zzc = new ArrayList();

    public final List<String> zza() {
        ArrayList arrayList = new ArrayList();
        for (zzblb<String> zzb2 : this.zzb) {
            String str = (String) zzbgq.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzblk.zza());
        return arrayList;
    }

    public final List<String> zzb() {
        List<String> zza2 = zza();
        for (zzblb<String> zzb2 : this.zzc) {
            String str = (String) zzbgq.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzblk.zzb());
        return zza2;
    }

    public final void zzc(zzblb<String> zzblb) {
        this.zzb.add(zzblb);
    }

    public final void zzd(zzblb zzblb) {
        this.zza.add(zzblb);
    }

    public final void zze(SharedPreferences.Editor editor, int i11, JSONObject jSONObject) {
        for (zzblb next : this.zza) {
            if (next.zze() == 1) {
                next.zzd(editor, next.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", JSONObjectInstrumentation.toString(jSONObject));
        } else {
            zzciz.zzg("Flag Json is null.");
        }
    }
}
