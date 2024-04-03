package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationOwnerKt {
    @Nullable
    public static final ReflectJavaAnnotation findAnnotation(@NotNull Annotation[] annotationArr, @NotNull FqName fqName) {
        Annotation annotation;
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        int length = annotationArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i11];
            if (Intrinsics.areEqual((Object) ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation))).asSingleFqName(), (Object) fqName)) {
                break;
            }
            i11++;
        }
        if (annotation != null) {
            return new ReflectJavaAnnotation(annotation);
        }
        return null;
    }

    @NotNull
    public static final List<ReflectJavaAnnotation> getAnnotations(@NotNull Annotation[] annotationArr) {
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation reflectJavaAnnotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(reflectJavaAnnotation));
        }
        return arrayList;
    }
}
