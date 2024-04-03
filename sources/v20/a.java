package v20;

import java.util.Comparator;
import org.apache.commons.compress.harmony.unpack200.IcTuple;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.valueOf(((IcTuple) obj).getTupleIndex()).compareTo(Integer.valueOf(((IcTuple) obj2).getTupleIndex()));
    }
}
