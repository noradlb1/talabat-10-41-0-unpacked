package com.huawei.location.tiles.cache;

import java.io.File;
import java.util.Comparator;

class yn implements Comparator<File> {
    public yn(Vw vw2) {
    }

    public int compare(Object obj, Object obj2) {
        int i11 = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0 ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0 ? 0 : -1));
        if (i11 > 0) {
            return -1;
        }
        if (i11 == 0) {
            return 0;
        }
        return 1;
    }
}
