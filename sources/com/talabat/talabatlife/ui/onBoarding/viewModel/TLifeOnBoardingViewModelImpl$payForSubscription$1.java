package com.talabat.talabatlife.ui.onBoarding.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingViewModelImpl$payForSubscription$1 extends Lambda implements Function1<Either<? extends Failure, ? extends SubscriptionPaymentDisplayModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TLifeOnBoardingViewModelImpl f12074g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeOnBoardingViewModelImpl$payForSubscription$1(TLifeOnBoardingViewModelImpl tLifeOnBoardingViewModelImpl) {
        super(1);
        this.f12074g = tLifeOnBoardingViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, SubscriptionPaymentDisplayModel>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, SubscriptionPaymentDisplayModel> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        final TLifeOnBoardingViewModelImpl tLifeOnBoardingViewModelImpl = this.f12074g;
        either.either(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                if ((failure instanceof ServerError) || (failure instanceof SystemError)) {
                    TLifeOnBoardingViewModelImpl tLifeOnBoardingViewModelImpl = tLifeOnBoardingViewModelImpl;
                    String message = failure.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    tLifeOnBoardingViewModelImpl.sendSubscriptionFailed(message);
                }
                tLifeOnBoardingViewModelImpl.handleFailure(failure);
            }
        }, new Function1<SubscriptionPaymentDisplayModel, Unit>(this.f12074g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SubscriptionPaymentDisplayModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
                Intrinsics.checkNotNullParameter(subscriptionPaymentDisplayModel, "p0");
                ((TLifeOnBoardingViewModelImpl) this.receiver).handleSuccessSubscriptionService(subscriptionPaymentDisplayModel);
            }
        });
    }
}
