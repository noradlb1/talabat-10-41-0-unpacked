package com.talabat.sdsquad.ui.vendorslist.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.swimlanes.responses.Strategy;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.StrategyDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/mappers/SwimlaneDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "mVendorDisplayMapper", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "(Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "mapStrategyModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/StrategyDisplayModel;", "strategy", "Lcom/talabat/sdsquad/data/swimlanes/responses/Strategy;", "mapToView", "type", "mapVendorList", "", "restaurants", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneDisplayMapper implements DisplayModelMapper<SwimlaneDisplayModel, SwimLane> {
    @NotNull
    private final DisplayModelMapper<VendorDisplayModel, Vendor> mVendorDisplayMapper;

    public SwimlaneDisplayMapper(@NotNull DisplayModelMapper<VendorDisplayModel, ? super Vendor> displayModelMapper) {
        Intrinsics.checkNotNullParameter(displayModelMapper, "mVendorDisplayMapper");
        this.mVendorDisplayMapper = displayModelMapper;
    }

    private final StrategyDisplayModel mapStrategyModel(Strategy strategy) {
        if (strategy != null) {
            return new StrategyDisplayModel(strategy.getRecommendationStrategy(), strategy.getRequestId(), strategy.getUserId());
        }
        return new StrategyDisplayModel("", "", "");
    }

    private final List<VendorDisplayModel> mapVendorList(List<Vendor> list) {
        List<VendorDisplayModel> mutableList = CollectionsKt___CollectionsKt.toMutableList(CollectionsKt__CollectionsKt.emptyList());
        if (list != null) {
            for (Vendor mapToView : CollectionsKt___CollectionsKt.toMutableList(list)) {
                mutableList.add(this.mVendorDisplayMapper.mapToView(mapToView));
            }
        }
        return mutableList;
    }

    @NotNull
    public SwimlaneDisplayModel mapToView(@NotNull SwimLane swimLane) {
        Intrinsics.checkNotNullParameter(swimLane, "type");
        return new SwimlaneDisplayModel(swimLane.getPosition(), mapVendorList(swimLane.getRestaurants()), swimLane.getSlug(), mapStrategyModel(swimLane.getStrategy()), swimLane.getTitle());
    }
}
