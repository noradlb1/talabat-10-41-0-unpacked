package com.talabat.wallet.ui.walletDashboard.viewModel;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.feature.walletBanner.GetWalletBannerUseCase;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.wallet.features.cobrandedcc.CobrandedDynamicBannerConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$getWalletBanner$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$getWalletBanner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12766h;

    /* renamed from: i  reason: collision with root package name */
    public int f12767i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12768j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12769k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$getWalletBanner$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, int i11, Continuation<? super WalletDashboardViewModelImpl$getWalletBanner$1> continuation) {
        super(2, continuation);
        this.f12768j = walletDashboardViewModelImpl;
        this.f12769k = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$getWalletBanner$1(this.f12768j, this.f12769k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$getWalletBanner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        WalletDashboardViewModelImpl walletDashboardViewModelImpl;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12767i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            WalletDashboardViewModelImpl walletDashboardViewModelImpl2 = this.f12768j;
            int i12 = this.f12769k;
            Result.Companion companion = Result.Companion;
            GetWalletBannerUseCase access$getGetWalletBannerUseCase$p = walletDashboardViewModelImpl2.getWalletBannerUseCase;
            String valueOf = String.valueOf(i12);
            this.f12766h = walletDashboardViewModelImpl2;
            this.f12767i = 1;
            Object run = access$getGetWalletBannerUseCase$p.run(valueOf, this);
            if (run == coroutine_suspended) {
                return coroutine_suspended;
            }
            walletDashboardViewModelImpl = walletDashboardViewModelImpl2;
            obj = run;
        } else if (i11 == 1) {
            walletDashboardViewModelImpl = (WalletDashboardViewModelImpl) this.f12766h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        WalletBannerDisplayModel walletBannerDisplayModel = (WalletBannerDisplayModel) obj;
        walletDashboardViewModelImpl.getWalletBannerDisplayModelData().setValue(walletBannerDisplayModel);
        if (walletBannerDisplayModel.getShouldShowBanner()) {
            walletDashboardViewModelImpl.cobrandedCCBannerTracker.trackBannerShown(walletDashboardViewModelImpl.isCobrandedApplicationPending());
        }
        IObservabilityManager.DefaultImpls.trackEvent$default(walletDashboardViewModelImpl.observabilityManager, CobrandedDynamicBannerConstants.EVENT_NAME, "CoBrandedDynamicBannerShown", (Map) null, 4, (Object) null);
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        WalletDashboardViewModelImpl walletDashboardViewModelImpl3 = this.f12768j;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            walletDashboardViewModelImpl3.getWalletBannerDisplayModelData().setValue(new WalletBannerDisplayModel(false, "no_banner", "", ""));
            IObservabilityManager.DefaultImpls.trackEvent$default(walletDashboardViewModelImpl3.observabilityManager, CobrandedDynamicBannerConstants.EVENT_NAME, "CoBrandedDynamicBannerShown", (Map) null, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
