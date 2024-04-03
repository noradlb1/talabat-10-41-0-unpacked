package org.mockito.session;

import org.mockito.NotExtensible;

@NotExtensible
public interface MockitoSessionLogger {
    void log(String str);
}
