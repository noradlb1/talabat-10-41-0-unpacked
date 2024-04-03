package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap  reason: invalid package */
public abstract class zzap implements Map, Serializable, j$.util.Map {
    @CheckForNull
    private transient zzaq zza;
    @CheckForNull
    private transient zzaq zzb;
    @CheckForNull
    private transient zzai zzc;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.p002firebaseauthapi.zzap zzc(java.lang.Iterable r2) {
        /*
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0009
            int r0 = r2.size()
            goto L_0x000a
        L_0x0009:
            r0 = 4
        L_0x000a:
            com.google.android.gms.internal.firebase-auth-api.zzao r1 = new com.google.android.gms.internal.firebase-auth-api.zzao
            r1.<init>(r0)
            r1.zza(r2)
            com.google.android.gms.internal.firebase-auth-api.zzan r2 = r1.zzc
            if (r2 != 0) goto L_0x0028
            int r2 = r1.zzb
            java.lang.Object[] r0 = r1.zza
            com.google.android.gms.internal.firebase-auth-api.zzax r2 = com.google.android.gms.internal.p002firebaseauthapi.zzax.zzg(r2, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzan r0 = r1.zzc
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.IllegalArgumentException r2 = r0.zza()
            throw r2
        L_0x0028:
            java.lang.IllegalArgumentException r2 = r2.zza()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzap.zzc(java.lang.Iterable):com.google.android.gms.internal.firebase-auth-api.zzap");
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        return entrySet().equals(((java.util.Map) obj).entrySet());
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzay.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaq zzaq = this.zzb;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq zze = zze();
        this.zzb = zze;
        return zze;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            boolean z11 = true;
            for (Map.Entry entry : entrySet()) {
                if (!z11) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(entry.getKey());
                sb2.append(SignatureVisitor.INSTANCEOF);
                sb2.append(entry.getValue());
                z11 = false;
            }
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            return sb2.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    public abstract zzai zza();

    /* renamed from: zzb */
    public final zzai values() {
        zzai zzai = this.zzc;
        if (zzai != null) {
            return zzai;
        }
        zzai zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzaq zzd();

    public abstract zzaq zze();

    /* renamed from: zzf */
    public final zzaq entrySet() {
        zzaq zzaq = this.zza;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
