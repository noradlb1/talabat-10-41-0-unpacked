package com.facebook.login;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/facebook/login/DeviceLoginManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DeviceLoginManager$Companion$instance$2 extends Lambda implements Function0<DeviceLoginManager> {
    public static final DeviceLoginManager$Companion$instance$2 INSTANCE = new DeviceLoginManager$Companion$instance$2();

    public DeviceLoginManager$Companion$instance$2() {
        super(0);
    }

    @NotNull
    public final DeviceLoginManager invoke() {
        return new DeviceLoginManager();
    }
}
