package bo.app;

import com.braze.support.BrazeLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lbo/app/u5;", "", "", "key", "a", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u5 {

    /* renamed from: a  reason: collision with root package name */
    public static final u5 f39456a = new u5();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39457b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while trying to read BrazeLogger tag from system properties.";
        }
    }

    private u5() {
    }

    @JvmStatic
    public static final String a(String str) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            InputStream inputStream = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", str}).getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getRuntime()\n           …             .inputStream");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            String readLine = bufferedReader.readLine();
            Intrinsics.checkNotNullExpressionValue(readLine, "{\n            Runtime.ge…er().readLine()\n        }");
            return readLine;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39456a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f39457b, 4, (Object) null);
            return "";
        }
    }
}
