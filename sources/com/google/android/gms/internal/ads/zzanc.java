package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzanc extends zzaoa {
    private static final zzaob<String> zzi = new zzaob<>();
    private final Context zzj;

    public zzanc(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, Context context) {
        super(zzams, "t7YLiNn9wSLVfNzBPSP796qGY15c9YWt19X86sjfqa1MN8DTMOAxKskDGE2b7plQ", "lEEnhl5euaIfSg9vXz1JH43pBH/xGM9fvSrfPaUZwEI=", zzaiz, i11, 29);
        this.zzj = context;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzl(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zza = zzi.zza(this.zzj.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zzf.invoke((Object) null, new Object[]{this.zzj}));
                }
            }
        }
        String str = zza.get();
        synchronized (this.zze) {
            this.zze.zzl(zzake.zza(str.getBytes(), true));
        }
    }
}
