package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

public final class zzanb extends zzaoa {
    public zzanb(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "SnrtMYC9+qStj9ZoSAj1DR6mGb7YlLFiZbsMn2F8wpevpQUtlzrwws7lBSZ1KQhS", "3Z4807bJ0KoyYYoQ9dcfmEBolGH5CdxZiQurF1neOqs=", zzaiz, i11, 49);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzV(3);
        try {
            int i11 = 1;
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzaiz zzaiz = this.zze;
            if (true == booleanValue) {
                i11 = 2;
            }
            zzaiz.zzV(i11);
        } catch (InvocationTargetException e11) {
            if (!(e11.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e11;
            }
        }
    }
}
