package org.junit.jupiter.engine.discovery;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class j implements AbstractOrderingVisitor.MessageGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassOrderer f62512a;

    public /* synthetic */ j(ClassOrderer classOrderer) {
        this.f62512a = classOrderer;
    }

    public final String generateMessage(int i11) {
        return String.format("ClassOrderer [%s] added %s ClassDescriptor(s) which will be ignored.", new Object[]{ClassOrderingVisitor.nullSafeToString(this.f62512a), Integer.valueOf(i11)});
    }
}
