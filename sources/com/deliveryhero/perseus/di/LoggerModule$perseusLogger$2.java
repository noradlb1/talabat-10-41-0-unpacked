package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.logger.PerseusLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LoggerModule$perseusLogger$2 extends Lambda implements Function0<PerseusLogger> {
    public static final LoggerModule$perseusLogger$2 INSTANCE = new LoggerModule$perseusLogger$2();

    public LoggerModule$perseusLogger$2() {
        super(0);
    }

    @NotNull
    public final PerseusLogger invoke() {
        return new PerseusLogger();
    }
}
