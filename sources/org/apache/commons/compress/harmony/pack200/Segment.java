package org.apache.commons.compress.harmony.pack200;

import androidx.exifinterface.media.ExifInterface;
import com.apptimize.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Archive;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class Segment implements ClassVisitor {
    private AttributeDefinitionBands attributeDefinitionBands;
    /* access modifiers changed from: private */
    public BcBands bcBands;
    /* access modifiers changed from: private */
    public ClassBands classBands;
    private CpBands cpBands;
    private Pack200ClassReader currentClassReader;
    private final SegmentFieldVisitor fieldVisitor = new SegmentFieldVisitor();
    private FileBands fileBands;
    private IcBands icBands;
    private final SegmentMethodVisitor methodVisitor = new SegmentMethodVisitor();
    private Attribute[] nonStandardAttributePrototypes;
    /* access modifiers changed from: private */
    public PackingOptions options;
    private SegmentHeader segmentHeader;
    /* access modifiers changed from: private */
    public boolean stripDebug;

    public class ArrayVisitor implements AnnotationVisitor {
        private final List T;
        private final List caseArrayN;
        private final int indexInCaseArrayN;
        private final List nameRU;
        private final List values;

        public ArrayVisitor(List list, List list2, List list3, List list4) {
            this.caseArrayN = list;
            this.T = list2;
            this.nameRU = list3;
            this.values = list4;
            this.indexInCaseArrayN = list.size() - 1;
        }

        public void visit(String str, Object obj) {
            this.caseArrayN.add(this.indexInCaseArrayN, Integer.valueOf(((Integer) this.caseArrayN.remove(this.indexInCaseArrayN)).intValue() + 1));
            Segment.this.addValueAndTag(obj, this.T, this.values);
        }

        public AnnotationVisitor visitAnnotation(String str, String str2) {
            throw new RuntimeException("Not yet supported");
        }

        public AnnotationVisitor visitArray(String str) {
            this.T.add("[");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.caseArrayN.add(0);
            return new ArrayVisitor(this.caseArrayN, this.T, this.nameRU, this.values);
        }

        public void visitEnd() {
        }

        public void visitEnum(String str, String str2, String str3) {
            List list = this.caseArrayN;
            this.caseArrayN.add(Integer.valueOf(((Integer) list.remove(list.size() - 1)).intValue() + 1));
            this.T.add("e");
            this.values.add(str2);
            this.values.add(str3);
        }
    }

    public static class PassException extends RuntimeException {
    }

    public class SegmentFieldVisitor implements FieldVisitor {
        public SegmentFieldVisitor() {
        }

        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
            return new SegmentAnnotationVisitor(1, str, z11);
        }

        public void visitAttribute(Attribute attribute) {
            if (attribute.isUnknown()) {
                String unknownAttributeAction = Segment.this.options.getUnknownAttributeAction();
                if (unknownAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                } else if (unknownAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
            } else if (attribute instanceof NewAttribute) {
                NewAttribute newAttribute = (NewAttribute) attribute;
                if (newAttribute.isUnknown(1)) {
                    String unknownFieldAttributeAction = Segment.this.options.getUnknownFieldAttributeAction(newAttribute.type);
                    if (unknownFieldAttributeAction.equals("pass")) {
                        Segment.this.passCurrentClass();
                    } else if (unknownFieldAttributeAction.equals("error")) {
                        throw new Error("Unknown attribute encountered");
                    }
                }
                Segment.this.classBands.addFieldAttribute(newAttribute);
            } else {
                throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
            }
        }

        public void visitEnd() {
        }
    }

    public class SegmentMethodVisitor implements MethodVisitor {
        public SegmentMethodVisitor() {
        }

        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
            return new SegmentAnnotationVisitor(2, str, z11);
        }

        public AnnotationVisitor visitAnnotationDefault() {
            return new SegmentAnnotationVisitor(2);
        }

        public void visitAttribute(Attribute attribute) {
            if (attribute.isUnknown()) {
                String unknownAttributeAction = Segment.this.options.getUnknownAttributeAction();
                if (unknownAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                } else if (unknownAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
            } else if (attribute instanceof NewAttribute) {
                NewAttribute newAttribute = (NewAttribute) attribute;
                if (attribute.isCodeAttribute()) {
                    if (newAttribute.isUnknown(3)) {
                        String unknownCodeAttributeAction = Segment.this.options.getUnknownCodeAttributeAction(newAttribute.type);
                        if (unknownCodeAttributeAction.equals("pass")) {
                            Segment.this.passCurrentClass();
                        } else if (unknownCodeAttributeAction.equals("error")) {
                            throw new Error("Unknown attribute encountered");
                        }
                    }
                    Segment.this.classBands.addCodeAttribute(newAttribute);
                    return;
                }
                if (newAttribute.isUnknown(2)) {
                    String unknownMethodAttributeAction = Segment.this.options.getUnknownMethodAttributeAction(newAttribute.type);
                    if (unknownMethodAttributeAction.equals("pass")) {
                        Segment.this.passCurrentClass();
                    } else if (unknownMethodAttributeAction.equals("error")) {
                        throw new Error("Unknown attribute encountered");
                    }
                }
                Segment.this.classBands.addMethodAttribute(newAttribute);
            } else {
                throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
            }
        }

        public void visitCode() {
            Segment.this.classBands.addCode();
        }

        public void visitEnd() {
            Segment.this.classBands.endOfMethod();
            Segment.this.bcBands.visitEnd();
        }

        public void visitFieldInsn(int i11, String str, String str2, String str3) {
            Segment.this.bcBands.visitFieldInsn(i11, str, str2, str3);
        }

        public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        }

        public void visitIincInsn(int i11, int i12) {
            Segment.this.bcBands.visitIincInsn(i11, i12);
        }

        public void visitInsn(int i11) {
            Segment.this.bcBands.visitInsn(i11);
        }

        public void visitIntInsn(int i11, int i12) {
            Segment.this.bcBands.visitIntInsn(i11, i12);
        }

        public void visitJumpInsn(int i11, Label label) {
            Segment.this.bcBands.visitJumpInsn(i11, label);
        }

        public void visitLabel(Label label) {
            Segment.this.bcBands.visitLabel(label);
        }

        public void visitLdcInsn(Object obj) {
            Segment.this.bcBands.visitLdcInsn(obj);
        }

        public void visitLineNumber(int i11, Label label) {
            if (!Segment.this.stripDebug) {
                Segment.this.classBands.addLineNumber(i11, label);
            }
        }

        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
            if (!Segment.this.stripDebug) {
                Segment.this.classBands.addLocalVariable(str, str2, str3, label, label2, i11);
            }
        }

        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
            Segment.this.bcBands.visitLookupSwitchInsn(label, iArr, labelArr);
        }

        public void visitMaxs(int i11, int i12) {
            Segment.this.classBands.addMaxStack(i11, i12);
        }

        public void visitMethodInsn(int i11, String str, String str2, String str3) {
            Segment.this.bcBands.visitMethodInsn(i11, str, str2, str3);
        }

        public void visitMultiANewArrayInsn(String str, int i11) {
            Segment.this.bcBands.visitMultiANewArrayInsn(str, i11);
        }

        public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
            return new SegmentAnnotationVisitor(2, i11, str, z11);
        }

        public void visitTableSwitchInsn(int i11, int i12, Label label, Label[] labelArr) {
            Segment.this.bcBands.visitTableSwitchInsn(i11, i12, label, labelArr);
        }

        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
            Segment.this.classBands.addHandler(label, label2, label3, str);
        }

        public void visitTypeInsn(int i11, String str) {
            Segment.this.bcBands.visitTypeInsn(i11, str);
        }

        public void visitVarInsn(int i11, int i12) {
            Segment.this.bcBands.visitVarInsn(i11, i12);
        }
    }

    /* access modifiers changed from: private */
    public void addValueAndTag(Object obj, List list, List list2) {
        if (obj instanceof Integer) {
            list.add("I");
            list2.add(obj);
        } else if (obj instanceof Double) {
            list.add("D");
            list2.add(obj);
        } else if (obj instanceof Float) {
            list.add("F");
            list2.add(obj);
        } else if (obj instanceof Long) {
            list.add("J");
            list2.add(obj);
        } else if (obj instanceof Byte) {
            list.add("B");
            list2.add(Integer.valueOf(((Byte) obj).intValue()));
        } else if (obj instanceof Character) {
            list.add("C");
            list2.add(Integer.valueOf(((Character) obj).charValue()));
        } else if (obj instanceof Short) {
            list.add(ExifInterface.LATITUDE_SOUTH);
            list2.add(Integer.valueOf(((Short) obj).intValue()));
        } else if (obj instanceof Boolean) {
            list.add("Z");
            list2.add(Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
        } else if (obj instanceof String) {
            list.add("s");
            list2.add(obj);
        } else if (obj instanceof Type) {
            list.add(c.f41585a);
            list2.add(((Type) obj).toString());
        }
    }

    /* access modifiers changed from: private */
    public void passCurrentClass() {
        throw new PassException();
    }

    private void processClasses(Archive.SegmentUnit segmentUnit, Attribute[] attributeArr) throws Pack200Exception {
        int i11;
        this.segmentHeader.setClass_count(segmentUnit.classListSize());
        for (Pack200ClassReader pack200ClassReader : segmentUnit.getClassList()) {
            this.currentClassReader = pack200ClassReader;
            boolean z11 = false;
            if (this.stripDebug) {
                i11 = 2;
            } else {
                i11 = 0;
            }
            try {
                pack200ClassReader.accept(this, attributeArr, i11);
            } catch (PassException unused) {
                this.classBands.removeCurrentClass();
                String fileName = pack200ClassReader.getFileName();
                this.options.addPassFile(fileName);
                this.cpBands.addCPUtf8(fileName);
                Iterator it = segmentUnit.getFileList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Archive.PackingFile packingFile = (Archive.PackingFile) it.next();
                    if (packingFile.getName().equals(fileName)) {
                        packingFile.setContents(pack200ClassReader.b);
                        z11 = true;
                        break;
                    }
                }
                if (!z11) {
                    throw new Pack200Exception("Error passing file " + fileName);
                }
            }
        }
    }

    public AttributeDefinitionBands getAttrBands() {
        return this.attributeDefinitionBands;
    }

    public ClassBands getClassBands() {
        return this.classBands;
    }

    public CpBands getCpBands() {
        return this.cpBands;
    }

    public Pack200ClassReader getCurrentClassReader() {
        return this.currentClassReader;
    }

    public IcBands getIcBands() {
        return this.icBands;
    }

    public SegmentHeader getSegmentHeader() {
        return this.segmentHeader;
    }

    public boolean lastConstantHadWideIndex() {
        return this.currentClassReader.lastConstantHadWideIndex();
    }

    public void pack(Archive.SegmentUnit segmentUnit, OutputStream outputStream, PackingOptions packingOptions) throws IOException, Pack200Exception {
        this.options = packingOptions;
        this.stripDebug = packingOptions.isStripDebug();
        int effort = packingOptions.getEffort();
        this.nonStandardAttributePrototypes = packingOptions.getUnknownAttributePrototypes();
        PackingUtils.log("Start to pack a new segment with " + segmentUnit.fileListSize() + " files including " + segmentUnit.classListSize() + " classes");
        PackingUtils.log("Initialize a header for the segment");
        SegmentHeader segmentHeader2 = new SegmentHeader();
        this.segmentHeader = segmentHeader2;
        segmentHeader2.setFile_count(segmentUnit.fileListSize());
        this.segmentHeader.setHave_all_code_flags(this.stripDebug ^ true);
        if (!packingOptions.isKeepDeflateHint()) {
            this.segmentHeader.setDeflate_hint("true".equals(packingOptions.getDeflateHint()));
        }
        PackingUtils.log("Setup constant pool bands for the segment");
        this.cpBands = new CpBands(this, effort);
        PackingUtils.log("Setup attribute definition bands for the segment");
        this.attributeDefinitionBands = new AttributeDefinitionBands(this, effort, this.nonStandardAttributePrototypes);
        PackingUtils.log("Setup internal class bands for the segment");
        this.icBands = new IcBands(this.segmentHeader, this.cpBands, effort);
        PackingUtils.log("Setup class bands for the segment");
        this.classBands = new ClassBands(this, segmentUnit.classListSize(), effort, this.stripDebug);
        PackingUtils.log("Setup byte code bands for the segment");
        this.bcBands = new BcBands(this.cpBands, this, effort);
        PackingUtils.log("Setup file bands for the segment");
        this.fileBands = new FileBands(this.cpBands, this.segmentHeader, packingOptions, segmentUnit, effort);
        processClasses(segmentUnit, this.nonStandardAttributePrototypes);
        this.cpBands.finaliseBands();
        this.attributeDefinitionBands.finaliseBands();
        this.icBands.finaliseBands();
        this.classBands.finaliseBands();
        this.bcBands.finaliseBands();
        this.fileBands.finaliseBands();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PackingUtils.log("Packing...");
        int numClassesProcessed = this.classBands.numClassesProcessed();
        this.segmentHeader.setClass_count(numClassesProcessed);
        this.cpBands.pack(byteArrayOutputStream);
        if (numClassesProcessed > 0) {
            this.attributeDefinitionBands.pack(byteArrayOutputStream);
            this.icBands.pack(byteArrayOutputStream);
            this.classBands.pack(byteArrayOutputStream);
            this.bcBands.pack(byteArrayOutputStream);
        }
        this.fileBands.pack(byteArrayOutputStream);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        this.segmentHeader.pack(byteArrayOutputStream2);
        byteArrayOutputStream2.writeTo(outputStream);
        byteArrayOutputStream.writeTo(outputStream);
        segmentUnit.addPackedByteAmount(byteArrayOutputStream2.size());
        segmentUnit.addPackedByteAmount(byteArrayOutputStream.size());
        PackingUtils.log("Wrote total of " + segmentUnit.getPackedByteAmount() + " bytes");
        PackingUtils.log("Transmitted " + segmentUnit.fileListSize() + " files of " + segmentUnit.getByteAmount() + " input bytes in a segment of " + segmentUnit.getPackedByteAmount() + " bytes");
    }

    public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        this.bcBands.setCurrentClass(str, str3);
        this.segmentHeader.addMajorVersion(i11);
        this.classBands.addClass(i11, i12, str, str2, str3, strArr);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        return new SegmentAnnotationVisitor(0, str, z11);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isUnknown()) {
            String unknownAttributeAction = this.options.getUnknownAttributeAction();
            if (unknownAttributeAction.equals("pass")) {
                passCurrentClass();
            } else if (unknownAttributeAction.equals("error")) {
                throw new Error("Unknown attribute encountered");
            }
        } else if (attribute instanceof NewAttribute) {
            NewAttribute newAttribute = (NewAttribute) attribute;
            if (newAttribute.isUnknown(0)) {
                String unknownClassAttributeAction = this.options.getUnknownClassAttributeAction(newAttribute.type);
                if (unknownClassAttributeAction.equals("pass")) {
                    passCurrentClass();
                } else if (unknownClassAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
            }
            this.classBands.addClassAttribute(newAttribute);
        } else {
            throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
        }
    }

    public void visitEnd() {
        this.classBands.endOfClass();
    }

    public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
        this.classBands.addField(i11, str, str2, str3, obj);
        return this.fieldVisitor;
    }

    public void visitInnerClass(String str, String str2, String str3, int i11) {
        this.icBands.addInnerClass(str, str2, str3, i11);
    }

    public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
        this.classBands.addMethod(i11, str, str2, str3, strArr);
        return this.methodVisitor;
    }

    public void visitOuterClass(String str, String str2, String str3) {
        this.classBands.addEnclosingMethod(str, str2, str3);
    }

    public void visitSource(String str, String str2) {
        if (!this.stripDebug) {
            this.classBands.addSourceFile(str);
        }
    }

    public class SegmentAnnotationVisitor implements AnnotationVisitor {
        /* access modifiers changed from: private */
        public final List T = new ArrayList();
        private final List caseArrayN = new ArrayList();
        private int context = -1;
        private String desc;
        private final List nameRU = new ArrayList();
        /* access modifiers changed from: private */
        public final List nestNameRU = new ArrayList();
        /* access modifiers changed from: private */
        public final List nestPairN = new ArrayList();
        private final List nestTypeRS = new ArrayList();
        private int parameter = -1;
        /* access modifiers changed from: private */
        public final List values = new ArrayList();
        private boolean visible;

        public SegmentAnnotationVisitor(int i11, String str, boolean z11) {
            this.context = i11;
            this.desc = str;
            this.visible = z11;
        }

        public void visit(String str, Object obj) {
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            Segment.this.addValueAndTag(obj, this.T, this.values);
        }

        public AnnotationVisitor visitAnnotation(String str, String str2) {
            this.T.add("@");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.nestTypeRS.add(str2);
            this.nestPairN.add(0);
            return new AnnotationVisitor() {
                public void visit(String str, Object obj) {
                    SegmentAnnotationVisitor.this.nestPairN.add(Integer.valueOf(((Integer) SegmentAnnotationVisitor.this.nestPairN.remove(SegmentAnnotationVisitor.this.nestPairN.size() - 1)).intValue() + 1));
                    SegmentAnnotationVisitor.this.nestNameRU.add(str);
                    SegmentAnnotationVisitor segmentAnnotationVisitor = SegmentAnnotationVisitor.this;
                    Segment.this.addValueAndTag(obj, segmentAnnotationVisitor.T, SegmentAnnotationVisitor.this.values);
                }

                public AnnotationVisitor visitAnnotation(String str, String str2) {
                    throw new RuntimeException("Not yet supported");
                }

                public AnnotationVisitor visitArray(String str) {
                    throw new RuntimeException("Not yet supported");
                }

                public void visitEnd() {
                }

                public void visitEnum(String str, String str2, String str3) {
                    SegmentAnnotationVisitor.this.nestPairN.add(Integer.valueOf(((Integer) SegmentAnnotationVisitor.this.nestPairN.remove(SegmentAnnotationVisitor.this.nestPairN.size() - 1)).intValue() + 1));
                    SegmentAnnotationVisitor.this.T.add("e");
                    SegmentAnnotationVisitor.this.nestNameRU.add(str);
                    SegmentAnnotationVisitor.this.values.add(str2);
                    SegmentAnnotationVisitor.this.values.add(str3);
                }
            };
        }

        public AnnotationVisitor visitArray(String str) {
            this.T.add("[");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.caseArrayN.add(0);
            return new ArrayVisitor(this.caseArrayN, this.T, this.nameRU, this.values);
        }

        public void visitEnd() {
            if (this.desc == null) {
                Segment.this.classBands.addAnnotationDefault(this.nameRU, this.T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            } else if (this.parameter != -1) {
                Segment.this.classBands.addParameterAnnotation(this.parameter, this.desc, this.visible, this.nameRU, this.T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            } else {
                Segment.this.classBands.addAnnotation(this.context, this.desc, this.visible, this.nameRU, this.T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            }
        }

        public void visitEnum(String str, String str2, String str3) {
            this.T.add("e");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.values.add(str2);
            this.values.add(str3);
        }

        public SegmentAnnotationVisitor(int i11) {
            this.context = i11;
        }

        public SegmentAnnotationVisitor(int i11, int i12, String str, boolean z11) {
            this.context = i11;
            this.parameter = i12;
            this.desc = str;
            this.visible = z11;
        }
    }
}
