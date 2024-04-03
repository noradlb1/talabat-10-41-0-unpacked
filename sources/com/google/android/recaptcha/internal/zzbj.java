package com.google.android.recaptcha.internal;

import java.util.HashMap;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public final class zzbj {
    @NotNull
    private final zzbb zza;
    @NotNull
    private final zzn zzb;
    @NotNull
    private final zzbi zzc;
    private byte zzd = ((byte) RangesKt___RangesKt.random(new IntRange(1, 127), (Random) Random.Default));
    @NotNull
    private final HashMap zze;

    public zzbj(@NotNull zzbb zzbb, @NotNull zzn zzn) {
        this.zza = zzbb;
        this.zzb = zzn;
        zzbi zzbi = new zzbi();
        this.zzc = zzbi;
        HashMap hashMap = new HashMap();
        this.zze = hashMap;
        zzbi.zze(Opcodes.LRETURN, hashMap);
    }

    public final byte zza() {
        return this.zzd;
    }

    @NotNull
    public final zzn zzb() {
        return this.zzb;
    }

    @NotNull
    public final zzbb zzc() {
        return this.zza;
    }

    @NotNull
    public final zzbi zzd() {
        return this.zzc;
    }

    public final void zze() {
        this.zzc.zzd();
        this.zzc.zze(Opcodes.LRETURN, this.zze);
    }

    public final void zzf(byte b11) {
        this.zzd = b11;
    }

    public final void zzg(@NotNull int i11, @NotNull Object obj) {
        this.zze.put(Integer.valueOf(i11 - 2), obj);
    }
}
