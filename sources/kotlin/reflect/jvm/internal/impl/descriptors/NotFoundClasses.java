package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotFoundClasses {
    @NotNull
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;
    /* access modifiers changed from: private */
    @NotNull
    public final ModuleDescriptor module;
    /* access modifiers changed from: private */
    @NotNull
    public final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    /* access modifiers changed from: private */
    @NotNull
    public final StorageManager storageManager;

    public static final class ClassRequest {
        @NotNull
        private final ClassId classId;
        @NotNull
        private final List<Integer> typeParametersCount;

        public ClassRequest(@NotNull ClassId classId2, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            Intrinsics.checkNotNullParameter(list, "typeParametersCount");
            this.classId = classId2;
            this.typeParametersCount = list;
        }

        @NotNull
        public final ClassId component1() {
            return this.classId;
        }

        @NotNull
        public final List<Integer> component2() {
            return this.typeParametersCount;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClassRequest)) {
                return false;
            }
            ClassRequest classRequest = (ClassRequest) obj;
            return Intrinsics.areEqual((Object) this.classId, (Object) classRequest.classId) && Intrinsics.areEqual((Object) this.typeParametersCount, (Object) classRequest.typeParametersCount);
        }

        public int hashCode() {
            return (this.classId.hashCode() * 31) + this.typeParametersCount.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + ')';
        }
    }

    public static final class MockClassDescriptor extends ClassDescriptorBase {
        @NotNull
        private final List<TypeParameterDescriptor> declaredTypeParameters;
        private final boolean isInner;
        @NotNull
        private final ClassTypeConstructorImpl typeConstructor;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MockClassDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Name name2, boolean z11, int i11) {
            super(storageManager, declarationDescriptor, name2, SourceElement.NO_SOURCE, false);
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(declarationDescriptor, TtmlNode.RUBY_CONTAINER);
            Intrinsics.checkNotNullParameter(name2, "name");
            this.isInner = z11;
            IntRange until = RangesKt___RangesKt.until(0, i11);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Annotations empty = Annotations.Companion.getEMPTY();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('T');
                sb2.append(nextInt);
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, empty, false, variance, Name.identifier(sb2.toString()), nextInt, storageManager));
            }
            this.declaredTypeParameters = arrayList;
            this.typeConstructor = new ClassTypeConstructorImpl(this, TypeParameterUtilsKt.computeConstructorTypeParameters(this), SetsKt__SetsJVMKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @NotNull
        /* renamed from: a */
        public MemberScope.Empty getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope.Empty.INSTANCE;
        }

        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @NotNull
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
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
            return this.isInner;
        }

        public boolean isValue() {
            return false;
        }

        @NotNull
        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @NotNull
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @NotNull
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }
    }

    public NotFoundClasses(@NotNull StorageManager storageManager2, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        this.storageManager = storageManager2;
        this.module = moduleDescriptor;
        this.packageFragments = storageManager2.createMemoizedFunction(new NotFoundClasses$packageFragments$1(this));
        this.classes = storageManager2.createMemoizedFunction(new NotFoundClasses$classes$1(this));
    }

    @NotNull
    public final ClassDescriptor getClass(@NotNull ClassId classId, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(list, "typeParametersCount");
        return this.classes.invoke(new ClassRequest(classId, list));
    }
}
