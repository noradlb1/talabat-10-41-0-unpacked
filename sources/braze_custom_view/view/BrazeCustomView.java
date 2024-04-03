package braze_custom_view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageWebView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lbraze_custom_view/view/BrazeCustomView;", "Lcom/braze/ui/inappmessage/views/InAppMessageWebView;", "Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "hasAppliedWindowInsets", "getHasAppliedWindowInsets", "()Z", "setHasAppliedWindowInsets", "(Z)V", "messageClickableView", "Landroid/view/View;", "getMessageClickableView", "()Landroid/view/View;", "applyWindowInsets", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeCustomView extends InAppMessageWebView implements IInAppMessageView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BrazeCustomView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
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

    public void applyWindowInsets(@NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
    }

    public boolean getHasAppliedWindowInsets() {
        return getHasAppliedWindowInsets();
    }

    @Nullable
    public View getMessageClickableView() {
        return this;
    }

    public void setHasAppliedWindowInsets(boolean z11) {
        setHasAppliedWindowInsets(false);
    }
}
