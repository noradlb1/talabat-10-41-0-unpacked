package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzanq extends zzaoa {
    private List<Long> zzi = null;

    public zzanq(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "Zsy6wzxKzkvuI5Zg91hlK7lftgUdlMXbkLzI72tnQVNXNUFbyYhuDjwGRJi5QzOf", "/h10yfi8gz82TQ6rp82eUm/z42AeNO79/O3Nlfr8yws=", zzaiz, i11, 31);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzR(-1);
        this.zze.zzN(-1);
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        }
        List<Long> list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzR(this.zzi.get(0).longValue());
                this.zze.zzN(this.zzi.get(1).longValue());
            }
        }
    }
}
