package o30;

import j$.util.function.BiConsumer;
import org.junit.platform.commons.util.ToStringBuilder;

public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ToStringBuilder f27524b;

    public /* synthetic */ b(ToStringBuilder toStringBuilder) {
        this.f27524b = toStringBuilder;
    }

    public final void accept(Object obj, Object obj2) {
        this.f27524b.append((String) obj, (String) obj2);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }
}
