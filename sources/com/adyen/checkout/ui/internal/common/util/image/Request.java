package com.adyen.checkout.ui.internal.common.util.image;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;

public abstract class Request implements Runnable {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private final Rembrandt mRembrandt;
    private final RequestArgs mRequestArgs;

    public Request(@NonNull Rembrandt rembrandt, @NonNull RequestArgs requestArgs) {
        this.mRembrandt = rembrandt;
        this.mRequestArgs = requestArgs;
    }

    @Nullable
    private Drawable loadDrawableResource(@DrawableRes int i11) {
        if (i11 == 0) {
            return null;
        }
        Application a11 = this.mRembrandt.a();
        Drawable drawable = AppCompatResources.getDrawable(a11, i11);
        if (drawable != null) {
            ThemeUtil.setTintFromAttributeColor(a11, drawable, R.attr.colorIconActive);
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    @AnyThread
    public abstract boolean a();

    @MainThread
    public abstract void b(@Nullable Drawable drawable);

    /* access modifiers changed from: package-private */
    @MainThread
    public abstract void c();

    public final void run() {
        if (!a()) {
            final Drawable loadDrawableResource = loadDrawableResource(this.mRequestArgs.getPlaceholderResId());
            Handler handler = MAIN_HANDLER;
            handler.post(new Runnable() {
                public void run() {
                    if (Request.this.a()) {
                        Request.this.c();
                    } else {
                        Request.this.b(loadDrawableResource);
                    }
                }
            });
            if (a()) {
                handler.post(new Runnable() {
                    public void run() {
                        Request.this.c();
                    }
                });
                return;
            }
            try {
                final Drawable call = this.mRequestArgs.getImageCallable().call();
                handler.post(new Runnable() {
                    public void run() {
                        if (Request.this.a()) {
                            Request.this.c();
                            return;
                        }
                        Request.this.b(call);
                        Request.this.c();
                    }
                });
            } catch (Exception unused) {
                final Drawable loadDrawableResource2 = loadDrawableResource(this.mRequestArgs.getErrorResId());
                MAIN_HANDLER.post(new Runnable() {
                    public void run() {
                        if (Request.this.a()) {
                            Request.this.c();
                            return;
                        }
                        Request.this.b(loadDrawableResource2);
                        Request.this.c();
                    }
                });
            }
        }
    }
}
