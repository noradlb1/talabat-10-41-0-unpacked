package com.talabat.core.navigation.domain.screen.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/menu/MenuScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/menu/MenuScreen$MenuData;", "data", "(Lcom/talabat/core/navigation/domain/screen/menu/MenuScreen$MenuData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/menu/MenuScreen$MenuData;", "link", "", "getLink", "()Ljava/lang/String;", "MenuData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuScreen implements Screen<MenuData> {
    @NotNull
    private final MenuData data;
    @NotNull
    private final String link = "talabat.action.flutter.vendorMenu";

    public MenuScreen(@NotNull MenuData menuData) {
        Intrinsics.checkNotNullParameter(menuData, "data");
        this.data = menuData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public MenuData getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/menu/MenuScreen$MenuData;", "Landroid/os/Parcelable;", "branchId", "", "deliveryMode", "", "isProVendor", "", "shopClickOrigin", "itemId", "(ILjava/lang/String;ZLjava/lang/String;I)V", "getBranchId", "()I", "getDeliveryMode", "()Ljava/lang/String;", "()Z", "getItemId", "getShopClickOrigin", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class MenuData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<MenuData> CREATOR = new Creator();
        private final int branchId;
        @NotNull
        private final String deliveryMode;
        private final boolean isProVendor;
        private final int itemId;
        @NotNull
        private final String shopClickOrigin;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MenuData> {
            @NotNull
            public final MenuData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MenuData(parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt());
            }

            @NotNull
            public final MenuData[] newArray(int i11) {
                return new MenuData[i11];
            }
        }

        public MenuData(int i11, @NotNull String str, boolean z11, @NotNull String str2, int i12) {
            Intrinsics.checkNotNullParameter(str, "deliveryMode");
            Intrinsics.checkNotNullParameter(str2, "shopClickOrigin");
            this.branchId = i11;
            this.deliveryMode = str;
            this.isProVendor = z11;
            this.shopClickOrigin = str2;
            this.itemId = i12;
        }

        public static /* synthetic */ MenuData copy$default(MenuData menuData, int i11, String str, boolean z11, String str2, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = menuData.branchId;
            }
            if ((i13 & 2) != 0) {
                str = menuData.deliveryMode;
            }
            String str3 = str;
            if ((i13 & 4) != 0) {
                z11 = menuData.isProVendor;
            }
            boolean z12 = z11;
            if ((i13 & 8) != 0) {
                str2 = menuData.shopClickOrigin;
            }
            String str4 = str2;
            if ((i13 & 16) != 0) {
                i12 = menuData.itemId;
            }
            return menuData.copy(i11, str3, z12, str4, i12);
        }

        public final int component1() {
            return this.branchId;
        }

        @NotNull
        public final String component2() {
            return this.deliveryMode;
        }

        public final boolean component3() {
            return this.isProVendor;
        }

        @NotNull
        public final String component4() {
            return this.shopClickOrigin;
        }

        public final int component5() {
            return this.itemId;
        }

        @NotNull
        public final MenuData copy(int i11, @NotNull String str, boolean z11, @NotNull String str2, int i12) {
            Intrinsics.checkNotNullParameter(str, "deliveryMode");
            Intrinsics.checkNotNullParameter(str2, "shopClickOrigin");
            return new MenuData(i11, str, z11, str2, i12);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MenuData)) {
                return false;
            }
            MenuData menuData = (MenuData) obj;
            return this.branchId == menuData.branchId && Intrinsics.areEqual((Object) this.deliveryMode, (Object) menuData.deliveryMode) && this.isProVendor == menuData.isProVendor && Intrinsics.areEqual((Object) this.shopClickOrigin, (Object) menuData.shopClickOrigin) && this.itemId == menuData.itemId;
        }

        public final int getBranchId() {
            return this.branchId;
        }

        @NotNull
        public final String getDeliveryMode() {
            return this.deliveryMode;
        }

        public final int getItemId() {
            return this.itemId;
        }

        @NotNull
        public final String getShopClickOrigin() {
            return this.shopClickOrigin;
        }

        public int hashCode() {
            int hashCode = ((this.branchId * 31) + this.deliveryMode.hashCode()) * 31;
            boolean z11 = this.isProVendor;
            if (z11) {
                z11 = true;
            }
            return ((((hashCode + (z11 ? 1 : 0)) * 31) + this.shopClickOrigin.hashCode()) * 31) + this.itemId;
        }

        public final boolean isProVendor() {
            return this.isProVendor;
        }

        @NotNull
        public String toString() {
            int i11 = this.branchId;
            String str = this.deliveryMode;
            boolean z11 = this.isProVendor;
            String str2 = this.shopClickOrigin;
            int i12 = this.itemId;
            return "MenuData(branchId=" + i11 + ", deliveryMode=" + str + ", isProVendor=" + z11 + ", shopClickOrigin=" + str2 + ", itemId=" + i12 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.branchId);
            parcel.writeString(this.deliveryMode);
            parcel.writeInt(this.isProVendor ? 1 : 0);
            parcel.writeString(this.shopClickOrigin);
            parcel.writeInt(this.itemId);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MenuData(int i11, String str, boolean z11, String str2, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, str, z11, str2, (i13 & 16) != 0 ? -1 : i12);
        }
    }
}
