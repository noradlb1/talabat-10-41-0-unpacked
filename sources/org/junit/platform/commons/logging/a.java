package org.junit.platform.commons.logging;

import j$.util.function.Consumer;
import java.util.logging.LogRecord;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogRecord f27999b;

    public /* synthetic */ a(LogRecord logRecord) {
        this.f27999b = logRecord;
    }

    public final void accept(Object obj) {
        ((LogRecordListener) obj).logRecordSubmitted(this.f27999b);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
