package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "", "areCompatible", "", "slotId", "reusableSlotId", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "SlotIdsSet", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SubcomposeSlotReusePolicy {

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\b\u0000\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\b\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0003J\u0019\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0001J\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\u0018\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0016\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u001c\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0016\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "", "", "set", "", "(Ljava/util/Set;)V", "size", "", "getSize", "()I", "add", "", "slotId", "add$ui_release", "clear", "", "contains", "element", "containsAll", "elements", "isEmpty", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "slotIds", "retainAll", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SlotIdsSet implements Collection<Object>, KMappedMarker, j$.util.Collection {
        public static final int $stable = 8;
        @NotNull
        private final Set<Object> set;

        public SlotIdsSet() {
            this((Set) null, 1, (DefaultConstructorMarker) null);
        }

        public SlotIdsSet(@NotNull Set<Object> set2) {
            Intrinsics.checkNotNullParameter(set2, "set");
            this.set = set2;
        }

        /* renamed from: add$ui_release */
        public final boolean add(@Nullable Object obj) {
            return this.set.add(obj);
        }

        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void clear() {
            this.set.clear();
        }

        public boolean contains(@Nullable Object obj) {
            return this.set.contains(obj);
        }

        public boolean containsAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.set.containsAll(collection);
        }

        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        public int getSize() {
            return this.set.size();
        }

        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @NotNull
        public Iterator<Object> iterator() {
            return this.set.iterator();
        }

        public final boolean remove(@Nullable Object obj) {
            return this.set.remove(obj);
        }

        public final boolean removeAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "slotIds");
            return this.set.remove(collection);
        }

        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf((Predicate<? super Object>) Predicate.VivifiedWrapper.convert(predicate));
        }

        public final boolean retainAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "slotIds");
            return this.set.retainAll(collection);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public final boolean removeAll(@NotNull Function1<Object, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return CollectionsKt__MutableCollectionsKt.removeAll(this.set, function1);
        }

        public final boolean retainAll(@NotNull Function1<Object, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return CollectionsKt__MutableCollectionsKt.retainAll(this.set, function1);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SlotIdsSet(Set set2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new LinkedHashSet() : set2);
        }
    }

    boolean areCompatible(@Nullable Object obj, @Nullable Object obj2);

    void getSlotsToRetain(@NotNull SlotIdsSet slotIdsSet);
}
