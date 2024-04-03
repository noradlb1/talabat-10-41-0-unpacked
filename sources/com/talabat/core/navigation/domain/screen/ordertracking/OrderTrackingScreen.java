package com.talabat.core.navigation.domain.screen.ordertracking;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.checkout.CheckoutNavigationActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderTrackingScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderTrackingScreen$OrderTrackingScreenData;", "data", "(Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderTrackingScreen$OrderTrackingScreenData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderTrackingScreen$OrderTrackingScreenData;", "link", "", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OrderTrackingScreenData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingScreen implements Screen<OrderTrackingScreenData> {
    @NotNull
    private final OrderTrackingScreenData data;
    @NotNull
    private final String link = CheckoutNavigationActions.OPEN_ORDER_TRACKING;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tHÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006("}, d2 = {"Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderTrackingScreen$OrderTrackingScreenData;", "Landroid/os/Parcelable;", "orderId", "", "transactionId", "shouldClearNavigationStack", "", "isFirstOrder", "selectedPaymentMethod", "", "addToPayMethod", "isPurchaseEventsEnabled", "(Ljava/lang/String;Ljava/lang/String;ZZIIZ)V", "getAddToPayMethod", "()I", "()Z", "getOrderId", "()Ljava/lang/String;", "getSelectedPaymentMethod", "getShouldClearNavigationStack", "getTransactionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class OrderTrackingScreenData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<OrderTrackingScreenData> CREATOR = new Creator();
        private final int addToPayMethod;
        private final boolean isFirstOrder;
        private final boolean isPurchaseEventsEnabled;
        @NotNull
        private final String orderId;
        private final int selectedPaymentMethod;
        private final boolean shouldClearNavigationStack;
        @NotNull
        private final String transactionId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<OrderTrackingScreenData> {
            @NotNull
            public final OrderTrackingScreenData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OrderTrackingScreenData(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
            }

            @NotNull
            public final OrderTrackingScreenData[] newArray(int i11) {
                return new OrderTrackingScreenData[i11];
            }
        }

        public OrderTrackingScreenData(@NotNull String str, @NotNull String str2, boolean z11, boolean z12, int i11, int i12, boolean z13) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "transactionId");
            this.orderId = str;
            this.transactionId = str2;
            this.shouldClearNavigationStack = z11;
            this.isFirstOrder = z12;
            this.selectedPaymentMethod = i11;
            this.addToPayMethod = i12;
            this.isPurchaseEventsEnabled = z13;
        }

        public static /* synthetic */ OrderTrackingScreenData copy$default(OrderTrackingScreenData orderTrackingScreenData, String str, String str2, boolean z11, boolean z12, int i11, int i12, boolean z13, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = orderTrackingScreenData.orderId;
            }
            if ((i13 & 2) != 0) {
                str2 = orderTrackingScreenData.transactionId;
            }
            String str3 = str2;
            if ((i13 & 4) != 0) {
                z11 = orderTrackingScreenData.shouldClearNavigationStack;
            }
            boolean z14 = z11;
            if ((i13 & 8) != 0) {
                z12 = orderTrackingScreenData.isFirstOrder;
            }
            boolean z15 = z12;
            if ((i13 & 16) != 0) {
                i11 = orderTrackingScreenData.selectedPaymentMethod;
            }
            int i14 = i11;
            if ((i13 & 32) != 0) {
                i12 = orderTrackingScreenData.addToPayMethod;
            }
            int i15 = i12;
            if ((i13 & 64) != 0) {
                z13 = orderTrackingScreenData.isPurchaseEventsEnabled;
            }
            return orderTrackingScreenData.copy(str, str3, z14, z15, i14, i15, z13);
        }

        @NotNull
        public final String component1() {
            return this.orderId;
        }

        @NotNull
        public final String component2() {
            return this.transactionId;
        }

        public final boolean component3() {
            return this.shouldClearNavigationStack;
        }

        public final boolean component4() {
            return this.isFirstOrder;
        }

        public final int component5() {
            return this.selectedPaymentMethod;
        }

        public final int component6() {
            return this.addToPayMethod;
        }

        public final boolean component7() {
            return this.isPurchaseEventsEnabled;
        }

        @NotNull
        public final OrderTrackingScreenData copy(@NotNull String str, @NotNull String str2, boolean z11, boolean z12, int i11, int i12, boolean z13) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "transactionId");
            return new OrderTrackingScreenData(str, str2, z11, z12, i11, i12, z13);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderTrackingScreenData)) {
                return false;
            }
            OrderTrackingScreenData orderTrackingScreenData = (OrderTrackingScreenData) obj;
            return Intrinsics.areEqual((Object) this.orderId, (Object) orderTrackingScreenData.orderId) && Intrinsics.areEqual((Object) this.transactionId, (Object) orderTrackingScreenData.transactionId) && this.shouldClearNavigationStack == orderTrackingScreenData.shouldClearNavigationStack && this.isFirstOrder == orderTrackingScreenData.isFirstOrder && this.selectedPaymentMethod == orderTrackingScreenData.selectedPaymentMethod && this.addToPayMethod == orderTrackingScreenData.addToPayMethod && this.isPurchaseEventsEnabled == orderTrackingScreenData.isPurchaseEventsEnabled;
        }

        public final int getAddToPayMethod() {
            return this.addToPayMethod;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        public final int getSelectedPaymentMethod() {
            return this.selectedPaymentMethod;
        }

        public final boolean getShouldClearNavigationStack() {
            return this.shouldClearNavigationStack;
        }

        @NotNull
        public final String getTransactionId() {
            return this.transactionId;
        }

        public int hashCode() {
            int hashCode = ((this.orderId.hashCode() * 31) + this.transactionId.hashCode()) * 31;
            boolean z11 = this.shouldClearNavigationStack;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isFirstOrder;
            if (z13) {
                z13 = true;
            }
            int i12 = (((((i11 + (z13 ? 1 : 0)) * 31) + this.selectedPaymentMethod) * 31) + this.addToPayMethod) * 31;
            boolean z14 = this.isPurchaseEventsEnabled;
            if (!z14) {
                z12 = z14;
            }
            return i12 + (z12 ? 1 : 0);
        }

        public final boolean isFirstOrder() {
            return this.isFirstOrder;
        }

        public final boolean isPurchaseEventsEnabled() {
            return this.isPurchaseEventsEnabled;
        }

        @NotNull
        public String toString() {
            String str = this.orderId;
            String str2 = this.transactionId;
            boolean z11 = this.shouldClearNavigationStack;
            boolean z12 = this.isFirstOrder;
            int i11 = this.selectedPaymentMethod;
            int i12 = this.addToPayMethod;
            boolean z13 = this.isPurchaseEventsEnabled;
            return "OrderTrackingScreenData(orderId=" + str + ", transactionId=" + str2 + ", shouldClearNavigationStack=" + z11 + ", isFirstOrder=" + z12 + ", selectedPaymentMethod=" + i11 + ", addToPayMethod=" + i12 + ", isPurchaseEventsEnabled=" + z13 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.orderId);
            parcel.writeString(this.transactionId);
            parcel.writeInt(this.shouldClearNavigationStack ? 1 : 0);
            parcel.writeInt(this.isFirstOrder ? 1 : 0);
            parcel.writeInt(this.selectedPaymentMethod);
            parcel.writeInt(this.addToPayMethod);
            parcel.writeInt(this.isPurchaseEventsEnabled ? 1 : 0);
        }
    }

    public OrderTrackingScreen(@NotNull OrderTrackingScreenData orderTrackingScreenData) {
        Intrinsics.checkNotNullParameter(orderTrackingScreenData, "data");
        this.data = orderTrackingScreenData;
    }

    public static /* synthetic */ OrderTrackingScreen copy$default(OrderTrackingScreen orderTrackingScreen, OrderTrackingScreenData orderTrackingScreenData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            orderTrackingScreenData = orderTrackingScreen.getData();
        }
        return orderTrackingScreen.copy(orderTrackingScreenData);
    }

    @NotNull
    public final OrderTrackingScreenData component1() {
        return getData();
    }

    @NotNull
    public final OrderTrackingScreen copy(@NotNull OrderTrackingScreenData orderTrackingScreenData) {
        Intrinsics.checkNotNullParameter(orderTrackingScreenData, "data");
        return new OrderTrackingScreen(orderTrackingScreenData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderTrackingScreen) && Intrinsics.areEqual((Object) getData(), (Object) ((OrderTrackingScreen) obj).getData());
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
        OrderTrackingScreenData data2 = getData();
        return "OrderTrackingScreen(data=" + data2 + ")";
    }

    @NotNull
    public OrderTrackingScreenData getData() {
        return this.data;
    }
}
