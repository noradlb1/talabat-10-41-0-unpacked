package gg;

import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

public final /* synthetic */ class c implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginDataSourceImpl f56840a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f56841b;

    public /* synthetic */ c(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl, List list) {
        this.f56840a = facebookLoginDataSourceImpl;
        this.f56841b = list;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        FacebookLoginDataSourceImpl.m9578login$lambda0(this.f56840a, this.f56841b, singleEmitter);
    }
}
