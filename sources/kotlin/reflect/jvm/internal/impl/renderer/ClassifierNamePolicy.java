package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public interface ClassifierNamePolicy {

    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        @NotNull
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        private FULLY_QUALIFIED() {
        }

        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name2 = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "classifier.name");
                return descriptorRenderer.renderName(name2, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return descriptorRenderer.renderFqName(fqName);
        }
    }

    public static final class SHORT implements ClassifierNamePolicy {
        @NotNull
        public static final SHORT INSTANCE = new SHORT();

        private SHORT() {
        }

        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            boolean z11;
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name2 = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "classifier.name");
                return descriptorRenderer.renderName(name2, false);
            }
            ArrayList arrayList = new ArrayList();
            DeclarationDescriptor declarationDescriptor = classifierDescriptor;
            do {
                arrayList.add(declarationDescriptor.getName());
                DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
                z11 = containingDeclaration instanceof ClassDescriptor;
                declarationDescriptor = containingDeclaration;
            } while (z11);
            return RenderingUtilsKt.renderFqName(CollectionsKt__ReversedViewsKt.asReversedMutable(arrayList));
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        @NotNull
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor classifierDescriptor) {
            Name name2 = classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
            String render = RenderingUtilsKt.render(name2);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            String qualifierName = qualifierName(containingDeclaration);
            if (qualifierName == null || Intrinsics.areEqual((Object) qualifierName, (Object) "")) {
                return render;
            }
            return qualifierName + '.' + render;
        }

        private final String qualifierName(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return qualifiedNameForSourceCode((ClassifierDescriptor) declarationDescriptor);
            }
            if (!(declarationDescriptor instanceof PackageFragmentDescriptor)) {
                return null;
            }
            FqNameUnsafe unsafe = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
            return RenderingUtilsKt.render(unsafe);
        }

        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            return qualifiedNameForSourceCode(classifierDescriptor);
        }
    }

    @NotNull
    String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer);
}
