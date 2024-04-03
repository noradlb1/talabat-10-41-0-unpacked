package com.deliveryhero.repository.gccchat.push;

import com.deliveryhero.chatsdk.PushNotificationTracker;
import com.deliveryhero.chatsdk.domain.model.PushNotificationData;
import com.deliveryhero.contract.model.ChatPushData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/repository/gccchat/push/GccPushNotificationTracker;", "", "()V", "mapToPushNotificationData", "Lcom/deliveryhero/chatsdk/domain/model/PushNotificationData;", "data", "Lcom/deliveryhero/contract/model/ChatPushData;", "trackPushNotification", "", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccPushNotificationTracker {
    @NotNull
    public static final GccPushNotificationTracker INSTANCE = new GccPushNotificationTracker();

    private GccPushNotificationTracker() {
    }

    private final PushNotificationData mapToPushNotificationData(ChatPushData chatPushData) {
        try {
            String channelID = chatPushData.getChannelID();
            String pushAlert = chatPushData.getPushAlert();
            String orderID = chatPushData.getOrderID();
            String pushID = chatPushData.getPushID();
            if (pushID != null) {
                String senderName = chatPushData.getSenderName();
                String country = chatPushData.getCountry();
                if (country != null) {
                    return new PushNotificationData(channelID, senderName, orderID, country, "", pushID, chatPushData.getMessage(), pushAlert, "", chatPushData.getChannelType());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final void trackPushNotification(@NotNull ChatPushData chatPushData, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(chatPushData, "data");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        PushNotificationData mapToPushNotificationData = mapToPushNotificationData(chatPushData);
        if (mapToPushNotificationData != null) {
            PushNotificationTracker.INSTANCE.trackPushNotification(mapToPushNotificationData, new GccPushNotificationTracker$trackPushNotification$1(function0, function1));
        } else {
            function1.invoke(new IllegalArgumentException("Push data is not a valid GCC chat push"));
        }
    }
}
