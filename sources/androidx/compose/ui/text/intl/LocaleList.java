package androidx.compose.ui.text.intl;

import androidx.compose.runtime.Immutable;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0002\u0010\bB\u0013\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "localeList", "", "(Ljava/util/List;)V", "getLocaleList", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "equals", "other", "", "get", "i", "hashCode", "isEmpty", "iterator", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocaleList implements Collection<Locale>, KMappedMarker, j$.util.Collection {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final List<Locale> localeList;
    private final int size;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocaleList getCurrent() {
            List<PlatformLocale> current = PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
            ArrayList arrayList = new ArrayList(current.size());
            int size = current.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(new Locale(current.get(i11)));
            }
            return new LocaleList((List<Locale>) arrayList);
        }
    }

    public LocaleList(@NotNull List<Locale> list) {
        Intrinsics.checkNotNullParameter(list, "localeList");
        this.localeList = list;
        this.size = list.size();
    }

    public boolean add(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Locale> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Locale)) {
            return false;
        }
        return contains((Locale) obj);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.localeList.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LocaleList) && Intrinsics.areEqual((Object) this.localeList, (Object) ((LocaleList) obj).localeList)) {
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
    public final Locale get(int i11) {
        return this.localeList.get(i11);
    }

    @NotNull
    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        return this.localeList.hashCode();
    }

    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    @NotNull
    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate<? super Locale> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf((Predicate<? super Locale>) Predicate.VivifiedWrapper.convert(predicate));
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @NotNull
    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }

    public boolean contains(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "element");
        return this.localeList.contains(locale);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocaleList(@org.jetbrains.annotations.NotNull java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "languageTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = ","
            java.lang.String[] r2 = new java.lang.String[]{r0}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r8.size()
            r0.<init>(r1)
            int r1 = r8.size()
            r2 = 0
            r3 = r2
        L_0x0023:
            if (r3 >= r1) goto L_0x0039
            java.lang.Object r4 = r8.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r4)
            java.lang.String r4 = r4.toString()
            r0.add(r4)
            int r3 = r3 + 1
            goto L_0x0023
        L_0x0039:
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = r0.size()
            r8.<init>(r1)
            int r1 = r0.size()
        L_0x0046:
            if (r2 >= r1) goto L_0x0059
            java.lang.Object r3 = r0.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            androidx.compose.ui.text.intl.Locale r4 = new androidx.compose.ui.text.intl.Locale
            r4.<init>((java.lang.String) r3)
            r8.add(r4)
            int r2 = r2 + 1
            goto L_0x0046
        L_0x0059:
            r7.<init>((java.util.List<androidx.compose.ui.text.intl.Locale>) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.intl.LocaleList.<init>(java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocaleList(@NotNull Locale... localeArr) {
        this((List<Locale>) ArraysKt___ArraysKt.toList((T[]) localeArr));
        Intrinsics.checkNotNullParameter(localeArr, "locales");
    }
}
