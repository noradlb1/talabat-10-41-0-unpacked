package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface SystemParametersOrBuilder extends MessageLiteOrBuilder {
    SystemParameterRule getRules(int i11);

    int getRulesCount();

    List<SystemParameterRule> getRulesList();
}
