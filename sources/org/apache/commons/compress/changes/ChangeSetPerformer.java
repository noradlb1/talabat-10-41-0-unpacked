package org.apache.commons.compress.changes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

public class ChangeSetPerformer {
    private final Set<Change> changes;

    public interface ArchiveEntryIterator {
        InputStream getInputStream() throws IOException;

        boolean hasNext() throws IOException;

        ArchiveEntry next();
    }

    public static class ArchiveInputStreamIterator implements ArchiveEntryIterator {

        /* renamed from: in  reason: collision with root package name */
        private final ArchiveInputStream f27668in;
        private ArchiveEntry next;

        public ArchiveInputStreamIterator(ArchiveInputStream archiveInputStream) {
            this.f27668in = archiveInputStream;
        }

        public InputStream getInputStream() {
            return this.f27668in;
        }

        public boolean hasNext() throws IOException {
            ArchiveEntry nextEntry = this.f27668in.getNextEntry();
            this.next = nextEntry;
            return nextEntry != null;
        }

        public ArchiveEntry next() {
            return this.next;
        }
    }

    public static class ZipFileIterator implements ArchiveEntryIterator {
        private ZipArchiveEntry current;

        /* renamed from: in  reason: collision with root package name */
        private final ZipFile f27669in;
        private final Enumeration<ZipArchiveEntry> nestedEnum;

        public ZipFileIterator(ZipFile zipFile) {
            this.f27669in = zipFile;
            this.nestedEnum = zipFile.getEntriesInPhysicalOrder();
        }

        public InputStream getInputStream() throws IOException {
            return this.f27669in.getInputStream(this.current);
        }

        public boolean hasNext() {
            return this.nestedEnum.hasMoreElements();
        }

        public ArchiveEntry next() {
            ZipArchiveEntry nextElement = this.nestedEnum.nextElement();
            this.current = nextElement;
            return nextElement;
        }
    }

    public ChangeSetPerformer(ChangeSet changeSet) {
        this.changes = changeSet.getChanges();
    }

    private void copyStream(InputStream inputStream, ArchiveOutputStream archiveOutputStream, ArchiveEntry archiveEntry) throws IOException {
        archiveOutputStream.putArchiveEntry(archiveEntry);
        IOUtils.copy(inputStream, (OutputStream) archiveOutputStream);
        archiveOutputStream.closeArchiveEntry();
    }

    private boolean isDeletedLater(Set<Change> set, ArchiveEntry archiveEntry) {
        String name2 = archiveEntry.getName();
        if (set.isEmpty()) {
            return false;
        }
        for (Change next : set) {
            int e11 = next.e();
            String d11 = next.d();
            if (e11 == 1 && name2.equals(d11)) {
                return true;
            }
            if (e11 == 4) {
                if (name2.startsWith(d11 + "/")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ChangeSetResults perform(ArchiveInputStream archiveInputStream, ArchiveOutputStream archiveOutputStream) throws IOException {
        return perform((ArchiveEntryIterator) new ArchiveInputStreamIterator(archiveInputStream), archiveOutputStream);
    }

    public ChangeSetResults perform(ZipFile zipFile, ArchiveOutputStream archiveOutputStream) throws IOException {
        return perform((ArchiveEntryIterator) new ZipFileIterator(zipFile), archiveOutputStream);
    }

    private ChangeSetResults perform(ArchiveEntryIterator archiveEntryIterator, ArchiveOutputStream archiveOutputStream) throws IOException {
        boolean z11;
        ChangeSetResults changeSetResults = new ChangeSetResults();
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.changes);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Change change = (Change) it.next();
            if (change.e() == 2 && change.c()) {
                copyStream(change.b(), archiveOutputStream, change.a());
                it.remove();
                changeSetResults.addedFromChangeSet(change.a().getName());
            }
        }
        while (archiveEntryIterator.hasNext()) {
            ArchiveEntry next = archiveEntryIterator.next();
            Iterator it2 = linkedHashSet.iterator();
            while (true) {
                z11 = true;
                if (!it2.hasNext()) {
                    break;
                }
                Change change2 = (Change) it2.next();
                int e11 = change2.e();
                String name2 = next.getName();
                if (e11 != 1 || name2 == null) {
                    if (e11 == 4 && name2 != null) {
                        if (name2.startsWith(change2.d() + "/")) {
                            changeSetResults.deleted(name2);
                            break;
                        }
                    }
                } else if (name2.equals(change2.d())) {
                    it2.remove();
                    changeSetResults.deleted(name2);
                    break;
                }
            }
            z11 = false;
            if (z11 && !isDeletedLater(linkedHashSet, next) && !changeSetResults.hasBeenAdded(next.getName())) {
                copyStream(archiveEntryIterator.getInputStream(), archiveOutputStream, next);
                changeSetResults.addedFromStream(next.getName());
            }
        }
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            Change change3 = (Change) it3.next();
            if (change3.e() == 2 && !change3.c() && !changeSetResults.hasBeenAdded(change3.a().getName())) {
                copyStream(change3.b(), archiveOutputStream, change3.a());
                it3.remove();
                changeSetResults.addedFromChangeSet(change3.a().getName());
            }
        }
        archiveOutputStream.finish();
        return changeSetResults;
    }
}
