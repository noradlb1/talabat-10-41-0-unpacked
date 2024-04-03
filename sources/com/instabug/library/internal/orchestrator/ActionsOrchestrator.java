package com.instabug.library.internal.orchestrator;

import androidx.annotation.NonNull;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class ActionsOrchestrator {
    private final Executor backgroundExecutor;
    private final List<Action> sameThreadActions = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Action> workerThreadActions = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            for (Action b11 : ActionsOrchestrator.this.workerThreadActions) {
                ActionsOrchestrator.this.runAction(b11);
            }
        }
    }

    private ActionsOrchestrator(Executor executor) {
        this.backgroundExecutor = executor;
    }

    public static ActionsOrchestrator obtainOrchestrator() {
        return new ActionsOrchestrator(PoolProvider.getInstance().getBackgroundExecutor());
    }

    private void orchestrateSameThreadActions() {
        for (Action runAction : this.sameThreadActions) {
            runAction(runAction);
        }
    }

    private void orchestrateWorkerThreadActions() {
        PoolProvider.postTask(this.backgroundExecutor, new a());
    }

    /* access modifiers changed from: private */
    public void runAction(Action action) {
        try {
            action.run();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while running action: " + e11.getMessage(), e11);
        }
    }

    public ActionsOrchestrator addSameThreadAction(@NonNull Action action) {
        this.sameThreadActions.add(action);
        return this;
    }

    public ActionsOrchestrator addWorkerThreadAction(@NonNull Action action) {
        this.workerThreadActions.add(action);
        return this;
    }

    public void orchestrate() {
        orchestrateSameThreadActions();
        orchestrateWorkerThreadActions();
    }

    public static ActionsOrchestrator obtainOrchestrator(@NonNull Executor executor) {
        return new ActionsOrchestrator(executor);
    }
}
