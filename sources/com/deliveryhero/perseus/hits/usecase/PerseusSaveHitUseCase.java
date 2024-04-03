package com.deliveryhero.perseus.hits.usecase;

import android.annotation.SuppressLint;
import androidx.work.ExistingWorkPolicy;
import com.deliveryhero.perseus.PerseusApp;
import com.deliveryhero.perseus.PerseusExecutePolicy;
import com.deliveryhero.perseus.data.local.PerseusConfigLocalDataStore;
import com.deliveryhero.perseus.hits.WorkerStarter;
import com.deliveryhero.perseus.logger.PerseusLogger;
import com.deliveryhero.perseus.repository.PerseusHitsRepository;
import com.facebook.internal.NativeProtocol;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x5.b;
import x5.c;
import x5.d;
import x5.e;
import x5.f;
import x5.g;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010J\u001c\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0003J\u001c\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/PerseusSaveHitUseCase;", "", "perseusHitsRepository", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "perseusHitsRequestProvider", "Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;", "configLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;", "workerStarter", "Lcom/deliveryhero/perseus/hits/WorkerStarter;", "perseusLogger", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "scheduler", "Lio/reactivex/Scheduler;", "(Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;Lcom/deliveryhero/perseus/hits/WorkerStarter;Lcom/deliveryhero/perseus/logger/PerseusLogger;Lio/reactivex/Scheduler;)V", "appendHitMatchId", "", "", "params", "run", "Lio/reactivex/Completable;", "runWithBatchDispatch", "runWithImmediateDispatch", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusSaveHitUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HIT_MATCH_ID = "hitMatchId";
    @NotNull
    private final PerseusConfigLocalDataStore configLocalDataStore;
    @NotNull
    private final PerseusHitsRepository perseusHitsRepository;
    @NotNull
    private final PerseusHitsRequestProvider perseusHitsRequestProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final PerseusLogger perseusLogger;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final WorkerStarter workerStarter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/PerseusSaveHitUseCase$Companion;", "", "()V", "HIT_MATCH_ID", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerseusSaveHitUseCase(@NotNull PerseusHitsRepository perseusHitsRepository2, @NotNull PerseusHitsRequestProvider perseusHitsRequestProvider2, @NotNull PerseusConfigLocalDataStore perseusConfigLocalDataStore, @NotNull WorkerStarter workerStarter2, @NotNull PerseusLogger perseusLogger2, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(perseusHitsRepository2, "perseusHitsRepository");
        Intrinsics.checkNotNullParameter(perseusHitsRequestProvider2, "perseusHitsRequestProvider");
        Intrinsics.checkNotNullParameter(perseusConfigLocalDataStore, "configLocalDataStore");
        Intrinsics.checkNotNullParameter(workerStarter2, "workerStarter");
        Intrinsics.checkNotNullParameter(perseusLogger2, "perseusLogger");
        Intrinsics.checkNotNullParameter(scheduler2, "scheduler");
        this.perseusHitsRepository = perseusHitsRepository2;
        this.perseusHitsRequestProvider = perseusHitsRequestProvider2;
        this.configLocalDataStore = perseusConfigLocalDataStore;
        this.workerStarter = workerStarter2;
        this.perseusLogger = perseusLogger2;
        this.scheduler = scheduler2;
    }

    private final Map<String, String> appendHitMatchId(Map<String, String> map) {
        if (!map.containsKey(HIT_MATCH_ID)) {
            map = MapsKt__MapsKt.toMutableMap(map);
            String str = map.get("perseusHitMatchId");
            if (str != null) {
                map.put(HIT_MATCH_ID, str);
            } else {
                PerseusLogger.w$default(this.perseusLogger, "perseusHitMatchId is missing from perseusEventPayLoad", (Throwable) null, 2, (Object) null);
            }
        }
        return map;
    }

    @SuppressLint({"CheckResult"})
    private final Completable runWithBatchDispatch(Map<String, String> map) {
        Completable doOnError = Completable.fromAction(new e(this, map)).subscribeOn(this.scheduler).doOnComplete(new f(this)).doOnError(new g(new PerseusSaveHitUseCase$runWithBatchDispatch$3(this, map)));
        Intrinsics.checkNotNullExpressionValue(doOnError, "@SuppressLint(\"CheckResu…    )\n            }\n    }");
        return doOnError;
    }

    /* access modifiers changed from: private */
    public static final void runWithBatchDispatch$lambda$4(PerseusSaveHitUseCase perseusSaveHitUseCase, Map map) {
        Intrinsics.checkNotNullParameter(perseusSaveHitUseCase, "this$0");
        Intrinsics.checkNotNullParameter(map, "$params");
        perseusSaveHitUseCase.perseusHitsRepository.insertEvent(map);
    }

    /* access modifiers changed from: private */
    public static final void runWithBatchDispatch$lambda$5(PerseusSaveHitUseCase perseusSaveHitUseCase) {
        Intrinsics.checkNotNullParameter(perseusSaveHitUseCase, "this$0");
        perseusSaveHitUseCase.workerStarter.startWorker(perseusSaveHitUseCase.configLocalDataStore.getBatchDispatchHitsDelay(), ExistingWorkPolicy.KEEP);
    }

    /* access modifiers changed from: private */
    public static final void runWithBatchDispatch$lambda$6(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    @SuppressLint({"CheckResult"})
    private final Completable runWithImmediateDispatch(Map<String, String> map) {
        Completable flatMapCompletable = this.perseusHitsRepository.perseusHits(this.perseusHitsRequestProvider.provideRequestParams(map)).subscribeOn(this.scheduler).doOnSuccess(new b(new PerseusSaveHitUseCase$runWithImmediateDispatch$1(this))).doOnError(new c(new PerseusSaveHitUseCase$runWithImmediateDispatch$2(this, map))).flatMapCompletable(new d(PerseusSaveHitUseCase$runWithImmediateDispatch$3.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "@SuppressLint(\"CheckResu…etable.complete() }\n    }");
        return flatMapCompletable;
    }

    /* access modifiers changed from: private */
    public static final void runWithImmediateDispatch$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void runWithImmediateDispatch$lambda$2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final CompletableSource runWithImmediateDispatch$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (CompletableSource) function1.invoke(obj);
    }

    @NotNull
    public final Completable run(@NotNull Map<String, ? extends Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || (str = value.toString()) == null) {
                str = "null";
            }
            linkedHashMap.put(key, str);
        }
        Map<String, String> appendHitMatchId = appendHitMatchId(linkedHashMap);
        if (PerseusApp.INSTANCE.getPolicy$perseus_release() == PerseusExecutePolicy.BATCH) {
            return runWithBatchDispatch(appendHitMatchId);
        }
        return runWithImmediateDispatch(appendHitMatchId);
    }
}
