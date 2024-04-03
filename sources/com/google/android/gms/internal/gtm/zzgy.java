package com.google.android.gms.internal.gtm;

import com.tekartik.sqflite.Constant;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class zzgy extends zzhb {

    /* renamed from: name  reason: collision with root package name */
    private final String f35098name;
    private zzfl zzape = null;
    private final List<String> zzarg;
    private final List<zzol> zzarh;

    public zzgy(zzfl zzfl, String str, List<String> list, List<zzol> list2) {
        this.f35098name = str;
        this.zzarg = list;
        this.zzarh = list2;
    }

    public final String getName() {
        return this.f35098name;
    }

    public final String toString() {
        String str = this.f35098name;
        String obj = this.zzarg.toString();
        String obj2 = this.zzarh.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(obj).length() + String.valueOf(obj2).length());
        sb2.append(str);
        sb2.append("\n\tparams: ");
        sb2.append(obj);
        sb2.append("\n\t: statements: ");
        sb2.append(obj2);
        return sb2.toString();
    }

    public final void zza(zzfl zzfl) {
        this.zzape = zzfl;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        try {
            zzfl zzku = this.zzape.zzku();
            for (int i11 = 0; i11 < this.zzarg.size(); i11++) {
                if (zzoaArr.length > i11) {
                    zzku.zza(this.zzarg.get(i11), zzoaArr[i11]);
                } else {
                    zzku.zza(this.zzarg.get(i11), zzog.zzaum);
                }
            }
            zzku.zza(Constant.PARAM_SQL_ARGUMENTS, new zzoh(Arrays.asList(zzoaArr)));
            for (zzol zza : this.zzarh) {
                zzoa zza2 = zzoo.zza(zzku, zza);
                if ((zza2 instanceof zzog) && ((zzog) zza2).zzmh()) {
                    return (zzoa) ((zzog) zza2).value();
                }
            }
        } catch (RuntimeException e11) {
            String str = this.f35098name;
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(message).length());
            sb2.append("Internal error - Function call: ");
            sb2.append(str);
            sb2.append(StringUtils.LF);
            sb2.append(message);
            zzev.zzav(sb2.toString());
        }
        return zzog.zzaum;
    }
}
