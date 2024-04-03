package com.talabat.offering.domain.usecases.business;

import com.talabat.offering.data.SubscriptionCountryMapperKt;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import kotlin.Metadata;
import kotlin.Result;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.offering.domain.usecases.business.GetUserIsOfferCollectionSubscribedUseCase$invoke$2", f = "GetUserIsOfferCollectionSubscribedUseCase.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class GetUserIsOfferCollectionSubscribedUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61123h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetUserIsOfferCollectionSubscribedUseCase f61124i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61125j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUserIsOfferCollectionSubscribedUseCase$invoke$2(GetUserIsOfferCollectionSubscribedUseCase getUserIsOfferCollectionSubscribedUseCase, String str, Continuation<? super GetUserIsOfferCollectionSubscribedUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61124i = getUserIsOfferCollectionSubscribedUseCase;
        this.f61125j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetUserIsOfferCollectionSubscribedUseCase$invoke$2 getUserIsOfferCollectionSubscribedUseCase$invoke$2 = new GetUserIsOfferCollectionSubscribedUseCase$invoke$2(this.f61124i, this.f61125j, continuation);
        getUserIsOfferCollectionSubscribedUseCase$invoke$2.L$0 = obj;
        return getUserIsOfferCollectionSubscribedUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((GetUserIsOfferCollectionSubscribedUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61123h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GetUserIsOfferCollectionSubscribedUseCase getUserIsOfferCollectionSubscribedUseCase = this.f61124i;
            String str = this.f61125j;
            Result.Companion companion = Result.Companion;
            OfferCollectionRepo access$getOfferCollectionRepo$p = getUserIsOfferCollectionSubscribedUseCase.offerCollectionRepo;
            int subscriptionCountryId = SubscriptionCountryMapperKt.subscriptionCountryId(getUserIsOfferCollectionSubscribedUseCase.configurationLocalRepository.selectedCountry());
            this.f61123h = 1;
            obj = access$getOfferCollectionRepo$p.getIsOfferCollectionSubscribed(str, subscriptionCountryId, this);
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
        obj2 = Result.m6329constructorimpl(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        return Boxing.boxBoolean(false);
    }
}
