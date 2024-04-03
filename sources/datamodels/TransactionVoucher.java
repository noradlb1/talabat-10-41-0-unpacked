package datamodels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B1\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBC\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017¨\u0006,"}, d2 = {"Ldatamodels/TransactionVoucher;", "", "loyaltyVoucherType", "", "id", "loyaltyDiscount", "", "loyaltyApplicableCartItemIds", "Ljava/util/ArrayList;", "", "(Ljava/lang/String;Ljava/lang/String;FLjava/util/ArrayList;)V", "type", "appliedDiscount", "productIds", "voucherCode", "(Ljava/lang/String;Ljava/lang/String;FLjava/util/ArrayList;Ljava/lang/String;)V", "getAppliedDiscount", "()F", "setAppliedDiscount", "(F)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getProductIds", "()Ljava/util/ArrayList;", "setProductIds", "(Ljava/util/ArrayList;)V", "getType", "setType", "getVoucherCode", "setVoucherCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "logValues", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TransactionVoucher {
    private float appliedDiscount;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f13877id;
    @NotNull
    private ArrayList<Integer> productIds;
    @Nullable
    private String type;
    @Nullable
    private String voucherCode;

    public TransactionVoucher() {
        this((String) null, (String) null, 0.0f, (ArrayList) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public TransactionVoucher(@Nullable String str, @Nullable String str2, float f11, @NotNull ArrayList<Integer> arrayList, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(arrayList, "productIds");
        this.type = str;
        this.f13877id = str2;
        this.appliedDiscount = f11;
        this.productIds = arrayList;
        this.voucherCode = str3;
    }

    public static /* synthetic */ TransactionVoucher copy$default(TransactionVoucher transactionVoucher, String str, String str2, float f11, ArrayList<Integer> arrayList, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = transactionVoucher.type;
        }
        if ((i11 & 2) != 0) {
            str2 = transactionVoucher.f13877id;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            f11 = transactionVoucher.appliedDiscount;
        }
        float f12 = f11;
        if ((i11 & 8) != 0) {
            arrayList = transactionVoucher.productIds;
        }
        ArrayList<Integer> arrayList2 = arrayList;
        if ((i11 & 16) != 0) {
            str3 = transactionVoucher.voucherCode;
        }
        return transactionVoucher.copy(str, str4, f12, arrayList2, str3);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.f13877id;
    }

    public final float component3() {
        return this.appliedDiscount;
    }

    @NotNull
    public final ArrayList<Integer> component4() {
        return this.productIds;
    }

    @Nullable
    public final String component5() {
        return this.voucherCode;
    }

    @NotNull
    public final TransactionVoucher copy(@Nullable String str, @Nullable String str2, float f11, @NotNull ArrayList<Integer> arrayList, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(arrayList, "productIds");
        return new TransactionVoucher(str, str2, f11, arrayList, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionVoucher)) {
            return false;
        }
        TransactionVoucher transactionVoucher = (TransactionVoucher) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) transactionVoucher.type) && Intrinsics.areEqual((Object) this.f13877id, (Object) transactionVoucher.f13877id) && Intrinsics.areEqual((Object) Float.valueOf(this.appliedDiscount), (Object) Float.valueOf(transactionVoucher.appliedDiscount)) && Intrinsics.areEqual((Object) this.productIds, (Object) transactionVoucher.productIds) && Intrinsics.areEqual((Object) this.voucherCode, (Object) transactionVoucher.voucherCode);
    }

    public final float getAppliedDiscount() {
        return this.appliedDiscount;
    }

    @Nullable
    public final String getId() {
        return this.f13877id;
    }

    @NotNull
    public final ArrayList<Integer> getProductIds() {
        return this.productIds;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    public int hashCode() {
        String str = this.type;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f13877id;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Float.floatToIntBits(this.appliedDiscount)) * 31) + this.productIds.hashCode()) * 31;
        String str3 = this.voucherCode;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public final String logValues() {
        String str = this.f13877id;
        String str2 = this.type;
        float f11 = this.appliedDiscount;
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f11;
    }

    public final void setAppliedDiscount(float f11) {
        this.appliedDiscount = f11;
    }

    public final void setId(@Nullable String str) {
        this.f13877id = str;
    }

    public final void setProductIds(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.productIds = arrayList;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setVoucherCode(@Nullable String str) {
        this.voucherCode = str;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.f13877id;
        float f11 = this.appliedDiscount;
        ArrayList<Integer> arrayList = this.productIds;
        String str3 = this.voucherCode;
        return "TransactionVoucher(type=" + str + ", id=" + str2 + ", appliedDiscount=" + f11 + ", productIds=" + arrayList + ", voucherCode=" + str3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TransactionVoucher(java.lang.String r5, java.lang.String r6, float r7, java.util.ArrayList r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0014
            r7 = 0
        L_0x0014:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x001e:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0025
            r10 = r0
            goto L_0x0026
        L_0x0025:
            r10 = r9
        L_0x0026:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.TransactionVoucher.<init>(java.lang.String, java.lang.String, float, java.util.ArrayList, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransactionVoucher(@Nullable String str, @Nullable String str2, float f11, @NotNull ArrayList<Integer> arrayList) {
        this((String) null, (String) null, 0.0f, (ArrayList) null, (String) null, 31, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(arrayList, "loyaltyApplicableCartItemIds");
        this.type = str;
        this.f13877id = str2;
        this.appliedDiscount = f11;
        this.productIds = arrayList;
    }
}
