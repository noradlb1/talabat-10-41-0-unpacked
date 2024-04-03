package com.adyen.checkout.ui.internal.card;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.base.TxVariantProvider;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import java.util.ArrayList;
import java.util.List;

public class LogoAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private final AppCompatActivity mActivity;
    private final LogoApi mLogoApi;
    /* access modifiers changed from: private */
    public final RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public final List<TxVariantProvider> mTxVariantProviders = new ArrayList();

    public final class DiffCallback extends DiffUtil.Callback {
        private final List<TxVariantProvider> mNewTxVariantProviders;
        private final List<TxVariantProvider> mOldTxVariantProviders;

        public boolean areContentsTheSame(int i11, int i12) {
            return true;
        }

        public boolean areItemsTheSame(int i11, int i12) {
            return this.mOldTxVariantProviders.get(i11).getTxVariant().equals(this.mNewTxVariantProviders.get(i12).getTxVariant());
        }

        public int getNewListSize() {
            return this.mNewTxVariantProviders.size();
        }

        public int getOldListSize() {
            return this.mOldTxVariantProviders.size();
        }

        private DiffCallback(@NonNull List<TxVariantProvider> list, @NonNull List<TxVariantProvider> list2) {
            this.mOldTxVariantProviders = list;
            this.mNewTxVariantProviders = list2;
        }
    }

    public static final class ImageViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final ImageView mImageView;

        private ImageViewHolder(@NonNull ImageView imageView) {
            super(imageView);
            this.mImageView = imageView;
        }
    }

    public LogoAdapter(@NonNull AppCompatActivity appCompatActivity, @NonNull RecyclerView recyclerView, @NonNull LogoApi logoApi) {
        this.mActivity = appCompatActivity;
        this.mRecyclerView = recyclerView;
        this.mLogoApi = logoApi;
    }

    public int getItemCount() {
        return this.mTxVariantProviders.size();
    }

    public void setTxVariantProviders(@NonNull final List<? extends TxVariantProvider> list) {
        this.mRecyclerView.post(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList(LogoAdapter.this.mTxVariantProviders);
                LogoAdapter.this.mTxVariantProviders.clear();
                LogoAdapter.this.mTxVariantProviders.addAll(list);
                LogoAdapter logoAdapter = LogoAdapter.this;
                DiffUtil.calculateDiff(new DiffCallback(arrayList, logoAdapter.mTxVariantProviders)).dispatchUpdatesTo((RecyclerView.Adapter) LogoAdapter.this);
                LogoAdapter.this.mRecyclerView.smoothScrollToPosition(0);
            }
        });
    }

    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i11) {
        Rembrandt.createDefaultLogoRequestArgs(this.mActivity.getApplication(), this.mLogoApi.newBuilder(this.mTxVariantProviders.get(i11)).buildCallable()).into((LifecycleOwner) this.mActivity, (RecyclerView.ViewHolder) imageViewHolder, imageViewHolder.mImageView);
    }

    @NonNull
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        Resources resources = viewGroup.getResources();
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(resources.getDimensionPixelSize(R.dimen.payment_method_logo_width), resources.getDimensionPixelSize(R.dimen.payment_method_logo_height));
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(layoutParams);
        return new ImageViewHolder(imageView);
    }
}
