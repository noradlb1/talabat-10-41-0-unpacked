package com.talabat.darkstores.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"appComponent", "Lcom/talabat/darkstores/di/ApplicationComponent;", "getAppComponent", "()Lcom/talabat/darkstores/di/ApplicationComponent;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class InjectorKt {
    @NotNull
    public static final ApplicationComponent getAppComponent() {
        ApplicationComponent appComponent = Injector.INSTANCE.getAppComponent();
        Intrinsics.checkNotNull(appComponent);
        return appComponent;
    }
}
