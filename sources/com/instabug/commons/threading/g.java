package com.instabug.commons.threading;

import java.util.Comparator;

public final class g implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Thread) obj).getId()), Long.valueOf(((Thread) obj2).getId()));
    }
}
