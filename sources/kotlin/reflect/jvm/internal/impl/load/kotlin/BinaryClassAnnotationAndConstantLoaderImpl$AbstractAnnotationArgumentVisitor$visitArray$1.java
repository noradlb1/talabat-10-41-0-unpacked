package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl f24721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Name f24722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor f24723c;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<ConstantValue<?>> elements = new ArrayList<>();

    public BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, Name name2, BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor abstractAnnotationArgumentVisitor) {
        this.f24721a = binaryClassAnnotationAndConstantLoaderImpl;
        this.f24722b = name2;
        this.f24723c = abstractAnnotationArgumentVisitor;
    }

    public void visit(@Nullable Object obj) {
        this.elements.add(this.f24721a.createConstant(this.f24722b, obj));
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.f24721a;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor h11 = binaryClassAnnotationAndConstantLoaderImpl.h(classId, sourceElement, arrayList);
        Intrinsics.checkNotNull(h11);
        return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1(h11, this, arrayList);
    }

    public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
        this.elements.add(new KClassValue(classLiteralValue));
    }

    public void visitEnd() {
        this.f24723c.visitArrayValue(this.f24722b, this.elements);
    }

    public void visitEnum(@NotNull ClassId classId, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name2, "enumEntryName");
        this.elements.add(new EnumValue(classId, name2));
    }
}
