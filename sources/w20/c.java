package w20;

import java.util.Comparator;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;

public final /* synthetic */ class c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((CPClass) obj).getName().compareTo(((CPClass) obj2).getName());
    }
}
