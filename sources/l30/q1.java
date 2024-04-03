package l30;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class q1 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ReflectionUtils.defaultMethodSorter((Method) obj, (Method) obj2);
    }
}
