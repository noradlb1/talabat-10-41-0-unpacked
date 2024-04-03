package com.talabat.mapper;

import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;

public final /* synthetic */ class m implements Consumer {
    public final void accept(Object obj) {
        ((Field) obj).setAccessible(true);
    }
}
