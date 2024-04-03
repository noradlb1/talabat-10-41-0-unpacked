package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24545b;
    @NotNull
    private final NotNullLazyValue empty$delegate;
    @NotNull
    private final FqName fqName;
    @NotNull
    private final NotNullLazyValue fragments$delegate;
    @NotNull
    private final MemberScope memberScope;
    @NotNull
    private final ModuleDescriptorImpl module;

    static {
        Class<LazyPackageViewDescriptorImpl> cls = LazyPackageViewDescriptorImpl.class;
        f24545b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "fragments", "getFragments()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "empty", "getEmpty()Z"))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull FqName fqName2, @NotNull StorageManager storageManager) {
        super(Annotations.Companion.getEMPTY(), fqName2.shortNameOrSpecial());
        Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.module = moduleDescriptorImpl;
        this.fqName = fqName2;
        this.fragments$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.empty$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$empty$2(this));
        this.memberScope = new LazyScopeAdapter(storageManager, new LazyPackageViewDescriptorImpl$memberScope$1(this));
    }

    public final boolean a() {
        return ((Boolean) StorageKt.getValue(this.empty$delegate, (Object) this, (KProperty<?>) f24545b[1])).booleanValue();
    }

    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d11);
    }

    public boolean equals(@Nullable Object obj) {
        PackageViewDescriptor packageViewDescriptor;
        if (obj instanceof PackageViewDescriptor) {
            packageViewDescriptor = (PackageViewDescriptor) obj;
        } else {
            packageViewDescriptor = null;
        }
        if (packageViewDescriptor != null && Intrinsics.areEqual((Object) getFqName(), (Object) packageViewDescriptor.getFqName()) && Intrinsics.areEqual((Object) getModule(), (Object) packageViewDescriptor.getModule())) {
            return true;
        }
        return false;
    }

    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.fragments$delegate, (Object) this, (KProperty<?>) f24545b[0]);
    }

    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    public boolean isEmpty() {
        return a();
    }

    @Nullable
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl module2 = getModule();
        FqName parent = getFqName().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
        return module2.getPackage(parent);
    }

    @NotNull
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }
}
