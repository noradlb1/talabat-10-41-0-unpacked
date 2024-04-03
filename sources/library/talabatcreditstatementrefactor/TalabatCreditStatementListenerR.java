package library.talabatcreditstatementrefactor;

import datamodels.TalabatCreditStatementR;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001d\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementListenerR;", "Llibrary/talabat/mvp/IGlobalListener;", "noTransactionFound", "", "onCreditStatmentDetailsDetailsReceived", "result", "", "Ldatamodels/TalabatCreditStatementR;", "([Ldatamodels/TalabatCreditStatementR;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatCreditStatementListenerR extends IGlobalListener {
    void noTransactionFound();

    void onCreditStatmentDetailsDetailsReceived(@Nullable TalabatCreditStatementR[] talabatCreditStatementRArr);
}
