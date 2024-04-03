package com.talabat.feature.subscriptions.domain.wrapper;

import com.facebook.internal.NativeProtocol;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import go.a;
import go.b;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/wrapper/GetActiveSubscriptionsRxWrapper;", "", "getActiveSubscriptionsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;", "subscriptionsCustomerHelper", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;)V", "single", "Lio/reactivex/Single;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "kotlin.jvm.PlatformType", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase$Params;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetActiveSubscriptionsRxWrapper {
    /* access modifiers changed from: private */
    @NotNull
    public final GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase;
    @NotNull
    private final ISubscriptionsCustomerRepository subscriptionsCustomerHelper;

    @Inject
    public GetActiveSubscriptionsRxWrapper(@NotNull GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase2, @NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        Intrinsics.checkNotNullParameter(getActiveSubscriptionsUseCase2, "getActiveSubscriptionsUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository, "subscriptionsCustomerHelper");
        this.getActiveSubscriptionsUseCase = getActiveSubscriptionsUseCase2;
        this.subscriptionsCustomerHelper = iSubscriptionsCustomerRepository;
    }

    /* access modifiers changed from: private */
    /* renamed from: single$lambda-0  reason: not valid java name */
    public static final Subscription m10293single$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new Subscription((String) null, false, false, (LocalDateTime) null, (LocalDateTime) null, (SubscriptionType) null, (SubscriptionPlan) null, false, (List) null, 511, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: single$lambda-1  reason: not valid java name */
    public static final void m10294single$lambda1(GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper, Subscription subscription) {
        Intrinsics.checkNotNullParameter(getActiveSubscriptionsRxWrapper, "this$0");
        if (!StringsKt__StringsJVMKt.isBlank(subscription.getMembershipId())) {
            ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository = getActiveSubscriptionsRxWrapper.subscriptionsCustomerHelper;
            Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
            iSubscriptionsCustomerRepository.saveSubscriptionInfo(subscription);
        }
    }

    @NotNull
    public final Single<Subscription> single(@NotNull GetActiveSubscriptionsUseCase.Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        Single<Subscription> doOnSuccess = RxSingleKt.rxSingle$default((CoroutineContext) null, new GetActiveSubscriptionsRxWrapper$single$1(this, params, (Continuation<? super GetActiveSubscriptionsRxWrapper$single$1>) null), 1, (Object) null).onErrorReturn(new a()).doOnSuccess(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "fun single(params: GetAc…)\n            }\n        }");
        return doOnSuccess;
    }
}
