package com.talabat.offering.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Customer;
import com.talabat.offering.domain.usecases.business.GetUserIsOfferCollectionSubscribedUseCase;
import com.talabat.offering.presentation.displaymodel.UserSubscriptionDisplayModel;
import com.talabat.offering.presentation.viewmodel.mapper.UserOfferCollectionSubscriptionDisplayModelMapper;
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
@DebugMetadata(c = "com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel$getCTAStatus$1", f = "OfferCollectionViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class OfferCollectionViewModel$getCTAStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f61136h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61137i;

    /* renamed from: j  reason: collision with root package name */
    public int f61138j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionViewModel f61139k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f61140l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionViewModel$getCTAStatus$1(OfferCollectionViewModel offerCollectionViewModel, String str, Continuation<? super OfferCollectionViewModel$getCTAStatus$1> continuation) {
        super(2, continuation);
        this.f61139k = offerCollectionViewModel;
        this.f61140l = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OfferCollectionViewModel$getCTAStatus$1(this.f61139k, this.f61140l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OfferCollectionViewModel$getCTAStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<UserSubscriptionDisplayModel> mutableLiveData;
        UserOfferCollectionSubscriptionDisplayModelMapper userOfferCollectionSubscriptionDisplayModelMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61138j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Customer.getInstance().isLoggedIn()) {
                this.f61139k.getOfferSubscribed().postValue(UserSubscriptionDisplayModel.UserLoggedOut.INSTANCE);
                return Unit.INSTANCE;
            }
            mutableLiveData = this.f61139k.getOfferSubscribed();
            UserOfferCollectionSubscriptionDisplayModelMapper userOfferCollectionSubscriptionDisplayModelMapper2 = UserOfferCollectionSubscriptionDisplayModelMapper.INSTANCE;
            GetUserIsOfferCollectionSubscribedUseCase access$getUserIsOfferCollectionSubscribedUseCase$p = this.f61139k.userIsOfferCollectionSubscribedUseCase;
            String str = this.f61140l;
            this.f61136h = mutableLiveData;
            this.f61137i = userOfferCollectionSubscriptionDisplayModelMapper2;
            this.f61138j = 1;
            Object invoke = access$getUserIsOfferCollectionSubscribedUseCase$p.invoke(str, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            userOfferCollectionSubscriptionDisplayModelMapper = userOfferCollectionSubscriptionDisplayModelMapper2;
            obj = invoke;
        } else if (i11 == 1) {
            userOfferCollectionSubscriptionDisplayModelMapper = (UserOfferCollectionSubscriptionDisplayModelMapper) this.f61137i;
            mutableLiveData = (MutableLiveData) this.f61136h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(userOfferCollectionSubscriptionDisplayModelMapper.mapUserSubscriptionView(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }
}
