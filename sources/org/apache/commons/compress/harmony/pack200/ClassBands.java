package org.apache.commons.compress.harmony.pack200;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands;
import org.apache.commons.compress.harmony.pack200.IcBands;
import org.objectweb.asm.Label;
import u20.b;

public class ClassBands extends BandSet {
    private boolean anySyntheticClasses = false;
    private boolean anySyntheticFields = false;
    private boolean anySyntheticMethods = false;
    private final AttributeDefinitionBands attrBands;
    private final List classAttributeBands = new ArrayList();
    private final List classEnclosingMethodClass = new ArrayList();
    private final List classEnclosingMethodDesc = new ArrayList();
    private final IntList classFileVersionMajor = new IntList();
    private final IntList classFileVersionMinor = new IntList();
    private List classInnerClassesNameRUN;
    private List classInnerClassesOuterRCN;
    private final Map classReferencesInnerClass = new HashMap();
    private final List classSignature = new ArrayList();
    private final List classSourceFile = new ArrayList();
    private int[] class_InnerClasses_F;
    private int[] class_InnerClasses_N;
    private CPClass[] class_InnerClasses_RC;
    private final MetadataBandGroup class_RIA_bands;
    private final MetadataBandGroup class_RVA_bands;
    private int[] class_attr_calls;
    private final int[] class_field_count;
    private final long[] class_flags;
    private final CPClass[][] class_interface;
    private final int[] class_interface_count;
    private final int[] class_method_count;
    private final CPClass[] class_super;
    private final CPClass[] class_this;
    private final List codeAttributeBands = new ArrayList();
    private final List codeFlags = new ArrayList();
    private final List codeHandlerCatchPO = new ArrayList();
    private final List codeHandlerClass = new ArrayList();
    private final IntList codeHandlerCount = new IntList();
    private final List codeHandlerEndPO = new ArrayList();
    private final List codeHandlerStartP = new ArrayList();
    private int[] codeHeaders;
    private final List codeLineNumberTableBciP = new ArrayList();
    private final IntList codeLineNumberTableLine = new IntList();
    private final IntList codeLineNumberTableN = new IntList();
    private final List codeLocalVariableTableBciP = new ArrayList();
    private final IntList codeLocalVariableTableN = new IntList();
    private final List codeLocalVariableTableNameRU = new ArrayList();
    private final IntList codeLocalVariableTableSlot = new IntList();
    private final List codeLocalVariableTableSpanO = new ArrayList();
    private final List codeLocalVariableTableTypeRS = new ArrayList();
    private final List codeLocalVariableTypeTableBciP = new ArrayList();
    private final IntList codeLocalVariableTypeTableN = new IntList();
    private final List codeLocalVariableTypeTableNameRU = new ArrayList();
    private final IntList codeLocalVariableTypeTableSlot = new IntList();
    private final List codeLocalVariableTypeTableSpanO = new ArrayList();
    private final List codeLocalVariableTypeTableTypeRS = new ArrayList();
    private final IntList codeMaxLocals = new IntList();
    private final IntList codeMaxStack = new IntList();
    private int[] code_attr_calls;
    private final CpBands cpBands;
    private final List fieldAttributeBands = new ArrayList();
    private final List fieldConstantValueKQ = new ArrayList();
    private final List fieldSignature = new ArrayList();
    private final MetadataBandGroup field_RIA_bands;
    private final MetadataBandGroup field_RVA_bands;
    private int[] field_attr_calls;
    private final CPNameAndType[][] field_descr;
    private final long[][] field_flags;
    private int index = 0;
    private final int[] major_versions;
    private final List methodAttributeBands = new ArrayList();
    private final List methodExceptionClasses = new ArrayList();
    private final IntList methodExceptionNumber = new IntList();
    private final List methodSignature = new ArrayList();
    private final MetadataBandGroup method_AD_bands;
    private final MetadataBandGroup method_RIA_bands;
    private final MetadataBandGroup method_RIPA_bands;
    private final MetadataBandGroup method_RVA_bands;
    private final MetadataBandGroup method_RVPA_bands;
    private int[] method_attr_calls;
    private final CPNameAndType[][] method_descr;
    private final long[][] method_flags;
    private int numMethodArgs = 0;
    private final Segment segment;
    private final boolean stripDebug;
    private final List tempFieldDesc = new ArrayList();
    private final List tempFieldFlags = new ArrayList();
    private final List tempMethodDesc = new ArrayList();
    private final List tempMethodFlags = new ArrayList();
    private TempParamAnnotation tempMethodRIPA;
    private TempParamAnnotation tempMethodRVPA;

    public static class TempParamAnnotation {

        /* renamed from: a  reason: collision with root package name */
        public int f27733a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f27734b;

        /* renamed from: c  reason: collision with root package name */
        public IntList f27735c = new IntList();

        /* renamed from: d  reason: collision with root package name */
        public List f27736d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public List f27737e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public List f27738f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public List f27739g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public List f27740h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public List f27741i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        public List f27742j = new ArrayList();

        /* renamed from: k  reason: collision with root package name */
        public List f27743k = new ArrayList();

        public TempParamAnnotation(int i11) {
            this.f27733a = i11;
            this.f27734b = new int[i11];
        }

        public void addParameterAnnotation(int i11, String str, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
            int[] iArr = this.f27734b;
            iArr[i11] = iArr[i11] + 1;
            this.f27736d.add(str);
            this.f27735c.add(list.size());
            this.f27737e.addAll(list);
            this.f27738f.addAll(list2);
            this.f27739g.addAll(list3);
            this.f27740h.addAll(list4);
            this.f27741i.addAll(list5);
            this.f27742j.addAll(list6);
            this.f27743k.addAll(list7);
        }
    }

    public ClassBands(Segment segment2, int i11, int i12, boolean z11) throws IOException {
        super(i12, segment2.getSegmentHeader());
        this.stripDebug = z11;
        this.segment = segment2;
        this.cpBands = segment2.getCpBands();
        this.attrBands = segment2.getAttrBands();
        this.class_this = new CPClass[i11];
        this.class_super = new CPClass[i11];
        this.class_interface_count = new int[i11];
        this.class_interface = new CPClass[i11][];
        this.class_field_count = new int[i11];
        this.class_method_count = new int[i11];
        this.field_descr = new CPNameAndType[i11][];
        this.field_flags = new long[i11][];
        this.method_descr = new CPNameAndType[i11][];
        this.method_flags = new long[i11][];
        for (int i13 = 0; i13 < i11; i13++) {
            this.field_flags[i13] = new long[0];
            this.method_flags[i13] = new long[0];
        }
        this.major_versions = new int[i11];
        this.class_flags = new long[i11];
        this.class_RVA_bands = new MetadataBandGroup("RVA", 0, this.cpBands, this.segmentHeader, i12);
        int i14 = i12;
        this.class_RIA_bands = new MetadataBandGroup("RIA", 0, this.cpBands, this.segmentHeader, i14);
        this.field_RVA_bands = new MetadataBandGroup("RVA", 1, this.cpBands, this.segmentHeader, i12);
        this.field_RIA_bands = new MetadataBandGroup("RIA", 1, this.cpBands, this.segmentHeader, i14);
        this.method_RVA_bands = new MetadataBandGroup("RVA", 2, this.cpBands, this.segmentHeader, i12);
        this.method_RIA_bands = new MetadataBandGroup("RIA", 2, this.cpBands, this.segmentHeader, i14);
        this.method_RVPA_bands = new MetadataBandGroup("RVPA", 2, this.cpBands, this.segmentHeader, i12);
        this.method_RIPA_bands = new MetadataBandGroup("RIPA", 2, this.cpBands, this.segmentHeader, i14);
        this.method_AD_bands = new MetadataBandGroup("AD", 2, this.cpBands, this.segmentHeader, i12);
        createNewAttributeBands();
    }

