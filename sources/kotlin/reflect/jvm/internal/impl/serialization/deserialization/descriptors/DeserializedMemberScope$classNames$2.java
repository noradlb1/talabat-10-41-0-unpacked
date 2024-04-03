package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$classNames$2 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Collection<Name>> f24913g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$classNames$2(Function0<? extends Collection<Name>> function0) {
        super(0);
        this.f24913g = function0;
    }

    @NotNull
    public final Set<Name> invoke() {
        return CollectionsKt___CollectionsKt.toSet(this.f24913g.invoke());
    }
}
