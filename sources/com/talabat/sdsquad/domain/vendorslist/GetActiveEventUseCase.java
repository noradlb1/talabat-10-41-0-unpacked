package com.talabat.sdsquad.domain.vendorslist;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorRepository;
import com.talabat.sdsquad.data.vendorslist.response.ActiveEvent;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0010B%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetActiveEventUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetActiveEventUseCase$RequestValues;", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/ActiveEventDisplayModel;", "requestValues", "a", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "mDisplayMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetActiveEventUseCase extends UseCase<RequestValues, Flowable<ActiveEventDisplayModel>> {
    @NotNull
    private final DisplayModelMapper<ActiveEventDisplayModel, ActiveEvent> mDisplayMapper;
    @NotNull
    private final VendorRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetActiveEventUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "()V", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
    }

    public GetActiveEventUseCase(@NotNull VendorRepository vendorRepository, @NotNull DisplayModelMapper<ActiveEventDisplayModel, ? super ActiveEvent> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorRepository, "mVendorRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mDisplayMapper");
        this.mVendorRepository = vendorRepository;
        this.mDisplayMapper = displayModelMapper;
    }

    @NotNull
    /* renamed from: a */
    public Flowable<ActiveEventDisplayModel> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Flowable<ActiveEventDisplayModel> just = Flowable.just(this.mDisplayMapper.mapToView(this.mVendorRepository.getPolygonEvent()));
            Intrinsics.checkNotNullExpressionValue(just, "just(mDisplayMapper.mapT…itory.getPolygonEvent()))");
            return just;
        }
        throw new RuntimeException("request value can not be null");
    }
}
