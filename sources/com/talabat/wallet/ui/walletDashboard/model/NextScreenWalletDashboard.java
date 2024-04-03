package com.talabat.wallet.ui.walletDashboard.model;

import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.navigation.domain.screen.wallet.WalletDashboardScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenWalletDashboard;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenType;", "data", "Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;", "navigationType", "Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "(Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;Lcom/talabat/core/navigation/domain/screen/Screen;)V", "getNavigationType", "()Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "getScreen", "()Lcom/talabat/core/navigation/domain/screen/Screen;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NextScreenWalletDashboard extends NextScreenType {
    @NotNull
    private final WalletDashboardScreen.WalletDashboardData data;
    @NotNull
    private final NavigationType navigationType;
    @NotNull
    private final Screen<Parcelable> screen;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NextScreenWalletDashboard(WalletDashboardScreen.WalletDashboardData walletDashboardData, NavigationType navigationType2, Screen screen2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(walletDashboardData, (i11 & 2) != 0 ? NavigationType.NATIVE : navigationType2, (i11 & 4) != 0 ? new WalletDashboardScreen(walletDashboardData) : screen2);
    }

    private final WalletDashboardScreen.WalletDashboardData component1() {
        return this.data;
    }

    public static /* synthetic */ NextScreenWalletDashboard copy$default(NextScreenWalletDashboard nextScreenWalletDashboard, WalletDashboardScreen.WalletDashboardData walletDashboardData, NavigationType navigationType2, Screen<Parcelable> screen2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletDashboardData = nextScreenWalletDashboard.data;
        }
        if ((i11 & 2) != 0) {
            navigationType2 = nextScreenWalletDashboard.getNavigationType();
        }
        if ((i11 & 4) != 0) {
            screen2 = nextScreenWalletDashboard.getScreen();
        }
        return nextScreenWalletDashboard.copy(walletDashboardData, navigationType2, screen2);
    }

    @NotNull
    public final NavigationType component2() {
        return getNavigationType();
    }

    @NotNull
    public final Screen<Parcelable> component3() {
        return getScreen();
    }

    @NotNull
    public final NextScreenWalletDashboard copy(@NotNull WalletDashboardScreen.WalletDashboardData walletDashboardData, @NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        Intrinsics.checkNotNullParameter(walletDashboardData, "data");
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        return new NextScreenWalletDashboard(walletDashboardData, navigationType2, screen2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextScreenWalletDashboard)) {
            return false;
        }
        NextScreenWalletDashboard nextScreenWalletDashboard = (NextScreenWalletDashboard) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) nextScreenWalletDashboard.data) && getNavigationType() == nextScreenWalletDashboard.getNavigationType() && Intrinsics.areEqual((Object) getScreen(), (Object) nextScreenWalletDashboard.getScreen());
    }

    @NotNull
    public NavigationType getNavigationType() {
        return this.navigationType;
    }

    @NotNull
    public Screen<Parcelable> getScreen() {
        return this.screen;
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + getNavigationType().hashCode()) * 31) + getScreen().hashCode();
    }

    @NotNull
    public String toString() {
        WalletDashboardScreen.WalletDashboardData walletDashboardData = this.data;
        NavigationType navigationType2 = getNavigationType();
        Screen<Parcelable> screen2 = getScreen();
        return "NextScreenWalletDashboard(data=" + walletDashboardData + ", navigationType=" + navigationType2 + ", screen=" + screen2 + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NextScreenWalletDashboard(@NotNull WalletDashboardScreen.WalletDashboardData walletDashboardData, @NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(walletDashboardData, "data");
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        this.data = walletDashboardData;
        this.navigationType = navigationType2;
        this.screen = screen2;
    }
}
