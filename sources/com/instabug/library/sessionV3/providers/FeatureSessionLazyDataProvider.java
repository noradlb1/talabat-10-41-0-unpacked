package com.instabug.library.sessionV3.providers;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface FeatureSessionLazyDataProvider {
    @NotNull
    Map<String, Boolean> isDataReady(@NotNull List<String> list);
}
