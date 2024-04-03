package com.talabat.gdm.owin.data.di;

import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/gdm/owin/data/di/GdmOwinTokenComponent;", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenApi;", "Factory", "com_talabat_core_gdm_owin-token_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {GdmOwinTokenModule.class})
public interface GdmOwinTokenComponent extends GdmOwinTokenApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/gdm/owin/data/di/GdmOwinTokenComponent$Factory;", "", "create", "Lcom/talabat/gdm/owin/data/di/GdmOwinTokenComponent;", "com_talabat_core_gdm_owin-token_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        GdmOwinTokenComponent create();
    }
}
