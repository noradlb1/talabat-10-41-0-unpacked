package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Supplier;
import java.math.BigDecimal;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BigDecimal f28074a;

    public /* synthetic */ b(BigDecimal bigDecimal) {
        this.f28074a = bigDecimal;
    }

    public final Object get() {
        return String.format("Factor '%s' specified via configuration parameter '%s' must be greater than 0", new Object[]{this.f28074a, DefaultParallelExecutionConfigurationStrategy.CONFIG_DYNAMIC_FACTOR_PROPERTY_NAME});
    }
}
