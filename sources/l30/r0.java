package l30;

import j$.util.function.Consumer;
import java.util.Map;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class r0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f26497b;

    public /* synthetic */ r0(Map map) {
        this.f26497b = map;
    }

    public final void accept(Object obj) {
        ReflectionUtils.lambda$static$0(this.f26497b, (Class) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
