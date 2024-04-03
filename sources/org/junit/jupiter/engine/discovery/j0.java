package org.junit.jupiter.engine.discovery;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class j0 implements AbstractOrderingVisitor.MessageGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodOrderer f62513a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62514b;

    public /* synthetic */ j0(MethodOrderer methodOrderer, Class cls) {
        this.f62513a = methodOrderer;
        this.f62514b = cls;
    }

    public final String generateMessage(int i11) {
        return String.format("MethodOrderer [%s] removed %s MethodDescriptor(s) for test class [%s] which will be retained with arbitrary ordering.", new Object[]{this.f62513a.getClass().getName(), Integer.valueOf(i11), this.f62514b.getName()});
    }
}
