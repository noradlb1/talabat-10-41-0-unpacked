package org.junit.jupiter.engine.discovery;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class i0 implements AbstractOrderingVisitor.MessageGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodOrderer f62510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62511b;

    public /* synthetic */ i0(MethodOrderer methodOrderer, Class cls) {
        this.f62510a = methodOrderer;
        this.f62511b = cls;
    }

    public final String generateMessage(int i11) {
        return String.format("MethodOrderer [%s] added %s MethodDescriptor(s) for test class [%s] which will be ignored.", new Object[]{this.f62510a.getClass().getName(), Integer.valueOf(i11), this.f62511b.getName()});
    }
}
