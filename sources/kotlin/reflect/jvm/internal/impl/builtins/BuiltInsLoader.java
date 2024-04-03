package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public interface BuiltInsLoader {
    @NotNull
    public static final Companion Companion = Companion.f24451a;

    public static final class Companion {
        @NotNull
        private static final Lazy<BuiltInsLoader> Instance$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$Instance$2.INSTANCE);

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24451a = new Companion();

        private Companion() {
        }

        @NotNull
        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    @NotNull
    PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z11);
}
