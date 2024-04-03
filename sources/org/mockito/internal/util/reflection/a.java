package org.mockito.internal.util.reflection;

import java.lang.invoke.MethodHandle;
import java.util.concurrent.atomic.AtomicBoolean;
import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class a implements MemberAccessor.ConstructionDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodHandle f63271a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object[] f63272b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f63273c;

    public /* synthetic */ a(MethodHandle methodHandle, Object[] objArr, AtomicBoolean atomicBoolean) {
        this.f63271a = methodHandle;
        this.f63272b = objArr;
        this.f63273c = atomicBoolean;
    }

    public final Object newInstance() {
        return InstrumentationMemberAccessor.lambda$newInstance$0(this.f63271a, this.f63272b, this.f63273c);
    }
}
