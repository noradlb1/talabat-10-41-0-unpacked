package com.talabat.talabatcore.logger.impl;

import com.talabat.talabatcore.logger.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcore/logger/impl/FakeLogger;", "Lcom/talabat/talabatcore/logger/Logger;", "()V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeLogger implements Logger {
    @NotNull
    public static final FakeLogger INSTANCE = new FakeLogger();

    private FakeLogger() {
    }

    public void debug(@NotNull String str) {
        Logger.DefaultImpls.debug(this, str);
    }

    public void error(@Nullable Throwable th2, @NotNull String str) {
        Logger.DefaultImpls.error(this, th2, str);
    }

    public void info(@NotNull String str) {
        Logger.DefaultImpls.info(this, str);
    }
}
