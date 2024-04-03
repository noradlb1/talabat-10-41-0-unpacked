package bo.app;

import com.appboy.enums.SdkFlavor;
import com.braze.enums.BrazeSdkMetadata;
import java.util.EnumSet;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u0004H&R\u001e\u0010\f\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u0007\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0007\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\t\u0010\u0010R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010 \u001a\u0004\u0018\u00010\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0007\u0010\u001fR\u001e\u0010%\u001a\u0004\u0018\u00010!8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u0007\u0010$R\u001e\u0010(\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\u001e\u0010+\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u001e\u0010/\u001a\u0004\u0018\u00010,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010-\"\u0004\b\u0007\u0010.R\u001e\u00101\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001e\u00102\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u0007\u0010\u0010R\u001e\u00107\u001a\u0004\u0018\u0001038&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u00104\"\u0004\b5\u00106R*\u0010>\u001a\u0010\u0012\u0004\u0012\u000209\u0018\u000108j\u0004\u0018\u0001`:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b\u0007\u0010=R\u0016\u0010B\u001a\u0004\u0018\u00010?8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010DR\u0014\u0010F\u001a\u00020C8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010Dø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006GÀ\u0006\u0001"}, d2 = {"Lbo/app/c2;", "Lbo/app/o2;", "", "", "Lcom/braze/communication/MutableHttpHeaders;", "existingHeaders", "", "a", "Lbo/app/j0;", "f", "()Lbo/app/j0;", "(Lbo/app/j0;)V", "device", "getDeviceId", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "deviceId", "", "j", "()Ljava/lang/Long;", "(Ljava/lang/Long;)V", "requestInitiationTime", "getApiKey", "apiKey", "getSdkVersion", "g", "sdkVersion", "Lcom/appboy/enums/SdkFlavor;", "getSdkFlavor", "()Lcom/appboy/enums/SdkFlavor;", "(Lcom/appboy/enums/SdkFlavor;)V", "sdkFlavor", "Lbo/app/b4;", "d", "()Lbo/app/b4;", "(Lbo/app/b4;)V", "outboundUser", "getHostAppVersion", "c", "hostAppVersion", "getHostAppSemanticVersionCode", "e", "hostAppSemanticVersionCode", "Lbo/app/k;", "()Lbo/app/k;", "(Lbo/app/k;)V", "customEvents", "k", "sdkAuthSignature", "userId", "Lbo/app/a4;", "()Lbo/app/a4;", "setOutboundRespondWith", "(Lbo/app/a4;)V", "outboundRespondWith", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "Lcom/braze/enums/MetadataTags;", "i", "()Ljava/util/EnumSet;", "(Ljava/util/EnumSet;)V", "sdkMetadata", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "", "()Z", "containsNoNewData", "doesSendOptionalData", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public interface c2 extends o2 {
    String a();

    void a(b4 b4Var);

    void a(j0 j0Var);

    void a(k kVar);

    void a(SdkFlavor sdkFlavor);

    void a(Long l11);

    void a(String str);

    void a(EnumSet<BrazeSdkMetadata> enumSet);

    void a(Map<String, String> map);

    void b(String str);

    boolean b();

    a4 c();

    void c(String str);

    b4 d();

    void d(String str);

    k e();

    void e(String str);

    j0 f();

    void f(String str);

    void g(String str);

    boolean g();

    EnumSet<BrazeSdkMetadata> i();

    Long j();

    String k();

    JSONObject l();
}
