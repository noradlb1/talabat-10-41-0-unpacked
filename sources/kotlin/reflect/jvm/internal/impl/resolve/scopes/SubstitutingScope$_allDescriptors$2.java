package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;

public final class SubstitutingScope$_allDescriptors$2 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubstitutingScope f24821g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        super(0);
        this.f24821g = substitutingScope;
    }

    @NotNull
    public final Collection<DeclarationDescriptor> invoke() {
        SubstitutingScope substitutingScope = this.f24821g;
        return substitutingScope.substitute(ResolutionScope.DefaultImpls.getContributedDescriptors$default(substitutingScope.workerScope, (DescriptorKindFilter) null, (Function1) null, 3, (Object) null));
    }
}
