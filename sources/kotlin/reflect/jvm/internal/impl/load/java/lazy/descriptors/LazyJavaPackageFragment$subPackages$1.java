package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements Function0<List<? extends FqName>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageFragment f24624g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.f24624g = lazyJavaPackageFragment;
    }

    @NotNull
    public final List<FqName> invoke() {
        Iterable<JavaPackage> subPackages = this.f24624g.jPackage.getSubPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subPackages, 10));
        for (JavaPackage fqName : subPackages) {
            arrayList.add(fqName.getFqName());
        }
        return arrayList;
    }
}
