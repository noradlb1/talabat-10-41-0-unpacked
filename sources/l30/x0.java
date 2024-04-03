package l30;

import java.util.concurrent.Callable;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class x0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassLoader f26509c;

    public /* synthetic */ x0(String str, ClassLoader classLoader) {
        this.f26508b = str;
        this.f26509c = classLoader;
    }

    public final Object call() {
        return ReflectionUtils.lambda$tryToLoadClass$9(this.f26508b, this.f26509c);
    }
}
