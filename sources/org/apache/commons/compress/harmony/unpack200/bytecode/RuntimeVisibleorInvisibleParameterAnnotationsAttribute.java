package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;

public class RuntimeVisibleorInvisibleParameterAnnotationsAttribute extends AnnotationsAttribute {
    private final int num_parameters;
    private final ParameterAnnotation[] parameter_annotations;

    public static class ParameterAnnotation {
        private final AnnotationsAttribute.Annotation[] annotations;
        private final int num_annotations;

        public ParameterAnnotation(AnnotationsAttribute.Annotation[] annotationArr) {
            this.num_annotations = annotationArr.length;
            this.annotations = annotationArr;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i11 >= annotationArr.length) {
                    return arrayList;
                }
                arrayList.addAll(annotationArr[i11].getClassFileEntries());
                i11++;
            }
        }

        public int getLength() {
            int i11 = 2;
            int i12 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i12 >= annotationArr.length) {
                    return i11;
                }
                i11 += annotationArr[i12].getLength();
                i12++;
            }
        }

        public void resolve(ClassConstantPool classConstantPool) {
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

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(this.num_annotations);
            int i11 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i11 < annotationArr.length) {
                    annotationArr[i11].writeBody(dataOutputStream);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public RuntimeVisibleorInvisibleParameterAnnotationsAttribute(CPUTF8 cputf8, ParameterAnnotation[] parameterAnnotationArr) {
        super(cputf8);
        this.num_parameters = parameterAnnotationArr.length;
        this.parameter_annotations = parameterAnnotationArr;
    }

    public int getLength() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.num_parameters; i12++) {
            i11 += this.parameter_annotations[i12].getLength();
        }
        return i11;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.attributeName);
        int i11 = 0;
        while (true) {
            ParameterAnnotation[] parameterAnnotationArr = this.parameter_annotations;
            if (i11 >= parameterAnnotationArr.length) {
                break;
            }
            arrayList.addAll(parameterAnnotationArr[i11].getClassFileEntries());
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
            ParameterAnnotation[] parameterAnnotationArr = this.parameter_annotations;
            if (i11 < parameterAnnotationArr.length) {
                parameterAnnotationArr[i11].resolve(classConstantPool);
                i11++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return this.attributeName.underlyingString() + ": " + this.num_parameters + " parameter annotations";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.num_parameters);
        for (int i11 = 0; i11 < this.num_parameters; i11++) {
            this.parameter_annotations[i11].writeBody(dataOutputStream);
        }
    }
}
