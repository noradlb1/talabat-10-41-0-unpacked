package com.instabug.library.internal.dataretention.files.logs;

import androidx.annotation.NonNull;
import com.instabug.library.internal.dataretention.files.f;
import com.instabug.library.logging.disklogs.g;
import com.instabug.library.util.TimeUtils;
import java.io.File;

public class d extends f {
    public d(@NonNull File file) {
        super(file);
    }

    public long b() {
        long e11 = g.e(a());
        if (e11 == -1) {
            return super.b();
        }
        return TimeUtils.currentTimeMillis() - e11;
    }
}
