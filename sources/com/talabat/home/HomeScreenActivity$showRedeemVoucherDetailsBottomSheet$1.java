package com.talabat.home;

import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import buisnessmodels.Customer;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60901g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1(HomeScreenActivity homeScreenActivity) {
        super(1);
        this.f60901g = homeScreenActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        Intent intent;
        String stringExtra;
        if (z11 && (intent = this.f60901g.getIntent()) != null && (stringExtra = intent.getStringExtra("VOUCHER_DEEPLINK_CODE")) != null) {
            HomeScreenActivity homeScreenActivity = this.f60901g;
            RedeemVoucherBottomSheetView redeemVoucherBottomSheetView = new RedeemVoucherBottomSheetView(stringExtra, Customer.getInstance().isLoggedIn(homeScreenActivity.getContext()), new HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$1(homeScreenActivity), new HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$2(homeScreenActivity), new HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1$1$3(homeScreenActivity));
            FragmentManager supportFragmentManager = homeScreenActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this@HomeScreenActivity.supportFragmentManager");
            redeemVoucherBottomSheetView.showDialog(supportFragmentManager, RedeemVoucherBottomSheetView.class.getSimpleName());
        }
    }
}
