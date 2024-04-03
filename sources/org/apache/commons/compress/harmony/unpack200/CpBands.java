package org.apache.commons.compress.harmony.unpack200;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
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

public class CpBands extends BandSet {
    private int classOffset;
    private String[] cpClass;
    private int[] cpClassInts;
    private String[] cpDescriptor;
    private int[] cpDescriptorNameInts;
    private int[] cpDescriptorTypeInts;
    private double[] cpDouble;
    private String[] cpFieldClass;
    private int[] cpFieldClassInts;
    private String[] cpFieldDescriptor;
    private int[] cpFieldDescriptorInts;
    private float[] cpFloat;
    private String[] cpIMethodClass;
    private int[] cpIMethodClassInts;
    private String[] cpIMethodDescriptor;
    private int[] cpIMethodDescriptorInts;
    private int[] cpInt;
    private long[] cpLong;
    private String[] cpMethodClass;
    private int[] cpMethodClassInts;
    private String[] cpMethodDescriptor;
    private int[] cpMethodDescriptorInts;
    private String[] cpSignature;
    private int[] cpSignatureInts;
    private String[] cpString;
    private int[] cpStringInts;
    private String[] cpUTF8;
    private int descrOffset;
    private final Map descriptorsToCPNameAndTypes = new HashMap();
    private int doubleOffset;
    private final Map doublesToCPDoubles = new HashMap();
    private int fieldOffset;
    private int floatOffset;
    private final Map floatsToCPFloats = new HashMap();
    private int imethodOffset;
    private int intOffset;
    private final Map integersToCPIntegers = new HashMap();
    private int longOffset;
    private final Map longsToCPLongs = new HashMap();
    private Map mapClass;
    private Map mapDescriptor;
    private Map mapSignature;
    private Map mapUTF8;
    private int methodOffset;
    private final SegmentConstantPool pool = new SegmentConstantPool(this);
    private int signatureOffset;
    private int stringOffset;
    private final Map stringsToCPClass = new HashMap();
    private final Map stringsToCPStrings = new HashMap();
    private final Map stringsToCPUTF8 = new HashMap();

    public CpBands(Segment segment) {
        super(segment);
    }

    private void parseCpClass(InputStream inputStream) throws IOException, Pack200Exception {
        int cpClassCount = this.header.getCpClassCount();
        this.cpClassInts = decodeBandInt("cp_Class", inputStream, Codec.UDELTA5, cpClassCount);
        this.cpClass = new String[cpClassCount];
        this.mapClass = new HashMap(cpClassCount);
        for (int i11 = 0; i11 < cpClassCount; i11++) {
            String[] strArr = this.cpClass;
            String str = this.cpUTF8[this.cpClassInts[i11]];
            strArr[i11] = str;
            this.mapClass.put(str, Integer.valueOf(i11));
        }
    }

    private void parseCpDescriptor(InputStream inputStream) throws IOException, Pack200Exception {
        int cpDescriptorCount = this.header.getCpDescriptorCount();
        this.cpDescriptorNameInts = decodeBandInt("cp_Descr_name", inputStream, Codec.DELTA5, cpDescriptorCount);
        this.cpDescriptorTypeInts = decodeBandInt("cp_Descr_type", inputStream, Codec.UDELTA5, cpDescriptorCount);
        String[] references = getReferences(this.cpDescriptorNameInts, this.cpUTF8);
        String[] references2 = getReferences(this.cpDescriptorTypeInts, this.cpSignature);
        this.cpDescriptor = new String[cpDescriptorCount];
        this.mapDescriptor = new HashMap(cpDescriptorCount);
        for (int i11 = 0; i11 < cpDescriptorCount; i11++) {
            String[] strArr = this.cpDescriptor;
            strArr[i11] = references[i11] + CertificateUtil.DELIMITER + references2[i11];
            this.mapDescriptor.put(this.cpDescriptor[i11], Integer.valueOf(i11));
        }
    }

