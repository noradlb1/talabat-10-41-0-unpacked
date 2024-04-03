package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"Composer", "Lkotlinx/serialization/json/internal/Composer;", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ComposersKt {
    @NotNull
    public static final Composer Composer(@NotNull JsonStringBuilder jsonStringBuilder, @NotNull Json json) {
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.getConfiguration().getPrettyPrint()) {
            return new ComposerWithPrettyPrint(jsonStringBuilder, json);
        }
        return new Composer(jsonStringBuilder);
    }
}
