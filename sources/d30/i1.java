package d30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.DynamicDescendantFilter;
import org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class i1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueId f61867a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DynamicContainer f61869c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TestSource f61870d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DynamicDescendantFilter f61871e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f61872f;

    public /* synthetic */ i1(UniqueId uniqueId, int i11, DynamicContainer dynamicContainer, TestSource testSource, DynamicDescendantFilter dynamicDescendantFilter, JupiterConfiguration jupiterConfiguration) {
        this.f61867a = uniqueId;
        this.f61868b = i11;
        this.f61869c = dynamicContainer;
        this.f61870d = testSource;
        this.f61871e = dynamicDescendantFilter;
        this.f61872f = jupiterConfiguration;
    }

    public final Object get() {
        return TestFactoryTestDescriptor.lambda$createDynamicDescriptor$3(this.f61867a, this.f61868b, this.f61869c, this.f61870d, this.f61871e, this.f61872f);
    }
}
