package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;

public final /* synthetic */ class e implements TempFileCreator.JavaNioCreator.PermissionSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOException f44692a;

    public /* synthetic */ e(IOException iOException) {
        this.f44692a = iOException;
    }

    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.lambda$userPermissions$4(this.f44692a);
    }
}
