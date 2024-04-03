package org.apache.commons.compress.harmony.unpack200;

import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;

public class SegmentConstantPool {
    public static final int ALL = 0;
    public static final int CP_CLASS = 7;
    public static final int CP_DESCR = 9;
    public static final int CP_DOUBLE = 5;
    public static final int CP_FIELD = 10;
    public static final int CP_FLOAT = 3;
    public static final int CP_IMETHOD = 12;
    public static final int CP_INT = 2;
    public static final int CP_LONG = 4;
    public static final int CP_METHOD = 11;
    public static final int CP_STRING = 6;
    protected static final String INITSTRING = "<init>";
    protected static final String REGEX_MATCH_ALL = ".*";
    protected static final String REGEX_MATCH_INIT = "^<init>.*";
    public static final int SIGNATURE = 8;
    public static final int UTF_8 = 1;
    private final SegmentConstantPoolArrayCache arrayCache = new SegmentConstantPoolArrayCache();
    private final CpBands bands;

    public SegmentConstantPool(CpBands cpBands) {
        this.bands = cpBands;
    }

    public static boolean regexMatches(String str, String str2) {
        if (REGEX_MATCH_ALL.equals(str)) {
            return true;
        }
        if (!REGEX_MATCH_INIT.equals(str)) {
            throw new Error("regex trying to match a pattern I don't know: " + str);
        } else if (str2.length() < 6) {
            return false;
        } else {
            return "<init>".equals(str2.substring(0, 6));
        }
    }

    public ConstantPoolEntry getClassPoolEntry(String str) {
        int matchSpecificPoolEntryIndex = matchSpecificPoolEntryIndex(this.bands.getCpClass(), str, 0);
        if (matchSpecificPoolEntryIndex == -1) {
            return null;
        }
        try {
            return getConstantPoolEntry(7, (long) matchSpecificPoolEntryIndex);
        } catch (Pack200Exception unused) {
            throw new Error("Error getting class pool entry");
        }
    }

    public ConstantPoolEntry getClassSpecificPoolEntry(int i11, long j11, String str) throws Pack200Exception {
        String[] strArr;
        int i12 = (int) j11;
        if (i11 == 10) {
            strArr = this.bands.getCpFieldClass();
        } else if (i11 == 11) {
            strArr = this.bands.getCpMethodClass();
        } else if (i11 == 12) {
            strArr = this.bands.getCpIMethodClass();
        } else {
            throw new Error("Don't know how to handle " + i11);
        }
        return getConstantPoolEntry(i11, (long) matchSpecificPoolEntryIndex(strArr, str, i12));
    }

    public ConstantPoolEntry getConstantPoolEntry(int i11, long j11) throws Pack200Exception {
        int i12 = (int) j11;
        if (i12 == -1) {
            return null;
        }
        if (i12 < 0) {
            throw new Pack200Exception("Cannot have a negative range");
        } else if (i11 == 1) {
            return this.bands.cpUTF8Value(i12);
        } else {
            if (i11 == 2) {
                return this.bands.cpIntegerValue(i12);
            }
            if (i11 == 3) {
                return this.bands.cpFloatValue(i12);
            }
            if (i11 == 4) {
                return this.bands.cpLongValue(i12);
            }
            if (i11 == 5) {
                return this.bands.cpDoubleValue(i12);
            }
            if (i11 == 6) {
                return this.bands.cpStringValue(i12);
            }
            if (i11 == 7) {
                return this.bands.cpClassValue(i12);
            }
            if (i11 == 8) {
                throw new Error("I don't know what to do with signatures yet");
            } else if (i11 == 9) {
                throw new Error("I don't know what to do with descriptors yet");
            } else if (i11 == 10) {
                return this.bands.cpFieldValue(i12);
            } else {
                if (i11 == 11) {
                    return this.bands.cpMethodValue(i12);
                }
                if (i11 == 12) {
                    return this.bands.cpIMethodValue(i12);
                }
                throw new Error("Get value incomplete");
            }
        }
    }

    public ConstantPoolEntry getInitMethodPoolEntry(int i11, long j11, String str) throws Pack200Exception {
        if (i11 == 11) {
            return getConstantPoolEntry(i11, (long) matchSpecificPoolEntryIndex(this.bands.getCpMethodClass(), this.bands.getCpMethodDescriptor(), str, REGEX_MATCH_INIT, (int) j11));
        }
        throw new Error("Nothing but CP_METHOD can be an <init>");
    }

    public ClassFileEntry getValue(int i11, long j11) throws Pack200Exception {
        int i12 = (int) j11;
        if (i12 == -1) {
            return null;
        }
        if (i12 < 0) {
            throw new Pack200Exception("Cannot have a negative range");
        } else if (i11 == 1) {
            return this.bands.cpUTF8Value(i12);
        } else {
            if (i11 == 2) {
                return this.bands.cpIntegerValue(i12);
            }
            if (i11 == 3) {
                return this.bands.cpFloatValue(i12);
            }
            if (i11 == 4) {
                return this.bands.cpLongValue(i12);
            }
            if (i11 == 5) {
                return this.bands.cpDoubleValue(i12);
            }
            if (i11 == 6) {
                return this.bands.cpStringValue(i12);
            }
            if (i11 == 7) {
                return this.bands.cpClassValue(i12);
            }
            if (i11 == 8) {
                return this.bands.cpSignatureValue(i12);
            }
            if (i11 == 9) {
                return this.bands.cpNameAndTypeValue(i12);
            }
            throw new Error("Tried to get a value I don't know about: " + i11);
        }
    }

    public int matchSpecificPoolEntryIndex(String[] strArr, String str, int i11) {
        return matchSpecificPoolEntryIndex(strArr, strArr, str, REGEX_MATCH_ALL, i11);
    }

    public int matchSpecificPoolEntryIndex(String[] strArr, String[] strArr2, String str, String str2, int i11) {
        List indexesForArrayKey = this.arrayCache.indexesForArrayKey(strArr, str);
        if (indexesForArrayKey.isEmpty()) {
            return -1;
        }
        int i12 = -1;
        for (int i13 = 0; i13 < indexesForArrayKey.size(); i13++) {
            int intValue = ((Integer) indexesForArrayKey.get(i13)).intValue();
            if (regexMatches(str2, strArr2[intValue]) && (i12 = i12 + 1) == i11) {
                return intValue;
            }
        }
        return -1;
    }
}
