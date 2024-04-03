package z30;

import java.lang.reflect.Constructor;
import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class m implements MemberAccessor.ConstructionDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Constructor f63589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object[] f63590b;

    public /* synthetic */ m(Constructor constructor, Object[] objArr) {
        this.f63589a = constructor;
        this.f63590b = objArr;
    }

    public final Object newInstance() {
        return this.f63589a.newInstance(this.f63590b);
    }
}
