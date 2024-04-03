package com.talabat.wallet.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "", "makeSnackBar", "", "root_view", "Landroid/view/View;", "context", "Landroid/content/Context;", "message", "", "status", "Lcom/talabat/wallet/helpers/ResponseStatus;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ResponseStatusInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void makeSnackBar(@NotNull ResponseStatusInterface responseStatusInterface, @NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
            View view2;
            Intrinsics.checkNotNullParameter(view, "root_view");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(responseStatus, "status");
            Snackbar make = Snackbar.make(view, (CharSequence) "This is a simple Snackbar", 0);
            Intrinsics.checkNotNullExpressionValue(make, "make(root_view, \"This is…r\", Snackbar.LENGTH_LONG)");
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) make.getView();
            ViewGroup.LayoutParams layoutParams = make.getView().getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                snackbarLayout.setBackgroundColor(0);
                Resources resources = context.getResources();
                float applyDimension = TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
                int applyDimension2 = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + applyDimension2, marginLayoutParams.topMargin, marginLayoutParams.rightMargin + applyDimension2, marginLayoutParams.bottomMargin + ((int) applyDimension));
                snackbarLayout.setLayoutParams(marginLayoutParams);
                ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setVisibility(4);
                LayoutInflater from = LayoutInflater.from(context);
                if (ResponseStatus.SUCCESS == responseStatus) {
                    view2 = from.inflate(R.layout.custom_message_view, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(view2, "{\n            inflater.i…age_view, null)\n        }");
                } else {
                    view2 = from.inflate(R.layout.custom_message_error_view, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(view2, "{\n            inflater.i…ror_view, null)\n        }");
                }
                View findViewById = view2.findViewById(R.id.image);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) findViewById;
                    View findViewById2 = view2.findViewById(R.id.text);
                    if (findViewById2 != null) {
                        ((TextView) findViewById2).setText(str);
                        snackbarLayout.setPadding(0, 0, 0, 0);
                        snackbarLayout.addView(view2, 0);
                        make.show();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus);
}
