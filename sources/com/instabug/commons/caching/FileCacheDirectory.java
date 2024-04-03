package com.instabug.commons.caching;

import java.io.File;
import org.jetbrains.annotations.Nullable;

public interface FileCacheDirectory {
    @Nullable
    File getFileDirectory();
}
