package org.apache.commons.compress.harmony.unpack200;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.DeprecatedAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTypeTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;

public class ClassBands extends BandSet {
    private final AttributeLayoutMap attrMap;
    private long[] classAccessFlags;
    private ArrayList[] classAttributes;
    private final int classCount = this.header.getClassCount();
    private int[] classFieldCount;
    private long[] classFlags;
    private int[][] classInterfacesInts;
    private int[] classMethodCount;
    private int[] classSuperInts;
    private String[] classThis;
    private int[] classThisInts;
    private int[] classVersionMajor;
    private int[] classVersionMinor;
    private List[] codeAttributes;
    private int[][] codeHandlerCatchPO;
    private int[][] codeHandlerClassRCN;
    private int[] codeHandlerCount;
    private int[][] codeHandlerEndPO;
    private int[][] codeHandlerStartP;
    private boolean[] codeHasAttributes;
    private int[] codeMaxNALocals;
    private int[] codeMaxStack;
    private final CpBands cpBands;
    private long[][] fieldAccessFlags;
    private ArrayList[][] fieldAttributes;
    private String[][] fieldDescr;
    private int[][] fieldDescrInts;
    private long[][] fieldFlags;
    private IcTuple[][] icLocal;
    private long[][] methodAccessFlags;
    private int[] methodAttrCalls;
    private ArrayList[][] methodAttributes;
    private String[][] methodDescr;
    private int[][] methodDescrInts;
    private long[][] methodFlags;
    private final SegmentOptions options = this.header.getOptions();

    public ClassBands(Segment segment) {
        super(segment);
        this.attrMap = segment.getAttrDefinitionBands().getAttributeDefinitionMap();
        this.cpBands = segment.getCpBands();
    }

    private int getCallCount(int[][] iArr, long[][] jArr, int i11) throws Pack200Exception {
        int i12 = 0;
        for (int[] iArr2 : iArr) {
            int i13 = 0;
            while (true) {
                if (i13 >= iArr2.length) {
                    break;
                }
                i12 += this.attrMap.getAttributeLayout(iArr2[i13], i11).numBackwardsCallables();
                i13++;
            }
        }
        int i14 = 0;
        for (long[] jArr2 : jArr) {
            int i15 = 0;
            while (true) {
                if (i15 >= jArr2.length) {
                    break;
                }
                i14 = (int) (((long) i14) | jArr2[i15]);
                i15++;
            }
        }
        for (int i16 = 0; i16 < 26; i16++) {
            if (((1 << i16) & i14) != 0) {
                i12 += this.attrMap.getAttributeLayout(i16, i11).numBackwardsCallables();
            }
        }
        return i12;
    }

