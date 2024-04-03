package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$properties$1 extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24639g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.f24639g = lazyJavaScope;
    }

    @NotNull
    public final List<PropertyDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addIfNotNull(arrayList, this.f24639g.declaredField.invoke(name2));
        this.f24639g.f(name2, arrayList);
        if (DescriptorUtils.isAnnotationClass(this.f24639g.getOwnerDescriptor())) {
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return CollectionsKt___CollectionsKt.toList(this.f24639g.i().getComponents().getSignatureEnhancement().enhanceSignatures(this.f24639g.i(), arrayList));
    }
}
