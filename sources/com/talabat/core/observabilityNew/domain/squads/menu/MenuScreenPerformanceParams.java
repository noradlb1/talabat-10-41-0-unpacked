package com.talabat.core.observabilityNew.domain.squads.menu;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/squads/menu/MenuScreenPerformanceParams;", "", "()V", "SCREEN_NAME", "", "SCREEN_NAME_DEEPLINK", "SCREEN_NAME_NATIVE", "SCREEN_TYPE", "TRACE", "TRACE_NATIVE", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuScreenPerformanceParams {
    @NotNull
    public static final MenuScreenPerformanceParams INSTANCE = new MenuScreenPerformanceParams();
    @NotNull
    public static final String SCREEN_NAME = "menuScreen";
    @NotNull
    public static final String SCREEN_NAME_DEEPLINK = "deeplinkFlutterActivity";
    @NotNull
    public static final String SCREEN_NAME_NATIVE = "vendorMenuFlutterActivity";
    @NotNull
    public static final String SCREEN_TYPE = "menu";
    @NotNull
    public static final String TRACE = "foodMenu";
    @NotNull
    public static final String TRACE_NATIVE = "TTI_SHOPPING_MENU_NATIVE";

    private MenuScreenPerformanceParams() {
    }
}
