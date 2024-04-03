package com.newrelic.agent.android;

import com.newrelic.agent.android.util.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class HttpHeaders {
    public static final String OPERATION_ID = "operationId";
    public static final String OPERATION_NAME = "operationName";
    public static final String OPERATION_TYPE = "operationType";
    protected static final AtomicReference<HttpHeaders> instance = new AtomicReference<>(new HttpHeaders());
    private final Set<String> httpHeaders;

    private HttpHeaders() {
        HashSet hashSet = new HashSet();
        this.httpHeaders = hashSet;
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_NAME);
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_ID);
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_TYPE);
    }

    public static HttpHeaders getInstance() {
        return instance.get();
    }

    public static String translateApolloHeader(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 276368474:
                if (str.equals(Constants.ApolloGraphQLHeader.OPERATION_NAME)) {
                    c11 = 0;
                    break;
                }
                break;
            case 276570377:
                if (str.equals(Constants.ApolloGraphQLHeader.OPERATION_TYPE)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1425984170:
                if (str.equals(Constants.ApolloGraphQLHeader.OPERATION_ID)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return OPERATION_NAME;
            case 1:
                return OPERATION_TYPE;
            case 2:
                return OPERATION_ID;
            default:
                return str;
        }
    }

    public void addHttpHeaderAsAttribute(String str) {
        this.httpHeaders.add(str);
    }

    public boolean addHttpHeadersAsAttributes(List<String> list) {
        return this.httpHeaders.addAll(list);
    }

    public Set<String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public void removeHttpHeaderAsAttribute(String str) {
        if (!Constants.ApolloGraphQLHeader.OPERATION_ID.equalsIgnoreCase(str) && !Constants.ApolloGraphQLHeader.OPERATION_NAME.equalsIgnoreCase(str) && !Constants.ApolloGraphQLHeader.OPERATION_TYPE.equalsIgnoreCase(str)) {
            this.httpHeaders.remove(str);
        }
    }
}
