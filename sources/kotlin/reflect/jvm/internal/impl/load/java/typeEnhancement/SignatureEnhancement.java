package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.apptimize.c;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class SignatureEnhancement {
    @NotNull
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(@NotNull JavaTypeEnhancement javaTypeEnhancement) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancement, "typeEnhancement");
        this.typeEnhancement = javaTypeEnhancement;
    }

    public static /* synthetic */ KotlinType a(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z11, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z12, Function1 function1, int i11, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z11, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i11 & 32) != 0 ? false : z12, function1);
    }

    public static /* synthetic */ KotlinType b(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            typeEnhancementInfo = null;
        }
        TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo2, z11);
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, SignatureEnhancement$containsFunctionN$1.INSTANCE);
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z11, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z12, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        Function1<? super CallableMemberDescriptor, ? extends KotlinType> function12 = function1;
        SignatureParts signatureParts = new SignatureParts(annotated, z11, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, (DefaultConstructorMarker) null);
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        KotlinType kotlinType = (KotlinType) function12.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor callableMemberDescriptor3 : iterable) {
            Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor3, "it");
            arrayList.add((KotlinType) function12.invoke(callableMemberDescriptor3));
        }
        return enhance(signatureParts, kotlinType, arrayList, typeEnhancementInfo, z12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D enhanceSignature(D r21, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r22) {
        /*
            r20 = this;
            r11 = r20
            r12 = r21
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
            if (r0 != 0) goto L_0x0009
            return r12
        L_0x0009:
            r13 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r13 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor) r13
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r0 = r13.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r1 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            r14 = 1
            if (r0 != r1) goto L_0x0024
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = r13.getOriginal()
            java.util.Collection r0 = r0.getOverriddenDescriptors()
            int r0 = r0.size()
            if (r0 != r14) goto L_0x0024
            return r12
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r20.getDefaultAnnotations(r21, r22)
            r7 = r22
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r7, r0)
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            r15 = 0
            if (r0 == 0) goto L_0x0050
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r1 = r0.getGetter()
            if (r1 == 0) goto L_0x0044
            boolean r1 = r1.isDefault()
            if (r1 != 0) goto L_0x0044
            r1 = r14
            goto L_0x0045
        L_0x0044:
            r1 = r15
        L_0x0045:
            if (r1 == 0) goto L_0x0050
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r0 = r0.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r9 = r0
            goto L_0x0051
        L_0x0050:
            r9 = r12
        L_0x0051:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r13.getExtensionReceiverParameter()
            r10 = 0
            if (r0 == 0) goto L_0x007e
            boolean r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 != 0) goto L_0x005e
            r0 = r10
            goto L_0x005f
        L_0x005e:
            r0 = r9
        L_0x005f:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            if (r0 == 0) goto L_0x006d
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER
            java.lang.Object r0 = r0.getUserData(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = r0
            goto L_0x006e
        L_0x006d:
            r2 = r10
        L_0x006e:
            r4 = 0
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE
            r0 = r20
            r1 = r21
            r3 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.enhanceValueParameter(r1, r2, r3, r4, r5, r6)
            r16 = r0
            goto L_0x0080
        L_0x007e:
            r16 = r10
        L_0x0080:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            if (r0 == 0) goto L_0x0088
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r0
            goto L_0x0089
        L_0x0088:
            r0 = r10
        L_0x0089:
            if (r0 == 0) goto L_0x00b0
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r0.getContainingDeclaration()
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            r3 = 3
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r0, r15, r15, r3, r10)
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(r1, r2, r0)
            if (r0 == 0) goto L_0x00b0
            java.util.Map r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE()
            java.lang.Object r0 = r1.get(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo) r0
            r17 = r0
            goto L_0x00b2
        L_0x00b0:
            r17 = r10
        L_0x00b2:
            if (r17 == 0) goto L_0x00c2
            java.util.List r0 = r17.getParametersInfo()
            r0.size()
            java.util.List r0 = r13.getValueParameters()
            r0.size()
        L_0x00c2:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r22.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState r0 = r0.getJavaTypeEnhancementState()
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.isJspecifyEnabledInStrictMode(r0)
            if (r0 != 0) goto L_0x00de
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r8.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r0 = r0.getSettings()
            boolean r0 = r0.getIgnoreNullabilityForErasedValueParameters()
            if (r0 == 0) goto L_0x00e6
        L_0x00de:
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.hasErasedValueParameters(r21)
            if (r0 == 0) goto L_0x00e6
            r7 = r14
            goto L_0x00e7
        L_0x00e6:
            r7 = r15
        L_0x00e7:
            java.util.List r0 = r9.getValueParameters()
            java.lang.String r1 = "annotationOwnerForMember.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r5 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r5)
            r6.<init>(r1)
            java.util.Iterator r18 = r0.iterator()
        L_0x0101:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x0140
            java.lang.Object r0 = r18.next()
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            if (r17 == 0) goto L_0x0122
            java.util.List r0 = r17.getParametersInfo()
            if (r0 == 0) goto L_0x0122
            int r1 = r2.getIndex()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo) r0
            r4 = r0
            goto L_0x0123
        L_0x0122:
            r4 = r10
        L_0x0123:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 r3 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1
            r3.<init>(r2)
            r0 = r20
            r1 = r21
            r19 = r3
            r3 = r8
            r15 = r5
            r5 = r7
            r15 = r6
            r6 = r19
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.enhanceValueParameter(r1, r2, r3, r4, r5, r6)
            r15.add(r0)
            r6 = r15
            r5 = 10
            r15 = 0
            goto L_0x0101
        L_0x0140:
            r15 = r6
            r3 = 1
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
            if (r0 != 0) goto L_0x0148
            r0 = r10
            goto L_0x0149
        L_0x0148:
            r0 = r12
        L_0x0149:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r0
            if (r0 == 0) goto L_0x0155
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt.isJavaField(r0)
            if (r0 != r14) goto L_0x0155
            r0 = r14
            goto L_0x0156
        L_0x0155:
            r0 = 0
        L_0x0156:
            if (r0 == 0) goto L_0x015b
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.FIELD
            goto L_0x015d
        L_0x015b:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE
        L_0x015d:
            r5 = r0
            if (r17 == 0) goto L_0x0166
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r0 = r17.getReturnTypeInfo()
            r6 = r0
            goto L_0x0167
        L_0x0166:
            r6 = r10
        L_0x0167:
            r7 = 0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 r17 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE
            r18 = 32
            r19 = 0
            r0 = r20
            r1 = r21
            r2 = r9
            r4 = r8
            r8 = r17
            r9 = r18
            r17 = r10
            r10 = r19
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r13.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r11.containsFunctionN(r1)
            if (r1 != 0) goto L_0x01e0
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r13.getExtensionReceiverParameter()
            if (r1 == 0) goto L_0x019e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            if (r1 == 0) goto L_0x019e
            boolean r1 = r11.containsFunctionN(r1)
            goto L_0x019f
        L_0x019e:
            r1 = 0
        L_0x019f:
            if (r1 != 0) goto L_0x01e0
            java.util.List r1 = r13.getValueParameters()
            java.lang.String r2 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L_0x01bb
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01bb
        L_0x01b9:
            r1 = 0
            goto L_0x01db
        L_0x01bb:
            java.util.Iterator r1 = r1.iterator()
        L_0x01bf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01b9
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            java.lang.String r3 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = r11.containsFunctionN(r2)
            if (r2 == 0) goto L_0x01bf
            r1 = r14
        L_0x01db:
            if (r1 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r1 = 0
            goto L_0x01e1
        L_0x01e0:
            r1 = r14
        L_0x01e1:
            if (r1 == 0) goto L_0x01f1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey r1 = kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY()
            kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo r2 = new kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo
            r2.<init>(r12)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r2)
            goto L_0x01f3
        L_0x01f1:
            r10 = r17
        L_0x01f3:
            if (r16 != 0) goto L_0x021c
            if (r0 != 0) goto L_0x021c
            boolean r1 = r15.isEmpty()
            if (r1 == 0) goto L_0x01ff
        L_0x01fd:
            r14 = 0
            goto L_0x0216
        L_0x01ff:
            java.util.Iterator r1 = r15.iterator()
        L_0x0203:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01fd
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            if (r2 == 0) goto L_0x0213
            r2 = r14
            goto L_0x0214
        L_0x0213:
            r2 = 0
        L_0x0214:
            if (r2 == 0) goto L_0x0203
        L_0x0216:
            if (r14 != 0) goto L_0x021c
            if (r10 == 0) goto L_0x021b
            goto L_0x021c
        L_0x021b:
            return r12
        L_0x021c:
            if (r16 != 0) goto L_0x022c
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r13.getExtensionReceiverParameter()
            if (r1 == 0) goto L_0x0229
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            goto L_0x022e
        L_0x0229:
            r1 = r17
            goto L_0x022e
        L_0x022c:
            r1 = r16
        L_0x022e:
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r15, r3)
            r2.<init>(r3)
            java.util.Iterator r3 = r15.iterator()
            r15 = 0
        L_0x023e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x026b
            java.lang.Object r4 = r3.next()
            int r5 = r15 + 1
            if (r15 >= 0) goto L_0x024f
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x024f:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            if (r4 != 0) goto L_0x0266
            java.util.List r4 = r13.getValueParameters()
            java.lang.Object r4 = r4.get(r15)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            java.lang.String r6 = "valueParameters[index].type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
        L_0x0266:
            r2.add(r4)
            r15 = r5
            goto L_0x023e
        L_0x026b:
            if (r0 != 0) goto L_0x0274
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r13.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
        L_0x0274:
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r0 = r13.enhance(r1, r2, r0, r10)
            java.lang.String r1 = "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z11, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContext2;
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        if (valueParameterDescriptor == null || (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) {
            lazyJavaResolverContext2 = lazyJavaResolverContext;
        } else {
            lazyJavaResolverContext2 = copyWithNewDefaultTypeQualifiers;
        }
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, lazyJavaResolverContext2, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z11, function1);
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d11, LazyJavaResolverContext lazyJavaResolverContext) {
        LazyJavaClassDescriptor lazyJavaClassDescriptor;
        boolean z11;
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d11);
        if (topLevelContainingClassifier == null) {
            return d11.getAnnotations();
        }
        List<JavaAnnotation> list = null;
        if (topLevelContainingClassifier instanceof LazyJavaClassDescriptor) {
            lazyJavaClassDescriptor = (LazyJavaClassDescriptor) topLevelContainingClassifier;
        } else {
            lazyJavaClassDescriptor = null;
        }
        if (lazyJavaClassDescriptor != null) {
            list = lazyJavaClassDescriptor.getModuleAnnotations();
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return d11.getAnnotations();
        }
        Iterable<JavaAnnotation> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (JavaAnnotation lazyJavaAnnotationDescriptor : iterable) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, lazyJavaAnnotationDescriptor, true));
        }
        return Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(d11.getAnnotations(), (Annotations) arrayList));
    }

    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull Collection<? extends D> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(collection, "platformSignatures");
        Iterable<CallableMemberDescriptor> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor enhanceSignature : iterable) {
            arrayList.add(enhanceSignature(enhanceSignature, lazyJavaResolverContext));
        }
        return arrayList;
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType kotlinType, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        KotlinType b11 = b(this, new SignatureParts((Annotated) null, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_USE, true), kotlinType, CollectionsKt__CollectionsKt.emptyList(), (TypeEnhancementInfo) null, false, 12, (Object) null);
        if (b11 == null) {
            return kotlinType;
        }
        return b11;
    }

    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull List<? extends KotlinType> list, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(list, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        Iterable<KotlinType> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            if (!TypeUtilsKt.contains(kotlinType, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                KotlinType kotlinType2 = kotlinType;
                KotlinType b11 = b(this, new SignatureParts(typeParameterDescriptor, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, (DefaultConstructorMarker) null), kotlinType2, CollectionsKt__CollectionsKt.emptyList(), (TypeEnhancementInfo) null, false, 12, (Object) null);
                if (b11 != null) {
                    kotlinType = b11;
                }
            }
            arrayList.add(kotlinType);
        }
        return arrayList;
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z11) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z11), signatureParts.getSkipRawTypeArguments());
    }
}
