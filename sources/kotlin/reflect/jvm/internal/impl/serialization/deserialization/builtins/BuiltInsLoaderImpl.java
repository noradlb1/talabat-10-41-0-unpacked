package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    @NotNull
    private final BuiltInsResourceLoader resourceLoader = new BuiltInsResourceLoader();

    public static /* synthetic */ PackageFragmentProvider createBuiltInPackageFragmentProvider$default(BuiltInsLoaderImpl builtInsLoaderImpl, StorageManager storageManager, ModuleDescriptor moduleDescriptor, Set set, Iterable iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z11, Function1 function1, int i11, Object obj) {
        AdditionalClassPartsProvider.None none;
        if ((i11 & 32) != 0) {
            none = AdditionalClassPartsProvider.None.INSTANCE;
        } else {
            none = additionalClassPartsProvider;
        }
        return builtInsLoaderImpl.createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor, set, iterable, platformDependentDeclarationFilter, none, z11, function1);
    }

    @NotNull
    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Set<FqName> set, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z11, @NotNull Function1<? super String, ? extends InputStream> function1) {
        StorageManager storageManager2 = storageManager;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        Set<FqName> set2 = set;
        Function1<? super String, ? extends InputStream> function12 = function1;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics.checkNotNullParameter(set2, "packageFqNames");
        Intrinsics.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(function12, "loadResource");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(set2, 10));
        for (FqName fqName : set) {
            String builtInsFilePath = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName);
            InputStream inputStream = (InputStream) function12.invoke(builtInsFilePath);
            if (inputStream != null) {
                arrayList.add(BuiltInsPackageFragmentImpl.Companion.create(fqName, storageManager, moduleDescriptor, inputStream, z11));
            } else {
                throw new IllegalStateException("Resource not found in classpath: " + builtInsFilePath);
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = r2;
        PackageFragmentProviderImpl packageFragmentProviderImpl2 = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = r1;
        NotFoundClasses notFoundClasses2 = new NotFoundClasses(storageManager2, moduleDescriptor2);
        DeserializationConfiguration.Default defaultR = DeserializationConfiguration.Default.INSTANCE;
        DeserializedClassDataFinder deserializedClassDataFinder = r5;
        DeserializedClassDataFinder deserializedClassDataFinder2 = new DeserializedClassDataFinder(packageFragmentProviderImpl2);
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = r7;
        PackageFragmentProviderImpl packageFragmentProviderImpl3 = packageFragmentProviderImpl2;
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.INSTANCE;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl2 = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses2, builtInSerializerProtocol);
        LocalClassifierTypeSettings.Default defaultR2 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        DeserializationComponents deserializationComponents = r0;
        ErrorReporter errorReporter2 = errorReporter;
        ArrayList arrayList2 = arrayList;
        Intrinsics.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        LookupTracker.DO_NOTHING do_nothing = LookupTracker.DO_NOTHING.INSTANCE;
        ArrayList<BuiltInsPackageFragmentImpl> arrayList3 = arrayList2;
        FlexibleTypeDeserializer.ThrowException throwException = FlexibleTypeDeserializer.ThrowException.INSTANCE;
        ContractDeserializer contractDeserializer = ContractDeserializer.Companion.getDEFAULT();
        ExtensionRegistryLite extensionRegistry = builtInSerializerProtocol.getExtensionRegistry();
        SamConversionResolverImpl samConversionResolverImpl = r1;
        SamConversionResolverImpl samConversionResolverImpl2 = new SamConversionResolverImpl(storageManager2, CollectionsKt__CollectionsKt.emptyList());
        PackageFragmentProviderImpl packageFragmentProviderImpl4 = packageFragmentProviderImpl3;
        DeserializationComponents deserializationComponents2 = new DeserializationComponents(storageManager, moduleDescriptor, defaultR, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl, defaultR2, errorReporter2, do_nothing, throwException, iterable, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, extensionRegistry, (NewKotlinTypeChecker) null, samConversionResolverImpl, (PlatformDependentTypeTransformer) null, (List) null, 851968, (DefaultConstructorMarker) null);
        for (BuiltInsPackageFragmentImpl initialize : arrayList3) {
            initialize.initialize(deserializationComponents);
        }
        return packageFragmentProviderImpl4;
    }

    @NotNull
    public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z11) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "builtInsModule");
        Intrinsics.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor, StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, z11, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.resourceLoader));
    }
}
