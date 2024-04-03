package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.objectweb.asm.Attribute;

public class AttributeDefinitionBands extends BandSet {
    public static final int CONTEXT_CLASS = 0;
    public static final int CONTEXT_CODE = 3;
    public static final int CONTEXT_FIELD = 1;
    public static final int CONTEXT_METHOD = 2;
    private final List attributeDefinitions = new ArrayList();
    private final List classAttributeLayouts = new ArrayList();
    private final List codeAttributeLayouts = new ArrayList();
    private final CpBands cpBands;
    private final List fieldAttributeLayouts = new ArrayList();
    private final List methodAttributeLayouts = new ArrayList();
    private final Segment segment;

    public static class AttributeDefinition {
        public int contextType;
        public int index;
        public CPUTF8 layout;

        /* renamed from: name  reason: collision with root package name */
        public CPUTF8 f27726name;

        public AttributeDefinition(int i11, int i12, CPUTF8 cputf8, CPUTF8 cputf82) {
            this.index = i11;
            this.contextType = i12;
            this.f27726name = cputf8;
            this.layout = cputf82;
        }
    }

    public AttributeDefinitionBands(Segment segment2, int i11, Attribute[] attributeArr) {
        super(i11, segment2.getSegmentHeader());
        this.cpBands = segment2.getCpBands();
        this.segment = segment2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        for (NewAttribute newAttribute : attributeArr) {
            if (!(newAttribute instanceof NewAttribute.ErrorAttribute) && !(newAttribute instanceof NewAttribute.PassAttribute) && !(newAttribute instanceof NewAttribute.StripAttribute)) {
                if (newAttribute.isContextClass()) {
                    hashMap.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextMethod()) {
                    hashMap2.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextField()) {
                    hashMap3.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextCode()) {
                    hashMap4.put(newAttribute.type, newAttribute.getLayout());
                }
            }
        }
        if (hashMap.size() > 7) {
            this.segmentHeader.setHave_class_flags_hi(true);
        }
        if (hashMap2.size() > 6) {
            this.segmentHeader.setHave_method_flags_hi(true);
        }
        if (hashMap3.size() > 10) {
            this.segmentHeader.setHave_field_flags_hi(true);
        }
        if (hashMap4.size() > 15) {
            this.segmentHeader.setHave_code_flags_hi(true);
        }
        int[] iArr = {25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(hashMap, hashMap.size() > 7 ? addHighIndices(iArr) : iArr, 0);
        int[] iArr2 = {26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(hashMap2, this.methodAttributeLayouts.size() > 6 ? addHighIndices(iArr2) : iArr2, 2);
        int[] iArr3 = {18, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(hashMap3, this.fieldAttributeLayouts.size() > 10 ? addHighIndices(iArr3) : iArr3, 1);
        int[] iArr4 = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(hashMap4, this.codeAttributeLayouts.size() > 15 ? addHighIndices(iArr4) : iArr4, 3);
    }

    private void addAttributeDefinitions(Map map, int[] iArr, int i11) {
        for (String str : map.keySet()) {
            AttributeDefinition attributeDefinition = new AttributeDefinition(iArr[0], i11, this.cpBands.getCPUtf8(str), this.cpBands.getCPUtf8((String) map.get(str)));
            this.attributeDefinitions.add(attributeDefinition);
            if (i11 == 0) {
                this.classAttributeLayouts.add(attributeDefinition);
            } else if (i11 == 1) {
                this.fieldAttributeLayouts.add(attributeDefinition);
            } else if (i11 == 2) {
                this.methodAttributeLayouts.add(attributeDefinition);
            } else if (i11 == 3) {
                this.codeAttributeLayouts.add(attributeDefinition);
            }
        }
    }

    private int[] addHighIndices(int[] iArr) {
        int i11 = 32;
        int length = iArr.length + 32;
        int[] iArr2 = new int[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr2[i12] = iArr[i12];
        }
        for (int length2 = iArr.length; length2 < length; length2++) {
            iArr2[length2] = i11;
            i11++;
        }
        return iArr2;
    }

    private void addSyntheticDefinitions() {
        boolean isAnySyntheticClasses = this.segment.getClassBands().isAnySyntheticClasses();
        boolean isAnySyntheticMethods = this.segment.getClassBands().isAnySyntheticMethods();
        boolean isAnySyntheticFields = this.segment.getClassBands().isAnySyntheticFields();
        if (isAnySyntheticClasses || isAnySyntheticMethods || isAnySyntheticFields) {
            CPUTF8 cPUtf8 = this.cpBands.getCPUtf8("Synthetic");
            CPUTF8 cPUtf82 = this.cpBands.getCPUtf8("");
            if (isAnySyntheticClasses) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 0, cPUtf8, cPUtf82));
            }
            if (isAnySyntheticMethods) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 2, cPUtf8, cPUtf82));
            }
            if (isAnySyntheticFields) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 1, cPUtf8, cPUtf82));
            }
        }
    }

    public void finaliseBands() {
        addSyntheticDefinitions();
        this.segmentHeader.setAttribute_definition_count(this.attributeDefinitions.size());
    }

    public List getClassAttributeLayouts() {
        return this.classAttributeLayouts;
    }

    public List getCodeAttributeLayouts() {
        return this.codeAttributeLayouts;
    }

    public List getFieldAttributeLayouts() {
        return this.fieldAttributeLayouts;
    }

    public List getMethodAttributeLayouts() {
        return this.methodAttributeLayouts;
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        PackingUtils.log("Writing attribute definition bands...");
        int size = this.attributeDefinitions.size();
        int[] iArr = new int[size];
        int size2 = this.attributeDefinitions.size();
        int[] iArr2 = new int[size2];
        int size3 = this.attributeDefinitions.size();
        int[] iArr3 = new int[size3];
        for (int i11 = 0; i11 < size3; i11++) {
            AttributeDefinition attributeDefinition = (AttributeDefinition) this.attributeDefinitions.get(i11);
            iArr[i11] = attributeDefinition.contextType | ((attributeDefinition.index + 1) << 2);
            iArr2[i11] = attributeDefinition.f27726name.getIndex();
            iArr3[i11] = attributeDefinition.layout.getIndex();
        }
        byte[] encodeBandInt = encodeBandInt("attributeDefinitionHeader", iArr, Codec.BYTE1);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from attributeDefinitionHeader[" + size + "]");
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] encodeBandInt2 = encodeBandInt("attributeDefinitionName", iArr2, bHSDCodec);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from attributeDefinitionName[" + size2 + "]");
        byte[] encodeBandInt3 = encodeBandInt("attributeDefinitionLayout", iArr3, bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from attributeDefinitionLayout[" + size3 + "]");
    }
}
