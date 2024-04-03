package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

public final class DeserializationComponentsForJava {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final DeserializationComponents components;

    public static final class Companion {

        public static final class ModuleData {
            @NotNull
            private final DeserializationComponentsForJava deserializationComponentsForJava;
            @NotNull
            private final DeserializedDescriptorResolver deserializedDescriptorResolver;

            public ModuleData(@NotNull DeserializationComponentsForJava deserializationComponentsForJava2, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver2) {
                Intrinsics.checkNotNullParameter(deserializationComponentsForJava2, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = deserializationComponentsForJava2;
                this.deserializedDescriptorResolver = deserializedDescriptorResolver2;
            }

            @NotNull
            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            @NotNull
            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ModuleData createModuleData(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull KotlinClassFinder kotlinClassFinder2, @NotNull JavaClassFinder javaClassFinder, @NotNull String str, @NotNull ErrorReporter errorReporter, @NotNull JavaSourceElementFactory javaSourceElementFactory) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(kotlinClassFinder2, "jvmBuiltInsKotlinClassFinder");
            JavaClassFinder javaClassFinder2 = javaClassFinder;
            Intrinsics.checkNotNullParameter(javaClassFinder2, "javaClassFinder");
            Intrinsics.checkNotNullParameter(str2, "moduleName");
            Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
            JavaSourceElementFactory javaSourceElementFactory2 = javaSourceElementFactory;
            Intrinsics.checkNotNullParameter(javaSourceElementFactory2, "javaSourceElementFactory");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special(Typography.less + str2 + Typography.greater);
            Intrinsics.checkNotNullExpressionValue(special, "special(\"<$moduleName>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, (TargetPlatform) null, (Map) null, (Name) null, 56, (DefaultConstructorMarker) null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            jvmBuiltIns.initialize(moduleDescriptorImpl, true);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            KotlinClassFinder kotlinClassFinder3 = kotlinClassFinder;
            NotFoundClasses notFoundClasses2 = notFoundClasses;
            SingleModuleClassResolver singleModuleClassResolver2 = singleModuleClassResolver;
            ErrorReporter errorReporter2 = errorReporter;
            DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
            ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            JvmBuiltIns jvmBuiltIns2 = jvmBuiltIns;
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(javaClassFinder2, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, kotlinClassFinder3, deserializedDescriptorResolver, errorReporter2, javaSourceElementFactory2, singleModuleClassResolver2, (PackagePartProvider) null, 512, (Object) null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(moduleDescriptorImpl2, lockBasedStorageManager, notFoundClasses2, makeLazyJavaPackageFragmentProvider$default, kotlinClassFinder3, deserializedDescriptorResolver2, errorReporter2);
            DeserializedDescriptorResolver deserializedDescriptorResolver3 = deserializedDescriptorResolver2;
            deserializedDescriptorResolver3.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentProvider$default, javaResolverCache);
            singleModuleClassResolver2.setResolver(javaDescriptorResolver);
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, kotlinClassFinder2, moduleDescriptorImpl2, notFoundClasses2, jvmBuiltIns2.getCustomizer(), jvmBuiltIns2.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(lockBasedStorageManager, CollectionsKt__CollectionsKt.emptyList()));
            ModuleDescriptorImpl moduleDescriptorImpl3 = moduleDescriptorImpl2;
            moduleDescriptorImpl3.setDependencies(moduleDescriptorImpl3);
            List listOf = CollectionsKt__CollectionsKt.listOf(javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider);
            moduleDescriptorImpl3.initialize(new CompositePackageFragmentProvider(listOf, "CompositeProvider@RuntimeModuleData for " + moduleDescriptorImpl3));
            return new ModuleData(makeDeserializationComponentsForJava, deserializedDescriptorResolver3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0073, code lost:
        r16 = r0.getCustomizer();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializationComponentsForJava(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.StorageManager r27, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r28, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r29, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder r30, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl r31, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider r32, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r33, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r34, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker r35, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer r36, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r37, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators r38) {
        /*
            r26 = this;
            r1 = r27
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "moduleDescriptor"
            r2 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "configuration"
            r3 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "classDataFinder"
            r4 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "annotationAndConstantLoader"
            r5 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "packageFragmentProvider"
            r6 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "notFoundClasses"
            r12 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "errorReporter"
            r8 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "lookupTracker"
            r9 = r35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "contractDeserializer"
            r13 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "kotlinTypeChecker"
            r15 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "typeAttributeTranslators"
            r7 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r26.<init>()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r0 = r28.getBuiltIns()
            boolean r10 = r0 instanceof kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns
            if (r10 == 0) goto L_0x0062
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns r0 = (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns) r0
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings$Default r10 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer.INSTANCE
            java.util.List r16 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r17 = r16
            java.lang.Iterable r17 = (java.lang.Iterable) r17
            if (r0 == 0) goto L_0x007a
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer r16 = r0.getCustomizer()
            if (r16 == 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider$None r16 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None.INSTANCE
        L_0x007c:
            r23 = r16
            if (r0 == 0) goto L_0x0087
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer r0 = r0.getCustomizer()
            if (r0 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter$NoPlatformDependent r0 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE
        L_0x0089:
            r24 = r0
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r16 = r0.getEXTENSION_REGISTRY()
            kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl r0 = new kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl
            r18 = r0
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r2 = r19
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r0.<init>(r1, r2)
            r19 = 0
            java.util.List r20 = r38.getTranslators()
            r21 = 262144(0x40000, float:3.67342E-40)
            r22 = 0
            r0 = r14
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r10
            r8 = r34
            r9 = r35
            r10 = r11
            r11 = r17
            r12 = r33
            r13 = r36
            r25 = r14
            r14 = r23
            r15 = r24
            r17 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r26
            r1 = r25
            r0.components = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker, kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators):void");
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        return this.components;
    }
}
