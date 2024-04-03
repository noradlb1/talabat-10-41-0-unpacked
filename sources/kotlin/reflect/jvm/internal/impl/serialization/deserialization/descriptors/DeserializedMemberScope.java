package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.apptimize.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeserializedMemberScope extends MemberScopeImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24885a;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f24886c;
    @NotNull
    private final NotNullLazyValue classNames$delegate;
    @NotNull
    private final NullableLazyValue classifierNamesLazy$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final Implementation impl;

    public interface Implementation {
        void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation);

        @NotNull
        Set<Name> getFunctionNames();

        @Nullable
        TypeAliasDescriptor getTypeAliasByName(@NotNull Name name2);

        @NotNull
        Set<Name> getTypeAliasNames();

        @NotNull
        Set<Name> getVariableNames();
    }

    public final class NoReorderImplementation implements Implementation {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f24887b;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DeserializedMemberScope f24888a;
        @NotNull
        private final NotNullLazyValue allFunctions$delegate;
        @NotNull
        private final NotNullLazyValue allProperties$delegate;
        @NotNull
        private final NotNullLazyValue allTypeAliases$delegate;
        @NotNull
        private final NotNullLazyValue declaredFunctions$delegate;
        @NotNull
        private final NotNullLazyValue declaredProperties$delegate;
        /* access modifiers changed from: private */
        @NotNull
        public final List<ProtoBuf.Function> functionList;
        @NotNull
        private final NotNullLazyValue functionNames$delegate;
        @NotNull
        private final NotNullLazyValue functionsByName$delegate;
        @NotNull
        private final NotNullLazyValue propertiesByName$delegate;
        /* access modifiers changed from: private */
        @NotNull
        public final List<ProtoBuf.Property> propertyList;
        @NotNull
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        @NotNull
        private final NotNullLazyValue typeAliasesByName$delegate;
        @NotNull
        private final NotNullLazyValue variableNames$delegate;

        static {
            Class<NoReorderImplementation> cls = NoReorderImplementation.class;
            f24887b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public NoReorderImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.f24888a = deserializedMemberScope;
            this.functionList = list;
            this.propertyList = list2;
            this.typeAliasList = !deserializedMemberScope.f().getComponents().getConfiguration().getTypeAliasesAllowed() ? CollectionsKt__CollectionsKt.emptyList() : list3;
            this.declaredFunctions$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.functionNames$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, deserializedMemberScope));
            this.variableNames$delegate = deserializedMemberScope.f().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, deserializedMemberScope));
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Set<Name> h11 = this.f24888a.h();
            ArrayList arrayList = new ArrayList();
            for (Name computeNonDeclaredFunctionsForName : h11) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, computeNonDeclaredFunctionsForName(computeNonDeclaredFunctionsForName));
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Set<Name> i11 = this.f24888a.i();
            ArrayList arrayList = new ArrayList();
            for (Name computeNonDeclaredPropertiesForName : i11) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, computeNonDeclaredPropertiesForName(computeNonDeclaredPropertiesForName));
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> list = this.functionList;
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                SimpleFunctionDescriptor loadFunction = deserializedMemberScope.f().getMemberDeserializer().loadFunction((ProtoBuf.Function) messageLite);
                if (!deserializedMemberScope.k(loadFunction)) {
                    loadFunction = null;
                }
                if (loadFunction != null) {
                    arrayList.add(loadFunction);
                }
            }
            return arrayList;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name name2) {
            List<SimpleFunctionDescriptor> declaredFunctions = getDeclaredFunctions();
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            ArrayList arrayList = new ArrayList();
            for (Object next : declaredFunctions) {
                if (Intrinsics.areEqual((Object) ((DeclarationDescriptor) next).getName(), (Object) name2)) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.c(name2, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name name2) {
            List<PropertyDescriptor> declaredProperties = getDeclaredProperties();
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            ArrayList arrayList = new ArrayList();
            for (Object next : declaredProperties) {
                if (Intrinsics.areEqual((Object) ((DeclarationDescriptor) next).getName(), (Object) name2)) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.d(name2, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> computeProperties() {
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : this.propertyList) {
                PropertyDescriptor loadProperty = deserializedMemberScope.f().getMemberDeserializer().loadProperty((ProtoBuf.Property) messageLite);
                if (loadProperty != null) {
                    arrayList.add(loadProperty);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> computeTypeAliases() {
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : this.typeAliasList) {
                TypeAliasDescriptor loadTypeAlias = deserializedMemberScope.f().getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) messageLite);
                if (loadTypeAlias != null) {
                    arrayList.add(loadTypeAlias);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, (Object) this, (KProperty<?>) f24887b[3]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, (Object) this, (KProperty<?>) f24887b[4]);
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, (Object) this, (KProperty<?>) f24887b[2]);
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, (Object) this, (KProperty<?>) f24887b[0]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, (Object) this, (KProperty<?>) f24887b[1]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, (Object) this, (KProperty<?>) f24887b[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, (Object) this, (KProperty<?>) f24887b[7]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, (Object) this, (KProperty<?>) f24887b[5]);
        }

        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                for (Object next : getAllProperties()) {
                    Name name2 = ((PropertyDescriptor) next).getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(next);
                    }
                }
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                for (Object next2 : getAllFunctions()) {
                    Name name3 = ((SimpleFunctionDescriptor) next2).getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "it.name");
                    if (function1.invoke(name3).booleanValue()) {
                        collection.add(next2);
                    }
                }
            }
        }

        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getFunctionNames().contains(name2)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Collection<SimpleFunctionDescriptor> collection = getFunctionsByName().get(name2);
            if (collection == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return collection;
        }

        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getVariableNames().contains(name2)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Collection<PropertyDescriptor> collection = getPropertiesByName().get(name2);
            if (collection == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return collection;
        }

        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, (Object) this, (KProperty<?>) f24887b[8]);
        }

        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return getTypeAliasesByName().get(name2);
        }

        @NotNull
        public Set<Name> getTypeAliasNames() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.f24888a;
            for (MessageLite messageLite : this.typeAliasList) {
                linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.f().getNameResolver(), ((ProtoBuf.TypeAlias) messageLite).getName()));
            }
            return linkedHashSet;
        }

        @NotNull
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, (Object) this, (KProperty<?>) f24887b[9]);
        }
    }

    public final class OptimizedImplementation implements Implementation {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f24901b;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DeserializedMemberScope f24902a;
        @NotNull
        private final NotNullLazyValue functionNames$delegate;
        /* access modifiers changed from: private */
        @NotNull
        public final Map<Name, byte[]> functionProtosBytes;
        @NotNull
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        @NotNull
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        /* access modifiers changed from: private */
        @NotNull
        public final Map<Name, byte[]> propertyProtosBytes;
        @NotNull
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        @NotNull
        private final Map<Name, byte[]> typeAliasBytes;
        @NotNull
        private final NotNullLazyValue variableNames$delegate;

        static {
            Class<OptimizedImplementation> cls = OptimizedImplementation.class;
            f24901b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public OptimizedImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Map<Name, byte[]> map;
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.f24902a = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object next : list) {
                Name name2 = NameResolverUtilKt.getName(deserializedMemberScope.f().getNameResolver(), ((ProtoBuf.Function) ((MessageLite) next)).getName());
                Object obj = linkedHashMap.get(name2);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(name2, obj);
                }
                ((List) obj).add(next);
            }
            this.functionProtosBytes = packToByteArray(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.f24902a;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object next2 : list2) {
                Name name3 = NameResolverUtilKt.getName(deserializedMemberScope2.f().getNameResolver(), ((ProtoBuf.Property) ((MessageLite) next2)).getName());
                Object obj2 = linkedHashMap2.get(name3);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(name3, obj2);
                }
                ((List) obj2).add(next2);
            }
            this.propertyProtosBytes = packToByteArray(linkedHashMap2);
            if (this.f24902a.f().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.f24902a;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object next3 : list3) {
                    Name name4 = NameResolverUtilKt.getName(deserializedMemberScope3.f().getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) next3)).getName());
                    Object obj3 = linkedHashMap3.get(name4);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap3.put(name4, obj3);
                    }
                    ((List) obj3).add(next3);
                }
                map = packToByteArray(linkedHashMap3);
            } else {
                map = MapsKt__MapsKt.emptyMap();
            }
            this.typeAliasBytes = map;
            this.functions = this.f24902a.f().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.f24902a.f().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.f24902a.f().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            this.functionNames$delegate = this.f24902a.f().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, this.f24902a));
            this.variableNames$delegate = this.f24902a.f().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, this.f24902a));
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> computeFunctions(kotlin.reflect.jvm.internal.impl.name.Name r7) {
            /*
                r6 = this;
                java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> r0 = r6.functionProtosBytes
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope r2 = r6.f24902a
                java.lang.Object r0 = r0.get(r7)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L_0x002c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope r3 = r6.f24902a
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1
                r0.<init>(r1, r4, r3)
                kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt__SequencesKt.generateSequence(r0)
                java.util.List r0 = kotlin.sequences.SequencesKt___SequencesKt.toList(r0)
                if (r0 == 0) goto L_0x002c
                java.util.Collection r0 = (java.util.Collection) r0
                goto L_0x0032
            L_0x002c:
                java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
                java.util.Collection r0 = (java.util.Collection) r0
            L_0x0032:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                int r0 = r0.size()
                r3.<init>(r0)
                java.util.Iterator r0 = r1.iterator()
            L_0x0042:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x006d
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r2.f()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r4 = r4.getMemberDeserializer()
                java.lang.String r5 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r1 = r4.loadFunction(r1)
                boolean r4 = r2.k(r1)
                if (r4 == 0) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r1 = 0
            L_0x0067:
                if (r1 == 0) goto L_0x0042
                r3.add(r1)
                goto L_0x0042
            L_0x006d:
                r2.c(r7, r3)
                java.util.List r7 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r3)
                java.util.Collection r7 = (java.util.Collection) r7
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.computeFunctions(kotlin.reflect.jvm.internal.impl.name.Name):java.util.Collection");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> computeProperties(kotlin.reflect.jvm.internal.impl.name.Name r7) {
            /*
                r6 = this;
                java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, byte[]> r0 = r6.propertyProtosBytes
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope r2 = r6.f24902a
                java.lang.Object r0 = r0.get(r7)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L_0x002c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope r3 = r6.f24902a
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1
                r0.<init>(r1, r4, r3)
                kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt__SequencesKt.generateSequence(r0)
                java.util.List r0 = kotlin.sequences.SequencesKt___SequencesKt.toList(r0)
                if (r0 == 0) goto L_0x002c
                java.util.Collection r0 = (java.util.Collection) r0
                goto L_0x0032
            L_0x002c:
                java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
                java.util.Collection r0 = (java.util.Collection) r0
            L_0x0032:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                int r0 = r0.size()
                r3.<init>(r0)
                java.util.Iterator r0 = r1.iterator()
            L_0x0042:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0065
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r2.f()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r4 = r4.getMemberDeserializer()
                java.lang.String r5 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r4.loadProperty(r1)
                if (r1 == 0) goto L_0x0042
                r3.add(r1)
                goto L_0x0042
            L_0x0065:
                r2.d(r7, r3)
                java.util.List r7 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r3)
                java.util.Collection r7 = (java.util.Collection) r7
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation.computeProperties(kotlin.reflect.jvm.internal.impl.name.Name):java.util.Collection");
        }

        /* access modifiers changed from: private */
        public final TypeAliasDescriptor createTypeAlias(Name name2) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.typeAliasBytes.get(name2);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f24902a.f().getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return this.f24902a.f().getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (AbstractMessageLite writeDelimitedTo : iterable) {
                    writeDelimitedTo.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name next : variableNames) {
                    if (function1.invoke(next).booleanValue()) {
                        arrayList.addAll(getContributedVariables(next, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator, "INSTANCE");
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, nameAndTypeMemberComparator);
                collection.addAll(arrayList);
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name next2 : functionNames) {
                    if (function1.invoke(next2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(next2, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator2, "INSTANCE");
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, nameAndTypeMemberComparator2);
                collection.addAll(arrayList2);
            }
        }

        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getFunctionNames().contains(name2)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return this.functions.invoke(name2);
        }

        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getVariableNames().contains(name2)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return this.properties.invoke(name2);
        }

        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, (Object) this, (KProperty<?>) f24901b[0]);
        }

        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return this.typeAliasByName.invoke(name2);
        }

        @NotNull
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        @NotNull
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, (Object) this, (KProperty<?>) f24901b[1]);
        }
    }

    static {
        Class<DeserializedMemberScope> cls = DeserializedMemberScope.class;
        f24885a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public DeserializedMemberScope(@NotNull DeserializationContext deserializationContext, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, @NotNull List<ProtoBuf.TypeAlias> list3, @NotNull Function0<? extends Collection<Name>> function0) {
        Intrinsics.checkNotNullParameter(deserializationContext, c.f41585a);
        Intrinsics.checkNotNullParameter(list, "functionList");
        Intrinsics.checkNotNullParameter(list2, "propertyList");
        Intrinsics.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics.checkNotNullParameter(function0, "classNames");
        this.f24886c = deserializationContext;
        this.impl = createImplementation(list, list2, list3);
        this.classNames$delegate = deserializationContext.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(function0));
        this.classifierNamesLazy$delegate = deserializationContext.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.f24886c.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    private final ClassDescriptor deserializeClass(Name name2) {
        return this.f24886c.getComponents().deserializeClass(e(name2));
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, (Object) this, (KProperty<?>) f24885a[1]);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name name2) {
        return this.impl.getTypeAliasByName(name2);
    }

    public abstract void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1);

    @NotNull
    public final Collection<DeclarationDescriptor> b(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        DescriptorKindFilter.Companion companion = DescriptorKindFilter.Companion;
        if (descriptorKindFilter.acceptsKinds(companion.getSINGLETON_CLASSIFIERS_MASK())) {
            a(arrayList, function1);
        }
        this.impl.addFunctionsAndPropertiesTo(arrayList, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(companion.getCLASSIFIERS_MASK())) {
            for (Name next : getClassNames$deserialization()) {
                if (function1.invoke(next).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, deserializeClass(next));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name next2 : this.impl.getTypeAliasNames()) {
                if (function1.invoke(next2).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, this.impl.getTypeAliasByName(next2));
                }
            }
        }
        return CollectionsKt.compact(arrayList);
    }

    public void c(@NotNull Name name2, @NotNull List<SimpleFunctionDescriptor> list) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(list, "functions");
    }

    public void d(@NotNull Name name2, @NotNull List<PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(list, "descriptors");
    }

    @NotNull
    public abstract ClassId e(@NotNull Name name2);

    @NotNull
    public final DeserializationContext f() {
        return this.f24886c;
    }

    @Nullable
    public abstract Set<Name> g();

    @NotNull
    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, (Object) this, (KProperty<?>) f24885a[0]);
    }

    @Nullable
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (j(name2)) {
            return deserializeClass(name2);
        }
        if (this.impl.getTypeAliasNames().contains(name2)) {
            return getTypeAliasByName(name2);
        }
        return null;
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.impl.getContributedFunctions(name2, lookupLocation);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.impl.getContributedVariables(name2, lookupLocation);
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @NotNull
    public abstract Set<Name> h();

    @NotNull
    public abstract Set<Name> i();

    public boolean j(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return getClassNames$deserialization().contains(name2);
    }

    public boolean k(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }
}
