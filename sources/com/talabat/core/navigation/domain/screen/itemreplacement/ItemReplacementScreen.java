package com.talabat.core.navigation.domain.screen.itemreplacement;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen$ItemReplacementData;", "data", "(Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen$ItemReplacementData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen$ItemReplacementData;", "link", "", "getLink", "()Ljava/lang/String;", "Companion", "ItemReplacementData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemReplacementScreen implements Screen<ItemReplacementData> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_ORIGIN_BOTTOM_SHEET = "item_replacement_bottom_sheet";
    @NotNull
    public static final String EVENT_ORIGIN_STATUS_CARD = "order_status_card";
    @NotNull
    private final ItemReplacementData data;
    @NotNull
    private final String link = "com.talabat.ItemReplacementFlutterActivity";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen$Companion;", "", "()V", "EVENT_ORIGIN_BOTTOM_SHEET", "", "EVENT_ORIGIN_STATUS_CARD", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/itemreplacement/ItemReplacementScreen$ItemReplacementData;", "Landroid/os/Parcelable;", "orderId", "", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getOrderId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class ItemReplacementData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<ItemReplacementData> CREATOR = new Creator();
        @NotNull
        private final String eventOrigin;
        @NotNull
        private final String orderId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ItemReplacementData> {
            @NotNull
            public final ItemReplacementData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ItemReplacementData(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final ItemReplacementData[] newArray(int i11) {
                return new ItemReplacementData[i11];
            }
        }

        public ItemReplacementData(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            this.orderId = str;
            this.eventOrigin = str2;
        }

        public static /* synthetic */ ItemReplacementData copy$default(ItemReplacementData itemReplacementData, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = itemReplacementData.orderId;
            }
            if ((i11 & 2) != 0) {
                str2 = itemReplacementData.eventOrigin;
            }
            return itemReplacementData.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.orderId;
        }

        @NotNull
        public final String component2() {
            return this.eventOrigin;
        }

        @NotNull
        public final ItemReplacementData copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            return new ItemReplacementData(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemReplacementData)) {
                return false;
            }
            ItemReplacementData itemReplacementData = (ItemReplacementData) obj;
            return Intrinsics.areEqual((Object) this.orderId, (Object) itemReplacementData.orderId) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) itemReplacementData.eventOrigin);
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        public int hashCode() {
            return (this.orderId.hashCode() * 31) + this.eventOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.orderId;
            String str2 = this.eventOrigin;
            return "ItemReplacementData(orderId=" + str + ", eventOrigin=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.orderId);
            parcel.writeString(this.eventOrigin);
        }
    }

    public ItemReplacementScreen(@NotNull ItemReplacementData itemReplacementData) {
        Intrinsics.checkNotNullParameter(itemReplacementData, "data");
        this.data = itemReplacementData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public ItemReplacementData getData() {
        return this.data;
    }
}
