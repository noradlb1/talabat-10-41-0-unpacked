package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementViewModelImpl$getSubscriptions$1 extends Lambda implements Function1<Either<? extends Failure, ? extends SubscriptionRootResponse>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementViewModelImpl f11940g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionManagementViewModelImpl$getSubscriptions$1(SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl) {
        super(1);
        this.f11940g = subscriptionManagementViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, SubscriptionRootResponse>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, SubscriptionRootResponse> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.either(new Function1<Failure, Unit>(this.f11940g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((SubscriptionManagementViewModelImpl) this.receiver).handleFailure(failure);
            }
        }, new Function1<SubscriptionRootResponse, Unit>(this.f11940g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SubscriptionRootResponse) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SubscriptionRootResponse subscriptionRootResponse) {
                Intrinsics.checkNotNullParameter(subscriptionRootResponse, "p0");
                ((SubscriptionManagementViewModelImpl) this.receiver).handleSubscriptionSuccess(subscriptionRootResponse);
            }
        });
    }
}
