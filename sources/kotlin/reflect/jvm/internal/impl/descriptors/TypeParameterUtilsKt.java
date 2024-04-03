package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeParameterUtilsKt {
    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i11) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i11);
    }

    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        List list2 = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.flatMap(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.takeWhile(DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                declarationDescriptor = null;
                break;
            }
            declarationDescriptor = it.next();
            if (declarationDescriptor instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (!(classDescriptor == null || (typeConstructor = classDescriptor.getTypeConstructor()) == null)) {
            list = typeConstructor.getParameters();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            Iterable<TypeParameterDescriptor> plus = CollectionsKt___CollectionsKt.plus(list2, list);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : plus) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "it");
                arrayList.add(capturedCopyForInnerDeclaration(typeParameterDescriptor, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            return CollectionsKt___CollectionsKt.plus(declaredTypeParameters, arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType r5, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r6, int r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x005a
            boolean r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(r6)
            if (r1 == 0) goto L_0x000a
            goto L_0x005a
        L_0x000a:
            java.util.List r1 = r6.getDeclaredTypeParameters()
            int r1 = r1.size()
            int r1 = r1 + r7
            boolean r2 = r6.isInner()
            if (r2 != 0) goto L_0x003d
            java.util.List r2 = r5.getArguments()
            int r2 = r2.size()
            if (r1 == r2) goto L_0x0027
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(r6)
        L_0x0027:
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r1 = new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType
            java.util.List r2 = r5.getArguments()
            java.util.List r5 = r5.getArguments()
            int r5 = r5.size()
            java.util.List r5 = r2.subList(r7, r5)
            r1.<init>(r6, r5, r0)
            return r1
        L_0x003d:
            java.util.List r2 = r5.getArguments()
            java.util.List r7 = r2.subList(r7, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r2 = new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r6.getContainingDeclaration()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
            if (r4 == 0) goto L_0x0052
            r0 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) r0
        L_0x0052:
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r5 = buildPossiblyInnerType(r5, r0, r1)
            r2.<init>(r6, r7, r5)
            return r2
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, int):kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType");
    }
}
