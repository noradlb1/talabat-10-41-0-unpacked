package org.mockito.configuration;

import org.mockito.stubbing.Answer;

public interface IMockitoConfiguration {
    boolean cleansStackTrace();

    boolean enableClassCache();

    Answer<Object> getDefaultAnswer();
}
