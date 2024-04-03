package com.talabat.wallet.ui.walletDashboard.view;

import android.os.Bundle;
import com.talabat.core.navigation.domain.screen.wallet.WalletDashboardScreen;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$shouldDisableOpeningHome$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12757g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardFragment$shouldDisableOpeningHome$2(WalletDashboardFragment walletDashboardFragment) {
        super(0);
        this.f12757g = walletDashboardFragment;
    }

    @NotNull
    public final Boolean invoke() {
        WalletDashboardScreen.WalletDashboardData walletDashboardData;
        boolean disableOpeningHomeForBackPressed;
        Bundle arguments = this.f12757g.getArguments();
        boolean z11 = false;
        if (arguments != null) {
            if (arguments.containsKey("extraDisableOpeningHome")) {
                disableOpeningHomeForBackPressed = arguments.getBoolean("extraDisableOpeningHome");
            } else if (arguments.containsKey("navigatorData") && (walletDashboardData = (WalletDashboardScreen.WalletDashboardData) arguments.getParcelable("navigatorData")) != null) {
                disableOpeningHomeForBackPressed = walletDashboardData.getDisableOpeningHomeForBackPressed();
            }
            z11 = disableOpeningHomeForBackPressed;
        }
        return Boolean.valueOf(z11);
    }
}
