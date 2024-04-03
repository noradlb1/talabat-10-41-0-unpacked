package com.talabat.sdsquad.domain.swimlanes;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.swimlanes.SwimlanesRepository;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u0012B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/domain/swimlanes/AddSwimlanesUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/swimlanes/AddSwimlanesUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "requestValues", "a", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "mSwimlanesRepository", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "mSwimalneMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class AddSwimlanesUseCase extends UseCase<RequestValues, Flowable<List<? extends VendorDisplayWrapper>>> {
    @NotNull
    private final DisplayModelMapper<SwimlaneDisplayModel, SwimLane> mSwimalneMapper;
    @NotNull
    private final SwimlanesRepository mSwimlanesRepository;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/domain/swimlanes/AddSwimlanesUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "baseUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getVendorsList", "()Ljava/util/List;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final String baseUrl;
        @NotNull
        private final List<VendorDisplayWrapper> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayWrapper> list, @NotNull String str) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            Intrinsics.checkNotNullParameter(str, "baseUrl");
            this.vendorsList = list;
            this.baseUrl = str;
        }

        @NotNull
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        @NotNull
        public final List<VendorDisplayWrapper> getVendorsList() {
            return this.vendorsList;
        }
    }

    public AddSwimlanesUseCase(@NotNull SwimlanesRepository swimlanesRepository, @NotNull DisplayModelMapper<SwimlaneDisplayModel, ? super SwimLane> displayModelMapper) {
        Intrinsics.checkNotNullParameter(swimlanesRepository, "mSwimlanesRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mSwimalneMapper");
        this.mSwimlanesRepository = swimlanesRepository;
        this.mSwimalneMapper = displayModelMapper;
    }

    @NotNull
    /* renamed from: a */
    public Flowable<List<VendorDisplayWrapper>> executeUseCase(@Nullable RequestValues requestValues) {
        int i11;
        int i12;
        List<SwimLane> swimlanes = this.mSwimlanesRepository.getSwimlanes();
        List<SwimlaneDisplayModel> mutableList = CollectionsKt___CollectionsKt.toMutableList(CollectionsKt__CollectionsKt.emptyList());
        if (swimlanes != null) {
            for (SwimLane mapToView : swimlanes) {
                mutableList.add(this.mSwimalneMapper.mapToView(mapToView));
            }
        }
        Intrinsics.checkNotNull(requestValues);
        List mutableList2 = CollectionsKt___CollectionsKt.toMutableList(requestValues.getVendorsList());
        for (SwimlaneDisplayModel swimlaneDisplayModel : mutableList) {
            int size = requestValues.getVendorsList().size();
            Integer position = swimlaneDisplayModel.getPosition();
            if (position != null) {
                i11 = position.intValue();
            } else {
                i11 = 0;
            }
            if (size > i11) {
                List<VendorDisplayModel> restaurants = swimlaneDisplayModel.getRestaurants();
                if (restaurants != null) {
                    for (VendorDisplayModel baseUrl : restaurants) {
                        baseUrl.setBaseUrl(requestValues.getBaseUrl());
                    }
                }
                if (swimlaneDisplayModel.getRestaurants() != null && (!swimlaneDisplayModel.getRestaurants().isEmpty())) {
                    VendorDisplayWrapper vendorDisplayWrapper = new VendorDisplayWrapper(VendorCellType.Swimlane, (VendorDisplayModel) null, (List) null, swimlaneDisplayModel, (InlineAdDisplayModel) null, 22, (DefaultConstructorMarker) null);
                    Integer position2 = swimlaneDisplayModel.getPosition();
                    if (position2 != null) {
                        i12 = position2.intValue();
                    } else {
                        i12 = 0;
                    }
                    if (i12 > 0) {
                        Integer position3 = swimlaneDisplayModel.getPosition();
                        Intrinsics.checkNotNull(position3);
                        mutableList2.add(position3.intValue() + 1, vendorDisplayWrapper);
                    } else {
                        mutableList2.add(0, vendorDisplayWrapper);
                    }
                }
            }
        }
        Flowable<List<VendorDisplayWrapper>> just = Flowable.just(mutableList2);
        Intrinsics.checkNotNullExpressionValue(just, "just(vendorsList)");
        return just;
    }
}
