package com.deliveryhero.fluid.utils;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/utils/ResourceType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getResourceId", "", "context", "Landroid/content/Context;", "resourceName", "ANIM", "BOOLEAN", "COLOR", "DIMENSION", "DRAWABLE", "INTEGER", "STRING", "STYLE", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ResourceType {
    ANIM("anim"),
    BOOLEAN("bool"),
    COLOR("color"),
    DIMENSION("dimen"),
    DRAWABLE("drawable"),
    INTEGER(TypedValues.Custom.S_INT),
    STRING(TypedValues.Custom.S_STRING),
    STYLE("style");
    
    @NotNull
    private final String typeName;

    private ResourceType(String str) {
        this.typeName = str;
    }

    public final int getResourceId(@NotNull Context context, @NotNull String str) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "resourceName");
        int identifier = context.getResources().getIdentifier(str, this.typeName, context.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        throw new Resources.NotFoundException(this.typeName + '/' + str);
    }
}
