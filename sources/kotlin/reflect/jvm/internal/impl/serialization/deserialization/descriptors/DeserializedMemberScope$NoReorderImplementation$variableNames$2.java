package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$NoReorderImplementation$variableNames$2 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation f24899g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope f24900h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$variableNames$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.f24899g = noReorderImplementation;
        this.f24900h = deserializedMemberScope;
    }

    @NotNull
    public final Set<Name> invoke() {
        DeserializedMemberScope.NoReorderImplementation noReorderImplementation = this.f24899g;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DeserializedMemberScope deserializedMemberScope = noReorderImplementation.f24888a;
        for (MessageLite messageLite : noReorderImplementation.propertyList) {
            linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.f().getNameResolver(), ((ProtoBuf.Property) messageLite).getName()));
        }
        return SetsKt___SetsKt.plus(linkedHashSet, this.f24900h.i());
    }
}
