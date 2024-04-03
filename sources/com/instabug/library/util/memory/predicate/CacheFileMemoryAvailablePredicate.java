package com.instabug.library.util.memory.predicate;

import com.instabug.library.util.FileUtils;
import java.io.File;

public class CacheFileMemoryAvailablePredicate extends FileMemoryAvailablePredicate {
    public CacheFileMemoryAvailablePredicate(File file) {
        super(file);
    }

    public boolean c(File file) {
        return FileUtils.isCacheFile(file);
    }
}
