package com.talabat.feature.tmart.growth.data.convert;

import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"toReminderData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder;", "toTrackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "title", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminderMappersKt {
    @NotNull
    public static final TMartGrowthReminderData toReminderData(@NotNull TMartGrowthReminder tMartGrowthReminder) {
        Intrinsics.checkNotNullParameter(tMartGrowthReminder, "<this>");
        if (tMartGrowthReminder instanceof TMartGrowthReminder.Basic) {
            TMartGrowthReminder.Basic basic = (TMartGrowthReminder.Basic) tMartGrowthReminder;
            return new TMartGrowthReminderData.Basic(basic.getDeeplink(), basic.getIconUrl(), basic.getSubtitle(), tMartGrowthReminder.getTitle());
        } else if (tMartGrowthReminder instanceof TMartGrowthReminder.Plain) {
            return new TMartGrowthReminderData.Plain(((TMartGrowthReminder.Plain) tMartGrowthReminder).getIconUrl(), tMartGrowthReminder.getTitle());
        } else {
            if (tMartGrowthReminder instanceof TMartGrowthReminder.Rich) {
                TMartGrowthReminder.Rich rich = (TMartGrowthReminder.Rich) tMartGrowthReminder;
                return new TMartGrowthReminderData.Rich(rich.getBackgroundUrl(), rich.getButtonText(), rich.getDeeplink(), rich.getLogoUrl(), rich.getImageUrl(), rich.getSubtitle(), tMartGrowthReminder.getTitle());
            } else if (Intrinsics.areEqual((Object) tMartGrowthReminder, (Object) TMartGrowthReminder.Unknown.INSTANCE)) {
                return TMartGrowthReminderData.Unknown.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @NotNull
    public static final TMartGrowthTrackingInfo toTrackingInfo(@NotNull TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse, @NotNull String str) {
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfoResponse, "<this>");
        Intrinsics.checkNotNullParameter(str, "title");
        return new TMartGrowthTrackingInfo(tMartGrowthTrackingInfoResponse.getBranchId(), tMartGrowthTrackingInfoResponse.getBranchName(), tMartGrowthTrackingInfoResponse.getCuisines(), tMartGrowthTrackingInfoResponse.getDeliveryTime(), tMartGrowthTrackingInfoResponse.isDarkstore(), "", str, tMartGrowthTrackingInfoResponse.getVendorId(), tMartGrowthTrackingInfoResponse.getVendorStatus(), tMartGrowthTrackingInfoResponse.getVendorStatusType(), tMartGrowthTrackingInfoResponse.getVerticalType());
    }
}
