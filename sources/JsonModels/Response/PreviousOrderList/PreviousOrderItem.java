package JsonModels.Response.PreviousOrderList;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 #2\u00020\u0001:\u0001#BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010 \u001a\u00020\u001eJ\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"LJsonModels/Response/PreviousOrderList/PreviousOrderItem;", "", "id", "", "itemName", "", "price", "", "orderItemDetailId", "choices", "", "LJsonModels/Response/PreviousOrderList/PreviousOrderItemChoice;", "quantity", "(ILjava/lang/String;DILjava/util/List;I)V", "getOrderItemDetailId", "()I", "setOrderItemDetailId", "(I)V", "getPrice", "()D", "setPrice", "(D)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasChoices", "hashCode", "toString", "Companion", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrderItem {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    @SerializedName("choices")
    @JvmField
    public List<PreviousOrderItemChoice> choices;
    @SerializedName("id")
    @JvmField

    /* renamed from: id  reason: collision with root package name */
    public int f478id;
    @SerializedName("itemName")
    @NotNull
    @JvmField
    public String itemName;
    @SerializedName("orderItemDetailId")
    private int orderItemDetailId;
    @SerializedName("price")
    private double price;
    @SerializedName("quantity")
    @JvmField
    public int quantity;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0007"}, d2 = {"LJsonModels/Response/PreviousOrderList/PreviousOrderItem$Companion;", "", "()V", "copyList", "", "LJsonModels/Response/PreviousOrderList/PreviousOrderItemChoice;", "previousOrderItemChoices", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final List<PreviousOrderItemChoice> copyList(@NotNull List<PreviousOrderItemChoice> list) {
            Intrinsics.checkNotNullParameter(list, "previousOrderItemChoices");
            ArrayList arrayList = new ArrayList();
            for (PreviousOrderItemChoice next : list) {
                PreviousOrderItemChoice previousOrderItemChoice = new PreviousOrderItemChoice(0, (String) null, 0.0d, 0, (List) null, 31, (DefaultConstructorMarker) null);
                previousOrderItemChoice.f479id = next.f479id;
                previousOrderItemChoice.setChoiceName(next.getChoiceName());
                previousOrderItemChoice.setChoices(next.getChoices());
                previousOrderItemChoice.setPrice(next.getPrice());
                previousOrderItemChoice.setQuantity(next.getQuantity());
                arrayList.add(previousOrderItemChoice);
            }
            return arrayList;
        }
    }

    public PreviousOrderItem() {
        this(0, (String) null, 0.0d, 0, (List) null, 0, 63, (DefaultConstructorMarker) null);
    }

    public PreviousOrderItem(int i11, @NotNull String str, double d11, int i12, @Nullable List<PreviousOrderItemChoice> list, int i13) {
        Intrinsics.checkNotNullParameter(str, "itemName");
        this.f478id = i11;
        this.itemName = str;
        this.price = d11;
        this.orderItemDetailId = i12;
        this.choices = list;
        this.quantity = i13;
    }

    public static /* synthetic */ PreviousOrderItem copy$default(PreviousOrderItem previousOrderItem, int i11, String str, double d11, int i12, List<PreviousOrderItemChoice> list, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = previousOrderItem.f478id;
        }
        if ((i14 & 2) != 0) {
            str = previousOrderItem.itemName;
        }
        String str2 = str;
        if ((i14 & 4) != 0) {
            d11 = previousOrderItem.price;
        }
        double d12 = d11;
        if ((i14 & 8) != 0) {
            i12 = previousOrderItem.orderItemDetailId;
        }
        int i15 = i12;
        if ((i14 & 16) != 0) {
            list = previousOrderItem.choices;
        }
        List<PreviousOrderItemChoice> list2 = list;
        if ((i14 & 32) != 0) {
            i13 = previousOrderItem.quantity;
        }
        return previousOrderItem.copy(i11, str2, d12, i15, list2, i13);
    }

    @JvmStatic
    @NotNull
    public static final List<PreviousOrderItemChoice> copyList(@NotNull List<PreviousOrderItemChoice> list) {
        return Companion.copyList(list);
    }

    public final int component1() {
        return this.f478id;
    }

    @NotNull
    public final String component2() {
        return this.itemName;
    }

    public final double component3() {
        return this.price;
    }

    public final int component4() {
        return this.orderItemDetailId;
    }

    @Nullable
    public final List<PreviousOrderItemChoice> component5() {
        return this.choices;
    }

    public final int component6() {
        return this.quantity;
    }

    @NotNull
    public final PreviousOrderItem copy(int i11, @NotNull String str, double d11, int i12, @Nullable List<PreviousOrderItemChoice> list, int i13) {
        Intrinsics.checkNotNullParameter(str, "itemName");
        return new PreviousOrderItem(i11, str, d11, i12, list, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousOrderItem)) {
            return false;
        }
        PreviousOrderItem previousOrderItem = (PreviousOrderItem) obj;
        return this.f478id == previousOrderItem.f478id && Intrinsics.areEqual((Object) this.itemName, (Object) previousOrderItem.itemName) && Intrinsics.areEqual((Object) Double.valueOf(this.price), (Object) Double.valueOf(previousOrderItem.price)) && this.orderItemDetailId == previousOrderItem.orderItemDetailId && Intrinsics.areEqual((Object) this.choices, (Object) previousOrderItem.choices) && this.quantity == previousOrderItem.quantity;
    }

    public final int getOrderItemDetailId() {
        return this.orderItemDetailId;
    }

    public final double getPrice() {
        return this.price;
    }

    public final boolean hasChoices() {
        List<PreviousOrderItemChoice> list = this.choices;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f478id * 31) + this.itemName.hashCode()) * 31) + Double.doubleToLongBits(this.price)) * 31) + this.orderItemDetailId) * 31;
        List<PreviousOrderItemChoice> list = this.choices;
        return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.quantity;
    }

    public final void setOrderItemDetailId(int i11) {
        this.orderItemDetailId = i11;
    }

    public final void setPrice(double d11) {
        this.price = d11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f478id;
        String str = this.itemName;
        double d11 = this.price;
        int i12 = this.orderItemDetailId;
        List<PreviousOrderItemChoice> list = this.choices;
        int i13 = this.quantity;
        return "PreviousOrderItem(id=" + i11 + ", itemName=" + str + ", price=" + d11 + ", orderItemDetailId=" + i12 + ", choices=" + list + ", quantity=" + i13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PreviousOrderItem(int r7, java.lang.String r8, double r9, int r11, java.util.List r12, int r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            java.lang.String r8 = ""
        L_0x000e:
            r1 = r8
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r9 = 0
        L_0x0015:
            r2 = r9
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r4 = r0
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0026
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x0026:
            r5 = r12
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002d
            r14 = r0
            goto L_0x002e
        L_0x002d:
            r14 = r13
        L_0x002e:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.PreviousOrderList.PreviousOrderItem.<init>(int, java.lang.String, double, int, java.util.List, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
