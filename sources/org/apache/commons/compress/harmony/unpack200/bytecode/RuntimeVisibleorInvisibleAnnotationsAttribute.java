package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;

public class RuntimeVisibleorInvisibleAnnotationsAttribute extends AnnotationsAttribute {
    private final AnnotationsAttribute.Annotation[] annotations;
    private final int num_annotations;

    public RuntimeVisibleorInvisibleAnnotationsAttribute(CPUTF8 cputf8, AnnotationsAttribute.Annotation[] annotationArr) {
        super(cputf8);
        this.num_annotations = annotationArr.length;
        this.annotations = annotationArr;
    }

    public int getLength() {
        int i11 = 2;
        for (int i12 = 0; i12 < this.num_annotations; i12++) {
            i11 += this.annotations[i12].getLength();
        }
        return i11;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.attributeName);
        int i11 = 0;
        while (true) {
            AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
            if (i11 >= annotationArr.length) {
                break;
            }
            arrayList.addAll(annotationArr[i11].getClassFileEntries());
            i11++;
        }
        int size = arrayList.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[size];
        for (int i12 = 0; i12 < size; i12++) {
            classFileEntryArr[i12] = (ClassFileEntry) arrayList.get(i12);
        }
        return classFileEntryArr;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        int i11 = 0;
        while (true) {
            AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
            if (i11 < annotationArr.length) {
                annotationArr[i11].resolve(classConstantPool);
                i11++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return this.attributeName.underlyingString() + ": " + this.num_annotations + " annotations";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        int size = dataOutputStream.size();
        dataOutputStream.writeShort(this.num_annotations);
        for (int i11 = 0; i11 < this.num_annotations; i11++) {
            this.annotations[i11].writeBody(dataOutputStream);
        }
        if (dataOutputStream.size() - size != getLength()) {
            throw new Error();
        }
    }
}
