package com.instabug.commons.caching;

import java.io.File;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SessionCacheDirectory extends FileCacheDirectory {
    void addWatcher(int i11);

    void consentOnCleansing(int i11);

    @Nullable
    File getCurrentSessionDirectory();

    @NotNull
    List<File> getOldSessionsDirectories();

    @Nullable
    Boolean queryWatcherConsent(int i11);

    void removeWatcher(int i11);

    void setCurrentSessionId(@Nullable String str);
}
