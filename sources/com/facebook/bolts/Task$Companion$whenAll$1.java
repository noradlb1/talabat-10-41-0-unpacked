package com.facebook.bolts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"TResult", "Lcom/facebook/bolts/Task;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Task$Companion$whenAll$1<TTaskResult, TContinuationResult> implements Continuation {
    final /* synthetic */ TaskCompletionSource<Void> $allFinished;
    final /* synthetic */ ArrayList<Exception> $causes;
    final /* synthetic */ AtomicInteger $count;
    final /* synthetic */ ReentrantLock $errorLock;
    final /* synthetic */ AtomicBoolean $isCancelled;

    public Task$Companion$whenAll$1(ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, ArrayList<Exception> arrayList, TaskCompletionSource<Void> taskCompletionSource) {
        this.$errorLock = reentrantLock;
        this.$isCancelled = atomicBoolean;
        this.$count = atomicInteger;
        this.$causes = arrayList;
        this.$allFinished = taskCompletionSource;
    }

    @Nullable
    public final Void then(@NotNull Task<Object> task) {
        Intrinsics.checkNotNullParameter(task, "it");
        if (task.isFaulted()) {
            ReentrantLock reentrantLock = this.$errorLock;
            ArrayList<Exception> arrayList = this.$causes;
            reentrantLock.lock();
            try {
                arrayList.add(task.getError());
            } finally {
                reentrantLock.unlock();
            }
        }
        if (task.isCancelled()) {
            this.$isCancelled.set(true);
        }
        if (this.$count.decrementAndGet() == 0) {
            if (this.$causes.size() != 0) {
                if (this.$causes.size() == 1) {
                    this.$allFinished.setError(this.$causes.get(0));
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("There were %d exceptions.", Arrays.copyOf(new Object[]{Integer.valueOf(this.$causes.size())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    this.$allFinished.setError(new AggregateException(format, this.$causes));
                }
            } else if (this.$isCancelled.get()) {
                this.$allFinished.setCancelled();
            } else {
                this.$allFinished.setResult(null);
            }
        }
        return null;
    }
}
