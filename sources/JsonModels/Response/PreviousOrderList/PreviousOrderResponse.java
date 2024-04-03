package JsonModels.Response.PreviousOrderList;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.AppUrls;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\bHÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0015\u001a\u00020\u0013J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"LJsonModels/Response/PreviousOrderList/PreviousOrderResponse;", "", "branchId", "", "orders", "", "LJsonModels/Response/PreviousOrderList/PreviousOrder;", "message", "", "(ILjava/util/List;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hasPreviousOrders", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrderResponse {
    @JvmField
    public int branchId;
    @SerializedName("message")
    @NotNull
    private String message;
    @SerializedName("orders")
    @NotNull
    @JvmField
    public List<PreviousOrder> orders;

    public PreviousOrderResponse() {
        this(0, (List) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public PreviousOrderResponse(int i11, @NotNull List<PreviousOrder> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        Intrinsics.checkNotNullParameter(str, "message");
        this.branchId = i11;
        this.orders = list;
        this.message = str;
    }

    public static /* synthetic */ PreviousOrderResponse copy$default(PreviousOrderResponse previousOrderResponse, int i11, List<PreviousOrder> list, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = previousOrderResponse.branchId;
        }
        if ((i12 & 2) != 0) {
            list = previousOrderResponse.orders;
        }
        if ((i12 & 4) != 0) {
            str = previousOrderResponse.message;
        }
        return previousOrderResponse.copy(i11, list, str);
    }

    public final int component1() {
        return this.branchId;
    }

    @NotNull
    public final List<PreviousOrder> component2() {
        return this.orders;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final PreviousOrderResponse copy(int i11, @NotNull List<PreviousOrder> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        Intrinsics.checkNotNullParameter(str, "message");
        return new PreviousOrderResponse(i11, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousOrderResponse)) {
            return false;
        }
        PreviousOrderResponse previousOrderResponse = (PreviousOrderResponse) obj;
        return this.branchId == previousOrderResponse.branchId && Intrinsics.areEqual((Object) this.orders, (Object) previousOrderResponse.orders) && Intrinsics.areEqual((Object) this.message, (Object) previousOrderResponse.message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean hasPreviousOrders() {
        return !this.orders.isEmpty();
    }

    public int hashCode() {
        return (((this.branchId * 31) + this.orders.hashCode()) * 31) + this.message.hashCode();
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.branchId;
        List<PreviousOrder> list = this.orders;
        String str = this.message;
        return "PreviousOrderResponse(branchId=" + i11 + ", orders=" + list + ", message=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviousOrderResponse(int i11, List list, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? new ArrayList() : list, (i12 & 4) != 0 ? "" : str);
    }
}
