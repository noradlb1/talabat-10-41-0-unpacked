package com.talabat.talabatcommon.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setImageResizeUrl", "", "url", "", "width", "height", "isCircle", "", "setImageUrl", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImageView extends AppCompatImageView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void setImageResizeUrl$default(TalabatImageView talabatImageView, String str, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        if ((i13 & 8) != 0) {
            z11 = false;
        }
        talabatImageView.setImageResizeUrl(str, i11, i12, z11);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void setImageResizeUrl(@NotNull String str, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.downloadImage(context, str, this, i11, i12, z11);
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageDownloadHelper.Companion.downloadImage$default(companion, context, str, this, 0, 0, false, 56, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
