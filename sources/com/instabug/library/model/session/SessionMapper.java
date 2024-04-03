package com.instabug.library.model.session;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.e0;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.instabug.library.model.session.CoreSession;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class SessionMapper {
    private static final Object TAG = "SessionMapper";

    public class a implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionRemoteEntity f51580a;

        public a(SessionRemoteEntity sessionRemoteEntity) {
            this.f51580a = sessionRemoteEntity;
        }

        /* renamed from: a */
        public JSONObject execute() throws Exception {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : this.f51580a.getMap().entrySet()) {
                if (e0.c().g() || next.getKey() == null || !((String) next.getKey()).equals("stitched_session_lead")) {
                    jSONObject.put((String) next.getKey(), SessionMapper.extractJsonValue(next.getValue()));
                }
            }
            return jSONObject;
        }
    }

    public class b implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionsBatchDTO f51581a;

        public b(SessionsBatchDTO sessionsBatchDTO) {
            this.f51581a = sessionsBatchDTO;
        }

        /* renamed from: a */
        public JSONObject execute() throws Exception {
            JSONObject jSONObject = new JSONObject();
            String productionUsage = this.f51581a.getProductionUsage();
            if (productionUsage != null && !productionUsage.isEmpty()) {
                try {
                    jSONObject.put(InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE, (Object) new JSONObject(productionUsage));
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-Core", e11.getClass().getSimpleName(), e11);
                }
            }
            for (Map.Entry next : this.f51581a.getCommonKeys().entrySet()) {
                jSONObject.put((String) next.getKey(), SessionMapper.extractJsonValue(next.getValue()));
            }
            JSONArray jSONArray = new JSONArray();
            for (SessionRemoteEntity json : this.f51581a.getSessions()) {
                jSONArray.put((Object) SessionMapper.toJson(json));
            }
            jSONObject.put("sessions", (Object) jSONArray);
            return jSONObject;
        }
    }

    public class c implements ReturnableExecutable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f51582a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request.Builder f51583b;

        public c(JSONObject jSONObject, Request.Builder builder) {
            this.f51582a = jSONObject;
            this.f51583b = builder;
        }

        /* renamed from: a */
        public Request execute() throws Exception {
            Iterator<String> keys = this.f51582a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f51583b.addParameter(new RequestParameter(next, this.f51582a.get(next)));
            }
            return this.f51583b.build();
        }
    }

    private SessionMapper() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        return new org.json.JSONArray(r2.toString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object extractJsonValue(java.lang.Object r2) {
        /*
            if (r2 == 0) goto L_0x002f
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "{"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "["
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x002f
        L_0x001b:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0025 }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0025 }
            r0.<init>((java.lang.String) r1)     // Catch:{ JSONException -> 0x0025 }
            return r0
        L_0x0025:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x002f }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x002f }
            r0.<init>((java.lang.String) r1)     // Catch:{ JSONException -> 0x002f }
            return r0
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.session.SessionMapper.extractJsonValue(java.lang.Object):java.lang.Object");
    }

    @NonNull
    public static ContentValues toContentValues(SessionLocalEntity sessionLocalEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", sessionLocalEntity.getId());
        contentValues.put("started_at", Long.valueOf(sessionLocalEntity.getStartTimestampMicros()));
        contentValues.put("duration", Long.valueOf(sessionLocalEntity.getDuration()));
        contentValues.put("user_attributes", sessionLocalEntity.getUserEvents());
        contentValues.put("user_events", sessionLocalEntity.getCustomAttributes());
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_EVENTS_KEYS, sessionLocalEntity.getUserEventsKeys());
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_ATTRIBUTES_KEYS, sessionLocalEntity.getCustomAttributesKeys());
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL, sessionLocalEntity.getUserEmail());
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_NAME, sessionLocalEntity.getUserName());
        contentValues.put("uuid", sessionLocalEntity.getUuid());
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, sessionLocalEntity.getAppToken());
        contentValues.put("os", sessionLocalEntity.getOs());
        contentValues.put("device", sessionLocalEntity.getDevice());
        contentValues.put("sdk_version", sessionLocalEntity.getSdkVersion());
        contentValues.put("app_version", sessionLocalEntity.getAppVersion());
        contentValues.put("crash_reporting_enabled", Integer.valueOf(sessionLocalEntity.isCrashReportingEnabled() ? 1 : 0));
        contentValues.put(InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED, Integer.valueOf(sessionLocalEntity.isUsersPageEnabled() ? 1 : 0));
        contentValues.put("sync_status", Integer.valueOf(sessionLocalEntity.getSyncStatus()));
        contentValues.put("stitched_session_lead", Integer.valueOf(sessionLocalEntity.isStitchedSessionLead() ? 1 : 0));
        String productionUsage = sessionLocalEntity.getProductionUsage();
        if (productionUsage != null) {
            contentValues.put(InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE, productionUsage);
        }
        return contentValues;
    }

    @NonNull
    public static SessionsBatchDTO toDTO(@NonNull SessionRemoteEntity sessionRemoteEntity) {
        return toDTO(Collections.emptyMap(), Collections.singletonList(sessionRemoteEntity));
    }

    @NonNull
    public static List<String> toIDs(@NonNull SessionsBatchDTO sessionsBatchDTO) {
        ArrayList arrayList = new ArrayList();
        for (SessionRemoteEntity id2 : sessionsBatchDTO.getSessions()) {
            arrayList.add(id2.getId());
        }
        return arrayList;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static JSONObject toJson(@NonNull SessionRemoteEntity sessionRemoteEntity) {
        return (JSONObject) new ExceptionHandler().withPenaltyLog().executeAndGet(new a(sessionRemoteEntity), new JSONObject());
    }

    @NonNull
    public static SessionLocalEntity toLocalEntity(ContentValues contentValues) {
        boolean z11;
        boolean z12;
        boolean z13;
        ContentValues contentValues2 = contentValues;
        String asString = contentValues2.getAsString("session_id");
        String asString2 = contentValues2.getAsString("os");
        String asString3 = contentValues2.getAsString("device");
        long longValue = contentValues2.getAsLong("duration").longValue();
        long longValue2 = contentValues2.getAsLong("started_at").longValue();
        String asString4 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_USER_NAME);
        String asString5 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL);
        String asString6 = contentValues2.getAsString("sdk_version");
        String asString7 = contentValues2.getAsString("app_version");
        String asString8 = contentValues2.getAsString("user_attributes");
        String asString9 = contentValues2.getAsString("user_events");
        String asString10 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_USER_EVENTS_KEYS);
        String asString11 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_USER_ATTRIBUTES_KEYS);
        String str = asString10;
        if (contentValues2.getAsInteger("crash_reporting_enabled").intValue() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int intValue = contentValues2.getAsInteger("sync_status").intValue();
        String asString12 = contentValues2.getAsString("uuid");
        String asString13 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN);
        if (contentValues2.getAsInteger(InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED).intValue() == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        String asString14 = contentValues2.getAsString(InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE);
        if (contentValues2.getAsInteger("stitched_session_lead").intValue() == 1) {
            z13 = true;
        } else {
            z13 = false;
        }
        return new SessionLocalEntity(asString, asString2, asString3, longValue, longValue2, asString4, asString5, asString6, asString7, asString8, asString9, str, asString11, z11, intValue, asString12, asString13, z12, asString14, z13);
    }

    @NonNull
    public static CoreSession toModel(@NonNull SessionLocalEntity sessionLocalEntity) {
        String str;
        String str2;
        CoreSession.Builder appVersion = new CoreSession.Builder(sessionLocalEntity.getId(), sessionLocalEntity.getUuid(), sessionLocalEntity.getOs()).setDevice(sessionLocalEntity.getDevice()).setDuration(sessionLocalEntity.getDuration()).setStartTimestampMicros(sessionLocalEntity.getStartTimestampMicros()).setUserName(sessionLocalEntity.getUserName()).setUserEmail(sessionLocalEntity.getUserEmail()).setSdkVersion(sessionLocalEntity.getSdkVersion()).setAppVersion(sessionLocalEntity.getAppVersion());
        if (sessionLocalEntity.isUsersPageEnabled()) {
            str = sessionLocalEntity.getUserEvents();
        } else {
            str = sessionLocalEntity.getUserEventsKeys();
        }
        CoreSession.Builder userEvents = appVersion.setUserEvents(str);
        if (sessionLocalEntity.isUsersPageEnabled()) {
            str2 = sessionLocalEntity.getCustomAttributes();
        } else {
            str2 = sessionLocalEntity.getCustomAttributesKeys();
        }
        return userEvents.setCustomAttributes(str2).setCrashReportingEnabled(sessionLocalEntity.isCrashReportingEnabled()).setSyncStatus(sessionLocalEntity.getSyncStatus()).setAppToken(sessionLocalEntity.getAppToken()).setUsersPageEnabled(sessionLocalEntity.isUsersPageEnabled()).setProductionUsage(sessionLocalEntity.getProductionUsage()).setIsStitchedSessionLead(sessionLocalEntity.isStitchedSessionLead()).build();
    }

    @NonNull
    public static List<CoreSession> toModels(@NonNull List<SessionLocalEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (SessionLocalEntity model : list) {
            arrayList.add(toModel(model));
        }
        return arrayList;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public static SessionRemoteEntity toRemoteEntity(@NonNull CoreSession coreSession) {
        HashMap hashMap = new HashMap();
        hashMap.put("os", coreSession.getOs());
        hashMap.put("device", coreSession.getDevice());
        hashMap.put("duration", Long.valueOf(coreSession.getDuration()));
        hashMap.put("started_at", Long.valueOf(coreSession.getStartTimestampMicros()));
        hashMap.put("name", coreSession.getUserName());
        hashMap.put("email", coreSession.getUserEmail());
        hashMap.put("sdk_version", coreSession.getSdkVersion());
        hashMap.put("app_version", coreSession.getAppVersion());
        hashMap.put(coreSession.isUsersPageEnabled() ? "user_events" : SessionParameter.USER_EVENTS_KEYS, coreSession.getUserEvents());
        hashMap.put(coreSession.isUsersPageEnabled() ? SessionParameter.CUSTOM_ATTRIBUTES : SessionParameter.CUSTOM_ATTRIBUTES_KEYS, coreSession.getCustomAttributes());
        hashMap.put("crash_reporting_enabled", Boolean.valueOf(coreSession.isCrashReportingEnabled()));
        hashMap.put("uuid", coreSession.getUuid());
        hashMap.put(SessionParameter.APP_TOKEN, coreSession.getAppToken());
        hashMap.put("stitched_session_lead", Boolean.valueOf(coreSession.isStitchedSessionLead()));
        return toRemoteEntity(coreSession.getId(), hashMap);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static Request toRequest(@NonNull JSONObject jSONObject) {
        Request.Builder method = new Request.Builder().endpoint(Endpoints.SEND_SESSION).method("POST");
        return (Request) new ExceptionHandler().withPenaltyLog().executeAndGet(new c(jSONObject, method), method.build());
    }

    @NonNull
    public static CoreSession toSession(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, long j11, long j12, boolean z11) {
        return new CoreSession.Builder(str, str3, str2).setAppVersion(str4).setStartTimestampMicros(j11).setStartNanoTime(j12).setIsStitchedSessionLead(z11).build();
    }

    @NonNull
    public static SessionsBatchDTO toDTO(@NonNull Map<String, Object> map, @NonNull List<SessionRemoteEntity> list) {
        return new SessionsBatchDTO(map, list);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @NonNull
    public static JSONObject toJson(@NonNull SessionsBatchDTO sessionsBatchDTO) {
        return (JSONObject) new ExceptionHandler().withPenaltyLog().executeAndGet(new b(sessionsBatchDTO), new JSONObject());
    }

    @NonNull
    public static SessionRemoteEntity toRemoteEntity(String str, @NonNull Map<String, Object> map) {
        return new SessionRemoteEntity(str, map);
    }
}
