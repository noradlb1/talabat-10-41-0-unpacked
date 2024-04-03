package org.apache.commons.compress.archivers.sevenz;

public class SevenZFileOptions {
    public static final SevenZFileOptions DEFAULT = new SevenZFileOptions(Integer.MAX_VALUE, false, false);
    private static final boolean DEFAULT_TRY_TO_RECOVER_BROKEN_ARCHIVES = false;
    private static final boolean DEFAULT_USE_DEFAULTNAME_FOR_UNNAMED_ENTRIES = false;
    private static final int DEFAUL_MEMORY_LIMIT_IN_KB = Integer.MAX_VALUE;
    private final int maxMemoryLimitInKb;
    private final boolean tryToRecoverBrokenArchives;
    private final boolean useDefaultNameForUnnamedEntries;

    public static class Builder {
        private int maxMemoryLimitInKb = Integer.MAX_VALUE;
        private boolean tryToRecoverBrokenArchives = false;
        private boolean useDefaultNameForUnnamedEntries = false;

        public SevenZFileOptions build() {
            return new SevenZFileOptions(this.maxMemoryLimitInKb, this.useDefaultNameForUnnamedEntries, this.tryToRecoverBrokenArchives);
        }

        public Builder withMaxMemoryLimitInKb(int i11) {
            this.maxMemoryLimitInKb = i11;
            return this;
        }

        public Builder withTryToRecoverBrokenArchives(boolean z11) {
            this.tryToRecoverBrokenArchives = z11;
            return this;
        }

        public Builder withUseDefaultNameForUnnamedEntries(boolean z11) {
            this.useDefaultNameForUnnamedEntries = z11;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getMaxMemoryLimitInKb() {
        return this.maxMemoryLimitInKb;
    }

    public boolean getTryToRecoverBrokenArchives() {
        return this.tryToRecoverBrokenArchives;
    }

    public boolean getUseDefaultNameForUnnamedEntries() {
        return this.useDefaultNameForUnnamedEntries;
    }

    private SevenZFileOptions(int i11, boolean z11, boolean z12) {
        this.maxMemoryLimitInKb = i11;
        this.useDefaultNameForUnnamedEntries = z11;
        this.tryToRecoverBrokenArchives = z12;
    }
}
