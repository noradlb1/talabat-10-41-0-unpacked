package org.apache.commons.compress.harmony.unpack200;

import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute;

public class MetadataBandGroup {
    private static CPUTF8 riaUTF8;
    private static CPUTF8 ripaUTF8;
    private static CPUTF8 rvaUTF8;
    private static CPUTF8 rvpaUTF8;
    public int[] T;
    private int T_index;
    public int[] anno_N;
    private int anno_N_Index;
    private List attributes;
    public CPDouble[] caseD_KD;
    private int caseD_KD_Index;
    public CPFloat[] caseF_KF;
    private int caseF_KF_Index;
    public CPInteger[] caseI_KI;
    private int caseI_KI_Index;
    public CPLong[] caseJ_KJ;
    private int caseJ_KJ_Index;
    public int[] casearray_N;
    private int casearray_N_Index;
    public CPUTF8[] casec_RS;
    private int casec_RS_Index;
    public String[] caseec_RU;
    private int caseec_RU_Index;
    public String[] caseet_RS;
    private int caseet_RS_Index;
    public CPUTF8[] cases_RU;
    private int cases_RU_Index;
    private final CpBands cpBands;
    public CPUTF8[] name_RU;
    public CPUTF8[] nestname_RU;
    private Iterator nestname_RU_Iterator;
    public int[] nestpair_N;
    private int nestpair_N_Index;
    public CPUTF8[] nesttype_RS;
    private int nesttype_RS_Index;
    public int[][] pair_N;
    private int pair_N_Index;
    public int[] param_NB;
    private final String type;
    public CPUTF8[][] type_RS;

    public MetadataBandGroup(String str, CpBands cpBands2) {
        this.type = str;
        this.cpBands = cpBands2;
    }

    private AnnotationsAttribute.Annotation getAnnotation(CPUTF8 cputf8, int i11, Iterator it) {
        CPUTF8[] cputf8Arr = new CPUTF8[i11];
        AnnotationsAttribute.ElementValue[] elementValueArr = new AnnotationsAttribute.ElementValue[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cputf8Arr[i12] = (CPUTF8) it.next();
            int[] iArr = this.T;
            int i13 = this.T_index;
            this.T_index = i13 + 1;
            int i14 = iArr[i13];
            elementValueArr[i12] = new AnnotationsAttribute.ElementValue(i14, getNextValue(i14));
        }
        return new AnnotationsAttribute.Annotation(i11, cputf8, cputf8Arr, elementValueArr);
    }

    private Attribute getAttribute(int i11, CPUTF8[] cputf8Arr, int[] iArr, Iterator it) {
        CPUTF8 cputf8;
        AnnotationsAttribute.Annotation[] annotationArr = new AnnotationsAttribute.Annotation[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            annotationArr[i12] = getAnnotation(cputf8Arr[i12], iArr[i12], it);
        }
        if (this.type.equals("RVA")) {
            cputf8 = rvaUTF8;
        } else {
            cputf8 = riaUTF8;
        }
        return new RuntimeVisibleorInvisibleAnnotationsAttribute(cputf8, annotationArr);
    }

    private Object getNextValue(int i11) {
        if (i11 == 64) {
            CPUTF8[] cputf8Arr = this.nesttype_RS;
            int i12 = this.nesttype_RS_Index;
            this.nesttype_RS_Index = i12 + 1;
            CPUTF8 cputf8 = cputf8Arr[i12];
            int[] iArr = this.nestpair_N;
            int i13 = this.nestpair_N_Index;
            this.nestpair_N_Index = i13 + 1;
            return getAnnotation(cputf8, iArr[i13], this.nestname_RU_Iterator);
        } else if (i11 != 70) {
            if (i11 != 83) {
                if (i11 == 99) {
                    CPUTF8[] cputf8Arr2 = this.casec_RS;
                    int i14 = this.casec_RS_Index;
                    this.casec_RS_Index = i14 + 1;
                    return cputf8Arr2[i14];
                } else if (i11 == 101) {
                    StringBuilder sb2 = new StringBuilder();
                    String[] strArr = this.caseet_RS;
                    int i15 = this.caseet_RS_Index;
                    this.caseet_RS_Index = i15 + 1;
                    sb2.append(strArr[i15]);
                    sb2.append(CertificateUtil.DELIMITER);
                    String[] strArr2 = this.caseec_RU;
                    int i16 = this.caseec_RU_Index;
                    this.caseec_RU_Index = i16 + 1;
                    sb2.append(strArr2[i16]);
                    return this.cpBands.cpNameAndTypeValue(sb2.toString());
                } else if (i11 == 115) {
                    CPUTF8[] cputf8Arr3 = this.cases_RU;
                    int i17 = this.cases_RU_Index;
                    this.cases_RU_Index = i17 + 1;
                    return cputf8Arr3[i17];
                } else if (i11 != 73) {
                    if (i11 == 74) {
                        CPLong[] cPLongArr = this.caseJ_KJ;
                        int i18 = this.caseJ_KJ_Index;
                        this.caseJ_KJ_Index = i18 + 1;
                        return cPLongArr[i18];
                    } else if (i11 != 90) {
                        if (i11 != 91) {
                            switch (i11) {
                                case 66:
                                case 67:
                                    break;
                                case 68:
                                    CPDouble[] cPDoubleArr = this.caseD_KD;
                                    int i19 = this.caseD_KD_Index;
                                    this.caseD_KD_Index = i19 + 1;
                                    return cPDoubleArr[i19];
                                default:
                                    return null;
                            }
                        } else {
                            int[] iArr2 = this.casearray_N;
                            int i21 = this.casearray_N_Index;
                            this.casearray_N_Index = i21 + 1;
                            int i22 = iArr2[i21];
                            AnnotationsAttribute.ElementValue[] elementValueArr = new AnnotationsAttribute.ElementValue[i22];
                            for (int i23 = 0; i23 < i22; i23++) {
                                int[] iArr3 = this.T;
                                int i24 = this.T_index;
                                this.T_index = i24 + 1;
                                int i25 = iArr3[i24];
                                elementValueArr[i23] = new AnnotationsAttribute.ElementValue(i25, getNextValue(i25));
                            }
                            return elementValueArr;
                        }
                    }
                }
            }
            CPInteger[] cPIntegerArr = this.caseI_KI;
            int i26 = this.caseI_KI_Index;
            this.caseI_KI_Index = i26 + 1;
            return cPIntegerArr[i26];
        } else {
            CPFloat[] cPFloatArr = this.caseF_KF;
            int i27 = this.caseF_KF_Index;
            this.caseF_KF_Index = i27 + 1;
            return cPFloatArr[i27];
        }
    }

