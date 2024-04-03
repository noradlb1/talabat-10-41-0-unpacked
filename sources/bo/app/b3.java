package bo.app;

import android.content.Context;
import com.braze.models.IPutIntoJson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&R\u0014\u0010\u0015\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u001fR\u001e\u0010%\u001a\u0004\u0018\u00010!8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u000b\u0010$ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0001"}, d2 = {"Lbo/app/b3;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lbo/app/w2;", "event", "", "b", "", "", "remoteAssetToLocalAssetPaths", "", "a", "Landroid/content/Context;", "context", "Lbo/app/j2;", "internalEventPublisher", "triggerEvent", "", "triggeredActionDisplayExpirationTimestamp", "m", "()Z", "shouldPrefetchAssets", "getId", "()Ljava/lang/String;", "id", "Lbo/app/r2;", "f", "()Lbo/app/r2;", "scheduleConfig", "", "Lbo/app/o4;", "()Ljava/util/List;", "remoteAssetPaths", "Lbo/app/l6;", "i", "()Lbo/app/l6;", "(Lbo/app/l6;)V", "triggerMetadata", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public interface b3 extends IPutIntoJson<JSONObject> {
    void a(Context context, j2 j2Var, w2 w2Var, long j11);

    void a(l6 l6Var);

    void a(Map<String, String> map);

    List<o4> b();

    boolean b(w2 w2Var);

    r2 f();

    String getId();

    l6 i();

    boolean m();
}
