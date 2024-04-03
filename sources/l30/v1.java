package l30;

import java.lang.reflect.Field;
import java.util.Comparator;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class v1 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ReflectionUtils.defaultFieldSorter((Field) obj, (Field) obj2);
    }
}
