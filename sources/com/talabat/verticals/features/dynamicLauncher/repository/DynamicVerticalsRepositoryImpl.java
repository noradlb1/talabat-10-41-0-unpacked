package com.talabat.verticals.features.dynamicLauncher.repository;

import com.facebook.internal.NativeProtocol;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.verticals.features.dynamicLauncher.model.request.DynamicVerticalsRequestModel;
import com.talabat.verticals.features.dynamicLauncher.model.response.VerticalsResponse;
import com.talabat.verticals.features.dynamicLauncher.network.VerticalsService;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/repository/DynamicVerticalsRepositoryImpl;", "Lcom/talabat/verticals/features/dynamicLauncher/repository/DynamicVerticalsRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "verticalsService", "Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsService;)V", "getVerticals", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "params", "Lcom/talabat/verticals/features/dynamicLauncher/model/request/DynamicVerticalsRequestModel;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicVerticalsRepositoryImpl implements DynamicVerticalsRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final VerticalsService verticalsService;

    public DynamicVerticalsRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull VerticalsService verticalsService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(verticalsService2, "verticalsService");
        this.networkHandler = networkHandler2;
        this.verticalsService = verticalsService2;
    }

    @NotNull
    public Either<Failure, VerticalsDisplayModel> getVerticals(@NotNull DynamicVerticalsRequestModel dynamicVerticalsRequestModel) {
        Intrinsics.checkNotNullParameter(dynamicVerticalsRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.verticalsService.getVerticals(dynamicVerticalsRequestModel.getCountryId(), dynamicVerticalsRequestModel.getLatitude(), dynamicVerticalsRequestModel.getLongitude()), DynamicVerticalsRepositoryImpl$getVerticals$1.INSTANCE, new VerticalsResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
