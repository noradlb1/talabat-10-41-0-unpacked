package com.talabat.home;

import android.content.Intent;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.home.HomeNavigationActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "voucherCode", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60902g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$1(HomeScreenActivity homeScreenActivity) {
        super(1);
        this.f60902g = homeScreenActivity;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        NavigatorModel createNavigationModelToVoucherDetailsBottomSheet$default = HomeNavigationActions.createNavigationModelToVoucherDetailsBottomSheet$default(HomeNavigationActions.INSTANCE, str, (String) null, (String) null, 6, (Object) null);
        HomeScreenActivity homeScreenActivity = this.f60902g;
        Intent intent = new Intent(createNavigationModelToVoucherDetailsBottomSheet$default.getAction());
        intent.putExtras(createNavigationModelToVoucherDetailsBottomSheet$default.getOptions());
        homeScreenActivity.onDLRedirectToLoginScreen(intent, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
