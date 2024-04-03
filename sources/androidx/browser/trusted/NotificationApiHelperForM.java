package androidx.browser.trusted;

import android.app.NotificationManager;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class NotificationApiHelperForM {
    private NotificationApiHelperForM() {
    }

    @NonNull
    public static Parcelable[] a(NotificationManager notificationManager) {
        return notificationManager.getActiveNotifications();
    }
}
