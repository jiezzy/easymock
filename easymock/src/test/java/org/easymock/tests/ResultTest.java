/**
 * Copyright 2001-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easymock.tests;

import static org.junit.Assert.*;

import org.easymock.internal.Result;
import org.easymock.internal.Results;
import org.junit.Test;

/**
 * @author OFFIS, Tammo Freese
 * @author Henri Tremblay
 */
public class ResultTest {

    @Test
    public void createThrowResultToString() {
        final Exception e = new Exception("Error message");
        final Result r = Result.createThrowResult(e);
        assertEquals("Answer throwing " + e, r.toString());
    }

    @Test
    public void createReturnResultToString() {
        final String value = "My value";
        final Result r = Result.createReturnResult(value);
        assertEquals("Answer returning " + value, r.toString());
    }

    @Test
    public void createDelegateResultToString() {
        final String value = "my value";
        final Result r = Result.createDelegatingResult(value);
        assertEquals("Delegated to " + value, r.toString());
    }

    @Test
    public void emptyResults() {
        // We never create a Results without at least one Range
        // This test is only to unit test Results with this to cover the case anyway
        final Results results = new Results();
        assertFalse(results.hasResults());
        assertNull(results.next());
    }
}
