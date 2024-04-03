package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"LJsonModels/Response/WalletCreditCardMetadataObject;", "", "totalRecords", "", "(Ljava/lang/Integer;)V", "getTotalRecords", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)LJsonModels/Response/WalletCreditCardMetadataObject;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardMetadataObject {
    @SerializedName("totalRecords")
    @Nullable
    private final Integer totalRecords;

    public WalletCreditCardMetadataObject(@Nullable Integer num) {
        this.totalRecords = num;
    }

    public static /* synthetic */ WalletCreditCardMetadataObject copy$default(WalletCreditCardMetadataObject walletCreditCardMetadataObject, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = walletCreditCardMetadataObject.totalRecords;
        }
        return walletCreditCardMetadataObject.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.totalRecords;
    }

    @NotNull
    public final WalletCreditCardMetadataObject copy(@Nullable Integer num) {
        return new WalletCreditCardMetadataObject(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCreditCardMetadataObject) && Intrinsics.areEqual((Object) this.totalRecords, (Object) ((WalletCreditCardMetadataObject) obj).totalRecords);
    }

    @Nullable
    public final Integer getTotalRecords() {
        return this.totalRecords;
    }

    public int hashCode() {
        Integer num = this.totalRecords;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        Integer num = this.totalRecords;
        return "WalletCreditCardMetadataObject(totalRecords=" + num + ")";
    }
}
