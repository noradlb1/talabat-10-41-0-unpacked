package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.examples.Expander;

public final /* synthetic */ class a implements Expander.ArchiveEntrySupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArchiveInputStream f27584a;

    public /* synthetic */ a(ArchiveInputStream archiveInputStream) {
        this.f27584a = archiveInputStream;
    }

    public final ArchiveEntry getNextReadableEntry() {
        return Expander.lambda$expand$0(this.f27584a);
    }
}
