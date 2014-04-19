/*
 * Copyright 2002-2014 iGeek, Inc.
 * All Rights Reserved
 * @Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.@
 */
 
package com.igeekinc.indelible.server.linux;

import org.apache.log4j.Logger;

import com.igeekinc.indelible.indeliblefs.linux.IndelibleAvahiMasterClient;
import com.igeekinc.indelible.server.IndelibleServer;
import com.igeekinc.indelible.server.IndelibleServerBonjour;

public class IndelibleServerBonjourLinux extends IndelibleServerBonjour
{	
	Logger logger = Logger.getLogger(getClass());
	public IndelibleServerBonjourLinux(IndelibleServer parent) 
	{
		super(parent);
	}

	@Override
	public synchronized void advertiseRegistry(int registryPort) 
	throws Exception 
	{
		if (advertise)
		{
			IndelibleAvahiMasterClient.getMasterClient().advertiseRegistry(registryPort);
		}
	}

	@Override
	public void advertiseEntityAuthenticationServer(int entityAuthenticationPort)
			throws Exception
	{
		if (advertise)
		{
			IndelibleAvahiMasterClient.getMasterClient().advertiseEntityAuthenticationRegistry(entityAuthenticationPort);
		}
	}
}
