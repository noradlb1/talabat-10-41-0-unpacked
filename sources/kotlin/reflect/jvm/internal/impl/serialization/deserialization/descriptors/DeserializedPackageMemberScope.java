package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    @NotNull
    private final String debugName;
    @NotNull
    private final PackageFragmentDescriptor packageDescriptor;
    @NotNull
    private final FqName packageFqName;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedPackageMemberScope(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r21, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name>> r24) {
        /*
            r16 = this;
            r6 = r16
            r14 = r17
            r15 = r23
            java.lang.String r0 = "packageDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "proto"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nameResolver"
            r2 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "metadataVersion"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "components"
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "debugName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "classNames"
            r5 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r10 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r0 = r18.getTypeTable()
            java.lang.String r7 = "proto.typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            r10.<init>(r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable$Companion r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r18.getVersionRequirementTable()
            java.lang.String r8 = "proto.versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r11 = r0.create(r7)
            r7 = r22
            r8 = r17
            r9 = r19
            r12 = r20
            r13 = r21
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r7.createContext(r8, r9, r10, r11, r12, r13)
            java.util.List r3 = r18.getFunctionList()
            java.lang.String r0 = "proto.functionList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.util.List r4 = r18.getPropertyList()
            java.lang.String r0 = "proto.propertyList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.util.List r7 = r18.getTypeAliasList()
            java.lang.String r0 = "proto.typeAliasList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r0 = r16
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.packageDescriptor = r14
            r6.debugName = r15
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r17.getFqName()
            r6.packageFqName = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope.<init>(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents, java.lang.String, kotlin.jvm.functions.Function0):void");
    }

    public void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
    }

    @NotNull
    public ClassId e(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return new ClassId(this.packageFqName, name2);
    }

    @Nullable
    public Set<Name> g() {
        return SetsKt__SetsKt.emptySet();
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name2, lookupLocation);
        return super.getContributedClassifier(name2, lookupLocation);
    }

    @NotNull
    public Set<Name> h() {
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public Set<Name> i() {
        return SetsKt__SetsKt.emptySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r6) {
        /*
            r5 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = super.j(r6)
            r1 = 1
            if (r0 != 0) goto L_0x0045
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r5.f()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r0.getComponents()
            java.lang.Iterable r0 = r0.getFictitiousClassDescriptorFactories()
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0028
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0028
        L_0x0026:
            r6 = r3
            goto L_0x0041
        L_0x0028:
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r2 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r2
            kotlin.reflect.jvm.internal.impl.name.FqName r4 = r5.packageFqName
            boolean r2 = r2.shouldCreateClass(r4, r6)
            if (r2 == 0) goto L_0x002c
            r6 = r1
        L_0x0041:
            if (r6 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = r3
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope.j(kotlin.reflect.jvm.internal.impl.name.Name):boolean");
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        UtilsKt.record(f().getComponents().getLookupTracker(), lookupLocation, this.packageDescriptor, name2);
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }

    @NotNull
    public List<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> b11 = b(descriptorKindFilter, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = f().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        for (ClassDescriptorFactory allContributedClassesIfPossible : fictitiousClassDescriptorFactories) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, allContributedClassesIfPossible.getAllContributedClassesIfPossible(this.packageFqName));
        }
        return CollectionsKt___CollectionsKt.plus(b11, arrayList);
    }
}
