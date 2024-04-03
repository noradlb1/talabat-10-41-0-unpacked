package com.adyen.checkout.ui.internal.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.model.SurchargeConfiguration;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodPickerListener;
import com.adyen.checkout.ui.internal.common.util.SnackbarSwipeHandler;
import com.adyen.checkout.ui.internal.common.util.SurchargeFormat;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SimpleDiffCallback;
import com.adyen.checkout.ui.internal.common.view.holder.TwoLineItemViewHolder;
import com.adyen.checkout.util.internal.TextFormat;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

class CheckoutMethodPickerAdapter extends RecyclerView.Adapter<TwoLineItemViewHolder> {
    private static final int VIEW_TYPE_DEFAULT = 0;
    private static final int VIEW_TYPE_DELETABLE = 1;
    /* access modifiers changed from: private */
    public List<CheckoutMethod> mAllCheckoutMethods = new ArrayList();
    private final LifecycleOwner mLifecycleOwner;
    /* access modifiers changed from: private */
    public final CheckoutMethodPickerListener mListener;
    private final LogoApi mLogoApi;
    private RecyclerView mRecyclerView;

    public CheckoutMethodPickerAdapter(@NonNull LifecycleOwner lifecycleOwner, @NonNull LogoApi logoApi, @NonNull CheckoutMethodPickerListener checkoutMethodPickerListener) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLogoApi = logoApi;
        this.mListener = checkoutMethodPickerListener;
    }

    /* access modifiers changed from: private */
    public void requestShopperConfirmationForCheckoutMethodDeletion(@NonNull final CheckoutMethod checkoutMethod) {
        Context context = this.mRecyclerView.getContext();
        Snackbar action = Snackbar.make((View) this.mRecyclerView, (CharSequence) context.getString(R.string.checkout_one_click_delete_confirmation_message, new Object[]{checkoutMethod.getPrimaryText()}), 0).setAction(R.string.checkout_one_click_delete, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                CheckoutMethodPickerAdapter.this.mListener.onCheckoutMethodDelete(checkoutMethod);
            }
        });
        action.show();
        SnackbarSwipeHandler.attach(context, action);
    }

    public void d(@NonNull List<CheckoutMethod> list) {
        DiffUtil.calculateDiff(new SimpleDiffCallback(this.mAllCheckoutMethods, list)).dispatchUpdatesTo((RecyclerView.Adapter) this);
        this.mAllCheckoutMethods = list;
    }

    public int getItemCount() {
        return this.mAllCheckoutMethods.size();
    }

    public int getItemViewType(int i11) {
        if (this.mListener.isCheckoutMethodDeletable(this.mAllCheckoutMethods.get(i11))) {
            return 1;
        }
        return 0;
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onBindViewHolder(@NonNull TwoLineItemViewHolder twoLineItemViewHolder, int i11) {
        CheckoutMethod checkoutMethod = this.mAllCheckoutMethods.get(i11);
        checkoutMethod.buildLogoRequestArgs(this.mLogoApi).into(this.mLifecycleOwner, (RecyclerView.ViewHolder) twoLineItemViewHolder, twoLineItemViewHolder.getLogoImageView());
        try {
            Context context = twoLineItemViewHolder.itemView.getContext();
            String primaryText = checkoutMethod.getPrimaryText();
            CharSequence format = SurchargeFormat.format(context, (SurchargeConfiguration) checkoutMethod.getPaymentMethod().getConfiguration(SurchargeConfiguration.class));
            twoLineItemViewHolder.setPrimaryText(TextFormat.format(context, R.string.checkout_surcharge_cost_format, primaryText, format));
        } catch (CheckoutException unused) {
            twoLineItemViewHolder.setPrimaryText(checkoutMethod.getPrimaryText());
        }
        twoLineItemViewHolder.setSecondaryText(checkoutMethod.getSecondaryText());
        twoLineItemViewHolder.itemView.setTag(checkoutMethod.getPaymentMethod().getType());
    }

    @NonNull
    public TwoLineItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        final TwoLineItemViewHolder create = TwoLineItemViewHolder.create(viewGroup);
        create.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int adapterPosition = create.getAdapterPosition();
                if (adapterPosition != -1) {
                    CheckoutMethodPickerAdapter.this.mListener.onCheckoutMethodSelected((CheckoutMethod) CheckoutMethodPickerAdapter.this.mAllCheckoutMethods.get(adapterPosition));
                }
            }
        });
        if (i11 == 1) {
            ImageView actionImageView = create.getActionImageView();
            actionImageView.setImageResource(R.drawable.ic_clear_24dp);
            ThemeUtil.setTintFromAttributeColor(actionImageView.getContext(), actionImageView.getDrawable(), R.attr.colorIconActive);
            TypedArray obtainStyledAttributes = actionImageView.getContext().obtainStyledAttributes(new int[]{16843534});
            actionImageView.setBackground(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            actionImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int adapterPosition = create.getAdapterPosition();
                    if (adapterPosition != -1) {
                        CheckoutMethodPickerAdapter.this.requestShopperConfirmationForCheckoutMethodDeletion((CheckoutMethod) CheckoutMethodPickerAdapter.this.mAllCheckoutMethods.get(adapterPosition));
                    }
                }
            });
        }
        return create;
    }
}
