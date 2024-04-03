package com.talabat.core.navigation.domain.screen.home;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/home/HomeScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$HomeScreenData;", "data", "(Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$HomeScreenData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$HomeScreenData;", "link", "", "getLink", "()Ljava/lang/String;", "HomeScreenData", "NavigationTab", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreen implements Screen<HomeScreenData> {
    @NotNull
    private final HomeScreenData data;
    @NotNull
    private final String link = "talabat.action.homeScreen";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$NavigationTab;", "", "(Ljava/lang/String;I)V", "HOME", "FLUTTER_HOME", "SEARCH", "HOME_OF_OFFERS", "ORDER_LIST", "FLUTTER_ACCOUNT", "ACCOUNT", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum NavigationTab {
        HOME,
        FLUTTER_HOME,
        SEARCH,
        HOME_OF_OFFERS,
        ORDER_LIST,
        FLUTTER_ACCOUNT,
        ACCOUNT
    }

    public HomeScreen(@NotNull HomeScreenData homeScreenData) {
        Intrinsics.checkNotNullParameter(homeScreenData, "data");
        this.data = homeScreenData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public HomeScreenData getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$HomeScreenData;", "Landroid/os/Parcelable;", "selectNavigationTab", "Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$NavigationTab;", "snap", "", "(Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$NavigationTab;Z)V", "getSelectNavigationTab", "()Lcom/talabat/core/navigation/domain/screen/home/HomeScreen$NavigationTab;", "getSnap", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class HomeScreenData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<HomeScreenData> CREATOR = new Creator();
        @NotNull
        private final NavigationTab selectNavigationTab;
        private final boolean snap;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<HomeScreenData> {
            @NotNull
            public final HomeScreenData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HomeScreenData(NavigationTab.valueOf(parcel.readString()), parcel.readInt() != 0);
            }

            @NotNull
            public final HomeScreenData[] newArray(int i11) {
                return new HomeScreenData[i11];
            }
        }

        public HomeScreenData() {
            this((NavigationTab) null, false, 3, (DefaultConstructorMarker) null);
        }

        public HomeScreenData(@NotNull NavigationTab navigationTab, boolean z11) {
            Intrinsics.checkNotNullParameter(navigationTab, "selectNavigationTab");
            this.selectNavigationTab = navigationTab;
            this.snap = z11;
        }

        public static /* synthetic */ HomeScreenData copy$default(HomeScreenData homeScreenData, NavigationTab navigationTab, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                navigationTab = homeScreenData.selectNavigationTab;
            }
            if ((i11 & 2) != 0) {
                z11 = homeScreenData.snap;
            }
            return homeScreenData.copy(navigationTab, z11);
        }

        @NotNull
        public final NavigationTab component1() {
            return this.selectNavigationTab;
        }

        public final boolean component2() {
            return this.snap;
        }

        @NotNull
        public final HomeScreenData copy(@NotNull NavigationTab navigationTab, boolean z11) {
            Intrinsics.checkNotNullParameter(navigationTab, "selectNavigationTab");
            return new HomeScreenData(navigationTab, z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HomeScreenData)) {
                return false;
            }
            HomeScreenData homeScreenData = (HomeScreenData) obj;
            return this.selectNavigationTab == homeScreenData.selectNavigationTab && this.snap == homeScreenData.snap;
        }

        @NotNull
        public final NavigationTab getSelectNavigationTab() {
            return this.selectNavigationTab;
        }

        public final boolean getSnap() {
            return this.snap;
        }

        public int hashCode() {
            int hashCode = this.selectNavigationTab.hashCode() * 31;
            boolean z11 = this.snap;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            NavigationTab navigationTab = this.selectNavigationTab;
            boolean z11 = this.snap;
            return "HomeScreenData(selectNavigationTab=" + navigationTab + ", snap=" + z11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.selectNavigationTab.name());
            parcel.writeInt(this.snap ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HomeScreenData(NavigationTab navigationTab, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? NavigationTab.HOME : navigationTab, (i11 & 2) != 0 ? true : z11);
        }
    }
}
