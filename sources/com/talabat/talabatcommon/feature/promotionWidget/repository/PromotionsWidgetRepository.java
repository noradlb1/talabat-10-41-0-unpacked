package com.talabat.talabatcommon.feature.promotionWidget.repository;

import com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/repository/PromotionsWidgetRepository;", "", "getPromotionData", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PromotionsWidgetRepository {
    @NotNull
    Either<Failure, PromotionsWidgetDisplayModel> getPromotionData(@NotNull PromotionsWidgetRequestModel promotionsWidgetRequestModel);
}
