package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.huawei.hms.flutter.map.constants.Param;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\b\u0010/\u001a\u000200H\u0016J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u001f\u00107\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001e\u00109\u001a\u0002002\u0014\u0010:\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0016J\u0017\u0010<\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J\u001b\u0010<\u001a\u0002022\u0006\u00103\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u0001¢\u0006\u0002\u0010=R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006>"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "modCount", "", "getModCount$runtime_release", "()I", "setModCount$runtime_release", "(I)V", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime_release", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "getOperationResult$runtime_release", "()Ljava/lang/Object;", "setOperationResult$runtime_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "size", "getSize", "setSize", "values", "", "getValues", "()Ljava/util/Collection;", "build", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V>, Map {
    @NotNull
    private PersistentHashMap<K, V> map;
    private int modCount;
    @NotNull
    private TrieNode<K, V> node = this.map.getNode$runtime_release();
    @Nullable
    private V operationResult;
    @NotNull
    private MutabilityOwnership ownership = new MutabilityOwnership();
    private int size = this.map.size();

    public PersistentHashMapBuilder(@NotNull PersistentHashMap<K, V> persistentHashMap) {
        Intrinsics.checkNotNullParameter(persistentHashMap, Param.MAP);
        this.map = persistentHashMap;
    }

    public void clear() {
        TrieNode<K, V> eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
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

    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Nullable
    public V get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    @NotNull
    public Set<K> getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @NotNull
    public final TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    @Nullable
    public final V getOperationResult$runtime_release() {
        return this.operationResult;
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @NotNull
    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Nullable
    public V put(K k11, V v11) {
        int i11;
        this.operationResult = null;
        TrieNode<K, V> trieNode = this.node;
        if (k11 != null) {
            i11 = k11.hashCode();
        } else {
            i11 = 0;
        }
        this.node = trieNode.mutablePut(i11, k11, v11, 0, this);
        return this.operationResult;
    }

    public void putAll(@NotNull java.util.Map<? extends K, ? extends V> map2) {
        PersistentHashMap persistentHashMap;
        PersistentHashMapBuilder persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(map2, "from");
        if (map2 instanceof PersistentHashMap) {
            persistentHashMap = (PersistentHashMap) map2;
        } else {
            persistentHashMap = null;
        }
        if (persistentHashMap == null) {
            if (map2 instanceof PersistentHashMapBuilder) {
                persistentHashMapBuilder = (PersistentHashMapBuilder) map2;
            } else {
                persistentHashMapBuilder = null;
            }
            if (persistentHashMapBuilder != null) {
                persistentHashMap = persistentHashMapBuilder.build();
            } else {
                persistentHashMap = null;
            }
        }
        if (persistentHashMap != null) {
            DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
            int size2 = size();
            TrieNode<K, V> trieNode = this.node;
            TrieNode node$runtime_release = persistentHashMap.getNode$runtime_release();
            Intrinsics.checkNotNull(node$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
            this.node = trieNode.mutablePutAll(node$runtime_release, 0, deltaCounter, this);
            int size3 = (persistentHashMap.size() + size2) - deltaCounter.getCount();
            if (size2 != size3) {
                setSize(size3);
                return;
            }
            return;
        }
        super.putAll(map2);
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Nullable
    public V remove(Object obj) {
        this.operationResult = null;
        TrieNode<K, V> mutableRemove = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (mutableRemove == null) {
            mutableRemove = TrieNode.Companion.getEMPTY$runtime_release();
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        return this.operationResult;
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

    public final void setModCount$runtime_release(int i11) {
        this.modCount = i11;
    }

    public final void setNode$runtime_release(@NotNull TrieNode<K, V> trieNode) {
        Intrinsics.checkNotNullParameter(trieNode, "<set-?>");
        this.node = trieNode;
    }

    public final void setOperationResult$runtime_release(@Nullable V v11) {
        this.operationResult = v11;
    }

    public void setSize(int i11) {
        this.size = i11;
        this.modCount++;
    }

    @NotNull
    public PersistentHashMap<K, V> build() {
        PersistentHashMap<K, V> persistentHashMap;
        if (this.node == this.map.getNode$runtime_release()) {
            persistentHashMap = this.map;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashMap = new PersistentHashMap<>(this.node, size());
        }
        this.map = persistentHashMap;
        return persistentHashMap;
    }

    public final boolean remove(Object obj, Object obj2) {
        int size2 = size();
        TrieNode<K, V> mutableRemove = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (mutableRemove == null) {
            mutableRemove = TrieNode.Companion.getEMPTY$runtime_release();
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        if (size2 != size()) {
            return true;
        }
        return false;
    }
}
