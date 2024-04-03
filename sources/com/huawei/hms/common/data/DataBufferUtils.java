package com.huawei.hms.common.data;

import android.os.Bundle;
import java.util.ArrayList;

public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    private static boolean a(Bundle bundle, String str) {
        return (bundle == null || bundle.getString(str) == null) ? false : true;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        if (dataBuffer == null) {
            return new ArrayList<>();
        }
        ArrayList<T> arrayList = new ArrayList<>(dataBuffer.getCount());
        for (E freeze : dataBuffer) {
            arrayList.add(freeze.freeze());
        }
        dataBuffer.release();
        return arrayList;
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return a(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return a(dataBuffer.getMetadata(), PREV_PAGE);
    }
}
