package com.google.android.libraries.places.internal;

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

public abstract class zzgg<K, V> implements Map<K, V>, Serializable, j$.util.Map {
    @CheckForNull
    private transient zzgh<Map.Entry<K, V>> zza;
    @CheckForNull
    private transient zzgh<K> zzb;
    @CheckForNull
    private transient zzgb<V> zzc;

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
    public abstract V get(@CheckForNull Object obj);

    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    public final int hashCode() {
        return zzgx.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzgh<K> zzgh = this.zzb;
        if (zzgh != null) {
            return zzgh;
        }
        zzgh<K> zzd = zzd();
        this.zzb = zzd;
        return zzd;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @CheckForNull
    @Deprecated
    public final V put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(java.util.Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
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
        StringBuilder sb3 = new StringBuilder(44);
        sb3.append("size cannot be negative but was: ");
        sb3.append(size);
        throw new IllegalArgumentException(sb3.toString());
    }

    public abstract zzgb<V> zza();

    /* renamed from: zzb */
    public final zzgb<V> values() {
        zzgb<V> zzgb = this.zzc;
        if (zzgb != null) {
            return zzgb;
        }
        zzgb<V> zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzgh<Map.Entry<K, V>> zzc();

    public abstract zzgh<K> zzd();

    /* renamed from: zze */
    public final zzgh<Map.Entry<K, V>> entrySet() {
        zzgh<Map.Entry<K, V>> zzgh = this.zza;
        if (zzgh != null) {
            return zzgh;
        }
        zzgh<Map.Entry<K, V>> zzc2 = zzc();
        this.zza = zzc2;
        return zzc2;
    }
}
