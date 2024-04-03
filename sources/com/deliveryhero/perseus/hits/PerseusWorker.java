package com.deliveryhero.perseus.hits;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import com.deliveryhero.perseus.di.HitsModule;
import com.deliveryhero.perseus.di.LoggerModule;
import com.deliveryhero.perseus.di.PerseusAppComponent;
import com.deliveryhero.perseus.logger.PerseusLogger;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w5.a;
import w5.b;
import w5.c;
import w5.d;
import w5.e;
import w5.f;
import w5.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0017J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/perseus/hits/PerseusWorker;", "Landroidx/work/RxWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "createWork", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "onError", "", "hits", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "error", "", "onSuccess", "response", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "triggerJob", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String WORKER_NAME = "perseus_worker";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/hits/PerseusWorker$Companion;", "", "()V", "WORKER_NAME", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    /* access modifiers changed from: private */
    public final void onError(List<HitEvent> list, Throwable th2) {
        LoggerModule.INSTANCE.getPerseusLogger().e("Error happened while sending hit to remote from Worker!", th2);
        PerseusWorkFinishedCallback perseusWorkFinishedCallback = HitsModule.INSTANCE.getPerseusWorkFinishedCallback();
        Result.Companion companion = Result.Companion;
        perseusWorkFinishedCallback.onWorkFinished(list, Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }

    /* access modifiers changed from: private */
    public final void onSuccess(List<HitEvent> list, HitsResponse hitsResponse) {
        PerseusLogger perseusLogger = LoggerModule.INSTANCE.getPerseusLogger();
        PerseusLogger.i$default(perseusLogger, "Send hit to remote: Response " + hitsResponse.getStatus(), (Throwable) null, 2, (Object) null);
        PerseusWorkFinishedCallback perseusWorkFinishedCallback = HitsModule.INSTANCE.getPerseusWorkFinishedCallback();
        Result.Companion companion = Result.Companion;
        perseusWorkFinishedCallback.onWorkFinished(list, Result.m6329constructorimpl(Unit.INSTANCE));
    }

    private final Single<ListenableWorker.Result> triggerJob() {
        ArrayList arrayList = new ArrayList();
        Single<R> onErrorReturn = HitsModule.INSTANCE.getHitsUseCase().run().doOnSuccess(new a(new PerseusWorker$triggerJob$1(arrayList))).filter(new b(PerseusWorker$triggerJob$2.INSTANCE)).flatMap(new c(PerseusWorker$triggerJob$3.INSTANCE)).doOnError(new d(new PerseusWorker$triggerJob$4(this, arrayList))).doOnSuccess(new e(new PerseusWorker$triggerJob$5(this, arrayList))).onErrorComplete().map(new f(PerseusWorker$triggerJob$6.INSTANCE)).toSingle().onErrorReturn(new g());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "private fun triggerJob()…ess()\n            }\n    }");
        return onErrorReturn;
    }

    /* access modifiers changed from: private */
    public static final void triggerJob$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean triggerJob$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final MaybeSource triggerJob$lambda$2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (MaybeSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void triggerJob$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void triggerJob$lambda$4(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ListenableWorker.Result triggerJob$lambda$5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (ListenableWorker.Result) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ListenableWorker.Result triggerJob$lambda$6(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return ListenableWorker.Result.success();
    }

    @NotNull
    @SuppressLint({"CheckResult"})
    public Single<ListenableWorker.Result> createWork() {
        PerseusAppComponent perseusAppComponent = PerseusAppComponent.INSTANCE;
        if (!perseusAppComponent.isInitialized()) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            perseusAppComponent.setApplicationContext(applicationContext);
        }
        return triggerJob();
    }
}
