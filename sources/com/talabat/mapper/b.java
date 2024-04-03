package com.talabat.mapper;

import io.reactivex.functions.Consumer;
import java.lang.reflect.Constructor;

public final /* synthetic */ class b implements Consumer {
    public final void accept(Object obj) {
        ((Constructor) obj).setAccessible(true);
    }
}
