package com.talabat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/HomeScreenMap$initInitialView$12", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap$initInitialView$12 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f54208b;

    public HomeScreenMap$initInitialView$12(HomeScreenMap homeScreenMap) {
        this.f54208b = homeScreenMap;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (charSequence.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f54208b._$_findCachedViewById(R.id.search_clear);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f54208b._$_findCachedViewById(R.id.search_clear);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }
}
