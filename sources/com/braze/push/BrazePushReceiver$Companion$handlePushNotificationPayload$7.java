package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazePushReceiver$Companion$handlePushNotificationPayload$7 extends Lambda implements Function0<String> {
    public static final BrazePushReceiver$Companion$handlePushNotificationPayload$7 INSTANCE = new BrazePushReceiver$Companion$handlePushNotificationPayload$7();

    public BrazePushReceiver$Companion$handlePushNotificationPayload$7() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "Push stories not supported on Amazon devices.";
    }
}
