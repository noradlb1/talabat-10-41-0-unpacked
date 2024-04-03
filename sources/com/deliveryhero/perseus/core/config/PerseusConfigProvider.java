package com.deliveryhero.perseus.core.config;

import com.deliveryhero.perseus.PerseusParamsConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "", "provideConfig", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusConfigProvider {
    @NotNull
    PerseusParamsConfig provideConfig();
}
