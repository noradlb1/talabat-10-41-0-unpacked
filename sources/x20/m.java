package x20;

import j$.util.function.Supplier;
import org.junit.jupiter.api.ClassOrderer;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57972a;

    public /* synthetic */ m(String str) {
        this.f57972a = str;
    }

    public final Object get() {
        return String.format("Failed to convert configuration parameter [%s] with value [%s] to a long. Using default seed [%s] as fallback.", new Object[]{"junit.jupiter.execution.order.random.seed", this.f57972a, Long.valueOf(ClassOrderer.Random.DEFAULT_SEED)});
    }
}
