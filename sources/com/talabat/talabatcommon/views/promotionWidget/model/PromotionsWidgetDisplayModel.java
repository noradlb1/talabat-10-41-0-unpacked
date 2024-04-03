package com.talabat.talabatcommon.views.promotionWidget.model;

import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "", "()V", "vendorInfo", "getVendorInfo", "()Ljava/lang/Object;", "setVendorInfo", "(Ljava/lang/Object;)V", "widgetInfo", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;", "getWidgetInfo", "()Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;", "setWidgetInfo", "(Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetDisplayModel {
    @Nullable
    private Object vendorInfo;
    @Nullable
    private WidgetInfo widgetInfo;

    @Nullable
    public final Object getVendorInfo() {
        return this.vendorInfo;
    }

    @Nullable
    public final WidgetInfo getWidgetInfo() {
        return this.widgetInfo;
    }

    public final void setVendorInfo(@Nullable Object obj) {
        this.vendorInfo = obj;
    }

    public final void setWidgetInfo(@Nullable WidgetInfo widgetInfo2) {
        this.widgetInfo = widgetInfo2;
    }
}
