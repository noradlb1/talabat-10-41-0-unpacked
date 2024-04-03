package com.talabat.feature.subscriptions.domain.wrapper;

import com.facebook.internal.NativeProtocol;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentWithErrorHandlingUseCase;
import go.c;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/wrapper/PostSubscriptionPaymentRxWrapper;", "", "getSubscriptionPaymentUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentWithErrorHandlingUseCase;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentWithErrorHandlingUseCase;)V", "single", "Lio/reactivex/Single;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "kotlin.jvm.PlatformType", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentWithErrorHandlingUseCase$Params;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PostSubscriptionPaymentRxWrapper {
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionPaymentWithErrorHandlingUseCase getSubscriptionPaymentUseCase;

    @Inject
    public PostSubscriptionPaymentRxWrapper(@NotNull GetSubscriptionPaymentWithErrorHandlingUseCase getSubscriptionPaymentWithErrorHandlingUseCase) {
        Intrinsics.checkNotNullParameter(getSubscriptionPaymentWithErrorHandlingUseCase, "getSubscriptionPaymentUseCase");
        this.getSubscriptionPaymentUseCase = getSubscriptionPaymentWithErrorHandlingUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: single$lambda-0  reason: not valid java name */
    public static final SubscriptionPaymentStatus m10295single$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new SubscriptionPaymentStatus((SubscriptionPaymentStatus.PaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Single<SubscriptionPaymentStatus> single(@NotNull GetSubscriptionPaymentWithErrorHandlingUseCase.Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        Single<SubscriptionPaymentStatus> onErrorReturn = RxSingleKt.rxSingle$default((CoroutineContext) null, new PostSubscriptionPaymentRxWrapper$single$1(this, params, (Continuation<? super PostSubscriptionPaymentRxWrapper$single$1>) null), 1, (Object) null).onErrorReturn(new c());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "fun single(params: GetSu…PaymentStatus()\n        }");
        return onErrorReturn;
    }
}
