package org.junit.jupiter.engine.extension;

import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.engine.extension.TimeoutInvocationFactory;

public final /* synthetic */ class m0 implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        return TimeoutInvocationFactory.SingleThreadExecutorResource.lambda$new$0(runnable);
    }
}
