package ig;

import com.talabat.core.facebook.login.data.dto.FacebookLoginDataRequestDto;
import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return FacebookLoginRepositoryImpl.m9584requestData$lambda2((FacebookLoginDataRequestDto) obj);
    }
}
