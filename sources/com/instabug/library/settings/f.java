package com.instabug.library.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.Instabug;
import com.instabug.library.broadcast.LastContactedChangedBroadcast;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.utils.PreferencesUtils;
import com.instabug.library.model.b;
import org.json.JSONException;

public class f {

    /* renamed from: c  reason: collision with root package name */
    private static f f51911c;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f51912a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f51913b;

    @SuppressLint({"CommitPrefEdits"})
    private f(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        this.f51912a = instabugSharedPreferences;
        if (instabugSharedPreferences != null) {
            this.f51913b = instabugSharedPreferences.edit();
        }
    }

    @VisibleForTesting
    public static void b(Context context) {
        f51911c = new f(context);
    }

    @Nullable
    public static synchronized f s() {
        f fVar;
        synchronized (f.class) {
            Context applicationContext = Instabug.getApplicationContext();
            if (f51911c == null && applicationContext != null) {
                b(applicationContext);
            }
            fVar = f51911c;
        }
        return fVar;
    }

    public long A() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return System.currentTimeMillis();
        }
        return sharedPreferences.getLong("last_seen_timestamp", System.currentTimeMillis());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String B() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_logging_settings", (String) null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String C() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_md5_uuid", (String) null);
    }

    @Nullable
    public String D() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_non_fatals_settings", (String) null);
    }

    public int E() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(UserPropertyKeys.OS_VERSION, -1);
    }

    public boolean F() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ibc_is_push_notification_token_sent", false);
    }

    public int G() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("ib_sessions_count", 0);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String H() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "{}";
        }
        return sharedPreferences.getString("ib_sessions_sync_configurations", "{}");
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String I() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("ib_user_data", "");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String J() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_uuid", (String) null);
    }

    public void K() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("ib_sessions_count", G() + 1).apply();
        }
    }

    public boolean L() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_pn", true);
    }

    public boolean M() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ib_device_registered", false);
    }

    public boolean N() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_first_dismiss", true);
    }

    public boolean O() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_first_run", true);
    }

    public boolean P() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_first_run_after_updating_encryptor", true);
    }

    public boolean Q() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_is_first_session", true);
    }

    public void R(b bVar) throws JSONException {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ib_features_cache", bVar.toJson()).apply();
        }
    }

    public boolean S() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ib_is_sdk_version_set", false);
    }

    public boolean T() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("session_status", true);
    }

    public boolean U() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_is_user_logged_out", true);
    }

    public boolean V() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ib_is_users_page_enabled", false);
    }

    public void W() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("ib_sessions_count", 0).apply();
        }
    }

    public boolean X() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("should_show_onboarding", true);
    }

    public boolean Y() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ib_should_make_uuid_migration_request", false);
    }

    public void Z(long j11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("ib_first_run_at", j11).apply();
        }
    }

    @Nullable
    public String a() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_app_token", (String) null);
    }

    public void a0(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ibc_is_push_notification_token_sent", z11).apply();
        }
    }

    public void b0(String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ibc_push_notification_token", str).apply();
        }
    }

    public void c(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_device_registered", z11).apply();
        }
    }

    public long c0() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("ib_first_run_at", 0);
    }

    public void d(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_first_dismiss", z11).apply();
        }
    }

    public void e(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_first_run", z11).apply();
            this.f51912a.edit().putLong("ib_first_run_at", System.currentTimeMillis()).apply();
        }
    }

    public void f(int i11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("last_migration_version", i11).apply();
        }
    }

    public void g(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt(UserPropertyKeys.OS_VERSION, i11).apply();
        }
    }

    public void h(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("identified_email", str);
            this.f51913b.apply();
        }
    }

    public void i(@Nullable String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            if (str == null) {
                editor.remove("identified_name");
            } else {
                editor.putString("identified_name", str);
            }
            this.f51913b.apply();
        }
    }

    public void j(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_should_make_uuid_migration_request", z11).apply();
        }
    }

    public void k(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_is_user_logged_out", z11).apply();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void l(@Nullable String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ib_md5_uuid", str).apply();
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String m() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("features_hash", "");
    }

    public long n() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("features_ttl", 0);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String o() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("ibc_push_notification_token", "");
    }

    public void p(String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ib_user_data", str).apply();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public String q() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("identified_email", "");
    }

    @NonNull
    public String r() {
        String string = this.f51912a.getString("identified_name", "");
        return string != null ? string : "";
    }

    @Nullable
    public String t() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("instabug_last_app_version", (String) null);
    }

    public long u() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong(LastContactedChangedBroadcast.LAST_CONTACTED_AT, 0);
    }

    public long v() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getLong("ib_last_foreground_time", -1);
    }

    public int w() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null && sharedPreferences.getInt("ib_version_code", -1) == -1) {
            j(InstabugDeviceProperties.getVersionCode().intValue());
        }
        SharedPreferences sharedPreferences2 = this.f51912a;
        if (sharedPreferences2 == null) {
            return -1;
        }
        return sharedPreferences2.getInt("ib_version_code", -1);
    }

    public int x() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("last_migration_version", 0);
    }

    public long y() {
        return this.f51912a.getLong("ib_last_report_time", 0);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String z() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "11.7.0";
        }
        return sharedPreferences.getString("ib_sdk_version", "11.7.0");
    }

    public void b(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_pn", z11).apply();
        }
    }

    public void a(boolean z11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putBoolean("ib_first_run_after_updating_encryptor", z11);
            this.f51913b.apply();
        }
    }

    public void c(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("ib_app_token", str).apply();
        }
    }

    public void d(String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ib_sdk_version", str).apply();
            this.f51912a.edit().putBoolean("ib_is_sdk_version_set", true).apply();
        }
    }

    public void f(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("entered_name", str);
            this.f51913b.apply();
        }
    }

    public void g(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("session_status", z11).apply();
        }
    }

    public void k(long j11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_seen_timestamp", j11).apply();
        }
    }

    public b l() throws JSONException {
        b bVar = new b();
        SharedPreferences sharedPreferences = this.f51912a;
        String str = null;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("ib_features_cache", (String) null);
        }
        bVar.fromJson(str);
        return bVar;
    }

    public void m(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("ib_non_fatals_settings", str).apply();
        }
    }

    public void o(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("ib_sessions_sync_configurations", str).apply();
        }
    }

    public long p() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getLong("instabug_app_version_first_seen", -1);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void q(@Nullable String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ib_uuid", str).apply();
        }
    }

    public void e(String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("entered_email", str);
            this.f51913b.apply();
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String h() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("entered_email", "");
    }

    public void j(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt("ib_version_code", i11).apply();
        }
    }

    public void b(String str, boolean z11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putBoolean(str, z11);
            this.f51913b.apply();
        }
    }

    @Nullable
    public int c() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 15;
        }
        return sharedPreferences.getInt("ib_custom_traces_count", 15);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void g(@Nullable String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("features_hash", str).apply();
        }
    }

    public void i(long j11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(LastContactedChangedBroadcast.LAST_CONTACTED_AT, j11).apply();
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String a(@NonNull Context context) {
        return new PreferencesUtils(context, SettingsManager.INSTABUG_SHARED_PREF_NAME).getString("ib_sessions_sync_configurations", "{}");
    }

    public void d(long j11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putLong("ib_non_fatals_last_sync", j11).apply();
        }
    }

    public void f(long j11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("features_ttl", j11).apply();
        }
    }

    public void h(int i11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("ib_sessions_count", i11).apply();
        }
    }

    public void j(@Nullable String str) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putString("instabug_last_app_version", str);
            this.f51913b.apply();
        }
    }

    public void k(@Nullable String str) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            if (str == null) {
                sharedPreferences.edit().remove("ib_logging_settings");
            }
            this.f51912a.edit().putString("ib_logging_settings", str).apply();
        }
    }

    public void c(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt("ib_encryptor_version", i11);
            this.f51913b.apply();
        }
    }

    @Nullable
    public long e() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("ib_non_fatals_last_sync", 0);
    }

    public int g() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 1;
        }
        return sharedPreferences.getInt("ib_encryptor_version", 1);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String i() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("entered_name", "");
    }

    public void l(boolean z11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putBoolean("ib_is_users_page_enabled", z11);
            this.f51913b.apply();
        }
    }

    public boolean a(String str, boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return z11;
        }
        return sharedPreferences.getBoolean(str, z11);
    }

    public void b(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt("ib_custom_traces_count", i11);
            this.f51913b.apply();
        }
    }

    public void d(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt("ib_diagnostics_sync_interval", i11);
            this.f51913b.apply();
        }
    }

    public void f(boolean z11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putBoolean("ib_is_first_session", z11).apply();
        }
    }

    public void h(long j11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putLong("instabug_app_version_first_seen", j11);
            this.f51913b.apply();
        }
    }

    public void e(int i11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putInt("ib_experiments_store_limit", i11).commit();
        }
    }

    public void i(boolean z11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("should_show_onboarding", z11).apply();
        }
    }

    public void j(long j11) {
        SharedPreferences.Editor editor = this.f51913b;
        if (editor != null) {
            editor.putLong("ib_last_foreground_time", j11).commit();
        }
    }

    public long k() {
        return this.f51912a.getLong("ib_fatal_hangs_sensitivity", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void a(@Nullable String str, @Nullable com.instabug.library.percentagefeatures.b bVar) {
        if (bVar != null && str != null) {
            SharedPreferences.Editor editor = this.f51913b;
            editor.putString(str + "_percentage", bVar.c());
            this.f51913b.apply();
        }
    }

    public void c(long j11) {
        this.f51913b.putLong("ib_last_report_time", j11).commit();
    }

    public int f() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 1440;
        }
        return sharedPreferences.getInt("ib_diagnostics_sync_interval", 1440);
    }

    public com.instabug.library.percentagefeatures.b b(@Nullable String str) {
        com.instabug.library.percentagefeatures.b bVar = new com.instabug.library.percentagefeatures.b();
        if (str != null) {
            SharedPreferences sharedPreferences = this.f51912a;
            String str2 = "";
            if (sharedPreferences != null) {
                str2 = sharedPreferences.getString(str + "_percentage", str2);
            }
            if (str2 != null) {
                bVar.a(str2);
            }
        }
        return bVar;
    }

    public long d() {
        return this.f51912a.getLong("ib_dequeue_threshold", 0);
    }

    public void e(long j11) {
        this.f51913b.putLong("ib_fatal_hangs_sensitivity", j11).commit();
    }

    public void i(int i11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("ib_session_stitching_timeout", i11).commit();
        }
    }

    public int j() {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return 200;
        }
        return sharedPreferences.getInt("ib_experiments_store_limit", 200);
    }

    public void a(@Nullable String str) {
        if (str != null) {
            SharedPreferences.Editor editor = this.f51913b;
            editor.remove(str + "_percentage");
            this.f51913b.apply();
        }
    }

    public int a(int i11) {
        SharedPreferences sharedPreferences = this.f51912a;
        if (sharedPreferences == null) {
            return i11;
        }
        return sharedPreferences.getInt("ib_session_stitching_timeout", i11);
    }

    public void b(long j11) {
        this.f51913b.putLong("ib_dequeue_threshold", j11).commit();
    }

    public void a(long j11) {
        this.f51913b.putLong("ib_completion_threshold", j11).commit();
    }

    public long b() {
        return this.f51912a.getLong("ib_completion_threshold", 0);
    }
}
