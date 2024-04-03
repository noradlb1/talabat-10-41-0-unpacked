package com.talabat.splash.domain.usecase;

import androidx.lifecycle.LiveData;
import com.talabat.splash.core.interactor.InternalUseCaseStateDecider;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetLocationPermissionStatusUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseStateDecider;", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "clInfrastructure", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;", "(Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;)V", "run", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetLocationPermissionStatusUseCase extends InternalUseCaseStateDecider<LiveData<PermissionStatus>> {
    @NotNull
    private final CLInfrastrcture clInfrastructure;

    @Inject
    public GetLocationPermissionStatusUseCase(@NotNull CLInfrastrcture cLInfrastrcture) {
        Intrinsics.checkNotNullParameter(cLInfrastrcture, "clInfrastructure");
        this.clInfrastructure = cLInfrastrcture;
    }

    @NotNull
    public Object run() {
        return this.clInfrastructure.getLocationPermissionStatus();
    }
}
