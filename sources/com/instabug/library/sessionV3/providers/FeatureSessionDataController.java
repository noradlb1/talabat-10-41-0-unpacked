package com.instabug.library.sessionV3.providers;

import androidx.annotation.WorkerThread;
import com.instabug.library.model.v3Session.IBGSessionData;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface FeatureSessionDataController {
    @NotNull
    @WorkerThread
    Map<String, IBGSessionData> collectSessionsData(@NotNull List<String> list);

    @WorkerThread
    void dropSessionData(@NotNull List<String> list);
}
