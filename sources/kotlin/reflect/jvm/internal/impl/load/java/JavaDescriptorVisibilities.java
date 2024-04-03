package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaDescriptorVisibilities {
    @NotNull
    public static final DescriptorVisibility PACKAGE_VISIBILITY;
    @NotNull
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE;
    @NotNull
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY;
    @NotNull
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = new HashMap();

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 5 || i11 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 5 || i11 == 6) ? 2 : 3)];
        switch (i11) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i11 == 5 || i11 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i11 == 2 || i11 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i11 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (!(i11 == 5 || i11 == 6)) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        throw ((i11 == 5 || i11 == 6) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    static {
        AnonymousClass1 r02 = new DelegatedDescriptorVisibility(JavaVisibilities.PackageVisibility.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return JavaDescriptorVisibilities.areInSamePackage(declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PACKAGE_VISIBILITY = r02;
        AnonymousClass2 r12 = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedStaticVisibility.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PROTECTED_STATIC_VISIBILITY = r12;
        AnonymousClass3 r22 = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedAndPackage.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PROTECTED_AND_PACKAGE = r22;
        recordVisibilityMapping(r02);
        recordVisibilityMapping(r12);
        recordVisibilityMapping(r22);
    }

    /* access modifiers changed from: private */
    public static boolean areInSamePackage(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(3);
        }
        Class<PackageFragmentDescriptor> cls = PackageFragmentDescriptor.class;
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, cls, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, cls, false);
        if (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean isVisibleForProtectedAndPackage(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return DescriptorVisibilities.PROTECTED.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor, false);
    }

    private static void recordVisibilityMapping(DescriptorVisibility descriptorVisibility) {
        visibilitiesMapping.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    @NotNull
    public static DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(4);
        }
        DescriptorVisibility descriptorVisibility = visibilitiesMapping.get(visibility);
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.toDescriptorVisibility(visibility);
        if (descriptorVisibility2 == null) {
            $$$reportNull$$$0(5);
        }
        return descriptorVisibility2;
    }
}