    private Attribute getParameterAttribute(int i11, Iterator it) {
        CPUTF8 cputf8;
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation[] parameterAnnotationArr = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int[] iArr = this.anno_N;
            int i13 = this.anno_N_Index;
            this.anno_N_Index = i13 + 1;
            int i14 = iArr[i13];
            int[][] iArr2 = this.pair_N;
            int i15 = this.pair_N_Index;
            this.pair_N_Index = i15 + 1;
            int[] iArr3 = iArr2[i15];
            AnnotationsAttribute.Annotation[] annotationArr = new AnnotationsAttribute.Annotation[i14];
            for (int i16 = 0; i16 < i14; i16++) {
                annotationArr[i16] = getAnnotation(this.type_RS[this.anno_N_Index - 1][i16], iArr3[i16], it);
            }
            parameterAnnotationArr[i12] = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation(annotationArr);
        }
        if (this.type.equals("RVPA")) {
            cputf8 = rvpaUTF8;
        } else {
            cputf8 = ripaUTF8;
        }
        return new RuntimeVisibleorInvisibleParameterAnnotationsAttribute(cputf8, parameterAnnotationArr);
    }

    public static void setRiaAttributeName(CPUTF8 cputf8) {
        riaUTF8 = cputf8;
    }

    public static void setRipaAttributeName(CPUTF8 cputf8) {
        ripaUTF8 = cputf8;
    }

    public static void setRvaAttributeName(CPUTF8 cputf8) {
        rvaUTF8 = cputf8;
    }

    public static void setRvpaAttributeName(CPUTF8 cputf8) {
        rvpaUTF8 = cputf8;
    }

    public List getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
            CPUTF8[] cputf8Arr = this.name_RU;
            int i11 = 0;
            if (cputf8Arr != null) {
                Iterator it = Arrays.asList(cputf8Arr).iterator();
                if (!this.type.equals("AD")) {
                    this.T_index = 0;
                }
                this.caseI_KI_Index = 0;
                this.caseD_KD_Index = 0;
                this.caseF_KF_Index = 0;
                this.caseJ_KJ_Index = 0;
                this.casec_RS_Index = 0;
                this.caseet_RS_Index = 0;
                this.caseec_RU_Index = 0;
                this.cases_RU_Index = 0;
                this.casearray_N_Index = 0;
                this.nesttype_RS_Index = 0;
                this.nestpair_N_Index = 0;
                this.nestname_RU_Iterator = Arrays.asList(this.nestname_RU).iterator();
                if (this.type.equals("RVA") || this.type.equals("RIA")) {
                    while (true) {
                        int[] iArr = this.anno_N;
                        if (i11 >= iArr.length) {
                            break;
                        }
                        this.attributes.add(getAttribute(iArr[i11], this.type_RS[i11], this.pair_N[i11], it));
                        i11++;
                    }
                } else if (this.type.equals("RVPA") || this.type.equals("RIPA")) {
                    this.anno_N_Index = 0;
                    this.pair_N_Index = 0;
                    while (true) {
                        int[] iArr2 = this.param_NB;
                        if (i11 >= iArr2.length) {
                            break;
                        }
                        this.attributes.add(getParameterAttribute(iArr2[i11], it));
                        i11++;
                    }
                }
            } else if (this.type.equals("AD")) {
                while (i11 < this.T.length) {
                    List list = this.attributes;
                    int i12 = this.T[i11];
                    list.add(new AnnotationDefaultAttribute(new AnnotationsAttribute.ElementValue(i12, getNextValue(i12))));
                    i11++;
                }
            }
        }
        return this.attributes;
    }
}
