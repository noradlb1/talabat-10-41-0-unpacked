package com.talabat.maputils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/talabat/maputils/CurrentLocHelper;", "", "()V", "IS_FROM_CL", "", "getIS_FROM_CL", "()I", "IS_FROM_INIT_CL_BG", "getIS_FROM_INIT_CL_BG", "IS_FROM_MAP", "getIS_FROM_MAP", "IS_FROM_MAP_CURRENT_LOC", "getIS_FROM_MAP_CURRENT_LOC", "IS_FROM_MAP_CURRENT_LOC_ADDRESS", "getIS_FROM_MAP_CURRENT_LOC_ADDRESS", "IS_FROM_SAVED_LOC", "getIS_FROM_SAVED_LOC", "IS_IGNORE", "getIS_IGNORE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocHelper {
    @NotNull
    public static final CurrentLocHelper INSTANCE = new CurrentLocHelper();
    private static final int IS_FROM_CL = 4;
    private static final int IS_FROM_INIT_CL_BG = 3;
    private static final int IS_FROM_MAP = 1;
    private static final int IS_FROM_MAP_CURRENT_LOC = 5;
    private static final int IS_FROM_MAP_CURRENT_LOC_ADDRESS = 6;
    private static final int IS_FROM_SAVED_LOC = 2;
    private static final int IS_IGNORE = 0;

    private CurrentLocHelper() {
    }

    public final int getIS_FROM_CL() {
        return IS_FROM_CL;
    }

    public final int getIS_FROM_INIT_CL_BG() {
        return IS_FROM_INIT_CL_BG;
    }

    public final int getIS_FROM_MAP() {
        return IS_FROM_MAP;
    }

    public final int getIS_FROM_MAP_CURRENT_LOC() {
        return IS_FROM_MAP_CURRENT_LOC;
    }

    public final int getIS_FROM_MAP_CURRENT_LOC_ADDRESS() {
        return IS_FROM_MAP_CURRENT_LOC_ADDRESS;
    }

    public final int getIS_FROM_SAVED_LOC() {
        return IS_FROM_SAVED_LOC;
    }

    public final int getIS_IGNORE() {
        return IS_IGNORE;
    }
}
