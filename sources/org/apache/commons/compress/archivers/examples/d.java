package org.apache.commons.compress.archivers.examples;

import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.zip.ZipFile;

public final /* synthetic */ class d implements Expander.EntryWriter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZipFile f27588a;

    public /* synthetic */ d(ZipFile zipFile) {
        this.f27588a = zipFile;
    }

    public final void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) {
        Expander.lambda$expand$5(this.f27588a, archiveEntry, outputStream);
    }
}
