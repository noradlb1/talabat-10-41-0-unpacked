package y30;

import j$.util.function.Supplier;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MockCreationSettings f63586a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MockHandler f63587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f63588c;

    public /* synthetic */ b(MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        this.f63586a = mockCreationSettings;
        this.f63587b = mockHandler;
        this.f63588c = obj;
    }

    public final Object get() {
        return MockUtil.lambda$createMock$0(this.f63586a, this.f63587b, this.f63588c);
    }
}
