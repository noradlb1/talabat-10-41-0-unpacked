package com.huawei.wearengine.notify;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.common.WearEngineErrorCode;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.notify.Notification;
import com.huawei.wearengine.notify.NotifySendCallback;
import java.util.concurrent.Callable;

public final class NotifyClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public NotifyServiceProxy f44746a = new NotifyServiceProxy();

    public class a extends NotifySendCallback.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Notification f44747b;

        public a(NotifyClient notifyClient, Notification notification) {
            this.f44747b = notification;
        }

        public void onError(NotificationParcel notificationParcel, int i11) {
            this.f44747b.getAction().onError(new Notification.Builder().setTemplateId(NotificationTemplate.getTemplateForTemplateId(notificationParcel.getTemplateId())).setPackageName(notificationParcel.getPackageName()).setTitle(notificationParcel.getTitle()).setText(notificationParcel.getText()).build(), WearEngineErrorCode.convertStringToErrorCode(String.valueOf(i11)), WearEngineErrorCode.getErrorMsgFromCode(i11));
        }

        public void onResult(NotificationParcel notificationParcel, int i11) {
            this.f44747b.getAction().onResult(new Notification.Builder().setTemplateId(NotificationTemplate.getTemplateForTemplateId(notificationParcel.getTemplateId())).setPackageName(notificationParcel.getPackageName()).setTitle(notificationParcel.getTitle()).setText(notificationParcel.getText()).build(), i11);
        }
    }

    public class b implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44748b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Notification f44749c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NotifySendCallback f44750d;

        public b(Device device, Notification notification, NotifySendCallback notifySendCallback) {
            this.f44748b = device;
            this.f44749c = notification;
            this.f44750d = notifySendCallback;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44748b, (Object) "deviceId can not be null!");
            com.huawei.wearengine.common.a.a(this.f44749c, (Object) "notification can not be null!");
            NotifyClient.this.a(this.f44749c);
            int notify = NotifyClient.this.f44746a.notify(this.f44748b, new NotificationParcel(this.f44749c), this.f44750d);
            if (notify == 0) {
                return null;
            }
            throw new WearEngineException(notify);
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final NotifyClient f44752a = new NotifyClient((a) null);
    }

    private NotifyClient() {
    }

    public /* synthetic */ NotifyClient(a aVar) {
    }

    /* access modifiers changed from: private */
    public void a(Notification notification) {
        if (notification.getTemplateId() != -1) {
            com.huawei.wearengine.common.a.a(notification.getPackageName(), 28);
            com.huawei.wearengine.common.a.a(notification.getTitle(), 28);
            com.huawei.wearengine.common.a.a(notification.getText(), 400);
            com.huawei.wearengine.utils.b.a(notification);
            return;
        }
        throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkNotifTemplateId templateId type is error", 5);
    }

    public static NotifyClient getInstance() {
        return c.f44752a;
    }

    public Task<Void> notify(Device device, Notification notification) {
        return Tasks.callInBackground(new b(device, notification, new a(this, notification)));
    }
}
