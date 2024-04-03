package com.deliveryhero.perseus.core.config;

import com.deliveryhero.perseus.PerseusApp;
import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.di.DataModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/core/config/PerseusConfigProviderImpl;", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "()V", "provideConfig", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusConfigProviderImpl implements PerseusConfigProvider {
    @NotNull
    public PerseusParamsConfig provideConfig() {
        PerseusParamsConfig config = DataModule.INSTANCE.getPerseusConfigLocalDataStore().getConfig();
        return config == null ? PerseusApp.INSTANCE.getConfig$perseus_release() : config;
    }
}
