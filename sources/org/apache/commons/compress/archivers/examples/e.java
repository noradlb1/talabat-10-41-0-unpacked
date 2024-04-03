package org.apache.commons.compress.archivers.examples;

import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;

public final /* synthetic */ class e implements Expander.ArchiveEntrySupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Iterator f27589a;

    public /* synthetic */ e(Iterator it) {
        this.f27589a = it;
    }

    public final ArchiveEntry getNextReadableEntry() {
        return Expander.lambda$expand$2(this.f27589a);
    }
}
