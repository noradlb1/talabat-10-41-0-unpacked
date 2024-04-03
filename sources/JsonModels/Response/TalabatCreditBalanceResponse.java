package JsonModels.Response;

import datamodels.TalabatCreditExpListBal;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LJsonModels/Response/TalabatCreditBalanceResponse;", "", "()V", "lstBalance", "", "Ldatamodels/TalabatCreditExpListBal;", "getLstBalance", "()[Ldatamodels/TalabatCreditExpListBal;", "setLstBalance", "([Ldatamodels/TalabatCreditExpListBal;)V", "[Ldatamodels/TalabatCreditExpListBal;", "totBalance", "", "getTotBalance", "()F", "setTotBalance", "(F)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditBalanceResponse {
    @Nullable
    private TalabatCreditExpListBal[] lstBalance;
    private float totBalance;

    @Nullable
    public final TalabatCreditExpListBal[] getLstBalance() {
        return this.lstBalance;
    }

    public final float getTotBalance() {
        return this.totBalance;
    }

    public final void setLstBalance(@Nullable TalabatCreditExpListBal[] talabatCreditExpListBalArr) {
        this.lstBalance = talabatCreditExpListBalArr;
    }

    public final void setTotBalance(float f11) {
        this.totBalance = f11;
    }
}
