package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpSuggestionsAndLimitsDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentOptionViewModelImpl$getWalletTopUpSuggestionsAndLimits$1 extends Lambda implements Function1<Either<? extends Failure, ? extends WalletTopUpSuggestionsAndLimitsDisplayModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionViewModelImpl f11991g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPaymentOptionViewModelImpl$getWalletTopUpSuggestionsAndLimits$1(WalletPaymentOptionViewModelImpl walletPaymentOptionViewModelImpl) {
        super(1);
        this.f11991g = walletPaymentOptionViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, WalletTopUpSuggestionsAndLimitsDisplayModel>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, WalletTopUpSuggestionsAndLimitsDisplayModel> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.either(new Function1<Failure, Unit>(this.f11991g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((WalletPaymentOptionViewModelImpl) this.receiver).handleWalletTopUpSuggestionsAndLimitsFailure(failure);
            }
        }, new Function1<WalletTopUpSuggestionsAndLimitsDisplayModel, Unit>(this.f11991g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WalletTopUpSuggestionsAndLimitsDisplayModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel) {
                Intrinsics.checkNotNullParameter(walletTopUpSuggestionsAndLimitsDisplayModel, "p0");
                ((WalletPaymentOptionViewModelImpl) this.receiver).handleWalletTopUpSuggestionsAndLimitsSuccess(walletTopUpSuggestionsAndLimitsDisplayModel);
            }
        });
    }
}
