package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.compress.harmony.pack200.Archive;
import org.objectweb.asm.ClassReader;

public class FileBands extends BandSet {
    private final CpBands cpBands;
    private final List fileList;
    private final CPUTF8[] fileName;
    private final byte[][] file_bits;
    private final int[] file_modtime;
    private int[] file_name;
    private final int[] file_options;
    private final long[] file_size;
    private final PackingOptions options;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileBands(CpBands cpBands2, SegmentHeader segmentHeader, PackingOptions packingOptions, Archive.SegmentUnit segmentUnit, int i11) {
        super(i11, segmentHeader);
        CpBands cpBands3 = cpBands2;
        PackingOptions packingOptions2 = packingOptions;
        List fileList2 = segmentUnit.getFileList();
        this.fileList = fileList2;
        this.options = packingOptions2;
        this.cpBands = cpBands3;
        int size = fileList2.size();
        this.fileName = new CPUTF8[size];
        this.file_modtime = new int[size];
        this.file_size = new long[size];
        this.file_options = new int[size];
        this.file_bits = new byte[size][];
        int archive_modtime = segmentHeader.getArchive_modtime();
        HashSet hashSet = new HashSet();
        for (ClassReader className : segmentUnit.getClassList()) {
            hashSet.add(className.getClassName());
        }
        CPUTF8 cPUtf8 = cpBands3.getCPUtf8("");
        boolean z11 = !"keep".equals(packingOptions.getModificationTime());
        int i12 = 0;
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        while (i14 < size) {
            Archive.PackingFile packingFile = (Archive.PackingFile) this.fileList.get(i14);
            String name2 = packingFile.getName();
            if (!name2.endsWith(".class") || packingOptions2.isPassFile(name2)) {
                this.fileName[i14] = cpBands3.getCPUtf8(name2);
            } else {
                int[] iArr = this.file_options;
                iArr[i14] = iArr[i14] | 2;
                if (hashSet.contains(name2.substring(i12, name2.length() - 6))) {
                    this.fileName[i14] = cPUtf8;
                } else {
                    this.fileName[i14] = cpBands3.getCPUtf8(name2);
                }
            }
            if (packingOptions.isKeepDeflateHint() && packingFile.isDefalteHint()) {
                int[] iArr2 = this.file_options;
                iArr2[i14] = iArr2[i14] | 1;
            }
            this.file_size[i14] = (long) packingFile.getContents().length;
            int modtime = (int) (((packingFile.getModtime() + ((long) TimeZone.getDefault().getRawOffset())) / 1000) - ((long) archive_modtime));
            this.file_modtime[i14] = modtime;
            i13 = i13;
            if (z11 && i13 < modtime) {
                i13 = modtime;
            }
            this.file_bits[i14] = packingFile.getContents();
            i14++;
            i12 = 0;
        }
        if (z11) {
            for (int i15 = 0; i15 < size; i15++) {
                this.file_modtime[i15] = i13;
            }
        }
    }

    private int[] flatten(byte[][] bArr) {
        int i11 = 0;
        for (byte[] length : bArr) {
            i11 += length.length;
        }
        int[] iArr = new int[i11];
        int i12 = 0;
        for (byte[] bArr2 : bArr) {
            int i13 = 0;
            while (true) {
                if (i13 >= bArr2.length) {
                    break;
                }
                iArr[i12] = bArr2[i13] & 255;
                i13++;
                i12++;
            }
        }
        return iArr;
    }

    public void finaliseBands() {
        this.file_name = new int[this.fileName.length];
        for (int i11 = 0; i11 < this.file_name.length; i11++) {
            if (this.fileName[i11].equals(this.cpBands.getCPUtf8(""))) {
                String name2 = ((Archive.PackingFile) this.fileList.get(i11)).getName();
                if (this.options.isPassFile(name2)) {
                    this.fileName[i11] = this.cpBands.getCPUtf8(name2);
                    int[] iArr = this.file_options;
                    iArr[i11] = iArr[i11] & -3;
                }
            }
            this.file_name[i11] = this.fileName[i11].getIndex();
        }
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        PackingUtils.log("Writing file bands...");
        int[] iArr = this.file_name;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeBandInt = encodeBandInt("file_name", iArr, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from file_name[" + this.file_name.length + "]");
        byte[] encodeFlags = encodeFlags("file_size", this.file_size, bHSDCodec, bHSDCodec, this.segmentHeader.have_file_size_hi());
        outputStream.write(encodeFlags);
        PackingUtils.log("Wrote " + encodeFlags.length + " bytes from file_size[" + this.file_size.length + "]");
        if (this.segmentHeader.have_file_modtime()) {
            byte[] encodeBandInt2 = encodeBandInt("file_modtime", this.file_modtime, Codec.DELTA5);
            outputStream.write(encodeBandInt2);
            PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from file_modtime[" + this.file_modtime.length + "]");
        }
        if (this.segmentHeader.have_file_options()) {
            byte[] encodeBandInt3 = encodeBandInt("file_options", this.file_options, bHSDCodec);
            outputStream.write(encodeBandInt3);
            PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from file_options[" + this.file_options.length + "]");
        }
        byte[] encodeBandInt4 = encodeBandInt("file_bits", flatten(this.file_bits), Codec.BYTE1);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from file_bits[" + this.file_bits.length + "]");
    }
}
