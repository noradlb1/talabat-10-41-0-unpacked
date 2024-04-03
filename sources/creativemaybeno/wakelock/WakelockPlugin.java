package creativemaybeno.wakelock;

import android.app.Activity;
import androidx.annotation.NonNull;
import creativemaybeno.wakelock.Messages;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcreativemaybeno/wakelock/WakelockPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcreativemaybeno/wakelock/Messages$WakelockApi;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "wakelock", "Lcreativemaybeno/wakelock/Wakelock;", "isEnabled", "Lcreativemaybeno/wakelock/Messages$IsEnabledMessage;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "toggle", "arg", "Lcreativemaybeno/wakelock/Messages$ToggleMessage;", "wakelock_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WakelockPlugin implements FlutterPlugin, Messages.WakelockApi, ActivityAware {
    @Nullable
    private Wakelock wakelock;

    @NotNull
    public Messages.IsEnabledMessage isEnabled() {
        Wakelock wakelock2 = this.wakelock;
        Intrinsics.checkNotNull(wakelock2);
        return wakelock2.isEnabled();
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        Wakelock wakelock2 = this.wakelock;
        if (wakelock2 != null) {
            wakelock2.setActivity(activityPluginBinding.getActivity());
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        a.d(flutterPluginBinding.getBinaryMessenger(), this);
        this.wakelock = new Wakelock();
    }

    public void onDetachedFromActivity() {
        Wakelock wakelock2 = this.wakelock;
        if (wakelock2 != null) {
            wakelock2.setActivity((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        a.d(flutterPluginBinding.getBinaryMessenger(), (Messages.WakelockApi) null);
        this.wakelock = null;
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        onAttachedToActivity(activityPluginBinding);
    }

    public void toggle(@Nullable Messages.ToggleMessage toggleMessage) {
        Wakelock wakelock2 = this.wakelock;
        Intrinsics.checkNotNull(wakelock2);
        Intrinsics.checkNotNull(toggleMessage);
        wakelock2.toggle(toggleMessage);
    }
}
