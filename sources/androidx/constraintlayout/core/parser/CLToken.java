package androidx.constraintlayout.core.parser;

public class CLToken extends CLElement {

    /* renamed from: g  reason: collision with root package name */
    public int f10671g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Type f10672h = Type.UNKNOWN;

    /* renamed from: i  reason: collision with root package name */
    public char[] f10673i = "true".toCharArray();

    /* renamed from: j  reason: collision with root package name */
    public char[] f10674j = "false".toCharArray();

    /* renamed from: k  reason: collision with root package name */
    public char[] f10675k = "null".toCharArray();

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10676a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.parser.CLToken$Type[] r0 = androidx.constraintlayout.core.parser.CLToken.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10676a = r0
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.TRUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.FALSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLToken.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.f10672h;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.f10672h;
    }

    public boolean isNull() throws CLParsingException {
        if (this.f10672h == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i11);
        sb2.append(content());
        return sb2.toString();
    }

    public String toJSON() {
        if (!CLParser.f10669a) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c11, long j11) {
        int i11 = AnonymousClass1.f10676a[this.f10672h.ordinal()];
        boolean z11 = false;
        if (i11 == 1) {
            char[] cArr = this.f10673i;
            int i12 = this.f10671g;
            if (cArr[i12] == c11) {
                z11 = true;
            }
            if (z11 && i12 + 1 == cArr.length) {
                setEnd(j11);
            }
        } else if (i11 == 2) {
            char[] cArr2 = this.f10674j;
            int i13 = this.f10671g;
            if (cArr2[i13] == c11) {
                z11 = true;
            }
            if (z11 && i13 + 1 == cArr2.length) {
                setEnd(j11);
            }
        } else if (i11 == 3) {
            char[] cArr3 = this.f10675k;
            int i14 = this.f10671g;
            if (cArr3[i14] == c11) {
                z11 = true;
            }
            if (z11 && i14 + 1 == cArr3.length) {
                setEnd(j11);
            }
        } else if (i11 == 4) {
            char[] cArr4 = this.f10673i;
            int i15 = this.f10671g;
            if (cArr4[i15] == c11) {
                this.f10672h = Type.TRUE;
            } else if (this.f10674j[i15] == c11) {
                this.f10672h = Type.FALSE;
            } else if (this.f10675k[i15] == c11) {
                this.f10672h = Type.NULL;
            }
            z11 = true;
        }
        this.f10671g++;
        return z11;
    }
}
