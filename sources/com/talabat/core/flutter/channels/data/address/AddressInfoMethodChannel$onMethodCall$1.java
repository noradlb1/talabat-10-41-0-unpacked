package com.talabat.core.flutter.channels.data.address;

import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel$onMethodCall$1", f = "AddressInfoMethodChannel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class AddressInfoMethodChannel$onMethodCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f55875h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AddressInfoMethodChannel f55876i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f55877j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55878k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressInfoMethodChannel$onMethodCall$1(AddressInfoMethodChannel addressInfoMethodChannel, Integer num, MethodChannel.Result result, Continuation<? super AddressInfoMethodChannel$onMethodCall$1> continuation) {
        super(2, continuation);
        this.f55876i = addressInfoMethodChannel;
        this.f55877j = num;
        this.f55878k = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AddressInfoMethodChannel$onMethodCall$1 addressInfoMethodChannel$onMethodCall$1 = new AddressInfoMethodChannel$onMethodCall$1(this.f55876i, this.f55877j, this.f55878k, continuation);
        addressInfoMethodChannel$onMethodCall$1.L$0 = obj;
        return addressInfoMethodChannel$onMethodCall$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AddressInfoMethodChannel$onMethodCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55875h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AddressInfoMethodChannel addressInfoMethodChannel = this.f55876i;
            Integer num = this.f55877j;
            Result.Companion companion = Result.Companion;
            AddressInfoChannelCallback access$getCallback$p = addressInfoMethodChannel.callback;
            int intValue = num.intValue();
            this.f55875h = 1;
            if (access$getCallback$p.setSelectedCountry(intValue, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        MethodChannel.Result result = this.f55878k;
        if (Result.m6336isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            result.success(Boxing.boxBoolean(true));
        }
        AddressInfoMethodChannel addressInfoMethodChannel2 = this.f55876i;
        MethodChannel.Result result2 = this.f55878k;
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj2);
        if (r52 != null) {
            IObservabilityManager access$getObservabilityManager$p = addressInfoMethodChannel2.observabilityManager;
            String message = r52.getMessage();
            if (message == null) {
                message = "";
            }
            access$getObservabilityManager$p.trackUnExpectedScenario("set_selected_country_error", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("exception_message", message)));
            result2.success(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
