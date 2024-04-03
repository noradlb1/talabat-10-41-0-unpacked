package com.huawei.wisesecurity.ucs_credential;

import java.security.cert.X509Certificate;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile X509Certificate f44861a;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r2 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate a(android.content.Context r2, java.lang.String r3) throws com.huawei.wisesecurity.ucs.common.exception.UcsException {
        /*
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x002a, CertificateException -> 0x0028 }
            java.io.InputStream r2 = r2.open(r3)     // Catch:{ IOException -> 0x002a, CertificateException -> 0x0028 }
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch:{ all -> 0x001a }
            java.security.cert.Certificate r3 = r3.generateCertificate(r2)     // Catch:{ all -> 0x001a }
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x0019
            r2.close()     // Catch:{ IOException -> 0x002a, CertificateException -> 0x0028 }
        L_0x0019:
            return r3
        L_0x001a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001c }
        L_0x001c:
            r0 = move-exception
            if (r2 == 0) goto L_0x0027
            r2.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ IOException -> 0x002a, CertificateException -> 0x0028 }
        L_0x0027:
            throw r0     // Catch:{ IOException -> 0x002a, CertificateException -> 0x0028 }
        L_0x0028:
            r2 = move-exception
            goto L_0x002b
        L_0x002a:
            r2 = move-exception
        L_0x002b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Read root cert error "
            r3.append(r0)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = "CertVerifier"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r0, r2, r3)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r3 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            r0 = 1012(0x3f4, double:5.0E-321)
            r3.<init>(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.a0.a(android.content.Context, java.lang.String):java.security.cert.X509Certificate");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0055, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9, com.huawei.wisesecurity.ucs_credential.h r10) throws com.huawei.wisesecurity.ucs.common.exception.UcsException {
        /*
            java.security.cert.X509Certificate r0 = f44861a
            if (r0 != 0) goto L_0x0018
            java.lang.Class<com.huawei.wisesecurity.ucs_credential.a0> r0 = com.huawei.wisesecurity.ucs_credential.a0.class
            monitor-enter(r0)
            java.security.cert.X509Certificate r1 = f44861a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "cbg_root.cer"
            java.security.cert.X509Certificate r9 = a((android.content.Context) r9, (java.lang.String) r1)     // Catch:{ all -> 0x0015 }
            f44861a = r9     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r9
        L_0x0018:
            com.huawei.wisesecurity.ucs_credential.h$a r9 = r10.f44874a
            java.lang.String[] r9 = r9.f44879b
            r0 = 1012(0x3f4, double:5.0E-321)
            if (r9 == 0) goto L_0x01b8
            int r2 = r9.length
            if (r2 == 0) goto L_0x01b8
            int r2 = r9.length
            java.security.cert.X509Certificate[] r3 = new java.security.cert.X509Certificate[r2]
            r4 = 0
            r5 = r4
        L_0x0028:
            int r6 = r9.length
            if (r5 >= r6) goto L_0x0063
            r6 = r9[r5]
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
            byte[] r6 = com.huawei.wisesecurity.ucs.common.utils.StringUtil.base64Decode(r6, r4)     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
            java.lang.String r6 = "X.509"
            java.security.cert.CertificateFactory r6 = java.security.cert.CertificateFactory.getInstance(r6)     // Catch:{ all -> 0x004a }
            java.security.cert.Certificate r6 = r6.generateCertificate(r7)     // Catch:{ all -> 0x004a }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ all -> 0x004a }
            r7.close()     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
            r3[r5] = r6
            int r5 = r5 + 1
            goto L_0x0028
        L_0x004a:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004c }
        L_0x004c:
            r10 = move-exception
            r7.close()     // Catch:{ all -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r2 = move-exception
            r9.addSuppressed(r2)     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
        L_0x0055:
            throw r10     // Catch:{ IOException -> 0x0058, CertificateException -> 0x0056 }
        L_0x0056:
            r9 = move-exception
            goto L_0x0059
        L_0x0058:
            r9 = move-exception
        L_0x0059:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r10 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            java.lang.String r9 = r9.getMessage()
            r10.<init>(r0, r9)
            throw r10
        L_0x0063:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "Start verify cert chain using root ca: "
            r9.append(r5)
            java.security.cert.X509Certificate r5 = f44861a
            java.security.Principal r5 = r5.getSubjectDN()
            java.lang.String r5 = r5.getName()
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "CertVerifier"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r6, r9, r5)
            r9 = r4
        L_0x0086:
            r5 = 1
            int r6 = r2 + -1
            if (r9 >= r6) goto L_0x00e3
            java.lang.String r5 = "CertVerifier"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r6.<init>()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r7 = "verify cert "
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r7 = r3[r9]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.security.Principal r7 = r7.getSubjectDN()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r7 = r7.getName()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r6 = r6.toString()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r5, r6, r7)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r5 = "CertVerifier"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r6.<init>()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r7 = "using "
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            int r7 = r9 + 1
            r8 = r3[r7]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.security.Principal r8 = r8.getSubjectDN()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r8 = r8.getName()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r6.append(r8)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.String r6 = r6.toString()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r5, r6, r8)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r5 = r3[r9]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r5.checkValidity()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r5 = r3[r7]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.security.PublicKey r5 = r5.getPublicKey()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r9 = r3[r9]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r9.verify(r5)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r9 = r7
            goto L_0x0086
        L_0x00e3:
            java.security.cert.X509Certificate r9 = f44861a     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            java.security.PublicKey r9 = r9.getPublicKey()     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r2 = r3[r6]     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r2.verify(r9)     // Catch:{ RuntimeException -> 0x0195, CertificateException -> 0x0193, InvalidKeyException -> 0x0191, NoSuchAlgorithmException -> 0x018f, NoSuchProviderException -> 0x018d, SignatureException -> 0x018b }
            r9 = r3[r4]
            java.security.Principal r9 = r9.getSubjectDN()
            java.lang.String r9 = r9.getName()
            java.lang.String r2 = ","
            java.lang.String[] r9 = r9.split(r2)
            int r2 = r9.length
            r6 = r4
        L_0x0100:
            if (r6 >= r2) goto L_0x011d
            r7 = r9[r6]
            java.lang.String r8 = "OU="
            boolean r8 = r7.startsWith(r8)
            if (r8 == 0) goto L_0x011a
            r8 = 3
            java.lang.String r7 = r7.substring(r8)
            java.lang.String r8 = "Huawei CBG Cloud Security Signer"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x011a
            goto L_0x011e
        L_0x011a:
            int r6 = r6 + 1
            goto L_0x0100
        L_0x011d:
            r5 = r4
        L_0x011e:
            if (r5 == 0) goto L_0x0183
            r9 = r3[r4]
            java.lang.String r2 = "RS256"
            com.huawei.wisesecurity.ucs_credential.h$a r3 = r10.f44874a     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            java.lang.String r3 = r3.f44878a     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            boolean r2 = r2.equals(r3)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            if (r2 == 0) goto L_0x0131
            java.lang.String r2 = "SHA256WithRSA"
            goto L_0x0133
        L_0x0131:
            java.lang.String r2 = "SHA256WithRSA/PSS"
        L_0x0133:
            java.security.Signature r2 = java.security.Signature.getInstance(r2)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            java.security.PublicKey r9 = r9.getPublicKey()     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            r2.initVerify(r9)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            java.lang.String r9 = r10.f44877d     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            byte[] r9 = r9.getBytes(r3)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            r2.update(r9)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            byte[] r9 = r10.f44876c     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            boolean r9 = r2.verify(r9)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            if (r9 == 0) goto L_0x0152
            return
        L_0x0152:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r9 = new com.huawei.wisesecurity.ucs.common.exception.UcsException     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            java.lang.String r10 = "signature not verify"
            r9.<init>(r0, r10)     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
            throw r9     // Catch:{ RuntimeException -> 0x0160, NoSuchAlgorithmException -> 0x015e, InvalidKeyException -> 0x015c, SignatureException -> 0x015a }
        L_0x015a:
            r9 = move-exception
            goto L_0x0161
        L_0x015c:
            r9 = move-exception
            goto L_0x0161
        L_0x015e:
            r9 = move-exception
            goto L_0x0161
        L_0x0160:
            r9 = move-exception
        L_0x0161:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "verify signature of c1 failed, exception "
            r10.append(r2)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r4]
            java.lang.String r2 = "CertVerifier"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r2, r9, r10)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r10 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            r10.<init>(r0, r9)
            throw r10
        L_0x0183:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r9 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            java.lang.String r10 = "Subject OU not verify"
            r9.<init>(r0, r10)
            throw r9
        L_0x018b:
            r9 = move-exception
            goto L_0x0196
        L_0x018d:
            r9 = move-exception
            goto L_0x0196
        L_0x018f:
            r9 = move-exception
            goto L_0x0196
        L_0x0191:
            r9 = move-exception
            goto L_0x0196
        L_0x0193:
            r9 = move-exception
            goto L_0x0196
        L_0x0195:
            r9 = move-exception
        L_0x0196:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "verify cert chain failed , exception "
            r10.append(r2)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r4]
            java.lang.String r2 = "CertVerifier"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r2, r9, r10)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r10 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            r10.<init>(r0, r9)
            throw r10
        L_0x01b8:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r9 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            java.lang.String r10 = "verify cert chain failed , certs is empty.."
            r9.<init>(r0, r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.a0.a(android.content.Context, com.huawei.wisesecurity.ucs_credential.h):void");
    }
}
