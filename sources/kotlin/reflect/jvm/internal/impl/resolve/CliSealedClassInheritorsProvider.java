package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;

public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    @NotNull
    public static final CliSealedClassInheritorsProvider INSTANCE = new CliSealedClassInheritorsProvider();

    private CliSealedClassInheritorsProvider() {
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor classDescriptor, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope memberScope, boolean z11) {
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, DescriptorKindFilter.CLASSIFIERS, (Function1) null, 2, (Object) null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor2.isExpect()) {
                    Name name2 = classDescriptor2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
                    ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name2, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (contributedClassifier instanceof ClassDescriptor) {
                        classDescriptor2 = (ClassDescriptor) contributedClassifier;
                    } else if (contributedClassifier instanceof TypeAliasDescriptor) {
                        classDescriptor2 = ((TypeAliasDescriptor) contributedClassifier).getClassDescriptor();
                    } else {
                        classDescriptor2 = null;
                    }
                }
                if (classDescriptor2 != null) {
                    if (DescriptorUtils.isDirectSubclass(classDescriptor2, classDescriptor)) {
                        linkedHashSet.add(classDescriptor2);
                    }
                    if (z11) {
                        MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z11);
                    }
                }
            }
        }
    }

    @NotNull
    public Collection<ClassDescriptor> computeSealedSubclasses(@NotNull ClassDescriptor classDescriptor, boolean z11) {
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor declarationDescriptor2;
        Intrinsics.checkNotNullParameter(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z11) {
            declarationDescriptor = classDescriptor.getContainingDeclaration();
        } else {
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classDescriptor).iterator();
            while (true) {
                if (!it.hasNext()) {
                    declarationDescriptor2 = null;
                    break;
                }
                declarationDescriptor2 = it.next();
                if (declarationDescriptor2 instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            declarationDescriptor = declarationDescriptor2;
        }
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, ((PackageFragmentDescriptor) declarationDescriptor).getMemberScope(), z11);
        }
        MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return CollectionsKt___CollectionsKt.sortedWith(linkedHashSet, new CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1());
    }
}
