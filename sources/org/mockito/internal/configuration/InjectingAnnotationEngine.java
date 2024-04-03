package org.mockito.internal.configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.mockito.ScopedMock;
import org.mockito.internal.configuration.injection.scanner.InjectMocksScanner;
import org.mockito.internal.configuration.injection.scanner.MockScanner;
import org.mockito.internal.util.collections.Sets;
import org.mockito.plugins.AnnotationEngine;
import u30.b;
import u30.c;

public class InjectingAnnotationEngine implements AnnotationEngine {
    private final AnnotationEngine delegate = new IndependentAnnotationEngine();
    private final AnnotationEngine spyAnnotationEngine = new SpyAnnotationEngine();

    private AutoCloseable injectCloseableMocks(Object obj) {
        HashSet hashSet = new HashSet();
        Set<Object> newMockSafeHashSet = Sets.newMockSafeHashSet(new Object[0]);
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            new InjectMocksScanner(cls).addTo(hashSet);
            new MockScanner(obj, cls).addPreparedMocks(newMockSafeHashSet);
            c(obj, cls, hashSet, newMockSafeHashSet);
        }
        new DefaultInjectionEngine().injectMocksOnFields(hashSet, newMockSafeHashSet, obj);
        return new b(newMockSafeHashSet);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$injectCloseableMocks$1(Set set) throws Exception {
        for (Object next : set) {
            if (next instanceof ScopedMock) {
                ((ScopedMock) next).closeOnDemand();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$process$0(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AutoCloseable) it.next()).close();
        }
    }

    private List<AutoCloseable> processIndependentAnnotations(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            arrayList.add(this.delegate.process(cls2, obj));
            arrayList.add(this.spyAnnotationEngine.process(cls2, obj));
        }
        return arrayList;
    }

    private List<AutoCloseable> processInjectMocks(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            arrayList.add(injectCloseableMocks(obj));
        }
        return arrayList;
    }

    public void c(Object obj, Class<?> cls, Set<Field> set, Set<Object> set2) {
    }

    @Deprecated
    public void injectMocks(Object obj) {
        try {
            injectCloseableMocks(obj).close();
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    public AutoCloseable process(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(processIndependentAnnotations(obj.getClass(), obj));
        arrayList.addAll(processInjectMocks(obj.getClass(), obj));
        return new c(arrayList);
    }
}
