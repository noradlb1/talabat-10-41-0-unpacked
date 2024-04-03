package com.instabug.library.internal.storage.cache.dbv2.migration;

import org.jetbrains.annotations.Nullable;

public final class MigrationInterruptedException extends Exception {
    public MigrationInterruptedException() {
    }

    public MigrationInterruptedException(@Nullable String str) {
        super(str);
    }
}
