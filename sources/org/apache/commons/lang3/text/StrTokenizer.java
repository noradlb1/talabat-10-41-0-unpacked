package org.apache.commons.lang3.text;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StrTokenizer implements ListIterator<String>, Cloneable, Iterator {
    private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE;
    private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
    private char[] chars;
    private StrMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StrMatcher ignoredMatcher;
    private StrMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StrMatcher trimmerMatcher;

    static {
        StrTokenizer strTokenizer = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = strTokenizer;
        strTokenizer.setDelimiterMatcher(StrMatcher.commaMatcher());
        strTokenizer.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer.setEmptyTokenAsNull(false);
        strTokenizer.setIgnoreEmptyTokens(false);
        StrTokenizer strTokenizer2 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = strTokenizer2;
        strTokenizer2.setDelimiterMatcher(StrMatcher.tabMatcher());
        strTokenizer2.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer2.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer2.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer2.setEmptyTokenAsNull(false);
        strTokenizer2.setIgnoreEmptyTokens(false);
    }

    public StrTokenizer() {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List<String> list, String str) {
        if (StringUtils.isEmpty(str)) {
            if (!isIgnoreEmptyTokens()) {
                if (isEmptyTokenAsNull()) {
                    str = null;
                }
            } else {
                return;
            }
        }
        list.add(str);
    }

    private void checkTokenized() {
        if (this.tokens == null) {
            char[] cArr = this.chars;
            if (cArr == null) {
                List<String> list = tokenize((char[]) null, 0, 0);
                this.tokens = (String[]) list.toArray(new String[list.size()]);
                return;
            }
            List<String> list2 = tokenize(cArr, 0, cArr.length);
            this.tokens = (String[]) list2.toArray(new String[list2.size()]);
        }
    }

    private static StrTokenizer getCSVClone() {
        return (StrTokenizer) CSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getCSVInstance() {
        return getCSVClone();
    }

    private static StrTokenizer getTSVClone() {
        return (StrTokenizer) TSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getTSVInstance() {
        return getTSVClone();
    }

    private boolean isQuote(char[] cArr, int i11, int i12, int i13, int i14) {
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = i11 + i15;
            if (i16 >= i12 || cArr[i16] != cArr[i13 + i15]) {
                return false;
            }
        }
        return true;
    }

    private int readNextToken(char[] cArr, int i11, int i12, StrBuilder strBuilder, List<String> list) {
        while (i11 < i12) {
            int max = Math.max(getIgnoredMatcher().isMatch(cArr, i11, i11, i12), getTrimmerMatcher().isMatch(cArr, i11, i11, i12));
            if (max == 0 || getDelimiterMatcher().isMatch(cArr, i11, i11, i12) > 0 || getQuoteMatcher().isMatch(cArr, i11, i11, i12) > 0) {
                break;
            }
            i11 += max;
        }
        if (i11 >= i12) {
            addToken(list, "");
            return -1;
        }
        int isMatch = getDelimiterMatcher().isMatch(cArr, i11, i11, i12);
        if (isMatch > 0) {
            addToken(list, "");
            return i11 + isMatch;
        }
        int isMatch2 = getQuoteMatcher().isMatch(cArr, i11, i11, i12);
        if (isMatch2 <= 0) {
            return readWithQuotes(cArr, i11, i12, strBuilder, list, 0, 0);
        }
        return readWithQuotes(cArr, i11 + isMatch2, i12, strBuilder, list, i11, isMatch2);
    }

    private int readWithQuotes(char[] cArr, int i11, int i12, StrBuilder strBuilder, List<String> list, int i13, int i14) {
        boolean z11;
        char[] cArr2 = cArr;
        int i15 = i11;
        int i16 = i12;
        StrBuilder strBuilder2 = strBuilder;
        List<String> list2 = list;
        int i17 = i14;
        strBuilder.clear();
        if (i17 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        int i18 = i15;
        int i19 = 0;
        while (i18 < i16) {
            if (z12) {
                int i21 = i19;
                int i22 = i18;
                if (isQuote(cArr, i18, i12, i13, i14)) {
                    int i23 = i22 + i17;
                    if (isQuote(cArr, i23, i12, i13, i14)) {
                        strBuilder2.append(cArr2, i22, i17);
                        i18 = i22 + (i17 * 2);
                        i19 = strBuilder.size();
                    } else {
                        i19 = i21;
                        i18 = i23;
                        z12 = false;
                    }
                } else {
                    i18 = i22 + 1;
                    strBuilder2.append(cArr2[i22]);
                    i19 = strBuilder.size();
                }
            } else {
                int i24 = i19;
                int i25 = i18;
                int isMatch = getDelimiterMatcher().isMatch(cArr2, i25, i15, i16);
                if (isMatch > 0) {
                    addToken(list2, strBuilder2.substring(0, i24));
                    return i25 + isMatch;
                } else if (i17 <= 0 || !isQuote(cArr, i25, i12, i13, i14)) {
                    int isMatch2 = getIgnoredMatcher().isMatch(cArr2, i25, i15, i16);
                    if (isMatch2 <= 0) {
                        isMatch2 = getTrimmerMatcher().isMatch(cArr2, i25, i15, i16);
                        if (isMatch2 > 0) {
                            strBuilder2.append(cArr2, i25, isMatch2);
                        } else {
                            i18 = i25 + 1;
                            strBuilder2.append(cArr2[i25]);
                            i19 = strBuilder.size();
                        }
                    }
                    i18 = i25 + isMatch2;
                    i19 = i24;
                } else {
                    i18 = i25 + i17;
                    i19 = i24;
                    z12 = true;
                }
            }
        }
        addToken(list2, strBuilder2.substring(0, i19));
        return -1;
    }

    public Object clone() {
        try {
            return cloneReset();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object cloneReset() throws CloneNotSupportedException {
        StrTokenizer strTokenizer = (StrTokenizer) super.clone();
        char[] cArr = strTokenizer.chars;
        if (cArr != null) {
            strTokenizer.chars = (char[]) cArr.clone();
        }
        strTokenizer.reset();
        return strTokenizer;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public String getContent() {
        char[] cArr = this.chars;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public StrMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StrMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StrMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public String[] getTokenArray() {
        checkTokenized();
        return (String[]) this.tokens.clone();
    }

    public List<String> getTokenList() {
        checkTokenized();
        ArrayList arrayList = new ArrayList(this.tokens.length);
        for (String add : this.tokens) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public StrMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    public boolean hasNext() {
        checkTokenized();
        if (this.tokenPos < this.tokens.length) {
            return true;
        }
        return false;
    }

    public boolean hasPrevious() {
        checkTokenized();
        if (this.tokenPos > 0) {
            return true;
        }
        return false;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    public int nextIndex() {
        return this.tokenPos;
    }

    public String nextToken() {
        if (!hasNext()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i11 = this.tokenPos;
        this.tokenPos = i11 + 1;
        return strArr[i11];
    }

    public int previousIndex() {
        return this.tokenPos - 1;
    }

    public String previousToken() {
        if (!hasPrevious()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i11 = this.tokenPos - 1;
        this.tokenPos = i11;
        return strArr[i11];
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public StrTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    public StrTokenizer setDelimiterChar(char c11) {
        return setDelimiterMatcher(StrMatcher.charMatcher(c11));
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            this.delimMatcher = StrMatcher.noneMatcher();
        } else {
            this.delimMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z11) {
        this.emptyAsNull = z11;
        return this;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z11) {
        this.ignoreEmptyTokens = z11;
        return this;
    }

    public StrTokenizer setIgnoredChar(char c11) {
        return setIgnoredMatcher(StrMatcher.charMatcher(c11));
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.ignoredMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setQuoteChar(char c11) {
        return setQuoteMatcher(StrMatcher.charMatcher(c11));
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.quoteMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.trimmerMatcher = strMatcher;
        }
        return this;
    }

    public int size() {
        checkTokenized();
        return this.tokens.length;
    }

    public String toString() {
        if (this.tokens == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + getTokenList();
    }

    public List<String> tokenize(char[] cArr, int i11, int i12) {
        if (cArr == null || i12 == 0) {
            return Collections.emptyList();
        }
        StrBuilder strBuilder = new StrBuilder();
        ArrayList arrayList = new ArrayList();
        int i13 = i11;
        while (i13 >= 0 && i13 < i12) {
            i13 = readNextToken(cArr, i13, i12, strBuilder, arrayList);
            if (i13 >= i12) {
                addToken(arrayList, "");
            }
        }
        return arrayList;
    }

    public static StrTokenizer getCSVInstance(String str) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(str);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(String str) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(str);
        return tSVClone;
    }

    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public String next() {
        if (hasNext()) {
            String[] strArr = this.tokens;
            int i11 = this.tokenPos;
            this.tokenPos = i11 + 1;
            return strArr[i11];
        }
        throw new NoSuchElementException();
    }

    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.tokens;
            int i11 = this.tokenPos - 1;
            this.tokenPos = i11;
            return strArr[i11];
        }
        throw new NoSuchElementException();
    }

    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public StrTokenizer reset(String str) {
        reset();
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
        return this;
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(cArr);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(cArr);
        return tSVClone;
    }

    public StrTokenizer reset(char[] cArr) {
        reset();
        this.chars = ArrayUtils.clone(cArr);
        return this;
    }

    public StrTokenizer(String str) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
    }

    public StrTokenizer(String str, char c11) {
        this(str);
        setDelimiterChar(c11);
    }

    public StrTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(String str, char c11, char c12) {
        this(str, c11);
        setQuoteChar(c12);
    }

    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = ArrayUtils.clone(cArr);
    }

    public StrTokenizer(char[] cArr, char c11) {
        this(cArr);
        setDelimiterChar(c11);
    }

    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(char[] cArr, char c11, char c12) {
        this(cArr, c11);
        setQuoteChar(c12);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        setQuoteMatcher(strMatcher2);
    }
}
