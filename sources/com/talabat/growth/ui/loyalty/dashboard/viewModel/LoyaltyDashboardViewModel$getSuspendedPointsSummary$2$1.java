package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardViewModel$getSuspendedPointsSummary$2$1 extends Lambda implements Function1<Either<? extends Failure, ? extends LoyaltyPointsDisplayModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardViewModel f60670g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f60671h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardViewModel$getSuspendedPointsSummary$2$1(LoyaltyDashboardViewModel loyaltyDashboardViewModel, CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.f60670g = loyaltyDashboardViewModel;
        this.f60671h = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, LoyaltyPointsDisplayModel>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, LoyaltyPointsDisplayModel> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.either(new Function1<Failure, Unit>(this.f60670g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((LoyaltyDashboardViewModel) this.receiver).handleFailure(failure);
            }
        }, new Function1<LoyaltyPointsDisplayModel, Unit>(this.f60670g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoyaltyPointsDisplayModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
                Intrinsics.checkNotNullParameter(loyaltyPointsDisplayModel, "p0");
                ((LoyaltyDashboardViewModel) this.receiver).handleLoyaltyPointsDisplayModel(loyaltyPointsDisplayModel);
            }
        });
        CancellableContinuation<Unit> cancellableContinuation = this.f60671h;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
