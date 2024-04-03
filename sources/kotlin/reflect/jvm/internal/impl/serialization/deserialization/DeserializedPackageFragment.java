package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    @NotNull
    private final StorageManager storageManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragment(@NotNull FqName fqName, @NotNull StorageManager storageManager2, @NotNull ModuleDescriptor moduleDescriptor) {
        super(moduleDescriptor, fqName);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        this.storageManager = storageManager2;
    }

    @NotNull
    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        MemberScope memberScope = getMemberScope();
        if (!(memberScope instanceof DeserializedMemberScope) || !((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name2)) {
            return false;
        }
        return true;
    }

    public abstract void initialize(@NotNull DeserializationComponents deserializationComponents);
}
