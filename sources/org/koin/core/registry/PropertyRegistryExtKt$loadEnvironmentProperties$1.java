package org.koin.core.registry;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PropertyRegistryExtKt$loadEnvironmentProperties$1 extends Lambda implements Function0<String> {
    public static final PropertyRegistryExtKt$loadEnvironmentProperties$1 INSTANCE = new PropertyRegistryExtKt$loadEnvironmentProperties$1();

    public PropertyRegistryExtKt$loadEnvironmentProperties$1() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "load properties from environment";
    }
}
