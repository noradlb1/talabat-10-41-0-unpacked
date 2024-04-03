package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardViewModel$checkUserIsEnabled$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Boolean>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardViewModel f60658g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f60659h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardViewModel$checkUserIsEnabled$1(LoyaltyDashboardViewModel loyaltyDashboardViewModel, String str) {
        super(1);
        this.f60658g = loyaltyDashboardViewModel;
        this.f60659h = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, Boolean>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, Boolean> either) {
        Intrinsics.checkNotNullParameter(either, "result");
        AnonymousClass1 r02 = AnonymousClass1.INSTANCE;
        final LoyaltyDashboardViewModel loyaltyDashboardViewModel = this.f60658g;
        final String str = this.f60659h;
        either.either(r02, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z11) {
                if (!z11 || !loyaltyDashboardViewModel.isFwFLoyaltyEnabled()) {
                    loyaltyDashboardViewModel.applyIsUserEligibleForRewardsProgram(false);
                    return;
                }
                loyaltyDashboardViewModel.applyIsUserEligibleForRewardsProgram(true);
                loyaltyDashboardViewModel.getPointsSummary(str);
            }
        });
    }
}
