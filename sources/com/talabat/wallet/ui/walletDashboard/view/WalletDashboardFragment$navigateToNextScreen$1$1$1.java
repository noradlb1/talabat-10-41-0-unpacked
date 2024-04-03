package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.wallet.features.cobrandedcc.CobrandedDynamicBannerConstants;
import com.talabat.wallet.ui.walletDashboard.model.NextScreenDeeplinkFlutter;
import com.talabat.wallet.ui.walletDashboard.model.WalletShowNextScreenDisplayModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment$navigateToNextScreen$1$1$1", f = "WalletDashboardFragment.kt", i = {}, l = {867}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardFragment$navigateToNextScreen$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12754h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12755i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletShowNextScreenDisplayModel f12756j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardFragment$navigateToNextScreen$1$1$1(WalletDashboardFragment walletDashboardFragment, WalletShowNextScreenDisplayModel walletShowNextScreenDisplayModel, Continuation<? super WalletDashboardFragment$navigateToNextScreen$1$1$1> continuation) {
        super(2, continuation);
        this.f12755i = walletDashboardFragment;
        this.f12756j = walletShowNextScreenDisplayModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardFragment$navigateToNextScreen$1$1$1(this.f12755i, this.f12756j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardFragment$navigateToNextScreen$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12754h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f12755i.getDeepLinkNavigator();
            String link = this.f12756j.getNextScreen().getScreen().getLink();
            this.f12754h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(link, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue() && (this.f12756j.getNextScreen() instanceof NextScreenDeeplinkFlutter)) {
            this.f12755i.getObservabilityManager().trackEvent(CobrandedDynamicBannerConstants.EVENT_NAME, CobrandedDynamicBannerConstants.COBRANDED_DEEPLINK_FAILED_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("deeplink", this.f12756j.getNextScreen().getScreen().getLink()), TuplesKt.to("bannerName", ((NextScreenDeeplinkFlutter) this.f12756j.getNextScreen()).getBannerName())));
        }
        return Unit.INSTANCE;
    }
}
