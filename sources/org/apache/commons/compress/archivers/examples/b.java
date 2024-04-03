package org.apache.commons.compress.archivers.examples;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.utils.IOUtils;

public final /* synthetic */ class b implements Expander.EntryWriter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArchiveInputStream f27585a;

    public /* synthetic */ b(ArchiveInputStream archiveInputStream) {
        this.f27585a = archiveInputStream;
    }

    public final void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) {
        IOUtils.copy((InputStream) this.f27585a, outputStream);
    }
}
