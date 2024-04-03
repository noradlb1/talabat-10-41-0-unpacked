package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;

public class SegmentHeader extends BandSet {
    private static final int archive_majver = 150;
    private static final int archive_minver = 7;
    private static final int[] magic = {202, 254, 208, 13};
    private int archive_modtime;
    private int archive_next_count;
    private int archive_options;
    private int archive_size_hi;
    private int archive_size_lo;
    private int attribute_definition_count;
    private final IntList band_headers = new IntList();
    private int class_count;
    private int cp_Class_count;
    private int cp_Descr_count;
    private int cp_Double_count;
    private int cp_Field_count;
    private int cp_Float_count;
    private int cp_Imethod_count;
    private int cp_Int_count;
    private int cp_Long_count;
    private int cp_Method_count;
    private int cp_Signature_count;
    private int cp_String_count;
    private int cp_Utf8_count;
    private boolean deflate_hint;
    private int file_count;
    private boolean have_all_code_flags = true;
    private boolean have_class_flags_hi;
    private boolean have_code_flags_hi;
    private boolean have_field_flags_hi;
    private final boolean have_file_modtime = true;
    private final boolean have_file_options = true;
    private boolean have_file_size_hi;
    private boolean have_method_flags_hi;
    private int ic_count;
    private final Counter majverCounter = new Counter();

    public class Counter {
        private final int[] counts;
        private int length;
        private final int[] objs;

        private Counter() {
            this.objs = new int[8];
            this.counts = new int[8];
        }

        public void add(int i11) {
            int i12;
            int i13 = 0;
            boolean z11 = false;
            while (true) {
                i12 = this.length;
                if (i13 >= i12) {
                    break;
                }
                if (this.objs[i13] == i11) {
                    int[] iArr = this.counts;
                    iArr[i13] = iArr[i13] + 1;
                    z11 = true;
                }
                i13++;
            }
            if (!z11) {
                int[] iArr2 = this.objs;
                iArr2[i12] = i11;
                this.counts[i12] = 1;
                int i14 = i12 + 1;
                this.length = i14;
                if (i14 > iArr2.length - 1) {
                    System.arraycopy(iArr2, 0, new Object[(iArr2.length + 8)], 0, i14);
                }
            }
        }

        public int getMostCommon() {
            int i11 = 0;
            for (int i12 = 0; i12 < this.length; i12++) {
                int[] iArr = this.counts;
                if (iArr[i12] > iArr[i11]) {
                    i11 = i12;
                }
            }
            return this.objs[i11];
        }
    }

    public SegmentHeader() {
        super(1, (SegmentHeader) null);
    }

    private void calculateArchiveOptions() {
        if (this.attribute_definition_count > 0 || this.band_headers.size() > 0) {
            this.archive_options |= 1;
        }
        if (this.cp_Int_count > 0 || this.cp_Float_count > 0 || this.cp_Long_count > 0 || this.cp_Double_count > 0) {
            this.archive_options |= 2;
        }
        if (this.have_all_code_flags) {
            this.archive_options |= 4;
        }
        if (this.file_count > 0) {
            this.archive_options |= 16;
        }
        if (this.deflate_hint) {
            this.archive_options |= 32;
        }
        int i11 = this.archive_options | 64 | 128;
        this.archive_options = i11;
        if (this.have_file_size_hi) {
            this.archive_options = i11 | 256;
        }
        if (this.have_class_flags_hi) {
            this.archive_options |= 512;
        }
        if (this.have_field_flags_hi) {
            this.archive_options |= 1024;
        }
        if (this.have_method_flags_hi) {
            this.archive_options |= 2048;
        }
        if (this.have_code_flags_hi) {
            this.archive_options |= 4096;
        }
    }

    private void writeArchiveFileCounts(OutputStream outputStream) throws IOException, Pack200Exception {
        if ((this.archive_options & 16) > 0) {
            int i11 = this.archive_size_hi;
            BHSDCodec bHSDCodec = Codec.UNSIGNED5;
            outputStream.write(encodeScalar(i11, bHSDCodec));
            outputStream.write(encodeScalar(this.archive_size_lo, bHSDCodec));
            outputStream.write(encodeScalar(this.archive_next_count, bHSDCodec));
            outputStream.write(encodeScalar(this.archive_modtime, bHSDCodec));
            outputStream.write(encodeScalar(this.file_count, bHSDCodec));
        }
    }

    private void writeArchiveSpecialCounts(OutputStream outputStream) throws IOException, Pack200Exception {
        if ((this.archive_options & 1) > 0) {
            int size = this.band_headers.size();
            BHSDCodec bHSDCodec = Codec.UNSIGNED5;
            outputStream.write(encodeScalar(size, bHSDCodec));
            outputStream.write(encodeScalar(this.attribute_definition_count, bHSDCodec));
        }
    }

