package com.huawei.wearengine.device;

public class ScanFilter {
    public static final int SCAN_TYPE_CONTAIN = 4;
    public static final int SCAN_TYPE_EMPTY = 0;
    public static final int SCAN_TYPE_EXACT = 1;
    public static final int SCAN_TYPE_MAC_EXACT = 5;
    public static final int SCAN_TYPE_PREFIX = 2;
    public static final int SCAN_TYPE_SUFFIX = 3;
    private String mMatcher;
    private int mType;

    public static class Builder {
        /* access modifiers changed from: private */
        public String mMatcher;
        /* access modifiers changed from: private */
        public int mType = 0;

        public ScanFilter build() {
            return new ScanFilter(this);
        }

        public Builder setMatcher(String str) {
            this.mMatcher = str;
            return this;
        }

        public Builder setType(int i11) {
            this.mType = i11;
            return this;
        }
    }

    public ScanFilter(Builder builder) {
        this.mType = builder.mType;
        this.mMatcher = builder.mMatcher;
    }

    public String getMatcher() {
        return this.mMatcher;
    }

    public int getType() {
        return this.mType;
    }
}
