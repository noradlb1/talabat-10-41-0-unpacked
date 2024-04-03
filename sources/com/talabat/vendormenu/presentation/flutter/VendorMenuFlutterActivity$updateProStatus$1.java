package com.talabat.vendormenu.presentation.flutter;

import com.talabat.configuration.country.Country;
import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
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
@DebugMetadata(c = "com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity$updateProStatus$1", f = "VendorMenuFlutterActivity.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class VendorMenuFlutterActivity$updateProStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12440h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VendorMenuFlutterActivity f12441i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12442j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorMenuFlutterActivity$updateProStatus$1(VendorMenuFlutterActivity vendorMenuFlutterActivity, int i11, Continuation<? super VendorMenuFlutterActivity$updateProStatus$1> continuation) {
        super(2, continuation);
        this.f12441i = vendorMenuFlutterActivity;
        this.f12442j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VendorMenuFlutterActivity$updateProStatus$1(this.f12441i, this.f12442j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VendorMenuFlutterActivity$updateProStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12440h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ProCentralizationStatusWrapper proCentralizationStatusWrapper = this.f12441i.getProCentralizationStatusWrapper();
            CountryParams countryParams = new CountryParams(Country.Companion.from(this.f12442j));
            this.f12440h = 1;
            if (proCentralizationStatusWrapper.single(countryParams, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
