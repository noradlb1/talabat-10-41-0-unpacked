package com.talabat.core.dispatcher.data;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/core/dispatcher/data/SingleThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "Companion", "com_talabat_core_dispatcher_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleThreadFactory implements ThreadFactory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static int ORDER = 1;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/dispatcher/data/SingleThreadFactory$Companion;", "", "()V", "ORDER", "", "com_talabat_core_dispatcher_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "r");
        Thread thread = new Thread(runnable);
        int i11 = ORDER;
        ORDER = i11 + 1;
        thread.setName("-=TalabatSingleThread{" + i11 + "}=-");
        return thread;
    }
}
