package org.apache.commons.compress.archivers.sevenz;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class SevenZArchiveEntry implements ArchiveEntry {
    static final SevenZArchiveEntry[] EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY = new SevenZArchiveEntry[0];
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;

    /* renamed from: name  reason: collision with root package name */
    private String f27626name;
    private long size;
    private int windowsAttributes;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean equalSevenZMethods(java.lang.Iterable<? extends org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration> r5, java.lang.Iterable<? extends org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration> r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0009
            if (r6 != 0) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            r0 = r1
        L_0x0008:
            return r0
        L_0x0009:
            if (r6 != 0) goto L_0x000c
            return r1
        L_0x000c:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0032
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L_0x0021
            return r1
        L_0x0021:
            java.lang.Object r2 = r5.next()
            org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration r2 = (org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration) r2
            java.lang.Object r3 = r6.next()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0014
            return r1
        L_0x0032:
            boolean r5 = r6.hasNext()
            r5 = r5 ^ r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry.equalSevenZMethods(java.lang.Iterable, java.lang.Iterable):boolean");
    }

    public static long javaTimeToNtfsTime(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(DesugarTimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return (date.getTime() - instance.getTimeInMillis()) * 1000 * 10;
    }

    public static Date ntfsTimeToJavaTime(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(DesugarTimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return new Date(instance.getTimeInMillis() + (j11 / 10000));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SevenZArchiveEntry sevenZArchiveEntry = (SevenZArchiveEntry) obj;
        if (Objects.equals(this.f27626name, sevenZArchiveEntry.f27626name) && this.hasStream == sevenZArchiveEntry.hasStream && this.isDirectory == sevenZArchiveEntry.isDirectory && this.isAntiItem == sevenZArchiveEntry.isAntiItem && this.hasCreationDate == sevenZArchiveEntry.hasCreationDate && this.hasLastModifiedDate == sevenZArchiveEntry.hasLastModifiedDate && this.hasAccessDate == sevenZArchiveEntry.hasAccessDate && this.creationDate == sevenZArchiveEntry.creationDate && this.lastModifiedDate == sevenZArchiveEntry.lastModifiedDate && this.accessDate == sevenZArchiveEntry.accessDate && this.hasWindowsAttributes == sevenZArchiveEntry.hasWindowsAttributes && this.windowsAttributes == sevenZArchiveEntry.windowsAttributes && this.hasCrc == sevenZArchiveEntry.hasCrc && this.crc == sevenZArchiveEntry.crc && this.compressedCrc == sevenZArchiveEntry.compressedCrc && this.size == sevenZArchiveEntry.size && this.compressedSize == sevenZArchiveEntry.compressedSize && equalSevenZMethods(this.contentMethods, sevenZArchiveEntry.contentMethods)) {
            return true;
        }
        return false;
    }

    public Date getAccessDate() {
        if (this.hasAccessDate) {
            return ntfsTimeToJavaTime(this.accessDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    @Deprecated
    public int getCompressedCrc() {
        return (int) this.compressedCrc;
    }

    public long getCompressedCrcValue() {
        return this.compressedCrc;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    @Deprecated
    public int getCrc() {
        return (int) this.crc;
    }

    public long getCrcValue() {
        return this.crc;
    }

    public Date getCreationDate() {
        if (this.hasCreationDate) {
            return ntfsTimeToJavaTime(this.creationDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean getHasAccessDate() {
        return this.hasAccessDate;
    }

    public boolean getHasCrc() {
        return this.hasCrc;
    }

    public boolean getHasCreationDate() {
        return this.hasCreationDate;
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public boolean getHasWindowsAttributes() {
        return this.hasWindowsAttributes;
    }

    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate) {
            return ntfsTimeToJavaTime(this.lastModifiedDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public String getName() {
        return this.f27626name;
    }

    public long getSize() {
        return this.size;
    }

    public int getWindowsAttributes() {
        return this.windowsAttributes;
    }

    public boolean hasStream() {
        return this.hasStream;
    }

    public int hashCode() {
        String name2 = getName();
        if (name2 == null) {
            return 0;
        }
        return name2.hashCode();
    }

    public boolean isAntiItem() {
        return this.isAntiItem;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setAccessDate(long j11) {
        this.accessDate = j11;
    }

    public void setAntiItem(boolean z11) {
        this.isAntiItem = z11;
    }

    @Deprecated
    public void setCompressedCrc(int i11) {
        this.compressedCrc = (long) i11;
    }

    public void setCompressedCrcValue(long j11) {
        this.compressedCrc = j11;
    }

    public void setCompressedSize(long j11) {
        this.compressedSize = j11;
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        if (iterable != null) {
            LinkedList linkedList = new LinkedList();
            for (SevenZMethodConfiguration addLast : iterable) {
                linkedList.addLast(addLast);
            }
            this.contentMethods = Collections.unmodifiableList(linkedList);
            return;
        }
        this.contentMethods = null;
    }

    @Deprecated
    public void setCrc(int i11) {
        this.crc = (long) i11;
    }

    public void setCrcValue(long j11) {
        this.crc = j11;
    }

    public void setCreationDate(long j11) {
        this.creationDate = j11;
    }

    public void setDirectory(boolean z11) {
        this.isDirectory = z11;
    }

    public void setHasAccessDate(boolean z11) {
        this.hasAccessDate = z11;
    }

    public void setHasCrc(boolean z11) {
        this.hasCrc = z11;
    }

    public void setHasCreationDate(boolean z11) {
        this.hasCreationDate = z11;
    }

    public void setHasLastModifiedDate(boolean z11) {
        this.hasLastModifiedDate = z11;
    }

    public void setHasStream(boolean z11) {
        this.hasStream = z11;
    }

    public void setHasWindowsAttributes(boolean z11) {
        this.hasWindowsAttributes = z11;
    }

    public void setLastModifiedDate(long j11) {
        this.lastModifiedDate = j11;
    }

    public void setName(String str) {
        this.f27626name = str;
    }

    public void setSize(long j11) {
        this.size = j11;
    }

    public void setWindowsAttributes(int i11) {
        this.windowsAttributes = i11;
    }

    public void setAccessDate(Date date) {
        boolean z11 = date != null;
        this.hasAccessDate = z11;
        if (z11) {
            this.accessDate = javaTimeToNtfsTime(date);
        }
    }

    public void setCreationDate(Date date) {
        boolean z11 = date != null;
        this.hasCreationDate = z11;
        if (z11) {
            this.creationDate = javaTimeToNtfsTime(date);
        }
    }

    public void setLastModifiedDate(Date date) {
        boolean z11 = date != null;
        this.hasLastModifiedDate = z11;
        if (z11) {
            this.lastModifiedDate = javaTimeToNtfsTime(date);
        }
    }
}
