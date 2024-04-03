package com.deliveryhero.perseus;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import io.reactivex.Single;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/perseus/PerseusWorker;", "Landroidx/work/RxWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "worker", "Lcom/deliveryhero/perseus/hits/PerseusWorker;", "getWorker", "()Lcom/deliveryhero/perseus/hits/PerseusWorker;", "worker$delegate", "Lkotlin/Lazy;", "createWork", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "This worker should not be used anymore. Please see doc for more information")
public final class PerseusWorker extends RxWorker {
    @NotNull
    private final Lazy worker$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        this.worker$delegate = LazyKt__LazyJVMKt.lazy(new PerseusWorker$worker$2(context, workerParameters));
    }

    private final com.deliveryhero.perseus.hits.PerseusWorker getWorker() {
        return (com.deliveryhero.perseus.hits.PerseusWorker) this.worker$delegate.getValue();
    }

    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        return getWorker().createWork();
    }
}
