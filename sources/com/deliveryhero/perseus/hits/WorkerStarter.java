package com.deliveryhero.perseus.hits;

import androidx.work.ExistingWorkPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/deliveryhero/perseus/hits/WorkerStarter;", "", "startWorker", "", "initialDelay", "", "existingWorkPolicy", "Landroidx/work/ExistingWorkPolicy;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface WorkerStarter {
    void startWorker(long j11, @NotNull ExistingWorkPolicy existingWorkPolicy);
}
