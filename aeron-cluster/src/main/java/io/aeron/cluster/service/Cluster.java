/*
 * Copyright 2017 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.aeron.cluster.service;

/**
 * Interface for a {@link ClusteredService} to interact with cluster hosting it.
 */
public interface Cluster
{
    /**
     * Get the {@link ClientSession} for a given cluster session id.
     *
     * @param clusterSessionId to be looked up.
     * @return the {@link ClientSession} that matches the clusterSessionId.
     */
    ClientSession getClientSession(long clusterSessionId);

    /**
     * Current Epoch time in milliseconds.
     *
     * @return Epoch time in milliseconds.
     */
    long timeMs();

    /**
     * Schedule a timer for a given deadline and provide a correlation id to identify the timer when it expires.
     * <p>
     * If the correlationId is for an existing scheduled timer then it will be reschedule to the new deadline.
     *
     * @param correlationId to identify the timer when it expires.
     * @param deadlineMs after which the timer will fire.
     */
    void scheduleTimer(long correlationId, long deadlineMs);

    /**
     * Cancel a previous scheduled timer.
     *
     * @param correlationId for the scheduled timer.
     */
    void cancelTimer(long correlationId);
}
