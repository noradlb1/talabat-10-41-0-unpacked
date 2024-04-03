package com.google.android.recaptcha.internal;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

public final class zzbs implements zzca {
    @NotNull
    public static final zzbs zza = new zzbs();

    private zzbs() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        String str;
        String str2;
        zznl[] zznlArr2 = zznlArr;
        if (zznlArr2.length == 1) {
            Object zza2 = zzbh.zze().zza(zznlArr2[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof int[]) {
                    str = ArraysKt___ArraysKt.joinToString$default((int[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else {
                    if (zza2 instanceof byte[]) {
                        str2 = new String((byte[]) zza2, Charsets.UTF_8);
                    } else if (zza2 instanceof long[]) {
                        str = ArraysKt___ArraysKt.joinToString$default((long[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof short[]) {
                        str = ArraysKt___ArraysKt.joinToString$default((short[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof float[]) {
                        str = ArraysKt___ArraysKt.joinToString$default((float[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof double[]) {
                        str = ArraysKt___ArraysKt.joinToString$default((double[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof char[]) {
                        str2 = new String((char[]) zza2);
                    } else if (zza2 instanceof Object[]) {
                        str = ArraysKt___ArraysKt.joinToString$default((Object[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof Collection) {
                        str = CollectionsKt___CollectionsKt.joinToString$default((Iterable) zza2, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else {
                        throw new zzs(4, 5, (Throwable) null);
                    }
                    str = str2;
                }
                int i12 = i11;
                zzbh.zze().zzf(i11, str);
                return;
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }
}
