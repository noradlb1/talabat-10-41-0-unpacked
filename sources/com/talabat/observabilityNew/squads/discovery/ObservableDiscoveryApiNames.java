package com.talabat.observabilityNew.squads.discovery;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/observabilityNew/squads/discovery/ObservableDiscoveryApiNames;", "", "()V", "APP_LAUNCH_TIME", "", "HOME_SCREEN_LOAD_TIME_ANDROID", "HOME_SCREEN_SWIM_LANES_LOAD_TIME_ANDROID", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservableDiscoveryApiNames {
    @NotNull
    public static final String APP_LAUNCH_TIME = "app_launch_time";
    @NotNull
    public static final String HOME_SCREEN_LOAD_TIME_ANDROID = "homeScreenLoadTimeAndroid";
    @NotNull
    public static final String HOME_SCREEN_SWIM_LANES_LOAD_TIME_ANDROID = "homeScreenSwimLanesLoadTimeAndroid";
    @NotNull
    public static final ObservableDiscoveryApiNames INSTANCE = new ObservableDiscoveryApiNames();

    private ObservableDiscoveryApiNames() {
    }
}
