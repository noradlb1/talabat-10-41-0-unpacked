package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Segment;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;

public class NewAttribute extends Attribute {
    private char[] buf;
    private ClassReader classReader;
    private int codeOff;
    private byte[] contents;
    private boolean contextClass = false;
    private boolean contextCode = false;
    private boolean contextField = false;
    private boolean contextMethod = false;
    private Label[] labels;
    private final String layout;

    public static class ErrorAttribute extends NewAttribute {
        public ErrorAttribute(String str, int i11) {
            super(str, "", i11);
        }

        public Attribute read(ClassReader classReader, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
            throw new Error("Attribute " + this.type + " was found");
        }
    }

    public static class PassAttribute extends NewAttribute {
        public PassAttribute(String str, int i11) {
            super(str, "", i11);
        }

        public Attribute read(ClassReader classReader, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
            throw new Segment.PassException();
        }
    }

    public static class StripAttribute extends NewAttribute {
        public StripAttribute(String str, int i11) {
            super(str, "", i11);
        }

        public Attribute read(ClassReader classReader, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
            return null;
        }
    }

    public NewAttribute(String str, String str2, int i11) {
        super(str);
        this.layout = str2;
        addContext(i11);
    }

    public void addContext(int i11) {
        if (i11 == 0) {
            this.contextClass = true;
        } else if (i11 == 1) {
            this.contextField = true;
        } else if (i11 == 2) {
            this.contextMethod = true;
        } else if (i11 == 3) {
            this.contextCode = true;
        }
    }

    public byte[] getBytes() {
        return this.contents;
    }

    public Label getLabel(int i11) {
        return this.labels[i11];
    }

    public String getLayout() {
        return this.layout;
    }

    public boolean isCodeAttribute() {
        return this.codeOff != -1;
    }

    public boolean isContextClass() {
        return this.contextClass;
    }

    public boolean isContextCode() {
        return this.contextCode;
    }

    public boolean isContextField() {
        return this.contextField;
    }

    public boolean isContextMethod() {
        return this.contextMethod;
    }

    public boolean isUnknown() {
        return false;
    }

    public boolean isUnknown(int i11) {
        if (i11 == 0) {
            return !this.contextClass;
        }
        if (i11 == 1) {
            return !this.contextField;
        }
        if (i11 == 2) {
            return !this.contextMethod;
        }
        if (i11 != 3) {
            return false;
        }
        return !this.contextCode;
    }

    public Attribute read(ClassReader classReader2, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
        byte[] bArr = new byte[i12];
        System.arraycopy(classReader2.b, i11, bArr, 0, i12);
        return new NewAttribute(classReader2, this.type, this.layout, bArr, cArr, i13, labelArr);
    }

    public String readClass(int i11) {
        return this.classReader.readClass(i11, this.buf);
    }

    public Object readConst(int i11) {
        return this.classReader.readConst(i11, this.buf);
    }

    public String readUTF8(int i11) {
        return this.classReader.readUTF8(i11, this.buf);
    }

    public NewAttribute(ClassReader classReader2, String str, String str2, byte[] bArr, char[] cArr, int i11, Label[] labelArr) {
        super(str);
        this.classReader = classReader2;
        this.contents = bArr;
        this.layout = str2;
        this.codeOff = i11;
        this.labels = labelArr;
        this.buf = cArr;
    }
}
