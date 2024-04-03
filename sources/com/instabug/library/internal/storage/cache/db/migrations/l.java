package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class l implements c {
    @VisibleForTesting
    public String a() {
        return "survey_id,survey_type,survey_title,survey_token,conditions_operator,answered,dismissed_at,shown_at,isCancelled,attemptCount,eventIndex,shouldShowAgain,paused,sessionCounter,questions,thanks_list,targetAudiences,customAttributes,userEvents,surveyState,surveyTargeting,surveyTriggerEvent,isLocalized,supportedLocales,currentLocale";
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "surveys_table_temp");
        a(sQLiteDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME, "surveys_table_temp", a());
        b(sQLiteDatabase, InstabugDbContract.SurveyEntry.TABLE_NAME);
        a(sQLiteDatabase, "surveys_table_temp", InstabugDbContract.SurveyEntry.TABLE_NAME);
    }

    @VisibleForTesting
    public void b(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "DROP TABLE IF EXISTS " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    @VisibleForTesting
    public void a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str) {
        String str2 = "CREATE TABLE IF NOT EXISTS " + str + " ( " + "survey_id" + " INTEGER" + " PRIMARY KEY" + "," + InstabugDbContract.SurveyEntry.COLUMN_TYPE + " INTEGER" + "," + InstabugDbContract.SurveyEntry.COLUMN_GOOGLE_PLAY_RATING + " INTEGER" + " DEFAULT " + "0 " + "," + InstabugDbContract.SurveyEntry.COLUMN_TITLE + " TEXT" + "," + InstabugDbContract.SurveyEntry.COLUMN_TOKEN + " TEXT" + "," + "conditions_operator" + " TEXT" + "," + "answered" + " INTEGER" + "," + "dismissed_at" + " INTEGER" + "," + "shown_at" + " INTEGER" + "," + "isCancelled" + " INTEGER" + "," + "attemptCount" + " INTEGER" + "," + "eventIndex" + " INTEGER" + "," + "shouldShowAgain" + " INTEGER" + "," + "paused" + " INTEGER" + "," + "sessionCounter" + " INTEGER" + "," + InstabugDbContract.SurveyEntry.COLUMN_QUESTIONS + " TEXT" + "," + InstabugDbContract.SurveyEntry.COLUMN_THANKS_LIST + " TEXT" + "," + "targetAudiences" + " TEXT" + "," + InstabugDbContract.SurveyEntry.COLUMN_CUSTOM_ATTRIBUTES + " TEXT" + "," + InstabugDbContract.SurveyEntry.COLUMN_USER_EVENTS + " TEXT" + "," + "surveyState" + " TEXT" + "," + "surveyTargeting" + " TEXT" + "," + InstabugDbContract.SurveyEntry.COLUMN_SURVEY_TRIGGER_EVENT + " TEXT" + "," + "isLocalized" + " BOOLEAN" + "," + "currentLocale" + " TEXT" + "," + "supportedLocales" + " TEXT" + ")";
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    @VisibleForTesting
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        String str4 = "INSERT INTO " + str2 + "(" + str3 + ") SELECT " + str3 + " FROM " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str4);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str4);
        }
    }

    @VisibleForTesting
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String str3 = "ALTER TABLE " + str + " RENAME TO " + str2;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str3);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str3);
        }
    }
}
