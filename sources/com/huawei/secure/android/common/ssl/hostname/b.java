package com.huawei.secure.android.common.ssl.hostname;

import com.apptimize.ed;
import com.huawei.secure.android.common.ssl.util.e;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.Typography;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33935a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33936b;

    static {
        String[] strArr = {"ac", "co", "com", ed.f42236a, "edu", "go", "gouv", "gov", CustomerInfoLocalDataSourceImpl.KEY, "lg", "ne", "net", "or", "org"};
        f33936b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z11) throws SSLException {
        String[] a11 = a(x509Certificate);
        String[] b11 = b(x509Certificate);
        e.a("", "cn is : " + Arrays.toString(a11));
        e.a("", "san is : " + Arrays.toString(b11));
        a(str, a11, b11, z11);
    }

    public static String[] b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e11) {
            e.a("", "Error parsing certificate.", e11);
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == 2) {
                    linkedList.add((String) next.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean c(String str) {
        return f33935a.matcher(str).matches();
    }

    public static final void a(String str, String[] strArr, String[] strArr2, boolean z11) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || (str2 = strArr[0]) == null)) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z12 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append(Typography.greater);
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (!endsWith || !z11) {
                        z12 = endsWith;
                        continue;
                    } else if (b(lowerCase) == b(lowerCase2)) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                } else {
                    z12 = lowerCase.equals(lowerCase2);
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            if (!z12) {
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + stringBuffer);
            }
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    public static int b(String str) {
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == '.') {
                i11++;
            }
        }
        return i11;
    }

    public static boolean a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i11 = length - 3;
        if (str.charAt(i11) != '.') {
            return true;
        }
        if (Arrays.binarySearch(f33936b, str.substring(2, i11)) < 0) {
            return true;
        }
        return false;
    }

    public static String[] a(X509Certificate x509Certificate) {
        List<String> b11 = new a(x509Certificate.getSubjectX500Principal()).b("cn");
        if (b11.isEmpty()) {
            return null;
        }
        String[] strArr = new String[b11.size()];
        b11.toArray(strArr);
        return strArr;
    }
}
