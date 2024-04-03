package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u00010B\u001f\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b.\u0010/J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001e\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00138\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012 \u001e*\b\u0018\u00010\u001dR\u00020\u00000\u001dR\u00020\u00000\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00138TX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u001e\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010%R\u0014\u0010-\u001a\u00020*8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", "index", "getLocalProperty", "", "other", "", "equals", "hashCode", "", "toString", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "usageModuleName", "Ljava/lang/String;", "getUsageModuleName", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "b", "methodOwner", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 7, 1})
public final class KPackageImpl extends KDeclarationContainerImpl {
    @NotNull
    private final ReflectProperties.LazyVal<Data> data;
    @NotNull
    private final Class<?> jClass;
    @Nullable
    private final String usageModuleName;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR/\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Data extends KDeclarationContainerImpl.Data {

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f24404d;
        @NotNull
        private final ReflectProperties.LazySoftVal kotlinClass$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal members$delegate;
        @NotNull
        private final ReflectProperties.LazyVal metadata$delegate;
        @NotNull
        private final ReflectProperties.LazyVal multifileFacade$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal scope$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$scope$2(this));

        static {
            Class<Data> cls = Data.class;
            f24404d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), TtmlNode.TAG_METADATA, "getMetadata()Lkotlin/Triple;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "members", "getMembers()Ljava/util/Collection;"))};
        }

        public Data() {
            super();
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$kotlinClass$2(KPackageImpl.this));
            this.multifileFacade$delegate = ReflectProperties.lazy(new KPackageImpl$Data$multifileFacade$2(this, KPackageImpl.this));
            this.metadata$delegate = ReflectProperties.lazy(new KPackageImpl$Data$metadata$2(this));
            this.members$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$members$2(KPackageImpl.this, this));
        }

        /* access modifiers changed from: private */
        public final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass$delegate.getValue(this, f24404d[0]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getMembers() {
            Object value = this.members$delegate.getValue(this, f24404d[4]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-members>(...)");
            return (Collection) value;
        }

        @Nullable
        public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> getMetadata() {
            return (Triple) this.metadata$delegate.getValue(this, f24404d[3]);
        }

        @Nullable
        public final Class<?> getMultifileFacade() {
            return (Class) this.multifileFacade$delegate.getValue(this, f24404d[2]);
        }

        @NotNull
        public final MemberScope getScope() {
            Object value = this.scope$delegate.getValue(this, f24404d[1]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-scope>(...)");
            return (MemberScope) value;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KPackageImpl(Class cls, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i11 & 2) != 0 ? null : str);
    }

    private final MemberScope getScope() {
        return this.data.invoke().getScope();
    }

    @NotNull
    public Class<?> b() {
        Class<?> multifileFacade = this.data.invoke().getMultifileFacade();
        return multifileFacade == null ? getJClass() : multifileFacade;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KPackageImpl) && Intrinsics.areEqual((Object) getJClass(), (Object) ((KPackageImpl) obj).getJClass());
    }

    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return getScope().getContributedFunctions(name2, NoLookupLocation.FROM_REFLECTION);
    }

    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Nullable
    public PropertyDescriptor getLocalProperty(int i11) {
        Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> metadata = this.data.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        JvmNameResolver component1 = metadata.component1();
        ProtoBuf.Package component2 = metadata.component2();
        JvmMetadataVersion component3 = metadata.component3();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.packageLocalVariable;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "packageLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(component2, generatedExtension, i11);
        if (property == null) {
            return null;
        }
        Class<?> jClass2 = getJClass();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass2, property, component1, new TypeTable(typeTable), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
    }

    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getMembers();
    }

    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return getScope().getContributedVariables(name2, NoLookupLocation.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }

    public KPackageImpl(@NotNull Class<?> cls, @Nullable String str) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.jClass = cls;
        this.usageModuleName = str;
        ReflectProperties.LazyVal<Data> lazy = ReflectProperties.lazy(new KPackageImpl$data$1(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "lazy { Data() }");
        this.data = lazy;
    }
}
