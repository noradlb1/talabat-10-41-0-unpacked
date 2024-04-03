package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public abstract class WrappedType extends KotlinType {
    public WrappedType() {
        super((DefaultConstructorMarker) null);
    }

    @NotNull
    public abstract KotlinType a();

    @NotNull
    public List<TypeProjection> getArguments() {
        return a().getArguments();
    }

    @NotNull
    public TypeAttributes getAttributes() {
        return a().getAttributes();
    }

    @NotNull
    public TypeConstructor getConstructor() {
        return a().getConstructor();
    }

    @NotNull
    public MemberScope getMemberScope() {
        return a().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    public boolean isMarkedNullable() {
        return a().isMarkedNullable();
    }

    @NotNull
    public String toString() {
        if (isComputed()) {
            return a().toString();
        }
        return "<Not computed yet>";
    }

    @NotNull
    public final UnwrappedType unwrap() {
        KotlinType a11 = a();
        while (a11 instanceof WrappedType) {
            a11 = ((WrappedType) a11).a();
        }
        Intrinsics.checkNotNull(a11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (UnwrappedType) a11;
    }
}
