package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.CountingOutputStream;

public class SevenZOutputFile implements Closeable {
    private CountingOutputStream[] additionalCountingStreams;
    private final Map<SevenZArchiveEntry, long[]> additionalSizes;
    /* access modifiers changed from: private */
    public final SeekableByteChannel channel;
    /* access modifiers changed from: private */
    public final CRC32 compressedCrc32;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    /* access modifiers changed from: private */
    public final CRC32 crc32;
    private CountingOutputStream currentOutputStream;
    /* access modifiers changed from: private */
    public long fileBytesWritten;
    private final List<SevenZArchiveEntry> files;
    private boolean finished;
    private int numNonEmptyStreams;

    public SevenZOutputFile(File file) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]));
    }

    public static /* synthetic */ long access$408(SevenZOutputFile sevenZOutputFile) {
        long j11 = sevenZOutputFile.fileBytesWritten;
        sevenZOutputFile.fileBytesWritten = 1 + j11;
        return j11;
    }

    private Iterable<? extends SevenZMethodConfiguration> getContentMethods(SevenZArchiveEntry sevenZArchiveEntry) {
        Iterable<? extends SevenZMethodConfiguration> contentMethods2 = sevenZArchiveEntry.getContentMethods();
        if (contentMethods2 == null) {
            return this.contentMethods;
        }
        return contentMethods2;
    }

    private OutputStream getCurrentOutputStream() throws IOException {
        if (this.currentOutputStream == null) {
            this.currentOutputStream = setupFileOutputStream();
        }
        return this.currentOutputStream;
    }

    private static <T> Iterable<T> reverse(Iterable<T> iterable) {
        LinkedList linkedList = new LinkedList();
        for (T addFirst : iterable) {
            linkedList.addFirst(addFirst);
        }
        return linkedList;
    }

    private CountingOutputStream setupFileOutputStream() throws IOException {
        if (!this.files.isEmpty()) {
            CountingOutputStream outputStreamWrapper = new OutputStreamWrapper();
            ArrayList arrayList = new ArrayList();
            List<SevenZArchiveEntry> list = this.files;
            boolean z11 = true;
            for (SevenZMethodConfiguration sevenZMethodConfiguration : getContentMethods(list.get(list.size() - 1))) {
                if (!z11) {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(outputStreamWrapper);
                    arrayList.add(countingOutputStream);
                    outputStreamWrapper = countingOutputStream;
                }
                outputStreamWrapper = Coders.b(outputStreamWrapper, sevenZMethodConfiguration.getMethod(), sevenZMethodConfiguration.getOptions());
                z11 = false;
            }
            if (!arrayList.isEmpty()) {
                this.additionalCountingStreams = (CountingOutputStream[]) arrayList.toArray(new CountingOutputStream[0]);
            }
            return new CountingOutputStream(outputStreamWrapper) {
                public void write(int i11) throws IOException {
                    super.write(i11);
                    SevenZOutputFile.this.crc32.update(i11);
                }

                public void write(byte[] bArr) throws IOException {
                    super.write(bArr);
                    SevenZOutputFile.this.crc32.update(bArr);
                }

                public void write(byte[] bArr, int i11, int i12) throws IOException {
                    super.write(bArr, i11, i12);
                    SevenZOutputFile.this.crc32.update(bArr, i11, i12);
                }
            };
        }
        throw new IllegalStateException("No current 7z entry");
    }

    private void writeBits(DataOutput dataOutput, BitSet bitSet, int i11) throws IOException {
        int i12 = 0;
        boolean z11 = true;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 |= (bitSet.get(i13) ? 1 : 0) << (z11 ? 1 : 0);
            z11 -= true;
            if (z11 < 0) {
                dataOutput.write(i12);
                i12 = 0;
                z11 = 7;
            }
        }
        if (!z11) {
            dataOutput.write(i12);
        }
    }

    private void writeFileATimes(DataOutput dataOutput) throws IOException {
        int i11 = 0;
        for (SevenZArchiveEntry hasAccessDate : this.files) {
            if (hasAccessDate.getHasAccessDate()) {
                i11++;
            }
        }
        if (i11 > 0) {
            dataOutput.write(19);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i11 != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i12 = 0; i12 < this.files.size(); i12++) {
                    bitSet.set(i12, this.files.get(i12).getHasAccessDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasAccessDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getAccessDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileAntiItems(DataOutput dataOutput) throws IOException {
        boolean z11 = false;
        BitSet bitSet = new BitSet(0);
        int i11 = 0;
        for (SevenZArchiveEntry next : this.files) {
            if (!next.hasStream()) {
                boolean isAntiItem = next.isAntiItem();
                bitSet.set(i11, isAntiItem);
                z11 |= isAntiItem;
                i11++;
            }
        }
        if (z11) {
            dataOutput.write(16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, i11);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileCTimes(DataOutput dataOutput) throws IOException {
        int i11 = 0;
        for (SevenZArchiveEntry hasCreationDate : this.files) {
            if (hasCreationDate.getHasCreationDate()) {
                i11++;
            }
        }
        if (i11 > 0) {
            dataOutput.write(18);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i11 != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i12 = 0; i12 < this.files.size(); i12++) {
                    bitSet.set(i12, this.files.get(i12).getHasCreationDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasCreationDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getCreationDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileEmptyFiles(DataOutput dataOutput) throws IOException {
        boolean z11 = false;
        BitSet bitSet = new BitSet(0);
        int i11 = 0;
        for (SevenZArchiveEntry next : this.files) {
            if (!next.hasStream()) {
                boolean isDirectory = next.isDirectory();
                bitSet.set(i11, !isDirectory);
                z11 |= !isDirectory;
                i11++;
            }
        }
        if (z11) {
            dataOutput.write(15);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, i11);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileEmptyStreams(DataOutput dataOutput) throws IOException {
        int i11;
        boolean z11;
        Iterator<SevenZArchiveEntry> it = this.files.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().hasStream()) {
                    z11 = true;
                    break;
                }
            } else {
                z11 = false;
                break;
            }
        }
        if (z11) {
            dataOutput.write(14);
            BitSet bitSet = new BitSet(this.files.size());
            for (i11 = 0; i11 < this.files.size(); i11++) {
                bitSet.set(i11, !this.files.get(i11).hasStream());
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeBits(dataOutputStream, bitSet, this.files.size());
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileMTimes(DataOutput dataOutput) throws IOException {
        int i11 = 0;
        for (SevenZArchiveEntry hasLastModifiedDate : this.files) {
            if (hasLastModifiedDate.getHasLastModifiedDate()) {
                i11++;
            }
        }
        if (i11 > 0) {
            dataOutput.write(20);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i11 != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i12 = 0; i12 < this.files.size(); i12++) {
                    bitSet.set(i12, this.files.get(i12).getHasLastModifiedDate());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasLastModifiedDate()) {
                    dataOutputStream.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(next.getLastModifiedDate())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFileNames(DataOutput dataOutput) throws IOException {
        dataOutput.write(17);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(0);
        for (SevenZArchiveEntry name2 : this.files) {
            dataOutputStream.write(name2.getName().getBytes(StandardCharsets.UTF_16LE));
            dataOutputStream.writeShort(0);
        }
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        writeUint64(dataOutput, (long) byteArray.length);
        dataOutput.write(byteArray);
    }

    private void writeFileWindowsAttributes(DataOutput dataOutput) throws IOException {
        int i11 = 0;
        for (SevenZArchiveEntry hasWindowsAttributes : this.files) {
            if (hasWindowsAttributes.getHasWindowsAttributes()) {
                i11++;
            }
        }
        if (i11 > 0) {
            dataOutput.write(21);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i11 != this.files.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.files.size());
                for (int i12 = 0; i12 < this.files.size(); i12++) {
                    bitSet.set(i12, this.files.get(i12).getHasWindowsAttributes());
                }
                writeBits(dataOutputStream, bitSet, this.files.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (SevenZArchiveEntry next : this.files) {
                if (next.getHasWindowsAttributes()) {
                    dataOutputStream.writeInt(Integer.reverseBytes(next.getWindowsAttributes()));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeUint64(dataOutput, (long) byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void writeFilesInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(5);
        writeUint64(dataOutput, (long) this.files.size());
        writeFileEmptyStreams(dataOutput);
        writeFileEmptyFiles(dataOutput);
        writeFileAntiItems(dataOutput);
        writeFileNames(dataOutput);
        writeFileCTimes(dataOutput);
        writeFileATimes(dataOutput);
        writeFileMTimes(dataOutput);
        writeFileWindowsAttributes(dataOutput);
        dataOutput.write(0);
    }

    private void writeFolder(DataOutput dataOutput, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        for (SevenZMethodConfiguration writeSingleCodec : getContentMethods(sevenZArchiveEntry)) {
            i11++;
            writeSingleCodec(writeSingleCodec, byteArrayOutputStream);
        }
        writeUint64(dataOutput, (long) i11);
        dataOutput.write(byteArrayOutputStream.toByteArray());
        long j11 = 0;
        while (j11 < ((long) (i11 - 1))) {
            long j12 = 1 + j11;
            writeUint64(dataOutput, j12);
            writeUint64(dataOutput, j11);
            j11 = j12;
        }
    }

    private void writeHeader(DataOutput dataOutput) throws IOException {
        dataOutput.write(1);
        dataOutput.write(4);
        writeStreamsInfo(dataOutput);
        writeFilesInfo(dataOutput);
        dataOutput.write(0);
    }

    private void writePackInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(6);
        writeUint64(dataOutput, 0);
        writeUint64(dataOutput, ((long) this.numNonEmptyStreams) & 4294967295L);
        dataOutput.write(9);
        for (SevenZArchiveEntry next : this.files) {
            if (next.hasStream()) {
                writeUint64(dataOutput, next.getCompressedSize());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (SevenZArchiveEntry next2 : this.files) {
            if (next2.hasStream()) {
                dataOutput.writeInt(Integer.reverseBytes((int) next2.getCompressedCrcValue()));
            }
        }
        dataOutput.write(0);
    }

    private void writeSingleCodec(SevenZMethodConfiguration sevenZMethodConfiguration, OutputStream outputStream) throws IOException {
        byte[] id2 = sevenZMethodConfiguration.getMethod().getId();
        byte[] d11 = Coders.c(sevenZMethodConfiguration.getMethod()).d(sevenZMethodConfiguration.getOptions());
        int length = id2.length;
        if (d11.length > 0) {
            length |= 32;
        }
        outputStream.write(length);
        outputStream.write(id2);
        if (d11.length > 0) {
            outputStream.write(d11.length);
            outputStream.write(d11);
        }
    }

    private void writeStreamsInfo(DataOutput dataOutput) throws IOException {
        if (this.numNonEmptyStreams > 0) {
            writePackInfo(dataOutput);
            writeUnpackInfo(dataOutput);
        }
        writeSubStreamsInfo(dataOutput);
        dataOutput.write(0);
    }

    private void writeSubStreamsInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(8);
        dataOutput.write(0);
    }

    private void writeUint64(DataOutput dataOutput, long j11) throws IOException {
        int i11 = 0;
        int i12 = 128;
        int i13 = 0;
        while (true) {
            if (i11 >= 8) {
                break;
            }
            int i14 = i11 + 1;
            if (j11 < (1 << (i14 * 7))) {
                i13 = (int) (((long) i13) | (j11 >>> (i11 * 8)));
                break;
            }
            i13 |= i12;
            i12 >>>= 1;
            i11 = i14;
        }
        dataOutput.write(i13);
        while (i11 > 0) {
            dataOutput.write((int) (255 & j11));
            j11 >>>= 8;
            i11--;
        }
    }

    private void writeUnpackInfo(DataOutput dataOutput) throws IOException {
        dataOutput.write(7);
        dataOutput.write(11);
        writeUint64(dataOutput, (long) this.numNonEmptyStreams);
        dataOutput.write(0);
        for (SevenZArchiveEntry next : this.files) {
            if (next.hasStream()) {
                writeFolder(dataOutput, next);
            }
        }
        dataOutput.write(12);
        for (SevenZArchiveEntry next2 : this.files) {
            if (next2.hasStream()) {
                long[] jArr = this.additionalSizes.get(next2);
                if (jArr != null) {
                    for (long writeUint64 : jArr) {
                        writeUint64(dataOutput, writeUint64);
                    }
                }
                writeUint64(dataOutput, next2.getSize());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (SevenZArchiveEntry next3 : this.files) {
            if (next3.hasStream()) {
                dataOutput.writeInt(Integer.reverseBytes((int) next3.getCrcValue()));
            }
        }
        dataOutput.write(0);
    }

    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            this.channel.close();
        }
    }

    public void closeArchiveEntry() throws IOException {
        CountingOutputStream countingOutputStream = this.currentOutputStream;
        if (countingOutputStream != null) {
            countingOutputStream.flush();
            this.currentOutputStream.close();
        }
        List<SevenZArchiveEntry> list = this.files;
        SevenZArchiveEntry sevenZArchiveEntry = list.get(list.size() - 1);
        int i11 = 0;
        if (this.fileBytesWritten > 0) {
            sevenZArchiveEntry.setHasStream(true);
            this.numNonEmptyStreams++;
            sevenZArchiveEntry.setSize(this.currentOutputStream.getBytesWritten());
            sevenZArchiveEntry.setCompressedSize(this.fileBytesWritten);
            sevenZArchiveEntry.setCrcValue(this.crc32.getValue());
            sevenZArchiveEntry.setCompressedCrcValue(this.compressedCrc32.getValue());
            sevenZArchiveEntry.setHasCrc(true);
            CountingOutputStream[] countingOutputStreamArr = this.additionalCountingStreams;
            if (countingOutputStreamArr != null) {
                long[] jArr = new long[countingOutputStreamArr.length];
                while (true) {
                    CountingOutputStream[] countingOutputStreamArr2 = this.additionalCountingStreams;
                    if (i11 >= countingOutputStreamArr2.length) {
                        break;
                    }
                    jArr[i11] = countingOutputStreamArr2[i11].getBytesWritten();
                    i11++;
                }
                this.additionalSizes.put(sevenZArchiveEntry, jArr);
            }
        } else {
            sevenZArchiveEntry.setHasStream(false);
            sevenZArchiveEntry.setSize(0);
            sevenZArchiveEntry.setCompressedSize(0);
            sevenZArchiveEntry.setHasCrc(false);
        }
        this.currentOutputStream = null;
        this.additionalCountingStreams = null;
        this.crc32.reset();
        this.compressedCrc32.reset();
        this.fileBytesWritten = 0;
    }

    public SevenZArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        SevenZArchiveEntry sevenZArchiveEntry = new SevenZArchiveEntry();
        sevenZArchiveEntry.setDirectory(file.isDirectory());
        sevenZArchiveEntry.setName(str);
        sevenZArchiveEntry.setLastModifiedDate(new Date(file.lastModified()));
        return sevenZArchiveEntry;
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.finished = true;
            long a11 = this.channel.position();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            writeHeader(dataOutputStream);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int unused = this.channel.write(ByteBuffer.wrap(byteArray));
            CRC32 crc322 = new CRC32();
            crc322.update(byteArray);
            byte[] bArr = SevenZFile.sevenZSignature;
            ByteBuffer order = ByteBuffer.allocate(bArr.length + 2 + 4 + 8 + 8 + 4).order(ByteOrder.LITTLE_ENDIAN);
            SeekableByteChannel unused2 = this.channel.position(0);
            order.put(bArr);
            order.put((byte) 0).put((byte) 2);
            order.putInt(0);
            order.putLong(a11 - 32).putLong(((long) byteArray.length) & 4294967295L).putInt((int) crc322.getValue());
            crc322.reset();
            crc322.update(order.array(), bArr.length + 6, 20);
            order.putInt(bArr.length + 2, (int) crc322.getValue());
            order.flip();
            int unused3 = this.channel.write(order);
            return;
        }
        throw new IOException("This archive has already been finished");
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        this.files.add((SevenZArchiveEntry) archiveEntry);
    }

    public void setContentCompression(SevenZMethod sevenZMethod) {
        setContentMethods(Collections.singletonList(new SevenZMethodConfiguration(sevenZMethod)));
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        this.contentMethods = reverse(iterable);
    }

    public void write(int i11) throws IOException {
        getCurrentOutputStream().write(i11);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 > 0) {
            getCurrentOutputStream().write(bArr, i11, i12);
        }
    }

    public SevenZOutputFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this.files = new ArrayList();
        this.crc32 = new CRC32();
        this.compressedCrc32 = new CRC32();
        this.contentMethods = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA2));
        this.additionalSizes = new HashMap();
        this.channel = seekableByteChannel;
        SeekableByteChannel unused = seekableByteChannel.position(32);
    }

    public void write(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8024];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public class OutputStreamWrapper extends OutputStream {
        private static final int BUF_SIZE = 8192;
        private final ByteBuffer buffer;

        private OutputStreamWrapper() {
            this.buffer = ByteBuffer.allocate(8192);
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public void write(int i11) throws IOException {
            this.buffer.clear();
            this.buffer.put((byte) i11).flip();
            int unused = SevenZOutputFile.this.channel.write(this.buffer);
            SevenZOutputFile.this.compressedCrc32.update(i11);
            SevenZOutputFile.access$408(SevenZOutputFile.this);
        }

        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 > 8192) {
                int unused = SevenZOutputFile.this.channel.write(ByteBuffer.wrap(bArr, i11, i12));
            } else {
                this.buffer.clear();
                this.buffer.put(bArr, i11, i12).flip();
                int unused2 = SevenZOutputFile.this.channel.write(this.buffer);
            }
            SevenZOutputFile.this.compressedCrc32.update(bArr, i11, i12);
            SevenZOutputFile sevenZOutputFile = SevenZOutputFile.this;
            long unused3 = sevenZOutputFile.fileBytesWritten = sevenZOutputFile.fileBytesWritten + ((long) i12);
        }
    }

    public SevenZArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        SevenZArchiveEntry sevenZArchiveEntry = new SevenZArchiveEntry();
        sevenZArchiveEntry.setDirectory(Files.isDirectory(path, linkOptionArr));
        sevenZArchiveEntry.setName(str);
        sevenZArchiveEntry.setLastModifiedDate(new Date(Files.getLastModifiedTime(path, linkOptionArr).toMillis()));
        return sevenZArchiveEntry;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(java.nio.file.Path r2, java.nio.file.OpenOption... r3) throws java.io.IOException {
        /*
            r1 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r3)
            r0.<init>(r2)
            r1.write((java.io.InputStream) r0)     // Catch:{ all -> 0x0010 }
            r0.close()
            return
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZOutputFile.write(java.nio.file.Path, java.nio.file.OpenOption[]):void");
    }
}
