package junit.framework;

public class ComparisonCompactor {
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    private static final String ELLIPSIS = "...";
    private String fActual;
    private int fContextLength;
    private String fExpected;
    private int fPrefix;
    private int fSuffix;

    public ComparisonCompactor(int i11, String str, String str2) {
        this.fContextLength = i11;
        this.fExpected = str;
        this.fActual = str2;
    }

    private boolean areStringsEqual() {
        return this.fExpected.equals(this.fActual);
    }

    private String compactString(String str) {
        String str2 = DELTA_START + str.substring(this.fPrefix, (str.length() - this.fSuffix) + 1) + DELTA_END;
        if (this.fPrefix > 0) {
            str2 = computeCommonPrefix() + str2;
        }
        if (this.fSuffix <= 0) {
            return str2;
        }
        return str2 + computeCommonSuffix();
    }

    private String computeCommonPrefix() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.fPrefix > this.fContextLength ? ELLIPSIS : "");
        sb2.append(this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix));
        return sb2.toString();
    }

    private String computeCommonSuffix() {
        String str;
        int min = Math.min((this.fExpected.length() - this.fSuffix) + 1 + this.fContextLength, this.fExpected.length());
        StringBuilder sb2 = new StringBuilder();
        String str2 = this.fExpected;
        sb2.append(str2.substring((str2.length() - this.fSuffix) + 1, min));
        if ((this.fExpected.length() - this.fSuffix) + 1 < this.fExpected.length() - this.fContextLength) {
            str = ELLIPSIS;
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    private void findCommonPrefix() {
        this.fPrefix = 0;
        int min = Math.min(this.fExpected.length(), this.fActual.length());
        while (true) {
            int i11 = this.fPrefix;
            if (i11 < min && this.fExpected.charAt(i11) == this.fActual.charAt(this.fPrefix)) {
                this.fPrefix++;
            } else {
                return;
            }
        }
    }

    private void findCommonSuffix() {
        int length = this.fExpected.length() - 1;
        int length2 = this.fActual.length() - 1;
        while (true) {
            int i11 = this.fPrefix;
            if (length2 < i11 || length < i11 || this.fExpected.charAt(length) != this.fActual.charAt(length2)) {
                this.fSuffix = this.fExpected.length() - length;
            } else {
                length2--;
                length--;
            }
        }
        this.fSuffix = this.fExpected.length() - length;
    }

    public String compact(String str) {
        if (this.fExpected == null || this.fActual == null || areStringsEqual()) {
            return Assert.format(str, this.fExpected, this.fActual);
        }
        findCommonPrefix();
        findCommonSuffix();
        return Assert.format(str, compactString(this.fExpected), compactString(this.fActual));
    }
}
