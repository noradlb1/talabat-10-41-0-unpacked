package com.huawei.location.tiles.utils;

import java.io.File;
import java.util.Comparator;

final class dC implements Comparator<File> {
    public int compare(Object obj, Object obj2) {
        return (int) (((File) obj2).lastModified() - ((File) obj).lastModified());
    }
}
