package z30;

import java.lang.reflect.Field;
import java.util.Comparator;

public final /* synthetic */ class n implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((Field) obj).getName().compareTo(((Field) obj2).getName());
    }
}
