package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f43814g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f43815h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3(String str, String str2) {
        super(0);
        this.f43814g = str;
        this.f43815h = str2;
    }

    @NotNull
    public final String invoke() {
        return "Adding bundle item from FCM remote data with key: " + this.f43814g + " and value: " + this.f43815h;
    }
}
