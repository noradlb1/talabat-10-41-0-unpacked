package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33895c = "SX509TM";

    /* renamed from: d  reason: collision with root package name */
    public static final String f33896d = "hmsrootcas.bks";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33897e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final String f33898f = "X509";

    /* renamed from: g  reason: collision with root package name */
    private static final String f33899g = "bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f33900h = "AndroidCAStore";

    /* renamed from: a  reason: collision with root package name */
    public List<X509TrustManager> f33901a;

    /* renamed from: b  reason: collision with root package name */
    private X509Certificate[] f33902b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    private void a() {
        e.c(f33895c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore instance = KeyStore.getInstance(f33900h);
            instance.load((InputStream) null, (char[]) null);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(f33898f);
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f33901a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
            e.b(f33895c, "loadSystemCA: exception : " + e11.getMessage());
        }
        e.a(f33895c, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f33895c, "checkClientTrusted: ");
        for (X509TrustManager checkServerTrusted : this.f33901a) {
            try {
                checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e11) {
                e.b(f33895c, "checkServerTrusted CertificateException" + e11.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        e.c(f33895c, "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            X509Certificate x509Certificate = x509CertificateArr[i11];
            e.a(f33895c, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            e.a(f33895c, "IssuerDN :" + x509Certificate.getIssuerDN());
            e.a(f33895c, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f33901a.size();
        int i12 = 0;
        while (i12 < size) {
            try {
                e.c(f33895c, "check server i=" + i12);
                X509TrustManager x509TrustManager = this.f33901a.get(i12);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    e.c(f33895c, "client root ca size=" + acceptedIssuers.length);
                    for (int i13 = 0; i13 < acceptedIssuers.length; i13++) {
                        e.a(f33895c, "client root ca getIssuerDN :" + acceptedIssuers[i13].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                e.c(f33895c, "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e11) {
                e.b(f33895c, "checkServerTrusted error :" + e11.getMessage() + " , time : " + i12);
                if (i12 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        e.b(f33895c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e11;
                }
                i12++;
            }
        }
        e.a(f33895c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.f33901a) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e11) {
            e.b(f33895c, "getAcceptedIssuers exception : " + e11.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f33902b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f33901a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f33902b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f33901a = list;
    }

    public SecureX509TrustManager(Context context, boolean z11) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f33901a = new ArrayList();
        if (context != null) {
            ContextUtil.setContext(context);
            if (z11) {
                a();
            }
            a(context);
            if (this.f33901a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f33901a = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    private void a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z11;
        e.c(f33895c, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                e.c(f33895c, "get bks not from assets");
                a(filesBksIS);
            } catch (IOException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
                e.b(f33895c, "loadBksCA: exception : " + e11.getMessage());
                z11 = false;
            }
        }
        z11 = true;
        if (!z11 || filesBksIS == null) {
            e.c(f33895c, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
        e.a(f33895c, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str, boolean z11) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f33901a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, "");
                d.a((InputStream) fileInputStream);
                if (z11) {
                    a();
                }
            } catch (Throwable th2) {
                th = th2;
                d.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            d.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z11) throws IllegalArgumentException {
        this.f33901a = new ArrayList();
        if (z11) {
            a();
        }
        a(inputStream, str);
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f33898f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, "".toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f33901a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            d.a(inputStream);
        }
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f33898f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, str.toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f33901a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
            e.b(f33895c, "loadInputStream: exception : " + e11.getMessage());
        } finally {
            d.a(inputStream);
        }
        e.a(f33895c, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
