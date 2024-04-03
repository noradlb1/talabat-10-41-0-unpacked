package com.talabat.talabatcommon.feature.promotionWidget.repository;

import com.facebook.internal.NativeProtocol;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.PromotionsWidgetResponse;
import com.talabat.talabatcommon.feature.promotionWidget.network.PromotionsWidgetService;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/repository/PromotionsWidgetRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/promotionWidget/repository/PromotionsWidgetRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "promotionsWidgetService", "Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/promotionWidget/network/PromotionsWidgetService;)V", "getPromotionData", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetRepositoryImpl implements PromotionsWidgetRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final PromotionsWidgetService promotionsWidgetService;

    public PromotionsWidgetRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull PromotionsWidgetService promotionsWidgetService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(promotionsWidgetService2, "promotionsWidgetService");
        this.networkHandler = networkHandler2;
        this.promotionsWidgetService = promotionsWidgetService2;
    }

    @NotNull
    public Either<Failure, PromotionsWidgetDisplayModel> getPromotionData(@NotNull PromotionsWidgetRequestModel promotionsWidgetRequestModel) {
        Intrinsics.checkNotNullParameter(promotionsWidgetRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.promotionsWidgetService.getPromotionData(promotionsWidgetRequestModel.getCountryId(), promotionsWidgetRequestModel.getAreaId(), promotionsWidgetRequestModel.getPromotionTag(), promotionsWidgetRequestModel.getModule(), promotionsWidgetRequestModel.getLat(), promotionsWidgetRequestModel.getLng()), PromotionsWidgetRepositoryImpl$getPromotionData$1.INSTANCE, new PromotionsWidgetResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
