package com.newrelic.agent.android.util;

import com.newrelic.agent.android.Agent;
import java.io.PrintStream;

public class AgentBuildOptionsReporter {
    public static void main(String[] strArr) {
        PrintStream printStream = System.out;
        String version = Agent.getVersion();
        printStream.println("Agent version: " + version);
        PrintStream printStream2 = System.out;
        String buildId = Agent.getBuildId();
        printStream2.println("Build ID: " + buildId);
    }
}
