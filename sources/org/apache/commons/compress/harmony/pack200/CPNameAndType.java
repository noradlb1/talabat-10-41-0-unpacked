package org.apache.commons.compress.harmony.pack200;

import com.facebook.internal.security.CertificateUtil;

public class CPNameAndType extends ConstantPoolEntry implements Comparable {

    /* renamed from: name  reason: collision with root package name */
    private final CPUTF8 f27732name;
    private final CPSignature signature;

    public CPNameAndType(CPUTF8 cputf8, CPSignature cPSignature) {
        this.f27732name = cputf8;
        this.signature = cPSignature;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof CPNameAndType)) {
            return 0;
        }
        CPNameAndType cPNameAndType = (CPNameAndType) obj;
        int compareTo = this.signature.compareTo(cPNameAndType.signature);
        if (compareTo == 0) {
            return this.f27732name.compareTo(cPNameAndType.f27732name);
        }
        return compareTo;
    }

    public String getName() {
        return this.f27732name.getUnderlyingString();
    }

    public int getNameIndex() {
        return this.f27732name.getIndex();
    }

    public int getTypeIndex() {
        return this.signature.getIndex();
    }

    public String toString() {
        return this.f27732name + CertificateUtil.DELIMITER + this.signature;
    }
}
