package com.braze.support;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.braze.support.BrazeLogger;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0014\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\f\u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u000e\u001a\f\u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u000e\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"NOTIFICATION_PERMISSION", "", "PERMISSION_STORAGE_PREFS_FILE", "TAG", "getPermissionRequestCount", "", "context", "Landroid/content/Context;", "permission", "incrementPermissionRequestCount", "", "hasPermission", "", "requestPushPermissionPrompt", "Landroid/app/Activity;", "wouldPushPermissionPromptDisplay", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PermissionUtils {
    private static final String NOTIFICATION_PERMISSION = "android.permission.POST_NOTIFICATIONS";
    private static final String PERMISSION_STORAGE_PREFS_FILE = "com.braze.support.permission_util.requested_perms";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("PermissionUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43957g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f43957g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failure checking permission ", this.f43957g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43958g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i11) {
            super(0);
            this.f43958g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Incrementing permission request counter to " + this.f43958g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43959b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to execute requestPushPermissionPrompt()";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43960b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot request push permission with null Activity.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f43961b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Permission prompt would not display, not attempting to request push permission prompt.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43962b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting push permission from system.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f43963b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot request push permission with null Activity.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43964b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device API version of " + Build.VERSION.SDK_INT + " is too low to display push permission prompt.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43965g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(int i11) {
            super(0);
            this.f43965g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "App Target API version of " + this.f43965g + " is too low to display push permission prompt.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f43966b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Notification permission already granted, doing nothing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43967g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(int i11) {
            super(0);
            this.f43967g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Notification permission request count is " + this.f43967g + ". Returning value of 'shouldShowRequestPermissionRationale(NOTIFICATION_PERMISSION)'";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f43968b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push Prompt can be shown on this device, within a reasonable confidence.";
        }
    }

    public static final int getPermissionRequestCount(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        return context.getSharedPreferences(PERMISSION_STORAGE_PREFS_FILE, 0).getInt(str, 0);
    }

    public static final boolean hasPermission(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        if (context == null) {
            return false;
        }
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th2, false, (Function0) new a(str), 8, (Object) null);
            return false;
        }
    }

    public static final void incrementPermissionRequestCount(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PERMISSION_STORAGE_PREFS_FILE, 0);
        int i11 = sharedPreferences.getInt(str, 0) + 1;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(i11), 14, (Object) null);
        sharedPreferences.edit().putInt(str, i11).apply();
    }

    public static final void requestPushPermissionPrompt(Activity activity) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str = TAG;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, false, (Function0) c.f43959b, 12, (Object) null);
        if (activity == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f43960b, 14, (Object) null);
        } else if (!wouldPushPermissionPromptDisplay(activity) || Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) e.f43961b, 14, (Object) null);
        } else {
            incrementPermissionRequestCount(activity, NOTIFICATION_PERMISSION);
            BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, false, (Function0) f.f43962b, 12, (Object) null);
            activity.requestPermissions(new String[]{NOTIFICATION_PERMISSION}, IntentUtils.getRequestCode());
        }
    }

    public static final boolean wouldPushPermissionPromptDisplay(Activity activity) {
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) g.f43963b, 14, (Object) null);
            return false;
        } else if (Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) h.f43964b, 12, (Object) null);
            return false;
        } else {
            int i11 = activity.getApplicationInfo().targetSdkVersion;
            if (i11 < 33) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new i(i11), 12, (Object) null);
                return false;
            } else if (hasPermission(activity, NOTIFICATION_PERMISSION)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) j.f43966b, 12, (Object) null);
                return false;
            } else {
                int permissionRequestCount = getPermissionRequestCount(activity, NOTIFICATION_PERMISSION);
                if (permissionRequestCount >= 2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new k(permissionRequestCount), 12, (Object) null);
                    return activity.shouldShowRequestPermissionRationale(NOTIFICATION_PERMISSION);
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) l.f43968b, 12, (Object) null);
                return true;
            }
        }
    }
}
