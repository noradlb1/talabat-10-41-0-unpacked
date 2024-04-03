package creativemaybeno.wakelock;

import android.app.Activity;
import creativemaybeno.wakelock.Messages;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcreativemaybeno/wakelock/Wakelock;", "", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "enabled", "", "getEnabled", "()Z", "isEnabled", "Lcreativemaybeno/wakelock/Messages$IsEnabledMessage;", "toggle", "", "message", "Lcreativemaybeno/wakelock/Messages$ToggleMessage;", "wakelock_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Wakelock {
    @Nullable
    private Activity activity;

    private final boolean getEnabled() {
        Activity activity2 = this.activity;
        Intrinsics.checkNotNull(activity2);
        return (activity2.getWindow().getAttributes().flags & 128) != 0;
    }

    @Nullable
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final Messages.IsEnabledMessage isEnabled() {
        if (this.activity != null) {
            Messages.IsEnabledMessage isEnabledMessage = new Messages.IsEnabledMessage();
            isEnabledMessage.setEnabled(Boolean.valueOf(getEnabled()));
            return isEnabledMessage;
        }
        throw new NoActivityException();
    }

    public final void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    public final void toggle(@NotNull Messages.ToggleMessage toggleMessage) {
        Intrinsics.checkNotNullParameter(toggleMessage, "message");
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Intrinsics.checkNotNull(activity2);
            boolean enabled = getEnabled();
            Boolean enable = toggleMessage.getEnable();
            Intrinsics.checkNotNull(enable);
            if (enable.booleanValue()) {
                if (!enabled) {
                    activity2.getWindow().addFlags(128);
                }
            } else if (enabled) {
                activity2.getWindow().clearFlags(128);
            }
        } else {
            throw new NoActivityException();
        }
    }
}
