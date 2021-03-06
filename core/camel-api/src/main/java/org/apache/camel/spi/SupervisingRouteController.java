/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.spi;

/**
 * A supervising capable {@link RouteController} that delays the startup
 * of the routes after the camel context startup and takes control of starting the routes in a safe manner.
 * This controller is able to retry starting failing routes, and have various options to configure
 * settings for backoff between restarting routes.
 */
public interface SupervisingRouteController extends RouteController {

    int getThreadPoolSize();

    /**
     * The number of threads used by the scheduled thread pool that are used for restarting
     * routes. The pool uses 1 thread by default, but you can increase this to allow the controller
     * to concurrently attempt to restart multiple routes in case more than one route has problems
     * starting.
     */
    void setThreadPoolSize(int threadPoolSize);

    long getInitialDelay();

    /**
     * Initial delay in milli seconds before the route controller starts, after
     * CamelContext has been started.
     */
    void setInitialDelay(long initialDelay);

    long getBackOffDelay();

    /**
     * Backoff delay in millis when restarting a route that failed to startup.
     */
    void setBackOffDelay(long backOffDelay);

    long getBackOffMaxDelay();

    /**
     * Backoff maximum delay in millis when restarting a route that failed to startup.
     */
    void setBackOffMaxDelay(long backOffMaxDelay);

    long getBackOffMaxElapsedTime();

    /**
     * Backoff maximum elapsed time in millis, after which the backoff should be considered
     * exhausted and no more attempts should be made.
     */
    void setBackOffMaxElapsedTime(long backOffMaxElapsedTime);

    long getBackOffMaxAttempts();

    /**
     * Backoff maximum number of attempts to restart a route that failed to startup.
     * When this threshold has been exceeded then the controller will give up
     * attempting to restart the route, and the route will remain as stopped.
     */
    void setBackOffMaxAttempts(long backOffMaxAttempts);

    double getBackOffMultiplier();

    /**
     * Backoff multiplier to use for exponential backoff. This is used to extend the delay
     * between restart attempts.
     */
    void setBackOffMultiplier(double backOffMultiplier);

}
