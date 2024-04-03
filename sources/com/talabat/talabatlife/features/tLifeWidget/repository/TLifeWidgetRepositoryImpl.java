package com.talabat.talabatlife.features.tLifeWidget.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRequestModel;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRootResponse;
import com.talabat.talabatlife.features.tLifeWidget.network.TLifeWidgetApi;
import com.talabat.talabatlife.features.tLifeWidget.network.TLifeWidgetService;
import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatlife/features/tLifeWidget/repository/TLifeWidgetRepositoryImpl;", "Lcom/talabat/talabatlife/features/tLifeWidget/repository/TLifeWidgetRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "tLifeHomeWidgetService", "Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetService;)V", "getTLifeUserSubscriptionStatus", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "requestModel", "Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeWidgetRepositoryImpl implements TLifeWidgetRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final TLifeWidgetService tLifeHomeWidgetService;

    public TLifeWidgetRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull TLifeWidgetService tLifeWidgetService) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(tLifeWidgetService, "tLifeHomeWidgetService");
        this.networkHandler = networkHandler2;
        this.tLifeHomeWidgetService = tLifeWidgetService;
    }

    @NotNull
    public Either<Failure, SubscriptionStatusDisplayModel> getTLifeUserSubscriptionStatus(@NotNull TLifeSubscriptionStatusRequestModel tLifeSubscriptionStatusRequestModel) {
        Intrinsics.checkNotNullParameter(tLifeSubscriptionStatusRequestModel, "requestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(TLifeWidgetApi.DefaultImpls.getUserSubscriptionStatus$default(this.tLifeHomeWidgetService, tLifeSubscriptionStatusRequestModel.getCountryCode(), 0, 2, (Object) null), TLifeWidgetRepositoryImpl$getTLifeUserSubscriptionStatus$1.INSTANCE, new TLifeSubscriptionStatusRootResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
