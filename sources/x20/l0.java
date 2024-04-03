package x20;

import j$.util.function.Supplier;
import org.junit.jupiter.api.MethodOrderer;

public final /* synthetic */ class l0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57971a;

    public /* synthetic */ l0(String str) {
        this.f57971a = str;
    }

    public final Object get() {
        return String.format("Failed to convert configuration parameter [%s] with value [%s] to a long. Using default seed [%s] as fallback.", new Object[]{"junit.jupiter.execution.order.random.seed", this.f57971a, Long.valueOf(MethodOrderer.Random.DEFAULT_SEED)});
    }
}
