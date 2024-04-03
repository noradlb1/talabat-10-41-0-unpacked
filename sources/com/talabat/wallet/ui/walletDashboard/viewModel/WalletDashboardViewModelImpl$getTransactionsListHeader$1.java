package com.talabat.wallet.ui.walletDashboard.viewModel;

import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.wallet.features.expiringCard.GetExpiringCardDetailUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$getTransactionsListHeader$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$getTransactionsListHeader$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12760h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f12761i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12762j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12763k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$getTransactionsListHeader$1(boolean z11, WalletDashboardViewModelImpl walletDashboardViewModelImpl, int i11, Continuation<? super WalletDashboardViewModelImpl$getTransactionsListHeader$1> continuation) {
        super(2, continuation);
        this.f12761i = z11;
        this.f12762j = walletDashboardViewModelImpl;
        this.f12763k = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$getTransactionsListHeader$1(this.f12761i, this.f12762j, this.f12763k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$getTransactionsListHeader$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12760h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.f12761i) {
                this.f12762j.getUserNotLoggedInData().setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            GetWalletDashboardFlagEnabledUseCase access$getGetWalletDashboardFlagEnabledUseCase$p = this.f12762j.getWalletDashboardFlagEnabledUseCase;
            this.f12760h = 1;
            obj = access$getGetWalletDashboardFlagEnabledUseCase$p.invoke(PayFeatureFlagConstants.EXPIRING_CREDIT, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            GetExpiringCardDetailUseCase access$getGetWalletExpiringCreditUseCase$p = this.f12762j.getWalletExpiringCreditUseCase;
            Integer boxInt = Boxing.boxInt(this.f12763k);
            final WalletDashboardViewModelImpl walletDashboardViewModelImpl = this.f12762j;
            access$getGetWalletExpiringCreditUseCase$p.invoke(boxInt, new Function1<Either<? extends Failure, ? extends ExpiringCardDetailDisplayModel>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Either<? extends Failure, ExpiringCardDetailDisplayModel>) (Either) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Either<? extends Failure, ExpiringCardDetailDisplayModel> either) {
                    Intrinsics.checkNotNullParameter(either, "it");
                    either.either(new Function1<Failure, Unit>(walletDashboardViewModelImpl) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "p0");
                            ((WalletDashboardViewModelImpl) this.receiver).handleExpiringCreditFailure(failure);
                        }
                    }, new Function1<ExpiringCardDetailDisplayModel, Unit>(walletDashboardViewModelImpl) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ExpiringCardDetailDisplayModel) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
                            Intrinsics.checkNotNullParameter(expiringCardDetailDisplayModel, "p0");
                            ((WalletDashboardViewModelImpl) this.receiver).handleExpiringCardSuccess(expiringCardDetailDisplayModel);
                        }
                    });
                }
            });
        } else {
            this.f12762j.showDefaultHeader();
        }
        return Unit.INSTANCE;
    }
}
