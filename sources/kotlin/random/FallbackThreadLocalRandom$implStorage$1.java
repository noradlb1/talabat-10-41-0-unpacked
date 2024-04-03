package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    @NotNull
    /* renamed from: a */
    public Random initialValue() {
        return new Random();
    }
}
