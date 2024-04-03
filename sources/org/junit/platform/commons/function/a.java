package org.junit.platform.commons.function;

import j$.util.function.Function;
import java.util.concurrent.Callable;
import org.junit.platform.commons.function.Try;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Try.Success f27994b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f27995c;

    public /* synthetic */ a(Try.Success success, Function function) {
        this.f27994b = success;
        this.f27995c = function;
    }

    public final Object call() {
        return this.f27994b.lambda$andThen$1(this.f27995c);
    }
}
