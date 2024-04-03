package com.deliveryhero.performance.core.logger;

import android.content.Context;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/performance/core/logger/LoggerFileWriter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "queue", "Ljava/util/concurrent/ArrayBlockingQueue;", "", "getQueue", "()Ljava/util/concurrent/ArrayBlockingQueue;", "writeLog", "", "text", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoggerFileWriter {
    @NotNull
    private final Context context;
    @NotNull
    private final File file;
    @NotNull
    private final Job job;
    @NotNull
    private final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

    public LoggerFileWriter(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.file = new File(context2.getExternalFilesDir((String) null), LoggerFileWriterKt.PERFORMANCE_LOG_FILENAME);
        this.job = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext(LoggerFileWriterKt.PERFORMANCE_LOGGER_THREAD)), (CoroutineContext) null, (CoroutineStart) null, new LoggerFileWriter$job$1(this, (Continuation<? super LoggerFileWriter$job$1>) null), 3, (Object) null);
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final Job getJob() {
        return this.job;
    }

    @NotNull
    public final ArrayBlockingQueue<String> getQueue() {
        return this.queue;
    }

    public final void writeLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.queue.put(str);
    }
}
