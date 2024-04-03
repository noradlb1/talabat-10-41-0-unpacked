package com.talabat.talabatcommon.views.talabarSnackBar;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "parent", "Landroid/view/ViewGroup;", "content", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBarContentView;", "(Landroid/view/ViewGroup;Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBarContentView;)V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatNotifySnackBar extends BaseTransientBottomBar<TalabatNotifySnackBar> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar$Companion;", "", "()V", "make", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar;", "viewGroup", "Landroid/view/ViewGroup;", "content", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBarContentView;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TalabatNotifySnackBar make(@NotNull ViewGroup viewGroup, @NotNull TalabatNotifySnackBarContentView talabatNotifySnackBarContentView) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(talabatNotifySnackBarContentView, "content");
            return new TalabatNotifySnackBar(viewGroup, talabatNotifySnackBarContentView);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatNotifySnackBar(@NotNull ViewGroup viewGroup, @NotNull TalabatNotifySnackBarContentView talabatNotifySnackBarContentView) {
        super(viewGroup, talabatNotifySnackBarContentView, talabatNotifySnackBarContentView);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(talabatNotifySnackBarContentView, "content");
        getView().setBackgroundColor(ContextCompat.getColor(this.view.getContext(), 17170445));
        View view = getView();
        Resources resources = view.getResources();
        int i11 = R.dimen.margin;
        view.setPadding(resources.getDimensionPixelSize(i11), 0, view.getResources().getDimensionPixelSize(i11), view.getResources().getDimensionPixelSize(i11));
    }
}
