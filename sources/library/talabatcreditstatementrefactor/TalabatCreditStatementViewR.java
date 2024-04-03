package library.talabatcreditstatementrefactor;

import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.TalabatCreditStatementR;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;", "Lcom/talabat/helpers/Talabat;", "getContext", "Landroid/content/Context;", "loadCreditStatmentList", "", "lstStatement", "Ljava/util/ArrayList;", "Ldatamodels/TalabatCreditStatementR;", "Lkotlin/collections/ArrayList;", "noCreditStatementFound", "showLoading", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatCreditStatementViewR extends Talabat {
    @NotNull
    Context getContext();

    void loadCreditStatmentList(@NotNull ArrayList<TalabatCreditStatementR> arrayList);

    void noCreditStatementFound();

    void showLoading();
}
