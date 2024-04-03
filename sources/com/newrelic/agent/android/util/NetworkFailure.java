package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public enum NetworkFailure {
    Unknown(-1),
    BadURL(-1000),
    TimedOut(HarvestErrorCodes.NSURLErrorTimedOut),
    CannotConnectToHost(HarvestErrorCodes.NSURLErrorCannotConnectToHost),
    DNSLookupFailed(HarvestErrorCodes.NSURLErrorDNSLookupFailed),
    BadServerResponse(HarvestErrorCodes.NSURLErrorBadServerResponse),
    SecureConnectionFailed(HarvestErrorCodes.NSURLErrorSecureConnectionFailed);
    
    private static final AgentLog log = null;
    private int errorCode;

    /* access modifiers changed from: public */
    static {
        log = AgentLogManager.getAgentLog();
    }

    private NetworkFailure(int i11) {
        this.errorCode = i11;
    }

    public static int exceptionToErrorCode(Exception exc) {
        return exceptionToNetworkFailure(exc).getErrorCode();
    }

    public static NetworkFailure exceptionToNetworkFailure(Exception exc) {
        AgentLog agentLog = log;
        String name2 = exc.getClass().getName();
        agentLog.error("NetworkFailure.exceptionToNetworkFailure: Attempting to convert network exception " + name2 + " to error code.");
        NetworkFailure networkFailure = Unknown;
        try {
            if (exc instanceof ConnectTimeoutException) {
                networkFailure = TimedOut;
            } else if ((exc instanceof HttpResponseException) || (exc instanceof ClientProtocolException)) {
                networkFailure = BadServerResponse;
            }
            if (!(exc instanceof SocketTimeoutException)) {
                if (!(exc instanceof UnknownHostException)) {
                    if (!(exc instanceof ConnectException)) {
                        if (!(exc instanceof MalformedURLException)) {
                            if (!(exc instanceof SSLException)) {
                                return networkFailure;
                            }
                            return SecureConnectionFailed;
                        }
                        return BadURL;
                    }
                    return CannotConnectToHost;
                }
                return DNSLookupFailed;
            }
        } catch (NoClassDefFoundError unused) {
            if (!(exc instanceof SocketTimeoutException)) {
                if (!(exc instanceof UnknownHostException)) {
                    if (!(exc instanceof ConnectException)) {
                        if (!(exc instanceof MalformedURLException)) {
                            if (!(exc instanceof SSLException)) {
                                return networkFailure;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            if (!(exc instanceof SocketTimeoutException) && !(exc instanceof UnknownHostException) && !(exc instanceof ConnectException) && !(exc instanceof MalformedURLException)) {
                boolean z11 = exc instanceof SSLException;
            }
            throw th2;
        }
        return TimedOut;
    }

    public static NetworkFailure fromErrorCode(int i11) {
        log.debug("fromErrorCode invoked with errorCode: " + i11);
        for (NetworkFailure networkFailure : values()) {
            if (networkFailure.getErrorCode() == i11) {
                log.debug("fromErrorCode found matching failure: " + networkFailure);
                return networkFailure;
            }
        }
        return Unknown;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
