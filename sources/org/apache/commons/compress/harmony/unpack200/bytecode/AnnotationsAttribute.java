package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AnnotationsAttribute extends Attribute {

    public static class Annotation {
        private final CPUTF8[] element_names;
        private final ElementValue[] element_values;
        private int[] name_indexes;
        private final int num_pairs;
        private final CPUTF8 type;
        private int type_index;

        public Annotation(int i11, CPUTF8 cputf8, CPUTF8[] cputf8Arr, ElementValue[] elementValueArr) {
            this.num_pairs = i11;
            this.type = cputf8;
            this.element_names = cputf8Arr;
            this.element_values = elementValueArr;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                CPUTF8[] cputf8Arr = this.element_names;
                if (i11 < cputf8Arr.length) {
                    arrayList.add(cputf8Arr[i11]);
                    arrayList.addAll(this.element_values[i11].getClassFileEntries());
                    i11++;
                } else {
                    arrayList.add(this.type);
                    return arrayList;
                }
            }
        }

        public int getLength() {
            int i11 = 4;
            for (int i12 = 0; i12 < this.num_pairs; i12++) {
                i11 = i11 + 2 + this.element_values[i12].getLength();
            }
            return i11;
        }

        public void resolve(ClassConstantPool classConstantPool) {
            this.type.resolve(classConstantPool);
            this.type_index = classConstantPool.indexOf(this.type);
            this.name_indexes = new int[this.num_pairs];
            int i11 = 0;
            while (true) {
                CPUTF8[] cputf8Arr = this.element_names;
                if (i11 < cputf8Arr.length) {
                    cputf8Arr[i11].resolve(classConstantPool);
                    this.name_indexes[i11] = classConstantPool.indexOf(this.element_names[i11]);
                    this.element_values[i11].resolve(classConstantPool);
                    i11++;
                } else {
                    return;
                }
            }
        }

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(this.type_index);
            dataOutputStream.writeShort(this.num_pairs);
            for (int i11 = 0; i11 < this.num_pairs; i11++) {
                dataOutputStream.writeShort(this.name_indexes[i11]);
                this.element_values[i11].writeBody(dataOutputStream);
            }
        }
    }

    public static class ElementValue {
        private int constant_value_index = -1;
        private final int tag;
        private final Object value;

        public ElementValue(int i11, Object obj) {
            this.tag = i11;
            this.value = obj;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList(1);
            Object obj = this.value;
            if (obj instanceof CPNameAndType) {
                arrayList.add(((CPNameAndType) obj).f27757name);
                arrayList.add(((CPNameAndType) this.value).descriptor);
            } else if (obj instanceof ClassFileEntry) {
                arrayList.add(obj);
            } else if (obj instanceof ElementValue[]) {
                ElementValue[] elementValueArr = (ElementValue[]) obj;
                for (ElementValue classFileEntries : elementValueArr) {
                    arrayList.addAll(classFileEntries.getClassFileEntries());
                }
            } else if (obj instanceof Annotation) {
                arrayList.addAll(((Annotation) obj).getClassFileEntries());
            }
            return arrayList;
        }

        public int getLength() {
            int i11 = this.tag;
            if (i11 == 64) {
                return ((Annotation) this.value).getLength() + 1;
            }
            int i12 = 3;
            if (!(i11 == 70 || i11 == 83 || i11 == 99)) {
                if (i11 == 101) {
                    return 5;
                }
                if (!(i11 == 115 || i11 == 73 || i11 == 74 || i11 == 90)) {
                    if (i11 != 91) {
                        switch (i11) {
                            case 66:
                            case 67:
                            case 68:
                                break;
                            default:
                                return 0;
                        }
                    } else {
                        ElementValue[] elementValueArr = (ElementValue[]) this.value;
                        for (ElementValue length : elementValueArr) {
                            i12 += length.getLength();
                        }
                        return i12;
                    }
                }
            }
            return 3;
        }

        public void resolve(ClassConstantPool classConstantPool) {
            Object obj = this.value;
            if (obj instanceof CPConstant) {
                ((CPConstant) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPConstant) this.value);
            } else if (obj instanceof CPClass) {
                ((CPClass) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPClass) this.value);
            } else if (obj instanceof CPUTF8) {
                ((CPUTF8) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPUTF8) this.value);
            } else if (obj instanceof CPNameAndType) {
                ((CPNameAndType) obj).resolve(classConstantPool);
            } else if (obj instanceof Annotation) {
                ((Annotation) obj).resolve(classConstantPool);
            } else if (obj instanceof ElementValue[]) {
                ElementValue[] elementValueArr = (ElementValue[]) obj;
                for (ElementValue resolve : elementValueArr) {
                    resolve.resolve(classConstantPool);
                }
            }
        }

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeByte(this.tag);
            int i11 = this.constant_value_index;
            if (i11 != -1) {
                dataOutputStream.writeShort(i11);
                return;
            }
            Object obj = this.value;
            if (obj instanceof CPNameAndType) {
                ((CPNameAndType) obj).writeBody(dataOutputStream);
            } else if (obj instanceof Annotation) {
                ((Annotation) obj).writeBody(dataOutputStream);
            } else if (obj instanceof ElementValue[]) {
                ElementValue[] elementValueArr = (ElementValue[]) obj;
                dataOutputStream.writeShort(elementValueArr.length);
                for (ElementValue writeBody : elementValueArr) {
                    writeBody.writeBody(dataOutputStream);
                }
            } else {
                throw new Error("");
            }
        }
    }

    public AnnotationsAttribute(CPUTF8 cputf8) {
        super(cputf8);
    }
}
