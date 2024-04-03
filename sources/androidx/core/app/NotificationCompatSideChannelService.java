package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

public abstract class NotificationCompatSideChannelService extends Service {

    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        public NotificationSideChannelStub() {
        }

        public void cancel(String str, int i11, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(str, i11, str2);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void cancelAll(String str) {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(str);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void notify(String str, int i11, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(str, i11, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void cancel(String str, int i11, String str2);

    public abstract void cancelAll(String str);

    public void checkPermission(int i11, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i11);
        int length = packagesForUid.length;
        int i12 = 0;
        while (i12 < length) {
            if (!packagesForUid[i12].equals(str)) {
                i12++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i11 + " is not authorized for package " + str);
    }

    public abstract void notify(String str, int i11, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }
}
