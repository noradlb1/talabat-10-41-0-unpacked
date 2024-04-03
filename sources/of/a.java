package of;

import com.talabat.authentication.token.data.remote.impl.LegacyTokenRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LegacyTokenRemoteDataSourceImpl f57069a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57070b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57071c;

    public /* synthetic */ a(LegacyTokenRemoteDataSourceImpl legacyTokenRemoteDataSourceImpl, String str, String str2) {
        this.f57069a = legacyTokenRemoteDataSourceImpl;
        this.f57070b = str;
        this.f57071c = str2;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        LegacyTokenRemoteDataSourceImpl.m9526swapToLegacyToken$lambda2(this.f57069a, this.f57070b, this.f57071c, singleEmitter);
    }
}
