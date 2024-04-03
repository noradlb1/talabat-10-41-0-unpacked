package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1 extends Lambda implements Function1<Name, TypeAliasDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation f24910g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.f24910g = optimizedImplementation;
    }

    @Nullable
    public final TypeAliasDescriptor invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "it");
        return this.f24910g.createTypeAlias(name2);
    }
}
