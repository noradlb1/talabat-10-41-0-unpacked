package kotlin.reflect.jvm.internal.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1 implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f24450a;

    public SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1(Ref.BooleanRef booleanRef) {
        this.f24450a = booleanRef;
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        if (!Intrinsics.areEqual((Object) classId, (Object) JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
            return null;
        }
        this.f24450a.element = true;
        return null;
    }

    public void visitEnd() {
    }
}
