package w20;

import java.util.Comparator;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((CPUTF8) obj).underlyingString().compareTo(((CPUTF8) obj2).underlyingString());
    }
}
