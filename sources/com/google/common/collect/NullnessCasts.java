package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class NullnessCasts {
    private NullnessCasts() {
    }

    @ParametricNullness
    public static <T> T uncheckedCastNullableTToT(@CheckForNull T t11) {
        return t11;
    }

    @ParametricNullness
    public static <T> T unsafeNull() {
        return null;
    }
}
