package l4;

import com.deliveryhero.chatsdk.network.HTTPRepositoryImpl;
import com.deliveryhero.chatsdk.network.http.model.TotalUnreadCountResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return HTTPRepositoryImpl.m8105getTotalUnreadMessagesCount$lambda1((TotalUnreadCountResponse) obj);
    }
}
