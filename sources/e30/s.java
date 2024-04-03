package e30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.JupiterConfiguration;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f61974a;

    public /* synthetic */ s(JupiterConfiguration jupiterConfiguration) {
        this.f61974a = jupiterConfiguration;
    }

    public final Object get() {
        return this.f61974a.getDefaultTestMethodOrderer();
    }
}
