package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    private ValueClassRepresentation() {
    }

    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes();

    @NotNull
    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(@NotNull Function1<? super Type, ? extends Other> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (this instanceof InlineClassRepresentation) {
            InlineClassRepresentation inlineClassRepresentation = (InlineClassRepresentation) this;
            return new InlineClassRepresentation(inlineClassRepresentation.getUnderlyingPropertyName(), (SimpleTypeMarker) function1.invoke(inlineClassRepresentation.getUnderlyingType()));
        } else if (this instanceof MultiFieldValueClassRepresentation) {
            Iterable<Pair> underlyingPropertyNamesToTypes = getUnderlyingPropertyNamesToTypes();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(underlyingPropertyNamesToTypes, 10));
            for (Pair pair : underlyingPropertyNamesToTypes) {
                arrayList.add(TuplesKt.to((Name) pair.component1(), function1.invoke((SimpleTypeMarker) pair.component2())));
            }
            return new MultiFieldValueClassRepresentation(arrayList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
