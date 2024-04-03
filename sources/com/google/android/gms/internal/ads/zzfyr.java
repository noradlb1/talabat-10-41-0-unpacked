package com.google.android.gms.internal.ads;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public final class zzfyr<P> {
    private final ConcurrentMap<zzfyq, List<zzfyo<P>>> zza = new ConcurrentHashMap();
    private zzfyo<P> zzb;
    private final Class<P> zzc;

    private zzfyr(Class<P> cls) {
        this.zzc = cls;
    }

    public static <P> zzfyr<P> zzc(Class<P> cls) {
        return new zzfyr<>(cls);
    }

    public final zzfyo<P> zza(P p11, zzgfp zzgfp) throws GeneralSecurityException {
        byte[] bArr;
        if (zzgfp.zzf() == 3) {
            int zzg = zzgfp.zzg() - 2;
            if (zzg != 1) {
                if (zzg != 2) {
                    if (zzg == 3) {
                        bArr = zzfxw.zza;
                    } else if (zzg != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgfp.zza()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgfp.zza()).array();
            }
            zzfyo zzfyo = new zzfyo(p11, bArr, zzgfp.zzf(), zzgfp.zzg(), zzgfp.zza());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzfyo);
            zzfyq zzfyq = new zzfyq(zzfyo.zzb(), (zzfyp) null);
            List put = this.zza.put(zzfyq, Collections.unmodifiableList(arrayList));
            if (put != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(put);
                arrayList2.add(zzfyo);
                this.zza.put(zzfyq, Collections.unmodifiableList(arrayList2));
            }
            return zzfyo;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final zzfyo<P> zzb() {
        return this.zzb;
    }

    public final Class<P> zzd() {
        return this.zzc;
    }

    public final void zze(zzfyo<P> zzfyo) {
        if (zzfyo.zzc() == 3) {
            List list = this.zza.get(new zzfyq(zzfyo.zzb(), (zzfyp) null));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzb = zzfyo;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        throw new IllegalArgumentException("the primary entry has to be ENABLED");
    }
}
