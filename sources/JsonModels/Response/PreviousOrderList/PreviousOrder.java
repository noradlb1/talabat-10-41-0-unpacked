package JsonModels.Response.PreviousOrderList;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"LJsonModels/Response/PreviousOrderList/PreviousOrder;", "", "orderId", "", "quantity", "total", "", "orderDate", "", "items", "", "LJsonModels/Response/PreviousOrderList/PreviousOrderItem;", "(IIDLjava/lang/String;Ljava/util/List;)V", "firstItemName", "getFirstItemName", "()Ljava/lang/String;", "firstItemQuantity", "getFirstItemQuantity", "()I", "moreItemsCount", "getMoreItemsCount", "getOrderDate", "setOrderDate", "(Ljava/lang/String;)V", "getQuantity", "setQuantity", "(I)V", "getTotal", "()D", "setTotal", "(D)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hasItems", "hasMoreThanOneItem", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrder {
    @SerializedName("items")
    @NotNull
    @JvmField
    public List<PreviousOrderItem> items;
    @SerializedName("orderDate")
    @NotNull
    private String orderDate;
    @SerializedName("orderId")
    @JvmField
    public int orderId;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("total")
    private double total;

    public PreviousOrder() {
        this(0, 0, 0.0d, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public PreviousOrder(int i11, int i12, double d11, @NotNull String str, @NotNull List<PreviousOrderItem> list) {
        Intrinsics.checkNotNullParameter(str, "orderDate");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.orderId = i11;
        this.quantity = i12;
        this.total = d11;
        this.orderDate = str;
        this.items = list;
    }

    public static /* synthetic */ PreviousOrder copy$default(PreviousOrder previousOrder, int i11, int i12, double d11, String str, List<PreviousOrderItem> list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = previousOrder.orderId;
        }
        if ((i13 & 2) != 0) {
            i12 = previousOrder.quantity;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            d11 = previousOrder.total;
        }
        double d12 = d11;
        if ((i13 & 8) != 0) {
            str = previousOrder.orderDate;
        }
        String str2 = str;
        if ((i13 & 16) != 0) {
            list = previousOrder.items;
        }
        return previousOrder.copy(i11, i14, d12, str2, list);
    }

    private final boolean hasMoreThanOneItem() {
        return this.items.size() > 1;
    }

    public final int component1() {
        return this.orderId;
    }

    public final int component2() {
        return this.quantity;
    }

    public final double component3() {
        return this.total;
    }

    @NotNull
    public final String component4() {
        return this.orderDate;
    }

    @NotNull
    public final List<PreviousOrderItem> component5() {
        return this.items;
    }

    @NotNull
    public final PreviousOrder copy(int i11, int i12, double d11, @NotNull String str, @NotNull List<PreviousOrderItem> list) {
        Intrinsics.checkNotNullParameter(str, "orderDate");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new PreviousOrder(i11, i12, d11, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousOrder)) {
            return false;
        }
        PreviousOrder previousOrder = (PreviousOrder) obj;
        return this.orderId == previousOrder.orderId && this.quantity == previousOrder.quantity && Intrinsics.areEqual((Object) Double.valueOf(this.total), (Object) Double.valueOf(previousOrder.total)) && Intrinsics.areEqual((Object) this.orderDate, (Object) previousOrder.orderDate) && Intrinsics.areEqual((Object) this.items, (Object) previousOrder.items);
    }

    @NotNull
    public final String getFirstItemName() {
        if (hasItems()) {
            return this.items.get(0).itemName;
        }
        return "";
    }

    public final int getFirstItemQuantity() {
        if (hasItems()) {
            return this.items.get(0).quantity;
        }
        return 0;
    }

    public final int getMoreItemsCount() {
        if (hasMoreThanOneItem()) {
            return this.items.size() - 1;
        }
        return 0;
    }

    @NotNull
    public final String getOrderDate() {
        return this.orderDate;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final double getTotal() {
        return this.total;
    }

    public final boolean hasItems() {
        return !this.items.isEmpty();
    }

    public int hashCode() {
        return (((((((this.orderId * 31) + this.quantity) * 31) + Double.doubleToLongBits(this.total)) * 31) + this.orderDate.hashCode()) * 31) + this.items.hashCode();
    }

    public final void setOrderDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderDate = str;
    }

    public final void setQuantity(int i11) {
        this.quantity = i11;
    }

    public final void setTotal(double d11) {
        this.total = d11;
    }

    @NotNull
    public String toString() {
        int i11 = this.orderId;
        int i12 = this.quantity;
        double d11 = this.total;
        String str = this.orderDate;
        List<PreviousOrderItem> list = this.items;
        return "PreviousOrder(orderId=" + i11 + ", quantity=" + i12 + ", total=" + d11 + ", orderDate=" + str + ", items=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PreviousOrder(int r5, int r6, double r7, java.lang.String r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r6
        L_0x000e:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0014
            r7 = 0
        L_0x0014:
            r1 = r7
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001b
            java.lang.String r9 = ""
        L_0x001b:
            r3 = r9
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0025
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0025:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r0
            r8 = r1
            r10 = r3
            r5.<init>(r6, r7, r8, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.PreviousOrderList.PreviousOrder.<init>(int, int, double, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
