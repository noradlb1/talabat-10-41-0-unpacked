package com.deliveryhero.perseus.hits;

import androidx.work.ExistingWorkPolicy;
import com.deliveryhero.perseus.data.local.PerseusConfigLocalDataStore;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.logger.PerseusLogger;
import com.deliveryhero.perseus.repository.PerseusHitsRepository;
import com.deliveryhero.perseus.utils.RandomValue;
import com.google.gson.Gson;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Instrumented
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u001e\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012H\u0002J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0002J*\u0010 \u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\"ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/deliveryhero/perseus/hits/PerseusWorkFinishedCallback;", "", "perseusHitsRepository", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "workerStarter", "Lcom/deliveryhero/perseus/hits/WorkerStarter;", "perseusLogger", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "configLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;", "random", "Lcom/deliveryhero/perseus/utils/RandomValue;", "(Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;Lcom/deliveryhero/perseus/hits/WorkerStarter;Lcom/deliveryhero/perseus/logger/PerseusLogger;Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;Lcom/deliveryhero/perseus/utils/RandomValue;)V", "currentDelay", "", "delayExponent", "", "nonRetryHttpCodes", "", "enqueueWorker", "", "isBadRequest", "", "code", "onBadRequestError", "hitEvents", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "exception", "Lretrofit2/HttpException;", "onSuccess", "onUnknownError", "", "onWorkFinished", "result", "Lkotlin/Result;", "(Ljava/util/List;Ljava/lang/Object;)V", "updateCurrentDelay", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorkFinishedCallback {
    @NotNull
    private final PerseusConfigLocalDataStore configLocalDataStore;
    private double currentDelay;
    private int delayExponent;
    @NotNull
    private final List<Integer> nonRetryHttpCodes = CollectionsKt__CollectionsKt.listOf(400, 401, 403, Integer.valueOf(ErrorCode.HTTP_GONE), 422);
    @NotNull
    private final PerseusHitsRepository perseusHitsRepository;
    @NotNull
    private final PerseusLogger perseusLogger;
    @NotNull
    private final RandomValue random;
    @NotNull
    private final WorkerStarter workerStarter;

    public PerseusWorkFinishedCallback(@NotNull PerseusHitsRepository perseusHitsRepository2, @NotNull WorkerStarter workerStarter2, @NotNull PerseusLogger perseusLogger2, @NotNull PerseusConfigLocalDataStore perseusConfigLocalDataStore, @NotNull RandomValue randomValue) {
        Intrinsics.checkNotNullParameter(perseusHitsRepository2, "perseusHitsRepository");
        Intrinsics.checkNotNullParameter(workerStarter2, "workerStarter");
        Intrinsics.checkNotNullParameter(perseusLogger2, "perseusLogger");
        Intrinsics.checkNotNullParameter(perseusConfigLocalDataStore, "configLocalDataStore");
        Intrinsics.checkNotNullParameter(randomValue, "random");
        this.perseusHitsRepository = perseusHitsRepository2;
        this.workerStarter = workerStarter2;
        this.perseusLogger = perseusLogger2;
        this.configLocalDataStore = perseusConfigLocalDataStore;
        this.random = randomValue;
        this.currentDelay = (double) perseusConfigLocalDataStore.getBatchDispatchHitsDelay();
    }

    private final void enqueueWorker() {
        this.workerStarter.startWorker(MathKt__MathJVMKt.roundToLong(this.currentDelay), ExistingWorkPolicy.APPEND);
    }

    private final boolean isBadRequest(int i11) {
        return this.nonRetryHttpCodes.contains(Integer.valueOf(i11));
    }

    private final void onBadRequestError(List<HitEvent> list, HttpException httpException) {
        PerseusLogger perseusLogger2 = this.perseusLogger;
        perseusLogger2.w("Failed to send events to remote because: " + httpException.message() + ". Will delete these events: " + GsonInstrumentation.toJson(new Gson(), (Object) list), httpException);
        this.perseusHitsRepository.deleteHits(list);
    }

    private final void onSuccess(List<HitEvent> list) {
        PerseusLogger perseusLogger2 = this.perseusLogger;
        PerseusLogger.i$default(perseusLogger2, "Successfully sent " + list.size() + " events", (Throwable) null, 2, (Object) null);
        this.perseusHitsRepository.deleteHits(list);
        this.currentDelay = (double) this.configLocalDataStore.getBatchDispatchHitsDelay();
        this.delayExponent = 0;
    }

    private final void onUnknownError(Throwable th2) {
        String str;
        PerseusLogger perseusLogger2 = this.perseusLogger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to send events to remote because: ");
        if (th2 != null) {
            str = th2.getMessage();
        } else {
            str = null;
        }
        sb2.append(str);
        sb2.append(". Will retry later");
        perseusLogger2.w(sb2.toString(), th2);
        updateCurrentDelay();
    }

    private final void updateCurrentDelay() {
        double min = Math.min(((double) this.configLocalDataStore.getBatchDispatchHitsDelay()) + Math.pow(2.0d, (double) this.delayExponent) + this.random.getNextDouble(0.0d, 1.0d), 60.0d);
        this.currentDelay = min;
        if (min < 60.0d) {
            this.delayExponent++;
        }
        PerseusLogger.i$default(this.perseusLogger, "Increasing delay to next request to " + this.currentDelay, (Throwable) null, 2, (Object) null);
    }

    public final void onWorkFinished(@NotNull List<HitEvent> list, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(list, "hitEvents");
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (Result.m6336isSuccessimpl(obj)) {
            onSuccess(list);
        } else {
            if (Result.m6335isFailureimpl(obj) && (r02 instanceof HttpException)) {
                HttpException httpException = (HttpException) r02;
                if (isBadRequest(httpException.code())) {
                    onBadRequestError(list, httpException);
                }
            }
            onUnknownError(r02);
        }
        if (!list.isEmpty()) {
            PerseusLogger.i$default(this.perseusLogger, "Start worker to send next batch", (Throwable) null, 2, (Object) null);
            enqueueWorker();
            return;
        }
        PerseusLogger.i$default(this.perseusLogger, "Backlog of events seems to be empty. No worker scheduled", (Throwable) null, 2, (Object) null);
    }
}
