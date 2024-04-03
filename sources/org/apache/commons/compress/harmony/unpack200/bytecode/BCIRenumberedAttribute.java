package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public abstract class BCIRenumberedAttribute extends Attribute {
    protected boolean renumbered;

    public BCIRenumberedAttribute(CPUTF8 cputf8) {
        super(cputf8);
    }

    public abstract int getLength();

    public abstract int[] getStartPCs();

    public boolean hasBCIRenumbering() {
        return true;
    }

    public void renumber(List list) throws Pack200Exception {
        if (!this.renumbered) {
            this.renumbered = true;
            int[] startPCs = getStartPCs();
            for (int i11 = 0; i11 < startPCs.length; i11++) {
                startPCs[i11] = ((Integer) list.get(startPCs[i11])).intValue();
            }
            return;
        }
        throw new Error("Trying to renumber a line number table that has already been renumbered");
    }

    public abstract String toString();

    public abstract void writeBody(DataOutputStream dataOutputStream) throws IOException;
}
