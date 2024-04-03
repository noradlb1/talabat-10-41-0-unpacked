package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

public class FieldReader {

    /* renamed from: a  reason: collision with root package name */
    public final Object f63265a;

    /* renamed from: b  reason: collision with root package name */
    public final Field f63266b;

    /* renamed from: c  reason: collision with root package name */
    public final MemberAccessor f63267c = Plugins.getMemberAccessor();

    public FieldReader(Object obj, Field field) {
        this.f63265a = obj;
        this.f63266b = field;
    }

    public boolean isNull() {
        return read() == null;
    }

    public Object read() {
        try {
            return this.f63267c.get(this.f63266b, this.f63265a);
        } catch (Exception e11) {
            throw new MockitoException("Cannot read state from field: " + this.f63266b + ", on instance: " + this.f63265a, e11);
        }
    }
}
