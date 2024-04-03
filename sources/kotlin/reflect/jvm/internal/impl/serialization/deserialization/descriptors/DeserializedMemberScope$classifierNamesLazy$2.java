package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

public final class DeserializedMemberScope$classifierNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope f24914g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$classifierNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.f24914g = deserializedMemberScope;
    }

    @Nullable
    public final Set<Name> invoke() {
        Set<Name> g11 = this.f24914g.g();
        if (g11 == null) {
            return null;
        }
        return SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(this.f24914g.getClassNames$deserialization(), this.f24914g.impl.getTypeAliasNames()), g11);
    }
}
