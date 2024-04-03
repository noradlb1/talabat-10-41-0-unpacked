package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = new ReceiverValue() {
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final DescriptorVisibility DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = new ReceiverValue() {
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    @NotNull
    public static final DescriptorVisibility INHERITED;
    @NotNull
    public static final DescriptorVisibility INTERNAL;
    @NotNull
    public static final DescriptorVisibility INVISIBLE_FAKE;
    public static final Set<DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES;
    /* access modifiers changed from: private */
    public static final ReceiverValue IRRELEVANT_RECEIVER = new ReceiverValue() {
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    @NotNull
    public static final DescriptorVisibility LOCAL;
    /* access modifiers changed from: private */
    @NotNull
    public static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    private static final Map<DescriptorVisibility, Integer> ORDERED_VISIBILITIES;
    @NotNull
    public static final DescriptorVisibility PRIVATE;
    @NotNull
    public static final DescriptorVisibility PRIVATE_TO_THIS;
    @NotNull
    public static final DescriptorVisibility PROTECTED;
    @NotNull
    public static final DescriptorVisibility PUBLIC;
    @NotNull
    public static final DescriptorVisibility UNKNOWN;
    @NotNull
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = new HashMap();

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = i11 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i11 != 16 ? 3 : 2)];
        if (!(i11 == 1 || i11 == 3 || i11 == 5 || i11 == 7)) {
            switch (i11) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        }
        objArr[0] = "from";
        if (i11 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i11) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String format = String.format(str, objArr);
        throw (i11 != 16 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    static {
        ModuleVisibilityHelper moduleVisibilityHelper;
        AnonymousClass1 r02 = new DelegatedDescriptorVisibility(Visibilities.Private.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 == 1) {
                    objArr[0] = "what";
                } else if (i11 != 2) {
                    objArr[0] = "descriptor";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
                if (i11 == 1 || i11 == 2) {
                    objArr[2] = "isVisible";
                } else {
                    objArr[2] = "hasContainingSourceFile";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            private boolean hasContainingSourceFile(@NotNull DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(0);
                }
                if (DescriptorUtils.getContainingSourceFile(declarationDescriptor) != SourceFile.NO_SOURCE_FILE) {
                    return true;
                }
                return false;
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                DeclarationDescriptor declarationDescriptor2;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(1);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(2);
                }
                if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility) && hasContainingSourceFile(declarationDescriptor)) {
                    return DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                }
                if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                    ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                    if (z11 && DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                        return true;
                    }
                }
                DeclarationDescriptor declarationDescriptor3 = declarationDescriptorWithVisibility;
                while (declarationDescriptor3 != null) {
                    DeclarationDescriptor containingDeclaration2 = declarationDescriptor3.getContainingDeclaration();
                    if ((containingDeclaration2 instanceof ClassDescriptor) && !DescriptorUtils.isCompanionObject(containingDeclaration2)) {
                        declarationDescriptor2 = containingDeclaration2;
                        break;
                    }
                    boolean z12 = containingDeclaration2 instanceof PackageFragmentDescriptor;
                    declarationDescriptor3 = containingDeclaration2;
                    if (z12) {
                        declarationDescriptor2 = containingDeclaration2;
                        break;
                    }
                }
                declarationDescriptor2 = declarationDescriptor3;
                if (declarationDescriptor2 == null) {
                    return false;
                }
                while (declarationDescriptor != null) {
                    if (declarationDescriptor2 == declarationDescriptor) {
                        return true;
                    }
                    if (!(declarationDescriptor instanceof PackageFragmentDescriptor)) {
                        declarationDescriptor = declarationDescriptor.getContainingDeclaration();
                    } else if (!(declarationDescriptor2 instanceof PackageFragmentDescriptor) || !((PackageFragmentDescriptor) declarationDescriptor2).getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) || !DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptor2)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        };
        PRIVATE = r02;
        AnonymousClass2 r12 = new DelegatedDescriptorVisibility(Visibilities.PrivateToThis.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                DeclarationDescriptor parentOfType;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (DescriptorVisibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor, z11)) {
                    if (receiverValue == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                        return true;
                    }
                    if (!(receiverValue == DescriptorVisibilities.IRRELEVANT_RECEIVER || (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) == null || !(receiverValue instanceof ThisClassReceiver))) {
                        return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                    }
                }
                return false;
            }
        };
        PRIVATE_TO_THIS = r12;
        AnonymousClass3 r22 = new DelegatedDescriptorVisibility(Visibilities.Protected.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 == 1) {
                    objArr[0] = "from";
                } else if (i11 == 2) {
                    objArr[0] = "whatDeclaration";
                } else if (i11 != 3) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "fromClass";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
                if (i11 == 2 || i11 == 3) {
                    objArr[2] = "doesReceiverFitForProtectedVisibility";
                } else {
                    objArr[2] = "isVisible";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            private boolean doesReceiverFitForProtectedVisibility(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull ClassDescriptor classDescriptor) {
                KotlinType kotlinType;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(2);
                }
                if (classDescriptor == null) {
                    $$$reportNull$$$0(3);
                }
                if (receiverValue == DescriptorVisibilities.FALSE_IF_PROTECTED) {
                    return false;
                }
                if (!(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) || receiverValue == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (receiverValue == DescriptorVisibilities.IRRELEVANT_RECEIVER || receiverValue == null) {
                    return false;
                }
                if (receiverValue instanceof SuperCallReceiverValue) {
                    kotlinType = ((SuperCallReceiverValue) receiverValue).getThisType();
                } else {
                    kotlinType = receiverValue.getType();
                }
                if (DescriptorUtils.isSubtypeOfClass(kotlinType, classDescriptor) || DynamicTypesKt.isDynamic(kotlinType)) {
                    return true;
                }
                return false;
            }

            public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
                ClassDescriptor classDescriptor;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                Class<ClassDescriptor> cls = ClassDescriptor.class;
                ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, cls);
                ClassDescriptor classDescriptor3 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, cls, false);
                if (classDescriptor3 == null) {
                    return false;
                }
                if (classDescriptor2 != null && DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(classDescriptor2, cls)) != null && DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                    return true;
                }
                DeclarationDescriptorWithVisibility unwrapFakeOverrideToAnyDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
                ClassDescriptor classDescriptor4 = (ClassDescriptor) DescriptorUtils.getParentOfType(unwrapFakeOverrideToAnyDeclaration, cls);
                if (classDescriptor4 == null) {
                    return false;
                }
                if (!DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4) || !doesReceiverFitForProtectedVisibility(receiverValue, unwrapFakeOverrideToAnyDeclaration, classDescriptor3)) {
                    return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration(), z11);
                }
                return true;
            }
        };
        PROTECTED = r22;
        AnonymousClass4 r32 = new DelegatedDescriptorVisibility(Visibilities.Internal.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
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
                if (!DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                    return false;
                }
                return DescriptorVisibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        INTERNAL = r32;
        AnonymousClass5 r42 = new DelegatedDescriptorVisibility(Visibilities.Public.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
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
                return true;
            }
        };
        PUBLIC = r42;
        AnonymousClass6 r52 = new DelegatedDescriptorVisibility(Visibilities.Local.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
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
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        };
        LOCAL = r52;
        AnonymousClass7 r62 = new DelegatedDescriptorVisibility(Visibilities.Inherited.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
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
                throw new IllegalStateException("Visibility is unknown yet");
            }
        };
        INHERITED = r62;
        AnonymousClass8 r72 = new DelegatedDescriptorVisibility(Visibilities.InvisibleFake.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
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
                return false;
            }
        };
        INVISIBLE_FAKE = r72;
        AnonymousClass9 r82 = new DelegatedDescriptorVisibility(Visibilities.Unknown.INSTANCE) {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                Object[] objArr = new Object[3];
                if (i11 != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
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
                return false;
            }
        };
        UNKNOWN = r82;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt__SetsKt.setOf(r02, r12, r32, r52));
        HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(4);
        newHashMapWithExpectedSize.put(r12, 0);
        newHashMapWithExpectedSize.put(r02, 0);
        newHashMapWithExpectedSize.put(r32, 1);
        newHashMapWithExpectedSize.put(r22, 1);
        newHashMapWithExpectedSize.put(r42, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(newHashMapWithExpectedSize);
        DEFAULT_VISIBILITY = r42;
        Class<ModuleVisibilityHelper> cls = ModuleVisibilityHelper.class;
        Iterator<S> it = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
        if (it.hasNext()) {
            moduleVisibilityHelper = (ModuleVisibilityHelper) it.next();
        } else {
            moduleVisibilityHelper = ModuleVisibilityHelper.EMPTY.INSTANCE;
        }
        MODULE_VISIBILITY_HELPER = moduleVisibilityHelper;
        recordVisibilityMapping(r02);
        recordVisibilityMapping(r12);
        recordVisibilityMapping(r22);
        recordVisibilityMapping(r32);
        recordVisibilityMapping(r42);
        recordVisibilityMapping(r52);
        recordVisibilityMapping(r62);
        recordVisibilityMapping(r72);
        recordVisibilityMapping(r82);
    }

    @Nullable
    public static Integer compare(@NotNull DescriptorVisibility descriptorVisibility, @NotNull DescriptorVisibility descriptorVisibility2) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(12);
        }
        if (descriptorVisibility2 == null) {
            $$$reportNull$$$0(13);
        }
        Integer compareTo = descriptorVisibility.compareTo(descriptorVisibility2);
        if (compareTo != null) {
            return compareTo;
        }
        Integer compareTo2 = descriptorVisibility2.compareTo(descriptorVisibility);
        if (compareTo2 != null) {
            return Integer.valueOf(-compareTo2.intValue());
        }
        return null;
    }

    @Nullable
    public static DeclarationDescriptorWithVisibility findInvisibleMember(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
        DeclarationDescriptorWithVisibility findInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(8);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal();
        while (declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor, z11)) {
                return declarationDescriptorWithVisibility2;
            }
            declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class);
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (findInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor, z11)) == null) {
            return null;
        }
        return findInvisibleMember;
    }

    public static boolean inSameFile(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(6);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(7);
        }
        SourceFile containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != SourceFile.NO_SOURCE_FILE) {
            return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static boolean isPrivate(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(14);
        }
        if (descriptorVisibility == PRIVATE || descriptorVisibility == PRIVATE_TO_THIS) {
            return true;
        }
        return false;
    }

    public static boolean isVisibleIgnoringReceiver(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z11) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor, z11) == null) {
            return true;
        }
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility descriptorVisibility) {
        visibilitiesMapping.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    @NotNull
    public static DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(15);
        }
        DescriptorVisibility descriptorVisibility = visibilitiesMapping.get(visibility);
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + visibility);
    }
}
