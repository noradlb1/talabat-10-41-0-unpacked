package org.apache.commons.compress.harmony.unpack200;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.CodecEncoding;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.pack200.PopulationCodec;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;

public abstract class BandSet {
    protected SegmentHeader header;
    protected Segment segment;

    public BandSet(Segment segment2) {
        this.segment = segment2;
        this.header = segment2.getSegmentHeader();
    }

    public int[] decodeBandInt(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        Codec codec;
        int[] iArr;
        if (bHSDCodec.getB() == 1 || i11 == 0) {
            return bHSDCodec.decodeInts(i11, inputStream);
        }
        int[] decodeInts = bHSDCodec.decodeInts(1, inputStream);
        if (decodeInts.length == 0) {
            return decodeInts;
        }
        int i12 = decodeInts[0];
        if (bHSDCodec.isSigned() && i12 >= -256 && i12 <= -1) {
            Codec codec2 = CodecEncoding.getCodec(-1 - i12, this.header.getBandHeadersInputStream(), bHSDCodec);
            iArr = codec2.decodeInts(i11, inputStream);
            codec = codec2;
        } else if (bHSDCodec.isSigned() || i12 < bHSDCodec.getL() || i12 > bHSDCodec.getL() + 255) {
            iArr = bHSDCodec.decodeInts(i11 - 1, inputStream, i12);
            codec = bHSDCodec;
        } else {
            Codec codec3 = CodecEncoding.getCodec(i12 - bHSDCodec.getL(), this.header.getBandHeadersInputStream(), bHSDCodec);
            iArr = codec3.decodeInts(i11, inputStream);
            codec = codec3;
        }
        if (codec instanceof PopulationCodec) {
            PopulationCodec populationCodec = (PopulationCodec) codec;
            int[] iArr2 = (int[]) populationCodec.getFavoured().clone();
            Arrays.sort(iArr2);
            for (int i13 = 0; i13 < iArr.length; i13++) {
                Codec favouredCodec = Arrays.binarySearch(iArr2, iArr[i13]) > -1 ? populationCodec.getFavouredCodec() : populationCodec.getUnfavouredCodec();
                if (favouredCodec instanceof BHSDCodec) {
                    BHSDCodec bHSDCodec2 = (BHSDCodec) favouredCodec;
                    if (bHSDCodec2.isDelta()) {
                        long cardinality = bHSDCodec2.cardinality();
                        while (((long) iArr[i13]) > bHSDCodec2.largest()) {
                            iArr[i13] = (int) (((long) iArr[i13]) - cardinality);
                        }
                        while (((long) iArr[i13]) < bHSDCodec2.smallest()) {
                            iArr[i13] = (int) (((long) iArr[i13]) + cardinality);
                        }
                    }
                }
            }
        }
        return iArr;
    }

