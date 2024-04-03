package com.instabug.library.visualusersteps.inspector;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import java.util.Collection;

class h implements Function {
    /* renamed from: a */
    public MaybeSource apply(Collection collection) {
        return j.b(collection.iterator());
    }
}
