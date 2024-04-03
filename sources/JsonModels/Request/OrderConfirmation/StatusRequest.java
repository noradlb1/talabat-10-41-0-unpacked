package JsonModels.Request.OrderConfirmation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"LJsonModels/Request/OrderConfirmation/StatusRequest;", "", "()V", "encryptedOrderId", "", "getEncryptedOrderId", "()Ljava/lang/String;", "setEncryptedOrderId", "(Ljava/lang/String;)V", "encryptedTransactionId", "getEncryptedTransactionId", "setEncryptedTransactionId", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StatusRequest {
    @SerializedName("orderId")
    @Nullable
    private String encryptedOrderId = "";
    @SerializedName("transId")
    @Nullable
    private String encryptedTransactionId = "";

    @Nullable
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @Nullable
    public final String getEncryptedTransactionId() {
        return this.encryptedTransactionId;
    }

    public final void setEncryptedOrderId(@Nullable String str) {
        this.encryptedOrderId = str;
    }

    public final void setEncryptedTransactionId(@Nullable String str) {
        this.encryptedTransactionId = str;
    }
}
