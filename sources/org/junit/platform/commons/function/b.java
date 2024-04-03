package org.junit.platform.commons.function;

import java.util.concurrent.Callable;
import org.junit.platform.commons.function.Try;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Try.Success f27996b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Try.Transformer f27997c;

    public /* synthetic */ b(Try.Success success, Try.Transformer transformer) {
        this.f27996b = success;
        this.f27997c = transformer;
    }

    public final Object call() {
        return this.f27996b.lambda$andThenTry$0(this.f27997c);
    }
}
