package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    private BoundType(boolean z11) {
        this.inclusive = z11;
    }

    public static BoundType forBoolean(boolean z11) {
        return z11 ? CLOSED : OPEN;
    }
}
