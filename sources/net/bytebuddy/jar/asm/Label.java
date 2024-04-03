package net.bytebuddy.jar.asm;

import com.google.common.base.Ascii;
import kotlin.UShort;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class Label {

    /* renamed from: k  reason: collision with root package name */
    public static final Label f27388k = new Label();

    /* renamed from: a  reason: collision with root package name */
    public short f27389a;

    /* renamed from: b  reason: collision with root package name */
    public int f27390b;

    /* renamed from: c  reason: collision with root package name */
    public short f27391c;

    /* renamed from: d  reason: collision with root package name */
    public short f27392d;

    /* renamed from: e  reason: collision with root package name */
    public short f27393e;

    /* renamed from: f  reason: collision with root package name */
    public short f27394f;
    private int[] forwardReferences;

    /* renamed from: g  reason: collision with root package name */
    public Frame f27395g;

    /* renamed from: h  reason: collision with root package name */
    public Label f27396h;

    /* renamed from: i  reason: collision with root package name */
    public Edge f27397i;
    public Object info;

    /* renamed from: j  reason: collision with root package name */
    public Label f27398j;
    private short lineNumber;
    private int[] otherLineNumbers;

    private void addForwardReference(int i11, int i12, int i13) {
        if (this.forwardReferences == null) {
            this.forwardReferences = new int[6];
        }
        int[] iArr = this.forwardReferences;
        int i14 = iArr[0];
        if (i14 + 2 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.forwardReferences = iArr2;
        }
        int[] iArr3 = this.forwardReferences;
        int i15 = i14 + 1;
        iArr3[i15] = i11;
        int i16 = i15 + 1;
        iArr3[i16] = i12 | i13;
        iArr3[0] = i16;
    }

    private Label pushSuccessors(Label label) {
        boolean z11;
        for (Edge edge = this.f27397i; edge != null; edge = edge.f27377c) {
            if ((this.f27389a & 16) == 0 || edge != this.f27397i.f27377c) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                Label label2 = edge.f27376b;
                if (label2.f27398j == null) {
                    label2.f27398j = label;
                    label = label2;
                }
            }
        }
        return label;
    }

    public final void a(MethodVisitor methodVisitor, boolean z11) {
        short s11;
        methodVisitor.visitLabel(this);
        if (z11 && (s11 = this.lineNumber) != 0) {
            methodVisitor.visitLineNumber(s11 & UShort.MAX_VALUE, this);
            if (this.otherLineNumbers != null) {
                int i11 = 1;
                while (true) {
                    int[] iArr = this.otherLineNumbers;
                    if (i11 <= iArr[0]) {
                        methodVisitor.visitLineNumber(iArr[i11], this);
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void b(int i11) {
        if (this.lineNumber == 0) {
            this.lineNumber = (short) i11;
            return;
        }
        if (this.otherLineNumbers == null) {
            this.otherLineNumbers = new int[4];
        }
        int[] iArr = this.otherLineNumbers;
        int i12 = iArr[0] + 1;
        iArr[0] = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.otherLineNumbers = iArr2;
        }
        this.otherLineNumbers[i12] = i11;
    }

    public final void c(Label label) {
        Label label2 = f27388k;
        this.f27398j = label2;
        Label label3 = label2;
        Label label4 = this;
        while (label4 != f27388k) {
            Label label5 = label4.f27398j;
            label4.f27398j = label3;
            if (!((label4.f27389a & 64) == 0 || label4.f27394f == label.f27394f)) {
                label4.f27397i = new Edge(label4.f27392d, label.f27397i.f27376b, label4.f27397i);
            }
            label3 = label4;
            label4 = label4.pushSuccessors(label5);
        }
        while (label3 != f27388k) {
            Label label6 = label3.f27398j;
            label3.f27398j = null;
            label3 = label6;
        }
    }

    public final Label d() {
        Frame frame = this.f27395g;
        return frame == null ? this : frame.f27380a;
    }

    public final void e(short s11) {
        this.f27398j = f27388k;
        Label label = this;
        while (label != f27388k) {
            Label label2 = label.f27398j;
            label.f27398j = null;
            if (label.f27394f == 0) {
                label.f27394f = s11;
                label = label.pushSuccessors(label2);
            } else {
                label = label2;
            }
        }
    }

    public final void f(ByteVector byteVector, int i11, boolean z11) {
        if ((this.f27389a & 4) == 0) {
            if (z11) {
                addForwardReference(i11, 536870912, byteVector.f27350b);
                byteVector.putInt(-1);
                return;
            }
            addForwardReference(i11, 268435456, byteVector.f27350b);
            byteVector.putShort(-1);
        } else if (z11) {
            byteVector.putInt(this.f27390b - i11);
        } else {
            byteVector.putShort(this.f27390b - i11);
        }
    }

    public final boolean g(byte[] bArr, int i11) {
        this.f27389a = (short) (this.f27389a | 4);
        this.f27390b = i11;
        int[] iArr = this.forwardReferences;
        boolean z11 = false;
        if (iArr == null) {
            return false;
        }
        for (int i12 = iArr[0]; i12 > 0; i12 -= 2) {
            int[] iArr2 = this.forwardReferences;
            int i13 = iArr2[i12 - 1];
            int i14 = iArr2[i12];
            int i15 = i11 - i13;
            int i16 = 268435455 & i14;
            if ((i14 & -268435456) == 268435456) {
                if (i15 < -32768 || i15 > 32767) {
                    byte b11 = bArr[i13] & 255;
                    if (b11 < 198) {
                        bArr[i13] = (byte) (b11 + TarConstants.LF_LINK);
                    } else {
                        bArr[i13] = (byte) (b11 + Ascii.DC4);
                    }
                    z11 = true;
                }
                bArr[i16] = (byte) (i15 >>> 8);
                bArr[i16 + 1] = (byte) i15;
            } else {
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i15 >>> 24);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (i15 >>> 16);
                bArr[i18] = (byte) (i15 >>> 8);
                bArr[i18 + 1] = (byte) i15;
            }
        }
        return z11;
    }

    public int getOffset() {
        if ((this.f27389a & 4) != 0) {
            return this.f27390b;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
