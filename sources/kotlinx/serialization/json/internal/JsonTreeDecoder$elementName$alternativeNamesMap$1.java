package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class JsonTreeDecoder$elementName$alternativeNamesMap$1 extends FunctionReferenceImpl implements Function0<Map<String, ? extends Integer>> {
    public JsonTreeDecoder$elementName$alternativeNamesMap$1(Object obj) {
        super(0, obj, JsonNamesMapKt.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
    }

    @NotNull
    public final Map<String, Integer> invoke() {
        return JsonNamesMapKt.buildAlternativeNamesMap((SerialDescriptor) this.receiver);
    }
}
