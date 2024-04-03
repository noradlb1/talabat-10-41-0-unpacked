package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

public final /* synthetic */ class g implements Function {
    public final Object apply(Object obj) {
        return Multimaps.unmodifiableValueCollection((Collection) obj);
    }
}
