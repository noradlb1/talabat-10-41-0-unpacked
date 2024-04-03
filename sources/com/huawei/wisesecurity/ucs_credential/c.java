package com.huawei.wisesecurity.ucs_credential;

import android.annotation.SuppressLint;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {
    public c(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws UcsException {
        super(credentialClient, context, networkCapability);
        b0.b(context);
        if (!b0.a(context)) {
            LogUcs.e("KeyStoreHandler", " keyStoreCertificateChain is off.", new Object[0]);
            throw new UcsException(1022, " keyStoreCertificateChain is off.");
        }
    }

    public Credential a(String str) throws UcsException {
        try {
            if (Integer.parseInt(new JSONObject(str).getString("expire")) == 0) {
                return this.f44868g.genCredentialFromString(str);
            }
            throw new UcsException(1017, "unenable expire.");
        } catch (JSONException e11) {
            throw new UcsException(UcsErrorCode.JSON_ERROR, "parse TSMS resp get json error : " + e11.getMessage());
        } catch (NumberFormatException e12) {
            throw new UcsException(2001, "parse TSMS resp expire error : " + e12.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public String a() throws UcsException {
        byte[] sign;
        b0 a11 = b0.a();
        try {
            if (b0.f44869a.containsAlias("ucs_alias_rootKey")) {
                LogUcs.i("KeyStoreManager", "the alias exists", new Object[0]);
            } else {
                try {
                    KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance.initialize(new KeyGenParameterSpec.Builder("ucs_alias_rootKey", 15).setDigests(new String[]{Constants.SHA256, "SHA-512"}).setKeySize(KfsConstant.KFS_RSA_KEY_LEN_3072).setAttestationChallenge("AndroidKeyStore".getBytes(StandardCharsets.UTF_8)).setSignaturePaddings(new String[]{"PSS"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).build());
                    instance.generateKeyPair();
                    LogUcs.i("KeyStoreManager", "generateKeyPair OK", new Object[0]);
                } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e11) {
                    LogUcs.e("KeyStoreManager", "generateKeyPair failed, " + e11.getMessage(), new Object[0]);
                    throw new UcsKeyStoreException(1022, "generateKeyPair failed , exception " + e11.getMessage());
                }
            }
            try {
                String xVar = new x("PS256", b0.f44869a.getCertificateChain("ucs_alias_rootKey"), "AndroidKS").toString();
                List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.f44863b);
                String wVar = new w(2, 1, this.f44866e, this.f44865d, 1, pkgNameCertFP.get(0), pkgNameCertFP.get(1)).toString();
                if (TextUtils.isEmpty(xVar) || TextUtils.isEmpty(wVar)) {
                    throw new UcsException(1006, "Get signStr error");
                }
                String str = xVar + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + wVar;
                synchronized (b0.f44871c) {
                    try {
                        Signature instance2 = Signature.getInstance("SHA256withRSA/PSS");
                        instance2.initSign(a11.a("ucs_alias_rootKey"));
                        instance2.update(str.getBytes(StandardCharsets.UTF_8));
                        sign = instance2.sign();
                    } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e12) {
                        LogUcs.e("KeyStoreManager", "doSign failed, " + e12.getMessage(), new Object[0]);
                        throw new UcsKeyStoreException(1022, "doSign failed , exception " + e12.getMessage());
                    }
                }
                String base64EncodeToString = StringUtil.base64EncodeToString(sign, 10);
                if (TextUtils.isEmpty(xVar) || TextUtils.isEmpty(wVar) || TextUtils.isEmpty(base64EncodeToString)) {
                    throw new UcsException(1006, "get credential JWS is empty...");
                }
                StringBuilder sb2 = new StringBuilder();
                if (TextUtils.isEmpty(xVar) || TextUtils.isEmpty(wVar)) {
                    throw new UcsException(1006, "Get signStr error");
                }
                sb2.append(xVar + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + wVar);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                sb2.append(base64EncodeToString);
                return sb2.toString();
            } catch (KeyStoreException e13) {
                LogUcs.e("KeyStoreManager", "getCertificateChain failed, " + e13.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "getCertificateChain failed , exception " + e13.getMessage());
            }
        } catch (KeyStoreException e14) {
            LogUcs.e("KeyStoreManager", "containsAlias failed, " + e14.getMessage(), new Object[0]);
            throw new UcsKeyStoreException(1022, "containsAlias failed , exception " + e14.getMessage());
        }
    }

    public String a(NetworkResponse networkResponse) throws UcsException {
        if (networkResponse.isSuccessful()) {
            return networkResponse.getBody();
        }
        ErrorBody fromString = ErrorBody.fromString(networkResponse.getBody());
        String str = "tsms service error, " + fromString.getErrorMessage();
        LogUcs.e("KeyStoreHandler", str, new Object[0]);
        String errorCode = fromString.getErrorCode();
        if ("tsms.1018".equalsIgnoreCase(errorCode) || "tsms.1019".equalsIgnoreCase(errorCode)) {
            b0.c(this.f44863b);
            LogUcs.i("KeyStoreHandler", "turn off androidkeystore CertificateChain", new Object[0]);
        }
        throw new UcsException(1024, str);
    }
}
