package d20;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabatcreditstatementrefactor.TalabatCreditStatementInteractiorR;

public final /* synthetic */ class b implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatCreditStatementInteractiorR f24318b;

    public /* synthetic */ b(TalabatCreditStatementInteractiorR talabatCreditStatementInteractiorR) {
        this.f24318b = talabatCreditStatementInteractiorR;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        TalabatCreditStatementInteractiorR.m7913onRequestError$lambda1(this.f24318b, volleyError);
    }
}
