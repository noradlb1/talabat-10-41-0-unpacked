package d30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.JupiterConfiguration;

public final /* synthetic */ class n1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f61890a;

    public /* synthetic */ n1(JupiterConfiguration jupiterConfiguration) {
        this.f61890a = jupiterConfiguration;
    }

    public final Object get() {
        return this.f61890a.getDefaultTestInstanceLifecycle();
    }
}
