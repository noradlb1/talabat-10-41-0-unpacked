package org.apache.commons.compress.harmony.unpack200;

import java.util.ArrayList;

public class IcTuple {
    public static final int NESTED_CLASS_FLAG = 65536;
    protected String C;
    protected String C2;
    protected int F;
    protected String N;
    private boolean anonymous;
    private final int c2Index;
    private final int cIndex;
    private int cachedHashCode;
    private int cachedOuterClassIndex = -1;
    private String cachedOuterClassString;
    private String cachedSimpleClassName;
    private int cachedSimpleClassNameIndex = -1;
    private boolean hashcodeComputed;
    private boolean initialized;
    private boolean member = true;
    private final int nIndex;
    private boolean outerIsAnonymous;
    private boolean predictOuter;
    private boolean predictSimple;
    private final int tIndex;

    public IcTuple(String str, int i11, String str2, String str3, int i12, int i13, int i14, int i15) {
        this.C = str;
        this.F = i11;
        this.C2 = str2;
        this.N = str3;
        this.cIndex = i12;
        this.c2Index = i13;
        this.nIndex = i14;
        this.tIndex = i15;
        if (str3 == null) {
            this.predictSimple = true;
        }
        if (str2 == null) {
            this.predictOuter = true;
        }
        initializeClassStrings();
    }

    private boolean computeOuterIsAnonymous() {
        String[] innerBreakAtDollar = innerBreakAtDollar(this.cachedOuterClassString);
        if (innerBreakAtDollar.length != 0) {
            for (String isAllDigits : innerBreakAtDollar) {
                if (isAllDigits(isAllDigits)) {
                    return true;
                }
            }
            return false;
        }
        throw new Error("Should have an outer before checking if it's anonymous");
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = 17;
        String str = this.C;
        if (str != null) {
            this.cachedHashCode = str.hashCode();
        }
        String str2 = this.C2;
        if (str2 != null) {
            this.cachedHashCode = str2.hashCode();
        }
        String str3 = this.N;
        if (str3 != null) {
            this.cachedHashCode = str3.hashCode();
        }
    }

    private void initializeClassStrings() {
        if (!this.initialized) {
            this.initialized = true;
            if (!this.predictSimple) {
                this.cachedSimpleClassName = this.N;
            }
            if (!this.predictOuter) {
                this.cachedOuterClassString = this.C2;
            }
            String[] innerBreakAtDollar = innerBreakAtDollar(this.C);
            int length = innerBreakAtDollar.length;
            if (innerBreakAtDollar.length >= 2) {
                int length2 = innerBreakAtDollar.length - 1;
                this.cachedSimpleClassName = innerBreakAtDollar[length2];
                this.cachedOuterClassString = "";
                int i11 = 0;
                while (i11 < length2) {
                    this.cachedOuterClassString += innerBreakAtDollar[i11];
                    if (isAllDigits(innerBreakAtDollar[i11])) {
                        this.member = false;
                    }
                    i11++;
                    if (i11 != length2) {
                        this.cachedOuterClassString += '$';
                    }
                }
                if (!this.predictSimple) {
                    this.cachedSimpleClassName = this.N;
                    this.cachedSimpleClassNameIndex = this.nIndex;
                }
                if (!this.predictOuter) {
                    this.cachedOuterClassString = this.C2;
                    this.cachedOuterClassIndex = this.c2Index;
                }
                if (isAllDigits(this.cachedSimpleClassName)) {
                    this.anonymous = true;
                    this.member = false;
                    if (nestedExplicitFlagSet()) {
                        this.member = true;
                    }
                }
                this.outerIsAnonymous = computeOuterIsAnonymous();
            }
        }
    }

    private boolean isAllDigits(String str) {
        if (str == null) {
            return false;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (!Character.isDigit(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        IcTuple icTuple = (IcTuple) obj;
        if (nullSafeEquals(this.C, icTuple.C) && nullSafeEquals(this.C2, icTuple.C2) && nullSafeEquals(this.N, icTuple.N)) {
            return true;
        }
        return false;
    }

    public String getC() {
        return this.C;
    }

    public String getC2() {
        return this.C2;
    }

    public int getF() {
        return this.F;
    }

    public String getN() {
        return this.N;
    }

    public int getTupleIndex() {
        return this.tIndex;
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public String[] innerBreakAtDollar(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        while (i11 < str.length()) {
            if (str.charAt(i11) <= '$') {
                arrayList.add(str.substring(i12, i11));
                i12 = i11 + 1;
            }
            i11++;
            if (i11 >= str.length()) {
                arrayList.add(str.substring(i12));
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            strArr[i13] = (String) arrayList.get(i13);
        }
        return strArr;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public boolean isMember() {
        return this.member;
    }

    public boolean nestedExplicitFlagSet() {
        return (this.F & 65536) == 65536;
    }

    public boolean nullSafeEquals(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public int outerClassIndex() {
        return this.cachedOuterClassIndex;
    }

    public String outerClassString() {
        return this.cachedOuterClassString;
    }

    public boolean outerIsAnonymous() {
        return this.outerIsAnonymous;
    }

    public boolean predicted() {
        return this.predictOuter || this.predictSimple;
    }

    public String simpleClassName() {
        return this.cachedSimpleClassName;
    }

    public int simpleClassNameIndex() {
        return this.cachedSimpleClassNameIndex;
    }

    public int thisClassIndex() {
        if (predicted()) {
            return this.cIndex;
        }
        return -1;
    }

    public String thisClassString() {
        if (predicted()) {
            return this.C;
        }
        return this.C2 + "$" + this.N;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IcTuple ");
        stringBuffer.append('(');
        stringBuffer.append(simpleClassName());
        stringBuffer.append(" in ");
        stringBuffer.append(outerClassString());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
