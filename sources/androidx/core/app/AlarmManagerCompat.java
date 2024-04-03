package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AlarmManagerCompat {

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static void setExact(AlarmManager alarmManager, int i11, long j11, PendingIntent pendingIntent) {
            alarmManager.setExact(i11, j11, pendingIntent);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j11, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j11, pendingIntent);
        }

        @DoNotInline
        public static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i11, long j11, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i11, j11, pendingIntent);
        }

        @DoNotInline
        public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i11, long j11, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i11, j11, pendingIntent);
        }
    }

    private AlarmManagerCompat() {
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j11, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j11, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i11, long j11, @NonNull PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, i11, j11, pendingIntent);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i11, long j11, @NonNull PendingIntent pendingIntent) {
        Api19Impl.setExact(alarmManager, i11, j11, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i11, long j11, @NonNull PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, i11, j11, pendingIntent);
    }
}
