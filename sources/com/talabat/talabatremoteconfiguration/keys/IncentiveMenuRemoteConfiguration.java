package com.talabat.talabatremoteconfiguration.keys;

import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/keys/IncentiveMenuRemoteConfiguration;", "", "()V", "MENU_INCENTIVE_WIDGET", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "getMENU_INCENTIVE_WIDGET", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncentiveMenuRemoteConfiguration {
    @NotNull
    public static final IncentiveMenuRemoteConfiguration INSTANCE = new IncentiveMenuRemoteConfiguration();
    @NotNull
    private static final FWFKeyObject MENU_INCENTIVE_WIDGET = new FWFKeyObject("menu-incentive-widget", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);

    private IncentiveMenuRemoteConfiguration() {
    }

    @NotNull
    public final FWFKeyObject getMENU_INCENTIVE_WIDGET() {
        return MENU_INCENTIVE_WIDGET;
    }
}
