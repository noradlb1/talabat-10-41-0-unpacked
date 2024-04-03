package org.junit.jupiter.api;

import kotlin.Metadata;
import org.junit.jupiter.api.function.Executable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "execute"}, k = 3, mv = {1, 1, 18}, xi = 128)
public final class AssertionsKt$assertThrows$3 implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f57098a;

    public AssertionsKt$assertThrows$3(Throwable th2) {
        this.f57098a = th2;
    }

    public final void execute() {
        Throwable th2 = this.f57098a;
        if (th2 != null) {
            throw th2;
        }
    }
}
