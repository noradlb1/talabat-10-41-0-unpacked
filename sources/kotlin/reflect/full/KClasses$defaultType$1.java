package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClasses$defaultType$1 extends Lambda implements Function0<Type> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClass<?> f34533g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClasses$defaultType$1(KClass<?> kClass) {
        super(0);
        this.f34533g = kClass;
    }

    @NotNull
    public final Type invoke() {
        return ((KClassImpl) this.f34533g).getJClass();
    }
}