    public String[] getReferences(int[] iArr, String[] strArr) {
        int length = iArr.length;
        String[] strArr2 = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr2[i11] = strArr[iArr[i11]];
        }
        return strArr2;
    }

    public CPClass[] parseCPClassReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPClass[] cPClassArr = new CPClass[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPClassArr[i12] = this.segment.getCpBands().cpClassValue(decodeBandInt[i12]);
        }
        return cPClassArr;
    }

    public CPNameAndType[] parseCPDescriptorReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        CpBands cpBands = this.segment.getCpBands();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPNameAndType[] cPNameAndTypeArr = new CPNameAndType[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPNameAndTypeArr[i12] = cpBands.cpNameAndTypeValue(decodeBandInt[i12]);
        }
        return cPNameAndTypeArr;
    }

    public CPDouble[] parseCPDoubleReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPDouble[] cPDoubleArr = new CPDouble[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPDoubleArr[i12] = this.segment.getCpBands().cpDoubleValue(decodeBandInt[i12]);
        }
        return cPDoubleArr;
    }

    public CPFieldRef[] parseCPFieldRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        CpBands cpBands = this.segment.getCpBands();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPFieldRef[] cPFieldRefArr = new CPFieldRef[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPFieldRefArr[i12] = cpBands.cpFieldValue(decodeBandInt[i12]);
        }
        return cPFieldRefArr;
    }

    public CPFloat[] parseCPFloatReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPFloat[] cPFloatArr = new CPFloat[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPFloatArr[i12] = this.segment.getCpBands().cpFloatValue(decodeBandInt[i12]);
        }
        return cPFloatArr;
    }

    public CPInteger[] parseCPIntReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] cpInt = this.segment.getCpBands().getCpInt();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPInteger[] cPIntegerArr = new CPInteger[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = decodeBandInt[i12];
            if (i13 < 0 || i13 >= cpInt.length) {
                throw new Pack200Exception("Something has gone wrong during parsing references, index = " + i13 + ", array size = " + cpInt.length);
            }
            cPIntegerArr[i12] = this.segment.getCpBands().cpIntegerValue(i13);
        }
        return cPIntegerArr;
    }

    public CPInterfaceMethodRef[] parseCPInterfaceMethodRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        CpBands cpBands = this.segment.getCpBands();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPInterfaceMethodRef[] cPInterfaceMethodRefArr = new CPInterfaceMethodRef[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPInterfaceMethodRefArr[i12] = cpBands.cpIMethodValue(decodeBandInt[i12]);
        }
        return cPInterfaceMethodRefArr;
    }

    public CPLong[] parseCPLongReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        long[] cpLong = this.segment.getCpBands().getCpLong();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPLong[] cPLongArr = new CPLong[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = decodeBandInt[i12];
            if (i13 < 0 || i13 >= cpLong.length) {
                throw new Pack200Exception("Something has gone wrong during parsing references, index = " + i13 + ", array size = " + cpLong.length);
            }
            cPLongArr[i12] = this.segment.getCpBands().cpLongValue(i13);
        }
        return cPLongArr;
    }

    public CPMethodRef[] parseCPMethodRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        CpBands cpBands = this.segment.getCpBands();
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPMethodRef[] cPMethodRefArr = new CPMethodRef[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPMethodRefArr[i12] = cpBands.cpMethodValue(decodeBandInt[i12]);
        }
        return cPMethodRefArr;
    }

    public CPUTF8[] parseCPSignatureReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPUTF8[] cputf8Arr = new CPUTF8[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cputf8Arr[i12] = this.segment.getCpBands().cpSignatureValue(decodeBandInt[i12]);
        }
        return cputf8Arr;
    }

    public CPString[] parseCPStringReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPString[] cPStringArr = new CPString[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cPStringArr[i12] = this.segment.getCpBands().cpStringValue(decodeBandInt[i12]);
        }
        return cPStringArr;
    }

    public CPUTF8[] parseCPUTF8References(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11) throws IOException, Pack200Exception {
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        CPUTF8[] cputf8Arr = new CPUTF8[decodeBandInt.length];
        for (int i12 = 0; i12 < i11; i12++) {
            cputf8Arr[i12] = this.segment.getCpBands().cpUTF8Value(decodeBandInt[i12]);
        }
        return cputf8Arr;
    }

    public long[] parseFlags(String str, InputStream inputStream, int i11, BHSDCodec bHSDCodec, boolean z11) throws IOException, Pack200Exception {
        return parseFlags(str, inputStream, new int[]{i11}, z11 ? bHSDCodec : null, bHSDCodec)[0];
    }

    public String[] parseReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i11, String[] strArr) throws IOException, Pack200Exception {
        return parseReferences(str, inputStream, bHSDCodec, new int[]{i11}, strArr)[0];
    }

    public abstract void read(InputStream inputStream) throws IOException, Pack200Exception;

    public abstract void unpack() throws IOException, Pack200Exception;

    public void unpack(InputStream inputStream) throws IOException, Pack200Exception {
        read(inputStream);
        unpack();
    }

    public long[][] parseFlags(String str, InputStream inputStream, int[] iArr, BHSDCodec bHSDCodec, boolean z11) throws IOException, Pack200Exception {
        return parseFlags(str, inputStream, iArr, z11 ? bHSDCodec : null, bHSDCodec);
    }

    public String[][] parseReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr, String[] strArr) throws IOException, Pack200Exception {
        int length = iArr.length;
        if (length == 0) {
            return new String[][]{new String[0]};
        }
        String[][] strArr2 = new String[length][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr[i12];
            strArr2[i12] = new String[i13];
            i11 += i13;
        }
        String[] strArr3 = new String[i11];
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = decodeBandInt[i14];
            if (i15 < 0 || i15 >= strArr.length) {
                throw new Pack200Exception("Something has gone wrong during parsing references, index = " + i15 + ", array size = " + strArr.length);
            }
            strArr3[i14] = strArr[i15];
        }
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            int i18 = iArr[i17];
            String[] strArr4 = new String[i18];
            strArr2[i17] = strArr4;
            System.arraycopy(strArr3, i16, strArr4, 0, i18);
            i16 += i18;
        }
        return strArr2;
    }

    public String[][] getReferences(int[][] iArr, String[] strArr) {
        int length = iArr.length;
        String[][] strArr2 = new String[length][];
        for (int i11 = 0; i11 < length; i11++) {
            strArr2[i11] = new String[iArr[i11].length];
            int i12 = 0;
            while (true) {
                String[] strArr3 = strArr2[i11];
                if (i12 >= strArr3.length) {
                    break;
                }
                strArr3[i12] = strArr[iArr[i11][i12]];
                i12++;
            }
        }
        return strArr2;
    }

    public long[] parseFlags(String str, InputStream inputStream, int i11, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2) throws IOException, Pack200Exception {
        return parseFlags(str, inputStream, new int[]{i11}, bHSDCodec, bHSDCodec2)[0];
    }

    public long[][] parseFlags(String str, InputStream inputStream, int[] iArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2) throws IOException, Pack200Exception {
        int[] iArr2;
        int[] iArr3;
        int length = iArr.length;
        if (length == 0) {
            return new long[][]{new long[0]};
        }
        long[][] jArr = new long[length][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr[i12];
            jArr[i12] = new long[i13];
            i11 += i13;
        }
        if (bHSDCodec != null) {
            iArr2 = decodeBandInt(str, inputStream, bHSDCodec, i11);
            iArr3 = decodeBandInt(str, inputStream, bHSDCodec2, i11);
        } else {
            iArr3 = decodeBandInt(str, inputStream, bHSDCodec2, i11);
            iArr2 = null;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = jArr[i15];
                if (i16 >= jArr2.length) {
                    break;
                }
                if (iArr2 != null) {
                    jArr2[i16] = (((long) iArr2[i14]) << 32) | (((long) iArr3[i14]) & 4294967295L);
                } else {
                    jArr2[i16] = (long) iArr3[i14];
                }
                i14++;
                i16++;
            }
        }
        return jArr;
    }

    public CPUTF8[][] parseCPSignatureReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) throws IOException, Pack200Exception {
        CPUTF8[][] cputf8Arr = new CPUTF8[iArr.length][];
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            cputf8Arr[i12] = new CPUTF8[i13];
            i11 += i13;
        }
        CPUTF8[] cputf8Arr2 = new CPUTF8[i11];
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        for (int i14 = 0; i14 < i11; i14++) {
            cputf8Arr2[i14] = this.segment.getCpBands().cpSignatureValue(decodeBandInt[i14]);
        }
        int i15 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            CPUTF8[] cputf8Arr3 = new CPUTF8[i17];
            cputf8Arr[i16] = cputf8Arr3;
            System.arraycopy(cputf8Arr2, i15, cputf8Arr3, 0, i17);
            i15 += i17;
        }
        return cputf8Arr;
    }

    public CPUTF8[][] parseCPUTF8References(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) throws IOException, Pack200Exception {
        CPUTF8[][] cputf8Arr = new CPUTF8[iArr.length][];
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            cputf8Arr[i12] = new CPUTF8[i13];
            i11 += i13;
        }
        CPUTF8[] cputf8Arr2 = new CPUTF8[i11];
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        for (int i14 = 0; i14 < i11; i14++) {
            cputf8Arr2[i14] = this.segment.getCpBands().cpUTF8Value(decodeBandInt[i14]);
        }
        int i15 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            CPUTF8[] cputf8Arr3 = new CPUTF8[i17];
            cputf8Arr[i16] = cputf8Arr3;
            System.arraycopy(cputf8Arr2, i15, cputf8Arr3, 0, i17);
            i15 += i17;
        }
        return cputf8Arr;
    }

    public int[][] decodeBandInt(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) throws IOException, Pack200Exception {
        int length = iArr.length;
        int[][] iArr2 = new int[length][];
        int i11 = 0;
        for (int i12 : iArr) {
            i11 += i12;
        }
        int[] decodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i11);
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            iArr2[i14] = new int[iArr[i14]];
            int i15 = 0;
            while (true) {
                int[] iArr3 = iArr2[i14];
                if (i15 >= iArr3.length) {
                    break;
                }
                iArr3[i15] = decodeBandInt[i13];
                i13++;
                i15++;
            }
        }
        return iArr2;
    }
}
