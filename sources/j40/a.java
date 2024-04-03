package j40;

import com.android.volley.Response;
import org.json.JSONObject;
import tracking.perseus.TalabatPerseus;

public final /* synthetic */ class a implements Response.Listener {
    public final void onResponse(Object obj) {
        TalabatPerseus.Companion.m10952dispatchPerseusEvent$lambda1((JSONObject) obj);
    }
}
