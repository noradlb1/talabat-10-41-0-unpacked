package com.instabug.library.tracking;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FirstFGTimeProvider {

    public static final class Factory {
        @NotNull
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @NotNull
        public final FirstFGTimeProvider invoke() {
            return c.f51918c;
        }
    }

    @Nullable
    Long getFirstFGTime();
}
