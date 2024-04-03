package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewAttribute extends BCIRenumberedAttribute {
    private final List body = new ArrayList();
    private final int layoutIndex;
    private final List lengths = new ArrayList();
    private ClassConstantPool pool;

    public static class BCIndex extends BCValue {
        /* access modifiers changed from: private */
        public final int index;

        public BCIndex(int i11) {
            super();
            this.index = i11;
        }
    }

    public static class BCLength extends BCValue {
        /* access modifiers changed from: private */
        public final int length;

        public BCLength(int i11) {
            super();
            this.length = i11;
        }
    }

    public static class BCOffset extends BCValue {
        /* access modifiers changed from: private */
        public int index;
        /* access modifiers changed from: private */
        public final int offset;

        public BCOffset(int i11) {
            super();
            this.offset = i11;
        }

        public void setIndex(int i11) {
            this.index = i11;
        }
    }

    public static abstract class BCValue {

        /* renamed from: a  reason: collision with root package name */
        public int f27766a;

        private BCValue() {
        }

        public void setActualValue(int i11) {
            this.f27766a = i11;
        }
    }

    public NewAttribute(CPUTF8 cputf8, int i11) {
        super(cputf8);
        this.layoutIndex = i11;
    }

    public void addBCIndex(int i11, int i12) {
        this.lengths.add(Integer.valueOf(i11));
        this.body.add(new BCIndex(i12));
    }

    public void addBCLength(int i11, int i12) {
        this.lengths.add(Integer.valueOf(i11));
        this.body.add(new BCLength(i12));
    }

    public void addBCOffset(int i11, int i12) {
        this.lengths.add(Integer.valueOf(i11));
        this.body.add(new BCOffset(i12));
    }

    public void addInteger(int i11, long j11) {
        this.lengths.add(Integer.valueOf(i11));
        this.body.add(Long.valueOf(j11));
    }

    public void addToBody(int i11, Object obj) {
        this.lengths.add(Integer.valueOf(i11));
        this.body.add(obj);
    }

    public int getLayoutIndex() {
        return this.layoutIndex;
    }

    public int getLength() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.lengths.size(); i12++) {
            i11 += ((Integer) this.lengths.get(i12)).intValue();
        }
        return i11;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        int i11 = 1;
        int i12 = 1;
        for (int i13 = 0; i13 < this.body.size(); i13++) {
            if (this.body.get(i13) instanceof ClassFileEntry) {
                i12++;
            }
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[i12];
        classFileEntryArr[0] = getAttributeName();
        for (int i14 = 0; i14 < this.body.size(); i14++) {
            Object obj = this.body.get(i14);
            if (obj instanceof ClassFileEntry) {
                classFileEntryArr[i11] = (ClassFileEntry) obj;
                i11++;
            }
        }
        return classFileEntryArr;
    }

    public int[] getStartPCs() {
        return null;
    }

    public void renumber(List list) {
        if (!this.renumbered) {
            BCIndex bCIndex = null;
            for (Object next : this.body) {
                if (next instanceof BCIndex) {
                    BCIndex bCIndex2 = (BCIndex) next;
                    bCIndex2.setActualValue(((Integer) list.get(bCIndex2.index)).intValue());
                } else if (next instanceof BCOffset) {
                    BCOffset bCOffset = (BCOffset) next;
                    if (bCIndex instanceof BCIndex) {
                        int a11 = bCIndex.index + bCOffset.offset;
                        bCOffset.setIndex(a11);
                        bCOffset.setActualValue(((Integer) list.get(a11)).intValue());
                    } else if (bCIndex instanceof BCOffset) {
                        int b11 = ((BCOffset) bCIndex).index + bCOffset.offset;
                        bCOffset.setIndex(b11);
                        bCOffset.setActualValue(((Integer) list.get(b11)).intValue());
                    } else {
                        bCOffset.setActualValue(((Integer) list.get(bCOffset.offset)).intValue());
                    }
                } else if (next instanceof BCLength) {
                    BCLength bCLength = (BCLength) next;
                    BCIndex bCIndex3 = bCIndex;
                    bCLength.setActualValue(((Integer) list.get(bCIndex3.index + bCLength.length)).intValue() - bCIndex3.f27766a);
                }
                bCIndex = next;
            }
            this.renumbered = true;
        }
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        for (int i11 = 0; i11 < this.body.size(); i11++) {
            Object obj = this.body.get(i11);
            if (obj instanceof ClassFileEntry) {
                ((ClassFileEntry) obj).resolve(classConstantPool);
            }
        }
        this.pool = classConstantPool;
    }

    public String toString() {
        return this.attributeName.underlyingString();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        long j11;
        int i11;
        for (int i12 = 0; i12 < this.lengths.size(); i12++) {
            int intValue = ((Integer) this.lengths.get(i12)).intValue();
            Object obj = this.body.get(i12);
            if (obj instanceof Long) {
                j11 = ((Long) obj).longValue();
            } else {
                if (obj instanceof ClassFileEntry) {
                    i11 = this.pool.indexOf((ClassFileEntry) obj);
                } else if (obj instanceof BCValue) {
                    i11 = ((BCValue) obj).f27766a;
                } else {
                    j11 = 0;
                }
                j11 = (long) i11;
            }
            if (intValue == 1) {
                dataOutputStream.writeByte((int) j11);
            } else if (intValue == 2) {
                dataOutputStream.writeShort((int) j11);
            } else if (intValue == 4) {
                dataOutputStream.writeInt((int) j11);
            } else if (intValue == 8) {
                dataOutputStream.writeLong(j11);
            }
        }
    }
}
