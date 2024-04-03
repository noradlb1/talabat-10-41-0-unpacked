package com.deliveryhero.customerchat;

import com.deliveryhero.contract.model.ChatPushData;
import com.deliveryhero.repository.gccchat.push.GccPushNotificationTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n¨\u0006\f"}, d2 = {"Lcom/deliveryhero/customerchat/PushNotificationTracker;", "", "()V", "trackPushNotification", "", "data", "Lcom/deliveryhero/contract/model/ChatPushData;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushNotificationTracker {
    @NotNull
    public static final PushNotificationTracker INSTANCE = new PushNotificationTracker();

    private PushNotificationTracker() {
    }

    public final void trackPushNotification(@NotNull ChatPushData chatPushData, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(chatPushData, "data");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        GccPushNotificationTracker.INSTANCE.trackPushNotification(chatPushData, function0, function1);
    }
}
