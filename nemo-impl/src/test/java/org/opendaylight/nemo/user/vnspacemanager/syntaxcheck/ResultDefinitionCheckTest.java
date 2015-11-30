/*
 * Copyright (c) 2015 Huawei, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.nemo.user.vnspacemanager.syntaxcheck;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.intent.rev151010.user.intent.Results;


/**
 * Created by Thomas Liu on 2015/11/11.
 */
public class ResultDefinitionCheckTest extends TestCase {

    private Results results;
    private ResultDefinitionCheck resultDefinitionCheckTest;
    @Before
    public void setUp() throws Exception {
        resultDefinitionCheckTest = mock(ResultDefinitionCheck.class);
        results = mock(Results.class);

    }

    @Test
    public void testCheckDefinition() throws Exception {
        resultDefinitionCheckTest.CheckDefinition(results);
        Assert.assertNotNull(resultDefinitionCheckTest);
        verify(resultDefinitionCheckTest).CheckDefinition(results);

    }
}