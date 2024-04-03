package com.instabug.library.internal.dataretention.files;

import androidx.annotation.NonNull;
import com.instabug.library.internal.dataretention.core.e;
import com.instabug.library.util.FileUtils;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final f f50972a;

    public a(@NonNull f fVar) {
        this.f50972a = fVar;
    }

    public void dispose() {
        FileUtils.deleteDirectory(this.f50972a.a());
    }
}
