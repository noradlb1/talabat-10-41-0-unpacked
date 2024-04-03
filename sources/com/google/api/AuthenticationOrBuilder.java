package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface AuthenticationOrBuilder extends MessageLiteOrBuilder {
    AuthProvider getProviders(int i11);

    int getProvidersCount();

    List<AuthProvider> getProvidersList();

    AuthenticationRule getRules(int i11);

    int getRulesCount();

    List<AuthenticationRule> getRulesList();
}
