package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    public static final class DefaultImpls {
        @Nullable
        public static ReflectJavaAnnotation findAnnotation(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, @NotNull FqName fqName) {
            Annotation[] declaredAnnotations;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations((r0 = r0.getDeclaredAnnotations()));
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner r0) {
            /*
                java.lang.reflect.AnnotatedElement r0 = r0.getElement()
                if (r0 == 0) goto L_0x0012
                java.lang.annotation.Annotation[] r0 = r0.getDeclaredAnnotations()
                if (r0 == 0) goto L_0x0012
                java.util.List r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations(r0)
                if (r0 != 0) goto L_0x0016
            L_0x0012:
                java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0016:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner):java.util.List");
        }

        public static boolean isDeprecatedInJavaDoc(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            return false;
        }
    }

    @Nullable
    AnnotatedElement getElement();
}
