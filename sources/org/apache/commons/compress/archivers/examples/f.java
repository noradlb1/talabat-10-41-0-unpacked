package org.apache.commons.compress.archivers.examples;

import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.tar.TarFile;

public final /* synthetic */ class f implements Expander.EntryWriter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TarFile f27590a;

    public /* synthetic */ f(TarFile tarFile) {
        this.f27590a = tarFile;
    }

    public final void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) {
        Expander.lambda$expand$3(this.f27590a, archiveEntry, outputStream);
    }
}
