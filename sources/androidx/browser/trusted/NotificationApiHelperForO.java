package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NotificationApiHelperForO {
    private NotificationApiHelperForO() {
    }

    @Nullable
    public static Notification a(Context context, NotificationManager notificationManager, Notification notification, String str, String str2) {
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, 3));
        if (notificationManager.getNotificationChannel(str).getImportance() == 0) {
            return null;
        }
        Notification.Builder a11 = Notification.Builder.recoverBuilder(context, notification);
        Notification.Builder unused = a11.setChannelId(str);
        return a11.build();
    }

    public static boolean b(NotificationManager notificationManager, String str) {
        NotificationChannel a11 = notificationManager.getNotificationChannel(str);
        if (a11 == null || a11.getImportance() != 0) {
            return true;
        }
        return false;
    }
}
