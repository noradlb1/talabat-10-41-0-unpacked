package com.talabat.gem.adapters.logger;

import com.talabat.gem.GemIntegrationDsl;
import com.talabat.gem.ports.logging.LoggerPort;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@GemIntegrationDsl
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\r"}, d2 = {"Lcom/talabat/gem/adapters/logger/GemLogger;", "Lcom/talabat/gem/ports/logging/LoggerPort;", "", "tag", "", "message", "", "b", "", "throwable", "a", "<init>", "()V", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0})
public final class GemLogger extends LoggerPort {
    @NotNull
    public static final GemLogger INSTANCE = new GemLogger();

    private GemLogger() {
    }

    public void a(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        LogManager.error$default(th2, (String) null, 2, (Object) null);
    }

    public void b(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "message");
        LogManager.info(str + ": " + obj);
    }
}
