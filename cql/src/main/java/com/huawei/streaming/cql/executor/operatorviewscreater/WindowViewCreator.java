/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.cql.executor.operatorviewscreater;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.streaming.api.opereators.Window;
import com.huawei.streaming.api.streams.Schema;
import com.huawei.streaming.cql.exception.ExecutorException;
import com.huawei.streaming.cql.executor.windowcreater.WindowCreatorFactory;
import com.huawei.streaming.window.IWindow;

/**
 * 创建窗口视图实例
 * 
 */
public class WindowViewCreator
{
    
    private static final Logger LOG = LoggerFactory.getLogger(OrderByViewCreator.class);
    
    /**
     * 创建窗口
     * @param inputSchemas 输入schema
     * @param window 窗口描述
     * @param systemConfig 系统配置属性
     * @return 窗口实例
     * @throws com.huawei.streaming.cql.exception.ExecutorException 执行期异常
     */
    public IWindow create(List<Schema> inputSchemas, Window window, Map<String, String> systemConfig)
        throws ExecutorException
    {
        if (window == null || StringUtils.isEmpty(window.getName()))
        {
            //允许窗口为空
            LOG.info("window is null");
            return null;
        }
        
        return WindowCreatorFactory.createNewWindow(window, inputSchemas, systemConfig);
    }
}
