package com.talabat.wallet.ui.subscriptionManagement.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.wallet.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import py.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0014\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0012H\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016J \u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter$SubscriptionManagementAdapterInterface;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Landroid/content/Context;Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter$SubscriptionManagementAdapterInterface;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "dataItems", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "addFreeTrialText", "", "freeTrialDays", "", "holder", "addItems", "newItems", "", "addListener", "position", "addRenewalDate", "item", "viewHolder", "addSubscriptionButtonType", "addSubscriptionTitle", "isActive", "", "addSubscriptionViews", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showAmount", "amount", "", "duration", "textView", "Landroid/widget/TextView;", "showSubscriptionAmount", "showSubscriptionImage", "imageUrl", "", "SubscriptionManagementAdapterInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private List<SubscriptionItemDisplayModel> dataItems = new ArrayList();
    @NotNull
    private final SubscriptionManagementAdapterInterface listener;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter$SubscriptionManagementAdapterInterface;", "", "navigateToPlanOnBoarding", "", "subscriptionItemDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "navigateToSubscriptionDetail", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionManagementAdapterInterface {
        void navigateToPlanOnBoarding(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel);

        void navigateToSubscriptionDetail(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel);
    }

    public SubscriptionManagementAdapter(@NotNull Context context2, @NotNull SubscriptionManagementAdapterInterface subscriptionManagementAdapterInterface, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(subscriptionManagementAdapterInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.context = context2;
        this.listener = subscriptionManagementAdapterInterface;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private final void addFreeTrialText(int i11, RecyclerView.ViewHolder viewHolder) {
        ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setText(this.context.getString(com.talabat.localization.R.string.subscription_free_trial_days, new Object[]{String.valueOf(i11)}));
    }

    private final void addListener(RecyclerView.ViewHolder viewHolder, int i11) {
        viewHolder.itemView.setOnClickListener(new a(this, i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: addListener$lambda-1  reason: not valid java name */
    public static final void m6018addListener$lambda1(SubscriptionManagementAdapter subscriptionManagementAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(subscriptionManagementAdapter, "this$0");
        if (subscriptionManagementAdapter.dataItems.get(i11).isActive()) {
            SubscriptionManagementAdapterInterface subscriptionManagementAdapterInterface = subscriptionManagementAdapter.listener;
            if (subscriptionManagementAdapterInterface != null) {
                subscriptionManagementAdapterInterface.navigateToSubscriptionDetail(subscriptionManagementAdapter.dataItems.get(i11));
                return;
            }
            return;
        }
        SubscriptionManagementAdapterInterface subscriptionManagementAdapterInterface2 = subscriptionManagementAdapter.listener;
        if (subscriptionManagementAdapterInterface2 != null) {
            subscriptionManagementAdapterInterface2.navigateToPlanOnBoarding(subscriptionManagementAdapter.dataItems.get(i11));
        }
    }

    private final void addRenewalDate(SubscriptionItemDisplayModel subscriptionItemDisplayModel, RecyclerView.ViewHolder viewHolder) {
        if (subscriptionItemDisplayModel.isActive() && subscriptionItemDisplayModel.isAutoRenewable()) {
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.subscription_amount)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.renewal_date)).setText(this.context.getString(com.talabat.localization.R.string.subscription_renew_date, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(subscriptionItemDisplayModel.getNextBillingDate(), "dd LLLL yyyy")}));
        } else if (subscriptionItemDisplayModel.isActive() && !subscriptionItemDisplayModel.isAutoRenewable()) {
            ((TextView) viewHolder.itemView.findViewById(R.id.subscription_amount)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(8);
            ((TextView) viewHolder.itemView.findViewById(R.id.renewal_date)).setText(this.context.getString(com.talabat.localization.R.string.subscription_expires_date, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(subscriptionItemDisplayModel.getNextBillingDate(), "dd LLLL yyyy")}));
        } else if (!subscriptionItemDisplayModel.isActive()) {
            float amount = subscriptionItemDisplayModel.getSubscriptionPlanItem().getAmount();
            int durationDays = subscriptionItemDisplayModel.getSubscriptionPlanItem().getDurationDays();
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.renewal_date);
            Intrinsics.checkNotNullExpressionValue(textView, "viewHolder.itemView.renewal_date");
            showAmount(amount, durationDays, textView);
            ((TextView) viewHolder.itemView.findViewById(R.id.subscription_amount)).setVisibility(8);
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(0);
        } else {
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(0);
        }
    }

    private final void addSubscriptionButtonType(SubscriptionItemDisplayModel subscriptionItemDisplayModel, RecyclerView.ViewHolder viewHolder) {
        if (subscriptionItemDisplayModel.isAutoRenewable() && subscriptionItemDisplayModel.isActive()) {
            ((Button) viewHolder.itemView.findViewById(R.id.subscription_active_button)).setVisibility(0);
        } else if (!subscriptionItemDisplayModel.isAutoRenewable() && subscriptionItemDisplayModel.isActive()) {
            ((Button) viewHolder.itemView.findViewById(R.id.subscription_cancel_button)).setVisibility(0);
        }
    }

    private final void addSubscriptionTitle(boolean z11, RecyclerView.ViewHolder viewHolder) {
        if (z11) {
            ((TextView) viewHolder.itemView.findViewById(R.id.plan_label)).setText(this.context.getString(com.talabat.localization.R.string.manage_plan));
        } else {
            ((TextView) viewHolder.itemView.findViewById(R.id.plan_label)).setText(this.context.getString(com.talabat.localization.R.string.view_plan));
        }
    }

    private final void addSubscriptionViews(int i11, RecyclerView.ViewHolder viewHolder) {
        SubscriptionItemDisplayModel subscriptionItemDisplayModel = this.dataItems.get(i11);
        SubscriptionPlanItemDisplayModel subscriptionPlanItem = subscriptionItemDisplayModel.getSubscriptionPlanItem();
        String title = subscriptionPlanItem.getTitle();
        String imageUrl = subscriptionPlanItem.getImageUrl();
        ((TextView) viewHolder.itemView.findViewById(R.id.plan_name)).setText(title);
        float amount = subscriptionItemDisplayModel.getSubscriptionPlanItem().getAmount();
        int durationDays = subscriptionItemDisplayModel.getSubscriptionPlanItem().getDurationDays();
        View view = viewHolder.itemView;
        int i12 = R.id.subscription_amount;
        TextView textView = (TextView) view.findViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView, "itemView.subscription_amount");
        showAmount(amount, durationDays, textView);
        addSubscriptionTitle(subscriptionItemDisplayModel.isActive(), viewHolder);
        addSubscriptionButtonType(subscriptionItemDisplayModel, viewHolder);
        addRenewalDate(subscriptionItemDisplayModel, viewHolder);
        if (StringsKt__StringsJVMKt.equals(subscriptionPlanItem.getCategory(), SubscriptionManagementAdapterKt.BUSINESS_TO_BUSINESS_TAG, true)) {
            ((TextView) viewHolder.itemView.findViewById(i12)).setVisibility(8);
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(8);
        }
        if (subscriptionPlanItem.getFreeTrialDays() > 0) {
            addFreeTrialText(subscriptionItemDisplayModel.getSubscriptionPlanItem().getFreeTrialDays(), viewHolder);
        } else {
            ((TextView) viewHolder.itemView.findViewById(R.id.free_trail_days)).setVisibility(8);
        }
        showSubscriptionImage(viewHolder, imageUrl);
    }

    private final void showAmount(float f11, int i11, TextView textView) {
        Context context2 = this.context;
        int i12 = com.talabat.localization.R.string.subscription_amount;
        WalletSubscriptionMapper.Companion companion = WalletSubscriptionMapper.Companion;
        String string = this.context.getString(com.talabat.localization.R.string.per_day);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ization.R.string.per_day)");
        String string2 = this.context.getString(com.talabat.localization.R.string.per_week);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.ta…zation.R.string.per_week)");
        String string3 = this.context.getString(com.talabat.localization.R.string.per_month);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.ta…ation.R.string.per_month)");
        String string4 = this.context.getString(com.talabat.localization.R.string.per_year);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(com.ta…zation.R.string.per_year)");
        String string5 = this.context.getString(com.talabat.localization.R.string.months);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(com.ta…lization.R.string.months)");
        String string6 = this.context.getString(com.talabat.localization.R.string.per);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(com.ta…ocalization.R.string.per)");
        textView.setText(context2.getString(i12, new Object[]{TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository).currencySymbol, String.valueOf((int) f11), companion.subscriptionDurationStringMapper(i11, string, string2, string3, string4, string5, string6)}));
    }

    private final void showSubscriptionAmount(SubscriptionItemDisplayModel subscriptionItemDisplayModel, RecyclerView.ViewHolder viewHolder) {
        Context context2 = this.context;
        int i11 = com.talabat.localization.R.string.subscription_amount;
        WalletSubscriptionMapper.Companion companion = WalletSubscriptionMapper.Companion;
        int durationDays = subscriptionItemDisplayModel.getSubscriptionPlanItem().getDurationDays();
        String string = this.context.getString(com.talabat.localization.R.string.per_day);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ization.R.string.per_day)");
        String string2 = this.context.getString(com.talabat.localization.R.string.per_week);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.ta…zation.R.string.per_week)");
        String string3 = this.context.getString(com.talabat.localization.R.string.per_month);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.ta…ation.R.string.per_month)");
        String string4 = this.context.getString(com.talabat.localization.R.string.per_year);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(com.ta…zation.R.string.per_year)");
        String string5 = this.context.getString(com.talabat.localization.R.string.months);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(com.ta…lization.R.string.months)");
        String string6 = this.context.getString(com.talabat.localization.R.string.per);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(com.ta…ocalization.R.string.per)");
        ((TextView) viewHolder.itemView.findViewById(R.id.subscription_amount)).setText(context2.getString(i11, new Object[]{subscriptionItemDisplayModel.getSubscriptionPlanItem().getCurrency(), String.valueOf((int) subscriptionItemDisplayModel.getSubscriptionPlanItem().getAmount()), companion.subscriptionDurationStringMapper(durationDays, string, string2, string3, string4, string5, string6)}));
    }

    private final void showSubscriptionImage(RecyclerView.ViewHolder viewHolder, String str) {
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context2 = this.context;
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.itemView.findViewById(R.id.subscription_plan_bg);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "holder.itemView.subscription_plan_bg");
        companion.downloadImageAsBackground(context2, str, constraintLayout);
    }

    public final void addItems(@NotNull List<SubscriptionItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.clear();
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        addSubscriptionViews(i11, viewHolder);
        addListener(viewHolder, i11);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return SubscriptionManagementViewHolder.Companion.from(viewGroup);
    }
}
