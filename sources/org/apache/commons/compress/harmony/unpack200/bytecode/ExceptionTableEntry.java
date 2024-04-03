package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ExceptionTableEntry {
    private final CPClass catchType;
    private int catchTypeIndex;
    private final int endPC;
    private int endPcRenumbered;
    private final int handlerPC;
    private int handlerPcRenumbered;
    private final int startPC;
    private int startPcRenumbered;

    public ExceptionTableEntry(int i11, int i12, int i13, CPClass cPClass) {
        this.startPC = i11;
        this.endPC = i12;
        this.handlerPC = i13;
        this.catchType = cPClass;
    }

    public CPClass getCatchType() {
        return this.catchType;
    }

    public void renumber(List list) {
        this.startPcRenumbered = ((Integer) list.get(this.startPC)).intValue();
        int i11 = this.startPC + this.endPC;
        this.endPcRenumbered = ((Integer) list.get(i11)).intValue();
        this.handlerPcRenumbered = ((Integer) list.get(i11 + this.handlerPC)).intValue();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        CPClass cPClass = this.catchType;
        if (cPClass == null) {
            this.catchTypeIndex = 0;
            return;
        }
        cPClass.resolve(classConstantPool);
        this.catchTypeIndex = classConstantPool.indexOf(this.catchType);
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.startPcRenumbered);
        dataOutputStream.writeShort(this.endPcRenumbered);
        dataOutputStream.writeShort(this.handlerPcRenumbered);
        dataOutputStream.writeShort(this.catchTypeIndex);
    }
}
