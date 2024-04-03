package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {
    @NotNull
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
        @NotNull
        private final Map<MemberSignature, C> annotationParametersDefaultValues;
        @NotNull
        private final Map<MemberSignature, List<A>> memberAnnotations;
        @NotNull
        private final Map<MemberSignature, C> propertyConstants;

        public AnnotationsContainerWithConstants(@NotNull Map<MemberSignature, ? extends List<? extends A>> map, @NotNull Map<MemberSignature, ? extends C> map2, @NotNull Map<MemberSignature, ? extends C> map3) {
            Intrinsics.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics.checkNotNullParameter(map2, "propertyConstants");
            Intrinsics.checkNotNullParameter(map3, "annotationParametersDefaultValues");
            this.memberAnnotations = map;
            this.propertyConstants = map2;
            this.annotationParametersDefaultValues = map3;
        }

        @NotNull
        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        @NotNull
        public Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        @NotNull
        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        super(kotlinClassFinder);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.storage = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    /* access modifiers changed from: private */
    public final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(this, hashMap, kotlinJvmBinaryClass, hashMap3, hashMap2), c(kotlinJvmBinaryClass));
        return new AnnotationsContainerWithConstants<>(hashMap, hashMap2, hashMap3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
        r4 = r10;
        r5 = r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final C loadConstantFromProperty(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r12, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r13, kotlin.reflect.jvm.internal.impl.types.KotlinType r14, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> r15) {
        /*
            r10 = this;
            r2 = 1
            r3 = 1
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST
            int r1 = r12.getFlags()
            java.lang.Boolean r4 = r0.get((int) r1)
            boolean r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(r12)
            r0 = r10
            r1 = r11
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r0 = r0.f(r1, r2, r3, r4, r5)
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r0 = r10.b(r11, r0)
            r1 = 0
            if (r0 != 0) goto L_0x001e
            return r1
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r2 = r0.getClassHeader()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r2 = r2.getMetadataVersion()
            kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$Companion r3 = kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver.Companion
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r3 = r3.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()
            boolean r9 = r2.isAtLeast(r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r6 = r11.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r7 = r11.getTypeTable()
            r4 = r10
            r5 = r12
            r8 = r13
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature r11 = r4.d(r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0042
            return r1
        L_0x0042:
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$AnnotationsContainerWithConstants<A, C>> r12 = r10.storage
            java.lang.Object r12 = r12.invoke(r0)
            java.lang.Object r11 = r15.invoke(r12, r11)
            if (r11 != 0) goto L_0x004f
            return r1
        L_0x004f:
            boolean r12 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r14)
            if (r12 == 0) goto L_0x0059
            java.lang.Object r11 = r10.transformToUnsignedConstant(r11)
        L_0x0059:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadConstantFromProperty(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    @NotNull
    /* renamed from: j */
    public AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "binaryClass");
        return this.storage.invoke(kotlinJvmBinaryClass);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.ClassId r3, @org.jetbrains.annotations.NotNull java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "annotationClassId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations r0 = kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r0.getJAVA_LANG_ANNOTATION_REPEATABLE()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            r0 = 0
            if (r3 != 0) goto L_0x0018
            return r0
        L_0x0018:
            java.lang.String r3 = "value"
            kotlin.reflect.jvm.internal.impl.name.Name r3 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r3)
            java.lang.Object r3 = r4.get(r3)
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue
            r1 = 0
            if (r4 == 0) goto L_0x002a
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue r3 = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) r3
            goto L_0x002b
        L_0x002a:
            r3 = r1
        L_0x002b:
            if (r3 != 0) goto L_0x002e
            return r0
        L_0x002e:
            java.lang.Object r3 = r3.getValue()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass
            if (r4 == 0) goto L_0x0039
            r1 = r3
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) r1
        L_0x0039:
            if (r1 != 0) goto L_0x003c
            return r0
        L_0x003c:
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = r1.getClassId()
            boolean r3 = r2.g(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.k(kotlin.reflect.jvm.internal.impl.name.ClassId, java.util.Map):boolean");
    }

    @Nullable
    public C loadAnnotationDefaultValue(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY_GETTER, kotlinType, AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1.INSTANCE);
    }

    @Nullable
    public abstract C loadConstant(@NotNull String str, @NotNull Object obj);

    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY, kotlinType, AbstractBinaryClassAnnotationAndConstantLoader$loadPropertyConstant$1.INSTANCE);
    }

    @Nullable
    public abstract C transformToUnsignedConstant(@NotNull C c11);
}
