package m4;

import com.deliveryhero.chatsdk.network.websocket.converter.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.lang.reflect.Type;
import java.util.Set;

public final /* synthetic */ class a implements JsonAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolymorphicJsonAdapterFactory f34556a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f34557b;

    public /* synthetic */ a(PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactory, Object obj) {
        this.f34556a = polymorphicJsonAdapterFactory;
        this.f34557b = obj;
    }

    public final JsonAdapter create(Type type, Set set, Moshi moshi) {
        return PolymorphicJsonAdapterFactory.m8108buildFallbackJsonAdapterFactory$lambda1(this.f34556a, this.f34557b, type, set, moshi);
    }
}
