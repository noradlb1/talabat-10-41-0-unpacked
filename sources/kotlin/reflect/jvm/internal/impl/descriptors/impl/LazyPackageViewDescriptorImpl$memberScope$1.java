package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyPackageViewDescriptorImpl f24548g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.f24548g = lazyPackageViewDescriptorImpl;
    }

    @NotNull
    public final MemberScope invoke() {
        if (this.f24548g.isEmpty()) {
            return MemberScope.Empty.INSTANCE;
        }
        Iterable<PackageFragmentDescriptor> fragments = this.f24548g.getFragments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fragments, 10));
        for (PackageFragmentDescriptor memberScope : fragments) {
            arrayList.add(memberScope.getMemberScope());
        }
        List plus = CollectionsKt___CollectionsKt.plus(arrayList, new SubpackagesScope(this.f24548g.getModule(), this.f24548g.getFqName()));
        ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
        return companion.create("package view scope for " + this.f24548g.getFqName() + " in " + this.f24548g.getModule().getName(), plus);
    }
}
