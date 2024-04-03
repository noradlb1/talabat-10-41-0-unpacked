package com.talabat.sdsquad.domain.globalsearch;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "requestValues", "a", "<init>", "()V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetBranchesIdUseCase extends UseCase<RequestValues, Flowable<String>> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "(Ljava/util/List;)V", "getVendorsList", "()Ljava/util/List;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final List<VendorDisplayModel> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayModel> list) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            this.vendorsList = list;
        }

        @NotNull
        public final List<VendorDisplayModel> getVendorsList() {
            return this.vendorsList;
        }
    }

    @NotNull
    /* renamed from: a */
    public Flowable<String> executeUseCase(@Nullable RequestValues requestValues) {
        boolean z11;
        if (requestValues != null) {
            String str = "";
            for (VendorDisplayModel next : requestValues.getVendorsList()) {
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    str = str + ",";
                }
                str = str + next.getBranchId();
            }
            Flowable<String> just = Flowable.just(str);
            Intrinsics.checkNotNullExpressionValue(just, "just(branchesId)");
            return just;
        }
        throw new RuntimeException("requestValues can not be empty");
    }
}
