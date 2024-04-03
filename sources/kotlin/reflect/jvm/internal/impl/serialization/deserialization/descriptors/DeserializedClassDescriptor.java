package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    @NotNull
    private final Annotations annotations;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f24865c;
    /* access modifiers changed from: private */
    @NotNull
    public final ClassId classId;
    @NotNull
    private final ProtoBuf.Class classProto;
    @NotNull
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    @NotNull
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    @NotNull
    private final DeclarationDescriptor containingDeclaration;
    /* access modifiers changed from: private */
    @Nullable
    public final EnumEntryClassDescriptors enumEntries;
    @NotNull
    private final ClassKind kind;
    @NotNull
    private final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    @NotNull
    private final BinaryVersion metadataVersion;
    @NotNull
    private final Modality modality;
    @NotNull
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    @NotNull
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    @NotNull
    private final SourceElement sourceElement;
    @NotNull
    private final MemberScopeImpl staticScope;
    @NotNull
    private final ProtoContainer.Class thisAsProtoContainer;
    /* access modifiers changed from: private */
    @NotNull
    public final DeserializedClassTypeConstructor typeConstructor;
    @NotNull
    private final NullableLazyValue<ValueClassRepresentation<SimpleType>> valueClassRepresentation;
    @NotNull
    private final DescriptorVisibility visibility;

    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        @NotNull
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeserializedClassDescriptor f24866b;
        /* access modifiers changed from: private */
        @NotNull
        public final KotlinTypeRefiner kotlinTypeRefiner;
        @NotNull
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeserializedClassMemberScope(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9) {
            /*
                r7 = this;
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r7.f24866b = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.getNameResolver()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L_0x0058:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0070
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.Name r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r8, r6)
                r1.add(r6)
                goto L_0x0058
            L_0x0070:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.kotlinTypeRefiner = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.f()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.allDescriptors = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.f()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.refinedSupertypes = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name2, Collection<? extends D> collection, List<D> list) {
            Name name3 = name2;
            Collection<? extends D> collection2 = collection;
            f().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name3, collection2, new ArrayList(list), getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(list));
        }

        /* access modifiers changed from: private */
        public final DeserializedClassDescriptor getClassDescriptor() {
            return this.f24866b;
        }

        public void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1) {
            Collection<ClassDescriptor> collection2;
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().enumEntries;
            if (access$getEnumEntries$p != null) {
                collection2 = access$getEnumEntries$p.all();
            } else {
                collection2 = null;
            }
            if (collection2 == null) {
                collection2 = CollectionsKt__CollectionsKt.emptyList();
            }
            collection.addAll(collection2);
        }

        public void c(@NotNull Name name2, @NotNull List<SimpleFunctionDescriptor> list) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedFunctions(name2, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(f().getComponents().getAdditionalClassPartsProvider().getFunctions(name2, this.f24866b));
            generateFakeOverrides(name2, arrayList, list);
        }

        public void d(@NotNull Name name2, @NotNull List<PropertyDescriptor> list) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedVariables(name2, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name2, arrayList, list);
        }

        @NotNull
        public ClassId e(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            ClassId createNestedClassId = this.f24866b.classId.createNestedClassId(name2);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        @Nullable
        public Set<Name> g() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().typeConstructor.getSupertypes()) {
                Set<Name> classifierNames = memberScope.getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            ClassDescriptor findEnumEntry;
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name2, lookupLocation);
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().enumEntries;
            if (access$getEnumEntries$p == null || (findEnumEntry = access$getEnumEntries$p.findEnumEntry(name2)) == null) {
                return super.getContributedClassifier(name2, lookupLocation);
            }
            return findEnumEntry;
        }

        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            return (Collection) this.allDescriptors.invoke();
        }

        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name2, lookupLocation);
            return super.getContributedFunctions(name2, lookupLocation);
        }

        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name2, lookupLocation);
            return super.getContributedVariables(name2, lookupLocation);
        }

        @NotNull
        public Set<Name> h() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().typeConstructor.getSupertypes()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(f().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.f24866b));
            return linkedHashSet;
        }

        @NotNull
        public Set<Name> i() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().typeConstructor.getSupertypes()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        public boolean k(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
            return f().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.f24866b, simpleFunctionDescriptor);
        }

        public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            UtilsKt.record(f().getComponents().getLookupTracker(), lookupLocation, (ClassDescriptor) getClassDescriptor(), name2);
        }
    }

    public final class EnumEntryClassDescriptors {
        @NotNull
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        /* access modifiers changed from: private */
        @NotNull
        public final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        /* access modifiers changed from: private */
        @NotNull
        public final NotNullLazyValue<Set<Name>> enumMemberNames;

        public EnumEntryClassDescriptors() {
            List<ProtoBuf.EnumEntry> enumEntryList = DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
            Iterable iterable = enumEntryList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (Object next : iterable) {
                linkedHashMap.put(NameResolverUtilKt.getName(DeserializedClassDescriptor.this.getC().getNameResolver(), ((ProtoBuf.EnumEntry) next).getName()), next);
            }
            this.enumEntryProtos = linkedHashMap;
            this.enumEntryByName = DeserializedClassDescriptor.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, DeserializedClassDescriptor.this));
            this.enumMemberNames = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        /* access modifiers changed from: private */
        public final Set<Name> computeEnumMemberNames() {
            HashSet hashSet = new HashSet();
            for (KotlinType memberScope : DeserializedClassDescriptor.this.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope.getMemberScope(), (DescriptorKindFilter) null, (Function1) null, 3, (Object) null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            for (ProtoBuf.Function name2 : functionList) {
                hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), name2.getName()));
            }
            List<ProtoBuf.Property> propertyList = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
            for (ProtoBuf.Property name3 : propertyList) {
                hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), name3.getName()));
            }
            return SetsKt___SetsKt.plus(hashSet, hashSet);
        }

        @NotNull
        public final Collection<ClassDescriptor> all() {
            Set<Name> keySet = this.enumEntryProtos.keySet();
            ArrayList arrayList = new ArrayList();
            for (Name findEnumEntry : keySet) {
                ClassDescriptor findEnumEntry2 = findEnumEntry(findEnumEntry);
                if (findEnumEntry2 != null) {
                    arrayList.add(findEnumEntry2);
                }
            }
            return arrayList;
        }

        @Nullable
        public final ClassDescriptor findEnumEntry(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return this.enumEntryByName.invoke(name2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(@NotNull DeserializationContext deserializationContext, @NotNull ProtoBuf.Class classR, @NotNull NameResolver nameResolver, @NotNull BinaryVersion binaryVersion, @NotNull SourceElement sourceElement2) {
        super(deserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, classR.getFqName()).getShortClassName());
        MemberScopeImpl memberScopeImpl;
        EnumEntryClassDescriptors enumEntryClassDescriptors;
        DeserializedClassDescriptor deserializedClassDescriptor;
        Annotations annotations2;
        Intrinsics.checkNotNullParameter(deserializationContext, "outerContext");
        Intrinsics.checkNotNullParameter(classR, "classProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement2, "sourceElement");
        this.classProto = classR;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement2;
        this.classId = NameResolverUtilKt.getClassId(nameResolver, classR.getFqName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        this.modality = protoEnumFlags.modality(Flags.MODALITY.get(classR.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(classR.getFlags()));
        ClassKind classKind = protoEnumFlags.classKind(Flags.CLASS_KIND.get(classR.getFlags()));
        this.kind = classKind;
        List<ProtoBuf.TypeParameter> typeParameterList = classR.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = classR.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = classR.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        DeserializationContext childContext = deserializationContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), binaryVersion);
        this.f24865c = childContext;
        ClassKind classKind2 = ClassKind.ENUM_CLASS;
        if (classKind == classKind2) {
            memberScopeImpl = new StaticScopeForKotlinEnum(childContext.getStorageManager(), this);
        } else {
            memberScopeImpl = MemberScope.Empty.INSTANCE;
        }
        this.staticScope = memberScopeImpl;
        this.typeConstructor = new DeserializedClassTypeConstructor();
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, childContext.getStorageManager(), childContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class classR2 = null;
        if (classKind == classKind2) {
            enumEntryClassDescriptors = new EnumEntryClassDescriptors();
        } else {
            enumEntryClassDescriptors = null;
        }
        this.enumEntries = enumEntryClassDescriptors;
        DeclarationDescriptor containingDeclaration2 = deserializationContext.getContainingDeclaration();
        this.containingDeclaration = containingDeclaration2;
        this.primaryConstructor = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = childContext.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = childContext.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.valueClassRepresentation = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$valueClassRepresentation$1(this));
        NameResolver nameResolver2 = childContext.getNameResolver();
        TypeTable typeTable3 = childContext.getTypeTable();
        if (containingDeclaration2 instanceof DeserializedClassDescriptor) {
            deserializedClassDescriptor = (DeserializedClassDescriptor) containingDeclaration2;
        } else {
            deserializedClassDescriptor = null;
        }
        this.thisAsProtoContainer = new ProtoContainer.Class(classR, nameResolver2, typeTable3, sourceElement2, deserializedClassDescriptor != null ? deserializedClassDescriptor.thisAsProtoContainer : classR2);
        if (!Flags.HAS_ANNOTATIONS.get(classR.getFlags()).booleanValue()) {
            annotations2 = Annotations.Companion.getEMPTY();
        } else {
            annotations2 = new NonEmptyDeserializedAnnotations(childContext.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        }
        this.annotations = annotations2;
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor computeCompanionObjectDescriptor() {
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = getMemberScope().getContributedClassifier(NameResolverUtilKt.getName(this.f24865c.getNameResolver(), this.classProto.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt__CollectionsKt.listOfNotNull(getUnsubstitutedPrimaryConstructor())), this.f24865c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX WARNING: type inference failed for: r1v8, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> computeInlineClassRepresentation() {
        /*
            r9 = this;
            boolean r0 = r9.isInline()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            boolean r0 = r9.isValue()
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r0 = r9.isValue()
            if (r0 == 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingPropertyName()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingType()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingTypeId()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            int r0 = r0.getMultiFieldValueClassUnderlyingNameCount()
            if (r0 <= 0) goto L_0x0035
            return r1
        L_0x0035:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingPropertyName()
            r2 = 1
            if (r0 == 0) goto L_0x004f
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r9.f24865c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r9.classProto
            int r3 = r3.getInlineClassUnderlyingPropertyName()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r3)
            goto L_0x0076
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r0 = r9.metadataVersion
            r3 = 5
            boolean r0 = r0.isAtLeast(r2, r3, r2)
            if (r0 != 0) goto L_0x0112
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r9.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x00f7
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r3 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.first(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getName()
            java.lang.String r3 = "{\n                // Bef…irst().name\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r9.classProto
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r9.f24865c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r4 = r4.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.inlineClassUnderlyingType(r3, r4)
            r4 = 0
            if (r3 == 0) goto L_0x0092
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r9.f24865c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r5 = r5.getTypeDeserializer()
            r6 = 2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType$default(r5, r3, r4, r6, r1)
            if (r3 != 0) goto L_0x00d6
        L_0x0092:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope r3 = r9.getMemberScope()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            java.util.Collection r3 = r3.getContributedVariables(r0, r5)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r6 = r1
            r5 = r4
        L_0x00a4:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00c2
            java.lang.Object r7 = r3.next()
            r8 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r8 = r8.getExtensionReceiverParameter()
            if (r8 != 0) goto L_0x00b9
            r8 = r2
            goto L_0x00ba
        L_0x00b9:
            r8 = r4
        L_0x00ba:
            if (r8 == 0) goto L_0x00a4
            if (r5 == 0) goto L_0x00bf
            goto L_0x00c6
        L_0x00bf:
            r5 = r2
            r6 = r7
            goto L_0x00a4
        L_0x00c2:
            if (r5 != 0) goto L_0x00c5
            goto L_0x00c6
        L_0x00c5:
            r1 = r6
        L_0x00c6:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r1
            if (r1 == 0) goto L_0x00dc
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r3 = r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3
        L_0x00d6:
            kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation r1 = new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation
            r1.<init>(r0, r3)
            return r1
        L_0x00dc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Value class has no underlying property: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Inline class has no primary constructor: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0112:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Inline class has no underlying property name in metadata: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.computeInlineClassRepresentation():kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation");
    }

    private final MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation() {
        List list;
        Iterable multiFieldValueClassUnderlyingNameList = this.classProto.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "classProto.multiFieldValueClassUnderlyingNameList");
        Iterable<Integer> iterable = multiFieldValueClassUnderlyingNameList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Integer num : iterable) {
            NameResolver nameResolver = this.f24865c.getNameResolver();
            Intrinsics.checkNotNullExpressionValue(num, "it");
            arrayList.add(NameResolverUtilKt.getName(nameResolver, num.intValue()));
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        if (isValue()) {
            Pair pair = TuplesKt.to(Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeCount()));
            if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(Integer.valueOf(arrayList.size()), 0))) {
                Iterable multiFieldValueClassUnderlyingTypeIdList = this.classProto.getMultiFieldValueClassUnderlyingTypeIdList();
                Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "classProto.multiFieldVal…ClassUnderlyingTypeIdList");
                Iterable<Integer> iterable2 = multiFieldValueClassUnderlyingTypeIdList;
                list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                for (Integer num2 : iterable2) {
                    TypeTable typeTable = this.f24865c.getTypeTable();
                    Intrinsics.checkNotNullExpressionValue(num2, "it");
                    list.add(typeTable.get(num2.intValue()));
                }
            } else if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(0, Integer.valueOf(arrayList.size())))) {
                list = this.classProto.getMultiFieldValueClassUnderlyingTypeList();
            } else {
                throw new IllegalStateException(("Illegal multi-field value class representation: " + this).toString());
            }
            Intrinsics.checkNotNullExpressionValue(list, "when (typeIdCount to typ…tation: $this\")\n        }");
            Iterable<ProtoBuf.Type> iterable3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
            for (ProtoBuf.Type type : iterable3) {
                TypeDeserializer typeDeserializer = this.f24865c.getTypeDeserializer();
                Intrinsics.checkNotNullExpressionValue(type, "it");
                arrayList2.add(TypeDeserializer.simpleType$default(typeDeserializer, type, false, 2, (Object) null));
            }
            return new MultiFieldValueClassRepresentation<>(CollectionsKt___CollectionsKt.zip(arrayList, arrayList2));
        }
        throw new IllegalArgumentException(("Not a value class: " + this).toString());
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor computePrimaryConstructor() {
        Object obj;
        if (this.kind.isSingleton()) {
            ClassConstructorDescriptorImpl createPrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
            createPrimaryConstructorForObject.setReturnType(getDefaultType());
            return createPrimaryConstructorForObject;
        }
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor != null) {
            return this.f24865c.getMemberDeserializer().loadConstructor(constructor, true);
        }
        return null;
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        ArrayList<ProtoBuf.Constructor> arrayList = new ArrayList<>();
        for (Object next : constructorList) {
            Boolean bool = Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) next).getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ProtoBuf.Constructor constructor : arrayList) {
            MemberDeserializer memberDeserializer = this.f24865c.getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(constructor, "it");
            arrayList2.add(memberDeserializer.loadConstructor(constructor, false));
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            DeserializationComponents components = this.f24865c.getComponents();
            NameResolver nameResolver = this.f24865c.getNameResolver();
            Intrinsics.checkNotNullExpressionValue(num, FirebaseAnalytics.Param.INDEX);
            ClassDescriptor deserializeClass = components.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, num.intValue()));
            if (deserializeClass != null) {
                arrayList.add(deserializeClass);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        InlineClassRepresentation<SimpleType> computeInlineClassRepresentation = computeInlineClassRepresentation();
        MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation = computeMultiFieldValueClassRepresentation();
        if (computeInlineClassRepresentation != null && computeMultiFieldValueClassRepresentation != null) {
            throw new IllegalArgumentException("Class cannot have both inline class representation and multi field class representation: " + this);
        } else if ((isValue() || isInline()) && computeInlineClassRepresentation == null && computeMultiFieldValueClassRepresentation == null) {
            throw new IllegalArgumentException("Value class has no value class representation: " + this);
        } else if (computeInlineClassRepresentation != null) {
            return computeInlineClassRepresentation;
        } else {
            return computeMultiFieldValueClassRepresentation;
        }
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return this.memberScopeHolder.getScope(this.f24865c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final DeserializationContext getC() {
        return this.f24865c;
    }

    @NotNull
    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.companionObjectDescriptor.invoke();
    }

    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.constructors.invoke();
    }

    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ProtoBuf.Type> contextReceiverTypeList = this.classProto.getContextReceiverTypeList();
        Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "classProto.contextReceiverTypeList");
        Iterable<ProtoBuf.Type> iterable = contextReceiverTypeList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Type type : iterable) {
            TypeDeserializer typeDeserializer = this.f24865c.getTypeDeserializer();
            Intrinsics.checkNotNullExpressionValue(type, "it");
            arrayList.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, typeDeserializer.type(type), (ReceiverValue) null), Annotations.Companion.getEMPTY()));
        }
        return arrayList;
    }

    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f24865c.getTypeDeserializer().getOwnTypeParameters();
    }

    @NotNull
    public ClassKind getKind() {
        return this.kind;
    }

    @NotNull
    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @NotNull
    public Modality getModality() {
        return this.modality;
    }

    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.sealedSubclasses.invoke();
    }

    @NotNull
    public SourceElement getSource() {
        return this.sourceElement;
    }

    @NotNull
    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @NotNull
    public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.primaryConstructor.invoke();
    }

    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return (ValueClassRepresentation) this.valueClassRepresentation.invoke();
    }

    @NotNull
    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    public final boolean hasNestedClass$deserialization(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return getMemberScope().getClassNames$deserialization().contains(name2);
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.classProto.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    public boolean isData() {
        Boolean bool = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isExpect() {
        Boolean bool = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isFun() {
        Boolean bool = Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isInline() {
        Boolean bool = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VALUE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.metadataVersion.isAtMost(1, 4, 1);
    }

    public boolean isInner() {
        Boolean bool = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isValue() {
        Boolean bool = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VALUE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.metadataVersion.isAtLeast(1, 4, 2);
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deserialized ");
        sb2.append(isExpect() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    public final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.getC().getStorageManager());
            this.parameters = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(DeserializedClassDescriptor.this));
        }

        @NotNull
        public Collection<KotlinType> c() {
            String str;
            FqName asSingleFqName;
            NotFoundClasses.MockClassDescriptor mockClassDescriptor;
            Iterable<ProtoBuf.Type> supertypes = ProtoTypeTableUtilKt.supertypes(DeserializedClassDescriptor.this.getClassProto(), DeserializedClassDescriptor.this.getC().getTypeTable());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(supertypes, 10));
            for (ProtoBuf.Type type : supertypes) {
                arrayList.add(deserializedClassDescriptor.getC().getTypeDeserializer().type(type));
            }
            Iterable<KotlinType> plus = CollectionsKt___CollectionsKt.plus(arrayList, DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(DeserializedClassDescriptor.this));
            ArrayList<NotFoundClasses.MockClassDescriptor> arrayList2 = new ArrayList<>();
            for (KotlinType constructor : plus) {
                ClassifierDescriptor declarationDescriptor = constructor.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor instanceof NotFoundClasses.MockClassDescriptor) {
                    mockClassDescriptor = (NotFoundClasses.MockClassDescriptor) declarationDescriptor;
                } else {
                    mockClassDescriptor = null;
                }
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                for (NotFoundClasses.MockClassDescriptor mockClassDescriptor2 : arrayList2) {
                    ClassId classId = DescriptorUtilsKt.getClassId(mockClassDescriptor2);
                    if (classId == null || (asSingleFqName = classId.asSingleFqName()) == null || (str = asSingleFqName.asString()) == null) {
                        str = mockClassDescriptor2.getName().asString();
                    }
                    arrayList3.add(str);
                }
                errorReporter.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList3);
            }
            return CollectionsKt___CollectionsKt.toList(plus);
        }

        @NotNull
        public SupertypeLoopChecker g() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public boolean isDenotable() {
            return true;
        }

        @NotNull
        public String toString() {
            String name2 = DeserializedClassDescriptor.this.getName().toString();
            Intrinsics.checkNotNullExpressionValue(name2, "name.toString()");
            return name2;
        }

        @NotNull
        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return DeserializedClassDescriptor.this;
        }
    }

    @NotNull
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }
}
