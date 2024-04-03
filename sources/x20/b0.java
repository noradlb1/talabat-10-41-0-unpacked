package x20;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingConsumer;

public final /* synthetic */ class b0 implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThrowingConsumer f57964a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Named f57965b;

    public /* synthetic */ b0(ThrowingConsumer throwingConsumer, Named named) {
        this.f57964a = throwingConsumer;
        this.f57965b = named;
    }

    public final void execute() {
        this.f57964a.accept(this.f57965b.getPayload());
    }
}
