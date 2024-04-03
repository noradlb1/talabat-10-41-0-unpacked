package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "()V", "featureName", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "Companion", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TProEvent extends TalabatEvent {
    @NotNull
    public static final String ATTR_CANCELLATION_DAY = "cancellationDay";
    @NotNull
    public static final String ATTR_DISCOUNT_AMOUNT = "discount_amount";
    @NotNull
    public static final String ATTR_ORDER_PRICE = "order_price";
    @NotNull
    public static final String ATTR_RESTAURANT = "restaurant";
    @NotNull
    public static final String ATTR_SAVINGS_AMOUNT = "savingsAmount";
    @NotNull
    public static final String ATTR_SCREEN_NAME = "screen_name";
    @NotNull
    public static final String ATTR_SCREEN_TYPE = "screen_type";
    @NotNull
    public static final String ATTR_SUBSCRIPTION_AMOUNT = "subscription_amount";
    @NotNull
    public static final String ATTR_SUBSCRIPTION_DATE = "subscription_date";
    @NotNull
    public static final String ATTR_SUBSCRIPTION_PLAN = "subscriptionPlan";
    @NotNull
    public static final String ATTR_USER_ID = "user_id";
    @NotNull
    public static final String ATTR_USER_IS_SUBSCRIBED = "is_subscribed";
    @NotNull
    public static final String ATTR_USER_PREFERENCES = "userPreferences";
    @NotNull
    public static final String ATTR_VOUCHER_NAME = "voucher_name";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NAME_PRO_BENEFITS_PAGE_LOADED = "app_pro_benefits_page_loaded";
    @NotNull
    public static final String NAME_PRO_ORDER = "app_pro_order";
    @NotNull
    public static final String NAME_REACTIVATE_ATTEMPTED = "subscription_reactivate_attempted";
    @NotNull
    public static final String NAME_REACTIVATE_LOADED = "subscription_reactivate_loaded";
    @NotNull
    public static final String NAME_REACTIVATE_SUCCESSFUL = "subscription_reactivate_successful";
    @NotNull
    public static final String NAME_SUBSCRIPTION_ATTEMPTED = "subscription_attempted";
    @NotNull
    public static final String NAME_SUBSCRIPTION_CANCELLATION_ABORTED = "subscription_cancellation_aborted";
    @NotNull
    public static final String NAME_SUBSCRIPTION_CANCELLATION_LOADED = "subscription_cancellation_loaded";
    @NotNull
    public static final String NAME_SUBSCRIPTION_COMPLETED = "subscription_completed";
    @NotNull
    public static final String NAME_SUBSCRIPTION_FAILED = "subscription_failed";
    @NotNull
    public static final String NAME_SUBSCRIPTION_PLAN_CLICKED = "subscription_plan_clicked";
    @NotNull
    public static final String NAME_SUBSCRIPTION_PLAN_LOADED = "subscription_plan_loaded";
    @NotNull
    public static final String NAME_UPGRADE_ATTEMPTED = "subscription_upgrade_attempted";
    @NotNull
    public static final String NAME_UPGRADE_COMPLETED = "subscription_upgrade_completed";
    @NotNull
    public static final String NAME_UPGRADE_LOADED = "subscription_upgrade_loaded";
    @NotNull
    public static final String NAME_UPGRADE_STARTED = "subscription_upgrade_started";
    @NotNull
    public static final String NAME_USER_SUBSCRIBED_EVENT = "app_pro_subscription";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent$Companion;", "", "()V", "ATTR_CANCELLATION_DAY", "", "ATTR_DISCOUNT_AMOUNT", "ATTR_ORDER_PRICE", "ATTR_RESTAURANT", "ATTR_SAVINGS_AMOUNT", "ATTR_SCREEN_NAME", "ATTR_SCREEN_TYPE", "ATTR_SUBSCRIPTION_AMOUNT", "ATTR_SUBSCRIPTION_DATE", "ATTR_SUBSCRIPTION_PLAN", "ATTR_USER_ID", "ATTR_USER_IS_SUBSCRIBED", "ATTR_USER_PREFERENCES", "ATTR_VOUCHER_NAME", "NAME_PRO_BENEFITS_PAGE_LOADED", "NAME_PRO_ORDER", "NAME_REACTIVATE_ATTEMPTED", "NAME_REACTIVATE_LOADED", "NAME_REACTIVATE_SUCCESSFUL", "NAME_SUBSCRIPTION_ATTEMPTED", "NAME_SUBSCRIPTION_CANCELLATION_ABORTED", "NAME_SUBSCRIPTION_CANCELLATION_LOADED", "NAME_SUBSCRIPTION_COMPLETED", "NAME_SUBSCRIPTION_FAILED", "NAME_SUBSCRIPTION_PLAN_CLICKED", "NAME_SUBSCRIPTION_PLAN_LOADED", "NAME_UPGRADE_ATTEMPTED", "NAME_UPGRADE_COMPLETED", "NAME_UPGRADE_LOADED", "NAME_UPGRADE_STARTED", "NAME_USER_SUBSCRIBED_EVENT", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro";
    }
}
