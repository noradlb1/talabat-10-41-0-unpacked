package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0003J\u0017\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0003J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\t\u0010\u0019\u001a\u00020\rH\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0003J\u0011\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0001J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u0016\u001a\u00020\tH\u0001J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontListFontFamily extends FileBasedFontFamily implements List<Font>, KMappedMarker, j$.util.List {
    private final /* synthetic */ List<Font> $$delegate_0;
    @NotNull
    private final List<Font> fonts;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontListFontFamily(@NotNull List<? extends Font> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "fonts");
        this.$$delegate_0 = list;
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.fonts = new ArrayList(collection);
            return;
        }
        throw new IllegalStateException("At least one font should be passed to FontFamily".toString());
    }

    public void add(int i11, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "element");
        return this.$$delegate_0.contains(font);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Font)) {
            return false;
        }
        return contains((Font) obj);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.$$delegate_0.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FontListFontFamily) && Intrinsics.areEqual((Object) this.fonts, (Object) ((FontListFontFamily) obj).fonts)) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @NotNull
    public Font get(int i11) {
        return this.$$delegate_0.get(i11);
    }

    @NotNull
    public final List<Font> getFonts() {
        return this.fonts;
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int hashCode() {
        return this.fonts.hashCode();
    }

    public int indexOf(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "element");
        return this.$$delegate_0.indexOf(font);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        return indexOf((Font) obj);
    }

    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @NotNull
    public Iterator<Font> iterator() {
        return this.$$delegate_0.iterator();
    }

    public int lastIndexOf(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "element");
        return this.$$delegate_0.lastIndexOf(font);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        return lastIndexOf((Font) obj);
    }

    @NotNull
    public ListIterator<Font> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    @NotNull
    public ListIterator<Font> listIterator(int i11) {
        return this.$$delegate_0.listIterator(i11);
    }

    public Font remove(int i11) {
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

    public void replaceAll(UnaryOperator<Font> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
        replaceAll((UnaryOperator<Font>) UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font set(int i11, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public void sort(Comparator<? super Font> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public List<Font> subList(int i11, int i12) {
        return this.$$delegate_0.subList(i11, i12);
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
        return "FontListFontFamily(fonts=" + this.fonts + ')';
    }
}
