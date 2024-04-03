package com.talabat.darkstores.common.lists.adapters.compact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CompactSwimlaneItemButton$plusIcon$2 extends Lambda implements Function0<Drawable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f56166g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CompactSwimlaneItemButton f56167h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompactSwimlaneItemButton$plusIcon$2(Context context, CompactSwimlaneItemButton compactSwimlaneItemButton) {
        super(0);
        this.f56166g = context;
        this.f56167h = compactSwimlaneItemButton;
    }

    @Nullable
    public final Drawable invoke() {
        Drawable drawableCompat = ContextExtensionsKt.getDrawableCompat(this.f56166g, R.drawable.ds_plus);
        if (drawableCompat == null) {
            return null;
        }
        DrawableCompat.setTint(drawableCompat, this.f56167h.getOrangeBackground());
        return drawableCompat;
    }
}
