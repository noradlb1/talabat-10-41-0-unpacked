package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class JsonNull$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {
    public static final JsonNull$$cachedSerializer$delegate$1 INSTANCE = new JsonNull$$cachedSerializer$delegate$1();

    public JsonNull$$cachedSerializer$delegate$1() {
        super(0);
    }

    @NotNull
    public final KSerializer<Object> invoke() {
        return JsonNullSerializer.INSTANCE;
    }
}
