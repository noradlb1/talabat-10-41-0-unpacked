package com.instabug.chat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.library.Feature;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Map;

public final class Replies {
    private static final String TAG = "Replies";

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45989a;

        public a(boolean z11) {
            this.f45989a = z11;
        }

        public void run() {
            f.b(this.f45989a);
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45990a;

        public b(boolean z11) {
            this.f45990a = z11;
        }

        public void run() {
            f.a(this.f45990a);
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f45991a;

        public c(Feature.State state) {
            this.f45991a = state;
        }

        public void run() {
            Feature.State state = this.f45991a;
            if (state == null) {
                InstabugSDKLogger.e("IBG-BR", "state object passed to Replies.setState() is null");
                return;
            }
            f.b(state);
            SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_UPDATED));
        }
    }

    public class d implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45992a;

        public d(int i11) {
            this.f45992a = i11;
        }

        public void run() {
            f.a(this.f45992a);
        }
    }

    public class e implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f45993a;

        public e(Bundle bundle) {
            this.f45993a = bundle;
        }

        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(f.a(this.f45993a));
        }
    }

    public class f implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f45994a;

        public f(Map map) {
            this.f45994a = map;
        }

        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(f.a(this.f45994a));
        }
    }

    public class g implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45995a;

        public g(boolean z11) {
            this.f45995a = z11;
        }

        public void run() {
            f.d(this.f45995a);
        }
    }

    public class h implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45996a;

        public h(String str) {
            this.f45996a = str;
        }

        public void run() {
            f.a(this.f45996a);
        }
    }

    public class i implements VoidRunnable {
        public void run() {
            f.e();
        }
    }

    public class j implements ReturnableRunnable {
        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(f.b());
        }
    }

    public class k implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f45997a;

        public k(Runnable runnable) {
            this.f45997a = runnable;
        }

        public void run() {
            f.a(this.f45997a);
        }
    }

    public class l implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45998a;

        public l(boolean z11) {
            this.f45998a = z11;
        }

        public void run() {
            f.c(this.f45998a);
        }
    }

    public class m implements ReturnableRunnable {
        /* renamed from: a */
        public Integer run() {
            return Integer.valueOf(f.a());
        }
    }

    public class n implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f45999a;

        public n(Feature.State state) {
            this.f45999a = state;
        }

        public void run() {
            InstabugCore.setPushNotificationState(this.f45999a);
        }
    }

    public class o implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46000a;

        public o(String str) {
            this.f46000a = str;
        }

        public void run() {
            f.b(this.f46000a);
        }
    }

    public class p implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f46001a;

        public p(Bundle bundle) {
            this.f46001a = bundle;
        }

        public void run() {
            f.b(this.f46001a);
        }
    }

    public class q implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f46002a;

        public q(Map map) {
            this.f46002a = map;
        }

        public void run() {
            f.b(this.f46002a);
        }
    }

    public static int getUnreadRepliesCount() {
        Integer num = (Integer) APIChecker.checkAndGet("Replies.getUnreadRepliesCount", new m(), 0);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static boolean hasChats() {
        Boolean bool = (Boolean) APIChecker.checkAndGet("Replies.hasChats", new j(), Boolean.FALSE);
        return bool != null && bool.booleanValue();
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static boolean isInstabugNotification(Bundle bundle) {
        return ((Boolean) APIChecker.checkAndGet("Replies.isInstabugNotification", new e(bundle), Boolean.FALSE)).booleanValue();
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static boolean isInstabugNotification(Map<String, String> map) {
        return ((Boolean) APIChecker.checkAndGet("Replies.isInstabugNotification", new f(map), Boolean.FALSE)).booleanValue();
    }

    public static void setInAppNotificationEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("Replies.setInAppNotificationEnabled", new l(z11));
    }

    public static void setInAppNotificationSound(boolean z11) {
        APIChecker.checkAndRunInExecutor("Replies.setInAppNotificationSound", new a(z11));
    }

    public static void setNotificationIcon(@DrawableRes int i11) {
        APIChecker.checkAndRunInExecutor("Replies.setNotificationIcon", new d(i11));
    }

    public static void setOnNewReplyReceivedCallback(Runnable runnable) {
        APIChecker.checkAndRunInExecutorThenPostOnMain("Replies.setOnNewReplyReceivedCallback", new k(runnable));
    }

    @RequiresApi(api = 26)
    public static void setPushNotificationChannelId(String str) {
        APIChecker.checkAndRunInExecutor("Replies.setPushNotificationChannelId", new h(str));
    }

    public static void setPushNotificationRegistrationToken(@NonNull String str) {
        APIChecker.checkAndRunInExecutor("Replies.setPushNotificationRegistrationToken", new o(str));
    }

    public static void setPushNotificationState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("Replies.setPushNotificationState", new n(state));
    }

    public static void setShouldPlayConversationSounds(boolean z11) {
        APIChecker.checkAndRunInExecutor("Replies.setShouldPlayConversationSounds", new b(z11));
    }

    public static void setState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("Replies.setState", new c(state));
    }

    public static void setSystemReplyNotificationSoundEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("Replies.setSystemReplyNotificationSoundEnabled", new g(z11));
    }

    public static void show() {
        APIChecker.checkAndRunInExecutor("Replies.show", new i());
    }

    public static void showNotification(Bundle bundle) {
        APIChecker.checkAndRunInExecutor("Replies.showNotification", new p(bundle));
    }

    public static void showNotification(Map<String, String> map) {
        APIChecker.checkAndRunInExecutor("Replies.showNotification", new q(map));
    }
}
