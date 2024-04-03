package androidx.constraintlayout.core.widgets;

public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f10798x;

    /* renamed from: y  reason: collision with root package name */
    public int f10799y;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r3 = r2.f10799y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean contains(int r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f10798x
            if (r3 < r0) goto L_0x0014
            int r1 = r2.width
            int r0 = r0 + r1
            if (r3 >= r0) goto L_0x0014
            int r3 = r2.f10799y
            if (r4 < r3) goto L_0x0014
            int r0 = r2.height
            int r3 = r3 + r0
            if (r4 >= r3) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Rectangle.contains(int, int):boolean");
    }

    public int getCenterX() {
        return (this.f10798x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f10799y + this.height) / 2;
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        this.f10798x = i11;
        this.f10799y = i12;
        this.width = i13;
        this.height = i14;
    }
}
