package bt;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Pair;

public final /* synthetic */ class o implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return new Pair((CustomerAddressInfoJsonResult) obj, (List) obj2);
    }
}