    public static int countArgs(String str) {
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 < indexOf) {
            throw new IllegalArgumentException("No arguments");
        }
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        for (int i12 = indexOf + 1; i12 < indexOf2; i12++) {
            char charAt = str.charAt(i12);
            if (z11 && charAt == ';') {
                z11 = false;
                z12 = false;
            } else if (!z11 && charAt == 'L') {
                i11++;
                z11 = true;
            } else if (charAt == '[') {
                z12 = true;
            } else if (!z11) {
                if (z12) {
                    i11++;
                    z12 = false;
                } else if (charAt == 'D' || charAt == 'J') {
                    i11 += 2;
                } else {
                    i11++;
                }
            }
        }
        return i11;
    }

    private void createNewAttributeBands() throws IOException {
        for (AttributeDefinitionBands.AttributeDefinition newAttributeBands : this.attrBands.getClassAttributeLayouts()) {
            this.classAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), newAttributeBands));
        }
        for (AttributeDefinitionBands.AttributeDefinition newAttributeBands2 : this.attrBands.getMethodAttributeLayouts()) {
            this.methodAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), newAttributeBands2));
        }
        for (AttributeDefinitionBands.AttributeDefinition newAttributeBands3 : this.attrBands.getFieldAttributeLayouts()) {
            this.fieldAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), newAttributeBands3));
        }
        for (AttributeDefinitionBands.AttributeDefinition newAttributeBands4 : this.attrBands.getCodeAttributeLayouts()) {
            this.codeAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), newAttributeBands4));
        }
    }

    private int[] getInts(CPClass[] cPClassArr) {
        int length = cPClassArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            CPClass cPClass = cPClassArr[i11];
            if (cPClass != null) {
                iArr[i11] = cPClass.getIndex();
            }
        }
        return iArr;
    }

    private boolean isInnerClass(String str) {
        return str.indexOf(36) != -1;
    }

    private boolean isInnerClassOf(String str, CPClass cPClass) {
        if (!isInnerClass(str)) {
            return false;
        }
        String substring = str.substring(0, str.lastIndexOf(36));
        if (substring.equals(cPClass.toString())) {
            return true;
        }
        return isInnerClassOf(substring, cPClass);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$finaliseBands$0(Object obj, Object obj2) {
        return ((NewAttributeBands) obj).getFlagIndex() - ((NewAttributeBands) obj2).getFlagIndex();
    }

    private void renumberBci(List list, IntList intList, Map map) {
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj = list.get(size);
            if (!(obj instanceof Integer)) {
                if (obj instanceof Label) {
                    list.remove(size);
                    list.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue())));
                }
                size--;
            } else {
                return;
            }
        }
    }

    private void renumberDoubleOffsetBci(List list, List list2, List list3, IntList intList, Map map) {
        int size = list3.size() - 1;
        while (size >= 0) {
            Object obj = list3.get(size);
            if (!(obj instanceof Integer)) {
                if (obj instanceof Label) {
                    list3.remove(size);
                    list3.add(size, Integer.valueOf((intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()) - ((Integer) list2.get(size)).intValue()));
                }
                size--;
            } else {
                return;
            }
        }
    }

    private void renumberOffsetBci(List list, List list2, IntList intList, Map map) {
        int size = list2.size() - 1;
        while (size >= 0) {
            Object obj = list2.get(size);
            if (!(obj instanceof Integer)) {
                if (obj instanceof Label) {
                    list2.remove(size);
                    list2.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()));
                }
                size--;
            } else {
                return;
            }
        }
    }

    private int sum(int[] iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 += i12;
        }
        return i11;
    }

    private void writeClassAttributeBands(OutputStream outputStream) throws IOException, Pack200Exception {
        long[] jArr = this.class_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeFlags = encodeFlags("class_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_class_flags_hi());
        outputStream.write(encodeFlags);
        PackingUtils.log("Wrote " + encodeFlags.length + " bytes from class_flags[" + this.class_flags.length + "]");
        byte[] encodeBandInt = encodeBandInt("class_attr_calls", this.class_attr_calls, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from class_attr_calls[" + this.class_attr_calls.length + "]");
        byte[] encodeBandInt2 = encodeBandInt("classSourceFile", cpEntryOrNullListToArray(this.classSourceFile), bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from classSourceFile[" + this.classSourceFile.size() + "]");
        byte[] encodeBandInt3 = encodeBandInt("class_enclosing_method_RC", cpEntryListToArray(this.classEnclosingMethodClass), bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from class_enclosing_method_RC[" + this.classEnclosingMethodClass.size() + "]");
        byte[] encodeBandInt4 = encodeBandInt("class_EnclosingMethod_RDN", cpEntryOrNullListToArray(this.classEnclosingMethodDesc), bHSDCodec);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from class_EnclosingMethod_RDN[" + this.classEnclosingMethodDesc.size() + "]");
        byte[] encodeBandInt5 = encodeBandInt("class_Signature_RS", cpEntryListToArray(this.classSignature), bHSDCodec);
        outputStream.write(encodeBandInt5);
        PackingUtils.log("Wrote " + encodeBandInt5.length + " bytes from class_Signature_RS[" + this.classSignature.size() + "]");
        this.class_RVA_bands.pack(outputStream);
        this.class_RIA_bands.pack(outputStream);
        byte[] encodeBandInt6 = encodeBandInt("class_InnerClasses_N", this.class_InnerClasses_N, bHSDCodec);
        outputStream.write(encodeBandInt6);
        PackingUtils.log("Wrote " + encodeBandInt6.length + " bytes from class_InnerClasses_N[" + this.class_InnerClasses_N.length + "]");
        byte[] encodeBandInt7 = encodeBandInt("class_InnerClasses_RC", getInts(this.class_InnerClasses_RC), bHSDCodec);
        outputStream.write(encodeBandInt7);
        PackingUtils.log("Wrote " + encodeBandInt7.length + " bytes from class_InnerClasses_RC[" + this.class_InnerClasses_RC.length + "]");
        byte[] encodeBandInt8 = encodeBandInt("class_InnerClasses_F", this.class_InnerClasses_F, bHSDCodec);
        outputStream.write(encodeBandInt8);
        PackingUtils.log("Wrote " + encodeBandInt8.length + " bytes from class_InnerClasses_F[" + this.class_InnerClasses_F.length + "]");
        byte[] encodeBandInt9 = encodeBandInt("class_InnerClasses_outer_RCN", cpEntryOrNullListToArray(this.classInnerClassesOuterRCN), bHSDCodec);
        outputStream.write(encodeBandInt9);
        PackingUtils.log("Wrote " + encodeBandInt9.length + " bytes from class_InnerClasses_outer_RCN[" + this.classInnerClassesOuterRCN.size() + "]");
        byte[] encodeBandInt10 = encodeBandInt("class_InnerClasses_name_RUN", cpEntryOrNullListToArray(this.classInnerClassesNameRUN), bHSDCodec);
        outputStream.write(encodeBandInt10);
        PackingUtils.log("Wrote " + encodeBandInt10.length + " bytes from class_InnerClasses_name_RUN[" + this.classInnerClassesNameRUN.size() + "]");
        byte[] encodeBandInt11 = encodeBandInt("classFileVersionMinor", this.classFileVersionMinor.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt11);
        PackingUtils.log("Wrote " + encodeBandInt11.length + " bytes from classFileVersionMinor[" + this.classFileVersionMinor.size() + "]");
        byte[] encodeBandInt12 = encodeBandInt("classFileVersionMajor", this.classFileVersionMajor.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt12);
        PackingUtils.log("Wrote " + encodeBandInt12.length + " bytes from classFileVersionMajor[" + this.classFileVersionMajor.size() + "]");
        for (NewAttributeBands pack : this.classAttributeBands) {
            pack.pack(outputStream);
        }
    }

    private void writeCodeAttributeBands(OutputStream outputStream) throws IOException, Pack200Exception {
        long[] longListToArray = longListToArray(this.codeFlags);
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeFlags = encodeFlags("codeFlags", longListToArray, bHSDCodec, bHSDCodec, this.segmentHeader.have_code_flags_hi());
        outputStream.write(encodeFlags);
        PackingUtils.log("Wrote " + encodeFlags.length + " bytes from codeFlags[" + this.codeFlags.size() + "]");
        byte[] encodeBandInt = encodeBandInt("code_attr_calls", this.code_attr_calls, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from code_attr_calls[" + this.code_attr_calls.length + "]");
        byte[] encodeBandInt2 = encodeBandInt("code_LineNumberTable_N", this.codeLineNumberTableN.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from code_LineNumberTable_N[" + this.codeLineNumberTableN.size() + "]");
        int[] integerListToArray = integerListToArray(this.codeLineNumberTableBciP);
        BHSDCodec bHSDCodec2 = Codec.BCI5;
        byte[] encodeBandInt3 = encodeBandInt("code_LineNumberTable_bci_P", integerListToArray, bHSDCodec2);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from code_LineNumberTable_bci_P[" + this.codeLineNumberTableBciP.size() + "]");
        byte[] encodeBandInt4 = encodeBandInt("code_LineNumberTable_line", this.codeLineNumberTableLine.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from code_LineNumberTable_line[" + this.codeLineNumberTableLine.size() + "]");
        byte[] encodeBandInt5 = encodeBandInt("code_LocalVariableTable_N", this.codeLocalVariableTableN.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt5);
        PackingUtils.log("Wrote " + encodeBandInt5.length + " bytes from code_LocalVariableTable_N[" + this.codeLocalVariableTableN.size() + "]");
        byte[] encodeBandInt6 = encodeBandInt("code_LocalVariableTable_bci_P", integerListToArray(this.codeLocalVariableTableBciP), bHSDCodec2);
        outputStream.write(encodeBandInt6);
        PackingUtils.log("Wrote " + encodeBandInt6.length + " bytes from code_LocalVariableTable_bci_P[" + this.codeLocalVariableTableBciP.size() + "]");
        int[] integerListToArray2 = integerListToArray(this.codeLocalVariableTableSpanO);
        BHSDCodec bHSDCodec3 = Codec.BRANCH5;
        byte[] encodeBandInt7 = encodeBandInt("code_LocalVariableTable_span_O", integerListToArray2, bHSDCodec3);
        outputStream.write(encodeBandInt7);
        PackingUtils.log("Wrote " + encodeBandInt7.length + " bytes from code_LocalVariableTable_span_O[" + this.codeLocalVariableTableSpanO.size() + "]");
        byte[] encodeBandInt8 = encodeBandInt("code_LocalVariableTable_name_RU", cpEntryListToArray(this.codeLocalVariableTableNameRU), bHSDCodec);
        outputStream.write(encodeBandInt8);
        PackingUtils.log("Wrote " + encodeBandInt8.length + " bytes from code_LocalVariableTable_name_RU[" + this.codeLocalVariableTableNameRU.size() + "]");
        byte[] encodeBandInt9 = encodeBandInt("code_LocalVariableTable_type_RS", cpEntryListToArray(this.codeLocalVariableTableTypeRS), bHSDCodec);
        outputStream.write(encodeBandInt9);
        PackingUtils.log("Wrote " + encodeBandInt9.length + " bytes from code_LocalVariableTable_type_RS[" + this.codeLocalVariableTableTypeRS.size() + "]");
        byte[] encodeBandInt10 = encodeBandInt("code_LocalVariableTable_slot", this.codeLocalVariableTableSlot.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt10);
        PackingUtils.log("Wrote " + encodeBandInt10.length + " bytes from code_LocalVariableTable_slot[" + this.codeLocalVariableTableSlot.size() + "]");
        byte[] encodeBandInt11 = encodeBandInt("code_LocalVariableTypeTable_N", this.codeLocalVariableTypeTableN.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt11);
        PackingUtils.log("Wrote " + encodeBandInt11.length + " bytes from code_LocalVariableTypeTable_N[" + this.codeLocalVariableTypeTableN.size() + "]");
        byte[] encodeBandInt12 = encodeBandInt("code_LocalVariableTypeTable_bci_P", integerListToArray(this.codeLocalVariableTypeTableBciP), bHSDCodec2);
        outputStream.write(encodeBandInt12);
        PackingUtils.log("Wrote " + encodeBandInt12.length + " bytes from code_LocalVariableTypeTable_bci_P[" + this.codeLocalVariableTypeTableBciP.size() + "]");
        byte[] encodeBandInt13 = encodeBandInt("code_LocalVariableTypeTable_span_O", integerListToArray(this.codeLocalVariableTypeTableSpanO), bHSDCodec3);
        outputStream.write(encodeBandInt13);
        PackingUtils.log("Wrote " + encodeBandInt13.length + " bytes from code_LocalVariableTypeTable_span_O[" + this.codeLocalVariableTypeTableSpanO.size() + "]");
        byte[] encodeBandInt14 = encodeBandInt("code_LocalVariableTypeTable_name_RU", cpEntryListToArray(this.codeLocalVariableTypeTableNameRU), bHSDCodec);
        outputStream.write(encodeBandInt14);
        PackingUtils.log("Wrote " + encodeBandInt14.length + " bytes from code_LocalVariableTypeTable_name_RU[" + this.codeLocalVariableTypeTableNameRU.size() + "]");
        byte[] encodeBandInt15 = encodeBandInt("code_LocalVariableTypeTable_type_RS", cpEntryListToArray(this.codeLocalVariableTypeTableTypeRS), bHSDCodec);
        outputStream.write(encodeBandInt15);
        PackingUtils.log("Wrote " + encodeBandInt15.length + " bytes from code_LocalVariableTypeTable_type_RS[" + this.codeLocalVariableTypeTableTypeRS.size() + "]");
        byte[] encodeBandInt16 = encodeBandInt("code_LocalVariableTypeTable_slot", this.codeLocalVariableTypeTableSlot.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt16);
        PackingUtils.log("Wrote " + encodeBandInt16.length + " bytes from code_LocalVariableTypeTable_slot[" + this.codeLocalVariableTypeTableSlot.size() + "]");
        for (NewAttributeBands pack : this.codeAttributeBands) {
            pack.pack(outputStream);
        }
    }

    private void writeCodeBands(OutputStream outputStream) throws IOException, Pack200Exception {
        byte[] encodeBandInt = encodeBandInt("codeHeaders", this.codeHeaders, Codec.BYTE1);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from codeHeaders[" + this.codeHeaders.length + "]");
        int[] array = this.codeMaxStack.toArray();
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeBandInt2 = encodeBandInt("codeMaxStack", array, bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from codeMaxStack[" + this.codeMaxStack.size() + "]");
        byte[] encodeBandInt3 = encodeBandInt("codeMaxLocals", this.codeMaxLocals.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from codeMaxLocals[" + this.codeMaxLocals.size() + "]");
        byte[] encodeBandInt4 = encodeBandInt("codeHandlerCount", this.codeHandlerCount.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from codeHandlerCount[" + this.codeHandlerCount.size() + "]");
        byte[] encodeBandInt5 = encodeBandInt("codeHandlerStartP", integerListToArray(this.codeHandlerStartP), Codec.BCI5);
        outputStream.write(encodeBandInt5);
        PackingUtils.log("Wrote " + encodeBandInt5.length + " bytes from codeHandlerStartP[" + this.codeHandlerStartP.size() + "]");
        int[] integerListToArray = integerListToArray(this.codeHandlerEndPO);
        BHSDCodec bHSDCodec2 = Codec.BRANCH5;
        byte[] encodeBandInt6 = encodeBandInt("codeHandlerEndPO", integerListToArray, bHSDCodec2);
        outputStream.write(encodeBandInt6);
        PackingUtils.log("Wrote " + encodeBandInt6.length + " bytes from codeHandlerEndPO[" + this.codeHandlerEndPO.size() + "]");
        byte[] encodeBandInt7 = encodeBandInt("codeHandlerCatchPO", integerListToArray(this.codeHandlerCatchPO), bHSDCodec2);
        outputStream.write(encodeBandInt7);
        PackingUtils.log("Wrote " + encodeBandInt7.length + " bytes from codeHandlerCatchPO[" + this.codeHandlerCatchPO.size() + "]");
        byte[] encodeBandInt8 = encodeBandInt("codeHandlerClass", cpEntryOrNullListToArray(this.codeHandlerClass), bHSDCodec);
        outputStream.write(encodeBandInt8);
        PackingUtils.log("Wrote " + encodeBandInt8.length + " bytes from codeHandlerClass[" + this.codeHandlerClass.size() + "]");
        writeCodeAttributeBands(outputStream);
    }

    private void writeFieldAttributeBands(OutputStream outputStream) throws IOException, Pack200Exception {
        long[][] jArr = this.field_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeFlags = encodeFlags("field_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_field_flags_hi());
        outputStream.write(encodeFlags);
        PackingUtils.log("Wrote " + encodeFlags.length + " bytes from field_flags[" + this.field_flags.length + "]");
        byte[] encodeBandInt = encodeBandInt("field_attr_calls", this.field_attr_calls, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from field_attr_calls[" + this.field_attr_calls.length + "]");
        byte[] encodeBandInt2 = encodeBandInt("fieldConstantValueKQ", cpEntryListToArray(this.fieldConstantValueKQ), bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from fieldConstantValueKQ[" + this.fieldConstantValueKQ.size() + "]");
        byte[] encodeBandInt3 = encodeBandInt("fieldSignature", cpEntryListToArray(this.fieldSignature), bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from fieldSignature[" + this.fieldSignature.size() + "]");
        this.field_RVA_bands.pack(outputStream);
        this.field_RIA_bands.pack(outputStream);
        for (NewAttributeBands pack : this.fieldAttributeBands) {
            pack.pack(outputStream);
        }
    }

    private void writeMethodAttributeBands(OutputStream outputStream) throws IOException, Pack200Exception {
        long[][] jArr = this.method_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeFlags = encodeFlags("method_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_method_flags_hi());
        outputStream.write(encodeFlags);
        PackingUtils.log("Wrote " + encodeFlags.length + " bytes from method_flags[" + this.method_flags.length + "]");
        byte[] encodeBandInt = encodeBandInt("method_attr_calls", this.method_attr_calls, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from method_attr_calls[" + this.method_attr_calls.length + "]");
        byte[] encodeBandInt2 = encodeBandInt("methodExceptionNumber", this.methodExceptionNumber.toArray(), bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from methodExceptionNumber[" + this.methodExceptionNumber.size() + "]");
        byte[] encodeBandInt3 = encodeBandInt("methodExceptionClasses", cpEntryListToArray(this.methodExceptionClasses), bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from methodExceptionClasses[" + this.methodExceptionClasses.size() + "]");
        byte[] encodeBandInt4 = encodeBandInt("methodSignature", cpEntryListToArray(this.methodSignature), bHSDCodec);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from methodSignature[" + this.methodSignature.size() + "]");
        this.method_RVA_bands.pack(outputStream);
        this.method_RIA_bands.pack(outputStream);
        this.method_RVPA_bands.pack(outputStream);
        this.method_RIPA_bands.pack(outputStream);
        this.method_AD_bands.pack(outputStream);
        for (NewAttributeBands pack : this.methodAttributeBands) {
            pack.pack(outputStream);
        }
    }

    public void addAnnotation(int i11, String str, boolean z11, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        int i12 = i11;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    if (z11) {
                        this.method_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                        List list8 = this.tempMethodFlags;
                        Long l11 = (Long) list8.remove(list8.size() - 1);
                        if ((l11.intValue() & 2097152) != 0) {
                            this.method_RVA_bands.incrementAnnoN();
                        } else {
                            this.method_RVA_bands.newEntryInAnnoN();
                        }
                        this.tempMethodFlags.add(Long.valueOf((long) (l11.intValue() | 2097152)));
                        return;
                    }
                    this.method_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                    List list9 = this.tempMethodFlags;
                    Long l12 = (Long) list9.remove(list9.size() - 1);
                    if ((l12.intValue() & 4194304) != 0) {
                        this.method_RIA_bands.incrementAnnoN();
                    } else {
                        this.method_RIA_bands.newEntryInAnnoN();
                    }
                    this.tempMethodFlags.add(Long.valueOf((long) (l12.intValue() | 4194304)));
                }
            } else if (z11) {
                this.field_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                List list10 = this.tempFieldFlags;
                Long l13 = (Long) list10.remove(list10.size() - 1);
                if ((l13.intValue() & 2097152) != 0) {
                    this.field_RVA_bands.incrementAnnoN();
                } else {
                    this.field_RVA_bands.newEntryInAnnoN();
                }
                this.tempFieldFlags.add(Long.valueOf((long) (l13.intValue() | 2097152)));
            } else {
                this.field_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                List list11 = this.tempFieldFlags;
                Long l14 = (Long) list11.remove(list11.size() - 1);
                if ((l14.intValue() & 4194304) != 0) {
                    this.field_RIA_bands.incrementAnnoN();
                } else {
                    this.field_RIA_bands.newEntryInAnnoN();
                }
                this.tempFieldFlags.add(Long.valueOf((long) (l14.intValue() | 4194304)));
            }
        } else if (z11) {
            this.class_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
            if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                this.class_RVA_bands.incrementAnnoN();
                return;
            }
            this.class_RVA_bands.newEntryInAnnoN();
            long[] jArr = this.class_flags;
            int i13 = this.index;
            jArr[i13] = jArr[i13] | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        } else {
            this.class_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
            if ((this.class_flags[this.index] & 4194304) != 0) {
                this.class_RIA_bands.incrementAnnoN();
                return;
            }
            this.class_RIA_bands.newEntryInAnnoN();
            long[] jArr2 = this.class_flags;
            int i14 = this.index;
            jArr2[i14] = jArr2[i14] | 4194304;
        }
    }

    public void addAnnotationDefault(List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        this.method_AD_bands.addAnnotation((String) null, list, list2, list3, list4, list5, list6, list7);
        List list8 = this.tempMethodFlags;
        this.tempMethodFlags.add(Long.valueOf(((Long) list8.remove(list8.size() - 1)).longValue() | 33554432));
    }

    public void addClass(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        this.class_this[this.index] = this.cpBands.getCPClass(str);
        this.class_super[this.index] = this.cpBands.getCPClass(str3);
        int[] iArr = this.class_interface_count;
        int i13 = this.index;
        iArr[i13] = strArr.length;
        this.class_interface[i13] = new CPClass[strArr.length];
        for (int i14 = 0; i14 < strArr.length; i14++) {
            this.class_interface[this.index][i14] = this.cpBands.getCPClass(strArr[i14]);
        }
        int[] iArr2 = this.major_versions;
        int i15 = this.index;
        iArr2[i15] = i11;
        this.class_flags[i15] = (long) i12;
        if (!this.anySyntheticClasses && (i12 & 4096) != 0 && this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            this.cpBands.addCPUtf8("Synthetic");
            this.anySyntheticClasses = true;
        }
        if (str2 != null) {
            long[] jArr = this.class_flags;
            int i16 = this.index;
            jArr[i16] = jArr[i16] | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            this.classSignature.add(this.cpBands.getCPSignature(str2));
        }
    }

    public void addClassAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.classAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                long[] jArr = this.class_flags;
                int i11 = this.index;
                jArr[i11] = jArr[i11] | ((long) (1 << flagIndex));
                return;
            }
        }
        throw new RuntimeException("No suitable definition for " + str);
    }

    public void addCode() {
        this.codeHandlerCount.add(0);
        if (!this.stripDebug) {
            this.codeFlags.add(4L);
            this.codeLocalVariableTableN.add(0);
        }
    }

    public void addCodeAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.codeAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.codeFlags;
                this.codeFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException("No suitable definition for " + str);
    }

    public void addEnclosingMethod(String str, String str2, String str3) {
        CPNameAndType cPNameAndType;
        long[] jArr = this.class_flags;
        int i11 = this.index;
        jArr[i11] = jArr[i11] | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.classEnclosingMethodClass.add(this.cpBands.getCPClass(str));
        List list = this.classEnclosingMethodDesc;
        if (str2 == null) {
            cPNameAndType = null;
        } else {
            cPNameAndType = this.cpBands.getCPNameAndType(str2, str3);
        }
        list.add(cPNameAndType);
    }

    public void addField(int i11, String str, String str2, String str3, Object obj) {
        int i12 = i11 & 65535;
        this.tempFieldDesc.add(this.cpBands.getCPNameAndType(str, str2));
        if (str3 != null) {
            this.fieldSignature.add(this.cpBands.getCPSignature(str3));
            i12 |= 524288;
        }
        if ((i12 & 131072) != 0) {
            i12 = (i12 & -131073) | 1048576;
        }
        if (obj != null) {
            this.fieldConstantValueKQ.add(this.cpBands.getConstant(obj));
            i12 |= 131072;
        }
        if (!this.anySyntheticFields && (i12 & 4096) != 0 && this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            this.cpBands.addCPUtf8("Synthetic");
            this.anySyntheticFields = true;
        }
        this.tempFieldFlags.add(Long.valueOf((long) i12));
    }

    public void addFieldAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.fieldAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.tempFieldFlags;
                this.tempFieldFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException("No suitable definition for " + str);
    }

    public void addHandler(Label label, Label label2, Label label3, String str) {
        CPClass cPClass;
        IntList intList = this.codeHandlerCount;
        this.codeHandlerCount.add(intList.remove(intList.size() - 1) + 1);
        this.codeHandlerStartP.add(label);
        this.codeHandlerEndPO.add(label2);
        this.codeHandlerCatchPO.add(label3);
        List list = this.codeHandlerClass;
        if (str == null) {
            cPClass = null;
        } else {
            cPClass = this.cpBands.getCPClass(str);
        }
        list.add(cPClass);
    }

    public void addLineNumber(int i11, Label label) {
        List list = this.codeFlags;
        Long l11 = (Long) list.get(list.size() - 1);
        if ((l11.intValue() & 2) == 0) {
            List list2 = this.codeFlags;
            list2.remove(list2.size() - 1);
            this.codeFlags.add(Long.valueOf((long) (l11.intValue() | 2)));
            this.codeLineNumberTableN.add(1);
        } else {
            IntList intList = this.codeLineNumberTableN;
            intList.increment(intList.size() - 1);
        }
        this.codeLineNumberTableLine.add(i11);
        this.codeLineNumberTableBciP.add(label);
    }

    public void addLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
        if (str3 != null) {
            List list = this.codeFlags;
            Long l11 = (Long) list.get(list.size() - 1);
            if ((l11.intValue() & 8) == 0) {
                List list2 = this.codeFlags;
                list2.remove(list2.size() - 1);
                this.codeFlags.add(Long.valueOf((long) (l11.intValue() | 8)));
                this.codeLocalVariableTypeTableN.add(1);
            } else {
                IntList intList = this.codeLocalVariableTypeTableN;
                intList.increment(intList.size() - 1);
            }
            this.codeLocalVariableTypeTableBciP.add(label);
            this.codeLocalVariableTypeTableSpanO.add(label2);
            this.codeLocalVariableTypeTableNameRU.add(this.cpBands.getCPUtf8(str));
            this.codeLocalVariableTypeTableTypeRS.add(this.cpBands.getCPSignature(str3));
            this.codeLocalVariableTypeTableSlot.add(i11);
        }
        IntList intList2 = this.codeLocalVariableTableN;
        intList2.increment(intList2.size() - 1);
        this.codeLocalVariableTableBciP.add(label);
        this.codeLocalVariableTableSpanO.add(label2);
        this.codeLocalVariableTableNameRU.add(this.cpBands.getCPUtf8(str));
        this.codeLocalVariableTableTypeRS.add(this.cpBands.getCPSignature(str2));
        this.codeLocalVariableTableSlot.add(i11);
    }

    public void addMaxStack(int i11, int i12) {
        List list = this.tempMethodFlags;
        Long valueOf = Long.valueOf((long) (((Long) list.remove(list.size() - 1)).intValue() | 131072));
        this.tempMethodFlags.add(valueOf);
        this.codeMaxStack.add(i11);
        if ((valueOf.longValue() & 8) == 0) {
            i12--;
        }
        this.codeMaxLocals.add(i12 - this.numMethodArgs);
    }

    public void addMethod(int i11, String str, String str2, String str3, String[] strArr) {
        this.tempMethodDesc.add(this.cpBands.getCPNameAndType(str, str2));
        if (str3 != null) {
            this.methodSignature.add(this.cpBands.getCPSignature(str3));
            i11 |= 524288;
        }
        if (strArr != null) {
            this.methodExceptionNumber.add(strArr.length);
            for (String cPClass : strArr) {
                this.methodExceptionClasses.add(this.cpBands.getCPClass(cPClass));
            }
            i11 |= 262144;
        }
        if ((131072 & i11) != 0) {
            i11 = (i11 & -131073) | 1048576;
        }
        this.tempMethodFlags.add(Long.valueOf((long) i11));
        this.numMethodArgs = countArgs(str2);
        if (!this.anySyntheticMethods && (i11 & 4096) != 0 && this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            this.cpBands.addCPUtf8("Synthetic");
            this.anySyntheticMethods = true;
        }
    }

    public void addMethodAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.methodAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.tempMethodFlags;
                this.tempMethodFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException("No suitable definition for " + str);
    }

    public void addParameterAnnotation(int i11, String str, boolean z11, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        if (z11) {
            if (this.tempMethodRVPA == null) {
                TempParamAnnotation tempParamAnnotation = new TempParamAnnotation(this.numMethodArgs);
                this.tempMethodRVPA = tempParamAnnotation;
                tempParamAnnotation.addParameterAnnotation(i11, str, list, list2, list3, list4, list5, list6, list7);
            }
            List list8 = this.tempMethodFlags;
            this.tempMethodFlags.add(Long.valueOf(((Long) list8.remove(list8.size() - 1)).longValue() | 8388608));
            return;
        }
        if (this.tempMethodRIPA == null) {
            TempParamAnnotation tempParamAnnotation2 = new TempParamAnnotation(this.numMethodArgs);
            this.tempMethodRIPA = tempParamAnnotation2;
            tempParamAnnotation2.addParameterAnnotation(i11, str, list, list2, list3, list4, list5, list6, list7);
        }
        List list9 = this.tempMethodFlags;
        this.tempMethodFlags.add(Long.valueOf(((Long) list9.remove(list9.size() - 1)).longValue() | 16777216));
    }

    public void addSourceFile(String str) {
        String cPClass = this.class_this[this.index].toString();
        if (cPClass.indexOf(36) != -1) {
            cPClass = cPClass.substring(0, cPClass.indexOf(36));
        }
        if (str.equals(cPClass.substring(cPClass.lastIndexOf(47) + 1) + ".java")) {
            this.classSourceFile.add((Object) null);
        } else {
            this.classSourceFile.add(this.cpBands.getCPUtf8(str));
        }
        long[] jArr = this.class_flags;
        int i11 = this.index;
        jArr[i11] = jArr[i11] | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
    }

    public void currentClassReferencesInnerClass(CPClass cPClass) {
        CPClass cPClass2;
        int i11 = this.index;
        CPClass[] cPClassArr = this.class_this;
        if (i11 < cPClassArr.length && (cPClass2 = cPClassArr[i11]) != null && !cPClass2.equals(cPClass) && !isInnerClassOf(cPClass2.toString(), cPClass)) {
            Set set = (Set) this.classReferencesInnerClass.get(cPClass2);
            if (set == null) {
                set = new HashSet();
                this.classReferencesInnerClass.put(cPClass2, set);
            }
            set.add(cPClass);
        }
    }

    public void doBciRenumbering(IntList intList, Map map) {
        renumberBci(this.codeLineNumberTableBciP, intList, map);
        renumberBci(this.codeLocalVariableTableBciP, intList, map);
        renumberOffsetBci(this.codeLocalVariableTableBciP, this.codeLocalVariableTableSpanO, intList, map);
        renumberBci(this.codeLocalVariableTypeTableBciP, intList, map);
        renumberOffsetBci(this.codeLocalVariableTypeTableBciP, this.codeLocalVariableTypeTableSpanO, intList, map);
        renumberBci(this.codeHandlerStartP, intList, map);
        renumberOffsetBci(this.codeHandlerStartP, this.codeHandlerEndPO, intList, map);
        renumberDoubleOffsetBci(this.codeHandlerStartP, this.codeHandlerEndPO, this.codeHandlerCatchPO, intList, map);
        for (NewAttributeBands renumberBci : this.classAttributeBands) {
            renumberBci.renumberBci(intList, map);
        }
        for (NewAttributeBands renumberBci2 : this.methodAttributeBands) {
            renumberBci2.renumberBci(intList, map);
        }
        for (NewAttributeBands renumberBci3 : this.fieldAttributeBands) {
            renumberBci3.renumberBci(intList, map);
        }
        for (NewAttributeBands renumberBci4 : this.codeAttributeBands) {
            renumberBci4.renumberBci(intList, map);
        }
    }

    public void endOfClass() {
        int size = this.tempFieldDesc.size();
        int[] iArr = this.class_field_count;
        int i11 = this.index;
        iArr[i11] = size;
        this.field_descr[i11] = new CPNameAndType[size];
        this.field_flags[i11] = new long[size];
        for (int i12 = 0; i12 < size; i12++) {
            this.field_descr[this.index][i12] = (CPNameAndType) this.tempFieldDesc.get(i12);
            this.field_flags[this.index][i12] = ((Long) this.tempFieldFlags.get(i12)).longValue();
        }
        int size2 = this.tempMethodDesc.size();
        int[] iArr2 = this.class_method_count;
        int i13 = this.index;
        iArr2[i13] = size2;
        this.method_descr[i13] = new CPNameAndType[size2];
        this.method_flags[i13] = new long[size2];
        for (int i14 = 0; i14 < size2; i14++) {
            this.method_descr[this.index][i14] = (CPNameAndType) this.tempMethodDesc.get(i14);
            this.method_flags[this.index][i14] = ((Long) this.tempMethodFlags.get(i14)).longValue();
        }
        this.tempFieldDesc.clear();
        this.tempFieldFlags.clear();
        this.tempMethodDesc.clear();
        this.tempMethodFlags.clear();
        this.index++;
    }

    public void endOfMethod() {
        TempParamAnnotation tempParamAnnotation = this.tempMethodRVPA;
        if (tempParamAnnotation != null) {
            this.method_RVPA_bands.addParameterAnnotation(tempParamAnnotation.f27733a, tempParamAnnotation.f27734b, tempParamAnnotation.f27735c, tempParamAnnotation.f27736d, tempParamAnnotation.f27737e, tempParamAnnotation.f27738f, tempParamAnnotation.f27739g, tempParamAnnotation.f27740h, tempParamAnnotation.f27741i, tempParamAnnotation.f27742j, tempParamAnnotation.f27743k);
            this.tempMethodRVPA = null;
        }
        TempParamAnnotation tempParamAnnotation2 = this.tempMethodRIPA;
        if (tempParamAnnotation2 != null) {
            this.method_RIPA_bands.addParameterAnnotation(tempParamAnnotation2.f27733a, tempParamAnnotation2.f27734b, tempParamAnnotation2.f27735c, tempParamAnnotation2.f27736d, tempParamAnnotation2.f27737e, tempParamAnnotation2.f27738f, tempParamAnnotation2.f27739g, tempParamAnnotation2.f27740h, tempParamAnnotation2.f27741i, tempParamAnnotation2.f27742j, tempParamAnnotation2.f27743k);
            this.tempMethodRIPA = null;
        }
        if (this.codeFlags.size() > 0) {
            List list = this.codeFlags;
            long longValue = ((Long) list.get(list.size() - 1)).longValue();
            IntList intList = this.codeLocalVariableTableN;
            int i11 = intList.get(intList.size() - 1);
            if (longValue == 4 && i11 == 0) {
                IntList intList2 = this.codeLocalVariableTableN;
                intList2.remove(intList2.size() - 1);
                List list2 = this.codeFlags;
                list2.remove(list2.size() - 1);
                this.codeFlags.add(0);
            }
        }
    }

    public void finaliseBands() {
        int i11;
        int defaultMajorVersion = this.segmentHeader.getDefaultMajorVersion();
        int i12 = 0;
        while (true) {
            long[] jArr = this.class_flags;
            if (i12 >= jArr.length) {
                break;
            }
            int i13 = this.major_versions[i12];
            if (i13 != defaultMajorVersion) {
                jArr[i12] = jArr[i12] | 16777216;
                this.classFileVersionMajor.add(i13);
                this.classFileVersionMinor.add(0);
            }
            i12++;
        }
        this.codeHeaders = new int[this.codeHandlerCount.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < this.codeHeaders.length; i15++) {
            int i16 = i15 - i14;
            int i17 = this.codeHandlerCount.get(i16);
            int i18 = this.codeMaxLocals.get(i16);
            int i19 = this.codeMaxStack.get(i16);
            if (i17 == 0) {
                int i21 = (i18 * 12) + i19 + 1;
                if (i21 < 145 && i19 < 12) {
                    this.codeHeaders[i15] = i21;
                }
            } else if (i17 == 1) {
                int i22 = (i18 * 8) + i19 + Opcodes.I2B;
                if (i22 < 209 && i19 < 8) {
                    this.codeHeaders[i15] = i22;
                }
            } else if (i17 == 2 && (i11 = (i18 * 7) + i19 + 209) < 256 && i19 < 7) {
                this.codeHeaders[i15] = i11;
            }
            if (this.codeHeaders[i15] != 0) {
                this.codeHandlerCount.remove(i16);
                this.codeMaxLocals.remove(i16);
                this.codeMaxStack.remove(i16);
                i14++;
            } else if (!this.segment.getSegmentHeader().have_all_code_flags()) {
                this.codeFlags.add(0L);
            }
        }
        IntList intList = new IntList();
        ArrayList arrayList = new ArrayList();
        int i23 = 0;
        while (true) {
            CPClass[] cPClassArr = this.class_this;
            if (i23 >= cPClassArr.length) {
                break;
            }
            CPClass cPClass = cPClassArr[i23];
            Set<CPClass> set = (Set) this.classReferencesInnerClass.get(cPClass);
            if (set != null) {
                List<IcBands.IcTuple> innerClassesForOuter = this.segment.getIcBands().getInnerClassesForOuter(cPClass.toString());
                if (innerClassesForOuter != null) {
                    for (IcBands.IcTuple icTuple : innerClassesForOuter) {
                        set.remove(icTuple.f27744b);
                    }
                }
                int i24 = 0;
                for (CPClass icTuple2 : set) {
                    IcBands.IcTuple icTuple3 = this.segment.getIcBands().getIcTuple(icTuple2);
                    if (icTuple3 != null && !icTuple3.isAnonymous()) {
                        arrayList.add(icTuple3);
                        i24++;
                    }
                }
                if (i24 != 0) {
                    intList.add(i24);
                    long[] jArr2 = this.class_flags;
                    jArr2[i23] = jArr2[i23] | 8388608;
                }
            }
            i23++;
        }
        this.class_InnerClasses_N = intList.toArray();
        this.class_InnerClasses_RC = new CPClass[arrayList.size()];
        this.class_InnerClasses_F = new int[arrayList.size()];
        this.classInnerClassesOuterRCN = new ArrayList();
        this.classInnerClassesNameRUN = new ArrayList();
        for (int i25 = 0; i25 < this.class_InnerClasses_RC.length; i25++) {
            IcBands.IcTuple icTuple4 = (IcBands.IcTuple) arrayList.get(i25);
            this.class_InnerClasses_RC[i25] = icTuple4.f27744b;
            CPClass cPClass2 = icTuple4.f27746d;
            if (cPClass2 == null && icTuple4.f27747e == null) {
                this.class_InnerClasses_F[i25] = 0;
            } else {
                int i26 = icTuple4.f27745c;
                if (i26 == 0) {
                    this.class_InnerClasses_F[i25] = 65536;
                } else {
                    this.class_InnerClasses_F[i25] = i26;
                }
                this.classInnerClassesOuterRCN.add(cPClass2);
                this.classInnerClassesNameRUN.add(icTuple4.f27747e);
            }
        }
        IntList intList2 = new IntList();
        IntList intList3 = new IntList();
        IntList intList4 = new IntList();
        IntList intList5 = new IntList();
        if (this.class_RVA_bands.hasContent()) {
            intList2.add(this.class_RVA_bands.numBackwardsCalls());
        }
        if (this.class_RIA_bands.hasContent()) {
            intList2.add(this.class_RIA_bands.numBackwardsCalls());
        }
        if (this.field_RVA_bands.hasContent()) {
            intList3.add(this.field_RVA_bands.numBackwardsCalls());
        }
        if (this.field_RIA_bands.hasContent()) {
            intList3.add(this.field_RIA_bands.numBackwardsCalls());
        }
        if (this.method_RVA_bands.hasContent()) {
            intList4.add(this.method_RVA_bands.numBackwardsCalls());
        }
        if (this.method_RIA_bands.hasContent()) {
            intList4.add(this.method_RIA_bands.numBackwardsCalls());
        }
        if (this.method_RVPA_bands.hasContent()) {
            intList4.add(this.method_RVPA_bands.numBackwardsCalls());
        }
        if (this.method_RIPA_bands.hasContent()) {
            intList4.add(this.method_RIPA_bands.numBackwardsCalls());
        }
        if (this.method_AD_bands.hasContent()) {
            intList4.add(this.method_AD_bands.numBackwardsCalls());
        }
        b bVar = new b();
        Collections.sort(this.classAttributeBands, bVar);
        Collections.sort(this.methodAttributeBands, bVar);
        Collections.sort(this.fieldAttributeBands, bVar);
        Collections.sort(this.codeAttributeBands, bVar);
        for (NewAttributeBands newAttributeBands : this.classAttributeBands) {
            if (newAttributeBands.isUsedAtLeastOnce()) {
                int[] numBackwardsCalls = newAttributeBands.numBackwardsCalls();
                for (int add : numBackwardsCalls) {
                    intList2.add(add);
                }
            }
        }
        for (NewAttributeBands newAttributeBands2 : this.methodAttributeBands) {
            if (newAttributeBands2.isUsedAtLeastOnce()) {
                int[] numBackwardsCalls2 = newAttributeBands2.numBackwardsCalls();
                for (int add2 : numBackwardsCalls2) {
                    intList4.add(add2);
                }
            }
        }
        for (NewAttributeBands newAttributeBands3 : this.fieldAttributeBands) {
            if (newAttributeBands3.isUsedAtLeastOnce()) {
                int[] numBackwardsCalls3 = newAttributeBands3.numBackwardsCalls();
                for (int add3 : numBackwardsCalls3) {
                    intList3.add(add3);
                }
            }
        }
        for (NewAttributeBands newAttributeBands4 : this.codeAttributeBands) {
            if (newAttributeBands4.isUsedAtLeastOnce()) {
                int[] numBackwardsCalls4 = newAttributeBands4.numBackwardsCalls();
                for (int add4 : numBackwardsCalls4) {
                    intList5.add(add4);
                }
            }
        }
        this.class_attr_calls = intList2.toArray();
        this.field_attr_calls = intList3.toArray();
        this.method_attr_calls = intList4.toArray();
        this.code_attr_calls = intList5.toArray();
    }

    public boolean isAnySyntheticClasses() {
        return this.anySyntheticClasses;
    }

    public boolean isAnySyntheticFields() {
        return this.anySyntheticFields;
    }

    public boolean isAnySyntheticMethods() {
        return this.anySyntheticMethods;
    }

    public int numClassesProcessed() {
        return this.index;
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        PackingUtils.log("Writing class bands...");
        int[] ints = getInts(this.class_this);
        BHSDCodec bHSDCodec = Codec.DELTA5;
        byte[] encodeBandInt = encodeBandInt("class_this", ints, bHSDCodec);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from class_this[" + this.class_this.length + "]");
        byte[] encodeBandInt2 = encodeBandInt("class_super", getInts(this.class_super), bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from class_super[" + this.class_super.length + "]");
        byte[] encodeBandInt3 = encodeBandInt("class_interface_count", this.class_interface_count, bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from class_interface_count[" + this.class_interface_count.length + "]");
        int sum = sum(this.class_interface_count);
        int[] iArr = new int[sum];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            CPClass[][] cPClassArr = this.class_interface;
            if (i11 >= cPClassArr.length) {
                break;
            }
            if (cPClassArr[i11] != null) {
                int i13 = 0;
                while (true) {
                    CPClass[] cPClassArr2 = this.class_interface[i11];
                    if (i13 >= cPClassArr2.length) {
                        break;
                    }
                    iArr[i12] = cPClassArr2[i13].getIndex();
                    i12++;
                    i13++;
                }
            }
            i11++;
        }
        BHSDCodec bHSDCodec2 = Codec.DELTA5;
        byte[] encodeBandInt4 = encodeBandInt("class_interface", iArr, bHSDCodec2);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from class_interface[" + sum + "]");
        byte[] encodeBandInt5 = encodeBandInt("class_field_count", this.class_field_count, bHSDCodec2);
        outputStream.write(encodeBandInt5);
        PackingUtils.log("Wrote " + encodeBandInt5.length + " bytes from class_field_count[" + this.class_field_count.length + "]");
        byte[] encodeBandInt6 = encodeBandInt("class_method_count", this.class_method_count, bHSDCodec2);
        outputStream.write(encodeBandInt6);
        PackingUtils.log("Wrote " + encodeBandInt6.length + " bytes from class_method_count[" + this.class_method_count.length + "]");
        int sum2 = sum(this.class_field_count);
        int[] iArr2 = new int[sum2];
        int i14 = 0;
        for (int i15 = 0; i15 < this.index; i15++) {
            int i16 = 0;
            while (true) {
                CPNameAndType[] cPNameAndTypeArr = this.field_descr[i15];
                if (i16 >= cPNameAndTypeArr.length) {
                    break;
                }
                iArr2[i14] = cPNameAndTypeArr[i16].getIndex();
                i14++;
                i16++;
            }
        }
        byte[] encodeBandInt7 = encodeBandInt("field_descr", iArr2, Codec.DELTA5);
        outputStream.write(encodeBandInt7);
        PackingUtils.log("Wrote " + encodeBandInt7.length + " bytes from field_descr[" + sum2 + "]");
        writeFieldAttributeBands(outputStream);
        int sum3 = sum(this.class_method_count);
        int[] iArr3 = new int[sum3];
        int i17 = 0;
        for (int i18 = 0; i18 < this.index; i18++) {
            int i19 = 0;
            while (true) {
                CPNameAndType[] cPNameAndTypeArr2 = this.method_descr[i18];
                if (i19 >= cPNameAndTypeArr2.length) {
                    break;
                }
                iArr3[i17] = cPNameAndTypeArr2[i19].getIndex();
                i17++;
                i19++;
            }
        }
        byte[] encodeBandInt8 = encodeBandInt("method_descr", iArr3, Codec.MDELTA5);
        outputStream.write(encodeBandInt8);
        PackingUtils.log("Wrote " + encodeBandInt8.length + " bytes from method_descr[" + sum3 + "]");
        writeMethodAttributeBands(outputStream);
        writeClassAttributeBands(outputStream);
        writeCodeBands(outputStream);
    }

    public void removeCurrentClass() {
        long j11 = this.class_flags[this.index];
        long j12 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if ((j11 & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
            List list = this.classSourceFile;
            list.remove(list.size() - 1);
        }
        if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
            List list2 = this.classEnclosingMethodClass;
            list2.remove(list2.size() - 1);
            List list3 = this.classEnclosingMethodDesc;
            list3.remove(list3.size() - 1);
        }
        long j13 = this.class_flags[this.index];
        long j14 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        if ((j13 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
            List list4 = this.classSignature;
            list4.remove(list4.size() - 1);
        }
        if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
            this.class_RVA_bands.removeLatest();
        }
        if ((this.class_flags[this.index] & 4194304) != 0) {
            this.class_RIA_bands.removeLatest();
        }
        for (Long longValue : this.tempFieldFlags) {
            long longValue2 = longValue.longValue();
            if ((longValue2 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                List list5 = this.fieldSignature;
                list5.remove(list5.size() - 1);
            }
            if ((longValue2 & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
                List list6 = this.fieldConstantValueKQ;
                list6.remove(list6.size() - 1);
            }
            if ((longValue2 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                this.field_RVA_bands.removeLatest();
            }
            if ((longValue2 & 4194304) != 0) {
                this.field_RIA_bands.removeLatest();
            }
        }
        for (Long longValue3 : this.tempMethodFlags) {
            long longValue4 = longValue3.longValue();
            if ((longValue4 & j14) != 0) {
                List list7 = this.methodSignature;
                list7.remove(list7.size() - 1);
            }
            if ((longValue4 & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                IntList intList = this.methodExceptionNumber;
                int remove = intList.remove(intList.size() - 1);
                for (int i11 = 0; i11 < remove; i11++) {
                    List list8 = this.methodExceptionClasses;
                    list8.remove(list8.size() - 1);
                }
            }
            if ((longValue4 & j12) != 0) {
                IntList intList2 = this.codeMaxLocals;
                intList2.remove(intList2.size() - 1);
                IntList intList3 = this.codeMaxStack;
                intList3.remove(intList3.size() - 1);
                IntList intList4 = this.codeHandlerCount;
                int remove2 = intList4.remove(intList4.size() - 1);
                for (int i12 = 0; i12 < remove2; i12++) {
                    int size = this.codeHandlerStartP.size() - 1;
                    this.codeHandlerStartP.remove(size);
                    this.codeHandlerEndPO.remove(size);
                    this.codeHandlerCatchPO.remove(size);
                    this.codeHandlerClass.remove(size);
                }
                if (!this.stripDebug) {
                    List list9 = this.codeFlags;
                    long longValue5 = ((Long) list9.remove(list9.size() - 1)).longValue();
                    IntList intList5 = this.codeLocalVariableTableN;
                    int remove3 = intList5.remove(intList5.size() - 1);
                    for (int i13 = 0; i13 < remove3; i13++) {
                        int size2 = this.codeLocalVariableTableBciP.size() - 1;
                        this.codeLocalVariableTableBciP.remove(size2);
                        this.codeLocalVariableTableSpanO.remove(size2);
                        this.codeLocalVariableTableNameRU.remove(size2);
                        this.codeLocalVariableTableTypeRS.remove(size2);
                        this.codeLocalVariableTableSlot.remove(size2);
                    }
                    if ((8 & longValue5) != 0) {
                        IntList intList6 = this.codeLocalVariableTypeTableN;
                        int remove4 = intList6.remove(intList6.size() - 1);
                        for (int i14 = 0; i14 < remove4; i14++) {
                            int size3 = this.codeLocalVariableTypeTableBciP.size() - 1;
                            this.codeLocalVariableTypeTableBciP.remove(size3);
                            this.codeLocalVariableTypeTableSpanO.remove(size3);
                            this.codeLocalVariableTypeTableNameRU.remove(size3);
                            this.codeLocalVariableTypeTableTypeRS.remove(size3);
                            this.codeLocalVariableTypeTableSlot.remove(size3);
                        }
                    }
                    if ((longValue5 & 2) != 0) {
                        IntList intList7 = this.codeLineNumberTableN;
                        int remove5 = intList7.remove(intList7.size() - 1);
                        for (int i15 = 0; i15 < remove5; i15++) {
                            int size4 = this.codeLineNumberTableBciP.size() - 1;
                            this.codeLineNumberTableBciP.remove(size4);
                            this.codeLineNumberTableLine.remove(size4);
                        }
                    }
                }
            }
            if ((longValue4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                this.method_RVA_bands.removeLatest();
            }
            if ((longValue4 & 4194304) != 0) {
                this.method_RIA_bands.removeLatest();
            }
            if ((8388608 & longValue4) != 0) {
                this.method_RVPA_bands.removeLatest();
            }
            if ((16777216 & longValue4) != 0) {
                this.method_RIPA_bands.removeLatest();
            }
            if ((33554432 & longValue4) != 0) {
                this.method_AD_bands.removeLatest();
            }
            j12 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            j14 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        CPClass[] cPClassArr = this.class_this;
        int i16 = this.index;
        cPClassArr[i16] = null;
        this.class_super[i16] = null;
        this.class_interface_count[i16] = 0;
        this.class_interface[i16] = null;
        this.major_versions[i16] = 0;
        this.class_flags[i16] = 0;
        this.tempFieldDesc.clear();
        this.tempFieldFlags.clear();
        this.tempMethodDesc.clear();
        this.tempMethodFlags.clear();
        int i17 = this.index;
        if (i17 > 0) {
            this.index = i17 - 1;
        }
    }
}
