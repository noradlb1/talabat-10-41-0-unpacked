package l30;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class m1 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Field f26490b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f26491c;

    public /* synthetic */ m1(Field field, Object obj) {
        this.f26490b = field;
        this.f26491c = obj;
    }

    public final Object call() {
        return ((Field) ReflectionUtils.makeAccessible(this.f26490b)).get(this.f26491c);
    }
}
