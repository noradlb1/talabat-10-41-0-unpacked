package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final Name f24563name;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReflectJavaAnnotationArgument create(@NotNull Object obj, @Nullable Name name2) {
            Intrinsics.checkNotNullParameter(obj, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
                return new ReflectJavaEnumValueAnnotationArgument(name2, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new ReflectJavaAnnotationAsAnnotationArgument(name2, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new ReflectJavaArrayAnnotationArgument(name2, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new ReflectJavaClassObjectAnnotationArgument(name2, (Class) obj);
            }
            return new ReflectJavaLiteralAnnotationArgument(name2, obj);
        }
    }

    private ReflectJavaAnnotationArgument(Name name2) {
        this.f24563name = name2;
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name name2, DefaultConstructorMarker defaultConstructorMarker) {
        this(name2);
    }

    @Nullable
    public Name getName() {
        return this.f24563name;
    }
}
