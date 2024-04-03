package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 implements KotlinJvmBinaryClass.MemberVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> f24706a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap<MemberSignature, List<A>> f24707b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KotlinJvmBinaryClass f24708c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HashMap<MemberSignature, C> f24709d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ HashMap<MemberSignature, C> f24710e;

    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 f24711b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnnotationVisitorForMethod(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            this.f24711b = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i11, @NotNull ClassId classId, @NotNull SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(a(), i11);
            List list = this.f24711b.f24707b.get(fromMethodSignatureAndParameterIndex);
            if (list == null) {
                list = new ArrayList();
                this.f24711b.f24707b.put(fromMethodSignatureAndParameterIndex, list);
            }
            return this.f24711b.f24706a.i(classId, sourceElement, list);
        }
    }

    public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 f24712a;
        @NotNull
        private final ArrayList<A> result = new ArrayList<>();
        @NotNull
        private final MemberSignature signature;

        public MemberAnnotationVisitor(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            this.f24712a = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            this.signature = memberSignature;
        }

        @NotNull
        public final MemberSignature a() {
            return this.signature;
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            return this.f24712a.f24706a.i(classId, sourceElement, this.result);
        }

        public void visitEnd() {
            if (!this.result.isEmpty()) {
                this.f24712a.f24707b.put(this.signature, this.result);
            }
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> hashMap, KotlinJvmBinaryClass kotlinJvmBinaryClass, HashMap<MemberSignature, C> hashMap2, HashMap<MemberSignature, C> hashMap3) {
        this.f24706a = abstractBinaryClassAnnotationAndConstantLoader;
        this.f24707b = hashMap;
        this.f24708c = kotlinJvmBinaryClass;
        this.f24709d = hashMap2;
        this.f24710e = hashMap3;
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name name2, @NotNull String str, @Nullable Object obj) {
        C loadConstant;
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
        if (!(obj == null || (loadConstant = this.f24706a.loadConstant(str, obj)) == null)) {
            this.f24710e.put(fromFieldNameAndDesc, loadConstant);
        }
        return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
    }

    @Nullable
    public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name name2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, str));
    }
}
