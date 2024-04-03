package tracking.gtm.automation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import tracking.gtm.automation.utils.JsonUtils;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONArray;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DynamicJsonManager$updateDynamicJson$2 extends Lambda implements Function0<JSONArray> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f63551g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f63552h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<JSONArray> f63553i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicJsonManager$updateDynamicJson$2(String str, Map<String, ? extends Object> map, Function0<? extends JSONArray> function0) {
        super(0);
        this.f63551g = str;
        this.f63552h = map;
        this.f63553i = function0;
    }

    @NotNull
    public final JSONArray invoke() {
        return JsonUtils.Companion.parseAndMapEvents(this.f63551g, (Map<String, ? extends Object>) this.f63552h, this.f63553i.invoke());
    }
}
