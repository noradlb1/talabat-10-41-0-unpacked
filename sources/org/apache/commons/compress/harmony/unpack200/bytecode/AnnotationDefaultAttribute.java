package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;

public class AnnotationDefaultAttribute extends AnnotationsAttribute {
    private static CPUTF8 attributeName;
    private final AnnotationsAttribute.ElementValue element_value;

    public AnnotationDefaultAttribute(AnnotationsAttribute.ElementValue elementValue) {
        super(attributeName);
        this.element_value = elementValue;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int getLength() {
        return this.element_value.getLength();
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(attributeName);
        arrayList.addAll(this.element_value.getClassFileEntries());
        int size = arrayList.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[size];
        for (int i11 = 0; i11 < size; i11++) {
            classFileEntryArr[i11] = (ClassFileEntry) arrayList.get(i11);
        }
        return classFileEntryArr;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.element_value.resolve(classConstantPool);
    }

    public String toString() {
        return "AnnotationDefault: " + this.element_value;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        this.element_value.writeBody(dataOutputStream);
    }
}
