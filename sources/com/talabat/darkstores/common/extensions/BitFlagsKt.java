package com.talabat.darkstores.common.extensions;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b¨\u0006\u0006"}, d2 = {"addFlag", "", "flag", "hasFlag", "", "removeFlag", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BitFlagsKt {
    public static final int addFlag(int i11, int i12) {
        return i11 | i12;
    }

    public static final boolean hasFlag(int i11, int i12) {
        return (i11 & i12) == i12;
    }

    public static final int removeFlag(int i11, int i12) {
        return i11 & (~i12);
    }
}
