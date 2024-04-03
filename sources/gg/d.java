package gg;

import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

public final /* synthetic */ class d implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginDataSourceImpl f56842a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f56843b;

    public /* synthetic */ d(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl, List list) {
        this.f56842a = facebookLoginDataSourceImpl;
        this.f56843b = list;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        FacebookLoginDataSourceImpl.m9580requestData$lambda8(this.f56842a, this.f56843b, singleEmitter);
    }
}
