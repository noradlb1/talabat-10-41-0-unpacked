package com.braze.brazeplugin;

import com.braze.BrazeUser;
import com.braze.events.SimpleValueCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/braze/brazeplugin/BrazePlugin$runOnUser$1", "Lcom/braze/events/SimpleValueCallback;", "Lcom/braze/BrazeUser;", "onSuccess", "", "user", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BrazePlugin$runOnUser$1 extends SimpleValueCallback<BrazeUser> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<BrazeUser, Unit> f43650a;

    public BrazePlugin$runOnUser$1(Function1<? super BrazeUser, Unit> function1) {
        this.f43650a = function1;
    }

    public void onSuccess(@NotNull BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "user");
        super.onSuccess(brazeUser);
        this.f43650a.invoke(brazeUser);
    }
}
