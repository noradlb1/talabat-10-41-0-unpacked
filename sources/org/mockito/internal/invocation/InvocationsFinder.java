package org.mockito.internal.invocation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mockito.internal.util.collections.ListUtil;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.MatchableInvocation;

public class InvocationsFinder {

    public static class RemoveNotMatching implements ListUtil.Filter<Invocation> {
        private final MatchableInvocation wanted;

        private RemoveNotMatching(MatchableInvocation matchableInvocation) {
            this.wanted = matchableInvocation;
        }

        public boolean isOut(Invocation invocation) {
            return !this.wanted.matches(invocation);
        }
    }

    public static class RemoveUnverifiedInOrder implements ListUtil.Filter<Invocation> {
        private final InOrderContext orderingContext;

        public RemoveUnverifiedInOrder(InOrderContext inOrderContext) {
            this.orderingContext = inOrderContext;
        }

        public boolean isOut(Invocation invocation) {
            return !this.orderingContext.isVerified(invocation);
        }
    }

    private InvocationsFinder() {
    }

    public static Invocation a(List<Invocation> list, Object obj) {
        boolean z11;
        for (Invocation next : list) {
            if (obj == null || obj == next.getMock()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!next.isVerified() && z11) {
                return next;
            }
        }
        return null;
    }

    public static List<Invocation> findAllMatchingUnverifiedChunks(List<Invocation> list, MatchableInvocation matchableInvocation, InOrderContext inOrderContext) {
        return ListUtil.filter(removeVerifiedInOrder(list, inOrderContext), new RemoveNotMatching(matchableInvocation));
    }

    public static Invocation findFirstMatchingUnverifiedInvocation(List<Invocation> list, MatchableInvocation matchableInvocation, InOrderContext inOrderContext) {
        for (Invocation next : removeVerifiedInOrder(list, inOrderContext)) {
            if (matchableInvocation.matches(next)) {
                return next;
            }
        }
        return null;
    }

    public static Invocation findFirstUnverified(List<Invocation> list) {
        return a(list, (Object) null);
    }

    public static Invocation findFirstUnverifiedInOrder(InOrderContext inOrderContext, List<Invocation> list) {
        Iterator<Invocation> it = list.iterator();
        while (true) {
            Invocation invocation = null;
            while (true) {
                if (!it.hasNext()) {
                    return invocation;
                }
                Invocation next = it.next();
                if (!inOrderContext.isVerified(next)) {
                    if (invocation == null) {
                        invocation = next;
                    }
                }
            }
        }
    }

    public static List<Invocation> findInvocations(List<Invocation> list, MatchableInvocation matchableInvocation) {
        return ListUtil.filter(list, new RemoveNotMatching(matchableInvocation));
    }

    public static List<Invocation> findMatchingChunk(List<Invocation> list, MatchableInvocation matchableInvocation, int i11, InOrderContext inOrderContext) {
        List<Invocation> firstMatchingChunk = getFirstMatchingChunk(matchableInvocation, removeVerifiedInOrder(list, inOrderContext));
        if (i11 != firstMatchingChunk.size()) {
            return findAllMatchingUnverifiedChunks(list, matchableInvocation, inOrderContext);
        }
        return firstMatchingChunk;
    }

    public static Invocation findPreviousVerifiedInOrder(List<Invocation> list, InOrderContext inOrderContext) {
        LinkedList<T> filter = ListUtil.filter(list, new RemoveUnverifiedInOrder(inOrderContext));
        if (filter.isEmpty()) {
            return null;
        }
        return (Invocation) filter.getLast();
    }

    public static Invocation findSimilarInvocation(List<Invocation> list, MatchableInvocation matchableInvocation) {
        Invocation invocation = null;
        for (Invocation next : list) {
            if (matchableInvocation.hasSimilarMethod(next)) {
                if (invocation == null) {
                    invocation = next;
                }
                if (matchableInvocation.hasSameMethod(next)) {
                    return next;
                }
            }
        }
        return invocation;
    }

    public static List<Location> getAllLocations(List<Invocation> list) {
        LinkedList linkedList = new LinkedList();
        for (Invocation location : list) {
            linkedList.add(location.getLocation());
        }
        return linkedList;
    }

    private static List<Invocation> getFirstMatchingChunk(MatchableInvocation matchableInvocation, List<Invocation> list) {
        LinkedList linkedList = new LinkedList();
        for (Invocation next : list) {
            if (matchableInvocation.matches(next)) {
                linkedList.add(next);
            } else if (!linkedList.isEmpty()) {
                break;
            }
        }
        return linkedList;
    }

    public static Location getLastLocation(List<Invocation> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1).getLocation();
    }

    private static List<Invocation> removeVerifiedInOrder(List<Invocation> list, InOrderContext inOrderContext) {
        LinkedList linkedList = new LinkedList();
        for (Invocation next : list) {
            if (inOrderContext.isVerified(next)) {
                linkedList.clear();
            } else {
                linkedList.add(next);
            }
        }
        return linkedList;
    }
}
