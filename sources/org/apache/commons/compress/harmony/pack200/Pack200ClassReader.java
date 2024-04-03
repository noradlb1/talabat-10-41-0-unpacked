package org.apache.commons.compress.harmony.pack200;

import org.objectweb.asm.ClassReader;

public class Pack200ClassReader extends ClassReader {
    private boolean anySyntheticAttributes;
    private String fileName;
    private boolean lastConstantHadWideIndex;
    private int lastUnsignedShort;

    public Pack200ClassReader(byte[] bArr) {
        super(bArr);
    }

    public String getFileName() {
        return this.fileName;
    }

    public boolean hasSyntheticAttributes() {
        return this.anySyntheticAttributes;
    }

    public boolean lastConstantHadWideIndex() {
        return this.lastConstantHadWideIndex;
    }

    public Object readConst(int i11, char[] cArr) {
        boolean z11;
        if (i11 == this.lastUnsignedShort) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.lastConstantHadWideIndex = z11;
        return Pack200ClassReader.super.readConst(i11, cArr);
    }

    public String readUTF8(int i11, char[] cArr) {
        String readUTF8 = Pack200ClassReader.super.readUTF8(i11, cArr);
        if (!this.anySyntheticAttributes && "Synthetic".equals(readUTF8)) {
            this.anySyntheticAttributes = true;
        }
        return readUTF8;
    }

    public int readUnsignedShort(int i11) {
        int readUnsignedShort = Pack200ClassReader.super.readUnsignedShort(i11);
        if (this.b[i11 - 1] == 19) {
            this.lastUnsignedShort = readUnsignedShort;
        } else {
            this.lastUnsignedShort = -32768;
        }
        return readUnsignedShort;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }
}
