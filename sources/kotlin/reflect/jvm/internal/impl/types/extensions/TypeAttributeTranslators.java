package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import org.jetbrains.annotations.NotNull;

public final class TypeAttributeTranslators {
    @NotNull
    private final List<TypeAttributeTranslator> translators;

    public TypeAttributeTranslators(@NotNull List<? extends TypeAttributeTranslator> list) {
        Intrinsics.checkNotNullParameter(list, "translators");
        this.translators = list;
    }

    @NotNull
    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}
