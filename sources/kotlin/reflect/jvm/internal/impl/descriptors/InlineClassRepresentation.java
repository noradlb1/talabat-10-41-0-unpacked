package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class InlineClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    @NotNull
    private final Name underlyingPropertyName;
    @NotNull
    private final Type underlyingType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineClassRepresentation(@NotNull Name name2, @NotNull Type type) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name2, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(type, "underlyingType");
        this.underlyingPropertyName = name2;
        this.underlyingType = type;
    }

    @NotNull
    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    @NotNull
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(this.underlyingPropertyName, this.underlyingType));
    }

    @NotNull
    public final Type getUnderlyingType() {
        return this.underlyingType;
    }
}
