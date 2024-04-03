package datamodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B7\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006\u001d"}, d2 = {"Ldatamodels/TalabatCreditExpListBal;", "", "balance", "", "expiryDate", "", "expiryDateStr", "expiryText", "expiryDays", "", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBalance", "()Ljava/lang/Float;", "setBalance", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getExpiryDate", "()Ljava/lang/String;", "setExpiryDate", "(Ljava/lang/String;)V", "getExpiryDateStr", "setExpiryDateStr", "getExpiryDays", "()Ljava/lang/Integer;", "setExpiryDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExpiryText", "setExpiryText", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditExpListBal {
    @Nullable
    private Float balance;
    @Nullable
    private String expiryDate;
    @Nullable
    private String expiryDateStr;
    @Nullable
    private Integer expiryDays;
    @Nullable
    private String expiryText;

    public TalabatCreditExpListBal(@Nullable Float f11, @Nullable String str, @Nullable String str2, @NotNull String str3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str3, "expiryText");
        this.balance = f11;
        this.expiryDate = str;
        this.expiryDateStr = str2;
        this.expiryText = str3;
        this.expiryDays = num;
    }

    @Nullable
    public final Float getBalance() {
        return this.balance;
    }

    @Nullable
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @Nullable
    public final String getExpiryDateStr() {
        return this.expiryDateStr;
    }

    @Nullable
    public final Integer getExpiryDays() {
        return this.expiryDays;
    }

    @Nullable
    public final String getExpiryText() {
        return this.expiryText;
    }

    public final void setBalance(@Nullable Float f11) {
        this.balance = f11;
    }

    public final void setExpiryDate(@Nullable String str) {
        this.expiryDate = str;
    }

    public final void setExpiryDateStr(@Nullable String str) {
        this.expiryDateStr = str;
    }

    public final void setExpiryDays(@Nullable Integer num) {
        this.expiryDays = num;
    }

    public final void setExpiryText(@Nullable String str) {
        this.expiryText = str;
    }
}
