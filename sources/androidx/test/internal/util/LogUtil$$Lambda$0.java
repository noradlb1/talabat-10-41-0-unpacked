package androidx.test.internal.util;

import androidx.test.internal.util.LogUtil;

final /* synthetic */ class LogUtil$$Lambda$0 implements LogUtil.Supplier {
    private final String arg$1;

    public LogUtil$$Lambda$0(String str) {
        this.arg$1 = str;
    }

    public Object get() {
        return LogUtil.a(this.arg$1);
    }
}
