package org.mockito.internal.verification.checkers;

import java.util.Arrays;
import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.reporting.Discrepancy;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.MatchableInvocation;

public class NumberOfInvocationsChecker {
    private NumberOfInvocationsChecker() {
    }

    public static void checkNumberOfInvocations(List<Invocation> list, MatchableInvocation matchableInvocation, int i11) {
        List<Invocation> findInvocations = InvocationsFinder.findInvocations(list, matchableInvocation);
        int size = findInvocations.size();
        if (i11 > size) {
            throw Reporter.tooFewActualInvocations(new Discrepancy(i11, size), matchableInvocation, InvocationsFinder.getAllLocations(findInvocations));
        } else if (i11 == 0 && size > 0) {
            throw Reporter.neverWantedButInvoked(matchableInvocation, findInvocations);
        } else if (i11 >= size) {
            InvocationMarker.markVerified(findInvocations, matchableInvocation);
        } else {
            throw Reporter.tooManyActualInvocations(i11, size, matchableInvocation, InvocationsFinder.getAllLocations(findInvocations));
        }
    }

    public static void checkNumberOfInvocationsNonGreedy(List<Invocation> list, MatchableInvocation matchableInvocation, int i11, InOrderContext inOrderContext) {
        Location location = null;
        int i12 = 0;
        while (i12 < i11) {
            Invocation findFirstMatchingUnverifiedInvocation = InvocationsFinder.findFirstMatchingUnverifiedInvocation(list, matchableInvocation, inOrderContext);
            if (findFirstMatchingUnverifiedInvocation != null) {
                InvocationMarker.markVerified(findFirstMatchingUnverifiedInvocation, matchableInvocation);
                inOrderContext.markVerified(findFirstMatchingUnverifiedInvocation);
                location = findFirstMatchingUnverifiedInvocation.getLocation();
                i12++;
            } else {
                throw Reporter.tooFewActualInvocationsInOrder(new Discrepancy(i11, i12), matchableInvocation, Arrays.asList(new Location[]{location}));
            }
        }
    }

    public static void checkNumberOfInvocations(List<Invocation> list, MatchableInvocation matchableInvocation, int i11, InOrderContext inOrderContext) {
        List<Invocation> findMatchingChunk = InvocationsFinder.findMatchingChunk(list, matchableInvocation, i11, inOrderContext);
        int size = findMatchingChunk.size();
        if (i11 > size) {
            throw Reporter.tooFewActualInvocationsInOrder(new Discrepancy(i11, size), matchableInvocation, InvocationsFinder.getAllLocations(findMatchingChunk));
        } else if (i11 >= size) {
            InvocationMarker.markVerifiedInOrder(findMatchingChunk, matchableInvocation, inOrderContext);
        } else {
            throw Reporter.tooManyActualInvocationsInOrder(i11, size, matchableInvocation, InvocationsFinder.getAllLocations(findMatchingChunk));
        }
    }
}
