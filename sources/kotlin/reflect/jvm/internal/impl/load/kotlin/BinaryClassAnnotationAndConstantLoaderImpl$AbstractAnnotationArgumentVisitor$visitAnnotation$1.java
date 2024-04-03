package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor f24717a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor f24718b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Name f24719c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList<AnnotationDescriptor> f24720d;

    public BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor abstractAnnotationArgumentVisitor, Name name2, ArrayList<AnnotationDescriptor> arrayList) {
        this.f24717a = annotationArgumentVisitor;
        this.f24718b = abstractAnnotationArgumentVisitor;
        this.f24719c = name2;
        this.f24720d = arrayList;
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
        this.f24717a.visitEnd();
        this.f24718b.visitConstantValue(this.f24719c, new AnnotationValue((AnnotationDescriptor) CollectionsKt___CollectionsKt.single(this.f24720d)));
    }

    public void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name3, "enumEntryName");
        this.$$delegate_0.visitEnum(name2, classId, name3);
    }
}
