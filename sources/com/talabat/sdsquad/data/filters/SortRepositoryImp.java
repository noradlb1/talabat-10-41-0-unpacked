package com.talabat.sdsquad.data.filters;

import androidx.annotation.VisibleForTesting;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\fH\u0002R,\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/data/filters/SortRepositoryImp;", "Lcom/talabat/sdsquad/data/filters/SortRepository;", "()V", "cachedSortList", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "getCachedSortList$annotations", "getCachedSortList", "()Ljava/util/List;", "setCachedSortList", "(Ljava/util/List;)V", "getSort", "Lio/reactivex/Flowable;", "loadSorts", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortRepositoryImp implements SortRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static SortRepositoryImp INSTANCE;
    @Nullable
    private List<Sort> cachedSortList;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/data/filters/SortRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/filters/SortRepositoryImp;", "destroyInstance", "", "getInstance", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            SortRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final SortRepositoryImp getInstance() {
            SortRepositoryImp access$getINSTANCE$cp;
            SortRepositoryImp access$getINSTANCE$cp2 = SortRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (SortRepositoryImp.class) {
                access$getINSTANCE$cp = SortRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new SortRepositoryImp((DefaultConstructorMarker) null);
                    SortRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private SortRepositoryImp() {
    }

    public /* synthetic */ SortRepositoryImp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getCachedSortList$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final SortRepositoryImp getInstance() {
        return Companion.getInstance();
    }

    private final Flowable<List<Sort>> loadSorts() {
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Sort sort = new Sort(SortTypes.RECOMMENDATION.ordinal(), true);
        Sort sort2 = new Sort(SortTypes.RATING.ordinal(), false);
        Sort sort3 = new Sort(SortTypes.ALPHABETIC.ordinal(), false);
        Sort sort4 = new Sort(SortTypes.MIN_ORDER.ordinal(), false);
        Sort sort5 = new Sort(SortTypes.FASTEST_DELIVERY.ordinal(), false);
        List<Sort> mutableList = CollectionsKt___CollectionsKt.toMutableList(emptyList);
        mutableList.add(sort);
        mutableList.add(sort2);
        mutableList.add(sort3);
        mutableList.add(sort4);
        mutableList.add(sort5);
        this.cachedSortList = mutableList;
        Flowable<List<Sort>> just = Flowable.just(mutableList);
        Intrinsics.checkNotNullExpressionValue(just, "just(list)");
        return just;
    }

    @Nullable
    public final List<Sort> getCachedSortList() {
        return this.cachedSortList;
    }

    @NotNull
    public Flowable<List<Sort>> getSort() {
        List<Sort> list = this.cachedSortList;
        if (list == null) {
            return loadSorts();
        }
        Flowable<List<Sort>> just = Flowable.just(list);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…cachedSortList)\n        }");
        return just;
    }

    public final void setCachedSortList(@Nullable List<Sort> list) {
        this.cachedSortList = list;
    }
}
