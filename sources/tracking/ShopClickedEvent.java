package tracking;

import datamodels.Cuisine;
import datamodels.TypesAliasesKt;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002)*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\t\u001a\u00020\n*\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0004\u0018\u0001`\u0012H\u0000¢\u0006\u0002\b\u0013J'\u0010\u0014\u001a\u00020\n*\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rj\u0004\u0018\u0001`\u0016H\u0000¢\u0006\u0002\b\u0017J!\u0010\u0018\u001a\u00020\n*\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\rH\u0000¢\u0006\u0002\b\u001aJ\u0011\u0010\u001b\u001a\u00020\u0004*\u00020\u000bH\u0000¢\u0006\u0002\b\u001cJ\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\u000bH\u0000¢\u0006\u0002\b\u001eJ\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0004*\u00020\u000bH\u0000¢\u0006\u0002\b J\u001c\u0010!\u001a\u00020\"*\u00020\u000b2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010\rJ\u0014\u0010%\u001a\u00020\"*\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'J\u0014\u0010(\u001a\u00020\"*\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltracking/ShopClickedEvent;", "", "()V", "CUISINE_APPLIED", "", "FILTER_APPLIED", "NOTHING_APPLIED", "SEPARATOR", "SORTING_APPLIED", "isAppliedFilters", "", "Ltracking/ShopClickedEvent$EventOriginSource;", "ids", "", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "popularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "isAppliedFilters$com_talabat_talabatlib_talabatlib", "isAppliedSorting", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "isAppliedSorting$com_talabat_talabatlib_talabatlib", "isCuisineApplied", "", "isCuisineApplied$com_talabat_talabatlib_talabatlib", "toEventData", "toEventData$com_talabat_talabatlib_talabatlib", "toShopFilterSelected", "toShopFilterSelected$com_talabat_talabatlib_talabatlib", "toShopSortingSelected", "toShopSortingSelected$com_talabat_talabatlib_talabatlib", "updateCuisineId", "", "cuisines", "Ldatamodels/Cuisine;", "updateFilterId", "selectables", "Ldatamodels/filters/Selectables;", "updateSortType", "EventOriginSource", "EventOriginSourceDelegate", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopClickedEvent {
    @NotNull
    public static final String CUISINE_APPLIED = "cuisine_filtered_list";
    @NotNull
    public static final String FILTER_APPLIED = "other_filtered_list";
    @NotNull
    public static final ShopClickedEvent INSTANCE = new ShopClickedEvent();
    @NotNull
    public static final String NOTHING_APPLIED = "NA";
    @NotNull
    public static final String SEPARATOR = ",";
    @NotNull
    public static final String SORTING_APPLIED = "sorted_list";

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR&\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007j\u0004\u0018\u0001`\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR&\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007j\u0004\u0018\u0001`\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ltracking/ShopClickedEvent$EventOriginSource;", "", "defaultSelectionId", "", "getDefaultSelectionId", "()I", "selectedCuisineId", "", "getSelectedCuisineId", "()Ljava/util/List;", "setSelectedCuisineId", "(Ljava/util/List;)V", "selectedFilters", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "getSelectedFilters", "setSelectedFilters", "selectedPopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "getSelectedPopularFilters", "setSelectedPopularFilters", "selectedSort", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "getSelectedSort", "setSelectedSort", "shopCategory", "", "getShopCategory", "()Ljava/lang/String;", "setShopCategory", "(Ljava/lang/String;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface EventOriginSource {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static int getDefaultSelectionId(@NotNull EventOriginSource eventOriginSource) {
                return -100;
            }
        }

        int getDefaultSelectionId();

        @Nullable
        List<Integer> getSelectedCuisineId();

        @Nullable
        List<SelectableFilter> getSelectedFilters();

        @Nullable
        List<SelectablePopularFilter> getSelectedPopularFilters();

        @Nullable
        List<SelectableSortType> getSelectedSort();

        @Nullable
        String getShopCategory();

        void setSelectedCuisineId(@Nullable List<Integer> list);

        void setSelectedFilters(@Nullable List<SelectableFilter> list);

        void setSelectedPopularFilters(@Nullable List<SelectablePopularFilter> list);

        void setSelectedSort(@Nullable List<SelectableSortType> list);

        void setShopCategory(@Nullable String str);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R;\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048V@VX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRG\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0004\u0018\u0001`\u000e2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0004\u0018\u0001`\u000e8V@VX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nRG\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0004j\u0004\u0018\u0001`\u00142\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148V@VX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nRG\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0004j\u0004\u0018\u0001`\u001a2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0004j\u0004\u0018\u0001`\u001a8V@VX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001f8V@VX\u0002¢\u0006\u0012\n\u0004\b%\u0010\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Ltracking/ShopClickedEvent$EventOriginSourceDelegate;", "Ltracking/ShopClickedEvent$EventOriginSource;", "()V", "<set-?>", "", "", "selectedCuisineId", "getSelectedCuisineId", "()Ljava/util/List;", "setSelectedCuisineId", "(Ljava/util/List;)V", "selectedCuisineId$delegate", "Lkotlin/properties/ReadWriteProperty;", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "selectedFilters", "getSelectedFilters", "setSelectedFilters", "selectedFilters$delegate", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "selectedPopularFilters", "getSelectedPopularFilters", "setSelectedPopularFilters", "selectedPopularFilters$delegate", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "selectedSort", "getSelectedSort", "setSelectedSort", "selectedSort$delegate", "", "shopCategory", "getShopCategory", "()Ljava/lang/String;", "setShopCategory", "(Ljava/lang/String;)V", "shopCategory$delegate", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EventOriginSourceDelegate implements EventOriginSource {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f63516a;
        @NotNull
        private final ReadWriteProperty selectedCuisineId$delegate = new ShopClickedEvent$EventOriginSourceDelegate$special$$inlined$observable$1((Object) null, this);
        @NotNull
        private final ReadWriteProperty selectedFilters$delegate = new ShopClickedEvent$EventOriginSourceDelegate$special$$inlined$observable$2((Object) null, this);
        @NotNull
        private final ReadWriteProperty selectedPopularFilters$delegate = new ShopClickedEvent$EventOriginSourceDelegate$special$$inlined$observable$5((Object) null, this);
        @NotNull
        private final ReadWriteProperty selectedSort$delegate = new ShopClickedEvent$EventOriginSourceDelegate$special$$inlined$observable$3((Object) null, this);
        @NotNull
        private final ReadWriteProperty shopCategory$delegate = new ShopClickedEvent$EventOriginSourceDelegate$special$$inlined$observable$4((Object) null, this);

        static {
            Class<EventOriginSourceDelegate> cls = EventOriginSourceDelegate.class;
            f63516a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedCuisineId", "getSelectedCuisineId()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedFilters", "getSelectedFilters()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedSort", "getSelectedSort()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shopCategory", "getShopCategory()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedPopularFilters", "getSelectedPopularFilters()Ljava/util/List;", 0))};
        }

        public EventOriginSourceDelegate() {
            Delegates delegates = Delegates.INSTANCE;
        }

        public int getDefaultSelectionId() {
            return EventOriginSource.DefaultImpls.getDefaultSelectionId(this);
        }

        @Nullable
        public List<Integer> getSelectedCuisineId() {
            return (List) this.selectedCuisineId$delegate.getValue(this, f63516a[0]);
        }

        @Nullable
        public List<SelectableFilter> getSelectedFilters() {
            return (List) this.selectedFilters$delegate.getValue(this, f63516a[1]);
        }

        @Nullable
        public List<SelectablePopularFilter> getSelectedPopularFilters() {
            return (List) this.selectedPopularFilters$delegate.getValue(this, f63516a[4]);
        }

        @Nullable
        public List<SelectableSortType> getSelectedSort() {
            return (List) this.selectedSort$delegate.getValue(this, f63516a[2]);
        }

        @Nullable
        public String getShopCategory() {
            return (String) this.shopCategory$delegate.getValue(this, f63516a[3]);
        }

        public void setSelectedCuisineId(@Nullable List<Integer> list) {
            this.selectedCuisineId$delegate.setValue(this, f63516a[0], list);
        }

        public void setSelectedFilters(@Nullable List<SelectableFilter> list) {
            this.selectedFilters$delegate.setValue(this, f63516a[1], list);
        }

        public void setSelectedPopularFilters(@Nullable List<SelectablePopularFilter> list) {
            this.selectedPopularFilters$delegate.setValue(this, f63516a[4], list);
        }

        public void setSelectedSort(@Nullable List<SelectableSortType> list) {
            this.selectedSort$delegate.setValue(this, f63516a[2], list);
        }

        public void setShopCategory(@Nullable String str) {
            this.shopCategory$delegate.setValue(this, f63516a[3], str);
        }
    }

    private ShopClickedEvent() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r6 != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isAppliedFilters$com_talabat_talabatlib_talabatlib(@org.jetbrains.annotations.NotNull tracking.ShopClickedEvent.EventOriginSource r6, @org.jetbrains.annotations.Nullable java.util.List<datamodels.filters.SelectableFilter> r7, @org.jetbrains.annotations.Nullable java.util.List<datamodels.filters.SelectablePopularFilter> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0048
            r3 = r7
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0048
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x001a:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x002e
            java.lang.Object r3 = r7.next()
            r4 = r3
            datamodels.filters.SelectableFilter r4 = (datamodels.filters.SelectableFilter) r4
            boolean r4 = r4.isOn()
            if (r4 == 0) goto L_0x001a
            goto L_0x002f
        L_0x002e:
            r3 = r0
        L_0x002f:
            datamodels.filters.SelectableFilter r3 = (datamodels.filters.SelectableFilter) r3
            if (r3 == 0) goto L_0x0045
            datamodels.Filter r7 = r3.getFilter()
            if (r7 == 0) goto L_0x0045
            int r7 = r7.getId()
            int r6 = r6.getDefaultSelectionId()
            if (r7 != r6) goto L_0x0045
            r6 = r2
            goto L_0x0046
        L_0x0045:
            r6 = r1
        L_0x0046:
            if (r6 == 0) goto L_0x007a
        L_0x0048:
            if (r8 == 0) goto L_0x006c
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r8.iterator()
        L_0x0055:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x006c
            java.lang.Object r7 = r6.next()
            r8 = r7
            datamodels.filters.SelectablePopularFilter r8 = (datamodels.filters.SelectablePopularFilter) r8
            boolean r8 = r8.isOn()
            if (r8 == 0) goto L_0x0055
            r0.add(r7)
            goto L_0x0055
        L_0x006c:
            if (r0 == 0) goto L_0x0077
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r6 = r1
            goto L_0x0078
        L_0x0077:
            r6 = r2
        L_0x0078:
            if (r6 != 0) goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tracking.ShopClickedEvent.isAppliedFilters$com_talabat_talabatlib_talabatlib(tracking.ShopClickedEvent$EventOriginSource, java.util.List, java.util.List):boolean");
    }

    public final boolean isAppliedSorting$com_talabat_talabatlib_talabatlib(@NotNull EventOriginSource eventOriginSource, @Nullable List<SelectableSortType> list) {
        Object obj;
        boolean z11;
        SortType type;
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        if (list == null || !(!list.isEmpty())) {
            return false;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SelectableSortType) obj).isOn()) {
                break;
            }
        }
        SelectableSortType selectableSortType = (SelectableSortType) obj;
        if (selectableSortType == null || (type = selectableSortType.getType()) == null || type.getValue() != eventOriginSource.getDefaultSelectionId()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return true;
        }
        return false;
    }

    public final boolean isCuisineApplied$com_talabat_talabatlib_talabatlib(@NotNull EventOriginSource eventOriginSource, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        if (list == null || !(!list.isEmpty()) || ((Number) CollectionsKt___CollectionsKt.first(list)).intValue() == eventOriginSource.getDefaultSelectionId()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String toEventData$com_talabat_talabatlib_talabatlib(@NotNull EventOriginSource eventOriginSource) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        String[] strArr = new String[3];
        String str3 = "NA";
        if (isCuisineApplied$com_talabat_talabatlib_talabatlib(eventOriginSource, eventOriginSource.getSelectedCuisineId())) {
            str = CUISINE_APPLIED;
        } else {
            str = str3;
        }
        strArr[0] = str;
        if (isAppliedFilters$com_talabat_talabatlib_talabatlib(eventOriginSource, eventOriginSource.getSelectedFilters(), eventOriginSource.getSelectedPopularFilters())) {
            str2 = FILTER_APPLIED;
        } else {
            str2 = str3;
        }
        strArr[1] = str2;
        if (isAppliedSorting$com_talabat_talabatlib_talabatlib(eventOriginSource, eventOriginSource.getSelectedSort())) {
            str3 = SORTING_APPLIED;
        }
        strArr[2] = str3;
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf(strArr), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Nullable
    public final String toShopFilterSelected$com_talabat_talabatlib_talabatlib(@NotNull EventOriginSource eventOriginSource) {
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        return TypesAliasesKt.getFilterSlugName(eventOriginSource.getSelectedFilters(), eventOriginSource.getSelectedPopularFilters());
    }

    @Nullable
    public final String toShopSortingSelected$com_talabat_talabatlib_talabatlib(@NotNull EventOriginSource eventOriginSource) {
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        return TypesAliasesKt.toSortingSlugName(eventOriginSource.getSelectedSort());
    }

    public final void updateCuisineId(@NotNull EventOriginSource eventOriginSource, @Nullable List<? extends Cuisine> list) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Cuisine cuisine : list) {
                if (cuisine != null) {
                    num = Integer.valueOf(cuisine.f13848id);
                } else {
                    num = null;
                }
                if (num != null) {
                    arrayList2.add(num);
                }
            }
            arrayList = arrayList2;
        }
        eventOriginSource.setSelectedCuisineId(arrayList);
    }

    public final void updateFilterId(@NotNull EventOriginSource eventOriginSource, @Nullable Selectables selectables) {
        ArrayList arrayList;
        List<SelectablePopularFilter> selectablePopularFilters;
        List<SelectableFilter> selectableFilters;
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        ArrayList arrayList2 = null;
        if (selectables == null || (selectableFilters = selectables.getSelectableFilters()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : selectableFilters) {
                if (((SelectableFilter) next).isOn()) {
                    arrayList.add(next);
                }
            }
        }
        eventOriginSource.setSelectedFilters(arrayList);
        if (!(selectables == null || (selectablePopularFilters = selectables.getSelectablePopularFilters()) == null)) {
            arrayList2 = new ArrayList();
            for (Object next2 : selectablePopularFilters) {
                if (((SelectablePopularFilter) next2).isOn()) {
                    arrayList2.add(next2);
                }
            }
        }
        eventOriginSource.setSelectedPopularFilters(arrayList2);
    }

    public final void updateSortType(@NotNull EventOriginSource eventOriginSource, @Nullable Selectables selectables) {
        ArrayList arrayList;
        List<SelectableSortType> selectableSortTypes;
        Intrinsics.checkNotNullParameter(eventOriginSource, "<this>");
        if (selectables == null || (selectableSortTypes = selectables.getSelectableSortTypes()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : selectableSortTypes) {
                if (((SelectableSortType) next).isOn()) {
                    arrayList.add(next);
                }
            }
        }
        eventOriginSource.setSelectedSort(arrayList);
    }
}
