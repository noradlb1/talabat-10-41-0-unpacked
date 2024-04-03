package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaRecordComponent extends ReflectJavaMember implements JavaRecordComponent {
    @NotNull
    private final Object recordComponent;

    public ReflectJavaRecordComponent(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "recordComponent");
        this.recordComponent = obj;
    }

    @NotNull
    public Member getMember() {
        Method loadGetAccessor = Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (loadGetAccessor != null) {
            return loadGetAccessor;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @NotNull
    public JavaType getType() {
        Class<?> loadGetType = Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (loadGetType != null) {
            return new ReflectJavaClassifierType(loadGetType);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    public boolean isVararg() {
        return false;
    }
}
