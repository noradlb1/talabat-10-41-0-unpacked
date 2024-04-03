package androidx.constraintlayout.core.parser;

public class CLParser {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10669a = false;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10670a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.parser.CLParser$TYPE[] r0 = androidx.constraintlayout.core.parser.CLParser.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10670a = r0
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10670a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10670a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10670a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10670a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.KEY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10670a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.TOKEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i11, TYPE type, boolean z11, char[] cArr) {
        CLElement cLElement2;
        if (f10669a) {
            System.out.println("CREATE " + type + " at " + cArr[i11]);
        }
        switch (AnonymousClass1.f10670a[type.ordinal()]) {
            case 1:
                cLElement2 = CLObject.allocate(cArr);
                break;
            case 2:
                cLElement2 = CLArray.allocate(cArr);
                break;
            case 3:
                cLElement2 = CLString.allocate(cArr);
                break;
            case 4:
                cLElement2 = CLNumber.allocate(cArr);
                break;
            case 5:
                cLElement2 = CLKey.allocate(cArr);
                break;
            case 6:
                cLElement2 = CLToken.allocate(cArr);
                break;
            default:
                cLElement2 = null;
                break;
        }
        i11++;
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.setLine(this.lineNumber);
        if (z11) {
            cLElement2.setStart((long) i11);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.setContainer((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement getNextJsonElement(int i11, char c11, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c11 == 9 || c11 == 10 || c11 == 13 || c11 == ' ') {
            return cLElement;
        }
        if (c11 == '\"' || c11 == '\'') {
            if (cLElement instanceof CLObject) {
                return createElement(cLElement, i11, TYPE.KEY, true, cArr);
            }
            return createElement(cLElement, i11, TYPE.STRING, true, cArr);
        } else if (c11 != '[') {
            if (c11 != ']') {
                if (c11 == '{') {
                    return createElement(cLElement, i11, TYPE.OBJECT, true, cArr);
                } else if (c11 != '}') {
                    switch (c11) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i11, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            return cLElement;
                        case '/':
                            int i12 = i11 + 1;
                            if (i12 >= cArr.length || cArr[i12] != '/') {
                                return cLElement;
                            }
                            this.hasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i11, TYPE.KEY, true, cArr);
                            }
                            CLElement createElement = createElement(cLElement, i11, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) createElement;
                            if (cLToken.validate(c11, (long) i11)) {
                                return createElement;
                            }
                            throw new CLParsingException("incorrect token <" + c11 + "> at line " + this.lineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd((long) (i11 - 1));
            CLElement container = cLElement.getContainer();
            container.setEnd((long) i11);
            return container;
        } else {
            return createElement(cLElement, i11, TYPE.ARRAY, true, cArr);
        }
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i11 = 1;
        this.lineNumber = 1;
        boolean z11 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = -1;
                break;
            }
            char c11 = charArray[i12];
            if (c11 == '{') {
                break;
            }
            if (c11 == 10) {
                this.lineNumber++;
            }
            i12++;
        }
        if (i12 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.lineNumber);
            allocate.setStart((long) i12);
            int i13 = i12 + 1;
            CLElement cLElement = allocate;
            while (i13 < length) {
                char c12 = charArray[i13];
                if (c12 == 10) {
                    this.lineNumber += i11;
                }
                if (this.hasComment) {
                    if (c12 == 10) {
                        this.hasComment = z11;
                    } else {
                        continue;
                        i13++;
                        i11 = 1;
                        z11 = false;
                    }
                }
                if (cLElement == null) {
                    break;
                }
                if (cLElement.isDone()) {
                    cLElement = getNextJsonElement(i13, c12, cLElement, charArray);
                } else if (cLElement instanceof CLObject) {
                    if (c12 == '}') {
                        cLElement.setEnd((long) (i13 - 1));
                    } else {
                        cLElement = getNextJsonElement(i13, c12, cLElement, charArray);
                    }
                } else if (!(cLElement instanceof CLArray)) {
                    boolean z12 = cLElement instanceof CLString;
                    if (z12) {
                        long j11 = cLElement.f10662b;
                        if (charArray[(int) j11] == c12) {
                            cLElement.setStart(j11 + 1);
                            cLElement.setEnd((long) (i13 - 1));
                        }
                    } else {
                        if (cLElement instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLElement;
                            if (!cLToken.validate(c12, (long) i13)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                            }
                        }
                        if ((cLElement instanceof CLKey) || z12) {
                            long j12 = cLElement.f10662b;
                            char c13 = charArray[(int) j12];
                            if ((c13 == '\'' || c13 == '\"') && c13 == c12) {
                                cLElement.setStart(j12 + 1);
                                cLElement.setEnd((long) (i13 - 1));
                            }
                        }
                        if (!cLElement.isDone() && (c12 == '}' || c12 == ']' || c12 == ',' || c12 == ' ' || c12 == 9 || c12 == 13 || c12 == 10 || c12 == ':')) {
                            long j13 = (long) (i13 - 1);
                            cLElement.setEnd(j13);
                            if (c12 == '}' || c12 == ']') {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j13);
                                if (cLElement instanceof CLKey) {
                                    cLElement = cLElement.getContainer();
                                    cLElement.setEnd(j13);
                                }
                            }
                        }
                    }
                } else if (c12 == ']') {
                    cLElement.setEnd((long) (i13 - 1));
                } else {
                    cLElement = getNextJsonElement(i13, c12, cLElement, charArray);
                }
                if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).f10659g.size() > 0)) {
                    cLElement = cLElement.getContainer();
                }
                i13++;
                i11 = 1;
                z11 = false;
            }
            while (cLElement != null && !cLElement.isDone()) {
                if (cLElement instanceof CLString) {
                    cLElement.setStart((long) (((int) cLElement.f10662b) + 1));
                }
                cLElement.setEnd((long) (length - 1));
                cLElement = cLElement.getContainer();
            }
            if (f10669a) {
                System.out.println("Root: " + allocate.toJSON());
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", (CLElement) null);
    }
}
