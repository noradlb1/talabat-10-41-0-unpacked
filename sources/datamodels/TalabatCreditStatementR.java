package datamodels;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldatamodels/TalabatCreditStatementR;", "Ldatamodels/TalabatCreditStatement;", "()V", "expiryDetails", "", "getExpiryDetails", "()Ljava/lang/String;", "setExpiryDetails", "(Ljava/lang/String;)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementR extends TalabatCreditStatement {
    @Nullable
    private String expiryDetails;

    @Nullable
    public final String getExpiryDetails() {
        return this.expiryDetails;
    }

    public final void setExpiryDetails(@Nullable String str) {
        this.expiryDetails = str;
    }
}
