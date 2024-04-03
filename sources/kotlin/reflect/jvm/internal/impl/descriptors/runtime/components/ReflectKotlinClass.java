package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    @NotNull
    private final KotlinClassHeader classHeader;
    @NotNull
    private final Class<?> klass;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ReflectKotlinClass create(@NotNull Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, (DefaultConstructorMarker) null);
        }
    }

    private ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual((Object) this.klass, (Object) ((ReflectKotlinClass) obj).klass);
    }

    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @NotNull
    public final Class<?> getKlass() {
        return this.klass;
    }

    @NotNull
    public String getLocation() {
        StringBuilder sb2 = new StringBuilder();
        String name2 = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "klass.name");
        sb2.append(StringsKt__StringsJVMKt.replace$default(name2, '.', '/', false, 4, (Object) null));
        sb2.append(".class");
        return sb2.toString();
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, annotationVisitor);
    }

    @NotNull
    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }

    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(memberVisitor, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, memberVisitor);
    }
}
