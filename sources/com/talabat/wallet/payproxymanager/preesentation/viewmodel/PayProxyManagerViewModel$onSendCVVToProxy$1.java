package com.talabat.wallet.payproxymanager.preesentation.viewmodel;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel;
import com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase;
import com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult;
import com.talabat.wallet.payproxymanager.preesentation.displaymodel.SendCVVToProxyDisplayModel;
import com.talabat.wallet.payproxymanager.preesentation.viewmodel.mapper.PayProxyDisplayModelMapper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.payproxymanager.preesentation.viewmodel.PayProxyManagerViewModel$onSendCVVToProxy$1", f = "PayProxyManagerViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class PayProxyManagerViewModel$onSendCVVToProxy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12646h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12647i;

    /* renamed from: j  reason: collision with root package name */
    public int f12648j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ RecurringPurchaseRequest f12649k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PayProxyManagerViewModel f12650l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f12651m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayProxyManagerViewModel$onSendCVVToProxy$1(RecurringPurchaseRequest recurringPurchaseRequest, PayProxyManagerViewModel payProxyManagerViewModel, int i11, Continuation<? super PayProxyManagerViewModel$onSendCVVToProxy$1> continuation) {
        super(2, continuation);
        this.f12649k = recurringPurchaseRequest;
        this.f12650l = payProxyManagerViewModel;
        this.f12651m = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayProxyManagerViewModel$onSendCVVToProxy$1(this.f12649k, this.f12650l, this.f12651m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PayProxyManagerViewModel$onSendCVVToProxy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<SendCVVToProxyDisplayModel> mutableLiveData;
        PayProxyDisplayModelMapper payProxyDisplayModelMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12648j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.f12649k.transactionId;
            Intrinsics.checkNotNullExpressionValue(str, "recurringPurchaseRequest.transactionId");
            String str2 = this.f12649k.cvv;
            Intrinsics.checkNotNullExpressionValue(str2, "recurringPurchaseRequest.cvv");
            PayProxyCVVRequestModel payProxyCVVRequestModel = new PayProxyCVVRequestModel(str, str2);
            mutableLiveData = this.f12650l.getSendCVVToProxyData();
            PayProxyDisplayModelMapper payProxyDisplayModelMapper2 = PayProxyDisplayModelMapper.INSTANCE;
            GetSendCVVToProxyUseCase access$getGetSendCVVToProxyUseCase$p = this.f12650l.getSendCVVToProxyUseCase;
            this.f12646h = mutableLiveData;
            this.f12647i = payProxyDisplayModelMapper2;
            this.f12648j = 1;
            obj = access$getGetSendCVVToProxyUseCase$p.invoke(payProxyCVVRequestModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            payProxyDisplayModelMapper = payProxyDisplayModelMapper2;
        } else if (i11 == 1) {
            payProxyDisplayModelMapper = (PayProxyDisplayModelMapper) this.f12647i;
            mutableLiveData = (MutableLiveData) this.f12646h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(payProxyDisplayModelMapper.mapToSendCVVToProxyDisplayModel((PayProxyCVVResult) obj, this.f12649k, this.f12651m));
        return Unit.INSTANCE;
    }
}
