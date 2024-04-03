package tracking.gtm.automation;

import android.content.Context;
import android.os.Bundle;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Ltracking/gtm/automation/DynamicJsonManager;", "", "()V", "convertAndSaveTrackingData", "", "eventJsonArray", "Lorg/json/JSONArray;", "file", "", "context", "Landroid/content/Context;", "(Lorg/json/JSONArray;Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDynamicJson", "", "eventName", "bundle", "Landroid/os/Bundle;", "attributes", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicJsonManager {
    @NotNull
    public static final DynamicJsonManager INSTANCE = new DynamicJsonManager();

    private DynamicJsonManager() {
    }

    @Nullable
    public final Object convertAndSaveTrackingData(@NotNull JSONArray jSONArray, @NotNull String str, @NotNull Context context, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DynamicJsonManager$convertAndSaveTrackingData$2(jSONArray, str, context, (Continuation<? super DynamicJsonManager$convertAndSaveTrackingData$2>) null), continuation);
    }

    public final void updateDynamicJson(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AutomationTestingIntegrator automationTestingIntegrator = AutomationTestingIntegrator.INSTANCE;
        automationTestingIntegrator.setTrackedEvents(new DynamicJsonManager$updateDynamicJson$1(str, bundle, automationTestingIntegrator.getTrackedEvents()));
    }

    public final void updateDynamicJson(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        AutomationTestingIntegrator automationTestingIntegrator = AutomationTestingIntegrator.INSTANCE;
        automationTestingIntegrator.setTrackedEvents(new DynamicJsonManager$updateDynamicJson$2(str, map, automationTestingIntegrator.getTrackedEvents()));
    }
}
