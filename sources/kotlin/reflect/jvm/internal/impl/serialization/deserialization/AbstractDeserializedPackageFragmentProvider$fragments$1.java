package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractDeserializedPackageFragmentProvider f24824g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        super(1);
        this.f24824g = abstractDeserializedPackageFragmentProvider;
    }

    @Nullable
    public final PackageFragmentDescriptor invoke(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        DeserializedPackageFragment a11 = this.f24824g.a(fqName);
        if (a11 == null) {
            return null;
        }
        a11.initialize(this.f24824g.b());
        return a11;
    }
}
