package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

public class NetworkImageView extends ImageView {
    /* access modifiers changed from: private */
    @Nullable
    public Bitmap mDefaultImageBitmap;
    /* access modifiers changed from: private */
    @Nullable
    public Drawable mDefaultImageDrawable;
    /* access modifiers changed from: private */
    public int mDefaultImageId;
    /* access modifiers changed from: private */
    @Nullable
    public Bitmap mErrorImageBitmap;
    /* access modifiers changed from: private */
    @Nullable
    public Drawable mErrorImageDrawable;
    /* access modifiers changed from: private */
    public int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setDefaultImageOrNull() {
        int i11 = this.mDefaultImageId;
        if (i11 != 0) {
            setImageResource(i11);
            return;
        }
        Drawable drawable = this.mDefaultImageDrawable;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.mDefaultImageBitmap;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void loadImageIfNecessary(final boolean z11) {
        boolean z12;
        boolean z13;
        int i11;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        boolean z14 = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (getLayoutParams().height == -2) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            z13 = false;
            z12 = false;
        }
        if (!z13 || !z12) {
            z14 = false;
        }
        if (width != 0 || height != 0 || z14) {
            if (TextUtils.isEmpty(this.mUrl)) {
                ImageLoader.ImageContainer imageContainer = this.mImageContainer;
                if (imageContainer != null) {
                    imageContainer.cancelRequest();
                    this.mImageContainer = null;
                }
                setDefaultImageOrNull();
                return;
            }
            ImageLoader.ImageContainer imageContainer2 = this.mImageContainer;
            if (!(imageContainer2 == null || imageContainer2.getRequestUrl() == null)) {
                if (!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
                    this.mImageContainer.cancelRequest();
                    setDefaultImageOrNull();
                } else {
                    return;
                }
            }
            if (z13) {
                width = 0;
            }
            if (z12) {
                i11 = 0;
            } else {
                i11 = height;
            }
            this.mImageContainer = this.mImageLoader.get(this.mUrl, new ImageLoader.ImageListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (NetworkImageView.this.mErrorImageId != 0) {
                        NetworkImageView networkImageView = NetworkImageView.this;
                        networkImageView.setImageResource(networkImageView.mErrorImageId);
                    } else if (NetworkImageView.this.mErrorImageDrawable != null) {
                        NetworkImageView networkImageView2 = NetworkImageView.this;
                        networkImageView2.setImageDrawable(networkImageView2.mErrorImageDrawable);
                    } else if (NetworkImageView.this.mErrorImageBitmap != null) {
                        NetworkImageView networkImageView3 = NetworkImageView.this;
                        networkImageView3.setImageBitmap(networkImageView3.mErrorImageBitmap);
                    }
                }

                public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z11) {
                    if (z11 && z11) {
                        NetworkImageView.this.post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.onResponse(imageContainer, false);
                            }
                        });
                    } else if (imageContainer.getBitmap() != null) {
                        NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
                    } else if (NetworkImageView.this.mDefaultImageId != 0) {
                        NetworkImageView networkImageView = NetworkImageView.this;
                        networkImageView.setImageResource(networkImageView.mDefaultImageId);
                    } else if (NetworkImageView.this.mDefaultImageDrawable != null) {
                        NetworkImageView networkImageView2 = NetworkImageView.this;
                        networkImageView2.setImageDrawable(networkImageView2.mDefaultImageDrawable);
                    } else if (NetworkImageView.this.mDefaultImageBitmap != null) {
                        NetworkImageView networkImageView3 = NetworkImageView.this;
                        networkImageView3.setImageBitmap(networkImageView3.mDefaultImageBitmap);
                    }
                }
            }, width, i11, scaleType);
        }
    }

    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.mImageContainer;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap((Bitmap) null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.mDefaultImageId = 0;
        this.mDefaultImageDrawable = null;
        this.mDefaultImageBitmap = bitmap;
    }

    public void setDefaultImageDrawable(@Nullable Drawable drawable) {
        this.mDefaultImageId = 0;
        this.mDefaultImageBitmap = null;
        this.mDefaultImageDrawable = drawable;
    }

    public void setDefaultImageResId(int i11) {
        this.mDefaultImageBitmap = null;
        this.mDefaultImageDrawable = null;
        this.mDefaultImageId = i11;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.mErrorImageId = 0;
        this.mErrorImageDrawable = null;
        this.mErrorImageBitmap = bitmap;
    }

    public void setErrorImageDrawable(@Nullable Drawable drawable) {
        this.mErrorImageId = 0;
        this.mErrorImageBitmap = null;
        this.mErrorImageDrawable = drawable;
    }

    public void setErrorImageResId(int i11) {
        this.mErrorImageBitmap = null;
        this.mErrorImageDrawable = null;
        this.mErrorImageId = i11;
    }

    @MainThread
    public void setImageUrl(String str, ImageLoader imageLoader) {
        Threads.throwIfNotOnMainThread();
        this.mUrl = str;
        this.mImageLoader = imageLoader;
        loadImageIfNecessary(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
