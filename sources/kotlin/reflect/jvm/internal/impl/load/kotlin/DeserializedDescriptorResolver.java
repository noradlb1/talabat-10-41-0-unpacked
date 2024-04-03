package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedDescriptorResolver {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
    @NotNull
    private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(1, 1, 11);
    /* access modifiers changed from: private */
    @NotNull
    public static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(1, 1, 13);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = SetsKt__SetsJVMKt.setOf(KotlinClassHeader.Kind.CLASS);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt__SetsKt.setOf(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
    public DeserializationComponents components;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        }
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary()) {
            return DeserializedContainerAbiStability.FIR_UNSTABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary()) {
            return DeserializedContainerAbiStability.IR_UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getSkipPrereleaseCheck() || !kotlinJvmBinaryClass.getClassHeader().isPreRelease() || !Intrinsics.areEqual((Object) kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), (Object) KOTLIN_1_3_M1_METADATA_VERSION)) {
            return false;
        }
        return true;
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if ((!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!kotlinJvmBinaryClass.getClassHeader().isPreRelease() && !Intrinsics.areEqual((Object) kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), (Object) KOTLIN_1_1_EAP_METADATA_VERSION))) && !isCompiledWith13M1(kotlinJvmBinaryClass)) {
            return false;
        }
        return true;
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data == null || !set.contains(classHeader.getKind())) {
            return null;
        }
        return data;
    }

    @Nullable
    public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (readData == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            pair = JvmProtoBufUtil.readPackageDataFrom(readData, strings);
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalStateException("Could not read data from " + kotlinJvmBinaryClass.getLocation(), e11);
        } catch (Throwable th2) {
            if (getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th2;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        ProtoBuf.Package component2 = pair.component2();
        JvmNameResolver component1 = pair.component1();
        JvmPackagePartSource jvmPackagePartSource = new JvmPackagePartSource(kotlinJvmBinaryClass, component2, component1, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass), getAbiStability(kotlinJvmBinaryClass));
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, component2, component1, kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), jvmPackagePartSource, getComponents(), "scope for " + jvmPackagePartSource + " in " + packageFragmentDescriptor, DeserializedDescriptorResolver$createKotlinPackagePartScope$2.INSTANCE);
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    @Nullable
    public final ClassData readClassData$descriptors_jvm(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_CLASS);
        if (readData == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            pair = JvmProtoBufUtil.readClassDataFrom(readData, strings);
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalStateException("Could not read data from " + kotlinJvmBinaryClass.getLocation(), e11);
        } catch (Throwable th2) {
            if (getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th2;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new ClassData(pair.component1(), pair.component2(), kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass), getAbiStability(kotlinJvmBinaryClass)));
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        ClassData readClassData$descriptors_jvm = readClassData$descriptors_jvm(kotlinJvmBinaryClass);
        if (readClassData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinJvmBinaryClass.getClassId(), readClassData$descriptors_jvm);
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public final void setComponents(@NotNull DeserializationComponentsForJava deserializationComponentsForJava) {
        Intrinsics.checkNotNullParameter(deserializationComponentsForJava, "components");
        setComponents(deserializationComponentsForJava.getComponents());
    }
}
