package com.uxcam.internals;

import java.io.File;
import java.io.FilenameFilter;

public class db implements FilenameFilter {
    public db(dc dcVar) {
    }

    public boolean accept(File file, String str) {
        return by.a(str);
    }
}
