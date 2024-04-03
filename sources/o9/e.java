package o9;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.UiExecutor;

public final /* synthetic */ class e implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return UiExecutor.INSTANCE;
    }
}
