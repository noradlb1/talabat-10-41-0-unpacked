package com.talabat.wallet.knetStatusManager.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Cart;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase;
import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult;
import com.talabat.wallet.knetStatusManager.presentation.displaymodel.KNetStatusDisplayModel;
import com.talabat.wallet.knetStatusManager.presentation.viewmodel.mapper.KNetStatusDisplayModelMapper;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@DebugMetadata(c = "com.talabat.wallet.knetStatusManager.presentation.viewmodel.KNetStatusManagerViewModel$onKNetStatusReceived$1", f = "KNetStatusManagerViewModel.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class KNetStatusManagerViewModel$onKNetStatusReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12629h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12630i;

    /* renamed from: j  reason: collision with root package name */
    public int f12631j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ KNetStatusManagerViewModel f12632k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Cart f12633l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KNetStatusManagerViewModel$onKNetStatusReceived$1(KNetStatusManagerViewModel kNetStatusManagerViewModel, Cart cart, Continuation<? super KNetStatusManagerViewModel$onKNetStatusReceived$1> continuation) {
        super(2, continuation);
        this.f12632k = kNetStatusManagerViewModel;
        this.f12633l = cart;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new KNetStatusManagerViewModel$onKNetStatusReceived$1(this.f12632k, this.f12633l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((KNetStatusManagerViewModel$onKNetStatusReceived$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<KNetStatusDisplayModel> mutableLiveData;
        KNetStatusDisplayModelMapper kNetStatusDisplayModelMapper;
        Boolean bool;
        Restaurant restaurant;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12631j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12632k.getKNetStatusDisplayModel().postValue(KNetStatusDisplayModel.Loading.INSTANCE);
            mutableLiveData = this.f12632k.getKNetStatusDisplayModel();
            KNetStatusDisplayModelMapper kNetStatusDisplayModelMapper2 = KNetStatusDisplayModelMapper.INSTANCE;
            GetKNetStatusUseCase access$getGetKNetStatus$p = this.f12632k.getKNetStatus;
            Cart cart = this.f12633l;
            if (cart == null || (restaurant = cart.getRestaurant()) == null) {
                bool = null;
            } else {
                bool = Boxing.boxBoolean(restaurant.isAcceptsDebit());
            }
            boolean orFalse = BooleanKt.orFalse(bool);
            this.f12629h = mutableLiveData;
            this.f12630i = kNetStatusDisplayModelMapper2;
            this.f12631j = 1;
            Object invoke = access$getGetKNetStatus$p.invoke(orFalse, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            kNetStatusDisplayModelMapper = kNetStatusDisplayModelMapper2;
            obj = invoke;
        } else if (i11 == 1) {
            kNetStatusDisplayModelMapper = (KNetStatusDisplayModelMapper) this.f12630i;
            mutableLiveData = (MutableLiveData) this.f12629h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(kNetStatusDisplayModelMapper.mapToKNetStatusDisplayModel((KNetStatusResult) obj));
        return Unit.INSTANCE;
    }
}
