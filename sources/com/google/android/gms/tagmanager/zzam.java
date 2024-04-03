package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
final class zzam extends zzbq {
    private static final String ID = zza.FUNCTION_CALL.toString();
    private static final String zzadw = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzafl = zzb.FUNCTION_CALL_NAME.toString();
    private final zzan zzafm;

    public zzam(zzan zzan) {
        super(ID, zzafl);
        this.zzafm = zzan;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String zzc = zzgj.zzc(map.get(zzafl));
        HashMap hashMap = new HashMap();
        zzl zzl = map.get(zzadw);
        if (zzl != null) {
            Object zzh = zzgj.zzh(zzl);
            if (!(zzh instanceof Map)) {
                zzdi.zzac("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzgj.zzkc();
            }
            for (Map.Entry entry : ((Map) zzh).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzgj.zzi(this.zzafm.zza(zzc, hashMap));
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzc).length() + 34 + String.valueOf(message).length());
            sb2.append("Custom macro/tag ");
            sb2.append(zzc);
            sb2.append(" threw exception ");
            sb2.append(message);
            zzdi.zzac(sb2.toString());
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return false;
    }
}
