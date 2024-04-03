package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PreferenceUtils {
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(@NonNull WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public static void migrateLegacyPreferences(@NonNull Context context, @NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        if (sharedPreferences.contains(KEY_RESCHEDULE_NEEDED) || sharedPreferences.contains(KEY_LAST_CANCEL_ALL_TIME_MS)) {
            long j11 = 0;
            long j12 = sharedPreferences.getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0);
            if (sharedPreferences.getBoolean(KEY_RESCHEDULE_NEEDED, false)) {
                j11 = 1;
            }
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(j12)});
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{KEY_RESCHEDULE_NEEDED, Long.valueOf(j11)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    public long getLastCancelAllTimeMillis() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_CANCEL_ALL_TIME_MS);
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0;
    }

    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map(this.mWorkDatabase.preferenceDao().getObservableLongValue(KEY_LAST_CANCEL_ALL_TIME_MS), new Function<Long, Long>() {
            public Long apply(Long l11) {
                return Long.valueOf(l11 != null ? l11.longValue() : 0);
            }
        });
    }

    public boolean getNeedsReschedule() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(KEY_RESCHEDULE_NEEDED);
        if (longValue == null || longValue.longValue() != 1) {
            return false;
        }
        return true;
    }

    public void setLastCancelAllTimeMillis(long j11) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(KEY_LAST_CANCEL_ALL_TIME_MS, j11));
    }

    public void setNeedsReschedule(boolean z11) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(KEY_RESCHEDULE_NEEDED, z11));
    }
}
