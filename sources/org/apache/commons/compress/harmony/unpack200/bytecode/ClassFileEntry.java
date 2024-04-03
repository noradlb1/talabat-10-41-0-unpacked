package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ClassFileEntry {
    protected static final ClassFileEntry[] NONE = new ClassFileEntry[0];
    private boolean resolved;

    public abstract void doWrite(DataOutputStream dataOutputStream) throws IOException;

    public abstract boolean equals(Object obj);

    public ClassFileEntry[] getNestedClassFileEntries() {
        return NONE;
    }

    public abstract int hashCode();

    public int objectHashCode() {
        return super.hashCode();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        this.resolved = true;
    }

    public abstract String toString();

    public final void write(DataOutputStream dataOutputStream) throws IOException {
        if (this.resolved) {
            doWrite(dataOutputStream);
            return;
        }
        throw new IllegalStateException("Entry has not been resolved");
    }
}
