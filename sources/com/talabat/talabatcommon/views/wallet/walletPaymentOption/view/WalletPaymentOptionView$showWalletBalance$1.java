package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.widget.TextView;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "amount", "", "currency", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentOptionView$showWalletBalance$1 extends Lambda implements Function2<Float, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11984g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LocationConfigurationRepository f11985h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPaymentOptionView$showWalletBalance$1(WalletPaymentOptionView walletPaymentOptionView, LocationConfigurationRepository locationConfigurationRepository) {
        super(2);
        this.f11984g = walletPaymentOptionView;
        this.f11985h = locationConfigurationRepository;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currency");
        TextView textView = (TextView) this.f11984g._$_findCachedViewById(R.id.wallet_balance);
        if (textView != null) {
            String formatAmount$default = CurrencyFormatter.Companion.formatAmount$default(CurrencyFormatter.Companion, this.f11985h, f11, false, 4, (Object) null);
            textView.setText(str + " " + formatAmount$default);
        }
    }
}
