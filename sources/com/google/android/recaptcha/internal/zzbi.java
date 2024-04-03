package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzbi {
    @NotNull
    private final Map zza;
    @NotNull
    private final Set zzb = new LinkedHashSet();
    @NotNull
    private final Map zzc;

    public zzbi() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zza = linkedHashMap;
        this.zzc = linkedHashMap;
    }

    private final List zzi(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zza((zznl) it.next()));
        }
        return arrayList;
    }

    @Nullable
    public final Object zza(@NotNull zznl zznl) throws zzs {
        int zzN = zznl.zzN();
        int i11 = zzN - 1;
        if (zzN != 0) {
            switch (i11) {
                case 0:
                    return this.zza.get(Integer.valueOf(zznl.zzi()));
                case 1:
                    return Boolean.valueOf(zznl.zzL());
                case 2:
                    byte[] zzo = zznl.zzH().zzo();
                    if (zzo.length == 1) {
                        return Byte.valueOf(zzo[0]);
                    }
                    throw new zzs(4, 6, (Throwable) null);
                case 3:
                    String zzJ = zznl.zzJ();
                    if (zzJ.length() == 1) {
                        return Character.valueOf(zzJ.charAt(0));
                    }
                    throw new zzs(4, 6, (Throwable) null);
                case 4:
                    int zzj = zznl.zzj();
                    if (zzj >= -32768 && zzj <= 32767) {
                        return Short.valueOf((short) zzj);
                    }
                    throw new zzs(4, 6, (Throwable) null);
                case 5:
                    return Integer.valueOf(zznl.zzk());
                case 6:
                case 8:
                    throw new zzs(4, 6, (Throwable) null);
                case 7:
                    return Long.valueOf(zznl.zzG());
                case 9:
                    return Float.valueOf(zznl.zzg());
                case 10:
                    return Double.valueOf(zznl.zzf());
                case 11:
                    return zznl.zzK();
                case 12:
                    return null;
                default:
                    throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw null;
        }
    }

    @Nullable
    public final Object zzb(int i11) {
        return this.zza.remove(Integer.valueOf(i11));
    }

    @NotNull
    public final Map zzc() {
        return this.zzc;
    }

    public final void zzd() {
        this.zza.clear();
    }

    public final void zze(int i11, @Nullable Object obj) {
        zzf(Opcodes.LRETURN, obj);
        this.zzb.add(Integer.valueOf(Opcodes.LRETURN));
    }

    public final void zzf(int i11, @Nullable Object obj) {
        this.zza.put(Integer.valueOf(i11), obj);
    }

    @NotNull
    public final Class[] zzg(@NotNull List list) {
        List<Object> zzi = zzi(list);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zzi, 10));
        for (Object zza2 : zzi) {
            arrayList.add(zzbg.zza(zza2));
        }
        return (Class[]) arrayList.toArray(new Class[0]);
    }

    @NotNull
    public final Object[] zzh(@NotNull List list) {
        return zzi(list).toArray(new Object[0]);
    }
}
