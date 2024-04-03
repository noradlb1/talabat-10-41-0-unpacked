package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaPackageFragment f24622g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.f24622g = lazyJavaPackageFragment;
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> invoke() {
        PackagePartProvider packagePartProvider = this.f24622g.f24621c.getComponents().getPackagePartProvider();
        String asString = this.f24622g.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
        LazyJavaPackageFragment lazyJavaPackageFragment = this.f24622g;
        ArrayList arrayList = new ArrayList();
        for (String str : packagePartProvider.findPackageParts(asString)) {
            ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
            KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaPackageFragment.f24621c.getComponents().getKotlinClassFinder(), classId);
            Pair pair = findKotlinClass != null ? TuplesKt.to(str, findKotlinClass) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }
}
