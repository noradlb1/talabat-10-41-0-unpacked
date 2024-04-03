package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class NotFoundClasses$packageFragments$1 extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NotFoundClasses f24485g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$packageFragments$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.f24485g = notFoundClasses;
    }

    @NotNull
    public final PackageFragmentDescriptor invoke(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new EmptyPackageFragmentDescriptor(this.f24485g.module, fqName);
    }
}
