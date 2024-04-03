package org.apache.commons.compress.changes;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

public final class ChangeSet {
    private final Set<Change> changes = new LinkedHashSet();

    private void addAddition(Change change) {
        if (2 == change.e() && change.b() != null) {
            if (!this.changes.isEmpty()) {
                Iterator<Change> it = this.changes.iterator();
                while (it.hasNext()) {
                    Change next = it.next();
                    if (next.e() == 2 && next.a() != null && next.a().equals(change.a())) {
                        if (change.c()) {
                            it.remove();
                            this.changes.add(change);
                            return;
                        }
                        return;
                    }
                }
            }
            this.changes.add(change);
        }
    }

    private void addDeletion(Change change) {
        String name2;
        if ((1 == change.e() || 4 == change.e()) && change.d() != null) {
            String d11 = change.d();
            if (d11 != null && !this.changes.isEmpty()) {
                Iterator<Change> it = this.changes.iterator();
                while (it.hasNext()) {
                    Change next = it.next();
                    if (!(next.e() != 2 || next.a() == null || (name2 = next.a().getName()) == null)) {
                        if (1 != change.e() || !d11.equals(name2)) {
                            if (4 == change.e()) {
                                if (!name2.matches(d11 + "/.*")) {
                                }
                            }
                        }
                        it.remove();
                    }
                }
            }
            this.changes.add(change);
        }
    }

    public void add(ArchiveEntry archiveEntry, InputStream inputStream) {
        add(archiveEntry, inputStream, true);
    }

    public void delete(String str) {
        addDeletion(new Change(str, 1));
    }

    public void deleteDir(String str) {
        addDeletion(new Change(str, 4));
    }

    public Set<Change> getChanges() {
        return new LinkedHashSet(this.changes);
    }

    public void add(ArchiveEntry archiveEntry, InputStream inputStream, boolean z11) {
        addAddition(new Change(archiveEntry, inputStream, z11));
    }
}
