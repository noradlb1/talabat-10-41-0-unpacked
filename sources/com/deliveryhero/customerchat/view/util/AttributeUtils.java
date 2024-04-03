package com.deliveryhero.customerchat.view.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.deliveryhero.chatui.view.util.StylingProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "", "stylingProvider", "Lcom/deliveryhero/chatui/view/util/StylingProvider;", "(Lcom/deliveryhero/chatui/view/util/StylingProvider;)V", "getAttributeResource", "", "context", "Landroid/content/Context;", "attributeId", "getColorInt", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "getStringAttribute", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttributeUtils {
    @NotNull
    private final StylingProvider stylingProvider;

    public AttributeUtils(@NotNull StylingProvider stylingProvider2) {
        Intrinsics.checkNotNullParameter(stylingProvider2, "stylingProvider");
        this.stylingProvider = stylingProvider2;
    }

    private final int getAttributeResource(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.stylingProvider.getChatStyleRes(), new int[]{i11});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…Of(attributeId)\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public final int getColorInt(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getColor(context, getAttributeResource(context, i11));
    }

    @Nullable
    public final Drawable getIconDrawable(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        return AppCompatResources.getDrawable(context, getAttributeResource(context, i11));
    }

    @NotNull
    public final String getStringAttribute(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(getAttributeResource(context, i11));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resourceId)");
        return string;
    }
}
