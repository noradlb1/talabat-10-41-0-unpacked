package com.talabat.core.navigation.domain.screen.grocery;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen$GroceryHomeData;", "data", "(Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen$GroceryHomeData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen$GroceryHomeData;", "link", "", "getLink", "()Ljava/lang/String;", "GroceryHomeData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeScreen implements Screen<GroceryHomeData> {
    @NotNull
    private final GroceryHomeData data;
    @NotNull
    private final String link = SdSquadActions.ACTION_GROCERY_HOME_SCREEN;

    public GroceryHomeScreen(@NotNull GroceryHomeData groceryHomeData) {
        Intrinsics.checkNotNullParameter(groceryHomeData, "data");
        this.data = groceryHomeData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public GroceryHomeData getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen$GroceryHomeData;", "Landroid/os/Parcelable;", "shopType", "", "verticalType", "", "verticalIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "deepLinkBundle", "Landroid/os/Bundle;", "(ILjava/lang/String;Ljava/util/ArrayList;Landroid/os/Bundle;)V", "getDeepLinkBundle", "()Landroid/os/Bundle;", "getShopType", "()I", "getVerticalIds", "()Ljava/util/ArrayList;", "getVerticalType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class GroceryHomeData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<GroceryHomeData> CREATOR = new Creator();
        @NotNull
        private final Bundle deepLinkBundle;
        private final int shopType;
        @NotNull
        private final ArrayList<Integer> verticalIds;
        @NotNull
        private final String verticalType;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<GroceryHomeData> {
            @NotNull
            public final GroceryHomeData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                }
                return new GroceryHomeData(readInt, readString, arrayList, parcel.readBundle(GroceryHomeData.class.getClassLoader()));
            }

            @NotNull
            public final GroceryHomeData[] newArray(int i11) {
                return new GroceryHomeData[i11];
            }
        }

        public GroceryHomeData(int i11, @NotNull String str, @NotNull ArrayList<Integer> arrayList, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "verticalType");
            Intrinsics.checkNotNullParameter(arrayList, "verticalIds");
            Intrinsics.checkNotNullParameter(bundle, "deepLinkBundle");
            this.shopType = i11;
            this.verticalType = str;
            this.verticalIds = arrayList;
            this.deepLinkBundle = bundle;
        }

        public static /* synthetic */ GroceryHomeData copy$default(GroceryHomeData groceryHomeData, int i11, String str, ArrayList<Integer> arrayList, Bundle bundle, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = groceryHomeData.shopType;
            }
            if ((i12 & 2) != 0) {
                str = groceryHomeData.verticalType;
            }
            if ((i12 & 4) != 0) {
                arrayList = groceryHomeData.verticalIds;
            }
            if ((i12 & 8) != 0) {
                bundle = groceryHomeData.deepLinkBundle;
            }
            return groceryHomeData.copy(i11, str, arrayList, bundle);
        }

        public final int component1() {
            return this.shopType;
        }

        @NotNull
        public final String component2() {
            return this.verticalType;
        }

        @NotNull
        public final ArrayList<Integer> component3() {
            return this.verticalIds;
        }

        @NotNull
        public final Bundle component4() {
            return this.deepLinkBundle;
        }

        @NotNull
        public final GroceryHomeData copy(int i11, @NotNull String str, @NotNull ArrayList<Integer> arrayList, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "verticalType");
            Intrinsics.checkNotNullParameter(arrayList, "verticalIds");
            Intrinsics.checkNotNullParameter(bundle, "deepLinkBundle");
            return new GroceryHomeData(i11, str, arrayList, bundle);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GroceryHomeData)) {
                return false;
            }
            GroceryHomeData groceryHomeData = (GroceryHomeData) obj;
            return this.shopType == groceryHomeData.shopType && Intrinsics.areEqual((Object) this.verticalType, (Object) groceryHomeData.verticalType) && Intrinsics.areEqual((Object) this.verticalIds, (Object) groceryHomeData.verticalIds) && Intrinsics.areEqual((Object) this.deepLinkBundle, (Object) groceryHomeData.deepLinkBundle);
        }

        @NotNull
        public final Bundle getDeepLinkBundle() {
            return this.deepLinkBundle;
        }

        public final int getShopType() {
            return this.shopType;
        }

        @NotNull
        public final ArrayList<Integer> getVerticalIds() {
            return this.verticalIds;
        }

        @NotNull
        public final String getVerticalType() {
            return this.verticalType;
        }

        public int hashCode() {
            return (((((this.shopType * 31) + this.verticalType.hashCode()) * 31) + this.verticalIds.hashCode()) * 31) + this.deepLinkBundle.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.shopType;
            String str = this.verticalType;
            ArrayList<Integer> arrayList = this.verticalIds;
            Bundle bundle = this.deepLinkBundle;
            return "GroceryHomeData(shopType=" + i11 + ", verticalType=" + str + ", verticalIds=" + arrayList + ", deepLinkBundle=" + bundle + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.shopType);
            parcel.writeString(this.verticalType);
            ArrayList<Integer> arrayList = this.verticalIds;
            parcel.writeInt(arrayList.size());
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                parcel.writeInt(it.next().intValue());
            }
            parcel.writeBundle(this.deepLinkBundle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GroceryHomeData(int i11, String str, ArrayList arrayList, Bundle bundle, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, str, arrayList, (i12 & 8) != 0 ? new Bundle() : bundle);
        }
    }
}
