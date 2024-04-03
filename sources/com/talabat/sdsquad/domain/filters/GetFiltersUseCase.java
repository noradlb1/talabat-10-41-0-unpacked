package com.talabat.sdsquad.domain.filters;

import au.a;
import au.b;
import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepository;
import com.talabat.sdsquad.data.vendorslist.response.Filter;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u0011B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "requestValues", "c", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "mFilterMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetFiltersUseCase extends UseCase<RequestValues, Flowable<List<? extends FilterDisplayModel>>> {
    @NotNull
    private final DisplayModelMapper<FilterDisplayModel, Filter> mFilterMapper;
    @NotNull
    private final VendorsInfoRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "selectedFilters", "Ljava/util/ArrayList;", "", "(Ljava/util/ArrayList;)V", "getSelectedFilters", "()Ljava/util/ArrayList;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final ArrayList<Integer> selectedFilters;

        public RequestValues(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "selectedFilters");
            this.selectedFilters = arrayList;
        }

        @NotNull
        public final ArrayList<Integer> getSelectedFilters() {
            return this.selectedFilters;
        }
    }

    public GetFiltersUseCase(@NotNull VendorsInfoRepository vendorsInfoRepository, @NotNull DisplayModelMapper<FilterDisplayModel, ? super Filter> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepository, "mVendorRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mFilterMapper");
        this.mVendorRepository = vendorsInfoRepository;
        this.mFilterMapper = displayModelMapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-1  reason: not valid java name */
    public static final List m10784executeUseCase$lambda1(GetFiltersUseCase getFiltersUseCase, List list) {
        Intrinsics.checkNotNullParameter(getFiltersUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Iterable<Filter> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Filter mapToView : iterable) {
            arrayList.add(getFiltersUseCase.mFilterMapper.mapToView(mapToView));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-2  reason: not valid java name */
    public static final List m10785executeUseCase$lambda2(RequestValues requestValues, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FilterDisplayModel filterDisplayModel = (FilterDisplayModel) it.next();
            Intrinsics.checkNotNull(requestValues);
            filterDisplayModel.setOn(requestValues.getSelectedFilters().contains(Integer.valueOf(filterDisplayModel.getId())));
        }
        return list;
    }

    @NotNull
    /* renamed from: c */
    public Flowable<List<FilterDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
        Flowable<R> map = this.mVendorRepository.getFilters().map(new a(this)).map(new b(requestValues));
        Intrinsics.checkNotNullExpressionValue(map, "mVendorRepository.getFil…         it\n            }");
        return map;
    }
}
