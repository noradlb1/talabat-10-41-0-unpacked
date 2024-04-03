package org.apache.commons.compress.archivers.examples;

import java.util.Enumeration;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.zip.ZipFile;

public final /* synthetic */ class c implements Expander.ArchiveEntrySupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Enumeration f27586a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZipFile f27587b;

    public /* synthetic */ c(Enumeration enumeration, ZipFile zipFile) {
        this.f27586a = enumeration;
        this.f27587b = zipFile;
    }

    public final ArchiveEntry getNextReadableEntry() {
        return Expander.lambda$expand$4(this.f27586a, this.f27587b);
    }
}
