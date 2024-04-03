package org.apache.commons.compress.compressors.lz77support;

public final class Parameters {
    public static final int TRUE_MIN_BACK_REFERENCE_LENGTH = 3;
    private final boolean lazyMatching;
    private final int lazyThreshold;
    private final int maxBackReferenceLength;
    private final int maxCandidates;
    private final int maxLiteralLength;
    private final int maxOffset;
    private final int minBackReferenceLength;
    private final int niceBackReferenceLength;
    private final int windowSize;

    public static class Builder {
        private Boolean lazyMatches;
        private Integer lazyThreshold;
        private int maxBackReferenceLength;
        private Integer maxCandidates;
        private int maxLiteralLength;
        private int maxOffset;
        private int minBackReferenceLength;
        private Integer niceBackReferenceLength;
        private final int windowSize;

        public Parameters build() {
            int i11;
            int i12;
            boolean z11;
            int i13;
            int i14;
            Integer num = this.niceBackReferenceLength;
            if (num != null) {
                i11 = num.intValue();
            } else {
                i11 = Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 2);
            }
            int i15 = i11;
            Integer num2 = this.maxCandidates;
            if (num2 != null) {
                i12 = num2.intValue();
            } else {
                i12 = Math.max(256, this.windowSize / 128);
            }
            int i16 = i12;
            Boolean bool = this.lazyMatches;
            if (bool == null || bool.booleanValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z12 = z11;
            if (z12) {
                Integer num3 = this.lazyThreshold;
                if (num3 != null) {
                    i14 = num3.intValue();
                } else {
                    i13 = i15;
                    return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, i15, i16, z12, i13);
                }
            } else {
                i14 = this.minBackReferenceLength;
            }
            i13 = i14;
            return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, i15, i16, z12, i13);
        }

        public Builder tunedForCompressionRatio() {
            Integer valueOf = Integer.valueOf(this.maxBackReferenceLength);
            this.lazyThreshold = valueOf;
            this.niceBackReferenceLength = valueOf;
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 16));
            this.lazyMatches = Boolean.TRUE;
            return this;
        }

        public Builder tunedForSpeed() {
            this.niceBackReferenceLength = Integer.valueOf(Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 8));
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 1024));
            this.lazyMatches = Boolean.FALSE;
            this.lazyThreshold = Integer.valueOf(this.minBackReferenceLength);
            return this;
        }

        public Builder withLazyMatching(boolean z11) {
            this.lazyMatches = Boolean.valueOf(z11);
            return this;
        }

        public Builder withLazyThreshold(int i11) {
            this.lazyThreshold = Integer.valueOf(i11);
            return this;
        }

        public Builder withMaxBackReferenceLength(int i11) {
            int i12 = this.minBackReferenceLength;
            if (i11 >= i12) {
                i12 = Math.min(i11, this.windowSize - 1);
            }
            this.maxBackReferenceLength = i12;
            return this;
        }

        public Builder withMaxLiteralLength(int i11) {
            int i12;
            if (i11 < 1) {
                i12 = this.windowSize;
            } else {
                i12 = Math.min(i11, this.windowSize);
            }
            this.maxLiteralLength = i12;
            return this;
        }

        public Builder withMaxNumberOfCandidates(int i11) {
            this.maxCandidates = Integer.valueOf(i11);
            return this;
        }

        public Builder withMaxOffset(int i11) {
            this.maxOffset = i11 < 1 ? this.windowSize - 1 : Math.min(i11, this.windowSize - 1);
            return this;
        }

        public Builder withMinBackReferenceLength(int i11) {
            int max = Math.max(3, i11);
            this.minBackReferenceLength = max;
            if (this.windowSize >= max) {
                if (this.maxBackReferenceLength < max) {
                    this.maxBackReferenceLength = max;
                }
                return this;
            }
            throw new IllegalArgumentException("minBackReferenceLength can't be bigger than windowSize");
        }

        public Builder withNiceBackReferenceLength(int i11) {
            this.niceBackReferenceLength = Integer.valueOf(i11);
            return this;
        }

        private Builder(int i11) {
            if (i11 < 2 || !Parameters.isPowerOfTwo(i11)) {
                throw new IllegalArgumentException("windowSize must be a power of two");
            }
            this.windowSize = i11;
            this.minBackReferenceLength = 3;
            int i12 = i11 - 1;
            this.maxBackReferenceLength = i12;
            this.maxOffset = i12;
            this.maxLiteralLength = i11;
        }
    }

    public static Builder builder(int i11) {
        return new Builder(i11);
    }

    /* access modifiers changed from: private */
    public static boolean isPowerOfTwo(int i11) {
        return (i11 & (i11 + -1)) == 0;
    }

    public boolean getLazyMatching() {
        return this.lazyMatching;
    }

    public int getLazyMatchingThreshold() {
        return this.lazyThreshold;
    }

    public int getMaxBackReferenceLength() {
        return this.maxBackReferenceLength;
    }

    public int getMaxCandidates() {
        return this.maxCandidates;
    }

    public int getMaxLiteralLength() {
        return this.maxLiteralLength;
    }

    public int getMaxOffset() {
        return this.maxOffset;
    }

    public int getMinBackReferenceLength() {
        return this.minBackReferenceLength;
    }

    public int getNiceBackReferenceLength() {
        return this.niceBackReferenceLength;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    private Parameters(int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z11, int i18) {
        this.windowSize = i11;
        this.minBackReferenceLength = i12;
        this.maxBackReferenceLength = i13;
        this.maxOffset = i14;
        this.maxLiteralLength = i15;
        this.niceBackReferenceLength = i16;
        this.maxCandidates = i17;
        this.lazyMatching = z11;
        this.lazyThreshold = i18;
    }
}
