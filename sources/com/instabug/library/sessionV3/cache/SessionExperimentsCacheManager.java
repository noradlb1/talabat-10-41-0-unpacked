package com.instabug.library.sessionV3.cache;

import com.instabug.library.model.v3Session.j;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface SessionExperimentsCacheManager {
    void insert(@NotNull j jVar);

    @NotNull
    Map<Long, j> queryExperiments(@NotNull List<Long> list);
}
