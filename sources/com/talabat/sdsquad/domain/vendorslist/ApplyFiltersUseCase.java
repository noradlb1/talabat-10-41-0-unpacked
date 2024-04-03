package com.talabat.sdsquad.domain.vendorslist;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase$RequestValues;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "requestValues", "a", "<init>", "()V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class ApplyFiltersUseCase extends UseCase<RequestValues, List<? extends VendorDisplayModel>> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "onFiltersId", "", "(Ljava/util/List;Ljava/util/List;)V", "getOnFiltersId", "()Ljava/util/List;", "getVendorsList", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final List<Integer> onFiltersId;
        @NotNull
        private final List<VendorDisplayModel> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayModel> list, @NotNull List<Integer> list2) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            Intrinsics.checkNotNullParameter(list2, "onFiltersId");
            this.vendorsList = list;
            this.onFiltersId = list2;
        }

        @NotNull
        public final List<Integer> getOnFiltersId() {
            return this.onFiltersId;
        }

        @NotNull
        public final List<VendorDisplayModel> getVendorsList() {
            return this.vendorsList;
        }
    }

    @NotNull
    /* renamed from: a */
    public List<VendorDisplayModel> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            ArrayList arrayList = new ArrayList();
            for (Object next : requestValues.getVendorsList()) {
                if (((VendorDisplayModel) next).getFiltersId().containsAll(requestValues.getOnFiltersId())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new RuntimeException("No request values found");
    }
}
