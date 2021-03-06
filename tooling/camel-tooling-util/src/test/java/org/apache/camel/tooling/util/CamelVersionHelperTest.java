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
package org.apache.camel.tooling.util;

import org.junit.jupiter.api.Test;

import static org.apache.camel.tooling.util.CamelVersionHelper.isGE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CamelVersionHelperTest {

    @Test
    public void testGE() throws Exception {
        assertTrue(isGE("2.15.0", "2.15.0"));
        assertTrue(isGE("2.15.0", "2.15.1"));
        assertTrue(isGE("2.15.0", "2.16.0"));
        assertTrue(isGE("2.15.0", "2.16-SNAPSHOT"));
        assertTrue(isGE("2.15.0", "2.16-foo"));

        assertFalse(isGE("2.15.0", "2.14.3"));
        assertFalse(isGE("2.15.0", "2.13.0"));
        assertFalse(isGE("2.15.0", "2.13.1"));
        assertFalse(isGE("2.15.0", "2.14-SNAPSHOT"));
        assertFalse(isGE("2.15.0", "2.14-foo"));

        assertTrue(isGE("3.0.0", "3.0.0"));
        assertTrue(isGE("3.0.0", "3.1.1"));
        assertTrue(isGE("3.1.0", "3.2.0"));
        assertTrue(isGE("3.3.0", "3.3.0-SNAPSHOT"));
        assertTrue(isGE("3.3.0", "3.4.0-SNAPSHOT"));
    }
}
