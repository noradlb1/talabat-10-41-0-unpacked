package zr;

import com.talabat.helpers.EntityUpdater;
import io.reactivex.functions.Function3;
import java.lang.reflect.Field;

public final /* synthetic */ class b implements Function3 {
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return EntityUpdater.defaultMerger((Field) obj, obj2, obj3);
    }
}
