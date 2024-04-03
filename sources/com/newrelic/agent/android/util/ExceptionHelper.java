package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class ExceptionHelper implements HarvestErrorCodes {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static int exceptionToErrorCode(Exception exc) {
        AgentLog agentLog = log;
        String name2 = exc.getClass().getName();
        agentLog.debug("ExceptionHelper: exception " + name2 + " to error code.");
        if (exc instanceof UnknownHostException) {
            return HarvestErrorCodes.NSURLErrorDNSLookupFailed;
        }
        if (exc instanceof SocketTimeoutException) {
            return HarvestErrorCodes.NSURLErrorTimedOut;
        }
        if (exc instanceof ConnectException) {
            return HarvestErrorCodes.NSURLErrorCannotConnectToHost;
        }
        if (exc instanceof MalformedURLException) {
            return -1000;
        }
        if (exc instanceof SSLException) {
            return HarvestErrorCodes.NSURLErrorSecureConnectionFailed;
        }
        if (exc instanceof FileNotFoundException) {
            return HarvestErrorCodes.NRURLErrorFileDoesNotExist;
        }
        if (exc instanceof EOFException) {
            return HarvestErrorCodes.NSURLErrorRequestBodyStreamExhausted;
        }
        if (exc instanceof IOException) {
            recordSupportabilityMetric(exc, "IOException");
        } else if (exc instanceof RuntimeException) {
            recordSupportabilityMetric(exc, "RuntimeException");
        }
        return -1;
    }

    public static void recordSupportabilityMetric(Exception exc, String str) {
        boolean z11;
        boolean z12;
        AgentHealthException agentHealthException = new AgentHealthException(exc);
        if (agentHealthException.getStackTrace() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (agentHealthException.getStackTrace().length > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && z12) {
            StackTraceElement stackTraceElement = agentHealthException.getStackTrace()[0];
            log.error(String.format("ExceptionHelper: %s:%s(%s:%s) %s[%s] %s", new Object[]{agentHealthException.getSourceClass(), agentHealthException.getSourceMethod(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), str, agentHealthException.getExceptionClass(), agentHealthException.getMessage()}));
            AgentHealth.noticeException(agentHealthException, str);
        }
    }
}
