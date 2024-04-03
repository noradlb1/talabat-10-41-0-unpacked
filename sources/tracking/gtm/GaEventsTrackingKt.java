package tracking.gtm;

import android.os.Bundle;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.lib.Integration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¨\u0006\f"}, d2 = {"updateGaEventsTracker", "", "eventName", "", "params", "Landroid/os/Bundle;", "eventLog", "eventsTracker", "", "attributes", "", "", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GaEventsTrackingKt {
    public static final void updateGaEventsTracker(@NotNull String str, @Nullable Bundle bundle, @NotNull String str2, @Nullable List<String> list) {
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "eventLog");
        if (list != null) {
            list.add(str2);
        }
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            for (String str3 : keySet) {
                if (list != null) {
                    Object obj = bundle.get(str3);
                    list.add(str + " property: " + str3 + " => " + obj);
                }
            }
        }
    }

    public static /* synthetic */ void updateGaEventsTracker$default(String str, Bundle bundle, String str2, List<String> list, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            list = Integration.getGaEventsTracker();
        }
        updateGaEventsTracker(str, bundle, str2, list);
    }

    public static /* synthetic */ void updateGaEventsTracker$default(String str, Map map, String str2, List<String> list, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            list = Integration.getGaEventsTracker();
        }
        updateGaEventsTracker(str, (Map<String, ? extends Object>) map, str2, list);
    }

    public static final void updateGaEventsTracker(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull String str2, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str2, "eventLog");
        if (list != null) {
            list.add(str2);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (list != null) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                list.add(str + " property: " + key + " => " + value);
            }
        }
    }
}
