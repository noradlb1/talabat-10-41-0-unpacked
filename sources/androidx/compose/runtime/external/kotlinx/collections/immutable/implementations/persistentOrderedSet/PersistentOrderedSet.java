package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0002J\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\"\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0%H\u0016J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "firstElement", "", "lastElement", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstElement$runtime_release", "()Ljava/lang/Object;", "getHashMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "getLastElement$runtime_release", "size", "", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "clear", "contains", "", "(Ljava/lang/Object;)Z", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PersistentOrderedSet<E> extends AbstractSet<E> implements PersistentSet<E> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final PersistentOrderedSet EMPTY;
    @Nullable
    private final Object firstElement;
    @NotNull
    private final PersistentHashMap<E, Links> hashMap;
    @Nullable
    private final Object lastElement;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\bH\u0000¢\u0006\u0002\b\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "", "emptyOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "emptyOf$runtime_release", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <E> PersistentSet<E> emptyOf$runtime_release() {
            return PersistentOrderedSet.EMPTY;
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        EMPTY = new PersistentOrderedSet(endOfChain, endOfChain, PersistentHashMap.Companion.emptyOf$runtime_release());
    }

    public PersistentOrderedSet(@Nullable Object obj, @Nullable Object obj2, @NotNull PersistentHashMap<E, Links> persistentHashMap) {
        Intrinsics.checkNotNullParameter(persistentHashMap, "hashMap");
        this.firstElement = obj;
        this.lastElement = obj2;
        this.hashMap = persistentHashMap;
    }

    public boolean contains(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Nullable
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    @NotNull
    public final PersistentHashMap<E, Links> getHashMap$runtime_release() {
        return this.hashMap;
    }

    @Nullable
    public final Object getLastElement$runtime_release() {
        return this.lastElement;
    }

    public int getSize() {
        return this.hashMap.size();
    }

    @NotNull
    public Iterator<E> iterator() {
        return new PersistentOrderedSetIterator(this.firstElement, this.hashMap);
    }

    @NotNull
    public PersistentSet<E> add(E e11) {
        if (this.hashMap.containsKey(e11)) {
            return this;
        }
        if (isEmpty()) {
            return new PersistentOrderedSet(e11, e11, this.hashMap.put((Object) e11, (Object) new Links()));
        }
        Object obj = this.lastElement;
        Links links = this.hashMap.get(obj);
        Intrinsics.checkNotNull(links);
        return new PersistentOrderedSet(this.firstElement, e11, this.hashMap.put(obj, (Object) links.withNext(e11)).put((Object) e11, (Object) new Links(obj)));
    }

    @NotNull
    public PersistentSet<E> addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet.Builder<E> builder() {
        return new PersistentOrderedSetBuilder(this);
    }

    @NotNull
    public PersistentSet<E> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @NotNull
    public PersistentSet<E> remove(E e11) {
        Links links = this.hashMap.get(e11);
        if (links == null) {
            return this;
        }
        PersistentHashMap remove = this.hashMap.remove((Object) e11);
        if (links.getHasPrevious()) {
            Object obj = remove.get(links.getPrevious());
            Intrinsics.checkNotNull(obj);
            remove = remove.put(links.getPrevious(), (Object) ((Links) obj).withNext(links.getNext()));
        }
        if (links.getHasNext()) {
            Object obj2 = remove.get(links.getNext());
            Intrinsics.checkNotNull(obj2);
            remove = remove.put(links.getNext(), (Object) ((Links) obj2).withPrevious(links.getPrevious()));
        }
        return new PersistentOrderedSet(!links.getHasPrevious() ? links.getNext() : this.firstElement, !links.getHasNext() ? links.getPrevious() : this.lastElement, remove);
    }

    @NotNull
    public PersistentSet<E> retainAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet.Builder builder = builder();
        builder.retainAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet<E> removeAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet.Builder builder = builder();
        builder.removeAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet<E> removeAll(@NotNull Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        PersistentSet.Builder builder = builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(builder, function1);
        return builder.build();
    }
}
