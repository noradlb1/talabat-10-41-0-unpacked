package com.instabug.survey.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.common.models.c;
import com.instabug.survey.common.models.f;
import com.instabug.survey.common.models.g;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.models.d;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

@Instrumented
public abstract class m {
    private static synchronized long a(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, long j11, ContentValues contentValues) {
        long update;
        synchronized (m.class) {
            String[] strArr = {String.valueOf(j11)};
            update = (long) (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.update(InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr));
            InstabugSDKLogger.d("IBG-Surveys", "survey with id: " + j11 + " has been updated");
        }
        return update;
    }

    @WorkerThread
    public static synchronized long a(Survey survey) {
        long insertWithOnConflict;
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("survey_id", Long.valueOf(survey.getId()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TYPE, Integer.valueOf(survey.getType()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_GOOGLE_PLAY_RATING, Boolean.valueOf(survey.isGooglePlayAppRating()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TITLE, survey.getTitle());
                if (survey.getToken() != null) {
                    contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TOKEN, survey.getToken());
                }
                contentValues.put("conditions_operator", survey.getConditionsOperator());
                contentValues.put("answered", Integer.valueOf(survey.isAnswered() ? 1 : 0));
                contentValues.put("dismissed_at", Long.valueOf(survey.getDismissedAt()));
                contentValues.put("shown_at", Long.valueOf(survey.getShownAt()));
                contentValues.put("isCancelled", Integer.valueOf(survey.isCancelled() ? 1 : 0));
                contentValues.put("attemptCount", Integer.valueOf(survey.getAttemptCount()));
                contentValues.put("eventIndex", Integer.valueOf(survey.getEventIndex()));
                contentValues.put("shouldShowAgain", Integer.valueOf(survey.shouldShowAgain() ? 1 : 0));
                contentValues.put("paused", Integer.valueOf(survey.isPaused() ? 1 : 0));
                contentValues.put("sessionCounter", Integer.valueOf(survey.getSessionCounter()));
                JSONArray b11 = b.b((ArrayList) survey.getQuestions());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS, !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11));
                JSONArray a11 = d.a((ArrayList) survey.getThankYouItems());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST, !(a11 instanceof JSONArray) ? a11.toString() : JSONArrayInstrumentation.toString(a11));
                JSONArray a12 = c.a((ArrayList) survey.getTargetAudiences());
                contentValues.put("targetAudiences", !(a12 instanceof JSONArray) ? a12.toString() : JSONArrayInstrumentation.toString(a12));
                JSONArray a13 = c.a((ArrayList) survey.getCustomAttributes());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_CUSTOM_ATTRIBUTES, !(a13 instanceof JSONArray) ? a13.toString() : JSONArrayInstrumentation.toString(a13));
                JSONArray a14 = c.a((ArrayList) survey.getUserEvents());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_USER_EVENTS, !(a14 instanceof JSONArray) ? a14.toString() : JSONArrayInstrumentation.toString(a14));
                contentValues.put("surveyState", survey.getSurveyState().toString());
                contentValues.put("surveyTargeting", survey.getTarget().toJson());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_SURVEY_TRIGGER_EVENT, survey.getTarget().f().b());
                contentValues.put("isLocalized", Boolean.valueOf(survey.getLocalization().c()));
                contentValues.put("supportedLocales", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) survey.getLocalization().b())));
                if (!(survey.getLocalization() == null || survey.getLocalization().a() == null)) {
                    contentValues.put("currentLocale", survey.getLocalization().a());
                }
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_SURVEY_IS_DISMISSIBLE, Integer.valueOf(survey.isDismissible() ? 1 : 0));
                insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.SurveyEntry.TABLE_NAME, (String) null, contentValues);
                if (insertWithOnConflict == -1) {
                    b(survey);
                }
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "survey id: " + survey.getId() + " has been added to DB");
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (JSONException e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "survey insertion failed due to " + e11.getMessage(), "IBG-Surveys");
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflict;
    }

    @WorkerThread
    public static synchronized long a(Survey survey, boolean z11, boolean z12) {
        long insertWithOnConflict;
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("survey_id", Long.valueOf(survey.getId()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TYPE, Integer.valueOf(survey.getType()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_GOOGLE_PLAY_RATING, Boolean.valueOf(survey.isGooglePlayAppRating()));
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TITLE, survey.getTitle());
                if (survey.getToken() != null) {
                    contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TOKEN, survey.getToken());
                }
                contentValues.put("conditions_operator", survey.getConditionsOperator());
                contentValues.put("answered", Integer.valueOf(survey.isAnswered() ? 1 : 0));
                contentValues.put("dismissed_at", Long.valueOf(survey.getDismissedAt()));
                contentValues.put("shown_at", Long.valueOf(survey.getShownAt()));
                contentValues.put("isCancelled", Integer.valueOf(survey.isCancelled() ? 1 : 0));
                contentValues.put("attemptCount", Integer.valueOf(survey.getAttemptCount()));
                contentValues.put("eventIndex", Integer.valueOf(survey.getEventIndex()));
                contentValues.put("shouldShowAgain", Integer.valueOf(survey.shouldShowAgain() ? 1 : 0));
                contentValues.put("paused", Integer.valueOf(survey.isPaused() ? 1 : 0));
                contentValues.put("sessionCounter", Integer.valueOf(survey.getSessionCounter()));
                JSONArray b11 = b.b((ArrayList) survey.getQuestions());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS, !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11));
                JSONArray a11 = d.a((ArrayList) survey.getThankYouItems());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST, !(a11 instanceof JSONArray) ? a11.toString() : JSONArrayInstrumentation.toString(a11));
                JSONArray a12 = c.a((ArrayList) survey.getTargetAudiences());
                contentValues.put("targetAudiences", !(a12 instanceof JSONArray) ? a12.toString() : JSONArrayInstrumentation.toString(a12));
                JSONArray a13 = c.a((ArrayList) survey.getCustomAttributes());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_CUSTOM_ATTRIBUTES, !(a13 instanceof JSONArray) ? a13.toString() : JSONArrayInstrumentation.toString(a13));
                JSONArray a14 = c.a((ArrayList) survey.getUserEvents());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_USER_EVENTS, !(a14 instanceof JSONArray) ? a14.toString() : JSONArrayInstrumentation.toString(a14));
                contentValues.put("surveyState", survey.getSurveyState().toString());
                contentValues.put("surveyTargeting", survey.getTarget().toJson());
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_SURVEY_TRIGGER_EVENT, survey.getTarget().f().b());
                contentValues.put("isLocalized", Boolean.valueOf(survey.getLocalization().c()));
                contentValues.put("supportedLocales", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) survey.getLocalization().b())));
                if (!(survey.getLocalization() == null || survey.getLocalization().a() == null)) {
                    contentValues.put("currentLocale", survey.getLocalization().a());
                }
                insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.SurveyEntry.TABLE_NAME, (String) null, contentValues);
                if (insertWithOnConflict == -1) {
                    if (z11) {
                        c(openDatabase, survey);
                    }
                    if (z12) {
                        a(openDatabase, survey);
                    }
                }
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "survey id: " + survey.getId() + " has been updated");
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "survey insertion failed due to " + e11.getMessage(), "IBG-Surveys");
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflict;
    }

    private static synchronized Survey a(Cursor cursor) {
        Survey survey;
        Cursor cursor2 = cursor;
        synchronized (m.class) {
            int columnIndex = cursor2.getColumnIndex("survey_id");
            int columnIndex2 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_TYPE);
            int columnIndex3 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_GOOGLE_PLAY_RATING);
            int columnIndex4 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_TITLE);
            int columnIndex5 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_TOKEN);
            int columnIndex6 = cursor2.getColumnIndex("conditions_operator");
            int columnIndex7 = cursor2.getColumnIndex("answered");
            int columnIndex8 = cursor2.getColumnIndex("dismissed_at");
            int columnIndex9 = cursor2.getColumnIndex("shown_at");
            int columnIndex10 = cursor2.getColumnIndex("isCancelled");
            int columnIndex11 = cursor2.getColumnIndex("attemptCount");
            int columnIndex12 = cursor2.getColumnIndex("eventIndex");
            int columnIndex13 = cursor2.getColumnIndex("shouldShowAgain");
            int columnIndex14 = cursor2.getColumnIndex("paused");
            int columnIndex15 = cursor2.getColumnIndex("sessionCounter");
            int columnIndex16 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS);
            int columnIndex17 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST);
            int columnIndex18 = cursor2.getColumnIndex("targetAudiences");
            int columnIndex19 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_CUSTOM_ATTRIBUTES);
            int columnIndex20 = cursor2.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_USER_EVENTS);
            int columnIndex21 = cursor2.getColumnIndex("surveyState");
            int columnIndex22 = cursor2.getColumnIndex("surveyTargeting");
            int columnIndex23 = cursor2.getColumnIndex("supportedLocales");
            int columnIndex24 = cursor2.getColumnIndex("isLocalized");
            int columnIndex25 = cursor2.getColumnIndex("currentLocale");
            Long valueOf = Long.valueOf(cursor2.getLong(columnIndex));
            int i11 = cursor2.getInt(columnIndex2);
            int i12 = cursor2.getInt(columnIndex3);
            String string = cursor2.getString(columnIndex4);
            String string2 = cursor2.getString(columnIndex5);
            String string3 = cursor2.getString(columnIndex6);
            int i13 = cursor2.getInt(columnIndex7);
            int i14 = cursor2.getInt(columnIndex8);
            int i15 = cursor2.getInt(columnIndex9);
            int i16 = cursor2.getInt(columnIndex10);
            int i17 = cursor2.getInt(columnIndex11);
            int i18 = cursor2.getInt(columnIndex12);
            int i19 = cursor2.getInt(columnIndex13);
            int i21 = cursor2.getInt(columnIndex14);
            int i22 = cursor2.getInt(columnIndex15);
            String string4 = cursor2.getString(columnIndex16);
            String string5 = cursor2.getString(columnIndex17);
            String string6 = cursor2.getString(columnIndex18);
            String string7 = cursor2.getString(columnIndex19);
            String string8 = cursor2.getString(columnIndex20);
            String string9 = cursor2.getString(columnIndex21);
            String string10 = cursor2.getString(columnIndex22);
            String string11 = cursor2.getString(columnIndex23);
            int i23 = cursor2.getInt(columnIndex24);
            String string12 = cursor2.getString(columnIndex25);
            survey = new Survey();
            int i24 = i23;
            String str = string12;
            survey.setId(valueOf.longValue());
            survey.setType(i11);
            boolean z11 = false;
            survey.setGooglePlayAppRating(i12 == 1);
            survey.setTitle(string);
            survey.setToken(string2);
            survey.setConditionsOperator(string3);
            survey.setAnswered(i13 == 1);
            survey.setDismissedAt((long) i14);
            survey.setShowAt((long) i15);
            survey.setCancelled(i16 == 1);
            survey.setAttemptCount(i17);
            survey.setEventIndex(i18);
            survey.setShouldShowAgain(i19 == 1);
            survey.setPaused(i21 == 1);
            survey.setSessionCount(i22);
            survey.setQuestions(b.a(new JSONArray(string4)));
            survey.setThankYouItems(d.a(new JSONArray(string5)));
            survey.setTargetAudiences(c.a(new JSONArray(string6)));
            survey.setCustomAttributes(c.a(new JSONArray(string7)));
            survey.setUserEvents(c.a(new JSONArray(string8)));
            survey.setSurveyState(f.valueOf(string9));
            survey.setTarget(g.a(string10));
            survey.getLocalization().a(new JSONArray(string11));
            survey.getLocalization().a(str);
            survey.getLocalization().a(i24 == 1);
            Cursor cursor3 = cursor;
            if (cursor3.getInt(cursor3.getColumnIndex(InstabugDbContract.SurveyEntry.COLUMN_SURVEY_IS_DISMISSIBLE)) == 1) {
                z11 = true;
            }
            survey.setDismissible(z11);
        }
        return survey;
    }

    public static List a() {
        ArrayList arrayList;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = null;
        try {
            cursor = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor == null) {
                ArrayList arrayList2 = new ArrayList();
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.close();
                return arrayList2;
            }
            if (cursor.moveToFirst() || cursor.isClosed()) {
                arrayList = new ArrayList();
                do {
                    arrayList.add(a(cursor));
                } while (cursor.moveToNext());
                InstabugSDKLogger.d("IBG-Surveys", arrayList.size() + " surveys have been retrieved from DB");
            } else {
                cursor.close();
                arrayList = new ArrayList();
            }
            cursor.close();
            openDatabase.close();
            return arrayList;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, " retrieve surveys failed: " + e11.getMessage(), "IBG-Surveys");
            ArrayList arrayList3 = new ArrayList();
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            return arrayList3;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            throw th2;
        }
    }

    public static List a(String str) {
        ArrayList arrayList;
        InstabugSDKLogger.d("IBG-Surveys", "Getting surveys by event: " + str);
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = null;
        try {
            String[] strArr = {str};
            cursor = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyTriggerEvent=?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyTriggerEvent=?", strArr, (String) null, (String) null, (String) null);
            if (cursor == null) {
                ArrayList arrayList2 = new ArrayList();
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.close();
                return arrayList2;
            }
            if (cursor.moveToFirst() || cursor.isClosed()) {
                arrayList = new ArrayList();
                do {
                    arrayList.add(a(cursor));
                } while (cursor.moveToNext());
                InstabugSDKLogger.d("IBG-Surveys", "Retrieved " + arrayList.size() + " unanswered surveys from DB");
            } else {
                cursor.close();
                arrayList = new ArrayList();
            }
            cursor.close();
            openDatabase.close();
            return arrayList;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, " retrieve surveys by trigger event failed: " + e11.getMessage(), "IBG-Surveys");
            ArrayList arrayList3 = new ArrayList();
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            return arrayList3;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            throw th2;
        }
    }

    @WorkerThread
    public static synchronized void a(long j11) {
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(j11)};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.SurveyEntry.TABLE_NAME, "survey_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, "survey_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    private static void a(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, Survey survey) {
        ContentValues contentValues = new ContentValues();
        JSONArray b11 = b.b((ArrayList) survey.getQuestions());
        contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS, !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11));
        JSONArray a11 = d.a((ArrayList) survey.getThankYouItems());
        contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST, !(a11 instanceof JSONArray) ? a11.toString() : JSONArrayInstrumentation.toString(a11));
        if (!(survey.getLocalization() == null || survey.getLocalization().a() == null)) {
            contentValues.put("currentLocale", survey.getLocalization().a());
        }
        a(sQLiteDatabaseWrapper, survey.getId(), contentValues);
    }

    @WorkerThread
    private static long b(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, Survey survey) {
        String[] strArr = {String.valueOf(survey.getId())};
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("survey_id", Long.valueOf(survey.getId()));
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TITLE, survey.getTitle());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TYPE, Integer.valueOf(survey.getType()));
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_GOOGLE_PLAY_RATING, Boolean.valueOf(survey.isGooglePlayAppRating()));
            if (survey.getToken() != null) {
                contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_TOKEN, survey.getToken());
            }
            contentValues.put("conditions_operator", survey.getConditionsOperator());
            contentValues.put("answered", Integer.valueOf(survey.isAnswered() ? 1 : 0));
            contentValues.put("dismissed_at", Long.valueOf(survey.getDismissedAt()));
            contentValues.put("shown_at", Long.valueOf(survey.getShownAt()));
            contentValues.put("isCancelled", Integer.valueOf(survey.isCancelled() ? 1 : 0));
            contentValues.put("attemptCount", Integer.valueOf(survey.getAttemptCount()));
            contentValues.put("eventIndex", Integer.valueOf(survey.getEventIndex()));
            contentValues.put("shouldShowAgain", Integer.valueOf(survey.shouldShowAgain() ? 1 : 0));
            contentValues.put("paused", Integer.valueOf(survey.isPaused() ? 1 : 0));
            contentValues.put("sessionCounter", Integer.valueOf(survey.getSessionCounter()));
            JSONArray b11 = b.b((ArrayList) survey.getQuestions());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS, !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11));
            JSONArray a11 = d.a((ArrayList) survey.getThankYouItems());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST, !(a11 instanceof JSONArray) ? a11.toString() : JSONArrayInstrumentation.toString(a11));
            JSONArray a12 = c.a((ArrayList) survey.getTargetAudiences());
            contentValues.put("targetAudiences", !(a12 instanceof JSONArray) ? a12.toString() : JSONArrayInstrumentation.toString(a12));
            JSONArray a13 = c.a((ArrayList) survey.getCustomAttributes());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_CUSTOM_ATTRIBUTES, !(a13 instanceof JSONArray) ? a13.toString() : JSONArrayInstrumentation.toString(a13));
            JSONArray a14 = c.a((ArrayList) survey.getUserEvents());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_USER_EVENTS, !(a14 instanceof JSONArray) ? a14.toString() : JSONArrayInstrumentation.toString(a14));
            contentValues.put("surveyState", survey.getSurveyState().toString());
            contentValues.put("surveyTargeting", survey.getTarget().toJson());
            contentValues.put(InstabugDbContract.SurveyEntry.COLUMN_SURVEY_TRIGGER_EVENT, survey.getTarget().f().b());
            contentValues.put("isLocalized", Boolean.valueOf(survey.getLocalization().c()));
            contentValues.put("supportedLocales", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) survey.getLocalization().b())));
            if (!(survey.getLocalization() == null || survey.getLocalization().a() == null)) {
                contentValues.put("currentLocale", survey.getLocalization().a());
            }
            long update = (long) (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.update(InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr));
            if (update > 0) {
                InstabugSDKLogger.d("IBG-Surveys", "survey with id: " + survey.getId() + " has been updated");
            }
            return update;
        } catch (JSONException e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, "survey updating failed due to " + e11.getMessage(), "IBG-Surveys");
            return -1;
        }
    }

    @WorkerThread
    public static synchronized long b(Survey survey) {
        long b11;
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                b11 = b(openDatabase, survey);
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return b11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0090=Splitter:B:32:0x0090, B:40:0x00b3=Splitter:B:40:0x00b3} */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.instabug.survey.models.Survey b(long r12) {
        /*
            java.lang.String r0 = "IBG-Surveys"
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            r10 = 0
            java.lang.String r3 = "surveys_table"
            r4 = 0
            java.lang.String r5 = "survey_id=? "
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            r13 = 0
            r6[r13] = r12     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r12 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            if (r12 != 0) goto L_0x002d
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            goto L_0x0034
        L_0x002d:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
            android.database.Cursor r12 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x00b1, Exception -> 0x008e, all -> 0x008c }
        L_0x0034:
            if (r12 != 0) goto L_0x003f
            if (r12 == 0) goto L_0x003b
            r12.close()
        L_0x003b:
            r1.close()
            return r10
        L_0x003f:
            boolean r13 = r12.moveToFirst()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            if (r13 != 0) goto L_0x0055
            boolean r13 = r12.isClosed()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            if (r13 != 0) goto L_0x0055
            r12.close()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            r12.close()
            r1.close()
            return r10
        L_0x0055:
            com.instabug.survey.models.Survey r13 = a((android.database.Cursor) r12)     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            r2.<init>()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            java.lang.String r3 = "survey with id: "
            r2.append(r3)     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            long r3 = r13.getId()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            r2.append(r3)     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            java.lang.String r3 = " has been retrieved from DB"
            r2.append(r3)     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            com.instabug.library.util.InstabugSDKLogger.d(r0, r2)     // Catch:{ JSONException -> 0x0087, Exception -> 0x0082, all -> 0x007e }
            r12.close()
            r1.close()
            return r13
        L_0x007e:
            r13 = move-exception
            r10 = r12
            r12 = r13
            goto L_0x00d7
        L_0x0082:
            r13 = move-exception
            r11 = r13
            r13 = r12
            r12 = r11
            goto L_0x0090
        L_0x0087:
            r13 = move-exception
            r11 = r13
            r13 = r12
            r12 = r11
            goto L_0x00b3
        L_0x008c:
            r12 = move-exception
            goto L_0x00d7
        L_0x008e:
            r12 = move-exception
            r13 = r10
        L_0x0090:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r2.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "retrieve survey by id failed: "
            r2.append(r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r12.getMessage()     // Catch:{ all -> 0x00d5 }
            r2.append(r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d5 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r12, r2, r0)     // Catch:{ all -> 0x00d5 }
            if (r13 == 0) goto L_0x00ad
            r13.close()
        L_0x00ad:
            r1.close()
            return r10
        L_0x00b1:
            r12 = move-exception
            r13 = r10
        L_0x00b3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r2.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "survey conversion failed due to "
            r2.append(r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r12.getMessage()     // Catch:{ all -> 0x00d5 }
            r2.append(r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d5 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r12, r2, r0)     // Catch:{ all -> 0x00d5 }
            if (r13 == 0) goto L_0x00d1
            r13.close()
        L_0x00d1:
            r1.close()
            return r10
        L_0x00d5:
            r12 = move-exception
            r10 = r13
        L_0x00d7:
            if (r10 == 0) goto L_0x00dc
            r10.close()
        L_0x00dc:
            r1.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.cache.m.b(long):com.instabug.survey.models.Survey");
    }

    @WorkerThread
    public static List b() {
        ArrayList arrayList;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = null;
        try {
            String[] strArr = {f.READY_TO_SEND.toString()};
            cursor = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyState=? ", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyState=? ", strArr, (String) null, (String) null, (String) null);
            if (cursor == null) {
                ArrayList arrayList2 = new ArrayList();
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.close();
                return arrayList2;
            }
            if (cursor.moveToFirst() || cursor.isClosed()) {
                arrayList = new ArrayList();
                do {
                    arrayList.add(a(cursor));
                } while (cursor.moveToNext());
                InstabugSDKLogger.d("IBG-Surveys", arrayList.size() + " surveys are ready to be sent");
            } else {
                cursor.close();
                arrayList = new ArrayList();
            }
            cursor.close();
            openDatabase.close();
            return arrayList;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, " retrieve ready to be send surveys failed: " + e11.getMessage(), "IBG-Surveys");
            ArrayList arrayList3 = new ArrayList();
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            return arrayList3;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            throw th2;
        }
    }

    @WorkerThread
    public static synchronized void b(List list) {
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b(openDatabase, (Survey) it.next());
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized long c(Survey survey) {
        long update;
        synchronized (m.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(survey.getId())};
            try {
                openDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("sessionCounter", Integer.valueOf(survey.getSessionCounter()));
                update = (long) (!(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, contentValues, "survey_id=? ", strArr));
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "survey with id: " + survey.getId() + " has been updated");
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return update;
    }

    public static List c() {
        ArrayList arrayList;
        InstabugSDKLogger.d("IBG-Surveys", "Getting time triggered surveys");
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = null;
        try {
            String[] strArr = {""};
            cursor = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyTriggerEvent=?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, (String[]) null, "surveyTriggerEvent=?", strArr, (String) null, (String) null, (String) null);
            if (cursor == null) {
                ArrayList arrayList2 = new ArrayList();
                if (cursor != null) {
                    cursor.close();
                }
                openDatabase.close();
                return arrayList2;
            }
            if (cursor.moveToFirst() || cursor.isClosed()) {
                arrayList = new ArrayList();
                do {
                    arrayList.add(a(cursor));
                } while (cursor.moveToNext());
                InstabugSDKLogger.d("IBG-Surveys", "Retrieved " + arrayList.size() + " unanswered surveys from DB");
            } else {
                cursor.close();
                arrayList = new ArrayList();
            }
            cursor.close();
            openDatabase.close();
            return arrayList;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, " retrieve time triggered surveys failed: " + e11.getMessage(), "IBG-Surveys");
            ArrayList arrayList3 = new ArrayList();
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            return arrayList3;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            throw th2;
        }
    }

    @WorkerThread
    private static void c(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, Survey survey) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("paused", Boolean.valueOf(survey.isPaused()));
        a(sQLiteDatabaseWrapper, survey.getId(), contentValues);
    }

    @WorkerThread
    private static void d(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, Survey survey) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("surveyTargeting", survey.getTarget().toJson());
        a(sQLiteDatabaseWrapper, survey.getId(), contentValues);
    }

    public static synchronized void d(@NonNull Survey survey) {
        synchronized (m.class) {
            try {
                d(DatabaseManager.getInstance().openDatabase(), survey);
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "survey insertion failed due to " + e11.getMessage(), "IBG-Surveys");
            }
        }
        return;
    }
}
