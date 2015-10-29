/*
 * Copyright (c) 2015 Huawei, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.nemo.user.vnspacemanager.instancecheck;

import org.opendaylight.nemo.user.tenantmanager.TenantManage;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.UserId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.intent.rev151010.user.intent.Results;


/**
 * Created by z00293636 on 2015/9/10.
 */
public class ResultInstanceCheck {
    private TenantManage tenantManage;

    public ResultInstanceCheck(TenantManage tenantManage)
    {
        this.tenantManage = tenantManage;
    }

    public String checkResultInstance(UserId userId,Results results)
    {
        return null;
    }
}
