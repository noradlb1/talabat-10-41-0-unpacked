package com.braze.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appboy.enums.Channel;
import com.appboy.ui.activities.AppboyFeedActivity;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/actions/NewsfeedAction;", "Lcom/braze/ui/actions/IAction;", "extras", "Landroid/os/Bundle;", "channel", "Lcom/appboy/enums/Channel;", "(Landroid/os/Bundle;Lcom/appboy/enums/Channel;)V", "getChannel", "()Lcom/appboy/enums/Channel;", "getExtras", "()Landroid/os/Bundle;", "execute", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NewsfeedAction implements IAction {
    @NotNull
    private final Channel channel;
    @Nullable
    private final Bundle extras;

    public NewsfeedAction(@Nullable Bundle bundle, @NotNull Channel channel2) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.extras = bundle;
        this.channel = channel2;
    }

    public void execute(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent(context, AppboyFeedActivity.class);
            Bundle bundle = this.extras;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) NewsfeedAction$execute$1.INSTANCE, 4, (Object) null);
        }
    }

    @NotNull
    public Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }
}
