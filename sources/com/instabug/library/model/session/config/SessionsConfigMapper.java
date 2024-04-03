package com.instabug.library.model.session.config;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

public class SessionsConfigMapper {
    private static final String TAG = "SessionsConfigMapper";

    public class a implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51585a;

        public a(String str) {
            this.f51585a = str;
        }

        /* renamed from: a */
        public SessionsConfig execute() throws Exception {
            return SessionsConfigMapper.map(new JSONObject(this.f51585a));
        }
    }

    public class b implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f51586a;

        public b(JSONObject jSONObject) {
            this.f51586a = jSONObject;
        }

        /* renamed from: a */
        public SessionsConfig execute() {
            return new SessionsConfig(this.f51586a.optInt(SessionsConfigParameter.SYNC_INTERVAL, 720), this.f51586a.optInt(SessionsConfigParameter.MAX_SESSIONS_PER_REQUEST, 10), this.f51586a.optInt(SessionsConfigParameter.SYNC_MODE, 2));
        }
    }

    @Instrumented
    public class c implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionsConfig f51587a;

        public c(SessionsConfig sessionsConfig) {
            this.f51587a = sessionsConfig;
        }

        /* renamed from: a */
        public String execute() throws Exception {
            int syncIntervalsInMinutes = this.f51587a.getSyncIntervalsInMinutes();
            int maxSessionsPerRequest = this.f51587a.getMaxSessionsPerRequest();
            int syncMode = this.f51587a.getSyncMode();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SessionsConfigParameter.SYNC_INTERVAL, syncIntervalsInMinutes);
            jSONObject.put(SessionsConfigParameter.MAX_SESSIONS_PER_REQUEST, maxSessionsPerRequest);
            jSONObject.put(SessionsConfigParameter.SYNC_MODE, syncMode);
            return JSONObjectInstrumentation.toString(jSONObject);
        }
    }

    private SessionsConfigMapper() {
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static SessionsConfig map(@NonNull String str) {
        return (SessionsConfig) new ExceptionHandler().withPenaltyLog(TAG).executeAndGet(new a(str), SessionsConfig.a());
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static SessionsConfig map(@NonNull JSONObject jSONObject) {
        return (SessionsConfig) new ExceptionHandler().withPenaltyLog(TAG).executeAndGet(new b(jSONObject), SessionsConfig.a());
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static String map(@NonNull SessionsConfig sessionsConfig) {
        return (String) new ExceptionHandler().withPenaltyLog(TAG).executeAndGet(new c(sessionsConfig), "{}");
    }
}
