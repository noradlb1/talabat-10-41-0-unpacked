package d30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class h1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueId f61861a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61862b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DynamicTest f61863c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TestSource f61864d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f61865e;

    public /* synthetic */ h1(UniqueId uniqueId, int i11, DynamicTest dynamicTest, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        this.f61861a = uniqueId;
        this.f61862b = i11;
        this.f61863c = dynamicTest;
        this.f61864d = testSource;
        this.f61865e = jupiterConfiguration;
    }

    public final Object get() {
        return TestFactoryTestDescriptor.lambda$createDynamicDescriptor$2(this.f61861a, this.f61862b, this.f61863c, this.f61864d, this.f61865e);
    }
}
