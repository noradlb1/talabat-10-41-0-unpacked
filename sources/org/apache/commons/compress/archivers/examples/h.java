package org.apache.commons.compress.archivers.examples;

import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public final /* synthetic */ class h implements Expander.EntryWriter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SevenZFile f27592a;

    public /* synthetic */ h(SevenZFile sevenZFile) {
        this.f27592a = sevenZFile;
    }

    public final void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) {
        Expander.lambda$expand$6(this.f27592a, archiveEntry, outputStream);
    }
}
