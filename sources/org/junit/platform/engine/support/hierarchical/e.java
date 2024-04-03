package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.commons.function.Try;
import org.junit.platform.engine.ConfigurationParameters;

public final /* synthetic */ class e implements Try.Transformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigurationParameters f28076a;

    public /* synthetic */ e(ConfigurationParameters configurationParameters) {
        this.f28076a = configurationParameters;
    }

    public final Object apply(Object obj) {
        return ((ParallelExecutionConfigurationStrategy) obj).createConfiguration(this.f28076a);
    }
}