    private void writeClassCounts(OutputStream outputStream) throws IOException, Pack200Exception {
        int mostCommon = this.majverCounter.getMostCommon();
        int i11 = this.ic_count;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        outputStream.write(encodeScalar(i11, bHSDCodec));
        outputStream.write(encodeScalar(0, bHSDCodec));
        outputStream.write(encodeScalar(mostCommon, bHSDCodec));
        outputStream.write(encodeScalar(this.class_count, bHSDCodec));
    }

    private void writeCpCounts(OutputStream outputStream) throws IOException, Pack200Exception {
        int i11 = this.cp_Utf8_count;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        outputStream.write(encodeScalar(i11, bHSDCodec));
        if ((this.archive_options & 2) != 0) {
            outputStream.write(encodeScalar(this.cp_Int_count, bHSDCodec));
            outputStream.write(encodeScalar(this.cp_Float_count, bHSDCodec));
            outputStream.write(encodeScalar(this.cp_Long_count, bHSDCodec));
            outputStream.write(encodeScalar(this.cp_Double_count, bHSDCodec));
        }
        outputStream.write(encodeScalar(this.cp_String_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Class_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Signature_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Descr_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Field_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Method_count, bHSDCodec));
        outputStream.write(encodeScalar(this.cp_Imethod_count, bHSDCodec));
    }

    public void addMajorVersion(int i11) {
        this.majverCounter.add(i11);
    }

    public void appendBandCodingSpecifier(int i11) {
        this.band_headers.add(i11);
    }

    public int getArchive_modtime() {
        return this.archive_modtime;
    }

    public int getDefaultMajorVersion() {
        return this.majverCounter.getMostCommon();
    }

    public boolean have_all_code_flags() {
        return this.have_all_code_flags;
    }

    public boolean have_class_flags_hi() {
        return this.have_class_flags_hi;
    }

    public boolean have_code_flags_hi() {
        return this.have_code_flags_hi;
    }

    public boolean have_field_flags_hi() {
        return this.have_field_flags_hi;
    }

    public boolean have_file_modtime() {
        return true;
    }

    public boolean have_file_options() {
        return true;
    }

    public boolean have_file_size_hi() {
        return this.have_file_size_hi;
    }

    public boolean have_method_flags_hi() {
        return this.have_method_flags_hi;
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        int[] iArr = magic;
        BHSDCodec bHSDCodec = Codec.BYTE1;
        outputStream.write(encodeScalar(iArr, bHSDCodec));
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        outputStream.write(encodeScalar(7, bHSDCodec2));
        outputStream.write(encodeScalar(150, bHSDCodec2));
        calculateArchiveOptions();
        outputStream.write(encodeScalar(this.archive_options, bHSDCodec2));
        writeArchiveFileCounts(outputStream);
        writeArchiveSpecialCounts(outputStream);
        writeCpCounts(outputStream);
        writeClassCounts(outputStream);
        if (this.band_headers.size() > 0) {
            outputStream.write(encodeScalar(this.band_headers.toArray(), bHSDCodec));
        }
    }

    public void setAttribute_definition_count(int i11) {
        this.attribute_definition_count = i11;
    }

    public void setClass_count(int i11) {
        this.class_count = i11;
    }

    public void setCp_Class_count(int i11) {
        this.cp_Class_count = i11;
    }

    public void setCp_Descr_count(int i11) {
        this.cp_Descr_count = i11;
    }

    public void setCp_Double_count(int i11) {
        this.cp_Double_count = i11;
    }

    public void setCp_Field_count(int i11) {
        this.cp_Field_count = i11;
    }

    public void setCp_Float_count(int i11) {
        this.cp_Float_count = i11;
    }

    public void setCp_Imethod_count(int i11) {
        this.cp_Imethod_count = i11;
    }

    public void setCp_Int_count(int i11) {
        this.cp_Int_count = i11;
    }

    public void setCp_Long_count(int i11) {
        this.cp_Long_count = i11;
    }

    public void setCp_Method_count(int i11) {
        this.cp_Method_count = i11;
    }

    public void setCp_Signature_count(int i11) {
        this.cp_Signature_count = i11;
    }

    public void setCp_String_count(int i11) {
        this.cp_String_count = i11;
    }

    public void setCp_Utf8_count(int i11) {
        this.cp_Utf8_count = i11;
    }

    public void setDeflate_hint(boolean z11) {
        this.deflate_hint = z11;
    }

    public void setFile_count(int i11) {
        this.file_count = i11;
    }

    public void setHave_all_code_flags(boolean z11) {
        this.have_all_code_flags = z11;
    }

    public void setHave_class_flags_hi(boolean z11) {
        this.have_class_flags_hi = z11;
    }

    public void setHave_code_flags_hi(boolean z11) {
        this.have_code_flags_hi = z11;
    }

    public void setHave_field_flags_hi(boolean z11) {
        this.have_field_flags_hi = z11;
    }

    public void setHave_method_flags_hi(boolean z11) {
        this.have_method_flags_hi = z11;
    }

    public void setIc_count(int i11) {
        this.ic_count = i11;
    }
}
