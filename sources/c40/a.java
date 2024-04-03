package c40;

import java.lang.reflect.Constructor;
import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class a implements MemberAccessor.ConstructionDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MemberAccessor f63130a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Constructor f63131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f63132c;

    public /* synthetic */ a(MemberAccessor memberAccessor, Constructor constructor, Object[] objArr) {
        this.f63130a = memberAccessor;
        this.f63131b = constructor;
        this.f63132c = objArr;
    }

    public final Object newInstance() {
        return this.f63130a.newInstance(this.f63131b, this.f63132c);
    }
}
