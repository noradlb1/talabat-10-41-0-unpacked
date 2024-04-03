package tracking.gtm.automation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import tracking.gtm.automation.EventLogConstants;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ltracking/gtm/automation/utils/TrackingPreferenceUtils;", "", "()V", "clearJsonFromPreference", "", "context", "Landroid/content/Context;", "getUserSharedPreference", "Landroid/content/SharedPreferences;", "readJsonFromPreference", "Lorg/json/JSONArray;", "writeToSharedPreference", "", "redrouteJson", "", "writeToSharedPreference$com_talabat_talabatlib_talabatlib", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingPreferenceUtils {
    @NotNull
    public static final TrackingPreferenceUtils INSTANCE = new TrackingPreferenceUtils();

    private TrackingPreferenceUtils() {
    }

    private final SharedPreferences getUserSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(EventLogConstants.PREFERENCE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final void clearJsonFromPreference(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getUserSharedPreference(context).edit().remove(EventLogConstants.REDROUTE_TRACKING_JSON).apply();
    }

    @NotNull
    public final JSONArray readJsonFromPreference(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return new JSONArray(getUserSharedPreference(context).getString(EventLogConstants.REDROUTE_TRACKING_JSON, ""));
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public final boolean writeToSharedPreference$com_talabat_talabatlib_talabatlib(@NotNull Context context, @NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "redrouteJson");
        SharedPreferences.Editor edit = getUserSharedPreference(context).edit();
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = "";
        }
        edit.putString(EventLogConstants.REDROUTE_TRACKING_JSON, str);
        edit.apply();
        return true;
    }
}
