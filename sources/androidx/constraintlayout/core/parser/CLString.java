package androidx.constraintlayout.core.parser;

public class CLString extends CLElement {
    public CLString(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLString(cArr);
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i11);
        sb2.append("'");
        sb2.append(content());
        sb2.append("'");
        return sb2.toString();
    }

    public String toJSON() {
        return "'" + content() + "'";
    }
}
