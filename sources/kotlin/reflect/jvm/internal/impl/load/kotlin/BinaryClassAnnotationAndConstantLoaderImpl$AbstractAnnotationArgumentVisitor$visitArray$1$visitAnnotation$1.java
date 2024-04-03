package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor f24724a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 f24725b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList<AnnotationDescriptor> f24726c;

    public BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 binaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1, ArrayList<AnnotationDescriptor> arrayList) {
        this.f24724a = annotationArgumentVisitor;
        this.f24725b = binaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1;
        this.f24726c = arrayList;
        this.$$delegate_0 = annotationArgumentVisitor;
    }

    public void visit(@Nullable Name name2, @Nullable Object obj) {
        this.$$delegate_0.visit(name2, obj);
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.$$delegate_0.visitAnnotation(name2, classId);
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2) {
        return this.$$delegate_0.visitArray(name2);
    }

    public void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
        this.$$delegate_0.visitClassLiteral(name2, classLiteralValue);
    }

    public void visitEnd() {
        this.f24724a.visitEnd();
        this.f24725b.elements.add(new AnnotationValue((AnnotationDescriptor) CollectionsKt___CollectionsKt.single(this.f24726c)));
    }

    public void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name3, "enumEntryName");
        this.$$delegate_0.visitEnum(name2, classId, name3);
    }
}
