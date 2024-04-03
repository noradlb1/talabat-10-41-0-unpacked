package datamodels;

import androidx.annotation.NonNull;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B9\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB\u0005¢\u0006\u0002\u0010\fR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldatamodels/AppliedVoucher;", "", "voucherCode", "", "voucherDiscount", "", "isTalabatDeliveryVoucher", "", "isZeroVoucherApplied", "onlySupportsOnlinePayment", "mobileNumber", "(Ljava/lang/String;FZZZLjava/lang/String;)V", "()V", "getMobileNumber", "()Ljava/lang/String;", "setMobileNumber", "(Ljava/lang/String;)V", "getVoucherCode", "setVoucherCode", "getVoucherDiscount", "()F", "setVoucherDiscount", "(F)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppliedVoucher {
    @JvmField
    public boolean isTalabatDeliveryVoucher;
    @JvmField
    public boolean isZeroVoucherApplied;
    @NotNull
    private String mobileNumber;
    @JvmField
    public boolean onlySupportsOnlinePayment;
    @NotNull
    private String voucherCode;
    private float voucherDiscount;

    public AppliedVoucher() {
        this.voucherCode = "";
        this.mobileNumber = "";
    }

    @NotNull
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @NotNull
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    public final float getVoucherDiscount() {
        return this.voucherDiscount;
    }

    public final void setMobileNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mobileNumber = str;
    }

    public final void setVoucherCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.voucherCode = str;
    }

    public final void setVoucherDiscount(float f11) {
        this.voucherDiscount = f11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppliedVoucher(@NotNull @NonNull String str, float f11, boolean z11, boolean z12, boolean z13, @NotNull String str2) {
        this();
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Intrinsics.checkNotNullParameter(str2, "mobileNumber");
        this.voucherCode = str;
        this.voucherDiscount = f11;
        this.isTalabatDeliveryVoucher = z11;
        this.isZeroVoucherApplied = z12;
        this.onlySupportsOnlinePayment = z13;
        this.mobileNumber = str2;
    }
}
