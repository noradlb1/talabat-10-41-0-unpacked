package com.talabat.talabatcommon.feature.vendorTags.domain;

import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsApi;
import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsRepository;
import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsRepositoryImpl;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0001j\u0002`\u0007B\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCase;", "Lkotlin/Function4;", "", "", "", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCaseInterface;", "vendorTagsRepository", "Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsRepository;", "(Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsRepository;)V", "invoke", "lat", "lng", "verticals", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestVendorTagsUseCase implements Function4<String, String, List<? extends Integer>, Integer, Single<VendorTagsResponse>> {
    @NotNull
    private final VendorTagsRepository vendorTagsRepository;

    public RequestVendorTagsUseCase() {
        this((VendorTagsRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public RequestVendorTagsUseCase(@NotNull VendorTagsRepository vendorTagsRepository2) {
        Intrinsics.checkNotNullParameter(vendorTagsRepository2, "vendorTagsRepository");
        this.vendorTagsRepository = vendorTagsRepository2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((String) obj, (String) obj2, (List<Integer>) (List) obj3, ((Number) obj4).intValue());
    }

    @NotNull
    public Single<VendorTagsResponse> invoke(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list, int i11) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lng");
        Intrinsics.checkNotNullParameter(list, "verticals");
        return this.vendorTagsRepository.getVendorTags(str, str2, list, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestVendorTagsUseCase(VendorTagsRepository vendorTagsRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new VendorTagsRepositoryImpl((VendorTagsApi) null, (TimeTrackerImplementation) null, 3, (DefaultConstructorMarker) null) : vendorTagsRepository2);
    }
}
