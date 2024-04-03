package org.apache.commons.compress.harmony.unpack200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class BcBands extends BandSet {
    private int[] bcByte;
    private int[] bcCaseCount;
    private int[] bcCaseValue;
    private int[] bcClassRef;
    private int[] bcDoubleRef;
    private int[][] bcEscByte;
    private int[] bcEscRef;
    private int[] bcEscRefSize;
    private int[] bcEscSize;
    private int[] bcFieldRef;
    private int[] bcFloatRef;
    private int[] bcIMethodRef;
    private int[] bcInitRef;
    private int[] bcIntRef;
    private int[] bcLabel;
    private int[] bcLocal;
    private int[] bcLongRef;
    private int[] bcMethodRef;
    private int[] bcShort;
    private int[] bcStringRef;
    private int[] bcSuperField;
    private int[] bcSuperMethod;
    private int[] bcThisField;
    private int[] bcThisMethod;
    private byte[][][] methodByteCodePacked;
    private List wideByteCodes;

    public BcBands(Segment segment) {
        super(segment);
    }

    private boolean endsWithLoad(int i11) {
        return i11 >= 21 && i11 <= 25;
    }

    private boolean endsWithStore(int i11) {
        return i11 >= 54 && i11 <= 58;
    }

    private boolean startsWithIf(int i11) {
        return (i11 >= 153 && i11 <= 166) || i11 == 198 || i11 == 199;
    }

    public int[] getBcByte() {
        return this.bcByte;
    }

    public int[] getBcCaseCount() {
        return this.bcCaseCount;
    }

    public int[] getBcCaseValue() {
        return this.bcCaseValue;
    }

    public int[] getBcClassRef() {
        return this.bcClassRef;
    }

    public int[] getBcDoubleRef() {
        return this.bcDoubleRef;
    }

    public int[] getBcFieldRef() {
        return this.bcFieldRef;
    }

    public int[] getBcFloatRef() {
        return this.bcFloatRef;
    }

    public int[] getBcIMethodRef() {
        return this.bcIMethodRef;
    }

    public int[] getBcInitRef() {
        return this.bcInitRef;
    }

    public int[] getBcIntRef() {
        return this.bcIntRef;
    }

    public int[] getBcLabel() {
        return this.bcLabel;
    }

    public int[] getBcLocal() {
        return this.bcLocal;
    }

    public int[] getBcLongRef() {
        return this.bcLongRef;
    }

    public int[] getBcMethodRef() {
        return this.bcMethodRef;
    }

    public int[] getBcShort() {
        return this.bcShort;
    }

    public int[] getBcStringRef() {
        return this.bcStringRef;
    }

    public int[] getBcSuperField() {
        return this.bcSuperField;
    }

    public int[] getBcSuperMethod() {
        return this.bcSuperMethod;
    }

    public int[] getBcThisField() {
        return this.bcThisField;
    }

    public int[] getBcThisMethod() {
        return this.bcThisMethod;
    }

    public byte[][][] getMethodByteCodePacked() {
        return this.methodByteCodePacked;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        if (startsWithIf(r5) != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014b, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015d, code lost:
        r11 = r11 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void read(java.io.InputStream r39) throws java.io.IOException, org.apache.commons.compress.harmony.pack200.Pack200Exception {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            org.apache.commons.compress.harmony.unpack200.Segment r2 = r0.segment
            org.apache.commons.compress.harmony.unpack200.AttrDefinitionBands r2 = r2.getAttrDefinitionBands()
            org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap r2 = r2.getAttributeDefinitionMap()
            org.apache.commons.compress.harmony.unpack200.SegmentHeader r3 = r0.header
            int r3 = r3.getClassCount()
            org.apache.commons.compress.harmony.unpack200.Segment r4 = r0.segment
            org.apache.commons.compress.harmony.unpack200.ClassBands r4 = r4.getClassBands()
            long[][] r4 = r4.getMethodFlags()
            java.lang.String r5 = "ACC_ABSTRACT"
            r6 = 2
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r5 = r2.getAttributeLayout((java.lang.String) r5, (int) r6)
            java.lang.String r7 = "ACC_NATIVE"
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r2 = r2.getAttributeLayout((java.lang.String) r7, (int) r6)
            byte[][][] r7 = new byte[r3][][]
            r0.methodByteCodePacked = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r0.wideByteCodes = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
        L_0x005f:
            if (r9 >= r3) goto L_0x01fe
            r6 = r4[r9]
            int r6 = r6.length
            r30 = r3
            byte[][][] r3 = r0.methodByteCodePacked
            r31 = r14
            byte[][] r14 = new byte[r6][]
            r3[r9] = r14
            r14 = r31
            r3 = 0
        L_0x0071:
            if (r3 >= r6) goto L_0x01ea
            r31 = r4[r9]
            r32 = r10
            r33 = r11
            r10 = r31[r3]
            boolean r31 = r5.matches(r10)
            if (r31 != 0) goto L_0x01d1
            boolean r10 = r2.matches(r10)
            if (r10 != 0) goto L_0x01d1
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream
            r10.<init>()
        L_0x008c:
            int r11 = r39.read()
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = (byte) r11
            r34 = r2
            r2 = -1
            if (r11 == r2) goto L_0x009e
            r10.write(r11)
            r2 = r34
            goto L_0x008c
        L_0x009e:
            byte[][][] r2 = r0.methodByteCodePacked
            r2 = r2[r9]
            byte[] r10 = r10.toByteArray()
            r2[r3] = r10
            byte[][][] r2 = r0.methodByteCodePacked
            r2 = r2[r9]
            r2 = r2[r3]
            int r10 = r2.length
            int r2 = r2.length
            int[] r10 = new int[r2]
            r11 = 0
        L_0x00b3:
            if (r11 >= r2) goto L_0x00c8
            r31 = r2
            byte[][][] r2 = r0.methodByteCodePacked
            r2 = r2[r9]
            r2 = r2[r3]
            byte r2 = r2[r11]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r10[r11] = r2
            int r11 = r11 + 1
            r2 = r31
            goto L_0x00b3
        L_0x00c8:
            r35 = r4
            r10 = r32
            r11 = r33
            r2 = 0
        L_0x00cf:
            byte[][][] r4 = r0.methodByteCodePacked
            r4 = r4[r9]
            r4 = r4[r3]
            r36 = r5
            int r5 = r4.length
            if (r2 >= r5) goto L_0x01cd
            byte r5 = r4[r2]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r37 = r6
            r6 = 132(0x84, float:1.85E-43)
            if (r5 == r6) goto L_0x01c0
            r6 = 192(0xc0, float:2.69E-43)
            if (r5 == r6) goto L_0x0169
            r6 = 193(0xc1, float:2.7E-43)
            if (r5 == r6) goto L_0x0169
            r6 = 196(0xc4, float:2.75E-43)
            if (r5 == r6) goto L_0x016b
            r4 = 197(0xc5, float:2.76E-43)
            if (r5 == r4) goto L_0x0167
            r4 = 253(0xfd, float:3.55E-43)
            if (r5 == r4) goto L_0x0164
            r4 = 254(0xfe, float:3.56E-43)
            if (r5 == r4) goto L_0x0161
            switch(r5) {
                case 16: goto L_0x015d;
                case 17: goto L_0x015a;
                case 18: goto L_0x0157;
                case 19: goto L_0x0157;
                case 20: goto L_0x0154;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            switch(r5) {
                case 167: goto L_0x0151;
                case 168: goto L_0x0151;
                case 169: goto L_0x014e;
                case 170: goto L_0x0146;
                case 171: goto L_0x0140;
                default: goto L_0x0102;
            }
        L_0x0102:
            switch(r5) {
                case 178: goto L_0x013d;
                case 179: goto L_0x013d;
                case 180: goto L_0x013d;
                case 181: goto L_0x013d;
                case 182: goto L_0x013a;
                case 183: goto L_0x013a;
                case 184: goto L_0x013a;
                case 185: goto L_0x0137;
                default: goto L_0x0105;
            }
        L_0x0105:
            switch(r5) {
                case 187: goto L_0x0169;
                case 188: goto L_0x015d;
                case 189: goto L_0x0169;
                default: goto L_0x0108;
            }
        L_0x0108:
            switch(r5) {
                case 200: goto L_0x0151;
                case 201: goto L_0x0151;
                case 202: goto L_0x0134;
                case 203: goto L_0x0134;
                case 204: goto L_0x0134;
                case 205: goto L_0x0134;
                case 206: goto L_0x0131;
                case 207: goto L_0x0131;
                case 208: goto L_0x0131;
                case 209: goto L_0x0134;
                case 210: goto L_0x0134;
                case 211: goto L_0x0134;
                case 212: goto L_0x0134;
                case 213: goto L_0x0131;
                case 214: goto L_0x0131;
                case 215: goto L_0x0131;
                case 216: goto L_0x012e;
                case 217: goto L_0x012e;
                case 218: goto L_0x012e;
                case 219: goto L_0x012e;
                case 220: goto L_0x012b;
                case 221: goto L_0x012b;
                case 222: goto L_0x012b;
                case 223: goto L_0x012e;
                case 224: goto L_0x012e;
                case 225: goto L_0x012e;
                case 226: goto L_0x012e;
                case 227: goto L_0x012b;
                case 228: goto L_0x012b;
                case 229: goto L_0x012b;
                case 230: goto L_0x0128;
                case 231: goto L_0x0128;
                case 232: goto L_0x0128;
                case 233: goto L_0x0169;
                case 234: goto L_0x0125;
                case 235: goto L_0x0122;
                case 236: goto L_0x0169;
                case 237: goto L_0x0125;
                case 238: goto L_0x0122;
                case 239: goto L_0x011f;
                default: goto L_0x010b;
            }
        L_0x010b:
            boolean r4 = r0.endsWithLoad(r5)
            if (r4 != 0) goto L_0x014e
            boolean r4 = r0.endsWithStore(r5)
            if (r4 == 0) goto L_0x0118
            goto L_0x014e
        L_0x0118:
            boolean r4 = r0.startsWithIf(r5)
            if (r4 == 0) goto L_0x015f
            goto L_0x0151
        L_0x011f:
            int r17 = r17 + 1
            goto L_0x015f
        L_0x0122:
            int r8 = r8 + 1
            goto L_0x015f
        L_0x0125:
            int r15 = r15 + 1
            goto L_0x015f
        L_0x0128:
            int r27 = r27 + 1
            goto L_0x015f
        L_0x012b:
            int r26 = r26 + 1
            goto L_0x015f
        L_0x012e:
            int r24 = r24 + 1
            goto L_0x015f
        L_0x0131:
            int r25 = r25 + 1
            goto L_0x015f
        L_0x0134:
            int r23 = r23 + 1
            goto L_0x015f
        L_0x0137:
            int r22 = r22 + 1
            goto L_0x015f
        L_0x013a:
            int r21 = r21 + 1
            goto L_0x015f
        L_0x013d:
            int r20 = r20 + 1
            goto L_0x015f
        L_0x0140:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r7.add(r4)
            goto L_0x014b
        L_0x0146:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r7.add(r4)
        L_0x014b:
            int r10 = r10 + 1
            goto L_0x0151
        L_0x014e:
            int r13 = r13 + 1
            goto L_0x015f
        L_0x0151:
            int r14 = r14 + 1
            goto L_0x015f
        L_0x0154:
            int r16 = r16 + 1
            goto L_0x015f
        L_0x0157:
            int r18 = r18 + 1
            goto L_0x015f
        L_0x015a:
            int r12 = r12 + 1
            goto L_0x015f
        L_0x015d:
            int r11 = r11 + 1
        L_0x015f:
            r4 = 2
            goto L_0x01c5
        L_0x0161:
            int r28 = r28 + 1
            goto L_0x015f
        L_0x0164:
            int r29 = r29 + 1
            goto L_0x015f
        L_0x0167:
            int r11 = r11 + 1
        L_0x0169:
            r4 = 2
            goto L_0x01bd
        L_0x016b:
            int r2 = r2 + 1
            byte r4 = r4[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.util.List r5 = r0.wideByteCodes
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r5.add(r6)
            r5 = 132(0x84, float:1.85E-43)
            if (r4 != r5) goto L_0x0186
            int r13 = r13 + 1
            int r12 = r12 + 1
            r31 = r2
            r4 = 2
            goto L_0x01ba
        L_0x0186:
            boolean r5 = r0.endsWithLoad(r4)
            if (r5 != 0) goto L_0x01b5
            boolean r5 = r0.endsWithStore(r4)
            if (r5 != 0) goto L_0x01b5
            r5 = 169(0xa9, float:2.37E-43)
            if (r4 != r5) goto L_0x0197
            goto L_0x01b5
        L_0x0197:
            org.apache.commons.compress.harmony.unpack200.Segment r5 = r0.segment
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r31 = r2
            java.lang.String r2 = "Found unhandled "
            r6.append(r2)
            org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode r2 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode(r4)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r4 = 2
            r5.log(r4, r2)
            goto L_0x01ba
        L_0x01b5:
            r31 = r2
            r4 = 2
            int r13 = r13 + 1
        L_0x01ba:
            r2 = r31
            goto L_0x01c5
        L_0x01bd:
            int r19 = r19 + 1
            goto L_0x01c5
        L_0x01c0:
            r4 = 2
            int r13 = r13 + 1
            int r11 = r11 + 1
        L_0x01c5:
            int r2 = r2 + 1
            r5 = r36
            r6 = r37
            goto L_0x00cf
        L_0x01cd:
            r37 = r6
            r4 = 2
            goto L_0x01de
        L_0x01d1:
            r34 = r2
            r35 = r4
            r36 = r5
            r37 = r6
            r4 = 2
            r10 = r32
            r11 = r33
        L_0x01de:
            int r3 = r3 + 1
            r2 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            goto L_0x0071
        L_0x01ea:
            r34 = r2
            r35 = r4
            r36 = r5
            r32 = r10
            r33 = r11
            r4 = 2
            int r9 = r9 + 1
            r6 = r4
            r3 = r30
            r4 = r35
            goto L_0x005f
        L_0x01fe:
            r31 = r14
            java.lang.String r2 = "bc_case_count"
            org.apache.commons.compress.harmony.pack200.BHSDCodec r3 = org.apache.commons.compress.harmony.pack200.Codec.UNSIGNED5
            int[] r2 = r0.decodeBandInt((java.lang.String) r2, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r10)
            r0.bcCaseCount = r2
            r2 = 0
            r3 = 0
        L_0x020c:
            int[] r4 = r0.bcCaseCount
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0228
            java.lang.Object r4 = r7.get(r2)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0220
            int r3 = r3 + 1
            goto L_0x0225
        L_0x0220:
            int[] r4 = r0.bcCaseCount
            r4 = r4[r2]
            int r3 = r3 + r4
        L_0x0225:
            int r2 = r2 + 1
            goto L_0x020c
        L_0x0228:
            java.lang.String r2 = "bc_case_value"
            org.apache.commons.compress.harmony.pack200.BHSDCodec r4 = org.apache.commons.compress.harmony.pack200.Codec.DELTA5
            int[] r2 = r0.decodeBandInt((java.lang.String) r2, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r3)
            r0.bcCaseValue = r2
            r14 = r31
            r2 = 0
        L_0x0235:
            if (r2 >= r10) goto L_0x023f
            int[] r3 = r0.bcCaseCount
            r3 = r3[r2]
            int r14 = r14 + r3
            int r2 = r2 + 1
            goto L_0x0235
        L_0x023f:
            org.apache.commons.compress.harmony.pack200.BHSDCodec r2 = org.apache.commons.compress.harmony.pack200.Codec.BYTE1
            java.lang.String r3 = "bc_byte"
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r2, (int) r11)
            r0.bcByte = r3
            org.apache.commons.compress.harmony.pack200.BHSDCodec r3 = org.apache.commons.compress.harmony.pack200.Codec.DELTA5
            java.lang.String r4 = "bc_short"
            int[] r4 = r0.decodeBandInt((java.lang.String) r4, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r12)
            r0.bcShort = r4
            org.apache.commons.compress.harmony.pack200.BHSDCodec r4 = org.apache.commons.compress.harmony.pack200.Codec.UNSIGNED5
            java.lang.String r5 = "bc_local"
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r13)
            r0.bcLocal = r5
            java.lang.String r5 = "bc_label"
            org.apache.commons.compress.harmony.pack200.BHSDCodec r6 = org.apache.commons.compress.harmony.pack200.Codec.BRANCH5
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r6, (int) r14)
            r0.bcLabel = r5
            java.lang.String r5 = "bc_intref"
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r15)
            r0.bcIntRef = r5
            java.lang.String r5 = "bc_floatref"
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcFloatRef = r5
            java.lang.String r5 = "bc_longref"
            r8 = r16
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcLongRef = r5
            java.lang.String r5 = "bc_doubleref"
            r8 = r17
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcDoubleRef = r5
            java.lang.String r5 = "bc_stringref"
            r8 = r18
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcStringRef = r5
            java.lang.String r5 = "bc_classref"
            r8 = r19
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcClassRef = r5
            java.lang.String r5 = "bc_fieldref"
            r8 = r20
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcFieldRef = r5
            java.lang.String r5 = "bc_methodref"
            r8 = r21
            int[] r5 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcMethodRef = r5
            java.lang.String r5 = "bc_imethodref"
            r8 = r22
            int[] r3 = r0.decodeBandInt((java.lang.String) r5, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r3, (int) r8)
            r0.bcIMethodRef = r3
            java.lang.String r3 = "bc_thisfield"
            r8 = r23
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcThisField = r3
            java.lang.String r3 = "bc_superfield"
            r8 = r24
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcSuperField = r3
            java.lang.String r3 = "bc_thismethod"
            r8 = r25
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcThisMethod = r3
            java.lang.String r3 = "bc_supermethod"
            r8 = r26
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcSuperMethod = r3
            java.lang.String r3 = "bc_initref"
            r8 = r27
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcInitRef = r3
            java.lang.String r3 = "bc_escref"
            r8 = r29
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcEscRef = r3
            java.lang.String r3 = "bc_escrefsize"
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcEscRefSize = r3
            java.lang.String r3 = "bc_escsize"
            r8 = r28
            int[] r3 = r0.decodeBandInt((java.lang.String) r3, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r4, (int) r8)
            r0.bcEscSize = r3
            java.lang.String r4 = "bc_escbyte"
            int[][] r1 = r0.decodeBandInt((java.lang.String) r4, (java.io.InputStream) r1, (org.apache.commons.compress.harmony.pack200.BHSDCodec) r2, (int[]) r3)
            r0.bcEscByte = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.unpack200.BcBands.read(java.io.InputStream):void");
    }

    public void unpack() throws Pack200Exception {
        AttributeLayout attributeLayout;
        AttributeLayout attributeLayout2;
        String[][] strArr;
        int[] iArr;
        int[] iArr2;
        ArrayList arrayList;
        List list;
        List list2;
        CPClass cPClass;
        int classCount = this.header.getClassCount();
        long[][] methodFlags = this.segment.getClassBands().getMethodFlags();
        int[] codeMaxNALocals = this.segment.getClassBands().getCodeMaxNALocals();
        int[] codeMaxStack = this.segment.getClassBands().getCodeMaxStack();
        ArrayList[][] methodAttributes = this.segment.getClassBands().getMethodAttributes();
        String[][] methodDescr = this.segment.getClassBands().getMethodDescr();
        AttributeLayoutMap attributeDefinitionMap = this.segment.getAttrDefinitionBands().getAttributeDefinitionMap();
        AttributeLayout attributeLayout3 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_ABSTRACT, 2);
        AttributeLayout attributeLayout4 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_NATIVE, 2);
        AttributeLayout attributeLayout5 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_STATIC, 2);
        int size = this.wideByteCodes.size();
        int[] iArr3 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr3[i11] = ((Integer) this.wideByteCodes.get(i11)).intValue();
        }
        ArrayList[][] arrayListArr = methodAttributes;
        OperandManager operandManager = new OperandManager(this.bcCaseCount, this.bcCaseValue, this.bcByte, this.bcShort, this.bcLocal, this.bcLabel, this.bcIntRef, this.bcFloatRef, this.bcLongRef, this.bcDoubleRef, this.bcStringRef, this.bcClassRef, this.bcFieldRef, this.bcMethodRef, this.bcIMethodRef, this.bcThisField, this.bcSuperField, this.bcThisMethod, this.bcSuperMethod, this.bcInitRef, iArr3);
        operandManager.setSegment(this.segment);
        ArrayList orderedCodeAttributes = this.segment.getClassBands().getOrderedCodeAttributes();
        int[] codeHandlerCount = this.segment.getClassBands().getCodeHandlerCount();
        int[][] codeHandlerStartP = this.segment.getClassBands().getCodeHandlerStartP();
        int[][] codeHandlerEndPO = this.segment.getClassBands().getCodeHandlerEndPO();
        int[][] codeHandlerCatchPO = this.segment.getClassBands().getCodeHandlerCatchPO();
        int[][] codeHandlerClassRCN = this.segment.getClassBands().getCodeHandlerClassRCN();
        ArrayList arrayList2 = orderedCodeAttributes;
        boolean hasAllCodeFlags = this.segment.getSegmentHeader().getOptions().hasAllCodeFlags();
        boolean[] codeHasAttributes = this.segment.getClassBands().getCodeHasAttributes();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < classCount) {
            int i15 = classCount;
            int length = methodFlags[i12].length;
            int[][] iArr4 = codeHandlerEndPO;
            int[][] iArr5 = codeHandlerCatchPO;
            int i16 = i13;
            int i17 = i14;
            int i18 = 0;
            while (i18 < length) {
                int i19 = length;
                long[][] jArr = methodFlags;
                long j11 = methodFlags[i12][i18];
                if (attributeLayout3.matches(j11) || attributeLayout4.matches(j11)) {
                    iArr2 = codeMaxNALocals;
                    iArr = codeMaxStack;
                    strArr = methodDescr;
                    attributeLayout2 = attributeLayout5;
                    attributeLayout = attributeLayout3;
                    arrayList = arrayList2;
                    i17 = i17;
                } else {
                    int i21 = codeMaxStack[i16];
                    int i22 = codeMaxNALocals[i16];
                    if (!attributeLayout5.matches(j11)) {
                        i22++;
                    }
                    int countInvokeInterfaceArgs = i22 + SegmentUtils.countInvokeInterfaceArgs(methodDescr[i12][i18]);
                    String[] cpClass = this.segment.getCpBands().getCpClass();
                    operandManager.setCurrentClass(cpClass[this.segment.getClassBands().getClassThisInts()[i12]]);
                    operandManager.setSuperClass(cpClass[this.segment.getClassBands().getClassSuperInts()[i12]]);
                    ArrayList arrayList3 = new ArrayList();
                    iArr2 = codeMaxNALocals;
                    if (codeHandlerCount != null) {
                        int i23 = 0;
                        while (i23 < codeHandlerCount[i16]) {
                            int i24 = codeHandlerClassRCN[i16][i23] - 1;
                            int[] iArr6 = codeMaxStack;
                            if (i24 != -1) {
                                cPClass = this.segment.getCpBands().cpClassValue(i24);
                            } else {
                                cPClass = null;
                            }
                            arrayList3.add(new ExceptionTableEntry(codeHandlerStartP[i16][i23], iArr4[i16][i23], iArr5[i16][i23], cPClass));
                            i23++;
                            codeMaxStack = iArr6;
                            methodDescr = methodDescr;
                            attributeLayout5 = attributeLayout5;
                            attributeLayout3 = attributeLayout3;
                        }
                    }
                    iArr = codeMaxStack;
                    strArr = methodDescr;
                    attributeLayout2 = attributeLayout5;
                    attributeLayout = attributeLayout3;
                    CodeAttribute codeAttribute = new CodeAttribute(i21, countInvokeInterfaceArgs, this.methodByteCodePacked[i12][i18], this.segment, operandManager, arrayList3);
                    ArrayList arrayList4 = arrayListArr[i12][i18];
                    int i25 = 0;
                    for (int i26 = 0; i26 < arrayList4.size(); i26++) {
                        Attribute attribute = (Attribute) arrayList4.get(i26);
                        if (!(attribute instanceof NewAttribute) || ((NewAttribute) attribute).getLayoutIndex() >= 15) {
                            break;
                        }
                        i25++;
                    }
                    arrayList4.add(i25, codeAttribute);
                    codeAttribute.renumber(codeAttribute.byteCodeOffsets);
                    if (hasAllCodeFlags) {
                        arrayList = arrayList2;
                        list = (List) arrayList.get(i16);
                    } else {
                        arrayList = arrayList2;
                        if (codeHasAttributes[i16]) {
                            int i27 = i17;
                            list2 = (List) arrayList.get(i27);
                            i17 = i27 + 1;
                        } else {
                            int i28 = i17;
                            list2 = Collections.EMPTY_LIST;
                        }
                        list = list2;
                    }
                    for (int i29 = 0; i29 < list.size(); i29++) {
                        Attribute attribute2 = (Attribute) list.get(i29);
                        codeAttribute.addAttribute(attribute2);
                        if (attribute2.hasBCIRenumbering()) {
                            ((BCIRenumberedAttribute) attribute2).renumber(codeAttribute.byteCodeOffsets);
                        }
                    }
                    i16++;
                }
                i18++;
                arrayList2 = arrayList;
                methodFlags = jArr;
                length = i19;
                codeMaxNALocals = iArr2;
                codeMaxStack = iArr;
                methodDescr = strArr;
                attributeLayout5 = attributeLayout2;
                attributeLayout3 = attributeLayout;
            }
            long[][] jArr2 = methodFlags;
            int[] iArr7 = codeMaxStack;
            String[][] strArr2 = methodDescr;
            AttributeLayout attributeLayout6 = attributeLayout5;
            AttributeLayout attributeLayout7 = attributeLayout3;
            ArrayList arrayList5 = arrayList2;
            i12++;
            i14 = i17;
            i13 = i16;
            classCount = i15;
            codeHandlerCatchPO = iArr5;
            codeHandlerEndPO = iArr4;
            codeMaxNALocals = codeMaxNALocals;
        }
    }
}
