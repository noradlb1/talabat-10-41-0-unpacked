package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GivenFunctionsMemberScope f24814g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        super(0);
        this.f24814g = givenFunctionsMemberScope;
    }

    @NotNull
    public final List<DeclarationDescriptor> invoke() {
        List<FunctionDescriptor> a11 = this.f24814g.a();
        return CollectionsKt___CollectionsKt.plus(a11, this.f24814g.createFakeOverrides(a11));
    }
}
