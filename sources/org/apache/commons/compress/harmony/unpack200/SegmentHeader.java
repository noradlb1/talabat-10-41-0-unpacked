package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class SegmentHeader {
    private static final int[] magic = {202, 254, 208, 13};
    private int archiveMajor;
    private int archiveMinor;
    private long archiveModtime;
    private long archiveSize;
    private int archiveSizeOffset;
    private int attributeDefinitionCount;
    private InputStream bandHeadersInputStream;
    private int bandHeadersSize;
    private int classCount;
    private int cpClassCount;
    private int cpDescriptorCount;
    private int cpDoubleCount;
    private int cpFieldCount;
    private int cpFloatCount;
    private int cpIMethodCount;
    private int cpIntCount;
    private int cpLongCount;
    private int cpMethodCount;
    private int cpSignatureCount;
    private int cpStringCount;
    private int cpUTF8Count;
    private int defaultClassMajorVersion;
    private int defaultClassMinorVersion;
    private int innerClassCount;
    private int numberOfFiles;
    private SegmentOptions options;
    private final Segment segment;
    private int segmentsRemaining;

    public SegmentHeader(Segment segment2) {
        this.segment = segment2;
    }

    private int[] decodeScalar(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        Segment segment2 = this.segment;
        segment2.log(2, "Parsed #" + str + " (" + i11 + ")");
        return bHSDCodec.decodeInts(i11, inputStream);
    }

    private void parseArchiveFileCounts(InputStream inputStream) throws IOException, Pack200Exception {
        if (this.options.hasArchiveFileCounts()) {
            BHSDCodec bHSDCodec = Codec.UNSIGNED5;
            setArchiveSize((((long) decodeScalar("archive_size_hi", inputStream, bHSDCodec)) << 32) | ((long) decodeScalar("archive_size_lo", inputStream, bHSDCodec)));
            this.archiveSizeOffset = inputStream.available();
            setSegmentsRemaining((long) decodeScalar("archive_next_count", inputStream, bHSDCodec));
            setArchiveModtime((long) decodeScalar("archive_modtime", inputStream, bHSDCodec));
            this.numberOfFiles = decodeScalar("file_count", inputStream, bHSDCodec);
        }
    }

    private void parseArchiveSpecialCounts(InputStream inputStream) throws IOException, Pack200Exception {
        if (getOptions().hasSpecialFormats()) {
            BHSDCodec bHSDCodec = Codec.UNSIGNED5;
            this.bandHeadersSize = decodeScalar("band_headers_size", inputStream, bHSDCodec);
            setAttributeDefinitionCount((long) decodeScalar("attr_definition_count", inputStream, bHSDCodec));
        }
    }

    private void parseClassCounts(InputStream inputStream) throws IOException, Pack200Exception {
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        this.innerClassCount = decodeScalar("ic_count", inputStream, bHSDCodec);
        this.defaultClassMinorVersion = decodeScalar("default_class_minver", inputStream, bHSDCodec);
        this.defaultClassMajorVersion = decodeScalar("default_class_majver", inputStream, bHSDCodec);
        this.classCount = decodeScalar("class_count", inputStream, bHSDCodec);
    }

    private void parseCpCounts(InputStream inputStream) throws IOException, Pack200Exception {
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        this.cpUTF8Count = decodeScalar("cp_Utf8_count", inputStream, bHSDCodec);
        if (getOptions().hasCPNumberCounts()) {
            this.cpIntCount = decodeScalar("cp_Int_count", inputStream, bHSDCodec);
            this.cpFloatCount = decodeScalar("cp_Float_count", inputStream, bHSDCodec);
            this.cpLongCount = decodeScalar("cp_Long_count", inputStream, bHSDCodec);
            this.cpDoubleCount = decodeScalar("cp_Double_count", inputStream, bHSDCodec);
        }
        this.cpStringCount = decodeScalar("cp_String_count", inputStream, bHSDCodec);
        this.cpClassCount = decodeScalar("cp_Class_count", inputStream, bHSDCodec);
        this.cpSignatureCount = decodeScalar("cp_Signature_count", inputStream, bHSDCodec);
        this.cpDescriptorCount = decodeScalar("cp_Descr_count", inputStream, bHSDCodec);
        this.cpFieldCount = decodeScalar("cp_Field_count", inputStream, bHSDCodec);
        this.cpMethodCount = decodeScalar("cp_Method_count", inputStream, bHSDCodec);
        this.cpIMethodCount = decodeScalar("cp_Imethod_count", inputStream, bHSDCodec);
    }

    private void readFully(InputStream inputStream, byte[] bArr) throws IOException, Pack200Exception {
        int read = inputStream.read(bArr);
        if (read != -1) {
            while (read < bArr.length) {
                int read2 = inputStream.read(bArr, read, bArr.length - read);
                if (read2 != -1) {
                    read += read2;
                } else {
                    throw new EOFException("Failed to read some data from input stream");
                }
            }
            return;
        }
        throw new EOFException("Failed to read any data from input stream");
    }

    private void setArchiveMajorVersion(int i11) throws Pack200Exception {
        if (i11 == 150) {
            this.archiveMajor = i11;
            return;
        }
        throw new Pack200Exception("Invalid segment major version: " + i11);
    }

    private void setArchiveMinorVersion(int i11) throws Pack200Exception {
        if (i11 == 7) {
            this.archiveMinor = i11;
            return;
        }
        throw new Pack200Exception("Invalid segment minor version");
    }

    private void setAttributeDefinitionCount(long j11) {
        this.attributeDefinitionCount = (int) j11;
    }

    private void setBandHeadersData(byte[] bArr) {
        this.bandHeadersInputStream = new ByteArrayInputStream(bArr);
    }

    public long getArchiveModtime() {
        return this.archiveModtime;
    }

    public long getArchiveSize() {
        return this.archiveSize;
    }

    public int getArchiveSizeOffset() {
        return this.archiveSizeOffset;
    }

    public int getAttributeDefinitionCount() {
        return this.attributeDefinitionCount;
    }

    public InputStream getBandHeadersInputStream() {
        if (this.bandHeadersInputStream == null) {
            this.bandHeadersInputStream = new ByteArrayInputStream(new byte[0]);
        }
        return this.bandHeadersInputStream;
    }

    public int getBandHeadersSize() {
        return this.bandHeadersSize;
    }

    public int getClassCount() {
        return this.classCount;
    }

    public int getCpClassCount() {
        return this.cpClassCount;
    }

    public int getCpDescriptorCount() {
        return this.cpDescriptorCount;
    }

    public int getCpDoubleCount() {
        return this.cpDoubleCount;
    }

    public int getCpFieldCount() {
        return this.cpFieldCount;
    }

    public int getCpFloatCount() {
        return this.cpFloatCount;
    }

    public int getCpIMethodCount() {
        return this.cpIMethodCount;
    }

    public int getCpIntCount() {
        return this.cpIntCount;
    }

    public int getCpLongCount() {
        return this.cpLongCount;
    }

    public int getCpMethodCount() {
        return this.cpMethodCount;
    }

    public int getCpSignatureCount() {
        return this.cpSignatureCount;
    }

    public int getCpStringCount() {
        return this.cpStringCount;
    }

    public int getCpUTF8Count() {
        return this.cpUTF8Count;
    }

    public int getDefaultClassMajorVersion() {
        return this.defaultClassMajorVersion;
    }

    public int getDefaultClassMinorVersion() {
        return this.defaultClassMinorVersion;
    }

    public int getInnerClassCount() {
        return this.innerClassCount;
    }

    public int getNumberOfFiles() {
        return this.numberOfFiles;
    }

    public SegmentOptions getOptions() {
        return this.options;
    }

    public int getSegmentsRemaining() {
        return this.segmentsRemaining;
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception, Error, Pack200Exception {
        int[] decodeScalar = decodeScalar("archive_magic_word", inputStream, Codec.BYTE1, magic.length);
        int i11 = 0;
        while (true) {
            int[] iArr = magic;
            if (i11 >= iArr.length) {
                BHSDCodec bHSDCodec = Codec.UNSIGNED5;
                setArchiveMinorVersion(decodeScalar("archive_minver", inputStream, bHSDCodec));
                setArchiveMajorVersion(decodeScalar("archive_majver", inputStream, bHSDCodec));
                this.options = new SegmentOptions(decodeScalar("archive_options", inputStream, bHSDCodec));
                parseArchiveFileCounts(inputStream);
                parseArchiveSpecialCounts(inputStream);
                parseCpCounts(inputStream);
                parseClassCounts(inputStream);
                if (getBandHeadersSize() > 0) {
                    byte[] bArr = new byte[getBandHeadersSize()];
                    readFully(inputStream, bArr);
                    setBandHeadersData(bArr);
                }
                this.archiveSizeOffset -= inputStream.available();
                return;
            } else if (decodeScalar[i11] == iArr[i11]) {
                i11++;
            } else {
                throw new Error("Bad header");
            }
        }
    }

    public void setArchiveModtime(long j11) {
        this.archiveModtime = j11;
    }

    public void setArchiveSize(long j11) {
        this.archiveSize = j11;
    }

    public void setSegmentsRemaining(long j11) {
        this.segmentsRemaining = (int) j11;
    }

    public void unpack() {
    }

    private int decodeScalar(String str, InputStream inputStream, BHSDCodec bHSDCodec) throws IOException, Pack200Exception {
        int decode = bHSDCodec.decode(inputStream);
        Segment segment2 = this.segment;
        segment2.log(2, "Parsed #" + str + " as " + decode);
        return decode;
    }
}
