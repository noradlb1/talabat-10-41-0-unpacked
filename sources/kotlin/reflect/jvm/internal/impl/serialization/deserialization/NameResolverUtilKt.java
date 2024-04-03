package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class NameResolverUtilKt {
    @NotNull
    public static final ClassId getClassId(@NotNull NameResolver nameResolver, int i11) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        ClassId fromString = ClassId.fromString(nameResolver.getQualifiedClassName(i11), nameResolver.isLocalClassName(i11));
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(getQualifiedC… isLocalClassName(index))");
        return fromString;
    }

    @NotNull
    public static final Name getName(@NotNull NameResolver nameResolver, int i11) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i11));
        Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return guessByFirstCharacter;
    }
}
