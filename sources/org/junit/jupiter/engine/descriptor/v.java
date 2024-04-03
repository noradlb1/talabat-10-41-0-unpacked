package org.junit.jupiter.engine.descriptor;

import j$.util.function.ToIntFunction;
import java.lang.reflect.Field;

public final /* synthetic */ class v implements ToIntFunction {
    public final int applyAsInt(Object obj) {
        return ExtensionUtils.getOrder((Field) obj);
    }
}
