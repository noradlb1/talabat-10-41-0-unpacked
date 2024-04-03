package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InnerClassesAttribute extends Attribute {
    private static CPUTF8 attributeName;
    private final List innerClasses = new ArrayList();
    private final List nestedClassFileEntries;

    public static class InnerClassesEntry {

        /* renamed from: a  reason: collision with root package name */
        public CPClass f27759a;

        /* renamed from: b  reason: collision with root package name */
        public CPClass f27760b;

        /* renamed from: c  reason: collision with root package name */
        public CPUTF8 f27761c;

        /* renamed from: d  reason: collision with root package name */
        public int f27762d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f27763e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f27764f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f27765g;

        public InnerClassesEntry(CPClass cPClass, CPClass cPClass2, CPUTF8 cputf8, int i11) {
            this.f27759a = cPClass;
            this.f27760b = cPClass2;
            this.f27761c = cputf8;
            this.f27765g = i11;
        }

        public void resolve(ClassConstantPool classConstantPool) {
            CPClass cPClass = this.f27759a;
            if (cPClass != null) {
                cPClass.resolve(classConstantPool);
                this.f27762d = classConstantPool.indexOf(this.f27759a);
            } else {
                this.f27762d = 0;
            }
            CPUTF8 cputf8 = this.f27761c;
            if (cputf8 != null) {
                cputf8.resolve(classConstantPool);
                this.f27764f = classConstantPool.indexOf(this.f27761c);
            } else {
                this.f27764f = 0;
            }
            CPClass cPClass2 = this.f27760b;
            if (cPClass2 != null) {
                cPClass2.resolve(classConstantPool);
                this.f27763e = classConstantPool.indexOf(this.f27760b);
                return;
            }
            this.f27763e = 0;
        }

        public void write(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(this.f27762d);
            dataOutputStream.writeShort(this.f27763e);
            dataOutputStream.writeShort(this.f27764f);
            dataOutputStream.writeShort(this.f27765g);
        }
    }

    public InnerClassesAttribute(String str) {
        super(attributeName);
        ArrayList arrayList = new ArrayList();
        this.nestedClassFileEntries = arrayList;
        arrayList.add(getAttributeName());
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public void addInnerClassesEntry(CPClass cPClass, CPClass cPClass2, CPUTF8 cputf8, int i11) {
        if (cPClass != null) {
            this.nestedClassFileEntries.add(cPClass);
        }
        if (cPClass2 != null) {
            this.nestedClassFileEntries.add(cPClass2);
        }
        if (cputf8 != null) {
            this.nestedClassFileEntries.add(cputf8);
        }
        addInnerClassesEntry(new InnerClassesEntry(cPClass, cPClass2, cputf8, i11));
    }

    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        super.doWrite(dataOutputStream);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        InnerClassesAttribute innerClassesAttribute = (InnerClassesAttribute) obj;
        if (getAttributeName() == null) {
            if (innerClassesAttribute.getAttributeName() != null) {
                return false;
            }
        } else if (!getAttributeName().equals(innerClassesAttribute.getAttributeName())) {
            return false;
        }
        return true;
    }

    public int getLength() {
        return (this.innerClasses.size() * 8) + 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        int size = this.nestedClassFileEntries.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[size];
        for (int i11 = 0; i11 < size; i11++) {
            classFileEntryArr[i11] = (ClassFileEntry) this.nestedClassFileEntries.get(i11);
        }
        return classFileEntryArr;
    }

    public int hashCode() {
        int i11;
        int hashCode = super.hashCode() * 31;
        if (getAttributeName() == null) {
            i11 = 0;
        } else {
            i11 = getAttributeName().hashCode();
        }
        return hashCode + i11;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        for (int i11 = 0; i11 < this.innerClasses.size(); i11++) {
            ((InnerClassesEntry) this.innerClasses.get(i11)).resolve(classConstantPool);
        }
    }

    public String toString() {
        return "InnerClasses: " + getAttributeName();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.innerClasses.size());
        for (int i11 = 0; i11 < this.innerClasses.size(); i11++) {
            ((InnerClassesEntry) this.innerClasses.get(i11)).write(dataOutputStream);
        }
    }

    private void addInnerClassesEntry(InnerClassesEntry innerClassesEntry) {
        this.innerClasses.add(innerClassesEntry);
    }
}
