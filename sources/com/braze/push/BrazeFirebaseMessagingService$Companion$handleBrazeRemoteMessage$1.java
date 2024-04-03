package com.braze.push;

import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RemoteMessage f43812g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1(RemoteMessage remoteMessage) {
        super(0);
        this.f43812g = remoteMessage;
    }

    @NotNull
    public final String invoke() {
        return Intrinsics.stringPlus("Remote message did not originate from Braze. Not consuming remote message: ", this.f43812g);
    }
}
