package x20;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingConsumer;

public final /* synthetic */ class z implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThrowingConsumer f57975a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f57976b;

    public /* synthetic */ z(ThrowingConsumer throwingConsumer, Object obj) {
        this.f57975a = throwingConsumer;
        this.f57976b = obj;
    }

    public final void execute() {
        this.f57975a.accept(this.f57976b);
    }
}
