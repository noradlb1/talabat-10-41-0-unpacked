package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1 implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> f24714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList<A> f24715b;

    public AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1(AbstractBinaryClassAnnotationLoader<A, S> abstractBinaryClassAnnotationLoader, ArrayList<A> arrayList) {
        this.f24714a = abstractBinaryClassAnnotationLoader;
        this.f24715b = arrayList;
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return this.f24714a.i(classId, sourceElement, this.f24715b);
    }

    public void visitEnd() {
    }
}
