package k6;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import org.json.JSONObject;

public final /* synthetic */ class m implements FacebookSdk.GraphRequestCreator {
    public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return FacebookSdk.m8861graphRequestCreator$lambda0(accessToken, str, jSONObject, callback);
    }
}
