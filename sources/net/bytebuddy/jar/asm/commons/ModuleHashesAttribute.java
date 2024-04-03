package net.bytebuddy.jar.asm.commons;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ByteVector;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Label;

public final class ModuleHashesAttribute extends Attribute {
    public String algorithm;
    public List<byte[]> hashes;
    public List<String> modules;

    public ModuleHashesAttribute(String str, List<String> list, List<byte[]> list2) {
        super("ModuleHashes");
        this.algorithm = str;
        this.modules = list;
        this.hashes = list2;
    }

    public Attribute h(ClassReader classReader, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
        String readUTF8 = classReader.readUTF8(i11, cArr);
        int i14 = i11 + 2;
        int readUnsignedShort = classReader.readUnsignedShort(i14);
        int i15 = i14 + 2;
        ArrayList arrayList = new ArrayList(readUnsignedShort);
        ArrayList arrayList2 = new ArrayList(readUnsignedShort);
        for (int i16 = 0; i16 < readUnsignedShort; i16++) {
            String readModule = classReader.readModule(i15, cArr);
            int i17 = i15 + 2;
            arrayList.add(readModule);
            int readUnsignedShort2 = classReader.readUnsignedShort(i17);
            i15 = i17 + 2;
            byte[] bArr = new byte[readUnsignedShort2];
            for (int i18 = 0; i18 < readUnsignedShort2; i18++) {
                bArr[i18] = (byte) classReader.readByte(i15);
                i15++;
            }
            arrayList2.add(bArr);
        }
        return new ModuleHashesAttribute(readUTF8, arrayList, arrayList2);
    }

    public ByteVector i(ClassWriter classWriter, byte[] bArr, int i11, int i12, int i13) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(classWriter.newUTF8(this.algorithm));
        List<String> list = this.modules;
        if (list == null) {
            byteVector.putShort(0);
        } else {
            int size = list.size();
            byteVector.putShort(size);
            for (int i14 = 0; i14 < size; i14++) {
                byte[] bArr2 = this.hashes.get(i14);
                byteVector.putShort(classWriter.newModule(this.modules.get(i14))).putShort(bArr2.length).putByteArray(bArr2, 0, bArr2.length);
            }
        }
        return byteVector;
    }

    public ModuleHashesAttribute() {
        this((String) null, (List<String>) null, (List<byte[]>) null);
    }
}
