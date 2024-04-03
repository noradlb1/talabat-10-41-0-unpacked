package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$OptimizedImplementation$variableNames$2 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation f24911g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope f24912h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$variableNames$2(DeserializedMemberScope.OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.f24911g = optimizedImplementation;
        this.f24912h = deserializedMemberScope;
    }

    @NotNull
    public final Set<Name> invoke() {
        return SetsKt___SetsKt.plus(this.f24911g.propertyProtosBytes.keySet(), this.f24912h.i());
    }
}
