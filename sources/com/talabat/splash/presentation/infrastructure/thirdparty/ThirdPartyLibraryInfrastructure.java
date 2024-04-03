package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.location.Location;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructure;", "", "getReverseGeoCodeCountry", "", "location", "Landroid/location/Location;", "(Landroid/location/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initAdjust", "initFacebookSDK", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ThirdPartyLibraryInfrastructure {
    @Nullable
    Object getReverseGeoCodeCountry(@NotNull Location location, @NotNull Continuation<? super Unit> continuation);

    void initAdjust();

    void initFacebookSDK();
}
