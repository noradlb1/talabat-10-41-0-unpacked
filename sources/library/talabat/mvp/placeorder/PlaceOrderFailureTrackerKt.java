package library.talabat.mvp.placeorder;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.lib.Integration;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"attributes", "", "", "Llibrary/talabat/mvp/placeorder/PlaceOrderFailure;", "errorMessage", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PlaceOrderFailureTrackerKt {
    /* access modifiers changed from: private */
    public static final Map<String, String> attributes(PlaceOrderFailure placeOrderFailure) {
        Map<String, String> map;
        Integer num;
        NetworkResponse networkResponse;
        Map invoke;
        Function0<Map<String, String>> gemComponentStateRetriever = Integration.getGemComponentStateRetriever();
        if (gemComponentStateRetriever == null || (invoke = gemComponentStateRetriever.invoke()) == null || (map = MapsKt__MapsKt.toMutableMap(invoke)) == null) {
            map = new HashMap<>();
        }
        map.put(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, String.valueOf(placeOrderFailure.getUrl()));
        map.put("requestJson", String.valueOf(placeOrderFailure.getRequest()));
        map.put("response", errorMessage(placeOrderFailure));
        map.put("responseError", String.valueOf(placeOrderFailure.getError()));
        VolleyError error = placeOrderFailure.getError();
        String str = null;
        if (error == null || (networkResponse = error.networkResponse) == null) {
            num = null;
        } else {
            num = Integer.valueOf(networkResponse.statusCode);
        }
        map.put("responseStatusCode", String.valueOf(num));
        VolleyError error2 = placeOrderFailure.getError();
        if (error2 != null) {
            str = error2.getMessage();
        }
        map.put("responseErrorMessage", String.valueOf(str));
        return map;
    }

    private static final String errorMessage(PlaceOrderFailure placeOrderFailure) {
        String str;
        NetworkResponse networkResponse;
        byte[] bArr;
        VolleyError error = placeOrderFailure.getError();
        if (error == null || (networkResponse = error.networkResponse) == null || (bArr = networkResponse.data) == null) {
            str = null;
        } else {
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
            str = new String(bArr, defaultCharset);
        }
        return String.valueOf(str);
    }
}
