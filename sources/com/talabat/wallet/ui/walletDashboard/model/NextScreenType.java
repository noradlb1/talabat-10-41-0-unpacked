package com.talabat.wallet.ui.walletDashboard.model;

import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenType;", "", "()V", "navigationType", "Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "getNavigationType", "()Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "getScreen", "()Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenCobrandedCreditCardFlutter;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenWalletDashboard;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenDeeplinkFlutter;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NextScreenType {
    private NextScreenType() {
    }

    public /* synthetic */ NextScreenType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract NavigationType getNavigationType();

    @NotNull
    public abstract Screen<Parcelable> getScreen();
}
