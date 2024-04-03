package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzbf extends zzbc {
    @NotNull
    private final zzbe zza;
    @NotNull
    private final String zzb;

    public zzbf(@NotNull zzbe zzbe, @NotNull String str, @Nullable Object obj) {
        super(obj);
        this.zza = zzbe;
        this.zzb = str;
    }

    public final boolean zza(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
        List list;
        if (!Intrinsics.areEqual((Object) method.getName(), (Object) this.zzb)) {
            return false;
        }
        zzbe zzbe = this.zza;
        if (objArr == null || (list = ArraysKt___ArraysJvmKt.asList((T[]) objArr)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        zzbe.zzb(list);
        return true;
    }
}
