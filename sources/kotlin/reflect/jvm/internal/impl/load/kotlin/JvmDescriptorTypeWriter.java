package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmDescriptorTypeWriter<T> {
    @Nullable
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    @NotNull
    private final JvmTypeFactory<T> jvmTypeFactory;

    public final void a(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "type");
        if (this.jvmCurrentType == null) {
            if (this.jvmCurrentTypeArrayLevel > 0) {
                JvmTypeFactory<T> jvmTypeFactory2 = this.jvmTypeFactory;
                t11 = jvmTypeFactory2.createFromString(StringsKt__StringsJVMKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(t11));
            }
            this.jvmCurrentType = t11;
        }
    }

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
        }
    }

    public void writeClass(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "objectType");
        a(t11);
    }

    public void writeTypeVariable(@NotNull Name name2, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(t11, "type");
        a(t11);
    }
}
