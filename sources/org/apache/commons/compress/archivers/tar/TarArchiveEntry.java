package org.apache.commons.compress.archivers.tar;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import n20.j;
import n20.k;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

public class TarArchiveEntry implements ArchiveEntry, TarConstants, EntryStreamOffsets {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRY_ARRAY = new TarArchiveEntry[0];
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long UNKNOWN = -1;
    private boolean checkSumOK;
    private long dataOffset;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final Path file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private final LinkOption[] linkOptions;
    private String magic;
    private long modTime;
    private int mode;

    /* renamed from: name  reason: collision with root package name */
    private String f27642name;
    private boolean paxGNU1XSparse;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private List<TarArchiveStructSparse> sparseHeaders;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    private TarArchiveEntry(boolean z11) {
        this.f27642name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1;
        String property = System.getProperty("user.name", "");
        this.userName = property.length() > 31 ? property.substring(0, 31) : property;
        this.file = null;
        this.linkOptions = IOUtils.EMPTY_LINK_OPTIONS;
        this.preserveAbsolutePath = z11;
    }

    private int evaluateType(byte[] bArr) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6)) {
            return 2;
        }
        if (!ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6)) {
            return 0;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, bArr, 508, 4)) {
            return 4;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getOrderedSparseHeaders$0(TarArchiveStructSparse tarArchiveStructSparse) {
        return tarArchiveStructSparse.getOffset() > 0 || tarArchiveStructSparse.getNumbytes() > 0;
    }

    private static String normalizeFileName(String str, boolean z11) {
        String lowerCase;
        int indexOf;
        if (!z11 && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z11 && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private long parseOctalOrBinary(byte[] bArr, int i11, int i12, boolean z11) {
        if (!z11) {
            return TarUtils.parseOctalOrBinary(bArr, i11, i12);
        }
        try {
            return TarUtils.parseOctalOrBinary(bArr, i11, i12);
        } catch (IllegalArgumentException unused) {
            return -1;
        }
    }

    private void parseTarHeaderUnwrapped(byte[] bArr, ZipEncoding zipEncoding, boolean z11, boolean z12) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (z11) {
            str = TarUtils.parseName(bArr, 0, 100);
        } else {
            str = TarUtils.parseName(bArr, 0, 100, zipEncoding);
        }
        this.f27642name = str;
        this.mode = (int) parseOctalOrBinary(bArr, 100, 8, z12);
        this.userId = (long) ((int) parseOctalOrBinary(bArr, 108, 8, z12));
        this.groupId = (long) ((int) parseOctalOrBinary(bArr, 116, 8, z12));
        long parseOctalOrBinary = TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.size = parseOctalOrBinary;
        if (parseOctalOrBinary >= 0) {
            this.modTime = parseOctalOrBinary(bArr, Opcodes.L2I, 12, z12);
            this.checkSumOK = TarUtils.verifyCheckSum(bArr);
            this.linkFlag = bArr[156];
            if (z11) {
                str2 = TarUtils.parseName(bArr, Opcodes.IFGT, 100);
            } else {
                str2 = TarUtils.parseName(bArr, Opcodes.IFGT, 100, zipEncoding);
            }
            this.linkName = str2;
            this.magic = TarUtils.parseName(bArr, 257, 6);
            this.version = TarUtils.parseName(bArr, TarConstants.VERSION_OFFSET, 2);
            if (z11) {
                str3 = TarUtils.parseName(bArr, 265, 32);
            } else {
                str3 = TarUtils.parseName(bArr, 265, 32, zipEncoding);
            }
            this.userName = str3;
            if (z11) {
                str4 = TarUtils.parseName(bArr, 297, 32);
            } else {
                str4 = TarUtils.parseName(bArr, 297, 32, zipEncoding);
            }
            this.groupName = str4;
            byte b11 = this.linkFlag;
            if (b11 == 51 || b11 == 52) {
                this.devMajor = (int) parseOctalOrBinary(bArr, 329, 8, z12);
                this.devMinor = (int) parseOctalOrBinary(bArr, 337, 8, z12);
            }
            int evaluateType = evaluateType(bArr);
            if (evaluateType == 2) {
                this.sparseHeaders = new ArrayList(TarUtils.readSparseStructs(bArr, 386, 4));
                this.isExtended = TarUtils.parseBoolean(bArr, 482);
                this.realSize = TarUtils.parseOctal(bArr, 483, 12);
            } else if (evaluateType != 4) {
                if (z11) {
                    str6 = TarUtils.parseName(bArr, 345, 155);
                } else {
                    str6 = TarUtils.parseName(bArr, 345, 155, zipEncoding);
                }
                if (isDirectory() && !this.f27642name.endsWith("/")) {
                    this.f27642name += "/";
                }
                if (!str6.isEmpty()) {
                    this.f27642name = str6 + "/" + this.f27642name;
                }
            } else {
                if (z11) {
                    str5 = TarUtils.parseName(bArr, 345, 131);
                } else {
                    str5 = TarUtils.parseName(bArr, 345, 131, zipEncoding);
                }
                if (!str5.isEmpty()) {
                    this.f27642name = str5 + "/" + this.f27642name;
                }
            }
        } else {
            throw new IOException("broken archive, entry with negative size");
        }
    }

    private void processPaxHeader(String str, String str2) throws IOException {
        processPaxHeader(str, str2, this.extraPaxHeaders);
    }

    private void readFileMode(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (Files.isDirectory(path, linkOptionArr)) {
            this.mode = DEFAULT_DIR_MODE;
            this.linkFlag = TarConstants.LF_DIR;
            int length = str.length();
            if (length == 0 || str.charAt(length - 1) != '/') {
                this.f27642name = str + "/";
                return;
            }
            this.f27642name = str;
            return;
        }
        this.mode = DEFAULT_FILE_MODE;
        this.linkFlag = TarConstants.LF_NORMAL;
        this.f27642name = str;
        this.size = Files.size(path);
    }

    private void readOsSpecificProperties(Path path, LinkOption... linkOptionArr) throws IOException {
        Set a11 = path.getFileSystem().supportedFileAttributeViews();
        if (a11.contains("posix")) {
            PosixFileAttributes posixFileAttributes = (PosixFileAttributes) Files.readAttributes(path, PosixFileAttributes.class, linkOptionArr);
            setModTime(posixFileAttributes.lastModifiedTime());
            this.userName = posixFileAttributes.owner().getName();
            this.groupName = posixFileAttributes.group().getName();
            if (a11.contains("unix")) {
                this.userId = ((Number) Files.getAttribute(path, "unix:uid", linkOptionArr)).longValue();
                this.groupId = ((Number) Files.getAttribute(path, "unix:gid", linkOptionArr)).longValue();
            }
        } else if (a11.contains("dos")) {
            setModTime(((DosFileAttributes) Files.readAttributes(path, DosFileAttributes.class, linkOptionArr)).lastModifiedTime());
            this.userName = Files.getOwner(path, linkOptionArr).getName();
        } else {
            setModTime(Files.readAttributes(path, BasicFileAttributes.class, linkOptionArr).lastModifiedTime());
            this.userName = Files.getOwner(path, linkOptionArr).getName();
        }
    }

    private int writeEntryHeaderField(long j11, byte[] bArr, int i11, int i12, boolean z11) {
        if (z11 || (j11 >= 0 && j11 < (1 << ((i12 - 1) * 3)))) {
            return TarUtils.formatLongOctalOrBinaryBytes(j11, bArr, i11, i12);
        }
        return TarUtils.formatLongOctalBytes(0, bArr, i11, i12);
    }

    public void addPaxHeader(String str, String str2) {
        try {
            processPaxHeader(str, str2);
        } catch (IOException e11) {
            throw new IllegalArgumentException("Invalid input", e11);
        }
    }

    public void clearExtraPaxHeaders() {
        this.extraPaxHeaders.clear();
    }

    public boolean equals(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry != null && getName().equals(tarArchiveEntry.getName());
    }

    public void fillGNUSparse0xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = (long) Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.f27642name = map.get("GNU.sparse.name");
        }
    }

    public void fillGNUSparse1xData(Map<String, String> map) throws IOException {
        this.paxGNUSparse = true;
        this.paxGNU1XSparse = true;
        if (map.containsKey("GNU.sparse.name")) {
            this.f27642name = map.get("GNU.sparse.name");
        }
        if (map.containsKey("GNU.sparse.realsize")) {
            try {
                this.realSize = (long) Integer.parseInt(map.get("GNU.sparse.realsize"));
            } catch (NumberFormatException unused) {
                throw new IOException("Corrupted TAR archive. GNU.sparse.realsize header for " + this.f27642name + " contains non-numeric value");
            }
        }
    }

    public void fillStarSparseData(Map<String, String> map) throws IOException {
        this.starSparse = true;
        if (map.containsKey("SCHILY.realsize")) {
            try {
                this.realSize = Long.parseLong(map.get("SCHILY.realsize"));
            } catch (NumberFormatException unused) {
                throw new IOException("Corrupted TAR archive. SCHILY.realsize header for " + this.f27642name + " contains non-numeric value");
            }
        }
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r1 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.compress.archivers.tar.TarArchiveEntry[] getDirectoryEntries() {
        /*
            r5 = this;
            java.nio.file.Path r0 = r5.file
            if (r0 == 0) goto L_0x004e
            boolean r0 = r5.isDirectory()
            if (r0 != 0) goto L_0x000b
            goto L_0x004e
        L_0x000b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.nio.file.Path r1 = r5.file     // Catch:{ IOException -> 0x004b }
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1)     // Catch:{ IOException -> 0x004b }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x003d }
        L_0x001a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x003d }
            java.nio.file.Path r3 = (java.nio.file.Path) r3     // Catch:{ all -> 0x003d }
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r4 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry     // Catch:{ all -> 0x003d }
            r4.<init>((java.nio.file.Path) r3)     // Catch:{ all -> 0x003d }
            r0.add(r4)     // Catch:{ all -> 0x003d }
            goto L_0x001a
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x004b }
        L_0x0034:
            org.apache.commons.compress.archivers.tar.TarArchiveEntry[] r1 = EMPTY_TAR_ARCHIVE_ENTRY_ARRAY
            java.lang.Object[] r0 = r0.toArray(r1)
            org.apache.commons.compress.archivers.tar.TarArchiveEntry[] r0 = (org.apache.commons.compress.archivers.tar.TarArchiveEntry[]) r0
            return r0
        L_0x003d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            if (r1 == 0) goto L_0x004a
            r1.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r1 = move-exception
            r0.addSuppressed(r1)     // Catch:{ IOException -> 0x004b }
        L_0x004a:
            throw r2     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            org.apache.commons.compress.archivers.tar.TarArchiveEntry[] r0 = EMPTY_TAR_ARCHIVE_ENTRY_ARRAY
            return r0
        L_0x004e:
            org.apache.commons.compress.archivers.tar.TarArchiveEntry[] r0 = EMPTY_TAR_ARCHIVE_ENTRY_ARRAY
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveEntry.getDirectoryEntries():org.apache.commons.compress.archivers.tar.TarArchiveEntry[]");
    }

    public String getExtraPaxHeader(String str) {
        return this.extraPaxHeaders.get(str);
    }

    public Map<String, String> getExtraPaxHeaders() {
        return Collections.unmodifiableMap(this.extraPaxHeaders);
    }

    public File getFile() {
        Path path = this.file;
        if (path == null) {
            return null;
        }
        return path.toFile();
    }

    @Deprecated
    public int getGroupId() {
        return (int) (this.groupId & -1);
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Date getLastModifiedDate() {
        return getModTime();
    }

    public String getLinkName() {
        return this.linkName;
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public long getLongUserId() {
        return this.userId;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    public int getMode() {
        return this.mode;
    }

    public String getName() {
        return this.f27642name;
    }

    public List<TarArchiveStructSparse> getOrderedSparseHeaders() throws IOException {
        List<TarArchiveStructSparse> list = this.sparseHeaders;
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<TarArchiveStructSparse> list2 = (List) Collection.EL.stream(this.sparseHeaders).filter(new k()).sorted(Comparator.CC.comparingLong(new j())).collect(Collectors.toList());
        int size2 = list2.size();
        int i11 = 0;
        while (i11 < size2) {
            TarArchiveStructSparse tarArchiveStructSparse = list2.get(i11);
            i11++;
            if (i11 < size2 && tarArchiveStructSparse.getOffset() + tarArchiveStructSparse.getNumbytes() > list2.get(i11).getOffset()) {
                throw new IOException("Corrupted TAR archive. Sparse blocks for " + getName() + " overlap each other.");
            } else if (tarArchiveStructSparse.getOffset() + tarArchiveStructSparse.getNumbytes() < 0) {
                throw new IOException("Unreadable TAR archive. Offset and numbytes for sparse block in " + getName() + " too large.");
            }
        }
        if (!list2.isEmpty()) {
            TarArchiveStructSparse tarArchiveStructSparse2 = list2.get(size2 - 1);
            if (tarArchiveStructSparse2.getOffset() + tarArchiveStructSparse2.getNumbytes() > getRealSize()) {
                throw new IOException("Corrupted TAR archive. Sparse block extends beyond real size of the entry");
            }
        }
        return list2;
    }

    public Path getPath() {
        return this.file;
    }

    public long getRealSize() {
        if (!isSparse()) {
            return getSize();
        }
        return this.realSize;
    }

    public long getSize() {
        return this.size;
    }

    public List<TarArchiveStructSparse> getSparseHeaders() {
        return this.sparseHeaders;
    }

    @Deprecated
    public int getUserId() {
        return (int) (this.userId & -1);
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public boolean isDescendent(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry.getName().startsWith(getName());
    }

    public boolean isDirectory() {
        Path path = this.file;
        if (path != null) {
            return Files.isDirectory(path, this.linkOptions);
        }
        if (this.linkFlag == 53) {
            return true;
        }
        if (isPaxHeader() || isGlobalPaxHeader() || !getName().endsWith("/")) {
            return false;
        }
        return true;
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isFile() {
        Path path = this.file;
        if (path != null) {
            return Files.isRegularFile(path, this.linkOptions);
        }
        byte b11 = this.linkFlag;
        if (b11 == 0 || b11 == 48) {
            return true;
        }
        return !getName().endsWith("/");
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76;
    }

    public boolean isGNUSparse() {
        return isOldGNUSparse() || isPaxGNUSparse();
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isOldGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isPaxGNU1XSparse() {
        return this.paxGNU1XSparse;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isPaxHeader() {
        byte b11 = this.linkFlag;
        return b11 == 120 || b11 == 88;
    }

    public boolean isSparse() {
        return isGNUSparse() || isStarSparse();
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    public boolean isStreamContiguous() {
        return true;
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0006 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseTarHeader(byte[] r4) {
        /*
            r3 = this;
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x0006 }
            r3.parseTarHeader(r4, r0)     // Catch:{ IOException -> 0x0006 }
            goto L_0x000d
        L_0x0006:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x000e }
            r1 = 1
            r2 = 0
            r3.parseTarHeader(r4, r0, r1, r2)     // Catch:{ IOException -> 0x000e }
        L_0x000d:
            return
        L_0x000e:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveEntry.parseTarHeader(byte[]):void");
    }

    public void setDataOffset(long j11) {
        if (j11 >= 0) {
            this.dataOffset = j11;
            return;
        }
        throw new IllegalArgumentException("The offset can not be smaller than 0");
    }

    public void setDevMajor(int i11) {
        if (i11 >= 0) {
            this.devMajor = i11;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i11);
    }

    public void setDevMinor(int i11) {
        if (i11 >= 0) {
            this.devMinor = i11;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i11);
    }

    public void setGroupId(int i11) {
        setGroupId((long) i11);
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIds(int i11, int i12) {
        setUserId(i11);
        setGroupId(i12);
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    public void setModTime(long j11) {
        this.modTime = j11 / 1000;
    }

    public void setMode(int i11) {
        this.mode = i11;
    }

    public void setName(String str) {
        this.f27642name = normalizeFileName(str, this.preserveAbsolutePath);
    }

    public void setNames(String str, String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setSize(long j11) {
        if (j11 >= 0) {
            this.size = j11;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j11);
    }

    public void setSparseHeaders(List<TarArchiveStructSparse> list) {
        this.sparseHeaders = list;
    }

    public void setUserId(int i11) {
        setUserId((long) i11);
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void updateEntryFromPaxHeaders(Map<String, String> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            processPaxHeader((String) next.getKey(), (String) next.getValue(), map);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeEntryHeader(byte[] r3) {
        /*
            r2 = this;
            r0 = 0
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            r2.writeEntryHeader(r3, r1, r0)     // Catch:{ IOException -> 0x0007 }
            goto L_0x000c
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = org.apache.commons.compress.archivers.tar.TarUtils.FALLBACK_ENCODING     // Catch:{ IOException -> 0x000d }
            r2.writeEntryHeader(r3, r1, r0)     // Catch:{ IOException -> 0x000d }
        L_0x000c:
            return
        L_0x000d:
            r3 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveEntry.writeEntryHeader(byte[]):void");
    }

    private void processPaxHeader(String str, String str2, Map<String, String> map) throws IOException {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1916861932:
                if (str.equals("SCHILY.devmajor")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1916619760:
                if (str.equals("SCHILY.devminor")) {
                    c11 = 1;
                    break;
                }
                break;
            case -277496563:
                if (str.equals("GNU.sparse.realsize")) {
                    c11 = 2;
                    break;
                }
                break;
            case -160380561:
                if (str.equals("GNU.sparse.size")) {
                    c11 = 3;
                    break;
                }
                break;
            case 102338:
                if (str.equals("gid")) {
                    c11 = 4;
                    break;
                }
                break;
            case 115792:
                if (str.equals(PushNotificationParser.PUSH_ID_KEY)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3433509:
                if (str.equals("path")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3530753:
                if (str.equals(BindingAdaptersKt.QUERY_SIZE)) {
                    c11 = 7;
                    break;
                }
                break;
            case 98496370:
                if (str.equals("gname")) {
                    c11 = 8;
                    break;
                }
                break;
            case 104223930:
                if (str.equals("mtime")) {
                    c11 = 9;
                    break;
                }
                break;
            case 111425664:
                if (str.equals("uname")) {
                    c11 = 10;
                    break;
                }
                break;
            case 530706950:
                if (str.equals("SCHILY.filetype")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1195018015:
                if (str.equals("linkpath")) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                int parseInt = Integer.parseInt(str2);
                if (parseInt >= 0) {
                    setDevMajor(parseInt);
                    return;
                }
                throw new IOException("Corrupted TAR archive. Dev-Major is negative");
            case 1:
                int parseInt2 = Integer.parseInt(str2);
                if (parseInt2 >= 0) {
                    setDevMinor(parseInt2);
                    return;
                }
                throw new IOException("Corrupted TAR archive. Dev-Minor is negative");
            case 2:
                fillGNUSparse1xData(map);
                return;
            case 3:
                fillGNUSparse0xData(map);
                return;
            case 4:
                setGroupId(Long.parseLong(str2));
                return;
            case 5:
                setUserId(Long.parseLong(str2));
                return;
            case 6:
                setName(str2);
                return;
            case 7:
                long parseLong = Long.parseLong(str2);
                if (parseLong >= 0) {
                    setSize(parseLong);
                    return;
                }
                throw new IOException("Corrupted TAR archive. Entry size is negative");
            case 8:
                setGroupName(str2);
                return;
            case 9:
                setModTime((long) (Double.parseDouble(str2) * 1000.0d));
                return;
            case 10:
                setUserName(str2);
                return;
            case 11:
                if ("sparse".equals(str2)) {
                    fillStarSparseData(map);
                    return;
                }
                return;
            case 12:
                setLinkName(str2);
                return;
            default:
                this.extraPaxHeaders.put(str, str2);
                return;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) obj);
    }

    public void setGroupId(long j11) {
        this.groupId = j11;
    }

    public void setModTime(Date date) {
        this.modTime = date.getTime() / 1000;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }

    public void setModTime(FileTime fileTime) {
        this.modTime = fileTime.to(TimeUnit.SECONDS);
    }

    public void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        parseTarHeader(bArr, zipEncoding, false, false);
    }

    public void writeEntryHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z11) throws IOException {
        byte[] bArr2 = bArr;
        ZipEncoding zipEncoding2 = zipEncoding;
        byte[] bArr3 = bArr;
        boolean z12 = z11;
        int writeEntryHeaderField = writeEntryHeaderField(this.modTime, bArr3, writeEntryHeaderField(this.size, bArr3, writeEntryHeaderField(this.groupId, bArr3, writeEntryHeaderField(this.userId, bArr3, writeEntryHeaderField((long) this.mode, bArr3, TarUtils.formatNameBytes(this.f27642name, bArr, 0, 100, zipEncoding2), 8, z12), 8, z12), 8, z12), 12, z12), 12, z12);
        int i11 = 0;
        int i12 = writeEntryHeaderField;
        while (i11 < 8) {
            bArr2[i12] = 32;
            i11++;
            i12++;
        }
        bArr2[i12] = this.linkFlag;
        byte[] bArr4 = bArr;
        boolean z13 = z11;
        for (int writeEntryHeaderField2 = writeEntryHeaderField((long) this.devMinor, bArr4, writeEntryHeaderField((long) this.devMajor, bArr4, TarUtils.formatNameBytes(this.groupName, bArr, TarUtils.formatNameBytes(this.userName, bArr, TarUtils.formatNameBytes(this.version, bArr, TarUtils.formatNameBytes(this.magic, bArr, TarUtils.formatNameBytes(this.linkName, bArr, i12 + 1, 100, zipEncoding2), 6), 2), 32, zipEncoding2), 32, zipEncoding2), 8, z13), 8, z13); writeEntryHeaderField2 < bArr2.length; writeEntryHeaderField2++) {
            bArr2[writeEntryHeaderField2] = 0;
        }
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(bArr), bArr, writeEntryHeaderField, 8);
    }

    private void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z11, boolean z12) throws IOException {
        try {
            parseTarHeaderUnwrapped(bArr, zipEncoding, z11, z12);
        } catch (IllegalArgumentException e11) {
            throw new IOException("Corrupted TAR archive.", e11);
        }
    }

    public TarArchiveEntry(String str) {
        this(str, false);
    }

    public TarArchiveEntry(String str, boolean z11) {
        this(z11);
        String normalizeFileName = normalizeFileName(str, z11);
        boolean endsWith = normalizeFileName.endsWith("/");
        this.f27642name = normalizeFileName;
        this.mode = endsWith ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = endsWith ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = System.currentTimeMillis() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String str, byte b11) {
        this(str, b11, false);
    }

    public TarArchiveEntry(String str, byte b11, boolean z11) {
        this(str, z11);
        this.linkFlag = b11;
        if (b11 == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file2) {
        this(file2, file2.getPath());
    }

    public TarArchiveEntry(Path path) throws IOException {
        this(path, path.toString(), new LinkOption[0]);
    }

    public TarArchiveEntry(File file2, String str) {
        this.f27642name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1;
        String normalizeFileName = normalizeFileName(str, false);
        Path a11 = file2.toPath();
        this.file = a11;
        this.linkOptions = IOUtils.EMPTY_LINK_OPTIONS;
        try {
            readFileMode(a11, normalizeFileName, new LinkOption[0]);
        } catch (IOException unused) {
            if (!file2.isDirectory()) {
                this.size = file2.length();
            }
        }
        this.userName = "";
        try {
            readOsSpecificProperties(this.file, new LinkOption[0]);
        } catch (IOException unused2) {
            this.modTime = file2.lastModified() / 1000;
        }
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        this.f27642name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1;
        String normalizeFileName = normalizeFileName(str, false);
        this.file = path;
        this.linkOptions = linkOptionArr == null ? IOUtils.EMPTY_LINK_OPTIONS : linkOptionArr;
        readFileMode(path, normalizeFileName, linkOptionArr);
        this.userName = "";
        readOsSpecificProperties(path, new LinkOption[0]);
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(byte[] bArr) {
        this(false);
        parseTarHeader(bArr);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        this(bArr, zipEncoding, false);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z11) throws IOException {
        this(false);
        parseTarHeader(bArr, zipEncoding, false, z11);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z11, long j11) throws IOException {
        this(bArr, zipEncoding, z11);
        setDataOffset(j11);
    }
}
