package com.instabug.survey.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ListUtils;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.common.models.a;
import com.instabug.survey.common.models.b;
import com.instabug.survey.common.models.c;
import com.instabug.survey.common.models.d;
import com.instabug.survey.common.models.e;
import com.instabug.survey.common.models.f;
import com.instabug.survey.common.models.g;
import com.instabug.survey.common.models.i;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Survey implements Cacheable, Serializable, e {
    private static final String HAS_RESPOND = "has_respond";
    private static final String KEY_ANSWERED = "answered";
    private static final String KEY_CONDITIONS_OPERATOR = "operator";
    private static final String KEY_CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String KEY_DISMISSED_AT = "dismissed_at";
    private static final String KEY_ID = "id";
    private static final String KEY_IS_CANCELLED = "is_cancelled";
    private static final String KEY_IS_DISMISSIBLE = "dismissible";
    private static final String KEY_IS_GOOGLE_PLAY_APP_RATING = "app_rating";
    private static final String KEY_PAUSED = "paused";
    private static final String KEY_PUBLISHED = "published";
    private static final String KEY_QUESTIONS = "questions";
    private static final String KEY_SESSION_COUNTER = "session_counter";
    private static final String KEY_SHOULD_SHOW_AGAIN = "should_show_again";
    private static final String KEY_SHOW_AT = "show_at";
    private static final String KEY_SURVEY_EVENTS = "events";
    private static final String KEY_SURVEY_STATE = "survey_state";
    private static final String KEY_TARGET = "target";
    private static final String KEY_TARGET_AUDIENCE = "primitive_types";
    private static final String KEY_THANKS_LIST = "thanks_list";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_TYPE = "type";
    private static final String KEY_USER_EVENTS = "user_events";
    private static final String KEY_WELCOME_SCREEN = "welcome_screen";

    /* renamed from: id  reason: collision with root package name */
    private long f52391id;
    private boolean isDismissible = true;
    private boolean isGooglePlayAppRating = false;
    private b localization = new b();
    private boolean paused = false;
    private ArrayList<b> questions = new ArrayList<>();
    private ArrayList<d> thankYouItems = new ArrayList<>();
    private String title = "";
    @Nullable
    private String token;
    private int type;
    private i userInteraction = new i(0);

    public static List<Survey> fromJson(@NonNull JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray(KEY_PUBLISHED);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            Survey survey = new Survey();
            survey.fromJson(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            arrayList.add(survey);
        }
        return arrayList;
    }

    @Nullable
    private String getCustomThankYouMessage() {
        d dVar;
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() <= 0 || (dVar = (d) ListUtils.safeGet(thankYouItems2, 0)) == null) {
            return null;
        }
        return dVar.b();
    }

    @Nullable
    private String getCustomThankYouTitle() {
        d dVar;
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() <= 0 || (dVar = (d) ListUtils.safeGet(thankYouItems2, 0)) == null) {
            return null;
        }
        return dVar.c();
    }

    private int getNPSAnswerValue() {
        String a11;
        try {
            b bVar = (b) ListUtils.safeGet(this.questions, 0);
            if (bVar == null || (a11 = bVar.a()) == null) {
                return 0;
            }
            return Integer.parseInt(a11);
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "NPS score parsing failed du to: " + e11.getMessage());
            return 0;
        }
    }

    @Nullable
    private String getNPSThankYouMessage() {
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() <= 0) {
            return null;
        }
        d dVar = (d) ListUtils.safeGet(thankYouItems2, 0);
        d dVar2 = (d) ListUtils.safeGet(thankYouItems2, 1);
        d dVar3 = (d) ListUtils.safeGet(thankYouItems2, 2);
        if (isPromoter() && dVar != null) {
            return dVar.b();
        }
        if (isPassive() && dVar2 != null) {
            return dVar2.b();
        }
        if (!isDetractor() || dVar3 == null) {
            return null;
        }
        return dVar3.b();
    }

    @Nullable
    private String getNPSThankYouTitle() {
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() <= 0) {
            return null;
        }
        d dVar = (d) ListUtils.safeGet(thankYouItems2, 0);
        d dVar2 = (d) ListUtils.safeGet(thankYouItems2, 1);
        d dVar3 = (d) ListUtils.safeGet(thankYouItems2, 2);
        if (isPromoter() && dVar != null) {
            return dVar.c();
        }
        if (isPassive() && dVar2 != null) {
            return dVar2.c();
        }
        if (!isDetractor() || dVar3 == null) {
            return null;
        }
        return dVar3.c();
    }

    public static List<Survey> getPausedSurveysFromJson(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("paused");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Survey survey = new Survey();
            survey.setId(jSONArray.getLong(i11));
            survey.setPaused(true);
            arrayList.add(survey);
        }
        return arrayList;
    }

    private boolean hasNPSSubmitted() {
        if (this.userInteraction.i().a() == null) {
            return false;
        }
        Iterator it = this.userInteraction.i().a().iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a() == a.C0096a.SUBMIT) {
                return true;
            }
        }
        return false;
    }

    private boolean isDetractor() {
        return getNPSAnswerValue() <= 6;
    }

    private boolean isPassive() {
        return getNPSAnswerValue() > 6 && getNPSAnswerValue() <= 8;
    }

    private boolean isPromoter() {
        return getNPSAnswerValue() > 8;
    }

    private void setSessionCounter(int i11) {
        this.userInteraction.c(i11);
    }

    public void addRateEvent() {
        this.userInteraction.i().a().add(new a(a.C0096a.RATE, TimeUtils.currentTimeSeconds(), getAttemptCount()));
    }

    public void addShowEvent() {
        this.userInteraction.b(TimeUtils.currentTimeSeconds());
        this.userInteraction.k();
        this.userInteraction.i().a().add(new a(a.C0096a.SHOW, this.userInteraction.f(), this.userInteraction.l()));
    }

    public void clearAnswers() {
        Iterator<b> it = this.questions.iterator();
        while (it.hasNext()) {
            it.next().a((String) null);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return obj != null && (obj instanceof Survey) && ((Survey) obj).getId() == getId();
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            setId(jSONObject.getLong("id"));
        }
        if (jSONObject.has("type")) {
            setType(jSONObject.getInt("type"));
        }
        if (jSONObject.has("title")) {
            setTitle(jSONObject.getString("title"));
        }
        if (jSONObject.has("token") && jSONObject.get("token") != JSONObject.NULL) {
            setToken(jSONObject.getString("token"));
        }
        if (jSONObject.has(KEY_SURVEY_EVENTS)) {
            this.userInteraction.i().a(a.a(jSONObject.getJSONArray(KEY_SURVEY_EVENTS)));
        }
        if (jSONObject.has("questions")) {
            setQuestions(b.a(jSONObject.getJSONArray("questions")));
        }
        if (jSONObject.has("target")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("target");
            this.userInteraction.i().fromJson((!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).replace("\\", ""));
        }
        if (jSONObject.has("answered")) {
            setAnswered(jSONObject.getBoolean("answered"));
        }
        if (jSONObject.has(KEY_IS_CANCELLED)) {
            setCancelled(jSONObject.getBoolean(KEY_IS_CANCELLED));
        }
        if (jSONObject.has(KEY_SURVEY_STATE)) {
            setSurveyState(f.valueOf(jSONObject.getString(KEY_SURVEY_STATE)));
        }
        if (jSONObject.has(KEY_SHOULD_SHOW_AGAIN)) {
            setShouldShowAgain(jSONObject.getBoolean(KEY_SHOULD_SHOW_AGAIN));
        }
        if (jSONObject.has(KEY_SESSION_COUNTER)) {
            setSessionCounter(jSONObject.getInt(KEY_SESSION_COUNTER));
        }
        if (jSONObject.has("dismissed_at")) {
            setDismissedAt((long) jSONObject.getInt("dismissed_at"));
        }
        if (jSONObject.has(KEY_SHOW_AT)) {
            setShowAt((long) jSONObject.getInt(KEY_SHOW_AT));
        }
        if (jSONObject.has("thanks_list")) {
            setThankYouItems(d.a(jSONObject.getJSONArray("thanks_list")));
        }
        if (jSONObject.has(KEY_IS_DISMISSIBLE)) {
            setDismissible(jSONObject.getBoolean(KEY_IS_DISMISSIBLE));
        }
        this.localization.a(jSONObject);
        setGooglePlayAppRating(jSONObject.optBoolean(KEY_IS_GOOGLE_PLAY_APP_RATING, false));
    }

    public int getAttemptCount() {
        return this.userInteraction.b();
    }

    public String getConditionsOperator() {
        return this.userInteraction.i().b();
    }

    public ArrayList<c> getCustomAttributes() {
        return this.userInteraction.i().c();
    }

    public long getDismissedAt() {
        return this.userInteraction.c();
    }

    public int getEventIndex() {
        return this.userInteraction.d();
    }

    public long getId() {
        return this.f52391id;
    }

    public b getLocalization() {
        return this.localization;
    }

    public ArrayList<b> getQuestions() {
        return this.questions;
    }

    @Nullable
    public String getRatingCTATitle() {
        if (!isAppStoreRatingEnabled()) {
            return null;
        }
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() <= 0) {
            return null;
        }
        d dVar = (d) ListUtils.safeGet(thankYouItems2, 0);
        d dVar2 = (d) ListUtils.safeGet(thankYouItems2, 1);
        if (isPromoter() && dVar != null) {
            return dVar.a();
        }
        if (!isPassive() || dVar2 == null) {
            return null;
        }
        return dVar2.a();
    }

    public long getRespondedAt() {
        if (isLastEventDismiss()) {
            return 0;
        }
        if (this.userInteraction.i().a() != null && this.userInteraction.i().a().size() > 0) {
            Iterator it = this.userInteraction.i().a().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.a() == a.C0096a.SUBMIT) {
                    return aVar.c();
                }
            }
        }
        if (getQuestions() != null && getQuestions().size() > 0) {
            for (int size = getQuestions().size() - 1; size >= 0; size--) {
                if (getQuestions().get(size).b() > 0) {
                    return getQuestions().get(size).b();
                }
            }
        }
        return 0;
    }

    @Nullable
    public b getSecondaryNegativeQuestion() {
        ArrayList<b> questions2;
        int i11;
        if (!isStoreRatingSurvey()) {
            return null;
        }
        if (isGooglePlayAppRating()) {
            questions2 = getQuestions();
            i11 = 1;
        } else {
            questions2 = getQuestions();
            i11 = 2;
        }
        return questions2.get(i11);
    }

    public int getSessionCounter() {
        return this.userInteraction.e();
    }

    public long getShownAt() {
        return this.userInteraction.f();
    }

    public ArrayList<a> getSurveyEvents() {
        return this.userInteraction.i().a();
    }

    public long getSurveyId() {
        return this.f52391id;
    }

    public f getSurveyState() {
        return this.userInteraction.h();
    }

    public g getTarget() {
        return this.userInteraction.i();
    }

    public ArrayList<c> getTargetAudiences() {
        return this.userInteraction.i().e();
    }

    public ArrayList<d> getThankYouItems() {
        return this.thankYouItems;
    }

    @Nullable
    public String getThankYouMessage() {
        return isNPSSurvey() ? getNPSThankYouMessage() : getCustomThankYouMessage();
    }

    @Nullable
    public String getThankYouTitle() {
        return isNPSSurvey() ? getNPSThankYouTitle() : getCustomThankYouTitle();
    }

    public String getTitle() {
        return this.title;
    }

    @Nullable
    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeAsString() {
        int i11 = this.type;
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? "" : "StoreRating" : "NPS" : TypedValues.Custom.NAME;
    }

    public ArrayList<c> getUserEvents() {
        return this.userInteraction.i().g();
    }

    public i getUserInteraction() {
        return this.userInteraction;
    }

    public boolean hasPositiveNpsAnswer() {
        return isNPSSurvey() && (isPromoter() || isPassive());
    }

    public int hashCode() {
        return String.valueOf(getId()).hashCode();
    }

    public void incrementSessionCount() {
        this.userInteraction.m();
    }

    public boolean isAnswered() {
        return this.userInteraction.o();
    }

    public boolean isAppStoreRatingEnabled() {
        ArrayList<d> thankYouItems2 = getThankYouItems();
        if (thankYouItems2.size() > 0) {
            d dVar = (d) ListUtils.safeGet(thankYouItems2, 0);
            d dVar2 = (d) ListUtils.safeGet(thankYouItems2, 1);
            if (isPromoter() && dVar != null) {
                return dVar.d();
            }
            if (isPassive() && dVar2 != null) {
                return dVar2.d();
            }
        }
        return false;
    }

    public boolean isCancelled() {
        return this.userInteraction.p();
    }

    public boolean isDismissible() {
        return this.isDismissible;
    }

    public boolean isGooglePlayAppRating() {
        return this.isGooglePlayAppRating;
    }

    public boolean isLastEventDismiss() {
        return this.userInteraction.i().a() != null && this.userInteraction.i().a().size() > 0 && ((a) this.userInteraction.i().a().get(this.userInteraction.i().a().size() - 1)).a() == a.C0096a.DISMISS;
    }

    public boolean isLastEventSubmit() {
        return this.userInteraction.i().a() != null && this.userInteraction.i().a().size() > 0 && ((a) this.userInteraction.i().a().get(this.userInteraction.i().a().size() - 1)).a() == a.C0096a.SUBMIT;
    }

    public boolean isNPSSurvey() {
        return getType() == 1;
    }

    public boolean isOptInSurvey() {
        return getToken() != null && !String.valueOf(getToken()).equals("null");
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean isStoreRatingSurvey() {
        return getType() == 2;
    }

    public void resetSessionsCounter() {
        this.userInteraction.c(0);
    }

    public void resetUserAnswers() {
        Iterator<b> it = this.questions.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public void resetUserInteractions() {
        g i11 = this.userInteraction.i();
        i11.a(new ArrayList());
        i iVar = new i(0);
        this.userInteraction = iVar;
        iVar.a(i11);
    }

    public void setAnswered(boolean z11) {
        this.userInteraction.b(z11);
    }

    public void setAttemptCount(int i11) {
        this.userInteraction.a(i11);
    }

    public void setCancelled(boolean z11) {
        this.userInteraction.c(z11);
    }

    public void setConditionsOperator(String str) {
        this.userInteraction.i().b(str);
    }

    public void setCustomAttributes(ArrayList<c> arrayList) {
        this.userInteraction.i().b((ArrayList) arrayList);
    }

    public void setDismissed() {
        setSurveyState(f.READY_TO_SEND);
        if (!isNPSSurvey() || !hasPositiveNpsAnswer() || !hasNPSSubmitted()) {
            setShouldShowAgain(isOptInSurvey() || this.userInteraction.c() == 0);
            this.userInteraction.a(TimeUtils.currentTimeSeconds());
            setCancelled(true);
            if (this.userInteraction.i().a().size() <= 0 || ((a) this.userInteraction.i().a().get(this.userInteraction.i().a().size() - 1)).a() != a.C0096a.DISMISS) {
                this.userInteraction.i().a().add(new a(a.C0096a.DISMISS, this.userInteraction.c(), getEventIndex()));
            }
        }
    }

    public void setDismissedAt(long j11) {
        this.userInteraction.a(j11);
    }

    public void setDismissible(boolean z11) {
        this.isDismissible = z11;
    }

    public void setEventIndex(int i11) {
        this.userInteraction.b(i11);
    }

    public void setGooglePlayAppRating(boolean z11) {
        this.isGooglePlayAppRating = z11;
    }

    public Survey setId(long j11) {
        this.f52391id = j11;
        return this;
    }

    public void setLocalization(b bVar) {
        this.localization = bVar;
    }

    public void setPaused(boolean z11) {
        this.paused = z11;
    }

    public void setQuestions(ArrayList<b> arrayList) {
        this.questions = arrayList;
    }

    public void setSessionCount(int i11) {
        this.userInteraction.c(i11);
    }

    public void setShouldShowAgain(boolean z11) {
        this.userInteraction.d(z11);
    }

    public void setShowAt(long j11) {
        this.userInteraction.b(j11);
    }

    public void setSubmitted() {
        a aVar;
        a.C0096a aVar2;
        setCancelled(false);
        setAnswered(true);
        if (!isNPSSurvey() || !isAnswered() || !hasNPSSubmitted() || !hasPositiveNpsAnswer()) {
            a aVar3 = new a(a.C0096a.SUBMIT, TimeUtils.currentTimeSeconds(), getEventIndex());
            if (isOptInSurvey()) {
                this.userInteraction.a(0);
            }
            aVar = aVar3;
        } else {
            aVar = new a(a.C0096a.RATE, TimeUtils.currentTimeSeconds(), getEventIndex());
        }
        setSurveyState(f.READY_TO_SEND);
        g i11 = this.userInteraction.i();
        if ((i11.a() == null || i11.a().size() <= 0 || ((a) i11.a().get(i11.a().size() - 1)).a() != (aVar2 = a.C0096a.SUBMIT) || aVar.a() != aVar2) && i11.a() != null) {
            i11.a().add(aVar);
        }
    }

    public void setSurveyEvents(ArrayList<a> arrayList) {
        this.userInteraction.i().a((ArrayList) arrayList);
    }

    public void setSurveyState(f fVar) {
        this.userInteraction.a(fVar);
    }

    public void setTarget(g gVar) {
        this.userInteraction.a(gVar);
    }

    public void setTargetAudiences(ArrayList<c> arrayList) {
        this.userInteraction.i().c(arrayList);
    }

    public void setThankYouItems(ArrayList<d> arrayList) {
        this.thankYouItems = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setToken(@Nullable String str) {
        this.token = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUserEvents(ArrayList<c> arrayList) {
        this.userInteraction.i().d(arrayList);
    }

    public void setUserInteraction(i iVar) {
        this.userInteraction = iVar;
    }

    public boolean shouldReshowAfterDismiss() {
        d d11 = getTarget().d();
        if (d11.d()) {
            return false;
        }
        return isLastEventDismiss() && (com.instabug.survey.utils.a.b(getShownAt()) >= d11.a());
    }

    public boolean shouldShow() {
        g i11 = this.userInteraction.i();
        boolean e11 = i11.d().e();
        boolean z11 = !this.userInteraction.n();
        boolean z12 = !i11.d().f();
        boolean z13 = com.instabug.survey.utils.a.b(getShownAt()) >= i11.d().b();
        if (e11 || z11) {
            return true;
        }
        return (z12 && z13) || shouldReshowAfterDismiss();
    }

    public boolean shouldShowAgain() {
        return this.userInteraction.q();
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("id", this.f52391id).put("type", this.type).put(KEY_IS_GOOGLE_PLAY_APP_RATING, this.isGooglePlayAppRating).put("title", (Object) this.title);
        String str = this.token;
        if (str == null) {
            str = "";
        }
        put.put("token", (Object) str).put("questions", (Object) b.b((ArrayList) this.questions)).put("target", (Object) g.a(this.userInteraction.i())).put(KEY_SURVEY_EVENTS, (Object) a.a(this.userInteraction.i().a())).put("answered", this.userInteraction.o()).put(KEY_SHOW_AT, this.userInteraction.f()).put("dismissed_at", getDismissedAt()).put(KEY_IS_CANCELLED, this.userInteraction.p()).put(KEY_SURVEY_STATE, (Object) getSurveyState().toString()).put(KEY_SHOULD_SHOW_AGAIN, shouldShowAgain()).put("thanks_list", (Object) d.a((ArrayList) this.thankYouItems)).put(KEY_SESSION_COUNTER, getSessionCounter());
        this.localization.b(jSONObject);
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        try {
            return toJson();
        } catch (JSONException e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("Survey", e11.getMessage(), e11);
            }
            return super.toString();
        }
    }
}
