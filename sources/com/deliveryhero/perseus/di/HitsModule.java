package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.hits.PerseusWorkFinishedCallback;
import com.deliveryhero.perseus.hits.WorkerStarter;
import com.deliveryhero.perseus.hits.WorkerStarterImpl;
import com.deliveryhero.perseus.hits.usecase.DeleteStaleEventsUseCase;
import com.deliveryhero.perseus.hits.usecase.GetHitsUseCase;
import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import com.deliveryhero.perseus.hits.usecase.PerseusSendHitUseCase;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/perseus/di/HitsModule;", "", "()V", "perseusWorkFinishedCallback", "Lcom/deliveryhero/perseus/hits/PerseusWorkFinishedCallback;", "getPerseusWorkFinishedCallback", "()Lcom/deliveryhero/perseus/hits/PerseusWorkFinishedCallback;", "perseusWorkFinishedCallback$delegate", "Lkotlin/Lazy;", "workerStarter", "Lcom/deliveryhero/perseus/hits/WorkerStarter;", "getWorkerStarter", "()Lcom/deliveryhero/perseus/hits/WorkerStarter;", "setWorkerStarter", "(Lcom/deliveryhero/perseus/hits/WorkerStarter;)V", "getDeleteStaleEventsUseCase", "Lcom/deliveryhero/perseus/hits/usecase/DeleteStaleEventsUseCase;", "getHitsUseCase", "Lcom/deliveryhero/perseus/hits/usecase/GetHitsUseCase;", "getPerseusSaveHitUseCase", "Lcom/deliveryhero/perseus/hits/usecase/PerseusSaveHitUseCase;", "perseusSendHitUseCase", "Lcom/deliveryhero/perseus/hits/usecase/PerseusSendHitUseCase;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HitsModule {
    @NotNull
    public static final HitsModule INSTANCE = new HitsModule();
    @NotNull
    private static final Lazy perseusWorkFinishedCallback$delegate = LazyKt__LazyJVMKt.lazy(HitsModule$perseusWorkFinishedCallback$2.INSTANCE);
    @NotNull
    private static WorkerStarter workerStarter = new WorkerStarterImpl(DataModule.INSTANCE.getWorkManager());

    private HitsModule() {
    }

    @NotNull
    public final DeleteStaleEventsUseCase getDeleteStaleEventsUseCase() {
        return new DeleteStaleEventsUseCase(DataModule.INSTANCE.getPerseusHitsLocalDataStore());
    }

    @NotNull
    public final GetHitsUseCase getHitsUseCase() {
        return new GetHitsUseCase(DataModule.INSTANCE.getPerseusHitsRepository());
    }

    @NotNull
    public final PerseusSaveHitUseCase getPerseusSaveHitUseCase() {
        DataModule dataModule = DataModule.INSTANCE;
        return new PerseusSaveHitUseCase(dataModule.getPerseusHitsRepository(), dataModule.getPerseusHitsRequestProvider(), dataModule.getPerseusConfigLocalDataStore(), workerStarter, LoggerModule.INSTANCE.getPerseusLogger(), CoreModule.INSTANCE.getScheduler());
    }

    @NotNull
    public final PerseusWorkFinishedCallback getPerseusWorkFinishedCallback() {
        return (PerseusWorkFinishedCallback) perseusWorkFinishedCallback$delegate.getValue();
    }

    @NotNull
    public final WorkerStarter getWorkerStarter() {
        return workerStarter;
    }

    @NotNull
    public final PerseusSendHitUseCase perseusSendHitUseCase() {
        DataModule dataModule = DataModule.INSTANCE;
        return new PerseusSendHitUseCase(dataModule.getPerseusHitsRepository(), dataModule.getPerseusHitsRequestProvider(), CoreModule.INSTANCE.getScheduler());
    }

    public final void setWorkerStarter(@NotNull WorkerStarter workerStarter2) {
        Intrinsics.checkNotNullParameter(workerStarter2, "<set-?>");
        workerStarter = workerStarter2;
    }
}
