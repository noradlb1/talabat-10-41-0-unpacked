package com.talabat.gms.maps.data;

import android.content.Context;
import com.google.android.gms.maps.MapsInitializer;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultGmsMapsInitializer;", "Lcom/talabat/gms/maps/domain/GmsMapsInitializer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initialize", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsMapsInitializer implements GmsMapsInitializer {
    @NotNull
    private final Context context;

    @Inject
    public DefaultGmsMapsInitializer(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void initialize() {
        MapsInitializer.initialize(this.context);
    }
}
