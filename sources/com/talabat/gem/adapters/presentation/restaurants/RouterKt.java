package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.views.StartForResultExecutor;
import com.talabat.talabatcommon.views.StartForResultKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¨\u0006\u0006"}, d2 = {"startActivityForResult", "Lcom/talabat/talabatcommon/views/StartForResultExecutor;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Landroid/content/Context;", "activity", "Ljava/lang/Class;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RouterKt {
    @NotNull
    public static final StartForResultExecutor<GemRestaurant> startActivityForResult(@NotNull Context context, @NotNull Class<?> cls) {
        AppCompatActivity appCompatActivity;
        StartForResultExecutor<GemRestaurant> StartForResultBuilder;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(cls, "activity");
        if (context instanceof AppCompatActivity) {
            appCompatActivity = context;
        } else {
            appCompatActivity = null;
        }
        if (appCompatActivity != null && (StartForResultBuilder = StartForResultKt.StartForResultBuilder(appCompatActivity, new RouterKt$startActivityForResult$3(context, cls))) != null) {
            return StartForResultBuilder;
        }
        throw new UnsupportedOperationException("Gem Floating Button host context must be Activity");
    }
}