    private void parseClassAttrBands(InputStream inputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        AttributeLayout attributeLayout;
        AttributeLayout attributeLayout2;
        int i13;
        int[] iArr;
        int[] iArr2;
        AttributeLayout attributeLayout3;
        int i14;
        int i15;
        int i16;
        AttributeLayout attributeLayout4;
        int i17;
        int i18;
        AttributeLayout attributeLayout5;
        AttributeLayout attributeLayout6;
        int i19;
        int i21;
        int i22;
        int i23;
        String str;
        String str2;
        int i24;
        CPNameAndType cPNameAndType;
        int i25;
        int[] iArr3;
        int i26;
        int[][] iArr4;
        InputStream inputStream2 = inputStream;
        String[] cpUTF8 = this.cpBands.getCpUTF8();
        String[] cpClass = this.cpBands.getCpClass();
        this.classAttributes = new ArrayList[this.classCount];
        int i27 = 0;
        while (true) {
            i11 = this.classCount;
            if (i27 >= i11) {
                break;
            }
            this.classAttributes[i27] = new ArrayList();
            i27++;
        }
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[] parseFlags = parseFlags("class_flags", inputStream, i11, bHSDCodec, this.options.hasClassFlagsHi());
        this.classFlags = parseFlags;
        int[] decodeBandInt = decodeBandInt("class_attr_calls", inputStream2, bHSDCodec, getCallCount(decodeBandInt("class_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("class_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(parseFlags))), new long[][]{this.classFlags}, 0));
        AttributeLayout attributeLayout7 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 0);
        AttributeLayout attributeLayout8 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SOURCE_FILE, 0);
        int[] decodeBandInt2 = decodeBandInt("class_SourceFile_RUN", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout8));
        AttributeLayout attributeLayout9 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_ENCLOSING_METHOD, 0);
        int countMatches = SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout9);
        int[] decodeBandInt3 = decodeBandInt("class_EnclosingMethod_RC", inputStream2, bHSDCodec, countMatches);
        int[] decodeBandInt4 = decodeBandInt("class_EnclosingMethod_RDN", inputStream2, bHSDCodec, countMatches);
        AttributeLayout attributeLayout10 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 0);
        int[] decodeBandInt5 = decodeBandInt("class_Signature_RS", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout10));
        int parseClassMetadataBands = parseClassMetadataBands(inputStream2, decodeBandInt);
        String[] strArr = cpUTF8;
        AttributeLayout attributeLayout11 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_INNER_CLASSES, 0);
        int[] decodeBandInt6 = decodeBandInt("class_InnerClasses_N", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout11));
        int[][] decodeBandInt7 = decodeBandInt("class_InnerClasses_RC", inputStream2, bHSDCodec, decodeBandInt6);
        String[] strArr2 = cpClass;
        int[][] decodeBandInt8 = decodeBandInt("class_InnerClasses_F", inputStream2, bHSDCodec, decodeBandInt6);
        int[] iArr5 = decodeBandInt6;
        int[][] iArr6 = decodeBandInt7;
        int i28 = 0;
        int i29 = 0;
        while (i28 < decodeBandInt8.length) {
            AttributeLayout attributeLayout12 = attributeLayout11;
            int i31 = 0;
            while (true) {
                int[] iArr7 = decodeBandInt8[i28];
                iArr4 = decodeBandInt8;
                if (i31 >= iArr7.length) {
                    break;
                }
                if (iArr7[i31] != 0) {
                    i29++;
                }
                i31++;
                decodeBandInt8 = iArr4;
            }
            i28++;
            attributeLayout11 = attributeLayout12;
            decodeBandInt8 = iArr4;
        }
        AttributeLayout attributeLayout13 = attributeLayout11;
        int[][] iArr8 = decodeBandInt8;
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] decodeBandInt9 = decodeBandInt("class_InnerClasses_outer_RCN", inputStream2, bHSDCodec2, i29);
        int[] decodeBandInt10 = decodeBandInt("class_InnerClasses_name_RUN", inputStream2, bHSDCodec2, i29);
        AttributeLayout attributeLayout14 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CLASS_FILE_VERSION, 0);
        int countMatches2 = SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout14);
        int[] decodeBandInt11 = decodeBandInt("class_file_version_minor_H", inputStream2, bHSDCodec2, countMatches2);
        int[] decodeBandInt12 = decodeBandInt("class_file_version_major_H", inputStream2, bHSDCodec2, countMatches2);
        if (countMatches2 > 0) {
            int i32 = this.classCount;
            this.classVersionMajor = new int[i32];
            this.classVersionMinor = new int[i32];
        }
        int defaultClassMajorVersion = this.header.getDefaultClassMajorVersion();
        int defaultClassMinorVersion = this.header.getDefaultClassMinorVersion();
        if (this.options.hasClassFlagsHi()) {
            i12 = 62;
        } else {
            i12 = 31;
        }
        int i33 = defaultClassMajorVersion;
        int i34 = i12 + 1;
        int[] iArr9 = decodeBandInt12;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i34];
        AttributeLayout attributeLayout15 = attributeLayout14;
        int[] iArr10 = new int[i34];
        int[] iArr11 = decodeBandInt9;
        List[] listArr = new List[i34];
        int[] iArr12 = decodeBandInt5;
        int i35 = 0;
        while (i35 < i12) {
            int i36 = i12;
            AttributeLayout attributeLayout16 = attributeLayout10;
            AttributeLayout attributeLayout17 = this.attrMap.getAttributeLayout(i35, 0);
            if (attributeLayout17 != null && !attributeLayout17.isDefaultLayout()) {
                attributeLayoutArr[i35] = attributeLayout17;
                iArr10[i35] = SegmentUtils.countMatches(this.classFlags, (IMatcher) attributeLayout17);
            }
            i35++;
            i12 = i36;
            attributeLayout10 = attributeLayout16;
        }
        AttributeLayout attributeLayout18 = attributeLayout10;
        int i37 = parseClassMetadataBands;
        int i38 = 0;
        while (i38 < i34) {
            if (iArr10[i38] > 0) {
                i26 = i34;
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i38]);
                listArr[i38] = attributeBands.parseAttributes(inputStream2, iArr10[i38]);
                int numBackwardsCallables = attributeLayoutArr[i38].numBackwardsCallables();
                if (numBackwardsCallables > 0) {
                    int[] iArr13 = new int[numBackwardsCallables];
                    iArr3 = iArr10;
                    System.arraycopy(decodeBandInt, i37, iArr13, 0, numBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr13);
                    i37 += numBackwardsCallables;
                    i38++;
                    inputStream2 = inputStream;
                    i34 = i26;
                    iArr10 = iArr3;
                }
            } else {
                i26 = i34;
            }
            iArr3 = iArr10;
            i38++;
            inputStream2 = inputStream;
            i34 = i26;
            iArr10 = iArr3;
        }
        int i39 = i34;
        this.icLocal = new IcTuple[this.classCount][];
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        while (i45 < this.classCount) {
            AttributeLayout[] attributeLayoutArr2 = attributeLayoutArr;
            List[] listArr2 = listArr;
            long j11 = this.classFlags[i45];
            if (attributeLayout7.matches(j11)) {
                attributeLayout = attributeLayout7;
                this.classAttributes[i45].add(new DeprecatedAttribute());
            } else {
                attributeLayout = attributeLayout7;
            }
            if (attributeLayout8.matches(j11)) {
                i13 = i46;
                iArr = decodeBandInt4;
                Object value = attributeLayout8.getValue((long) decodeBandInt2[i42], this.cpBands.getConstantPool());
                if (value == null) {
                    String str3 = this.classThis[i45];
                    String substring = str3.substring(str3.lastIndexOf(47) + 1);
                    String substring2 = substring.substring(substring.lastIndexOf(46) + 1);
                    char[] charArray = substring2.toCharArray();
                    int i48 = 0;
                    while (true) {
                        if (i48 >= charArray.length) {
                            attributeLayout2 = attributeLayout8;
                            i25 = -1;
                            i48 = -1;
                            break;
                        }
                        attributeLayout2 = attributeLayout8;
                        if (charArray[i48] <= '-') {
                            i25 = -1;
                            break;
                        } else {
                            i48++;
                            attributeLayout8 = attributeLayout2;
                        }
                    }
                    if (i48 > i25) {
                        substring2 = substring2.substring(0, i48);
                    }
                    value = this.cpBands.cpUTF8Value(substring2 + ".java", true);
                } else {
                    attributeLayout2 = attributeLayout8;
                }
                this.classAttributes[i45].add(new SourceFileAttribute((CPUTF8) value));
                i42++;
            } else {
                attributeLayout2 = attributeLayout8;
                i13 = i46;
                iArr = decodeBandInt4;
            }
            if (attributeLayout9.matches(j11)) {
                CPClass cpClassValue = this.cpBands.cpClassValue(decodeBandInt3[i43]);
                int i49 = iArr[i43];
                if (i49 != 0) {
                    cPNameAndType = this.cpBands.cpNameAndTypeValue(i49 - 1);
                } else {
                    cPNameAndType = null;
                }
                this.classAttributes[i45].add(new EnclosingMethodAttribute(cpClassValue, cPNameAndType));
                i43++;
            }
            AttributeLayout attributeLayout19 = attributeLayout18;
            if (attributeLayout19.matches(j11)) {
                iArr2 = decodeBandInt3;
                this.classAttributes[i45].add(new SignatureAttribute((CPUTF8) attributeLayout19.getValue((long) iArr12[i44], this.cpBands.getConstantPool())));
                i44++;
            } else {
                iArr2 = decodeBandInt3;
            }
            AttributeLayout attributeLayout20 = attributeLayout13;
            if (attributeLayout20.matches(j11)) {
                this.icLocal[i45] = new IcTuple[iArr5[i13]];
                i16 = i41;
                int i50 = 0;
                while (i50 < this.icLocal[i45].length) {
                    int i51 = iArr6[i13][i50];
                    String str4 = strArr2[i51];
                    int i52 = iArr8[i13][i50];
                    if (i52 != 0) {
                        int i53 = iArr11[i16];
                        int i54 = decodeBandInt10[i16];
                        String str5 = strArr2[i53];
                        i16++;
                        i21 = i42;
                        i19 = i43;
                        attributeLayout6 = attributeLayout19;
                        i23 = i53;
                        i22 = i54;
                        str = strArr[i54];
                        str2 = str5;
                        i24 = i52;
                    } else {
                        i21 = i42;
                        IcTuple[] icTuples = this.segment.getIcBands().getIcTuples();
                        i19 = i43;
                        attributeLayout6 = attributeLayout19;
                        int i55 = 0;
                        while (true) {
                            if (i55 >= icTuples.length) {
                                i24 = i52;
                                str2 = null;
                                str = null;
                                break;
                            } else if (icTuples[i55].getC().equals(str4)) {
                                int f11 = icTuples[i55].getF();
                                String c22 = icTuples[i55].getC2();
                                str = icTuples[i55].getN();
                                i24 = f11;
                                str2 = c22;
                                break;
                            } else {
                                i55++;
                            }
                        }
                        i23 = -1;
                        i22 = -1;
                    }
                    this.icLocal[i45][i50] = new IcTuple(str4, i24, str2, str, i51, i23, i22, i50);
                    i50++;
                    i42 = i21;
                    i43 = i19;
                    attributeLayout19 = attributeLayout6;
                }
                i15 = i42;
                i14 = i43;
                attributeLayout3 = attributeLayout19;
                i17 = i13 + 1;
                attributeLayout4 = attributeLayout15;
            } else {
                i15 = i42;
                i14 = i43;
                attributeLayout3 = attributeLayout19;
                i16 = i41;
                attributeLayout4 = attributeLayout15;
                i17 = i13;
            }
            if (attributeLayout4.matches(j11)) {
                this.classVersionMajor[i45] = iArr9[i47];
                this.classVersionMinor[i45] = decodeBandInt11[i47];
                i47++;
            } else {
                int[] iArr14 = this.classVersionMajor;
                if (iArr14 != null) {
                    iArr14[i45] = i33;
                    this.classVersionMinor[i45] = defaultClassMinorVersion;
                }
            }
            int i56 = i39;
            int i57 = 0;
            while (i57 < i56) {
                AttributeLayout attributeLayout21 = attributeLayoutArr2[i57];
                if (attributeLayout21 == null || !attributeLayout21.matches(j11)) {
                    i18 = i17;
                    attributeLayout5 = attributeLayout4;
                } else {
                    i18 = i17;
                    attributeLayout5 = attributeLayout4;
                    this.classAttributes[i45].add(listArr2[i57].get(0));
                    listArr2[i57].remove(0);
                }
                i57++;
                i17 = i18;
                attributeLayout4 = attributeLayout5;
            }
            int i58 = i17;
            attributeLayout15 = attributeLayout4;
            i45++;
            attributeLayout13 = attributeLayout20;
            i39 = i56;
            attributeLayoutArr = attributeLayoutArr2;
            listArr = listArr2;
            attributeLayout7 = attributeLayout;
            decodeBandInt4 = iArr;
            attributeLayout8 = attributeLayout2;
            i42 = i15;
            i43 = i14;
            attributeLayout18 = attributeLayout3;
            int[] iArr15 = iArr2;
            i46 = i58;
            i41 = i16;
            decodeBandInt3 = iArr15;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseClassMetadataBands(java.io.InputStream r12, int[] r13) throws org.apache.commons.compress.harmony.pack200.Pack200Exception, java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "RVA"
            java.lang.String r1 = "RIA"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}
            org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap r0 = r11.attrMap
            java.lang.String r1 = "RuntimeVisibleAnnotations"
            r8 = 0
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r0 = r0.getAttributeLayout((java.lang.String) r1, (int) r8)
            org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap r1 = r11.attrMap
            java.lang.String r2 = "RuntimeInvisibleAnnotations"
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r1 = r1.getAttributeLayout((java.lang.String) r2, (int) r8)
            long[] r2 = r11.classFlags
            int r2 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countMatches((long[]) r2, (org.apache.commons.compress.harmony.unpack200.IMatcher) r0)
            long[] r3 = r11.classFlags
            int r3 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countMatches((long[]) r3, (org.apache.commons.compress.harmony.unpack200.IMatcher) r1)
            r5 = 2
            int[] r6 = new int[r5]
            r6[r8] = r2
            r9 = 1
            r6[r9] = r3
            int[] r7 = new int[r5]
            r7 = {0, 0} // fill-array
            if (r2 <= 0) goto L_0x0042
            r2 = r13[r8]
            r7[r8] = r2
            if (r3 <= 0) goto L_0x0040
            r13 = r13[r9]
            r7[r9] = r13
            r13 = r5
            goto L_0x004a
        L_0x0040:
            r13 = r9
            goto L_0x004a
        L_0x0042:
            if (r3 <= 0) goto L_0x0049
            r13 = r13[r8]
            r7[r9] = r13
            goto L_0x0040
        L_0x0049:
            r13 = r8
        L_0x004a:
            java.lang.String r10 = "class"
            r2 = r11
            r3 = r12
            r5 = r6
            r6 = r7
            r7 = r10
            org.apache.commons.compress.harmony.unpack200.MetadataBandGroup[] r12 = r2.parseMetadata(r3, r4, r5, r6, r7)
            r2 = r12[r8]
            java.util.List r2 = r2.getAttributes()
            r12 = r12[r9]
            java.util.List r12 = r12.getAttributes()
            r3 = r8
            r4 = r3
        L_0x0063:
            long[] r5 = r11.classFlags
            int r6 = r5.length
            if (r8 >= r6) goto L_0x0099
            r6 = r5[r8]
            boolean r5 = r0.matches(r6)
            if (r5 == 0) goto L_0x007e
            java.util.ArrayList[] r5 = r11.classAttributes
            r5 = r5[r8]
            int r6 = r3 + 1
            java.lang.Object r3 = r2.get(r3)
            r5.add(r3)
            r3 = r6
        L_0x007e:
            long[] r5 = r11.classFlags
            r6 = r5[r8]
            boolean r5 = r1.matches(r6)
            if (r5 == 0) goto L_0x0096
            java.util.ArrayList[] r5 = r11.classAttributes
            r5 = r5[r8]
            int r6 = r4 + 1
            java.lang.Object r4 = r12.get(r4)
            r5.add(r4)
            r4 = r6
        L_0x0096:
            int r8 = r8 + 1
            goto L_0x0063
        L_0x0099:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.unpack200.ClassBands.parseClassMetadataBands(java.io.InputStream, int[]):int");
    }

    private void parseCodeAttrBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
        int i12;
        int[] iArr;
        AttributeLayout attributeLayout;
        int[] iArr2;
        int i13;
        InputStream inputStream2 = inputStream;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[] parseFlags = parseFlags("code_flags", inputStream, i11, bHSDCodec, this.segment.getSegmentHeader().getOptions().hasCodeFlagsHi());
        int[][] decodeBandInt = decodeBandInt("code_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("code_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(parseFlags)));
        int i14 = 0;
        for (int[] iArr3 : decodeBandInt) {
            int i15 = 0;
            while (true) {
                if (i15 >= iArr3.length) {
                    break;
                }
                i14 += this.attrMap.getAttributeLayout(iArr3[i15], 3).numBackwardsCallables();
                i15++;
            }
        }
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] decodeBandInt2 = decodeBandInt("code_attr_calls", inputStream2, bHSDCodec2, i14);
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LINE_NUMBER_TABLE, 3);
        int[] decodeBandInt3 = decodeBandInt("code_LineNumberTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(parseFlags, (IMatcher) attributeLayout2));
        BHSDCodec bHSDCodec3 = Codec.BCI5;
        int[][] decodeBandInt4 = decodeBandInt("code_LineNumberTable_bci_P", inputStream2, bHSDCodec3, decodeBandInt3);
        int[][] decodeBandInt5 = decodeBandInt("code_LineNumberTable_line", inputStream2, bHSDCodec2, decodeBandInt3);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TABLE, 3);
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE, 3);
        int[] decodeBandInt6 = decodeBandInt("code_LocalVariableTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(parseFlags, (IMatcher) attributeLayout3));
        int[][] decodeBandInt7 = decodeBandInt("code_LocalVariableTable_bci_P", inputStream2, bHSDCodec3, decodeBandInt6);
        BHSDCodec bHSDCodec4 = Codec.BRANCH5;
        int[][] decodeBandInt8 = decodeBandInt("code_LocalVariableTable_span_O", inputStream2, bHSDCodec4, decodeBandInt6);
        CPUTF8[][] parseCPUTF8References = parseCPUTF8References("code_LocalVariableTable_name_RU", inputStream2, bHSDCodec2, decodeBandInt6);
        CPUTF8[][] parseCPSignatureReferences = parseCPSignatureReferences("code_LocalVariableTable_type_RS", inputStream2, bHSDCodec2, decodeBandInt6);
        int[][] decodeBandInt9 = decodeBandInt("code_LocalVariableTable_slot", inputStream2, bHSDCodec2, decodeBandInt6);
        AttributeLayout attributeLayout5 = attributeLayout4;
        int[] decodeBandInt10 = decodeBandInt("code_LocalVariableTypeTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(parseFlags, (IMatcher) attributeLayout4));
        int[][] decodeBandInt11 = decodeBandInt("code_LocalVariableTypeTable_bci_P", inputStream2, bHSDCodec3, decodeBandInt10);
        int[][] decodeBandInt12 = decodeBandInt("code_LocalVariableTypeTable_span_O", inputStream2, bHSDCodec4, decodeBandInt10);
        CPUTF8[][] parseCPUTF8References2 = parseCPUTF8References("code_LocalVariableTypeTable_name_RU", inputStream2, bHSDCodec2, decodeBandInt10);
        CPUTF8[][] parseCPSignatureReferences2 = parseCPSignatureReferences("code_LocalVariableTypeTable_type_RS", inputStream2, bHSDCodec2, decodeBandInt10);
        int[][] decodeBandInt13 = decodeBandInt("code_LocalVariableTypeTable_slot", inputStream2, bHSDCodec2, decodeBandInt10);
        if (this.options.hasCodeFlagsHi()) {
            i12 = 62;
        } else {
            i12 = 31;
        }
        int[][] iArr4 = decodeBandInt13;
        int i16 = i12 + 1;
        int[][] iArr5 = decodeBandInt12;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i16];
        int[][] iArr6 = decodeBandInt11;
        int[] iArr7 = new int[i16];
        int[] iArr8 = decodeBandInt10;
        List[] listArr = new List[i16];
        int[][] iArr9 = decodeBandInt7;
        int i17 = 0;
        while (i17 < i12) {
            int i18 = i12;
            int[] iArr10 = decodeBandInt6;
            AttributeLayout attributeLayout6 = this.attrMap.getAttributeLayout(i17, 3);
            if (attributeLayout6 != null && !attributeLayout6.isDefaultLayout()) {
                attributeLayoutArr[i17] = attributeLayout6;
                iArr7[i17] = SegmentUtils.countMatches(parseFlags, (IMatcher) attributeLayout6);
            }
            i17++;
            i12 = i18;
            decodeBandInt6 = iArr10;
        }
        int[] iArr11 = decodeBandInt6;
        int i19 = 0;
        int i21 = 0;
        while (i19 < i16) {
            if (iArr7[i19] > 0) {
                i13 = i16;
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i19]);
                listArr[i19] = attributeBands.parseAttributes(inputStream2, iArr7[i19]);
                int numBackwardsCallables = attributeLayoutArr[i19].numBackwardsCallables();
                if (numBackwardsCallables > 0) {
                    int[] iArr12 = new int[numBackwardsCallables];
                    iArr2 = iArr7;
                    System.arraycopy(decodeBandInt2, i21, iArr12, 0, numBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr12);
                    i21 += numBackwardsCallables;
                    i19++;
                    inputStream2 = inputStream;
                    i16 = i13;
                    iArr7 = iArr2;
                }
            } else {
                i13 = i16;
            }
            iArr2 = iArr7;
            i19++;
            inputStream2 = inputStream;
            i16 = i13;
            iArr7 = iArr2;
        }
        int i22 = i16;
        int i23 = i11;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i27 < i23) {
            if (attributeLayout2.matches(parseFlags[i27])) {
                attributeLayout = attributeLayout2;
                iArr = decodeBandInt3;
                LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(decodeBandInt3[i24], decodeBandInt4[i24], decodeBandInt5[i24]);
                i24++;
                this.codeAttributes[i27].add(lineNumberTableAttribute);
            } else {
                attributeLayout = attributeLayout2;
                iArr = decodeBandInt3;
            }
            if (attributeLayout3.matches(parseFlags[i27])) {
                LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute(iArr11[i25], iArr9[i25], decodeBandInt8[i25], parseCPUTF8References[i25], parseCPSignatureReferences[i25], decodeBandInt9[i25]);
                i25++;
                this.codeAttributes[i27].add(localVariableTableAttribute);
            }
            AttributeLayout attributeLayout7 = attributeLayout5;
            if (attributeLayout7.matches(parseFlags[i27])) {
                LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(iArr8[i26], iArr6[i26], iArr5[i26], parseCPUTF8References2[i26], parseCPSignatureReferences2[i26], iArr4[i26]);
                i26++;
                this.codeAttributes[i27].add(localVariableTypeTableAttribute);
            }
            int i28 = i22;
            int i29 = 0;
            while (i29 < i28) {
                AttributeLayout attributeLayout8 = attributeLayoutArr[i29];
                int i31 = i24;
                AttributeLayout[] attributeLayoutArr2 = attributeLayoutArr;
                if (attributeLayout8 != null && attributeLayout8.matches(parseFlags[i27])) {
                    this.codeAttributes[i27].add(listArr[i29].get(0));
                    listArr[i29].remove(0);
                }
                i29++;
                i24 = i31;
                attributeLayoutArr = attributeLayoutArr2;
            }
            int i32 = i24;
            AttributeLayout[] attributeLayoutArr3 = attributeLayoutArr;
            i27++;
            attributeLayout5 = attributeLayout7;
            attributeLayout2 = attributeLayout;
            i22 = i28;
            decodeBandInt3 = iArr;
        }
    }

    private void parseCodeBands(InputStream inputStream) throws Pack200Exception, IOException {
        char c11;
        InputStream inputStream2 = inputStream;
        char c12 = 2;
        int countMatches = SegmentUtils.countMatches(this.methodFlags, (IMatcher) this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CODE, 2));
        int[] decodeBandInt = decodeBandInt("code_headers", inputStream2, Codec.BYTE1, countMatches);
        boolean hasAllCodeFlags = this.segment.getSegmentHeader().getOptions().hasAllCodeFlags();
        if (!hasAllCodeFlags) {
            this.codeHasAttributes = new boolean[countMatches];
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < countMatches; i13++) {
            if (decodeBandInt[i13] == 0) {
                i12++;
                if (!hasAllCodeFlags) {
                    this.codeHasAttributes[i13] = true;
                }
            }
        }
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        int[] decodeBandInt2 = decodeBandInt("code_max_stack", inputStream2, bHSDCodec, i12);
        int[] decodeBandInt3 = decodeBandInt("code_max_na_locals", inputStream2, bHSDCodec, i12);
        int[] decodeBandInt4 = decodeBandInt("code_handler_count", inputStream2, bHSDCodec, i12);
        this.codeMaxStack = new int[countMatches];
        this.codeMaxNALocals = new int[countMatches];
        this.codeHandlerCount = new int[countMatches];
        int i14 = 0;
        int i15 = 0;
        while (i14 < countMatches) {
            int i16 = decodeBandInt[i14] & 255;
            if (i16 >= 0) {
                if (i16 == 0) {
                    this.codeMaxStack[i14] = decodeBandInt2[i15];
                    this.codeMaxNALocals[i14] = decodeBandInt3[i15];
                    this.codeHandlerCount[i14] = decodeBandInt4[i15];
                    i15++;
                    c11 = c12;
                } else {
                    if (i16 <= 144) {
                        int i17 = i16 - 1;
                        this.codeMaxStack[i14] = i17 % 12;
                        this.codeMaxNALocals[i14] = i17 / 12;
                        this.codeHandlerCount[i14] = 0;
                    } else if (i16 <= 208) {
                        int i18 = i16 - 145;
                        this.codeMaxStack[i14] = i18 % 8;
                        this.codeMaxNALocals[i14] = i18 / 8;
                        this.codeHandlerCount[i14] = 1;
                    } else if (i16 <= 255) {
                        int i19 = i16 - 209;
                        this.codeMaxStack[i14] = i19 % 7;
                        this.codeMaxNALocals[i14] = i19 / 7;
                        c11 = 2;
                        this.codeHandlerCount[i14] = 2;
                    } else {
                        throw new IllegalStateException("Shouldn't get here either");
                    }
                    c11 = 2;
                }
                i14++;
                c12 = c11;
            } else {
                throw new IllegalStateException("Shouldn't get here");
            }
        }
        this.codeHandlerStartP = decodeBandInt("code_handler_start_P", inputStream2, Codec.BCI5, this.codeHandlerCount);
        BHSDCodec bHSDCodec2 = Codec.BRANCH5;
        this.codeHandlerEndPO = decodeBandInt("code_handler_end_PO", inputStream2, bHSDCodec2, this.codeHandlerCount);
        this.codeHandlerCatchPO = decodeBandInt("code_handler_catch_PO", inputStream2, bHSDCodec2, this.codeHandlerCount);
        this.codeHandlerClassRCN = decodeBandInt("code_handler_class_RCN", inputStream2, Codec.UNSIGNED5, this.codeHandlerCount);
        if (!hasAllCodeFlags) {
            countMatches = i12;
        }
        this.codeAttributes = new List[countMatches];
        while (true) {
            List[] listArr = this.codeAttributes;
            if (i11 < listArr.length) {
                listArr[i11] = new ArrayList();
                i11++;
            } else {
                parseCodeAttrBands(inputStream2, countMatches);
                return;
            }
        }
    }

    private void parseFieldAttrBands(InputStream inputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        AttributeLayout attributeLayout;
        int[] iArr;
        int[] iArr2;
        int i13;
        InputStream inputStream2 = inputStream;
        int[] iArr3 = this.classFieldCount;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[][] parseFlags = parseFlags("field_flags", inputStream, iArr3, bHSDCodec, this.options.hasFieldFlagsHi());
        this.fieldFlags = parseFlags;
        int[] decodeBandInt = decodeBandInt("field_attr_calls", inputStream2, bHSDCodec, getCallCount(decodeBandInt("field_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("field_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(parseFlags))), this.fieldFlags, 1));
        this.fieldAttributes = new ArrayList[this.classCount][];
        for (int i14 = 0; i14 < this.classCount; i14++) {
            this.fieldAttributes[i14] = new ArrayList[this.fieldFlags[i14].length];
            for (int i15 = 0; i15 < this.fieldFlags[i14].length; i15++) {
                this.fieldAttributes[i14][i15] = new ArrayList();
            }
        }
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CONSTANT_VALUE, 1);
        int countMatches = SegmentUtils.countMatches(this.fieldFlags, (IMatcher) attributeLayout2);
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] decodeBandInt2 = decodeBandInt("field_ConstantValue_KQ", inputStream2, bHSDCodec2, countMatches);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 1);
        int[] decodeBandInt3 = decodeBandInt("field_Signature_RS", inputStream2, bHSDCodec2, SegmentUtils.countMatches(this.fieldFlags, (IMatcher) attributeLayout3));
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 1);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < this.classCount; i18++) {
            int i19 = 0;
            while (true) {
                long[] jArr = this.fieldFlags[i18];
                if (i19 >= jArr.length) {
                    break;
                }
                long j11 = jArr[i19];
                if (attributeLayout4.matches(j11)) {
                    this.fieldAttributes[i18][i19].add(new DeprecatedAttribute());
                }
                if (attributeLayout2.matches(j11)) {
                    iArr2 = decodeBandInt2;
                    iArr = decodeBandInt3;
                    long j12 = (long) decodeBandInt2[i16];
                    String str = this.fieldDescr[i18][i19];
                    attributeLayout = attributeLayout4;
                    i13 = 58;
                    String substring = str.substring(str.indexOf(58) + 1);
                    if (substring.equals("B") || substring.equals(ExifInterface.LATITUDE_SOUTH) || substring.equals("C") || substring.equals("Z")) {
                        substring = "I";
                    }
                    this.fieldAttributes[i18][i19].add(new ConstantValueAttribute(attributeLayout2.getValue(j12, substring, this.cpBands.getConstantPool())));
                    i16++;
                } else {
                    iArr2 = decodeBandInt2;
                    iArr = decodeBandInt3;
                    attributeLayout = attributeLayout4;
                    i13 = 58;
                }
                if (attributeLayout3.matches(j11)) {
                    String str2 = this.fieldDescr[i18][i19];
                    this.fieldAttributes[i18][i19].add(new SignatureAttribute((CPUTF8) attributeLayout3.getValue((long) iArr[i17], str2.substring(str2.indexOf(i13) + 1), this.cpBands.getConstantPool())));
                    i17++;
                }
                i19++;
                decodeBandInt2 = iArr2;
                decodeBandInt3 = iArr;
                attributeLayout4 = attributeLayout;
            }
            int[] iArr4 = decodeBandInt2;
            int[] iArr5 = decodeBandInt3;
            AttributeLayout attributeLayout5 = attributeLayout4;
        }
        int parseFieldMetadataBands = parseFieldMetadataBands(inputStream2, decodeBandInt);
        if (this.options.hasFieldFlagsHi()) {
            i11 = 62;
        } else {
            i11 = 31;
        }
        int i21 = i11 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i21];
        int[] iArr6 = new int[i21];
        List[] listArr = new List[i21];
        for (int i22 = 0; i22 < i11; i22++) {
            AttributeLayout attributeLayout6 = this.attrMap.getAttributeLayout(i22, 1);
            if (attributeLayout6 != null && !attributeLayout6.isDefaultLayout()) {
                attributeLayoutArr[i22] = attributeLayout6;
                iArr6[i22] = SegmentUtils.countMatches(this.fieldFlags, (IMatcher) attributeLayout6);
            }
        }
        for (int i23 = 0; i23 < i21; i23++) {
            if (iArr6[i23] > 0) {
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i23]);
                listArr[i23] = attributeBands.parseAttributes(inputStream2, iArr6[i23]);
                int numBackwardsCallables = attributeLayoutArr[i23].numBackwardsCallables();
                if (numBackwardsCallables > 0) {
                    int[] iArr7 = new int[numBackwardsCallables];
                    System.arraycopy(decodeBandInt, parseFieldMetadataBands, iArr7, 0, numBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr7);
                    parseFieldMetadataBands += numBackwardsCallables;
                }
            }
        }
        for (int i24 = 0; i24 < this.classCount; i24++) {
            int i25 = 0;
            while (true) {
                long[] jArr2 = this.fieldFlags[i24];
                if (i25 >= jArr2.length) {
                    break;
                }
                long j13 = jArr2[i25];
                int i26 = 0;
                for (int i27 = 0; i27 < i21; i27++) {
                    AttributeLayout attributeLayout7 = attributeLayoutArr[i27];
                    if (attributeLayout7 != null && attributeLayout7.matches(j13)) {
                        if (attributeLayoutArr[i27].getIndex() < 15) {
                            i12 = 0;
                            this.fieldAttributes[i24][i25].add(i26, listArr[i27].get(0));
                            i26++;
                        } else {
                            i12 = 0;
                            this.fieldAttributes[i24][i25].add(listArr[i27].get(0));
                        }
                        listArr[i27].remove(i12);
                    }
                }
                i25++;
            }
        }
    }

    private void parseFieldBands(InputStream inputStream) throws IOException, Pack200Exception {
        int[][] decodeBandInt = decodeBandInt("field_descr", inputStream, Codec.DELTA5, this.classFieldCount);
        this.fieldDescrInts = decodeBandInt;
        this.fieldDescr = getReferences(decodeBandInt, this.cpBands.getCpDescriptor());
        parseFieldAttrBands(inputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseFieldMetadataBands(java.io.InputStream r13, int[] r14) throws org.apache.commons.compress.harmony.pack200.Pack200Exception, java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "RVA"
            java.lang.String r1 = "RIA"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}
            org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap r0 = r12.attrMap
            java.lang.String r1 = "RuntimeVisibleAnnotations"
            r8 = 1
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r0 = r0.getAttributeLayout((java.lang.String) r1, (int) r8)
            org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap r1 = r12.attrMap
            java.lang.String r2 = "RuntimeInvisibleAnnotations"
            org.apache.commons.compress.harmony.unpack200.AttributeLayout r1 = r1.getAttributeLayout((java.lang.String) r2, (int) r8)
            long[][] r2 = r12.fieldFlags
            int r2 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countMatches((long[][]) r2, (org.apache.commons.compress.harmony.unpack200.IMatcher) r0)
            long[][] r3 = r12.fieldFlags
            int r3 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countMatches((long[][]) r3, (org.apache.commons.compress.harmony.unpack200.IMatcher) r1)
            r5 = 2
            int[] r6 = new int[r5]
            r9 = 0
            r6[r9] = r2
            r6[r8] = r3
            int[] r7 = new int[r5]
            r7 = {0, 0} // fill-array
            if (r2 <= 0) goto L_0x0042
            r2 = r14[r9]
            r7[r9] = r2
            if (r3 <= 0) goto L_0x0040
            r14 = r14[r8]
            r7[r8] = r14
            r14 = r5
            goto L_0x004a
        L_0x0040:
            r14 = r8
            goto L_0x004a
        L_0x0042:
            if (r3 <= 0) goto L_0x0049
            r14 = r14[r9]
            r7[r8] = r14
            goto L_0x0040
        L_0x0049:
            r14 = r9
        L_0x004a:
            java.lang.String r10 = "field"
            r2 = r12
            r3 = r13
            r5 = r6
            r6 = r7
            r7 = r10
            org.apache.commons.compress.harmony.unpack200.MetadataBandGroup[] r13 = r2.parseMetadata(r3, r4, r5, r6, r7)
            r2 = r13[r9]
            java.util.List r2 = r2.getAttributes()
            r13 = r13[r8]
            java.util.List r13 = r13.getAttributes()
            r3 = r9
            r4 = r3
            r5 = r4
        L_0x0064:
            long[][] r6 = r12.fieldFlags
            int r6 = r6.length
            if (r3 >= r6) goto L_0x00ab
            r6 = r9
        L_0x006a:
            long[][] r7 = r12.fieldFlags
            r7 = r7[r3]
            int r8 = r7.length
            if (r6 >= r8) goto L_0x00a8
            r10 = r7[r6]
            boolean r7 = r0.matches(r10)
            if (r7 == 0) goto L_0x0089
            java.util.ArrayList[][] r7 = r12.fieldAttributes
            r7 = r7[r3]
            r7 = r7[r6]
            int r8 = r4 + 1
            java.lang.Object r4 = r2.get(r4)
            r7.add(r4)
            r4 = r8
        L_0x0089:
            long[][] r7 = r12.fieldFlags
            r7 = r7[r3]
            r10 = r7[r6]
            boolean r7 = r1.matches(r10)
            if (r7 == 0) goto L_0x00a5
            java.util.ArrayList[][] r7 = r12.fieldAttributes
            r7 = r7[r3]
            r7 = r7[r6]
            int r8 = r5 + 1
            java.lang.Object r5 = r13.get(r5)
            r7.add(r5)
            r5 = r8
        L_0x00a5:
            int r6 = r6 + 1
            goto L_0x006a
        L_0x00a8:
            int r3 = r3 + 1
            goto L_0x0064
        L_0x00ab:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.unpack200.ClassBands.parseFieldMetadataBands(java.io.InputStream, int[]):int");
    }

    private MetadataBandGroup[] parseMetadata(InputStream inputStream, String[] strArr, int[] iArr, int[] iArr2, String str) throws IOException, Pack200Exception {
        int i11;
        ClassBands classBands = this;
        InputStream inputStream2 = inputStream;
        String[] strArr2 = strArr;
        String str2 = str;
        MetadataBandGroup[] metadataBandGroupArr = new MetadataBandGroup[strArr2.length];
        int i12 = 0;
        while (i12 < strArr2.length) {
            metadataBandGroupArr[i12] = new MetadataBandGroup(strArr2[i12], classBands.cpBands);
            String str3 = strArr2[i12];
            if (str3.indexOf(80) >= 0) {
                metadataBandGroupArr[i12].param_NB = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_param_NB", inputStream2, Codec.BYTE1, iArr[i12]);
            }
            if (!str3.equals("AD")) {
                BHSDCodec bHSDCodec = Codec.UNSIGNED5;
                metadataBandGroupArr[i12].anno_N = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_anno_N", inputStream2, bHSDCodec, iArr[i12]);
                metadataBandGroupArr[i12].type_RS = classBands.parseCPSignatureReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_type_RS", inputStream2, bHSDCodec, metadataBandGroupArr[i12].anno_N);
                metadataBandGroupArr[i12].pair_N = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_pair_N", inputStream2, bHSDCodec, metadataBandGroupArr[i12].anno_N);
                int i13 = 0;
                i11 = 0;
                while (true) {
                    MetadataBandGroup metadataBandGroup = metadataBandGroupArr[i12];
                    if (i13 < metadataBandGroup.pair_N.length) {
                        int i14 = 0;
                        while (true) {
                            int[] iArr3 = metadataBandGroupArr[i12].pair_N[i13];
                            if (i14 < iArr3.length) {
                                i11 += iArr3[i14];
                                i14++;
                            } else {
                                i13++;
                            }
                        }
                    } else {
                        metadataBandGroup.name_RU = classBands.parseCPUTF8References(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_name_RU", inputStream2, Codec.UNSIGNED5, i11);
                    }
                }
            } else {
                i11 = iArr[i12];
            }
            metadataBandGroupArr[i12].T = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_T", inputStream2, Codec.BYTE1, i11 + iArr2[i12]);
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (true) {
                MetadataBandGroup metadataBandGroup2 = metadataBandGroupArr[i12];
                MetadataBandGroup[] metadataBandGroupArr2 = metadataBandGroupArr;
                int[] iArr4 = metadataBandGroup2.T;
                MetadataBandGroup metadataBandGroup3 = metadataBandGroup2;
                if (i15 < iArr4.length) {
                    char c11 = (char) iArr4[i15];
                    if (c11 == '@') {
                        i22++;
                    } else if (c11 != 'F') {
                        if (c11 != 'S') {
                            if (c11 == 'c') {
                                i21++;
                            } else if (c11 == 'e') {
                                i25++;
                            } else if (c11 == 's') {
                                i24++;
                            } else if (c11 != 'I') {
                                if (c11 == 'J') {
                                    i19++;
                                } else if (c11 != 'Z') {
                                    if (c11 != '[') {
                                        switch (c11) {
                                            case 'B':
                                            case 'C':
                                                break;
                                            case 'D':
                                                i17++;
                                                break;
                                        }
                                    } else {
                                        i23++;
                                    }
                                }
                            }
                        }
                        i16++;
                    } else {
                        i18++;
                    }
                    i15++;
                    metadataBandGroupArr = metadataBandGroupArr2;
                } else {
                    BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
                    InputStream inputStream3 = inputStream;
                    int i26 = i22;
                    classBands = this;
                    MetadataBandGroup metadataBandGroup4 = metadataBandGroup3;
                    int i27 = i23;
                    metadataBandGroup4.caseI_KI = classBands.parseCPIntReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseI_KI", inputStream3, bHSDCodec2, i16);
                    metadataBandGroupArr2[i12].caseD_KD = classBands.parseCPDoubleReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseD_KD", inputStream3, bHSDCodec2, i17);
                    metadataBandGroupArr2[i12].caseF_KF = classBands.parseCPFloatReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseF_KF", inputStream3, bHSDCodec2, i18);
                    metadataBandGroupArr2[i12].caseJ_KJ = classBands.parseCPLongReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseJ_KJ", inputStream3, bHSDCodec2, i19);
                    metadataBandGroupArr2[i12].casec_RS = classBands.parseCPSignatureReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_casec_RS", inputStream3, bHSDCodec2, i21);
                    InputStream inputStream4 = inputStream;
                    BHSDCodec bHSDCodec3 = bHSDCodec2;
                    int i28 = i25;
                    metadataBandGroupArr2[i12].caseet_RS = parseReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseet_RS", inputStream4, bHSDCodec3, i28, classBands.cpBands.getCpSignature());
                    metadataBandGroupArr2[i12].caseec_RU = parseReferences(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_caseec_RU", inputStream4, bHSDCodec3, i28, classBands.cpBands.getCpUTF8());
                    metadataBandGroupArr2[i12].cases_RU = classBands.parseCPUTF8References(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_cases_RU", inputStream3, bHSDCodec2, i24);
                    metadataBandGroupArr2[i12].casearray_N = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_casearray_N", inputStream3, bHSDCodec2, i27);
                    int i29 = i26;
                    metadataBandGroupArr2[i12].nesttype_RS = classBands.parseCPUTF8References(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_nesttype_RS", inputStream3, bHSDCodec2, i29);
                    metadataBandGroupArr2[i12].nestpair_N = classBands.decodeBandInt(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_nestpair_N", inputStream3, bHSDCodec2, i29);
                    int i31 = 0;
                    int i32 = 0;
                    while (true) {
                        MetadataBandGroup metadataBandGroup5 = metadataBandGroupArr2[i12];
                        int[] iArr5 = metadataBandGroup5.nestpair_N;
                        if (i31 < iArr5.length) {
                            i32 += iArr5[i31];
                            i31++;
                        } else {
                            metadataBandGroup5.nestname_RU = classBands.parseCPUTF8References(str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3 + "_nestname_RU", inputStream3, Codec.UNSIGNED5, i32);
                            i12++;
                            strArr2 = strArr;
                            inputStream2 = inputStream3;
                            metadataBandGroupArr = metadataBandGroupArr2;
                        }
                    }
                }
            }
        }
        return metadataBandGroupArr;
    }

    private void parseMethodAttrBands(InputStream inputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        int[][] iArr;
        AttributeLayout attributeLayout;
        InputStream inputStream2 = inputStream;
        int[] iArr2 = this.classMethodCount;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[][] parseFlags = parseFlags("method_flags", inputStream, iArr2, bHSDCodec, this.options.hasMethodFlagsHi());
        this.methodFlags = parseFlags;
        this.methodAttrCalls = decodeBandInt("method_attr_calls", inputStream2, bHSDCodec, getCallCount(decodeBandInt("method_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("method_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(parseFlags))), this.methodFlags, 2));
        this.methodAttributes = new ArrayList[this.classCount][];
        for (int i13 = 0; i13 < this.classCount; i13++) {
            this.methodAttributes[i13] = new ArrayList[this.methodFlags[i13].length];
            for (int i14 = 0; i14 < this.methodFlags[i13].length; i14++) {
                this.methodAttributes[i13][i14] = new ArrayList();
            }
        }
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_EXCEPTIONS, 2);
        int countMatches = SegmentUtils.countMatches(this.methodFlags, (IMatcher) attributeLayout2);
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] decodeBandInt = decodeBandInt("method_Exceptions_n", inputStream2, bHSDCodec2, countMatches);
        int[][] decodeBandInt2 = decodeBandInt("method_Exceptions_RC", inputStream2, bHSDCodec2, decodeBandInt);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 2);
        int[] decodeBandInt3 = decodeBandInt("method_signature_RS", inputStream2, bHSDCodec2, SegmentUtils.countMatches(this.methodFlags, (IMatcher) attributeLayout3));
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 2);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < this.methodAttributes.length; i17++) {
            int i18 = 0;
            while (i18 < this.methodAttributes[i17].length) {
                int[] iArr3 = decodeBandInt;
                long j11 = this.methodFlags[i17][i18];
                if (attributeLayout2.matches(j11)) {
                    int i19 = iArr3[i15];
                    int[] iArr4 = decodeBandInt2[i15];
                    CPClass[] cPClassArr = new CPClass[i19];
                    int i21 = 0;
                    while (i21 < i19) {
                        cPClassArr[i21] = this.cpBands.cpClassValue(iArr4[i21]);
                        i21++;
                        attributeLayout2 = attributeLayout2;
                        decodeBandInt2 = decodeBandInt2;
                    }
                    attributeLayout = attributeLayout2;
                    iArr = decodeBandInt2;
                    this.methodAttributes[i17][i18].add(new ExceptionsAttribute(cPClassArr));
                    i15++;
                } else {
                    attributeLayout = attributeLayout2;
                    iArr = decodeBandInt2;
                }
                if (attributeLayout3.matches(j11)) {
                    long j12 = (long) decodeBandInt3[i16];
                    String str = this.methodDescr[i17][i18];
                    String substring = str.substring(str.indexOf(58) + 1);
                    if (substring.equals("B") || substring.equals("H")) {
                        substring = "I";
                    }
                    this.methodAttributes[i17][i18].add(new SignatureAttribute((CPUTF8) attributeLayout3.getValue(j12, substring, this.cpBands.getConstantPool())));
                    i16++;
                }
                if (attributeLayout4.matches(j11)) {
                    this.methodAttributes[i17][i18].add(new DeprecatedAttribute());
                }
                i18++;
                decodeBandInt = iArr3;
                attributeLayout2 = attributeLayout;
                decodeBandInt2 = iArr;
            }
            AttributeLayout attributeLayout5 = attributeLayout2;
            int[] iArr5 = decodeBandInt;
            int[][] iArr6 = decodeBandInt2;
        }
        int parseMethodMetadataBands = parseMethodMetadataBands(inputStream2, this.methodAttrCalls);
        if (this.options.hasMethodFlagsHi()) {
            i11 = 62;
        } else {
            i11 = 31;
        }
        int i22 = i11 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i22];
        int[] iArr7 = new int[i22];
        List[] listArr = new List[i22];
        for (int i23 = 0; i23 < i11; i23++) {
            AttributeLayout attributeLayout6 = this.attrMap.getAttributeLayout(i23, 2);
            if (attributeLayout6 != null && !attributeLayout6.isDefaultLayout()) {
                attributeLayoutArr[i23] = attributeLayout6;
                iArr7[i23] = SegmentUtils.countMatches(this.methodFlags, (IMatcher) attributeLayout6);
            }
        }
        for (int i24 = 0; i24 < i22; i24++) {
            if (iArr7[i24] > 0) {
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i24]);
                listArr[i24] = attributeBands.parseAttributes(inputStream2, iArr7[i24]);
                int numBackwardsCallables = attributeLayoutArr[i24].numBackwardsCallables();
                if (numBackwardsCallables > 0) {
                    int[] iArr8 = new int[numBackwardsCallables];
                    System.arraycopy(this.methodAttrCalls, parseMethodMetadataBands, iArr8, 0, numBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr8);
                    parseMethodMetadataBands += numBackwardsCallables;
                }
            }
        }
        for (int i25 = 0; i25 < this.methodAttributes.length; i25++) {
            for (int i26 = 0; i26 < this.methodAttributes[i25].length; i26++) {
                long j13 = this.methodFlags[i25][i26];
                int i27 = 0;
                for (int i28 = 0; i28 < i22; i28++) {
                    AttributeLayout attributeLayout7 = attributeLayoutArr[i28];
                    if (attributeLayout7 != null && attributeLayout7.matches(j13)) {
                        if (attributeLayoutArr[i28].getIndex() < 15) {
                            i12 = 0;
                            this.methodAttributes[i25][i26].add(i27, listArr[i28].get(0));
                            i27++;
                        } else {
                            i12 = 0;
                            this.methodAttributes[i25][i26].add(listArr[i28].get(0));
                        }
                        listArr[i28].remove(i12);
                    }
                }
            }
        }
    }

    private void parseMethodBands(InputStream inputStream) throws IOException, Pack200Exception {
        int[][] decodeBandInt = decodeBandInt("method_descr", inputStream, Codec.MDELTA5, this.classMethodCount);
        this.methodDescrInts = decodeBandInt;
        this.methodDescr = getReferences(decodeBandInt, this.cpBands.getCpDescriptor());
        parseMethodAttrBands(inputStream);
    }

    private int parseMethodMetadataBands(InputStream inputStream, int[] iArr) throws Pack200Exception, IOException {
        String[] strArr = {"RVA", "RIA", "RVPA", "RIPA", "AD"};
        int[] iArr2 = {0, 0, 0, 0, 0};
        AttributeLayout[] attributeLayoutArr = {this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT, 2)};
        for (int i11 = 0; i11 < 5; i11++) {
            iArr2[i11] = SegmentUtils.countMatches(this.methodFlags, (IMatcher) attributeLayoutArr[i11]);
        }
        int[] iArr3 = new int[5];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < 5; i14++) {
            if (iArr2[i14] > 0) {
                i12++;
                iArr3[i14] = iArr[i13];
                i13++;
            } else {
                iArr3[i14] = 0;
            }
        }
        MetadataBandGroup[] parseMetadata = parseMetadata(inputStream, strArr, iArr2, iArr3, "method");
        List[] listArr = new List[5];
        int[] iArr4 = new int[5];
        for (int i15 = 0; i15 < parseMetadata.length; i15++) {
            listArr[i15] = parseMetadata[i15].getAttributes();
            iArr4[i15] = 0;
        }
        for (int i16 = 0; i16 < this.methodFlags.length; i16++) {
            for (int i17 = 0; i17 < this.methodFlags[i16].length; i17++) {
                for (int i18 = 0; i18 < 5; i18++) {
                    if (attributeLayoutArr[i18].matches(this.methodFlags[i16][i17])) {
                        ArrayList arrayList = this.methodAttributes[i16][i17];
                        List list = listArr[i18];
                        int i19 = iArr4[i18];
                        iArr4[i18] = i19 + 1;
                        arrayList.add(list.get(i19));
                    }
                }
            }
        }
        return i12;
    }

    public ArrayList[] getClassAttributes() {
        return this.classAttributes;
    }

    public int[] getClassFieldCount() {
        return this.classFieldCount;
    }

    public long[] getClassFlags() throws Pack200Exception {
        if (this.classAccessFlags == null) {
            int i11 = 0;
            long j11 = 32767;
            for (int i12 = 0; i12 < 16; i12++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i12, 0);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j11 &= (long) (~(1 << i12));
                }
            }
            this.classAccessFlags = new long[this.classFlags.length];
            while (true) {
                long[] jArr = this.classFlags;
                if (i11 >= jArr.length) {
                    break;
                }
                this.classAccessFlags[i11] = jArr[i11] & j11;
                i11++;
            }
        }
        return this.classAccessFlags;
    }

    public int[][] getClassInterfacesInts() {
        return this.classInterfacesInts;
    }

    public int[] getClassMethodCount() {
        return this.classMethodCount;
    }

    public int[] getClassSuperInts() {
        return this.classSuperInts;
    }

    public int[] getClassThisInts() {
        return this.classThisInts;
    }

    public int[] getClassVersionMajor() {
        return this.classVersionMajor;
    }

    public int[] getClassVersionMinor() {
        return this.classVersionMinor;
    }

    public int[][] getCodeHandlerCatchPO() {
        return this.codeHandlerCatchPO;
    }

    public int[][] getCodeHandlerClassRCN() {
        return this.codeHandlerClassRCN;
    }

    public int[] getCodeHandlerCount() {
        return this.codeHandlerCount;
    }

    public int[][] getCodeHandlerEndPO() {
        return this.codeHandlerEndPO;
    }

    public int[][] getCodeHandlerStartP() {
        return this.codeHandlerStartP;
    }

    public boolean[] getCodeHasAttributes() {
        return this.codeHasAttributes;
    }

    public int[] getCodeMaxNALocals() {
        return this.codeMaxNALocals;
    }

    public int[] getCodeMaxStack() {
        return this.codeMaxStack;
    }

    public ArrayList[][] getFieldAttributes() {
        return this.fieldAttributes;
    }

    public int[][] getFieldDescrInts() {
        return this.fieldDescrInts;
    }

    public long[][] getFieldFlags() throws Pack200Exception {
        if (this.fieldAccessFlags == null) {
            long j11 = 32767;
            for (int i11 = 0; i11 < 16; i11++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i11, 1);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j11 &= (long) (~(1 << i11));
                }
            }
            this.fieldAccessFlags = new long[this.fieldFlags.length][];
            int i12 = 0;
            while (true) {
                long[][] jArr = this.fieldFlags;
                if (i12 >= jArr.length) {
                    break;
                }
                this.fieldAccessFlags[i12] = new long[jArr[i12].length];
                int i13 = 0;
                while (true) {
                    long[] jArr2 = this.fieldFlags[i12];
                    if (i13 >= jArr2.length) {
                        break;
                    }
                    this.fieldAccessFlags[i12][i13] = jArr2[i13] & j11;
                    i13++;
                }
                i12++;
            }
        }
        return this.fieldAccessFlags;
    }

    public IcTuple[][] getIcLocal() {
        return this.icLocal;
    }

    public ArrayList[][] getMethodAttributes() {
        return this.methodAttributes;
    }

    public String[][] getMethodDescr() {
        return this.methodDescr;
    }

    public int[][] getMethodDescrInts() {
        return this.methodDescrInts;
    }

    public long[][] getMethodFlags() throws Pack200Exception {
        if (this.methodAccessFlags == null) {
            long j11 = 32767;
            for (int i11 = 0; i11 < 16; i11++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i11, 2);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j11 &= (long) (~(1 << i11));
                }
            }
            this.methodAccessFlags = new long[this.methodFlags.length][];
            int i12 = 0;
            while (true) {
                long[][] jArr = this.methodFlags;
                if (i12 >= jArr.length) {
                    break;
                }
                this.methodAccessFlags[i12] = new long[jArr[i12].length];
                int i13 = 0;
                while (true) {
                    long[] jArr2 = this.methodFlags[i12];
                    if (i13 >= jArr2.length) {
                        break;
                    }
                    this.methodAccessFlags[i12][i13] = jArr2[i13] & j11;
                    i13++;
                }
                i12++;
            }
        }
        return this.methodAccessFlags;
    }

    public ArrayList getOrderedCodeAttributes() {
        ArrayList arrayList = new ArrayList(this.codeAttributes.length);
        for (int i11 = 0; i11 < this.codeAttributes.length; i11++) {
            ArrayList arrayList2 = new ArrayList(this.codeAttributes[i11].size());
            for (int i12 = 0; i12 < this.codeAttributes[i11].size(); i12++) {
                arrayList2.add((Attribute) this.codeAttributes[i11].get(i12));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public long[] getRawClassFlags() {
        return this.classFlags;
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception {
        int classCount2 = this.header.getClassCount();
        BHSDCodec bHSDCodec = Codec.DELTA5;
        int[] decodeBandInt = decodeBandInt("class_this", inputStream, bHSDCodec, classCount2);
        this.classThisInts = decodeBandInt;
        this.classThis = getReferences(decodeBandInt, this.cpBands.getCpClass());
        this.classSuperInts = decodeBandInt("class_super", inputStream, bHSDCodec, classCount2);
        this.classInterfacesInts = decodeBandInt("class_interface", inputStream, bHSDCodec, decodeBandInt("class_interface_count", inputStream, bHSDCodec, classCount2));
        this.classFieldCount = decodeBandInt("class_field_count", inputStream, bHSDCodec, classCount2);
        this.classMethodCount = decodeBandInt("class_method_count", inputStream, bHSDCodec, classCount2);
        parseFieldBands(inputStream);
        parseMethodBands(inputStream);
        parseClassAttrBands(inputStream);
        parseCodeBands(inputStream);
    }

    public void unpack() {
    }
}
