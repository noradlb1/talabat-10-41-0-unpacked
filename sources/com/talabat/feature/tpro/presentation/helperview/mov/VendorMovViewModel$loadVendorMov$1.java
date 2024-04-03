package com.talabat.feature.tpro.presentation.helperview.mov;

import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel$loadVendorMov$1", f = "VendorMovViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
public final class VendorMovViewModel$loadVendorMov$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59289h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VendorMovViewModel f59290i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f59291j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorMovViewModel$loadVendorMov$1(VendorMovViewModel vendorMovViewModel, int i11, Continuation<? super VendorMovViewModel$loadVendorMov$1> continuation) {
        super(2, continuation);
        this.f59290i = vendorMovViewModel;
        this.f59291j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VendorMovViewModel$loadVendorMov$1 vendorMovViewModel$loadVendorMov$1 = new VendorMovViewModel$loadVendorMov$1(this.f59290i, this.f59291j, continuation);
        vendorMovViewModel$loadVendorMov$1.L$0 = obj;
        return vendorMovViewModel$loadVendorMov$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VendorMovViewModel$loadVendorMov$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59289h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            VendorMovViewModel vendorMovViewModel = this.f59290i;
            int i12 = this.f59291j;
            Result.Companion companion = Result.Companion;
            GetTProVendorMovUseCase access$getGetProMovUseCase$p = vendorMovViewModel.getProMovUseCase;
            GetTProVendorMovUseCase.Params params = new GetTProVendorMovUseCase.Params(i12);
            this.f59289h = 1;
            obj = access$getGetProMovUseCase$p.invoke(params, this);
            if (obj == coroutine_suspended) {
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
        obj2 = Result.m6329constructorimpl((ProVendorMov) obj);
        VendorMovViewModel vendorMovViewModel2 = this.f59290i;
        if (Result.m6336isSuccessimpl(obj2)) {
            vendorMovViewModel2._vendorMovLiveData.postValue((ProVendorMov) obj2);
        }
        VendorMovViewModel vendorMovViewModel3 = this.f59290i;
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj2);
        if (r52 != null) {
            vendorMovViewModel3._failureLiveData.postValue(r52);
        }
        return Unit.INSTANCE;
    }
}
