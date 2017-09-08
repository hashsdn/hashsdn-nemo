/*
 * Copyright (c) 2015 Huawei, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.nemo.renderer.cli;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.CheckedFuture;
import java.lang.reflect.Method;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.generic.physical.network.rev151010.PhysicalNetwork;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.generic.virtual.network.rev151010.virtual.networks.VirtualNetwork;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.intent.mapping.result.rev151010.intent.vn.mapping.results.UserIntentVnMapping;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.UserId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.intent.rev151010.users.User;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
/**
 * Created by zhangmeng on 2015/12/8.
 */
public class CliTriggerTest extends TestCase {
    private CliTrigger cliTrigger;
    private DataBroker dataBroker;
    @Override
    @Before
    public void setUp() throws Exception {
        dataBroker = mock(DataBroker.class);
        cliTrigger = new CliTrigger(dataBroker);
    }

    @Test
    public void testClose() throws Exception {
        cliTrigger.close();
    }

    @Test
    public void testRegisterUserVnPnMappingListener() throws Exception{
        Class<CliTrigger> class1 = CliTrigger.class;
        Method method = class1.getDeclaredMethod("registerUserVnPnMappingListener");
        method.setAccessible(true);

        method.invoke(cliTrigger);
    }

    @Test
    public void testGetUser() throws Exception{
        Class<CliTrigger> class1 = CliTrigger.class;
        Method method = class1.getDeclaredMethod("getUser", new Class[]{UserId.class});
        method.setAccessible(true);

        Optional<User>  optional = mock(Optional.class);
        UserId userId = mock(UserId.class);
        User result;
        ReadOnlyTransaction readOnlyTransaction = mock(ReadOnlyTransaction.class);
        CheckedFuture checkedFuture = mock(CheckedFuture.class);

        when(dataBroker.newReadOnlyTransaction()).thenReturn(readOnlyTransaction);
        when(readOnlyTransaction.read(any(LogicalDatastoreType.class), any(InstanceIdentifier.class))).thenReturn(checkedFuture);
        when(checkedFuture.get()).thenReturn(optional);
        when(optional.isPresent())
                .thenReturn(false)
                .thenReturn(true);
        when(optional.get()).thenReturn(mock(User.class));

        result = (User)method.invoke(cliTrigger, userId);
        Assert.assertTrue(result == null);
        result = (User)method.invoke(cliTrigger,userId);
        Assert.assertTrue(result != null);
        verify(optional).get();
        verify(optional,times(2)).isPresent();
    }

    @Test
    public void testGetVirtualNetwork() throws Exception{
        Class<CliTrigger> class1 = CliTrigger.class;
        Method method = class1.getDeclaredMethod("getVirtualNetwork", new Class[]{UserId.class});
        method.setAccessible(true);

        UserId userId = mock(UserId.class);
        VirtualNetwork result;
        ReadOnlyTransaction readOnlyTransaction = mock(ReadOnlyTransaction.class);
        CheckedFuture checkedFuture = mock(CheckedFuture.class);
        Optional<VirtualNetwork>  optional = mock(Optional.class);

        when(userId.getValue()).thenReturn(new String("00001111-0000-0000-0000-000011112222"));
        when(dataBroker.newReadOnlyTransaction()).thenReturn(readOnlyTransaction);
        when(readOnlyTransaction.read(any(LogicalDatastoreType.class), any(InstanceIdentifier.class))).thenReturn(checkedFuture);
        when(checkedFuture.get()).thenReturn(optional);
        when(optional.isPresent())
                .thenReturn(false)
                .thenReturn(true);
        when(optional.get()).thenReturn(mock(VirtualNetwork.class));

        result = (VirtualNetwork) method.invoke(cliTrigger,userId);
        Assert.assertTrue(result == null);
        result = (VirtualNetwork) method.invoke(cliTrigger,userId);
        Assert.assertTrue(result != null);
        verify(optional).get();
        verify(optional,times(2)).isPresent();

    }

    @Test
    public void testGetUserIntentVnMapping() throws Exception{
        Class<CliTrigger> class1 = CliTrigger.class;
        Method method = class1.getDeclaredMethod("getUserIntentVnMapping", new Class[]{UserId.class});
        method.setAccessible(true);

        UserId userId = mock(UserId.class);
        UserIntentVnMapping result;
        ReadOnlyTransaction readOnlyTransaction = mock(ReadOnlyTransaction.class);
        CheckedFuture checkedFuture = mock(CheckedFuture.class);
        Optional<UserIntentVnMapping>  optional = mock(Optional.class);

        when(dataBroker.newReadOnlyTransaction()).thenReturn(readOnlyTransaction);
        when(readOnlyTransaction.read(any(LogicalDatastoreType.class), any(InstanceIdentifier.class))).thenReturn(checkedFuture);
        when(checkedFuture.get()).thenReturn(optional);
        when(optional.isPresent())
                .thenReturn(false)
                .thenReturn(true);
        when(optional.get()).thenReturn(mock(UserIntentVnMapping.class));

        result = (UserIntentVnMapping) method.invoke(cliTrigger,userId);
        Assert.assertTrue(result == null);
//        new UserId("00001111-0000-0000-0000-000011112222");
        result = (UserIntentVnMapping) method.invoke(cliTrigger,userId);
        Assert.assertTrue(result != null);
        verify(optional).get();
        verify(optional,times(2)).isPresent();
    }

    @Test
    public void testGetPhysicalNetwork() throws Exception{
        Class<CliTrigger> class1 = CliTrigger.class;
        Method method = class1.getDeclaredMethod("getPhysicalNetwork");
        method.setAccessible(true);

        ReadOnlyTransaction readOnlyTransaction = mock(ReadOnlyTransaction.class);
        CheckedFuture checkedFuture = mock(CheckedFuture.class);
        Optional<PhysicalNetwork>  optional = mock(Optional.class);
        PhysicalNetwork result;

        when(dataBroker.newReadOnlyTransaction()).thenReturn(readOnlyTransaction);
        when(readOnlyTransaction.read(any(LogicalDatastoreType.class), any(InstanceIdentifier.class))).thenReturn(checkedFuture);
        when(checkedFuture.get()).thenReturn(optional);
        when(optional.isPresent())
                .thenReturn(false)
                .thenReturn(true);
        when(optional.get()).thenReturn(mock(PhysicalNetwork.class));

        result = (PhysicalNetwork) method.invoke(cliTrigger);
        Assert.assertTrue(result == null);
        result = (PhysicalNetwork) method.invoke(cliTrigger);
        Assert.assertTrue(result != null);
        verify(optional).get();
        verify(optional, times(2)).isPresent();
    }
}
