package tracking.gtm;

import android.content.Context;
import android.os.Bundle;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Ltracking/gtm/TalabatFirebaseWrapper;", "", "()V", "dispatchEvent", "", "eventName", "", "attributes", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatFirebaseWrapper {
    public final void dispatchEvent(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, str, bundle, 1, (Object) null);
    }
}
