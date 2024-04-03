package com.talabat.feature.nfvinvendorsearch.presentation.activity;

import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class QCommerceFlutterActivity_MembersInjector implements MembersInjector<QCommerceFlutterActivity> {
    private final Provider<QCommerceViewModelFactory> viewModelFactoryProvider;

    public QCommerceFlutterActivity_MembersInjector(Provider<QCommerceViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<QCommerceFlutterActivity> create(Provider<QCommerceViewModelFactory> provider) {
        return new QCommerceFlutterActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity.viewModelFactory")
    public static void injectViewModelFactory(QCommerceFlutterActivity qCommerceFlutterActivity, QCommerceViewModelFactory qCommerceViewModelFactory) {
        qCommerceFlutterActivity.viewModelFactory = qCommerceViewModelFactory;
    }

    public void injectMembers(QCommerceFlutterActivity qCommerceFlutterActivity) {
        injectViewModelFactory(qCommerceFlutterActivity, this.viewModelFactoryProvider.get());
    }
}
