package com.talabat.splash.presentation.ui;

import android.location.Location;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.domain.model.location.LocationRequestWrapper;
import com.talabat.splash.domain.usecase.GetReverseGeoCodeCountryUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivitySharedViewModel$onLocationReceived$1", f = "SplashActivitySharedViewModel.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
public final class SplashActivitySharedViewModel$onLocationReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61538h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CurrentLocationWrapper f61539i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SplashActivitySharedViewModel f61540j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivitySharedViewModel$onLocationReceived$1(CurrentLocationWrapper currentLocationWrapper, SplashActivitySharedViewModel splashActivitySharedViewModel, Continuation<? super SplashActivitySharedViewModel$onLocationReceived$1> continuation) {
        super(2, continuation);
        this.f61539i = currentLocationWrapper;
        this.f61540j = splashActivitySharedViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivitySharedViewModel$onLocationReceived$1(this.f61539i, this.f61540j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SplashActivitySharedViewModel$onLocationReceived$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61538h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Location mCurrentLocation = this.f61539i.getMCurrentLocation();
            if (mCurrentLocation != null) {
                GetReverseGeoCodeCountryUseCase access$getGetReverseGeoCodeCountryUseCase$p = this.f61540j.getReverseGeoCodeCountryUseCase;
                this.f61538h = 1;
                if (access$getGetReverseGeoCodeCountryUseCase$p.invoke(mCurrentLocation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f61540j.onLocationRequestSuccess(new LocationRequestWrapper.LocationRequestSuccess(this.f61539i.isLocationFetchSuccess(), this.f61539i.getAccuracy(), this.f61539i.getMCurrentLocation()));
        this.f61540j.showLoadingPopup();
        return Unit.INSTANCE;
    }
}
