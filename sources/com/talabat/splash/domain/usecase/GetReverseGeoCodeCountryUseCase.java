package com.talabat.splash.domain.usecase;

import android.location.Location;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetReverseGeoCodeCountryUseCase;", "", "thirdPartyLibraryInfrastructure", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructure;", "(Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructure;)V", "invoke", "", "location", "Landroid/location/Location;", "(Landroid/location/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetReverseGeoCodeCountryUseCase {
    @NotNull
    private final ThirdPartyLibraryInfrastructure thirdPartyLibraryInfrastructure;

    @Inject
    public GetReverseGeoCodeCountryUseCase(@NotNull ThirdPartyLibraryInfrastructure thirdPartyLibraryInfrastructure2) {
        Intrinsics.checkNotNullParameter(thirdPartyLibraryInfrastructure2, "thirdPartyLibraryInfrastructure");
        this.thirdPartyLibraryInfrastructure = thirdPartyLibraryInfrastructure2;
    }

    @Nullable
    public final Object invoke(@NotNull Location location, @NotNull Continuation<? super Unit> continuation) {
        Object reverseGeoCodeCountry = this.thirdPartyLibraryInfrastructure.getReverseGeoCodeCountry(location, continuation);
        return reverseGeoCodeCountry == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? reverseGeoCodeCountry : Unit.INSTANCE;
    }
}
