package com.checkout.base.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/checkout/base/util/EnvironmentConstants;", "", "()V", "PRODUCTION_SERVER_URL", "", "SANDBOX_SERVER_URL", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EnvironmentConstants {
    @NotNull
    public static final EnvironmentConstants INSTANCE = new EnvironmentConstants();
    @NotNull
    public static final String PRODUCTION_SERVER_URL = "https://api.checkout.com/tokens";
    @NotNull
    public static final String SANDBOX_SERVER_URL = "https://api.sandbox.checkout.com/tokens";

    private EnvironmentConstants() {
    }
}
