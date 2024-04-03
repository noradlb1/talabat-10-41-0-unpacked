package com.instabug.library.util.threading;

import com.instabug.library.apichecker.ReturnableRunnable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qd.d;

public abstract class m {
    @Nullable
    public static final Object a(@NotNull ThreadPoolExecutor threadPoolExecutor, @NotNull ReturnableRunnable returnableRunnable) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<this>");
        Intrinsics.checkNotNullParameter(returnableRunnable, "runnable");
        try {
            return threadPoolExecutor.submit(new d(returnableRunnable)).get();
        } catch (ExecutionException e11) {
            e11.printStackTrace();
            return null;
        } catch (InterruptedException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final Object a(ReturnableRunnable returnableRunnable) {
        Intrinsics.checkNotNullParameter(returnableRunnable, "$runnable");
        try {
            return returnableRunnable.run();
        } catch (Throwable th2) {
            DefensiveRunnableKt.defensiveLog$default(th2, (String) null, 2, (Object) null);
            if (th2 instanceof OutOfMemoryError) {
                DefensiveRunnableKt.reportOOM(th2);
            }
            return null;
        }
    }
}
