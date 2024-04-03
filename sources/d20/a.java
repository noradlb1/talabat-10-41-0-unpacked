package d20;

import JsonModels.TalabatCreditStatementResponseR;
import com.android.volley.Response;
import library.talabatcreditstatementrefactor.TalabatCreditStatementInteractiorR;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatCreditStatementInteractiorR f24317b;

    public /* synthetic */ a(TalabatCreditStatementInteractiorR talabatCreditStatementInteractiorR) {
        this.f24317b = talabatCreditStatementInteractiorR;
    }

    public final void onResponse(Object obj) {
        TalabatCreditStatementInteractiorR.m7912onCreditStatementDetailsReceived$lambda0(this.f24317b, (TalabatCreditStatementResponseR) obj);
    }
}
