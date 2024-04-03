package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;

public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {
    @NotNull
    private final TypeConstructor constructor;
    @NotNull
    private final MemberScope memberScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StubTypeForBuilderInference(@NotNull NewTypeVariableConstructor newTypeVariableConstructor, boolean z11, @NotNull TypeConstructor typeConstructor) {
        super(newTypeVariableConstructor, z11);
        Intrinsics.checkNotNullParameter(newTypeVariableConstructor, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        this.constructor = typeConstructor;
        this.memberScope = newTypeVariableConstructor.getBuiltIns().getAnyType().getMemberScope();
    }

    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @NotNull
    public AbstractStubType materialize(boolean z11) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), z11, getConstructor());
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Stub (BI): ");
        sb2.append(getOriginalTypeVariable());
        sb2.append(isMarkedNullable() ? TypeDescription.Generic.OfWildcardType.SYMBOL : "");
        return sb2.toString();
    }
}
