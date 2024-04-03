package com.google.android.gms.internal.vision;

import android.util.Log;

final class zzbf extends zzbe<Boolean> {
    public zzbf(zzbk zzbk, String str, Boolean bool) {
        super(zzbk, str, bool, (zzbg) null);
    }

    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzal.zzeu.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzal.zzev.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String zzac = super.zzac();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzac).length() + 28 + valueOf.length());
        sb2.append("Invalid boolean value for ");
        sb2.append(zzac);
        sb2.append(": ");
        sb2.append(valueOf);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
