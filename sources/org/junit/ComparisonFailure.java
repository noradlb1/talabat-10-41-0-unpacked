package org.junit;

public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public static class ComparisonCompactor {
        private static final String DIFF_END = "]";
        private static final String DIFF_START = "[";
        private static final String ELLIPSIS = "...";
        /* access modifiers changed from: private */
        public final String actual;
        /* access modifiers changed from: private */
        public final int contextLength;
        /* access modifiers changed from: private */
        public final String expected;

        public class DiffExtractor {
            private final String sharedPrefix;
            private final String sharedSuffix;

            private String extractDiff(String str) {
                return ComparisonCompactor.DIFF_START + str.substring(this.sharedPrefix.length(), str.length() - this.sharedSuffix.length()) + ComparisonCompactor.DIFF_END;
            }

            public String actualDiff() {
                return extractDiff(ComparisonCompactor.this.actual);
            }

            public String compactPrefix() {
                if (this.sharedPrefix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedPrefix;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ComparisonCompactor.ELLIPSIS);
                String str = this.sharedPrefix;
                sb2.append(str.substring(str.length() - ComparisonCompactor.this.contextLength));
                return sb2.toString();
            }

            public String compactSuffix() {
                if (this.sharedSuffix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedSuffix;
                }
                return this.sharedSuffix.substring(0, ComparisonCompactor.this.contextLength) + ComparisonCompactor.ELLIPSIS;
            }

            public String expectedDiff() {
                return extractDiff(ComparisonCompactor.this.expected);
            }

            private DiffExtractor() {
                String a11 = ComparisonCompactor.this.sharedPrefix();
                this.sharedPrefix = a11;
                this.sharedSuffix = ComparisonCompactor.this.sharedSuffix(a11);
            }
        }

        public ComparisonCompactor(int i11, String str, String str2) {
            this.contextLength = i11;
            this.expected = str;
            this.actual = str2;
        }

        /* access modifiers changed from: private */
        public String sharedPrefix() {
            int min = Math.min(this.expected.length(), this.actual.length());
            for (int i11 = 0; i11 < min; i11++) {
                if (this.expected.charAt(i11) != this.actual.charAt(i11)) {
                    return this.expected.substring(0, i11);
                }
            }
            return this.expected.substring(0, min);
        }

        /* access modifiers changed from: private */
        public String sharedSuffix(String str) {
            int min = Math.min(this.expected.length() - str.length(), this.actual.length() - str.length()) - 1;
            int i11 = 0;
            while (i11 <= min) {
                String str2 = this.expected;
                char charAt = str2.charAt((str2.length() - 1) - i11);
                String str3 = this.actual;
                if (charAt != str3.charAt((str3.length() - 1) - i11)) {
                    break;
                }
                i11++;
            }
            String str4 = this.expected;
            return str4.substring(str4.length() - i11);
        }

        public String compact(String str) {
            String str2;
            String str3 = this.expected;
            if (str3 == null || (str2 = this.actual) == null || str3.equals(str2)) {
                return Assert.a(str, this.expected, this.actual);
            }
            DiffExtractor diffExtractor = new DiffExtractor();
            String compactPrefix = diffExtractor.compactPrefix();
            String compactSuffix = diffExtractor.compactSuffix();
            return Assert.a(str, compactPrefix + diffExtractor.expectedDiff() + compactSuffix, compactPrefix + diffExtractor.actualDiff() + compactSuffix);
        }
    }

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    public String getMessage() {
        return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
    }
}
