package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class Alarms {
    private static final String TAG = Logger.tagWithPrefix("Alarms");

    private Alarms() {
    }

    public static void cancelAlarm(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        SystemIdInfoDao systemIdInfoDao = workManagerImpl.getWorkDatabase().systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            Logger.get().debug(TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            systemIdInfoDao.removeSystemIdInfo(str);
        }
    }

    private static void cancelExactAlarm(@NonNull Context context, @NonNull String str, int i11) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service2 = PendingIntent.getService(context, i11, CommandHandler.b(context, str), 603979776);
        if (service2 != null && alarmManager != null) {
            Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i11)}), new Throwable[0]);
            alarmManager.cancel(service2);
        }
    }

    public static void setAlarm(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str, long j11) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            setExactAlarm(context, str, systemIdInfo.systemId, j11);
            return;
        }
        int nextAlarmManagerId = new IdGenerator(workDatabase).nextAlarmManagerId();
        systemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(str, nextAlarmManagerId));
        setExactAlarm(context, str, nextAlarmManagerId, j11);
    }

    private static void setExactAlarm(@NonNull Context context, @NonNull String str, int i11, long j11) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service2 = PendingIntent.getService(context, i11, CommandHandler.b(context, str), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, j11, service2);
        }
    }
}
