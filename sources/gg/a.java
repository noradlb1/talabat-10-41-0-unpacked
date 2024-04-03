package gg;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl;
import io.reactivex.SingleEmitter;
import java.util.List;
import org.json.JSONObject;

public final /* synthetic */ class a implements GraphRequest.GraphJSONObjectCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f56836a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f56837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginDataSourceImpl f56838c;

    public /* synthetic */ a(SingleEmitter singleEmitter, List list, FacebookLoginDataSourceImpl facebookLoginDataSourceImpl) {
        this.f56836a = singleEmitter;
        this.f56837b = list;
        this.f56838c = facebookLoginDataSourceImpl;
    }

    public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
        FacebookLoginDataSourceImpl.m9581requestData$lambda8$lambda7$lambda5(this.f56836a, this.f56837b, this.f56838c, jSONObject, graphResponse);
    }
}
