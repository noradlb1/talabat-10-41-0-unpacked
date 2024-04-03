package com.instabug.library.user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Patterns;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.core.plugin.c;
import com.instabug.library.e0;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.orchestrator.a;
import com.instabug.library.internal.orchestrator.e;
import com.instabug.library.internal.orchestrator.g;
import com.instabug.library.internal.orchestrator.h;
import com.instabug.library.internal.orchestrator.i;
import com.instabug.library.internal.orchestrator.j;
import com.instabug.library.internal.orchestrator.k;
import com.instabug.library.internal.orchestrator.l;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.db.InstabugDBInsertionListener;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.user.UserCacheManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.MD5Generator;
import com.instabug.library.util.threading.PoolProvider;
import java.util.UUID;

public abstract class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f51997a;

    public static void a(Context context) {
        PoolProvider.getUserActionsExecutor().execute(new d());
    }

    public static void c() {
        InstabugSDKLogger.v("IBG-Core", "clearing User Activities");
        SettingsManager.getInstance().setLastContactedAt(0);
        CacheManager.getInstance().invalidateAllCachesForIdentifyingUsers();
    }

    public static void d(String str) {
        String str2 = (str == null || str.isEmpty()) ? "empty-email" : "non-empty-email";
        InstabugSDKLogger.v("IBG-Core", "setEnteredEmail: " + str2);
        SettingsManager.getInstance().setEnteredEmail(str);
    }

    public static void e(String str) {
        String str2 = (str == null || str.isEmpty()) ? "empty_username" : "non-empty-username";
        InstabugSDKLogger.v("IBG-Core", "setEnteredUsername: " + str2);
        SettingsManager.getInstance().setEnteredUsername(str);
    }

    public static void f(@NonNull String str) {
        SettingsManager.getInstance().setIdentifiedUserEmail(str);
        if ("".equals(str)) {
            InstabugSDKLogger.d("IBG-Core", "Email set to empty string, enabling user input of email");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            InstabugSDKLogger.w("IBG-Core", "Invalid email passed to setIdentifiedUserEmail, ignoring.");
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void g(@Nullable String str) {
        String str2 = (str == null || str.isEmpty()) ? "empty_username" : "non-empty-username";
        InstabugSDKLogger.v("IBG-Core", "setIdentifiedUsername: " + str2);
        SettingsManager.getInstance().setIdentifiedUsername(str);
    }

    @NonNull
    public static String h() {
        String str;
        String identifiedUserEmail = SettingsManager.getInstance().getIdentifiedUserEmail();
        if (identifiedUserEmail != null && identifiedUserEmail.isEmpty()) {
            identifiedUserEmail = SettingsManager.getInstance().getEnteredEmail();
        }
        if (identifiedUserEmail == null || identifiedUserEmail.isEmpty()) {
            str = "empty-email";
        } else {
            str = "non-empty-email";
        }
        InstabugSDKLogger.v("IBG-Core", "getIdentifiedUserEmail: " + str);
        return identifiedUserEmail;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static String i() {
        String str;
        String identifiedUsername = SettingsManager.getInstance().getIdentifiedUsername();
        if (identifiedUsername.isEmpty()) {
            identifiedUsername = SettingsManager.getInstance().getEnteredUsername();
        }
        if (identifiedUsername == null || identifiedUsername.isEmpty()) {
            str = "empty_username";
        } else {
            str = "non-empty-username";
        }
        InstabugSDKLogger.v("IBG-Core", "getIdentifiedUsername: " + str);
        return identifiedUsername;
    }

    public static int j() {
        return SettingsManager.getInstance().getSessionsCount();
    }

    public static String k() {
        if (f51997a == null) {
            u();
        }
        return f51997a;
    }

    public static String l() {
        if (f51997a != null) {
            return f51997a;
        }
        f51997a = m();
        UserCacheManager.insertIfNotExists(f51997a, j());
        return f51997a;
    }

    @NonNull
    private static synchronized String m() {
        String mD5Uuid;
        synchronized (f.class) {
            mD5Uuid = SettingsManager.getInstance().getMD5Uuid();
            if ((mD5Uuid == null || mD5Uuid.isEmpty()) && ((mD5Uuid = SettingsManager.getInstance().getUuid()) == null || mD5Uuid.isEmpty())) {
                mD5Uuid = UUID.randomUUID().toString();
                if (SettingsManager.shouldLogExtraRequestData()) {
                    InstabugSDKLogger.v("IBG-Core", "new randomly generated UUID: " + mD5Uuid);
                }
                SettingsManager.getInstance().setUuid(mD5Uuid);
            }
        }
        return mD5Uuid;
    }

    public static String n() {
        String f11 = f();
        if (f11 == null || f11.trim().equals("")) {
            return h();
        }
        return f11;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static String o() {
        try {
            String g11 = g();
            if (g11 == null || g11.trim().equals("")) {
                return i();
            }
            return g11;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error getting username" + e11);
            return "";
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static boolean p() {
        return !SettingsManager.getInstance().isUserLoggedOut();
    }

    /* access modifiers changed from: private */
    public static boolean q() {
        boolean z11;
        if (c.e() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        InstabugSDKLogger.v("IBG-Core", "isUserHasActivity: " + z11);
        return z11;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void s() {
        d("");
        e("");
        if (!SettingsManager.getInstance().getIdentifiedUserEmail().trim().isEmpty() || !SettingsManager.getInstance().getIdentifiedUsername().trim().isEmpty()) {
            SDKCoreEventPublisher.post(new SDKCoreEvent("user", SDKCoreEvent.User.VALUE_LOGGED_OUT));
            String k11 = k();
            f51997a = UUID.randomUUID().toString();
            ActionsOrchestrator.obtainOrchestrator(PoolProvider.getUserActionsExecutor()).addWorkerThreadAction(new a(k11, j())).addSameThreadAction(new g(f51997a)).addWorkerThreadAction(new l(k11, System.currentTimeMillis())).orchestrate();
        }
    }

    public static void t() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && e0.c().b((Object) Feature.INSTABUG) == Feature.State.ENABLED && SettingsManager.getInstance().shouldMakeUUIDMigrationRequest()) {
            a(applicationContext);
        }
        u();
    }

    public static void u() {
        f51997a = m();
        PoolProvider.getUserActionsExecutor().execute(new od.a());
    }

    public static void a(@NonNull Context context, @Nullable String str, String str2) {
        if (context == null) {
            InstabugSDKLogger.e("IBG-Core", "Context passed to identify is null");
        } else if (str2 == null || str2.trim().isEmpty()) {
            InstabugSDKLogger.e("IBG-Core", "Empty email, Can't identify user");
        } else {
            String trim = str2.trim();
            if (!p() || !b(trim)) {
                if (p()) {
                    s();
                }
                f(trim);
                g(str);
                String a11 = a(trim);
                if (a11 != null) {
                    c(a11);
                    f51997a = a11;
                }
                if (InstabugCore.getFeatureState(Feature.CRASHES_CUSTOM_IDENTIFIED_EMAIL) == Feature.State.DISABLED) {
                    d(trim);
                }
                a(context);
            }
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static boolean b(String str) {
        return SettingsManager.getInstance().getIdentifiedUserEmail().equalsIgnoreCase(str);
    }

    private static void c(String str) {
        ActionsOrchestrator.obtainOrchestrator(PoolProvider.getUserActionsExecutor()).addWorkerThreadAction(new j(str)).addWorkerThreadAction(new e(str)).addWorkerThreadAction(new i(str)).addWorkerThreadAction(new h(str)).addWorkerThreadAction(new com.instabug.library.internal.orchestrator.f(str)).addWorkerThreadAction(new k()).orchestrate();
    }

    @Deprecated
    public static com.instabug.library.internal.dataretention.f d() {
        return com.instabug.library.internal.dataretention.f.a("user", "uuid", InstabugDbContract.UserEntity.COLUMN_LAST_SEEN, com.instabug.library.internal.dataretention.j.USER_DATA);
    }

    @Nullable
    public static String e() {
        String f11 = f();
        if (f11 != null && !f11.trim().equals("")) {
            return f11;
        }
        if (InstabugCore.getFeatureState(Feature.CRASHES_CUSTOM_IDENTIFIED_EMAIL) == Feature.State.DISABLED) {
            return h();
        }
        return null;
    }

    public static String g() {
        return SettingsManager.getInstance().getEnteredUsername();
    }

    public static String f() {
        return SettingsManager.getInstance().getEnteredEmail();
    }

    @Nullable
    private static String a(@NonNull String str) {
        return MD5Generator.generateMD5(str + SettingsManager.getInstance().getAppToken());
    }

    public static void a(@Nullable InstabugDBInsertionListener instabugDBInsertionListener) {
        if (f51997a == null) {
            f51997a = m();
            PoolProvider.postIOTask(new e(instabugDBInsertionListener));
        } else if (instabugDBInsertionListener != null) {
            instabugDBInsertionListener.onDataInserted(f51997a);
        }
    }
}
