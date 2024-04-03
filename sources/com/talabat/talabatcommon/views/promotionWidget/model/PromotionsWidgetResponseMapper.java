package com.talabat.talabatcommon.views.promotionWidget.model;

import com.talabat.talabatcommon.feature.promotionWidget.model.response.PromotionsWidgetResponse;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetResponseMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetResponseMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetResponseMapper$Companion;", "", "()V", "map", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "data", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/PromotionsWidgetResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PromotionsWidgetDisplayModel map(@Nullable PromotionsWidgetResponse promotionsWidgetResponse) {
            PromotionsWidgetDisplayModel promotionsWidgetDisplayModel = new PromotionsWidgetDisplayModel();
            if (promotionsWidgetResponse != null) {
                Object vendorInfo = promotionsWidgetResponse.getVendorInfo();
                if (vendorInfo != null) {
                    promotionsWidgetDisplayModel.setVendorInfo(vendorInfo);
                }
                WidgetInfo widgetInfo = promotionsWidgetResponse.getWidgetInfo();
                if (widgetInfo != null) {
                    WidgetInfo widgetInfo2 = new WidgetInfo();
                    widgetInfo2.setBtnTitle(widgetInfo.getBtnTitle());
                    widgetInfo2.setTagLine(widgetInfo.getTagLine());
                    widgetInfo2.setHeadline(widgetInfo.getHeadline());
                    widgetInfo2.setLogo(widgetInfo.getLogo());
                    widgetInfo2.setImgUrl(widgetInfo.getImgUrl());
                    widgetInfo2.setCampaignId(widgetInfo.getCampaignId());
                    widgetInfo2.setDeeplink(widgetInfo.getDeeplink());
                    promotionsWidgetDisplayModel.setWidgetInfo(widgetInfo2);
                }
            }
            return promotionsWidgetDisplayModel;
        }
    }
}
