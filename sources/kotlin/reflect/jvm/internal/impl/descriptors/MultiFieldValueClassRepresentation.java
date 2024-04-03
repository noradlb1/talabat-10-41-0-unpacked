package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    @NotNull
    private final Map<Name, Type> map;
    @NotNull
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFieldValueClassRepresentation(@NotNull List<? extends Pair<Name, ? extends Type>> list) {
        super((DefaultConstructorMarker) null);
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "underlyingPropertyNamesToTypes");
        this.underlyingPropertyNamesToTypes = list;
        Map<Name, Type> map2 = MapsKt__MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (map2.size() == getUnderlyingPropertyNamesToTypes().size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.map = map2;
            return;
        }
        throw new IllegalArgumentException("Some properties have the same names".toString());
    }

    @NotNull
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }
}
