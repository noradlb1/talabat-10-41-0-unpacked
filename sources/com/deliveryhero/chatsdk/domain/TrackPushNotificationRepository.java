package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.PushNotificationData;
import com.deliveryhero.chatsdk.network.http.TrackPushNotificationService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\nø\u0001\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/TrackPushNotificationRepository;", "", "service", "Lcom/deliveryhero/chatsdk/network/http/TrackPushNotificationService;", "(Lcom/deliveryhero/chatsdk/network/http/TrackPushNotificationService;)V", "trackPushNotification", "", "data", "Lcom/deliveryhero/chatsdk/domain/model/PushNotificationData;", "resultListener", "Lkotlin/Function1;", "Lkotlin/Result;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackPushNotificationRepository {
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final TrackPushNotificationService f29381service;

    public TrackPushNotificationRepository(@NotNull TrackPushNotificationService trackPushNotificationService) {
        Intrinsics.checkNotNullParameter(trackPushNotificationService, "service");
        this.f29381service = trackPushNotificationService;
    }

    public final void trackPushNotification(@NotNull PushNotificationData pushNotificationData, @NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(pushNotificationData, "data");
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        if (StringsKt__StringsJVMKt.isBlank(pushNotificationData.getPushID())) {
            Result.Companion companion = Result.Companion;
            function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Invalid data. PushId is blank")))));
            return;
        }
        TrackPushNotificationService trackPushNotificationService = this.f29381service;
        String channelID = pushNotificationData.getChannelID();
        String pushID = pushNotificationData.getPushID();
        if (pushID != null) {
            trackPushNotificationService.trackPushNotification(channelID, pushID).enqueue(new TrackPushNotificationRepository$trackPushNotification$1(function1));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
