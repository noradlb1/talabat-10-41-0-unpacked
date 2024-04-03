package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ClassId functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    /* access modifiers changed from: private */
    @NotNull
    public static final ClassId kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    private final int arity;
    /* access modifiers changed from: private */
    @NotNull
    public final PackageFragmentDescriptor containingDeclaration;
    @NotNull
    private final FunctionClassKind functionKind;
    @NotNull
    private final FunctionClassScope memberScope;
    /* access modifiers changed from: private */
    @NotNull
    public final List<TypeParameterDescriptor> parameters;
    /* access modifiers changed from: private */
    @NotNull
    public final StorageManager storageManager;
    @NotNull
    private final FunctionTypeConstructor typeConstructor = new FunctionTypeConstructor();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(@NotNull StorageManager storageManager2, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull FunctionClassKind functionClassKind, int i11) {
        super(storageManager2, functionClassKind.numberedClassName(i11));
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(functionClassKind, "functionKind");
        this.storageManager = storageManager2;
        this.containingDeclaration = packageFragmentDescriptor;
        this.functionKind = functionClassKind;
        this.arity = i11;
        this.memberScope = new FunctionClassScope(storageManager2, this);
        ArrayList arrayList = new ArrayList();
        IntRange intRange = new IntRange(1, i11);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('P');
            sb2.append(nextInt);
            _init_$typeParameter(arrayList, this, variance, sb2.toString());
            arrayList2.add(Unit.INSTANCE);
        }
        _init_$typeParameter(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    private static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.storageManager));
    }

    @NotNull
    /* renamed from: a */
    public FunctionClassScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public final int getArity() {
        return this.arity;
    }

    @Nullable
    public Void getCompanionObjectDescriptor() {
        return null;
    }

    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    @NotNull
    public final FunctionClassKind getFunctionKind() {
        return this.functionKind;
    }

    @NotNull
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @NotNull
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Nullable
    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
        return descriptorVisibility;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    @NotNull
    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }

    public final class FunctionTypeConstructor extends AbstractClassTypeConstructor {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }

        @NotNull
        public Collection<KotlinType> c() {
            List list;
            int i11 = WhenMappings.$EnumSwitchMapping$0[FunctionClassDescriptor.this.getFunctionKind().ordinal()];
            if (i11 == 1) {
                list = CollectionsKt__CollectionsJVMKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i11 == 2) {
                list = CollectionsKt__CollectionsKt.listOf(FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(FunctionClassDescriptor.this.getArity())));
            } else if (i11 == 3) {
                list = CollectionsKt__CollectionsJVMKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i11 == 4) {
                list = CollectionsKt__CollectionsKt.listOf(FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME, FunctionClassKind.SuspendFunction.numberedClassName(FunctionClassDescriptor.this.getArity())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            Iterable<ClassId> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ClassId classId : iterable) {
                ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    Iterable<TypeParameterDescriptor> takeLast = CollectionsKt___CollectionsKt.takeLast(getParameters(), findClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(takeLast, 10));
                    for (TypeParameterDescriptor defaultType : takeLast) {
                        arrayList2.add(new TypeProjectionImpl(defaultType.getDefaultType()));
                    }
                    arrayList.add(KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), findClassAcrossModuleDependencies, arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }

        @NotNull
        public SupertypeLoopChecker g() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        public boolean isDenotable() {
            return true;
        }

        @NotNull
        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        @NotNull
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }
    }

    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @NotNull
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }
}
