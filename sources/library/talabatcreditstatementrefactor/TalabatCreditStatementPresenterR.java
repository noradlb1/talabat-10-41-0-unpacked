package library.talabatcreditstatementrefactor;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import datamodels.TalabatCreditStatementR;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001d\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementPresenterR;", "Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementPresenterR;", "Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementListenerR;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "talabatCreditStatementView", "Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;)V", "talabatCreditStatementInteractorR", "Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementInteractorR;", "getTalabatCreditStatementInteractorR", "()Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementInteractorR;", "setTalabatCreditStatementInteractorR", "(Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementInteractorR;)V", "talabatCreditStatementViewR", "getTalabatCreditStatementViewR", "()Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;", "setTalabatCreditStatementViewR", "(Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;)V", "noTransactionFound", "", "onCreditStatmentDetailsDetailsReceived", "result", "", "Ldatamodels/TalabatCreditStatementR;", "([Ldatamodels/TalabatCreditStatementR;)V", "onDataError", "onDestroy", "onNetworkError", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "setUpViews", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementPresenterR implements ITalabatCreditStatementPresenterR, TalabatCreditStatementListenerR {
    @Nullable
    private ITalabatCreditStatementInteractorR talabatCreditStatementInteractorR;
    @Nullable
    private TalabatCreditStatementViewR talabatCreditStatementViewR;

    public TalabatCreditStatementPresenterR(@NotNull AppVersionProvider appVersionProvider, @NotNull TalabatCreditStatementViewR talabatCreditStatementViewR2) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(talabatCreditStatementViewR2, "talabatCreditStatementView");
        this.talabatCreditStatementInteractorR = new TalabatCreditStatementInteractiorR(appVersionProvider, this);
        this.talabatCreditStatementViewR = talabatCreditStatementViewR2;
    }

    @Nullable
    public final ITalabatCreditStatementInteractorR getTalabatCreditStatementInteractorR() {
        return this.talabatCreditStatementInteractorR;
    }

    @Nullable
    public final TalabatCreditStatementViewR getTalabatCreditStatementViewR() {
        return this.talabatCreditStatementViewR;
    }

    public void noTransactionFound() {
        TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
        if (talabatCreditStatementViewR2 != null) {
            talabatCreditStatementViewR2.noCreditStatementFound();
        }
    }

    public void onCreditStatmentDetailsDetailsReceived(@Nullable TalabatCreditStatementR[] talabatCreditStatementRArr) {
        if (talabatCreditStatementRArr == null) {
            TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
            if (talabatCreditStatementViewR2 != null) {
                talabatCreditStatementViewR2.noCreditStatementFound();
            }
        } else if (talabatCreditStatementRArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(Arrays.copyOf(talabatCreditStatementRArr, talabatCreditStatementRArr.length)));
            TalabatCreditStatementViewR talabatCreditStatementViewR3 = this.talabatCreditStatementViewR;
            if (talabatCreditStatementViewR3 != null) {
                talabatCreditStatementViewR3.loadCreditStatmentList(arrayList);
            }
        } else {
            TalabatCreditStatementViewR talabatCreditStatementViewR4 = this.talabatCreditStatementViewR;
            if (talabatCreditStatementViewR4 != null) {
                talabatCreditStatementViewR4.noCreditStatementFound();
            }
        }
    }

    public void onDataError() {
        TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
        if (talabatCreditStatementViewR2 != null) {
            talabatCreditStatementViewR2.onDataError();
        }
    }

    public void onDestroy() {
        this.talabatCreditStatementViewR = null;
        ITalabatCreditStatementInteractorR iTalabatCreditStatementInteractorR = this.talabatCreditStatementInteractorR;
        if (!(iTalabatCreditStatementInteractorR == null || iTalabatCreditStatementInteractorR == null)) {
            iTalabatCreditStatementInteractorR.unregister();
        }
        this.talabatCreditStatementInteractorR = null;
    }

    public void onNetworkError() {
        TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
        if (talabatCreditStatementViewR2 != null) {
            talabatCreditStatementViewR2.onNetworkError();
        }
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
        if (talabatCreditStatementViewR2 != null) {
            talabatCreditStatementViewR2.onServerError(volleyError);
        }
    }

    public final void setTalabatCreditStatementInteractorR(@Nullable ITalabatCreditStatementInteractorR iTalabatCreditStatementInteractorR) {
        this.talabatCreditStatementInteractorR = iTalabatCreditStatementInteractorR;
    }

    public final void setTalabatCreditStatementViewR(@Nullable TalabatCreditStatementViewR talabatCreditStatementViewR2) {
        this.talabatCreditStatementViewR = talabatCreditStatementViewR2;
    }

    public void setUpViews() {
        TalabatCreditStatementViewR talabatCreditStatementViewR2 = this.talabatCreditStatementViewR;
        if (talabatCreditStatementViewR2 != null) {
            talabatCreditStatementViewR2.showLoading();
        }
        ITalabatCreditStatementInteractorR iTalabatCreditStatementInteractorR = this.talabatCreditStatementInteractorR;
        if (iTalabatCreditStatementInteractorR != null) {
            iTalabatCreditStatementInteractorR.loadCreditStatementList();
        }
    }
}
