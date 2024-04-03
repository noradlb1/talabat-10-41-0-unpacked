package com.instabug.library.internal.dataretention;

import com.instabug.library.util.TimeUtils;

/* 'enum' modifier removed */
final class i extends j {
    private static final int PERIOD_IN_MONTHS = 6;

    public i(String str, int i11) {
        super(str, i11, (i) null);
    }

    public long a() {
        return 100;
    }

    public long b() {
        return TimeUtils.monthToMillis(6);
    }
}
