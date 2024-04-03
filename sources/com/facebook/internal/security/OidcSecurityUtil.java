package com.facebook.internal.security;

import a7.a;
import android.util.Base64;
import com.facebook.FacebookSdk;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", "", "()V", "OPENID_KEYS_PATH", "", "getOPENID_KEYS_PATH", "()Ljava/lang/String;", "SIGNATURE_ALGORITHM_SHA256", "TIMEOUT_IN_MILLISECONDS", "", "getPublicKeyFromString", "Ljava/security/PublicKey;", "key", "getRawKeyFromEndPoint", "kid", "verify", "", "publicKey", "data", "signature", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OidcSecurityUtil {
    @NotNull
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();
    @NotNull
    private static final String OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";
    @NotNull
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";
    public static final long TIMEOUT_IN_MILLISECONDS = 5000;

    private OidcSecurityUtil() {
    }

    @JvmStatic
    @NotNull
    public static final PublicKey getPublicKeyFromString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        byte[] decode = Base64.decode(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, StringUtils.LF, "", false, 4, (Object) null), "-----BEGIN PUBLIC KEY-----", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        Intrinsics.checkNotNullExpressionValue(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX INFO: finally extract failed */
    @JvmStatic
    @Nullable
    public static final String getRawKeyFromEndPoint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "kid");
        URL url = new URL("https", Intrinsics.stringPlus("www.", FacebookSdk.getFacebookDomain()), OPENID_KEYS_PATH);
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FacebookSdk.getExecutor().execute(new a(url, objectRef, str, reentrantLock, newCondition));
        reentrantLock.lock();
        try {
            newCondition.await(5000, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) objectRef.element;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getRawKeyFromEndPoint$lambda-1  reason: not valid java name */
    public static final void m8985getRawKeyFromEndPoint$lambda1(URL url, Ref.ObjectRef objectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(url, "$openIdKeyUrl");
        Intrinsics.checkNotNullParameter(objectRef, "$result");
        Intrinsics.checkNotNullParameter(str, "$kid");
        Intrinsics.checkNotNullParameter(reentrantLock, "$lock");
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection()));
        if (uRLConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                String readText = TextStreamsKt.readText(bufferedReader);
                httpURLConnection.getInputStream().close();
                objectRef.element = new JSONObject(readText).optString(str);
                httpURLConnection.disconnect();
                reentrantLock.lock();
                try {
                    condition.signal();
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } catch (Exception e11) {
                try {
                    INSTANCE.getClass();
                    e11.getMessage();
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th3) {
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                    Unit unit3 = Unit.INSTANCE;
                    throw th3;
                } finally {
                    reentrantLock.unlock();
                }
            } catch (Throwable th4) {
                throw th4;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
    }

    @JvmStatic
    public static final boolean verify(@NotNull PublicKey publicKey, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, "signature");
        try {
            Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
            instance.initVerify(publicKey);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] decode = Base64.decode(str2, 8);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(signature, Base64.URL_SAFE)");
            return instance.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }

    @NotNull
    public final String getOPENID_KEYS_PATH() {
        return OPENID_KEYS_PATH;
    }
}
