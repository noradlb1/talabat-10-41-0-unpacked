package kotlinx.serialization.json;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001!B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0003J\u0017\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0001J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0011\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0006H\u0003J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0001J\t\u0010\u0016\u001a\u00020\nH\u0001J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0003J\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0001J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0001J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0001J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable(with = JsonArraySerializer.class)
public final class JsonArray extends JsonElement implements List<JsonElement>, KMappedMarker, j$.util.List {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final List<JsonElement> content;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<JsonArray> serializer() {
            return JsonArraySerializer.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonArray(@NotNull List<? extends JsonElement> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "content");
        this.content = list;
    }

    public /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int i11, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        return contains((JsonElement) obj);
    }

    public boolean contains(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.contains(jsonElement);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.content.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        return Intrinsics.areEqual((Object) this.content, obj);
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @NotNull
    public JsonElement get(int i11) {
        return this.content.get(i11);
    }

    public int getSize() {
        return this.content.size();
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return indexOf((JsonElement) obj);
    }

    public int indexOf(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.indexOf(jsonElement);
    }

    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @NotNull
    public Iterator<JsonElement> iterator() {
        return this.content.iterator();
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return lastIndexOf((JsonElement) obj);
    }

    public int lastIndexOf(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.lastIndexOf(jsonElement);
    }

    @NotNull
    public ListIterator<JsonElement> listIterator() {
        return this.content.listIterator();
    }

    @NotNull
    public ListIterator<JsonElement> listIterator(int i11) {
        return this.content.listIterator(i11);
    }

    public JsonElement remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    public void replaceAll(UnaryOperator<JsonElement> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
        replaceAll((UnaryOperator<JsonElement>) UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement set(int i11, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public void sort(Comparator<? super JsonElement> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public List<JsonElement> subList(int i11, int i12) {
        return this.content.subList(i11, i12);
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

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.content, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
