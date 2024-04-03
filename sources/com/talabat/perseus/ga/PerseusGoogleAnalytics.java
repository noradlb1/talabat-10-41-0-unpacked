package com.talabat.perseus.ga;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/perseus/ga/PerseusGoogleAnalytics;", "", "()V", "CLIENT_ID_KEY", "", "HIT_MATCH_ID_KEY", "SESSION_ID_KEY", "perseus_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusGoogleAnalytics {
    @NotNull
    public static final String CLIENT_ID_KEY = "perseusClientId";
    @NotNull
    public static final String HIT_MATCH_ID_KEY = "perseusHitMatchId";
    @NotNull
    public static final PerseusGoogleAnalytics INSTANCE = new PerseusGoogleAnalytics();
    @NotNull
    public static final String SESSION_ID_KEY = "perseusSessionId";

    private PerseusGoogleAnalytics() {
    }
}
