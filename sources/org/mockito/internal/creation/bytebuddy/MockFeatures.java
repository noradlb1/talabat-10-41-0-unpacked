package org.mockito.internal.creation.bytebuddy;

import java.util.Collections;
import java.util.Set;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

class MockFeatures<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f63158a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Class<?>> f63159b;

    /* renamed from: c  reason: collision with root package name */
    public final SerializableMode f63160c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f63161d;

    /* renamed from: e  reason: collision with root package name */
    public final Answer f63162e;

    private MockFeatures(Class<T> cls, Set<Class<?>> set, SerializableMode serializableMode, boolean z11, Answer answer) {
        this.f63158a = cls;
        this.f63159b = Collections.unmodifiableSet(set);
        this.f63160c = serializableMode;
        this.f63161d = z11;
        this.f63162e = answer;
    }

    public static <T> MockFeatures<T> withMockFeatures(Class<T> cls, Set<Class<?>> set, SerializableMode serializableMode, boolean z11, Answer answer) {
        return new MockFeatures(cls, set, serializableMode, z11, answer);
    }
}
