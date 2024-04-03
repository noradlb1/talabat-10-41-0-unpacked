package kotlin.reflect.jvm.internal.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class SpecialJvmAnnotations {
    @NotNull
    public static final SpecialJvmAnnotations INSTANCE = new SpecialJvmAnnotations();
    @NotNull
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE;
    @NotNull
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;

    static {
        FqName[] fqNameArr = {JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION};
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : CollectionsKt__CollectionsKt.listOf(fqNameArr)) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        SPECIAL_ANNOTATIONS = linkedHashSet;
        ClassId classId = ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        JAVA_LANG_ANNOTATION_REPEATABLE = classId;
    }

    private SpecialJvmAnnotations() {
    }

    @NotNull
    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    @NotNull
    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "klass");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        kotlinJvmBinaryClass.loadClassAnnotations(new SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1(booleanRef), (byte[]) null);
        return booleanRef.element;
    }
}
