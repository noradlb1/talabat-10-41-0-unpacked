package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.compress.utils.FileNameUtils;

class ZipSplitOutputStream extends OutputStream {
    private static final long ZIP_SEGMENT_MAX_SIZE = 4294967295L;
    private static final long ZIP_SEGMENT_MIN_SIZE = 65536;
    private long currentSplitSegmentBytesWritten;
    private int currentSplitSegmentIndex;
    private boolean finished;
    private OutputStream outputStream;
    private final byte[] singleByte = new byte[1];
    private final long splitSize;
    private File zipFile;

    public ZipSplitOutputStream(File file, long j11) throws IllegalArgumentException, IOException {
        if (j11 < 65536 || j11 > 4294967295L) {
            throw new IllegalArgumentException("zip split segment size should between 64K and 4,294,967,295");
        }
        this.zipFile = file;
        this.splitSize = j11;
        this.outputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        writeZipSplitSignature();
    }

    private File createNewSplitSegmentFile(Integer num) throws IOException {
        int i11;
        String str;
        if (num == null) {
            i11 = this.currentSplitSegmentIndex + 2;
        } else {
            i11 = num.intValue();
        }
        String baseName = FileNameUtils.getBaseName(this.zipFile.getName());
        if (i11 <= 9) {
            str = ".z" + "0" + i11;
        } else {
            str = ".z" + i11;
        }
        File file = new File(this.zipFile.getParent(), baseName + str);
        if (!file.exists()) {
            return file;
        }
        throw new IOException("split zip segment " + baseName + str + " already exists");
    }

    private void finish() throws IOException {
        if (!this.finished) {
            String baseName = FileNameUtils.getBaseName(this.zipFile.getName());
            File parentFile = this.zipFile.getParentFile();
            File file = new File(parentFile, baseName + ".zip");
            this.outputStream.close();
            if (this.zipFile.renameTo(file)) {
                this.finished = true;
                return;
            }
            throw new IOException("Failed to rename " + this.zipFile + " to " + file);
        }
        throw new IOException("This archive has already been finished");
    }

    private void openNewSplitSegment() throws IOException {
        if (this.currentSplitSegmentIndex == 0) {
            this.outputStream.close();
            File createNewSplitSegmentFile = createNewSplitSegmentFile(1);
            if (!this.zipFile.renameTo(createNewSplitSegmentFile)) {
                throw new IOException("Failed to rename " + this.zipFile + " to " + createNewSplitSegmentFile);
            }
        }
        File createNewSplitSegmentFile2 = createNewSplitSegmentFile((Integer) null);
        this.outputStream.close();
        this.outputStream = Files.newOutputStream(createNewSplitSegmentFile2.toPath(), new OpenOption[0]);
        this.currentSplitSegmentBytesWritten = 0;
        this.zipFile = createNewSplitSegmentFile2;
        this.currentSplitSegmentIndex++;
    }

    private void writeZipSplitSignature() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        byte[] bArr = ZipArchiveOutputStream.DD_SIG;
        outputStream2.write(bArr);
        this.currentSplitSegmentBytesWritten += (long) bArr.length;
    }

    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
    }

    public long getCurrentSplitSegmentBytesWritten() {
        return this.currentSplitSegmentBytesWritten;
    }

    public int getCurrentSplitSegmentIndex() {
        return this.currentSplitSegmentIndex;
    }

    public void prepareToWriteUnsplittableContent(long j11) throws IllegalArgumentException, IOException {
        long j12 = this.splitSize;
        if (j11 > j12) {
            throw new IllegalArgumentException("The unsplittable content size is bigger than the split segment size");
        } else if (j12 - this.currentSplitSegmentBytesWritten < j11) {
            openNewSplitSegment();
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) (i11 & 255);
        write(bArr);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 > 0) {
            long j11 = this.currentSplitSegmentBytesWritten;
            long j12 = this.splitSize;
            if (j11 >= j12) {
                openNewSplitSegment();
                write(bArr, i11, i12);
                return;
            }
            long j13 = (long) i12;
            if (j11 + j13 > j12) {
                int i13 = ((int) j12) - ((int) j11);
                write(bArr, i11, i13);
                openNewSplitSegment();
                write(bArr, i11 + i13, i12 - i13);
                return;
            }
            this.outputStream.write(bArr, i11, i12);
            this.currentSplitSegmentBytesWritten += j13;
        }
    }
}
