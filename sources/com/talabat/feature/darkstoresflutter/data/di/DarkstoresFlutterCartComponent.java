package com.talabat.feature.darkstoresflutter.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/di/DarkstoresFlutterCartComponent;", "Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "Factory", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DarkstoresCartApi.class, DispatcherCoreLibApi.class, ParserCoreLibApi.class}, modules = {DarkstoresFlutterCartModule.class})
public interface DarkstoresFlutterCartComponent extends DarkstoresFlutterCartApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/di/DarkstoresFlutterCartComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstoresflutter/data/di/DarkstoresFlutterCartComponent;", "darkstoresCartApi", "Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresFlutterCartComponent create(@NotNull DarkstoresCartApi darkstoresCartApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi);
    }
}
