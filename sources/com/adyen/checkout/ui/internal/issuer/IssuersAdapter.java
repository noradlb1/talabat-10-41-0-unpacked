package com.adyen.checkout.ui.internal.issuer;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.IssuerDetails;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import com.adyen.checkout.ui.internal.common.view.holder.TwoLineItemViewHolder;
import java.util.List;

class IssuersAdapter extends RecyclerView.Adapter<TwoLineItemViewHolder> {
    private final AppCompatActivity mActivity;
    private final List<Item> mItems;
    /* access modifiers changed from: private */
    public Listener mListener;
    private final LogoApi mLogoApi;
    /* access modifiers changed from: private */
    public final PaymentMethod mPaymentMethod;

    public interface Listener {
        void onIssuerClick(@NonNull PaymentMethod paymentMethod, @NonNull Item item);
    }

    public IssuersAdapter(@NonNull AppCompatActivity appCompatActivity, @NonNull PaymentMethod paymentMethod, @NonNull LogoApi logoApi, @NonNull Listener listener) {
        this.mActivity = appCompatActivity;
        this.mPaymentMethod = paymentMethod;
        this.mLogoApi = logoApi;
        this.mItems = InputDetailImpl.findByKey(paymentMethod.getInputDetails(), IssuerDetails.KEY_ISSUER).getItems();
        this.mListener = listener;
    }

    /* access modifiers changed from: private */
    @Nullable
    public Item getItem(int i11) {
        if (i11 < 0 || i11 >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(i11);
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public void onBindViewHolder(@NonNull TwoLineItemViewHolder twoLineItemViewHolder, int i11) {
        Item item = getItem(i11);
        if (item != null) {
            Rembrandt.createDefaultLogoRequestArgs(this.mActivity.getApplication(), this.mLogoApi.newBuilder(this.mPaymentMethod).setTxSubVariantProvider(item).buildCallable()).into((LifecycleOwner) this.mActivity, (RecyclerView.ViewHolder) twoLineItemViewHolder, twoLineItemViewHolder.getLogoImageView());
            twoLineItemViewHolder.setPrimaryText(item.getName());
        }
    }

    @NonNull
    public TwoLineItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        final TwoLineItemViewHolder create = TwoLineItemViewHolder.create(viewGroup);
        create.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Item a11 = IssuersAdapter.this.getItem(create.getAdapterPosition());
                if (a11 != null) {
                    IssuersAdapter.this.mListener.onIssuerClick(IssuersAdapter.this.mPaymentMethod, a11);
                }
            }
        });
        return create;
    }
}
