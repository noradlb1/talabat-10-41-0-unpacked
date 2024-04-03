package org.junit.jupiter.engine.discovery;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class k implements AbstractOrderingVisitor.MessageGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassOrderer f62515a;

    public /* synthetic */ k(ClassOrderer classOrderer) {
        this.f62515a = classOrderer;
    }

    public final String generateMessage(int i11) {
        return String.format("ClassOrderer [%s] removed %s ClassDescriptor(s) which will be retained with arbitrary ordering.", new Object[]{ClassOrderingVisitor.nullSafeToString(this.f62515a), Integer.valueOf(i11)});
    }
}
