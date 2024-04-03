package com.talabat.splash.domain.usecase;

import androidx.lifecycle.MutableLiveData;
import com.talabat.splash.core.interactor.InternalUseCaseLiveSingleReturn;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetCurrentLocationUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseLiveSingleReturn;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "", "clInfrastructure", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;", "(Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;)V", "run", "", "params", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCurrentLocationUseCase extends InternalUseCaseLiveSingleReturn<MutableLiveData<CurrentLocationWrapper>, Integer> {
    @NotNull
    private final CLInfrastrcture clInfrastructure;

    @Inject
    public GetCurrentLocationUseCase(@NotNull CLInfrastrcture cLInfrastrcture) {
        Intrinsics.checkNotNullParameter(cLInfrastrcture, "clInfrastructure");
        this.clInfrastructure = cLInfrastrcture;
    }

    public /* bridge */ /* synthetic */ Object run(Object obj) {
        return run(((Number) obj).intValue());
    }

    @NotNull
    public Object run(int i11) {
        return this.clInfrastructure.getFetchCurrentLocation(i11);
    }
}
