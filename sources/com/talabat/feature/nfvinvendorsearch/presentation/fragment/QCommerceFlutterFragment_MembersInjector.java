package com.talabat.feature.nfvinvendorsearch.presentation.fragment;

import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class QCommerceFlutterFragment_MembersInjector implements MembersInjector<QCommerceFlutterFragment> {
    private final Provider<QCommerceViewModelFactory> viewModelFactoryProvider;

    public QCommerceFlutterFragment_MembersInjector(Provider<QCommerceViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<QCommerceFlutterFragment> create(Provider<QCommerceViewModelFactory> provider) {
        return new QCommerceFlutterFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragment.viewModelFactory")
    public static void injectViewModelFactory(QCommerceFlutterFragment qCommerceFlutterFragment, QCommerceViewModelFactory qCommerceViewModelFactory) {
        qCommerceFlutterFragment.viewModelFactory = qCommerceViewModelFactory;
    }

    public void injectMembers(QCommerceFlutterFragment qCommerceFlutterFragment) {
        injectViewModelFactory(qCommerceFlutterFragment, this.viewModelFactoryProvider.get());
    }
}
