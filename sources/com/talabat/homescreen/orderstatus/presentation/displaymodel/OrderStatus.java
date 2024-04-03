package com.talabat.homescreen.orderstatus.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0001\u0002\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "", "()V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "orderType", "", "getOrderType", "()I", "restaurantName", "getRestaurantName", "status", "getStatus", "withAlertBackground", "", "getWithAlertBackground", "()Z", "Multiple", "Single", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Single;", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Multiple;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OrderStatus {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Multiple;", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "orderId", "", "restaurantName", "status", "orderType", "", "withAlertBackground", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getOrderId", "()Ljava/lang/String;", "getOrderType", "()I", "getRestaurantName", "getStatus", "getWithAlertBackground", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Multiple extends OrderStatus {
        @NotNull
        private final String orderId;
        private final int orderType;
        @NotNull
        private final String restaurantName;
        @NotNull
        private final String status;
        private final boolean withAlertBackground;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Multiple(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "restaurantName");
            Intrinsics.checkNotNullParameter(str3, "status");
            this.orderId = str;
            this.restaurantName = str2;
            this.status = str3;
            this.orderType = i11;
            this.withAlertBackground = z11;
        }

        public static /* synthetic */ Multiple copy$default(Multiple multiple, String str, String str2, String str3, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = multiple.getOrderId();
            }
            if ((i12 & 2) != 0) {
                str2 = multiple.getRestaurantName();
            }
            String str4 = str2;
            if ((i12 & 4) != 0) {
                str3 = multiple.getStatus();
            }
            String str5 = str3;
            if ((i12 & 8) != 0) {
                i11 = multiple.getOrderType();
            }
            int i13 = i11;
            if ((i12 & 16) != 0) {
                z11 = multiple.getWithAlertBackground();
            }
            return multiple.copy(str, str4, str5, i13, z11);
        }

        @NotNull
        public final String component1() {
            return getOrderId();
        }

        @NotNull
        public final String component2() {
            return getRestaurantName();
        }

        @NotNull
        public final String component3() {
            return getStatus();
        }

        public final int component4() {
            return getOrderType();
        }

        public final boolean component5() {
            return getWithAlertBackground();
        }

        @NotNull
        public final Multiple copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "restaurantName");
            Intrinsics.checkNotNullParameter(str3, "status");
            return new Multiple(str, str2, str3, i11, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Multiple)) {
                return false;
            }
            Multiple multiple = (Multiple) obj;
            return Intrinsics.areEqual((Object) getOrderId(), (Object) multiple.getOrderId()) && Intrinsics.areEqual((Object) getRestaurantName(), (Object) multiple.getRestaurantName()) && Intrinsics.areEqual((Object) getStatus(), (Object) multiple.getStatus()) && getOrderType() == multiple.getOrderType() && getWithAlertBackground() == multiple.getWithAlertBackground();
        }

        @NotNull
        public String getOrderId() {
            return this.orderId;
        }

        public int getOrderType() {
            return this.orderType;
        }

        @NotNull
        public String getRestaurantName() {
            return this.restaurantName;
        }

        @NotNull
        public String getStatus() {
            return this.status;
        }

        public boolean getWithAlertBackground() {
            return this.withAlertBackground;
        }

        public int hashCode() {
            int hashCode = ((((((getOrderId().hashCode() * 31) + getRestaurantName().hashCode()) * 31) + getStatus().hashCode()) * 31) + getOrderType()) * 31;
            boolean withAlertBackground2 = getWithAlertBackground();
            if (withAlertBackground2) {
                withAlertBackground2 = true;
            }
            return hashCode + (withAlertBackground2 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            String orderId2 = getOrderId();
            String restaurantName2 = getRestaurantName();
            String status2 = getStatus();
            int orderType2 = getOrderType();
            boolean withAlertBackground2 = getWithAlertBackground();
            return "Multiple(orderId=" + orderId2 + ", restaurantName=" + restaurantName2 + ", status=" + status2 + ", orderType=" + orderType2 + ", withAlertBackground=" + withAlertBackground2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus$Single;", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "orderId", "", "restaurantName", "status", "orderType", "", "withAlertBackground", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getOrderId", "()Ljava/lang/String;", "getOrderType", "()I", "getRestaurantName", "getStatus", "getWithAlertBackground", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Single extends OrderStatus {
        @NotNull
        private final String orderId;
        private final int orderType;
        @NotNull
        private final String restaurantName;
        @NotNull
        private final String status;
        private final boolean withAlertBackground;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Single(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "restaurantName");
            Intrinsics.checkNotNullParameter(str3, "status");
            this.orderId = str;
            this.restaurantName = str2;
            this.status = str3;
            this.orderType = i11;
            this.withAlertBackground = z11;
        }

        public static /* synthetic */ Single copy$default(Single single, String str, String str2, String str3, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = single.getOrderId();
            }
            if ((i12 & 2) != 0) {
                str2 = single.getRestaurantName();
            }
            String str4 = str2;
            if ((i12 & 4) != 0) {
                str3 = single.getStatus();
            }
            String str5 = str3;
            if ((i12 & 8) != 0) {
                i11 = single.getOrderType();
            }
            int i13 = i11;
            if ((i12 & 16) != 0) {
                z11 = single.getWithAlertBackground();
            }
            return single.copy(str, str4, str5, i13, z11);
        }

        @NotNull
        public final String component1() {
            return getOrderId();
        }

        @NotNull
        public final String component2() {
            return getRestaurantName();
        }

        @NotNull
        public final String component3() {
            return getStatus();
        }

        public final int component4() {
            return getOrderType();
        }

        public final boolean component5() {
            return getWithAlertBackground();
        }

        @NotNull
        public final Single copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(str2, "restaurantName");
            Intrinsics.checkNotNullParameter(str3, "status");
            return new Single(str, str2, str3, i11, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Single)) {
                return false;
            }
            Single single = (Single) obj;
            return Intrinsics.areEqual((Object) getOrderId(), (Object) single.getOrderId()) && Intrinsics.areEqual((Object) getRestaurantName(), (Object) single.getRestaurantName()) && Intrinsics.areEqual((Object) getStatus(), (Object) single.getStatus()) && getOrderType() == single.getOrderType() && getWithAlertBackground() == single.getWithAlertBackground();
        }

        @NotNull
        public String getOrderId() {
            return this.orderId;
        }

        public int getOrderType() {
            return this.orderType;
        }

        @NotNull
        public String getRestaurantName() {
            return this.restaurantName;
        }

        @NotNull
        public String getStatus() {
            return this.status;
        }

        public boolean getWithAlertBackground() {
            return this.withAlertBackground;
        }

        public int hashCode() {
            int hashCode = ((((((getOrderId().hashCode() * 31) + getRestaurantName().hashCode()) * 31) + getStatus().hashCode()) * 31) + getOrderType()) * 31;
            boolean withAlertBackground2 = getWithAlertBackground();
            if (withAlertBackground2) {
                withAlertBackground2 = true;
            }
            return hashCode + (withAlertBackground2 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            String orderId2 = getOrderId();
            String restaurantName2 = getRestaurantName();
            String status2 = getStatus();
            int orderType2 = getOrderType();
            boolean withAlertBackground2 = getWithAlertBackground();
            return "Single(orderId=" + orderId2 + ", restaurantName=" + restaurantName2 + ", status=" + status2 + ", orderType=" + orderType2 + ", withAlertBackground=" + withAlertBackground2 + ")";
        }
    }

    private OrderStatus() {
    }

    public /* synthetic */ OrderStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String getOrderId();

    public abstract int getOrderType();

    @NotNull
    public abstract String getRestaurantName();

    @NotNull
    public abstract String getStatus();

    public abstract boolean getWithAlertBackground();
}
