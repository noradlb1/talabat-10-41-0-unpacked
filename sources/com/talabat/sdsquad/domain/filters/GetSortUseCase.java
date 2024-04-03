package com.talabat.sdsquad.domain.filters;

import au.c;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.filters.SortRepository;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/domain/filters/GetSortUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/filters/GetSortUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "requestValues", "b", "Lcom/talabat/sdsquad/data/filters/SortRepository;", "mSortRepository", "Lcom/talabat/sdsquad/data/filters/SortRepository;", "<init>", "(Lcom/talabat/sdsquad/data/filters/SortRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetSortUseCase extends UseCase<RequestValues, Flowable<List<? extends Sort>>> {
    @NotNull
    private final SortRepository mSortRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/domain/filters/GetSortUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "selectedSort", "", "(I)V", "getSelectedSort", "()I", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final int selectedSort;

        public RequestValues(int i11) {
            this.selectedSort = i11;
        }

        public final int getSelectedSort() {
            return this.selectedSort;
        }
    }

    public GetSortUseCase(@NotNull SortRepository sortRepository) {
        Intrinsics.checkNotNullParameter(sortRepository, "mSortRepository");
        this.mSortRepository = sortRepository;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-0  reason: not valid java name */
    public static final List m10786executeUseCase$lambda0(RequestValues requestValues, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Sort sort = (Sort) it.next();
            boolean z11 = false;
            if (requestValues != null && sort.getType() == requestValues.getSelectedSort()) {
                z11 = true;
            }
            sort.setOn(z11);
        }
        return list;
    }

    @NotNull
    /* renamed from: b */
    public Flowable<List<Sort>> executeUseCase(@Nullable RequestValues requestValues) {
        Flowable<R> map = this.mSortRepository.getSort().map(new c(requestValues));
        Intrinsics.checkNotNullExpressionValue(map, "mSortRepository.getSort(…         it\n            }");
        return map;
    }
}
