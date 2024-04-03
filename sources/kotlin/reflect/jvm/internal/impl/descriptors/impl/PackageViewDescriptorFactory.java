package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public interface PackageViewDescriptorFactory {
    @NotNull
    public static final Companion Companion = Companion.f24553a;

    public static final class Companion {
        @NotNull
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = new ModuleCapability<>("PackageViewDescriptorFactory");

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24553a = new Companion();

        private Companion() {
        }

        @NotNull
        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }

    public static final class Default implements PackageViewDescriptorFactory {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @NotNull
        public PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull FqName fqName, @NotNull StorageManager storageManager) {
            Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName, storageManager);
        }
    }

    @NotNull
    PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull FqName fqName, @NotNull StorageManager storageManager);
}
