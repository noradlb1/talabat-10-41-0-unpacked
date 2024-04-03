package com.instabug.library.internal.dataretention.files;

import androidx.annotation.NonNull;
import com.instabug.library.util.TimeUtils;
import java.io.File;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private final File f50973a;

    public f(@NonNull File file) {
        this.f50973a = file;
    }

    @NonNull
    public File a() {
        return this.f50973a;
    }

    public long b() {
        return TimeUtils.currentTimeMillis() - this.f50973a.lastModified();
    }
}
