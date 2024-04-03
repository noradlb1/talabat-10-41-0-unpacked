package com.deliveryhero.customerchat.telephonyImpl.di;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"telephonyModule", "Lorg/koin/core/module/Module;", "getTelephonyModule", "()Lorg/koin/core/module/Module;", "telephony-no-op_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ModuleKt {
    @NotNull
    private static final Module telephonyModule = org.koin.dsl.ModuleKt.module$default(false, ModuleKt$telephonyModule$1.INSTANCE, 1, (Object) null);

    @NotNull
    public static final Module getTelephonyModule() {
        return telephonyModule;
    }
}
