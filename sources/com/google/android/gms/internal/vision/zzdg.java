package com.google.android.gms.internal.vision;

import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzdg<K, V> implements Serializable, Map<K, V>, j$.util.Map {
    private static final Map.Entry<?, ?>[] zzlo = new Map.Entry[0];
    private transient zzdj<Map.Entry<K, V>> zzlp;
    private transient zzdj<K> zzlq;
    private transient zzdc<V> zzlr;

    public static <K, V> zzdg<K, V> zza(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        zzda.zza(k11, v11);
        zzda.zza(k12, v12);
        zzda.zza(k13, v13);
        zzda.zza(k14, v14);
        return zzdl.zza(4, new Object[]{k11, v11, k12, v12, k13, v13, k14, v14});
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

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdc) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzdj<Map.Entry<K, V>> zzdj = this.zzlp;
        if (zzdj != null) {
            return zzdj;
        }
        zzdj<Map.Entry<K, V>> zzce = zzce();
        this.zzlp = zzce;
        return zzce;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof java.util.Map) {
            return entrySet().equals(((java.util.Map) obj).entrySet());
        }
        return false;
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    public int hashCode() {
        return zzdo.zza((zzdj) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzdj<K> zzdj = this.zzlq;
        if (zzdj != null) {
            return zzdj;
        }
        zzdj<K> zzcf = zzcf();
        this.zzlq = zzcf;
        return zzcf;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

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

    @Deprecated
    public final V remove(Object obj) {
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

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
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
        StringBuilder sb3 = new StringBuilder(BindingAdaptersKt.QUERY_SIZE.length() + 40);
        sb3.append(BindingAdaptersKt.QUERY_SIZE);
        sb3.append(" cannot be negative but was: ");
        sb3.append(size);
        throw new IllegalArgumentException(sb3.toString());
    }

    public /* synthetic */ Collection values() {
        zzdc<V> zzdc = this.zzlr;
        if (zzdc != null) {
            return zzdc;
        }
        zzdc<V> zzcg = zzcg();
        this.zzlr = zzcg;
        return zzcg;
    }

    public abstract zzdj<Map.Entry<K, V>> zzce();

    public abstract zzdj<K> zzcf();

    public abstract zzdc<V> zzcg();
}
