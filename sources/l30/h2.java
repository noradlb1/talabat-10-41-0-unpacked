package l30;

import j$.util.function.Supplier;
import org.junit.platform.commons.util.ClassLoaderUtils;

public final /* synthetic */ class h2 implements Supplier {
    public final Object get() {
        return ClassLoaderUtils.getDefaultClassLoader();
    }
}
