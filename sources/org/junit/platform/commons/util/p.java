package org.junit.platform.commons.util;

import j$.util.concurrent.ConcurrentMap;
import java.io.Closeable;
import java.net.URI;
import org.junit.platform.commons.util.CloseablePath;

public final /* synthetic */ class p implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ URI f28019b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CloseablePath.ManagedFileSystem f28020c;

    public /* synthetic */ p(URI uri, CloseablePath.ManagedFileSystem managedFileSystem) {
        this.f28019b = uri;
        this.f28020c = managedFileSystem;
    }

    public final void close() {
        ConcurrentMap.EL.compute(CloseablePath.MANAGED_FILE_SYSTEMS, this.f28019b, new m(this.f28020c));
    }
}
