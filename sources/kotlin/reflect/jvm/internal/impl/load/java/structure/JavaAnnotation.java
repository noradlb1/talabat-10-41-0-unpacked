package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaAnnotation extends JavaElement {

    public static final class DefaultImpls {
        public static boolean isFreshlySupportedTypeUseAnnotation(@NotNull JavaAnnotation javaAnnotation) {
            return false;
        }

        public static boolean isIdeExternalAnnotation(@NotNull JavaAnnotation javaAnnotation) {
            return false;
        }
    }

    @NotNull
    Collection<JavaAnnotationArgument> getArguments();

    @Nullable
    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    @Nullable
    JavaClass resolve();
}
