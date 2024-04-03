package com.talabat.wallet.ui.walletDashboard.model;

import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.navigation.domain.screen.wallet.CobrandedCreditCardFlutterScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenCobrandedCreditCardFlutter;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenType;", "navigationType", "Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "(Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;Lcom/talabat/core/navigation/domain/screen/Screen;)V", "getNavigationType", "()Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "getScreen", "()Lcom/talabat/core/navigation/domain/screen/Screen;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NextScreenCobrandedCreditCardFlutter extends NextScreenType {
    @NotNull
    private final NavigationType navigationType;
    @NotNull
    private final Screen<Parcelable> screen;

    public NextScreenCobrandedCreditCardFlutter() {
        this((NavigationType) null, (Screen) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NextScreenCobrandedCreditCardFlutter(NavigationType navigationType2, Screen screen2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? NavigationType.FLUTTER : navigationType2, (i11 & 2) != 0 ? new CobrandedCreditCardFlutterScreen() : screen2);
    }

    public static /* synthetic */ NextScreenCobrandedCreditCardFlutter copy$default(NextScreenCobrandedCreditCardFlutter nextScreenCobrandedCreditCardFlutter, NavigationType navigationType2, Screen<Parcelable> screen2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            navigationType2 = nextScreenCobrandedCreditCardFlutter.getNavigationType();
        }
        if ((i11 & 2) != 0) {
            screen2 = nextScreenCobrandedCreditCardFlutter.getScreen();
        }
        return nextScreenCobrandedCreditCardFlutter.copy(navigationType2, screen2);
    }

    @NotNull
    public final NavigationType component1() {
        return getNavigationType();
    }

    @NotNull
    public final Screen<Parcelable> component2() {
        return getScreen();
    }

    @NotNull
    public final NextScreenCobrandedCreditCardFlutter copy(@NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        return new NextScreenCobrandedCreditCardFlutter(navigationType2, screen2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextScreenCobrandedCreditCardFlutter)) {
            return false;
        }
        NextScreenCobrandedCreditCardFlutter nextScreenCobrandedCreditCardFlutter = (NextScreenCobrandedCreditCardFlutter) obj;
        return getNavigationType() == nextScreenCobrandedCreditCardFlutter.getNavigationType() && Intrinsics.areEqual((Object) getScreen(), (Object) nextScreenCobrandedCreditCardFlutter.getScreen());
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
        return (getNavigationType().hashCode() * 31) + getScreen().hashCode();
    }

    @NotNull
    public String toString() {
        NavigationType navigationType2 = getNavigationType();
        Screen<Parcelable> screen2 = getScreen();
        return "NextScreenCobrandedCreditCardFlutter(navigationType=" + navigationType2 + ", screen=" + screen2 + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NextScreenCobrandedCreditCardFlutter(@NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        this.navigationType = navigationType2;
        this.screen = screen2;
    }
}
