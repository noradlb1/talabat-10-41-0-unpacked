package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public final /* synthetic */ class g implements Expander.ArchiveEntrySupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SevenZFile f27591a;

    public /* synthetic */ g(SevenZFile sevenZFile) {
        this.f27591a = sevenZFile;
    }

    public final ArchiveEntry getNextReadableEntry() {
        return this.f27591a.getNextEntry();
    }
}
