package com.talabat.talabatcommon.views.checkoutForceCVV.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.feature.checkoutForceCVV.GetCheckoutCVVPopUpStatusUseCase;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1", f = "CheckoutForceCVVVViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f11715h;

    /* renamed from: i  reason: collision with root package name */
    public int f11716i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckoutForceCVVVViewModel f11717j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11718k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f11719l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1(CheckoutForceCVVVViewModel checkoutForceCVVVViewModel, String str, float f11, Continuation<? super CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1> continuation) {
        super(2, continuation);
        this.f11717j = checkoutForceCVVVViewModel;
        this.f11718k = str;
        this.f11719l = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1(this.f11717j, this.f11718k, this.f11719l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<Boolean> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11716i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> checkoutCVVPopUpData = this.f11717j.getCheckoutCVVPopUpData();
            GetCheckoutCVVPopUpStatusUseCase access$getGetCheckoutCVVPopUpStatusUseCase$p = this.f11717j.getCheckoutCVVPopUpStatusUseCase;
            String str = this.f11718k;
            float f11 = this.f11719l;
            this.f11715h = checkoutCVVPopUpData;
            this.f11716i = 1;
            Object invoke = access$getGetCheckoutCVVPopUpStatusUseCase$p.invoke(str, f11, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = checkoutCVVPopUpData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f11715h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
