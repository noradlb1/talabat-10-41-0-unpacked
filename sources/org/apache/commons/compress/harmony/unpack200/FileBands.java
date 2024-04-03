package org.apache.commons.compress.harmony.unpack200;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class FileBands extends BandSet {
    private final String[] cpUTF8;
    private byte[][] fileBits;
    private int[] fileModtime;
    private String[] fileName;
    private int[] fileOptions;
    private long[] fileSize;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f27754in;

    public FileBands(Segment segment) {
        super(segment);
        this.cpUTF8 = segment.getCpBands().getCpUTF8();
    }

    public byte[][] getFileBits() {
        return this.fileBits;
    }

    public int[] getFileModtime() {
        return this.fileModtime;
    }

    public String[] getFileName() {
        return this.fileName;
    }

    public int[] getFileOptions() {
        return this.fileOptions;
    }

    public long[] getFileSize() {
        return this.fileSize;
    }

    public void processFileBits() throws IOException, Pack200Exception {
        int numberOfFiles = this.header.getNumberOfFiles();
        this.fileBits = new byte[numberOfFiles][];
        int i11 = 0;
        while (i11 < numberOfFiles) {
            int i12 = (int) this.fileSize[i11];
            byte[] bArr = new byte[i12];
            this.fileBits[i11] = bArr;
            int read = this.f27754in.read(bArr);
            if (i12 == 0 || read >= i12) {
                i11++;
            } else {
                throw new Pack200Exception("Expected to read " + i12 + " bytes but read " + read);
            }
        }
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception {
        int numberOfFiles = this.header.getNumberOfFiles();
        SegmentOptions options = this.header.getOptions();
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        InputStream inputStream2 = inputStream;
        this.fileName = parseReferences("file_name", inputStream2, bHSDCodec, numberOfFiles, this.cpUTF8);
        this.fileSize = parseFlags("file_size", inputStream2, numberOfFiles, bHSDCodec, options.hasFileSizeHi());
        if (options.hasFileModtime()) {
            this.fileModtime = decodeBandInt("file_modtime", inputStream, Codec.DELTA5, numberOfFiles);
        } else {
            this.fileModtime = new int[numberOfFiles];
        }
        if (options.hasFileOptions()) {
            this.fileOptions = decodeBandInt("file_options", inputStream, bHSDCodec, numberOfFiles);
        } else {
            this.fileOptions = new int[numberOfFiles];
        }
        this.f27754in = inputStream;
    }

    public void unpack() {
    }
}
