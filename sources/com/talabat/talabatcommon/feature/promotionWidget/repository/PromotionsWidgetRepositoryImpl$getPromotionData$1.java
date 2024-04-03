package com.talabat.talabatcommon.feature.promotionWidget.repository;

import com.talabat.talabatcommon.feature.promotionWidget.model.response.PromotionsWidgetResponse;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetResponseMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/PromotionsWidgetResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetRepositoryImpl$getPromotionData$1 extends Lambda implements Function1<PromotionsWidgetResponse, PromotionsWidgetDisplayModel> {
    public static final PromotionsWidgetRepositoryImpl$getPromotionData$1 INSTANCE = new PromotionsWidgetRepositoryImpl$getPromotionData$1();

    public PromotionsWidgetRepositoryImpl$getPromotionData$1() {
        super(1);
    }

    @NotNull
    public final PromotionsWidgetDisplayModel invoke(@NotNull PromotionsWidgetResponse promotionsWidgetResponse) {
        Intrinsics.checkNotNullParameter(promotionsWidgetResponse, "it");
        return PromotionsWidgetResponseMapper.Companion.map(promotionsWidgetResponse);
    }
}
