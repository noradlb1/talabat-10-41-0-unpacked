package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<MemberScope[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmPackageScope f24597g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.f24597g = jvmPackageScope;
    }

    @NotNull
    public final MemberScope[] invoke() {
        JvmPackageScope jvmPackageScope = this.f24597g;
        ArrayList arrayList = new ArrayList();
        for (KotlinJvmBinaryClass createKotlinPackagePartScope : this.f24597g.packageFragment.getBinaryClasses$descriptors_jvm().values()) {
            MemberScope createKotlinPackagePartScope2 = jvmPackageScope.f24596c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(jvmPackageScope.packageFragment, createKotlinPackagePartScope);
            if (createKotlinPackagePartScope2 != null) {
                arrayList.add(createKotlinPackagePartScope2);
            }
        }
        Object[] array = ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (MemberScope[]) array;
    }
}