    private void parseCpDouble(InputStream inputStream) throws IOException, Pack200Exception {
        long[] parseFlags = parseFlags("cp_Double", inputStream, this.header.getCpDoubleCount(), Codec.UDELTA5, Codec.DELTA5);
        this.cpDouble = new double[parseFlags.length];
        for (int i11 = 0; i11 < parseFlags.length; i11++) {
            this.cpDouble[i11] = Double.longBitsToDouble(parseFlags[i11]);
        }
    }

    private void parseCpField(InputStream inputStream) throws IOException, Pack200Exception {
        int cpFieldCount = this.header.getCpFieldCount();
        this.cpFieldClassInts = decodeBandInt("cp_Field_class", inputStream, Codec.DELTA5, cpFieldCount);
        this.cpFieldDescriptorInts = decodeBandInt("cp_Field_desc", inputStream, Codec.UDELTA5, cpFieldCount);
        this.cpFieldClass = new String[cpFieldCount];
        this.cpFieldDescriptor = new String[cpFieldCount];
        for (int i11 = 0; i11 < cpFieldCount; i11++) {
            this.cpFieldClass[i11] = this.cpClass[this.cpFieldClassInts[i11]];
            this.cpFieldDescriptor[i11] = this.cpDescriptor[this.cpFieldDescriptorInts[i11]];
        }
    }

    private void parseCpFloat(InputStream inputStream) throws IOException, Pack200Exception {
        int cpFloatCount = this.header.getCpFloatCount();
        this.cpFloat = new float[cpFloatCount];
        int[] decodeBandInt = decodeBandInt("cp_Float", inputStream, Codec.UDELTA5, cpFloatCount);
        for (int i11 = 0; i11 < cpFloatCount; i11++) {
            this.cpFloat[i11] = Float.intBitsToFloat(decodeBandInt[i11]);
        }
    }

    private void parseCpIMethod(InputStream inputStream) throws IOException, Pack200Exception {
        int cpIMethodCount = this.header.getCpIMethodCount();
        this.cpIMethodClassInts = decodeBandInt("cp_Imethod_class", inputStream, Codec.DELTA5, cpIMethodCount);
        this.cpIMethodDescriptorInts = decodeBandInt("cp_Imethod_desc", inputStream, Codec.UDELTA5, cpIMethodCount);
        this.cpIMethodClass = new String[cpIMethodCount];
        this.cpIMethodDescriptor = new String[cpIMethodCount];
        for (int i11 = 0; i11 < cpIMethodCount; i11++) {
            this.cpIMethodClass[i11] = this.cpClass[this.cpIMethodClassInts[i11]];
            this.cpIMethodDescriptor[i11] = this.cpDescriptor[this.cpIMethodDescriptorInts[i11]];
        }
    }

    private void parseCpInt(InputStream inputStream) throws IOException, Pack200Exception {
        this.cpInt = decodeBandInt("cpInt", inputStream, Codec.UDELTA5, this.header.getCpIntCount());
    }

    private void parseCpLong(InputStream inputStream) throws IOException, Pack200Exception {
        this.cpLong = parseFlags("cp_Long", inputStream, this.header.getCpLongCount(), Codec.UDELTA5, Codec.DELTA5);
    }

    private void parseCpMethod(InputStream inputStream) throws IOException, Pack200Exception {
        int cpMethodCount = this.header.getCpMethodCount();
        this.cpMethodClassInts = decodeBandInt("cp_Method_class", inputStream, Codec.DELTA5, cpMethodCount);
        this.cpMethodDescriptorInts = decodeBandInt("cp_Method_desc", inputStream, Codec.UDELTA5, cpMethodCount);
        this.cpMethodClass = new String[cpMethodCount];
        this.cpMethodDescriptor = new String[cpMethodCount];
        for (int i11 = 0; i11 < cpMethodCount; i11++) {
            this.cpMethodClass[i11] = this.cpClass[this.cpMethodClassInts[i11]];
            this.cpMethodDescriptor[i11] = this.cpDescriptor[this.cpMethodDescriptorInts[i11]];
        }
    }

