package com.instabug.library.util.memory.predicate;

import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

public abstract class FileMemoryAvailablePredicate extends MemoryAvailablePredicate {

    /* renamed from: d  reason: collision with root package name */
    public final File f52076d;

    public FileMemoryAvailablePredicate(File file) {
        this.f52076d = file;
    }

    private String b() {
        File file = this.f52076d;
        if (file == null) {
            return "null file reference";
        }
        if (!file.isFile()) {
            return "the file object maybe representing a folder not a file";
        }
        return "the file object is not a text file";
    }

    public abstract boolean c(File file);

    public boolean check() {
        File file = this.f52076d;
        if (file == null || !file.isFile() || !c(this.f52076d)) {
            InstabugSDKLogger.e("IBG-Core", getClass().getSimpleName() + " is returning false due to " + b());
            return false;
        }
        boolean b11 = b((this.f52076d.length() * 2) + 40);
        InstabugSDKLogger.v("IBG-Core", getClass().getSimpleName() + " is running test, results: " + b11);
        return b11;
    }
}
