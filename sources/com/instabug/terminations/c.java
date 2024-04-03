package com.instabug.terminations;

import com.instabug.commons.caching.FileCacheDirectory;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class c extends PropertyReference0Impl {
    public c(Object obj) {
        super(obj, FileCacheDirectory.class, "fileDirectory", "getFileDirectory()Ljava/io/File;", 0);
    }

    @Nullable
    public Object get() {
        return ((FileCacheDirectory) this.receiver).getFileDirectory();
    }
}
