package androidx.test.internal.util;

import androidx.test.internal.util.LogUtil;

final /* synthetic */ class LogUtil$$Lambda$1 implements LogUtil.Supplier {
    private final String arg$1;

    public LogUtil$$Lambda$1(String str) {
        this.arg$1 = str;
    }

    public Object get() {
        return LogUtil.b(this.arg$1);
    }
}
