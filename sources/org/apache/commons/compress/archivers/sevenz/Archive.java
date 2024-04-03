package org.apache.commons.compress.archivers.sevenz;

import java.util.BitSet;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class Archive {

    /* renamed from: a  reason: collision with root package name */
    public long f27598a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f27599b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    public BitSet f27600c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f27601d;

    /* renamed from: e  reason: collision with root package name */
    public Folder[] f27602e = Folder.f27616j;

    /* renamed from: f  reason: collision with root package name */
    public SubStreamsInfo f27603f;

    /* renamed from: g  reason: collision with root package name */
    public SevenZArchiveEntry[] f27604g = SevenZArchiveEntry.EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY;

    /* renamed from: h  reason: collision with root package name */
    public StreamMap f27605h;

    private static String lengthOf(long[] jArr) {
        return jArr == null ? "(null)" : String.valueOf(jArr.length);
    }

    public String toString() {
        return "Archive with packed streams starting at offset " + this.f27598a + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + lengthOf(this.f27599b) + " pack sizes, " + lengthOf(this.f27601d) + " CRCs, " + lengthOf((Object[]) this.f27602e) + " folders, " + lengthOf((Object[]) this.f27604g) + " files and " + this.f27605h;
    }

    private static String lengthOf(Object[] objArr) {
        return objArr == null ? "(null)" : String.valueOf(objArr.length);
    }
}
