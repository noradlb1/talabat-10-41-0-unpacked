package androidx.constraintlayout.core.parser;

public class CLNumber extends CLElement {

    /* renamed from: g  reason: collision with root package name */
    public float f10665g;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.f10665g = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    public float getFloat() {
        if (Float.isNaN(this.f10665g)) {
            this.f10665g = Float.parseFloat(content());
        }
        return this.f10665g;
    }

    public int getInt() {
        if (Float.isNaN(this.f10665g)) {
            this.f10665g = (float) Integer.parseInt(content());
        }
        return (int) this.f10665g;
    }

    public boolean isInt() {
        float f11 = getFloat();
        return ((float) ((int) f11)) == f11;
    }

    public void putValue(float f11) {
        this.f10665g = f11;
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i11);
        float f11 = getFloat();
        int i13 = (int) f11;
        if (((float) i13) == f11) {
            sb2.append(i13);
        } else {
            sb2.append(f11);
        }
        return sb2.toString();
    }

    public String toJSON() {
        float f11 = getFloat();
        int i11 = (int) f11;
        if (((float) i11) == f11) {
            return "" + i11;
        }
        return "" + f11;
    }

    public CLNumber(float f11) {
        super((char[]) null);
        this.f10665g = f11;
    }
}
