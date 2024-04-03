package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(@Nullable Name name2, @Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId);

        @Nullable
        AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2);

        void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(@Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId);

        void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(@NotNull ClassId classId, @NotNull Name name2);
    }

    public interface AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement);

        void visitEnd();
    }

    public interface MemberVisitor {
        @Nullable
        AnnotationVisitor visitField(@NotNull Name name2, @NotNull String str, @Nullable Object obj);

        @Nullable
        MethodAnnotationVisitor visitMethod(@NotNull Name name2, @NotNull String str);
    }

    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitParameterAnnotation(int i11, @NotNull ClassId classId, @NotNull SourceElement sourceElement);
    }

    @NotNull
    KotlinClassHeader getClassHeader();

    @NotNull
    ClassId getClassId();

    @NotNull
    String getLocation();

    void loadClassAnnotations(@NotNull AnnotationVisitor annotationVisitor, @Nullable byte[] bArr);

    void visitMembers(@NotNull MemberVisitor memberVisitor, @Nullable byte[] bArr);
}
