package org.mockito.internal.configuration.injection.filter;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.reflection.BeanPropertySetter;
import org.mockito.plugins.MemberAccessor;
import v30.a;

public class TerminalMockCandidateFilter implements MockCandidateFilter {
    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$filterCandidate$0(Object obj, Field field, Object obj2, MemberAccessor memberAccessor) {
        try {
            if (!new BeanPropertySetter(obj, field).set(obj2)) {
                memberAccessor.set(field, obj, obj2);
            }
            return obj2;
        } catch (IllegalAccessException | RuntimeException e11) {
            throw Reporter.cannotInjectDependency(field, obj2, e11);
        }
    }

    public OngoingInjector filterCandidate(Collection<Object> collection, Field field, List<Field> list, Object obj) {
        if (collection.size() == 1) {
            return new a(obj, field, collection.iterator().next(), Plugins.getMemberAccessor());
        }
        return OngoingInjector.nop;
    }
}
