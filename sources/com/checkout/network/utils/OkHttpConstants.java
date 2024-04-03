package com.checkout.network.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/checkout/network/utils/OkHttpConstants;", "", "()V", "CALL_TIMEOUT_MS", "", "CONNECTION_TIMEOUT_MS", "HEADER_AUTHORIZATION", "", "HEADER_USER_AGENT_NAME", "HEADER_USER_AGENT_VALUE", "READ_TIMEOUT_MS", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OkHttpConstants {
    public static final long CALL_TIMEOUT_MS = 10000;
    public static final long CONNECTION_TIMEOUT_MS = 10000;
    @NotNull
    public static final String HEADER_AUTHORIZATION = "Authorization";
    @NotNull
    public static final String HEADER_USER_AGENT_NAME = "User-Agent";
    @NotNull
    public static final String HEADER_USER_AGENT_VALUE = "checkout-android-sdk";
    @NotNull
    public static final OkHttpConstants INSTANCE = new OkHttpConstants();
    public static final long READ_TIMEOUT_MS = 30000;

    private OkHttpConstants() {
    }
}
