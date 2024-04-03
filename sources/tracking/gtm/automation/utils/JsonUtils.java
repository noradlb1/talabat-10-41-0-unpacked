package tracking.gtm.automation.utils;

import android.os.Bundle;
import com.braze.models.FeatureFlag;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ltracking/gtm/automation/utils/JsonUtils;", "", "()V", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JsonUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\b\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Ltracking/gtm/automation/utils/JsonUtils$Companion;", "", "()V", "getEventJson", "Lorg/json/JSONObject;", "eventName", "", "propertiesObject", "getProperties", "bundle", "Landroid/os/Bundle;", "attributes", "", "parseAndMapEvents", "Lorg/json/JSONArray;", "eventJsonMainArray", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final JSONObject getEventJson(String str, JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME, (Object) str);
            jSONObject2.put(FeatureFlag.PROPERTIES, (Object) jSONObject);
            return jSONObject2;
        }

        private final JSONObject getProperties(Bundle bundle) {
            JSONObject jSONObject = new JSONObject();
            Set<String> keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
            for (String next : keySet) {
                try {
                    jSONObject.put(next, JSONObject.wrap(bundle.get(next)));
                } catch (JSONException e11) {
                    String message = e11.getMessage();
                    LogManager.debug("TrackingAutomation: " + message);
                }
            }
            return jSONObject;
        }

        public static /* synthetic */ JSONArray parseAndMapEvents$default(Companion companion, String str, Bundle bundle, JSONArray jSONArray, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                jSONArray = new JSONArray();
            }
            return companion.parseAndMapEvents(str, bundle, jSONArray);
        }

        @NotNull
        public final JSONArray parseAndMapEvents(@NotNull String str, @NotNull Bundle bundle, @NotNull JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(jSONArray, "eventJsonMainArray");
            jSONArray.put((Object) getEventJson(str, getProperties(bundle)));
            LogManager.debug("TRACKING_EVENTS_LOG = ParseAnsMap:::" + jSONArray);
            return jSONArray;
        }

        public static /* synthetic */ JSONArray parseAndMapEvents$default(Companion companion, String str, Map map, JSONArray jSONArray, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                jSONArray = new JSONArray();
            }
            return companion.parseAndMapEvents(str, (Map<String, ? extends Object>) map, jSONArray);
        }

        @NotNull
        public final JSONArray parseAndMapEvents(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
            Intrinsics.checkNotNullParameter(jSONArray, "eventJsonMainArray");
            jSONArray.put((Object) getEventJson(str, getProperties(map)));
            LogManager.debug("TRACKING_EVENTS_LOG = ParseAnsMap:::" + jSONArray);
            return jSONArray;
        }

        private final JSONObject getProperties(Map<String, ? extends Object> map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), JSONObject.wrap(entry.getValue()));
                } catch (JSONException e11) {
                    String message = e11.getMessage();
                    LogManager.debug("TrackingAutomation: " + message);
                }
            }
            return jSONObject;
        }
    }
}
