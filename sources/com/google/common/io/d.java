package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;

public final /* synthetic */ class d implements TempFileCreator.JavaNioCreator.PermissionSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileAttribute f44691a;

    public /* synthetic */ d(FileAttribute fileAttribute) {
        this.f44691a = fileAttribute;
    }

    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.lambda$userPermissions$3(this.f44691a);
    }
}
