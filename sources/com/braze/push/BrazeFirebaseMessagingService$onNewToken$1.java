package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeFirebaseMessagingService$onNewToken$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f43816g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeFirebaseMessagingService$onNewToken$1(String str) {
        super(0);
        this.f43816g = str;
    }

    @NotNull
    public final String invoke() {
        return Intrinsics.stringPlus("No configured API key, not registering token in onNewToken. Token: ", this.f43816g);
    }
}
