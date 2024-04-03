package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzio extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzom);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        String str = (String) zzoaArr[1].value();
        List list = (List) zzoaArr[2].value();
        if (zzoa.zzcn(str)) {
            zzoa<?> zzco = zzoa.zzco(str);
            if (zzco instanceof zzof) {
                return ((zzgz) ((zzof) zzco).value()).zzb(zzfl, (zzoa[]) list.toArray(new zzoa[list.size()]));
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35);
            sb2.append("Apply TypeError: ");
            sb2.append(str);
            sb2.append(" is not a function");
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzoa.zzcp(str)) {
            zzgz zzcq = zzoa.zzcq(str);
            list.add(0, zzoa);
            return zzcq.zzb(zzfl, (zzoa[]) list.toArray(new zzoa[list.size()]));
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 40);
            sb3.append("Apply TypeError: object has no ");
            sb3.append(str);
            sb3.append(" property");
            throw new IllegalArgumentException(sb3.toString());
        }
    }
}
