package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0005\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Landroid/location/Address;", "kotlin.jvm.PlatformType", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl$getFromLocation$2", f = "ThirdPartyLibraryInfrastructureImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ThirdPartyLibraryInfrastructureImpl$getFromLocation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Address>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61507h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ThirdPartyLibraryInfrastructureImpl f61508i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Location f61509j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThirdPartyLibraryInfrastructureImpl$getFromLocation$2(ThirdPartyLibraryInfrastructureImpl thirdPartyLibraryInfrastructureImpl, Location location, Continuation<? super ThirdPartyLibraryInfrastructureImpl$getFromLocation$2> continuation) {
        super(2, continuation);
        this.f61508i = thirdPartyLibraryInfrastructureImpl;
        this.f61509j = location;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ThirdPartyLibraryInfrastructureImpl$getFromLocation$2(this.f61508i, this.f61509j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<Address>> continuation) {
        return ((ThirdPartyLibraryInfrastructureImpl$getFromLocation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61507h == 0) {
            ResultKt.throwOnFailure(obj);
            return new Geocoder(this.f61508i.context).getFromLocation(this.f61509j.getLatitude(), this.f61509j.getLongitude(), 1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
