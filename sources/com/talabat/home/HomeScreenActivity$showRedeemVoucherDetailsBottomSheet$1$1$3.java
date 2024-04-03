package com.talabat.home;

import com.talabat.growth.ui.util.DeepLinkNavigator;
import com.talabat.growth.ui.util.DeepLinkUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "deepLink", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$3 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60904g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$3(HomeScreenActivity homeScreenActivity) {
        super(1);
        this.f60904g = homeScreenActivity;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deepLink");
        HomeScreenActivity homeScreenActivity = this.f60904g;
        DeepLinkUtilKt.redirectToDeepLink$default(homeScreenActivity, str, (DeepLinkNavigator) null, homeScreenActivity.getObservabilityManager(), 4, (Object) null);
        this.f60904g.finish();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
