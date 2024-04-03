package tracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import tracking.perseus.TalabatPerseus;

@Instrumented
public class GoogleAdvertisingIdClientHelper {
    private static final String GOOGLEADVERTID = "googleadvertid";
    private static GoogleAdvertisingIdClientHelper googleAdvertisingIdClientHelper = new GoogleAdvertisingIdClientHelper();
    private String googleAdvertisingId = "";

    public static GoogleAdvertisingIdClientHelper getInstance() {
        return googleAdvertisingIdClientHelper;
    }

    /* access modifiers changed from: private */
    public void storeAdvertisingId(Context context, String str) {
        TalabatPerseus.setAdvertisingId(str);
        GlobalDataModel.googleAdId = str;
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putString(GOOGLEADVERTID, str);
        edit.apply();
        AppTracker.setGoogleAdvertId(context, str);
    }

    public void getAdvertisingId(final Context context) {
        AsyncTaskInstrumentation.execute(new TraceFieldInterface() {
            public Trace _nr_trace;

            public void _nr_setTrace(Trace trace) {
                try {
                    this._nr_trace = trace;
                } catch (Exception unused) {
                }
            }

            public String a(Void... voidArr) {
                AdvertisingIdClient.Info info;
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Exception unused) {
                    info = null;
                }
                if (info != null) {
                    return info.getId();
                }
                return null;
            }

            public void b(String str) {
                if (!TalabatUtils.isNullOrEmpty(str)) {
                    GoogleAdvertisingIdClientHelper.this.storeAdvertisingId(context, str);
                }
            }

            public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
                try {
                    TraceMachine.enterMethod(this._nr_trace, "GoogleAdvertisingIdClientHelper$1#doInBackground", (ArrayList<String>) null);
                } catch (NoSuchFieldError unused) {
                    TraceMachine.enterMethod((Trace) null, "GoogleAdvertisingIdClientHelper$1#doInBackground", (ArrayList<String>) null);
                }
                String a11 = a((Void[]) objArr);
                TraceMachine.exitMethod();
                return a11;
            }

            public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
                try {
                    TraceMachine.enterMethod(this._nr_trace, "GoogleAdvertisingIdClientHelper$1#onPostExecute", (ArrayList<String>) null);
                } catch (NoSuchFieldError unused) {
                    TraceMachine.enterMethod((Trace) null, "GoogleAdvertisingIdClientHelper$1#onPostExecute", (ArrayList<String>) null);
                }
                b((String) obj);
                TraceMachine.exitMethod();
            }
        }, new Void[0]);
    }

    public String googleAdvertId(Context context) {
        return context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getString(GOOGLEADVERTID, "");
    }
}
