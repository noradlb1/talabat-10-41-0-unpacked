package JsonModels.Response.PreviousOrderList;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0003JC\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010%\u001a\u00020#J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"LJsonModels/Response/PreviousOrderList/PreviousOrderItemChoice;", "", "id", "", "choiceName", "", "price", "", "quantity", "choices", "", "(ILjava/lang/String;DILjava/util/List;)V", "getChoiceName", "()Ljava/lang/String;", "setChoiceName", "(Ljava/lang/String;)V", "getChoices", "()Ljava/util/List;", "setChoices", "(Ljava/util/List;)V", "getPrice", "()D", "setPrice", "(D)V", "getQuantity", "()I", "setQuantity", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hasChoices", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrderItemChoice {
    @SerializedName("choiceName")
    @NotNull
    private String choiceName;
    @SerializedName("choices")
    @Nullable
    private List<PreviousOrderItemChoice> choices;
    @SerializedName("id")
    @JvmField

    /* renamed from: id  reason: collision with root package name */
    public int f479id;
    @SerializedName("price")
    private double price;
    @SerializedName("quantity")
    private int quantity;

    public PreviousOrderItemChoice() {
        this(0, (String) null, 0.0d, 0, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public PreviousOrderItemChoice(int i11, @NotNull String str, double d11, int i12, @Nullable List<PreviousOrderItemChoice> list) {
        Intrinsics.checkNotNullParameter(str, "choiceName");
        this.f479id = i11;
        this.choiceName = str;
        this.price = d11;
        this.quantity = i12;
        this.choices = list;
    }

    public static /* synthetic */ PreviousOrderItemChoice copy$default(PreviousOrderItemChoice previousOrderItemChoice, int i11, String str, double d11, int i12, List<PreviousOrderItemChoice> list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = previousOrderItemChoice.f479id;
        }
        if ((i13 & 2) != 0) {
            str = previousOrderItemChoice.choiceName;
        }
        String str2 = str;
        if ((i13 & 4) != 0) {
            d11 = previousOrderItemChoice.price;
        }
        double d12 = d11;
        if ((i13 & 8) != 0) {
            i12 = previousOrderItemChoice.quantity;
        }
        int i14 = i12;
        if ((i13 & 16) != 0) {
            list = previousOrderItemChoice.choices;
        }
        return previousOrderItemChoice.copy(i11, str2, d12, i14, list);
    }

    public final int component1() {
        return this.f479id;
    }

    @NotNull
    public final String component2() {
        return this.choiceName;
    }

    public final double component3() {
        return this.price;
    }

    public final int component4() {
        return this.quantity;
    }

    @Nullable
    public final List<PreviousOrderItemChoice> component5() {
        return this.choices;
    }

    @NotNull
    public final PreviousOrderItemChoice copy(int i11, @NotNull String str, double d11, int i12, @Nullable List<PreviousOrderItemChoice> list) {
        Intrinsics.checkNotNullParameter(str, "choiceName");
        return new PreviousOrderItemChoice(i11, str, d11, i12, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousOrderItemChoice)) {
            return false;
        }
        PreviousOrderItemChoice previousOrderItemChoice = (PreviousOrderItemChoice) obj;
        return this.f479id == previousOrderItemChoice.f479id && Intrinsics.areEqual((Object) this.choiceName, (Object) previousOrderItemChoice.choiceName) && Intrinsics.areEqual((Object) Double.valueOf(this.price), (Object) Double.valueOf(previousOrderItemChoice.price)) && this.quantity == previousOrderItemChoice.quantity && Intrinsics.areEqual((Object) this.choices, (Object) previousOrderItemChoice.choices);
    }

    @NotNull
    public final String getChoiceName() {
        return this.choiceName;
    }

    @Nullable
    public final List<PreviousOrderItemChoice> getChoices() {
        return this.choices;
    }

    public final double getPrice() {
        return this.price;
    }

    public final int getQuantity() {
        return this.quantity;
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
        int hashCode = ((((((this.f479id * 31) + this.choiceName.hashCode()) * 31) + Double.doubleToLongBits(this.price)) * 31) + this.quantity) * 31;
        List<PreviousOrderItemChoice> list = this.choices;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setChoiceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.choiceName = str;
    }

    public final void setChoices(@Nullable List<PreviousOrderItemChoice> list) {
        this.choices = list;
    }

    public final void setPrice(double d11) {
        this.price = d11;
    }

    public final void setQuantity(int i11) {
        this.quantity = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f479id;
        String str = this.choiceName;
        double d11 = this.price;
        int i12 = this.quantity;
        List<PreviousOrderItemChoice> list = this.choices;
        return "PreviousOrderItemChoice(id=" + i11 + ", choiceName=" + str + ", price=" + d11 + ", quantity=" + i12 + ", choices=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PreviousOrderItemChoice(int r5, java.lang.String r6, double r7, int r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
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
            if (r5 == 0) goto L_0x000e
            java.lang.String r6 = ""
        L_0x000e:
            r1 = r6
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            r7 = 0
        L_0x0015:
            r2 = r7
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r9
        L_0x001c:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0025
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0025:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.PreviousOrderList.PreviousOrderItemChoice.<init>(int, java.lang.String, double, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
