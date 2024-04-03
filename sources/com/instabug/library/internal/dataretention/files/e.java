package com.instabug.library.internal.dataretention.files;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.dataretention.core.g;
import com.instabug.library.logging.disklogs.h;
import java.util.Collection;
import java.util.Collections;

public class e implements g {
    @Nullable
    private c b() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return h.a(applicationContext);
    }

    @NonNull
    public Collection a() {
        c b11 = b();
        if (b11 == null) {
            return Collections.emptyList();
        }
        return Collections.singleton(b11);
    }
}
