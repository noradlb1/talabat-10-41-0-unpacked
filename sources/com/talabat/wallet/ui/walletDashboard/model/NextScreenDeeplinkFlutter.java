package com.talabat.wallet.ui.walletDashboard.model;

import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.navigation.domain.screen.wallet.WalletCustomDeepLinkFlutter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenDeeplinkFlutter;", "Lcom/talabat/wallet/ui/walletDashboard/model/NextScreenType;", "customDeepLink", "", "bannerName", "navigationType", "Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;Lcom/talabat/core/navigation/domain/screen/Screen;)V", "getBannerName", "()Ljava/lang/String;", "getCustomDeepLink", "getNavigationType", "()Lcom/talabat/wallet/ui/walletDashboard/model/NavigationType;", "getScreen", "()Lcom/talabat/core/navigation/domain/screen/Screen;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NextScreenDeeplinkFlutter extends NextScreenType {
    @NotNull
    private final String bannerName;
    @Nullable
    private final String customDeepLink;
    @NotNull
    private final NavigationType navigationType;
    @NotNull
    private final Screen<Parcelable> screen;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NextScreenDeeplinkFlutter(String str, String str2, NavigationType navigationType2, Screen screen2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? NavigationType.FLUTTER : navigationType2, (i11 & 8) != 0 ? new WalletCustomDeepLinkFlutter(str) : screen2);
    }

    public static /* synthetic */ NextScreenDeeplinkFlutter copy$default(NextScreenDeeplinkFlutter nextScreenDeeplinkFlutter, String str, String str2, NavigationType navigationType2, Screen<Parcelable> screen2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = nextScreenDeeplinkFlutter.customDeepLink;
        }
        if ((i11 & 2) != 0) {
            str2 = nextScreenDeeplinkFlutter.bannerName;
        }
        if ((i11 & 4) != 0) {
            navigationType2 = nextScreenDeeplinkFlutter.getNavigationType();
        }
        if ((i11 & 8) != 0) {
            screen2 = nextScreenDeeplinkFlutter.getScreen();
        }
        return nextScreenDeeplinkFlutter.copy(str, str2, navigationType2, screen2);
    }

    @Nullable
    public final String component1() {
        return this.customDeepLink;
    }

    @NotNull
    public final String component2() {
        return this.bannerName;
    }

    @NotNull
    public final NavigationType component3() {
        return getNavigationType();
    }

    @NotNull
    public final Screen<Parcelable> component4() {
        return getScreen();
    }

    @NotNull
    public final NextScreenDeeplinkFlutter copy(@Nullable String str, @NotNull String str2, @NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        Intrinsics.checkNotNullParameter(str2, "bannerName");
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        return new NextScreenDeeplinkFlutter(str, str2, navigationType2, screen2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextScreenDeeplinkFlutter)) {
            return false;
        }
        NextScreenDeeplinkFlutter nextScreenDeeplinkFlutter = (NextScreenDeeplinkFlutter) obj;
        return Intrinsics.areEqual((Object) this.customDeepLink, (Object) nextScreenDeeplinkFlutter.customDeepLink) && Intrinsics.areEqual((Object) this.bannerName, (Object) nextScreenDeeplinkFlutter.bannerName) && getNavigationType() == nextScreenDeeplinkFlutter.getNavigationType() && Intrinsics.areEqual((Object) getScreen(), (Object) nextScreenDeeplinkFlutter.getScreen());
    }

    @NotNull
    public final String getBannerName() {
        return this.bannerName;
    }

    @Nullable
    public final String getCustomDeepLink() {
        return this.customDeepLink;
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
        String str = this.customDeepLink;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.bannerName.hashCode()) * 31) + getNavigationType().hashCode()) * 31) + getScreen().hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.customDeepLink;
        String str2 = this.bannerName;
        NavigationType navigationType2 = getNavigationType();
        Screen<Parcelable> screen2 = getScreen();
        return "NextScreenDeeplinkFlutter(customDeepLink=" + str + ", bannerName=" + str2 + ", navigationType=" + navigationType2 + ", screen=" + screen2 + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NextScreenDeeplinkFlutter(@Nullable String str, @NotNull String str2, @NotNull NavigationType navigationType2, @NotNull Screen<? extends Parcelable> screen2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str2, "bannerName");
        Intrinsics.checkNotNullParameter(navigationType2, "navigationType");
        Intrinsics.checkNotNullParameter(screen2, "screen");
        this.customDeepLink = str;
        this.bannerName = str2;
        this.navigationType = navigationType2;
        this.screen = screen2;
    }
}
