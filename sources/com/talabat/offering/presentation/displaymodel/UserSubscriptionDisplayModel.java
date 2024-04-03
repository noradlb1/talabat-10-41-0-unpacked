package com.talabat.offering.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "", "()V", "UserLoggedOut", "UserNotSubscribed", "UserSubscribed", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserSubscribed;", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserNotSubscribed;", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserLoggedOut;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UserSubscriptionDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserLoggedOut;", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "()V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UserLoggedOut extends UserSubscriptionDisplayModel {
        @NotNull
        public static final UserLoggedOut INSTANCE = new UserLoggedOut();

        private UserLoggedOut() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserNotSubscribed;", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "()V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UserNotSubscribed extends UserSubscriptionDisplayModel {
        @NotNull
        public static final UserNotSubscribed INSTANCE = new UserNotSubscribed();

        private UserNotSubscribed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel$UserSubscribed;", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "()V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UserSubscribed extends UserSubscriptionDisplayModel {
        @NotNull
        public static final UserSubscribed INSTANCE = new UserSubscribed();

        private UserSubscribed() {
            super((DefaultConstructorMarker) null);
        }
    }

    private UserSubscriptionDisplayModel() {
    }

    public /* synthetic */ UserSubscriptionDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