    private void parseCpSignature(InputStream inputStream) throws IOException, Pack200Exception {
        int cpSignatureCount = this.header.getCpSignatureCount();
        int[] decodeBandInt = decodeBandInt("cp_Signature_form", inputStream, Codec.DELTA5, cpSignatureCount);
        this.cpSignatureInts = decodeBandInt;
        String[] references = getReferences(decodeBandInt, this.cpUTF8);
        this.cpSignature = new String[cpSignatureCount];
        this.mapSignature = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < cpSignatureCount; i12++) {
            char[] charArray = references[i12].toCharArray();
            for (char c11 : charArray) {
                if (c11 == 'L') {
                    this.cpSignatureInts[i12] = -1;
                    i11++;
                }
            }
        }
        String[] parseReferences = parseReferences("cp_Signature_classes", inputStream, Codec.UDELTA5, i11, this.cpClass);
        int i13 = 0;
        for (int i14 = 0; i14 < cpSignatureCount; i14++) {
            String str = references[i14];
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(64);
            ArrayList arrayList = new ArrayList();
            for (int i15 = 0; i15 < length; i15++) {
                char charAt = str.charAt(i15);
                stringBuffer.append(charAt);
                if (charAt == 'L') {
                    String str2 = parseReferences[i13];
                    arrayList.add(str2);
                    stringBuffer.append(str2);
                    i13++;
                }
            }
            this.cpSignature[i14] = stringBuffer.toString();
            this.mapSignature.put(stringBuffer.toString(), Integer.valueOf(i14));
        }
    }

    private void parseCpString(InputStream inputStream) throws IOException, Pack200Exception {
        int cpStringCount = this.header.getCpStringCount();
        this.cpStringInts = decodeBandInt("cp_String", inputStream, Codec.UDELTA5, cpStringCount);
        this.cpString = new String[cpStringCount];
        for (int i11 = 0; i11 < cpStringCount; i11++) {
            this.cpString[i11] = this.cpUTF8[this.cpStringInts[i11]];
        }
    }

    private void parseCpUtf8(InputStream inputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        int cpUTF8Count = this.header.getCpUTF8Count();
        this.cpUTF8 = new String[cpUTF8Count];
        HashMap hashMap = new HashMap(cpUTF8Count + 1);
        this.mapUTF8 = hashMap;
        this.cpUTF8[0] = "";
        hashMap.put("", 0);
        int[] decodeBandInt = decodeBandInt("cpUTF8Prefix", inputStream, Codec.DELTA5, cpUTF8Count - 2);
        int[] decodeBandInt2 = decodeBandInt("cpUTF8Suffix", inputStream, Codec.UNSIGNED5, cpUTF8Count - 1);
        int i13 = 0;
        int i14 = 0;
        for (int i15 : decodeBandInt2) {
            if (i15 == 0) {
                i14++;
            } else {
                i13 += i15;
            }
        }
        char[] cArr = new char[i13];
        int[] decodeBandInt3 = decodeBandInt("cp_Utf8_chars", inputStream, Codec.CHAR3, i13);
        for (int i16 = 0; i16 < i13; i16++) {
            cArr[i16] = (char) decodeBandInt3[i16];
        }
        int[] decodeBandInt4 = decodeBandInt("cp_Utf8_big_suffix", inputStream, Codec.DELTA5, i14);
        int[][] iArr = new int[i14][];
        for (int i17 = 0; i17 < i14; i17++) {
            iArr[i17] = decodeBandInt("cp_Utf8_big_chars " + i17, inputStream, Codec.DELTA5, decodeBandInt4[i17]);
        }
        char[][] cArr2 = new char[i14][];
        for (int i18 = 0; i18 < i14; i18++) {
            cArr2[i18] = new char[iArr[i18].length];
            int i19 = 0;
            while (true) {
                int[] iArr2 = iArr[i18];
                if (i19 >= iArr2.length) {
                    break;
                }
                cArr2[i18][i19] = (char) iArr2[i19];
                i19++;
            }
        }
        int i21 = 0;
        int i22 = 0;
        for (int i23 = 1; i23 < cpUTF8Count; i23++) {
            String[] strArr = this.cpUTF8;
            int i24 = i23 - 1;
            String str = strArr[i24];
            if (decodeBandInt2[i24] == 0) {
                StringBuilder sb2 = new StringBuilder();
                if (i23 > 1) {
                    i12 = decodeBandInt[i23 - 2];
                } else {
                    i12 = 0;
                }
                sb2.append(str.substring(0, i12));
                sb2.append(new String(cArr2[i22]));
                strArr[i23] = sb2.toString();
                this.mapUTF8.put(this.cpUTF8[i23], Integer.valueOf(i23));
                i22++;
            } else {
                StringBuilder sb3 = new StringBuilder();
                if (i23 > 1) {
                    i11 = decodeBandInt[i23 - 2];
                } else {
                    i11 = 0;
                }
                sb3.append(str.substring(0, i11));
                sb3.append(new String(cArr, i21, decodeBandInt2[i24]));
                strArr[i23] = sb3.toString();
                i21 += decodeBandInt2[i24];
                this.mapUTF8.put(this.cpUTF8[i23], Integer.valueOf(i23));
            }
        }
    }

    public CPClass cpClassValue(int i11) {
        String str = this.cpClass[i11];
        int i12 = this.cpClassInts[i11];
        int i13 = this.classOffset + i11;
        CPClass cPClass = (CPClass) this.stringsToCPClass.get(str);
        if (cPClass != null) {
            return cPClass;
        }
        CPClass cPClass2 = new CPClass(cpUTF8Value(i12), i13);
        this.stringsToCPClass.put(str, cPClass2);
        return cPClass2;
    }

    public CPDouble cpDoubleValue(int i11) {
        Double valueOf = Double.valueOf(this.cpDouble[i11]);
        CPDouble cPDouble = (CPDouble) this.doublesToCPDoubles.get(valueOf);
        if (cPDouble != null) {
            return cPDouble;
        }
        CPDouble cPDouble2 = new CPDouble(valueOf, i11 + this.doubleOffset);
        this.doublesToCPDoubles.put(valueOf, cPDouble2);
        return cPDouble2;
    }

    public CPFieldRef cpFieldValue(int i11) {
        return new CPFieldRef(cpClassValue(this.cpFieldClassInts[i11]), cpNameAndTypeValue(this.cpFieldDescriptorInts[i11]), i11 + this.fieldOffset);
    }

    public CPFloat cpFloatValue(int i11) {
        Float valueOf = Float.valueOf(this.cpFloat[i11]);
        CPFloat cPFloat = (CPFloat) this.floatsToCPFloats.get(valueOf);
        if (cPFloat != null) {
            return cPFloat;
        }
        CPFloat cPFloat2 = new CPFloat(valueOf, i11 + this.floatOffset);
        this.floatsToCPFloats.put(valueOf, cPFloat2);
        return cPFloat2;
    }

    public CPInterfaceMethodRef cpIMethodValue(int i11) {
        return new CPInterfaceMethodRef(cpClassValue(this.cpIMethodClassInts[i11]), cpNameAndTypeValue(this.cpIMethodDescriptorInts[i11]), i11 + this.imethodOffset);
    }

    public CPInteger cpIntegerValue(int i11) {
        Integer valueOf = Integer.valueOf(this.cpInt[i11]);
        CPInteger cPInteger = (CPInteger) this.integersToCPIntegers.get(valueOf);
        if (cPInteger != null) {
            return cPInteger;
        }
        CPInteger cPInteger2 = new CPInteger(valueOf, i11 + this.intOffset);
        this.integersToCPIntegers.put(valueOf, cPInteger2);
        return cPInteger2;
    }

    public CPLong cpLongValue(int i11) {
        Long valueOf = Long.valueOf(this.cpLong[i11]);
        CPLong cPLong = (CPLong) this.longsToCPLongs.get(valueOf);
        if (cPLong != null) {
            return cPLong;
        }
        CPLong cPLong2 = new CPLong(valueOf, i11 + this.longOffset);
        this.longsToCPLongs.put(valueOf, cPLong2);
        return cPLong2;
    }

    public CPMethodRef cpMethodValue(int i11) {
        return new CPMethodRef(cpClassValue(this.cpMethodClassInts[i11]), cpNameAndTypeValue(this.cpMethodDescriptorInts[i11]), i11 + this.methodOffset);
    }

    public CPNameAndType cpNameAndTypeValue(int i11) {
        String str = this.cpDescriptor[i11];
        CPNameAndType cPNameAndType = (CPNameAndType) this.descriptorsToCPNameAndTypes.get(str);
        if (cPNameAndType != null) {
            return cPNameAndType;
        }
        CPNameAndType cPNameAndType2 = new CPNameAndType(cpUTF8Value(this.cpDescriptorNameInts[i11]), cpSignatureValue(this.cpDescriptorTypeInts[i11]), i11 + this.descrOffset);
        this.descriptorsToCPNameAndTypes.put(str, cPNameAndType2);
        return cPNameAndType2;
    }

    public CPUTF8 cpSignatureValue(int i11) {
        int i12 = this.cpSignatureInts[i11];
        if (i12 == -1) {
            i12 = this.signatureOffset + i11;
        }
        String str = this.cpSignature[i11];
        CPUTF8 cputf8 = (CPUTF8) this.stringsToCPUTF8.get(str);
        if (cputf8 != null) {
            return cputf8;
        }
        CPUTF8 cputf82 = new CPUTF8(str, i12);
        this.stringsToCPUTF8.put(str, cputf82);
        return cputf82;
    }

    public CPString cpStringValue(int i11) {
        String str = this.cpString[i11];
        int i12 = this.cpStringInts[i11];
        int i13 = this.stringOffset + i11;
        CPString cPString = (CPString) this.stringsToCPStrings.get(str);
        if (cPString != null) {
            return cPString;
        }
        CPString cPString2 = new CPString(cpUTF8Value(i12), i13);
        this.stringsToCPStrings.put(str, cPString2);
        return cPString2;
    }

    public CPUTF8 cpUTF8Value(int i11) {
        String str = this.cpUTF8[i11];
        CPUTF8 cputf8 = (CPUTF8) this.stringsToCPUTF8.get(str);
        if (cputf8 == null) {
            CPUTF8 cputf82 = new CPUTF8(str, i11);
            this.stringsToCPUTF8.put(str, cputf82);
            return cputf82;
        } else if (cputf8.getGlobalIndex() <= i11) {
            return cputf8;
        } else {
            cputf8.setGlobalIndex(i11);
            return cputf8;
        }
    }

    public SegmentConstantPool getConstantPool() {
        return this.pool;
    }

    public String[] getCpClass() {
        return this.cpClass;
    }

    public String[] getCpDescriptor() {
        return this.cpDescriptor;
    }

    public int[] getCpDescriptorNameInts() {
        return this.cpDescriptorNameInts;
    }

    public int[] getCpDescriptorTypeInts() {
        return this.cpDescriptorTypeInts;
    }

    public String[] getCpFieldClass() {
        return this.cpFieldClass;
    }

    public String[] getCpIMethodClass() {
        return this.cpIMethodClass;
    }

    public int[] getCpInt() {
        return this.cpInt;
    }

    public long[] getCpLong() {
        return this.cpLong;
    }

    public String[] getCpMethodClass() {
        return this.cpMethodClass;
    }

    public String[] getCpMethodDescriptor() {
        return this.cpMethodDescriptor;
    }

    public String[] getCpSignature() {
        return this.cpSignature;
    }

    public String[] getCpUTF8() {
        return this.cpUTF8;
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception {
        parseCpUtf8(inputStream);
        parseCpInt(inputStream);
        parseCpFloat(inputStream);
        parseCpLong(inputStream);
        parseCpDouble(inputStream);
        parseCpString(inputStream);
        parseCpClass(inputStream);
        parseCpSignature(inputStream);
        parseCpDescriptor(inputStream);
        parseCpField(inputStream);
        parseCpMethod(inputStream);
        parseCpIMethod(inputStream);
        int length = this.cpUTF8.length;
        this.intOffset = length;
        int length2 = length + this.cpInt.length;
        this.floatOffset = length2;
        int length3 = length2 + this.cpFloat.length;
        this.longOffset = length3;
        int length4 = length3 + this.cpLong.length;
        this.doubleOffset = length4;
        int length5 = length4 + this.cpDouble.length;
        this.stringOffset = length5;
        int length6 = length5 + this.cpString.length;
        this.classOffset = length6;
        int length7 = length6 + this.cpClass.length;
        this.signatureOffset = length7;
        int length8 = length7 + this.cpSignature.length;
        this.descrOffset = length8;
        int length9 = length8 + this.cpDescriptor.length;
        this.fieldOffset = length9;
        int length10 = length9 + this.cpFieldClass.length;
        this.methodOffset = length10;
        this.imethodOffset = length10 + this.cpMethodClass.length;
    }

    public void unpack() {
    }

    public CPClass cpClassValue(String str) {
        CPClass cPClass = (CPClass) this.stringsToCPClass.get(str);
        if (cPClass != null) {
            return cPClass;
        }
        Integer num = (Integer) this.mapClass.get(str);
        if (num != null) {
            return cpClassValue(num.intValue());
        }
        CPClass cPClass2 = new CPClass(cpUTF8Value(str, false), -1);
        this.stringsToCPClass.put(str, cPClass2);
        return cPClass2;
    }

    public CPUTF8 cpUTF8Value(String str) {
        return cpUTF8Value(str, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cpUTF8Value(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            java.util.Map r0 = r1.stringsToCPUTF8
            java.lang.Object r0 = r0.get(r2)
            org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 r0 = (org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8) r0
            if (r0 != 0) goto L_0x0042
            if (r3 == 0) goto L_0x0015
            java.util.Map r0 = r1.mapUTF8
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x0021
            int r2 = r0.intValue()
            org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 r2 = r1.cpUTF8Value((int) r2)
            return r2
        L_0x0021:
            if (r3 == 0) goto L_0x002c
            java.util.Map r3 = r1.mapSignature
            java.lang.Object r3 = r3.get(r2)
            r0 = r3
            java.lang.Integer r0 = (java.lang.Integer) r0
        L_0x002c:
            if (r0 == 0) goto L_0x0037
            int r2 = r0.intValue()
            org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 r2 = r1.cpSignatureValue(r2)
            return r2
        L_0x0037:
            org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 r0 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8
            r3 = -1
            r0.<init>(r2, r3)
            java.util.Map r3 = r1.stringsToCPUTF8
            r3.put(r2, r0)
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.unpack200.CpBands.cpUTF8Value(java.lang.String, boolean):org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8");
    }

    public CPNameAndType cpNameAndTypeValue(String str) {
        CPNameAndType cPNameAndType = (CPNameAndType) this.descriptorsToCPNameAndTypes.get(str);
        if (cPNameAndType != null) {
            return cPNameAndType;
        }
        Integer num = (Integer) this.mapDescriptor.get(str);
        if (num != null) {
            return cpNameAndTypeValue(num.intValue());
        }
        int indexOf = str.indexOf(58);
        CPNameAndType cPNameAndType2 = new CPNameAndType(cpUTF8Value(str.substring(0, indexOf), true), cpUTF8Value(str.substring(indexOf + 1), true), this.descrOffset - 1);
        this.descriptorsToCPNameAndTypes.put(str, cPNameAndType2);
        return cPNameAndType2;
    }
}
