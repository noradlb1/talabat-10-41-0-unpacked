package com.talabat.splash.core.utils.NetWorkUtils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/core/utils/NetWorkUtils/NetworkConstants;", "", "()V", "APP_INFO", "", "HEADER_BRAND_TYPE_TALABAT", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkConstants {
    @NotNull
    public static final String APP_INFO = "v2/apps/appinfo/{countryId}";
    public static final int HEADER_BRAND_TYPE_TALABAT = 1;
    @NotNull
    public static final NetworkConstants INSTANCE = new NetworkConstants();

    private NetworkConstants() {
    }
}
