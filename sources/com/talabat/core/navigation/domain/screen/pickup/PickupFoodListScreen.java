package com.talabat.core.navigation.domain.screen.pickup;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.pickup.PickupNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/pickup/PickupFoodListScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/pickup/PickupFoodListScreen$PickupFoodListData;", "data", "(Lcom/talabat/core/navigation/domain/screen/pickup/PickupFoodListScreen$PickupFoodListData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/pickup/PickupFoodListScreen$PickupFoodListData;", "link", "", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "PickupFoodListData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupFoodListScreen implements Screen<PickupFoodListData> {
    @NotNull
    private final PickupFoodListData data;
    @NotNull
    private final String link = PickupNavigatorActions.ACTION_NEW_PICKUP_MODULE;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/pickup/PickupFoodListScreen$PickupFoodListData;", "Landroid/os/Parcelable;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class PickupFoodListData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<PickupFoodListData> CREATOR = new Creator();
        @NotNull
        private final String source;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PickupFoodListData> {
            @NotNull
            public final PickupFoodListData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PickupFoodListData(parcel.readString());
            }

            @NotNull
            public final PickupFoodListData[] newArray(int i11) {
                return new PickupFoodListData[i11];
            }
        }

        public PickupFoodListData(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            this.source = str;
        }

        public static /* synthetic */ PickupFoodListData copy$default(PickupFoodListData pickupFoodListData, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = pickupFoodListData.source;
            }
            return pickupFoodListData.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.source;
        }

        @NotNull
        public final PickupFoodListData copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            return new PickupFoodListData(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PickupFoodListData) && Intrinsics.areEqual((Object) this.source, (Object) ((PickupFoodListData) obj).source);
        }

        @NotNull
        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.source;
            return "PickupFoodListData(source=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.source);
        }
    }

    public PickupFoodListScreen(@NotNull PickupFoodListData pickupFoodListData) {
        Intrinsics.checkNotNullParameter(pickupFoodListData, "data");
        this.data = pickupFoodListData;
    }

    public static /* synthetic */ PickupFoodListScreen copy$default(PickupFoodListScreen pickupFoodListScreen, PickupFoodListData pickupFoodListData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pickupFoodListData = pickupFoodListScreen.getData();
        }
        return pickupFoodListScreen.copy(pickupFoodListData);
    }

    @NotNull
    public final PickupFoodListData component1() {
        return getData();
    }

    @NotNull
    public final PickupFoodListScreen copy(@NotNull PickupFoodListData pickupFoodListData) {
        Intrinsics.checkNotNullParameter(pickupFoodListData, "data");
        return new PickupFoodListScreen(pickupFoodListData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PickupFoodListScreen) && Intrinsics.areEqual((Object) getData(), (Object) ((PickupFoodListScreen) obj).getData());
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    public int hashCode() {
        return getData().hashCode();
    }

    @NotNull
    public String toString() {
        PickupFoodListData data2 = getData();
        return "PickupFoodListScreen(data=" + data2 + ")";
    }

    @NotNull
    public PickupFoodListData getData() {
        return this.data;
    }
}
