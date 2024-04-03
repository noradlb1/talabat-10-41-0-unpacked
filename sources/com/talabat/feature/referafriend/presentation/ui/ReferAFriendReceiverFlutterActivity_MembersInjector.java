package com.talabat.feature.referafriend.presentation.ui;

import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ReferAFriendReceiverFlutterActivity_MembersInjector implements MembersInjector<ReferAFriendReceiverFlutterActivity> {
    private final Provider<ReferAFriendViewModelFactory> factoryProvider;

    public ReferAFriendReceiverFlutterActivity_MembersInjector(Provider<ReferAFriendViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<ReferAFriendReceiverFlutterActivity> create(Provider<ReferAFriendViewModelFactory> provider) {
        return new ReferAFriendReceiverFlutterActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity.factory")
    public static void injectFactory(ReferAFriendReceiverFlutterActivity referAFriendReceiverFlutterActivity, ReferAFriendViewModelFactory referAFriendViewModelFactory) {
        referAFriendReceiverFlutterActivity.factory = referAFriendViewModelFactory;
    }

    public void injectMembers(ReferAFriendReceiverFlutterActivity referAFriendReceiverFlutterActivity) {
        injectFactory(referAFriendReceiverFlutterActivity, this.factoryProvider.get());
    }
}
