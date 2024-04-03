package kotlin.reflect.jvm.internal.impl.types;

import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope;
import org.jetbrains.annotations.NotNull;

final class SimpleTypeImpl extends SimpleType {
    @NotNull
    private final List<TypeProjection> arguments;
    @NotNull
    private final TypeConstructor constructor;
    private final boolean isMarkedNullable;
    @NotNull
    private final MemberScope memberScope;
    @NotNull
    private final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    public SimpleTypeImpl(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z11, @NotNull MemberScope memberScope2, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        this.constructor = typeConstructor;
        this.arguments = list;
        this.isMarkedNullable = z11;
        this.memberScope = memberScope2;
        this.refinedTypeFactory = function1;
        if ((getMemberScope() instanceof ErrorScope) && !(getMemberScope() instanceof ThrowingScope)) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + 10 + getConstructor());
        }
    }

    @NotNull
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @NotNull
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z11) {
        if (z11 == isMarkedNullable()) {
            return this;
        }
        if (z11) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        if (typeAttributes.isEmpty()) {
            return this;
        }
        return new SimpleTypeWithAttributes(this, typeAttributes);
    }

    @NotNull
    public SimpleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }
}
