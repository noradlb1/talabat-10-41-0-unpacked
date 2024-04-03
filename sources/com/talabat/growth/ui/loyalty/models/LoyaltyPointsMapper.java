package com.talabat.growth.ui.loyalty.models;

import com.designsystem.marshmallow.R;
import com.talabat.growth.features.loyalty.models.PointsTransactionType;
import com.talabat.growth.features.loyalty.models.responses.LoyaltyOrderResponseModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsListResponseModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsResponseModel;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsMapper;", "", "()V", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsMapper$Companion;", "", "()V", "getIconType", "", "pointsType", "(Ljava/lang/Integer;)I", "getPointsSign", "", "points", "getPointsTransactionString", "mapLoyaltyOrderResponseModel", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "displayModel", "lastOrder", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "mapToLoyaltyHistoryDisplayModel", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;", "model", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsListResponseModel;", "mapToLoyaltyPointsDisplayModel", "response", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsResponseModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getIconType(Integer num) {
            int value = PointsTransactionType.BURN.getValue();
            if (num != null && num.intValue() == value) {
                return R.drawable.ds_reward;
            }
            int value2 = PointsTransactionType.BURN_DONATION.getValue();
            if (num != null && num.intValue() == value2) {
                return R.drawable.ds_favorite;
            }
            int value3 = PointsTransactionType.EXPRIED.getValue();
            if (num != null && num.intValue() == value3) {
                return R.drawable.ds_minus;
            }
            return R.drawable.ds_talabat;
        }

        private final String getPointsSign(int i11) {
            return i11 > 0 ? "+" : " ";
        }

        private final int getPointsTransactionString(int i11) {
            if (i11 > 0) {
                return com.talabat.localization.R.string.loyalty_points_earned;
            }
            if (i11 < 0) {
                return com.talabat.localization.R.string.loyalty_points_spent;
            }
            return com.talabat.localization.R.string.empty;
        }

        private final LoyaltyPointsDisplayModel mapLoyaltyOrderResponseModel(LoyaltyPointsDisplayModel loyaltyPointsDisplayModel, LoyaltyOrderResponseModel loyaltyOrderResponseModel) {
            Integer num;
            boolean z11;
            if (loyaltyOrderResponseModel != null) {
                Integer points = loyaltyOrderResponseModel.getPoints();
                if (points != null) {
                    num = Integer.valueOf(Math.abs(points.intValue()));
                } else {
                    num = null;
                }
                loyaltyPointsDisplayModel.setUnSignedPoints(String.valueOf(IntKt.orZero(num)));
                Companion companion = LoyaltyPointsMapper.Companion;
                String pointsSign = companion.getPointsSign(IntKt.orZero(loyaltyOrderResponseModel.getPoints()));
                int orZero = IntKt.orZero(loyaltyOrderResponseModel.getPoints());
                loyaltyPointsDisplayModel.setPoints(pointsSign + orZero);
                loyaltyPointsDisplayModel.setPointsTransactionString(companion.getPointsTransactionString(IntKt.orZero(loyaltyOrderResponseModel.getPoints())));
                String subTitle = loyaltyOrderResponseModel.getSubTitle();
                String str = "";
                if (subTitle == null) {
                    subTitle = str;
                }
                loyaltyPointsDisplayModel.setSubTitle(subTitle);
                loyaltyPointsDisplayModel.setPointsType(IntKt.orZero(loyaltyOrderResponseModel.getPointsType()));
                String title = loyaltyOrderResponseModel.getTitle();
                if (title != null) {
                    str = title;
                }
                loyaltyPointsDisplayModel.setTitle(str);
                String createdOnUTC = loyaltyOrderResponseModel.getCreatedOnUTC();
                if (createdOnUTC != null) {
                    loyaltyPointsDisplayModel.setDate(DateUtils.Companion.getFormattedDateString(createdOnUTC, "dd LLLL yyyy"));
                }
                loyaltyPointsDisplayModel.setIcon(companion.getIconType(loyaltyOrderResponseModel.getPointsType()));
                Integer pointsType = loyaltyOrderResponseModel.getPointsType();
                int value = PointsTransactionType.EARN_CANCELLATION.getValue();
                if (pointsType != null && pointsType.intValue() == value) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                loyaltyPointsDisplayModel.setCancellation(z11);
            }
            return loyaltyPointsDisplayModel;
        }

        @NotNull
        public final LoyaltyHistoryDisplayModel mapToLoyaltyHistoryDisplayModel(@Nullable LoyaltyPointsListResponseModel loyaltyPointsListResponseModel) {
            LoyaltyHistoryDisplayModel loyaltyHistoryDisplayModel = new LoyaltyHistoryDisplayModel(0, 0, 0, (List) null, 15, (DefaultConstructorMarker) null);
            if (loyaltyPointsListResponseModel != null) {
                loyaltyHistoryDisplayModel.setPageNumber(IntKt.orZero(loyaltyPointsListResponseModel.getPageNumber()));
                loyaltyHistoryDisplayModel.setPageSize(IntKt.orZero(loyaltyPointsListResponseModel.getPageSize()));
                loyaltyHistoryDisplayModel.setTotalCount(IntKt.orZero(loyaltyPointsListResponseModel.getTotalCount()));
                LoyaltyOrderResponseModel[] pointsList = loyaltyPointsListResponseModel.getPointsList();
                if (pointsList != null) {
                    for (LoyaltyOrderResponseModel mapLoyaltyOrderResponseModel : pointsList) {
                        loyaltyHistoryDisplayModel.getRecords().add(LoyaltyPointsMapper.Companion.mapLoyaltyOrderResponseModel(new LoyaltyPointsDisplayModel(0, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, false, 2047, (DefaultConstructorMarker) null), mapLoyaltyOrderResponseModel));
                    }
                }
            }
            return loyaltyHistoryDisplayModel;
        }

        @NotNull
        public final LoyaltyPointsDisplayModel mapToLoyaltyPointsDisplayModel(@Nullable LoyaltyPointsResponseModel loyaltyPointsResponseModel) {
            LoyaltyPointsDisplayModel loyaltyPointsDisplayModel = new LoyaltyPointsDisplayModel(0, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, false, 2047, (DefaultConstructorMarker) null);
            if (loyaltyPointsResponseModel != null) {
                loyaltyPointsDisplayModel.setTotalPoints(IntKt.orZero(loyaltyPointsResponseModel.getTotalPoints()));
                String expirationText = loyaltyPointsResponseModel.getExpirationText();
                if (expirationText == null) {
                    expirationText = "";
                }
                loyaltyPointsDisplayModel.setExpirationText(expirationText);
                LoyaltyPointsMapper.Companion.mapLoyaltyOrderResponseModel(loyaltyPointsDisplayModel, loyaltyPointsResponseModel.getLastOrder());
            }
            return loyaltyPointsDisplayModel;
        }
    }
}
