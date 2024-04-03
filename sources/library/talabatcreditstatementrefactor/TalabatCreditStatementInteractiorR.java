package library.talabatcreditstatementrefactor;

import JsonModels.TalabatCreditStatementResponseR;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import d20.a;
import d20.b;
import datamodels.TalabatCreditStatementR;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementInteractiorR;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementInteractorR;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "talabatCreditStatementListenerR", "Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementListenerR;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementListenerR;)V", "loadCreditStatementList", "", "onCreditStatementDetailsReceived", "Lcom/android/volley/Response$Listener;", "LJsonModels/TalabatCreditStatementResponseR;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "unregister", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementInteractiorR implements IGlobalInteractor, ITalabatCreditStatementInteractorR {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @Nullable
    private TalabatCreditStatementListenerR talabatCreditStatementListenerR;

    public TalabatCreditStatementInteractiorR(@NotNull AppVersionProvider appVersionProvider2, @NotNull TalabatCreditStatementListenerR talabatCreditStatementListenerR2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(talabatCreditStatementListenerR2, "talabatCreditStatementListenerR");
        this.appVersionProvider = appVersionProvider2;
        this.talabatCreditStatementListenerR = talabatCreditStatementListenerR2;
    }

    private final Response.Listener<TalabatCreditStatementResponseR> onCreditStatementDetailsReceived() {
        return new a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreditStatementDetailsReceived$lambda-0  reason: not valid java name */
    public static final void m7912onCreditStatementDetailsReceived$lambda0(TalabatCreditStatementInteractiorR talabatCreditStatementInteractiorR, TalabatCreditStatementResponseR talabatCreditStatementResponseR) {
        TalabatCreditStatementR[] talabatCreditStatementRArr;
        Intrinsics.checkNotNullParameter(talabatCreditStatementInteractiorR, "this$0");
        TalabatCreditStatementListenerR talabatCreditStatementListenerR2 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
        if (talabatCreditStatementListenerR2 != null) {
            if (talabatCreditStatementResponseR != null) {
                talabatCreditStatementRArr = talabatCreditStatementResponseR.getResult();
            } else {
                talabatCreditStatementRArr = null;
            }
            talabatCreditStatementListenerR2.onCreditStatmentDetailsDetailsReceived(talabatCreditStatementRArr);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-1  reason: not valid java name */
    public static final void m7913onRequestError$lambda1(TalabatCreditStatementInteractiorR talabatCreditStatementInteractiorR, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(talabatCreditStatementInteractiorR, "this$0");
        if (volleyError instanceof ServerError) {
            TalabatCreditStatementListenerR talabatCreditStatementListenerR2 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
            if (talabatCreditStatementListenerR2 != null) {
                talabatCreditStatementListenerR2.noTransactionFound();
            }
            TalabatCreditStatementListenerR talabatCreditStatementListenerR3 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
            if (talabatCreditStatementListenerR3 != null) {
                talabatCreditStatementListenerR3.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            TalabatCreditStatementListenerR talabatCreditStatementListenerR4 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
            if (talabatCreditStatementListenerR4 != null) {
                talabatCreditStatementListenerR4.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            TalabatCreditStatementListenerR talabatCreditStatementListenerR5 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
            if (talabatCreditStatementListenerR5 != null) {
                talabatCreditStatementListenerR5.noTransactionFound();
            }
            TalabatCreditStatementListenerR talabatCreditStatementListenerR6 = talabatCreditStatementInteractiorR.talabatCreditStatementListenerR;
            if (talabatCreditStatementListenerR6 != null) {
                talabatCreditStatementListenerR6.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    public void loadCreditStatementList() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_TALABATCREDIT_STATEMENT;
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        GsonRequest.Builder<TalabatCreditStatementResponseR> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", sb2.toString()})).setClazz(TalabatCreditStatementResponseR.class).setListener(onCreditStatementDetailsReceived()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    @NotNull
    public final Response.ErrorListener onRequestError() {
        return new b(this);
    }

    public void unregister() {
        this.talabatCreditStatementListenerR = null;
    }
}
