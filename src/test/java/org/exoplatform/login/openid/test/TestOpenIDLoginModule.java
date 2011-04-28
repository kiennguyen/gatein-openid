/**
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.login.openid.test;

import org.exoplatform.container.PortalContainer;
import org.exoplatform.container.RootContainer;
import org.exoplatform.login.openid.OpenIDCallbackHandler;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.services.organization.User;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

/**
 * @author <a href="kien.nguyen@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class TestOpenIDLoginModule //extends AbstractGateInTest
{
//   protected static OrganizationService organizationService;
//
//   
//   public TestOpenIDLoginModule(String name) {
//      super(name);
//   }
//   
//   protected void setUp() throws Exception {
//      System.setProperty("java.security.auth.login.config", "src/test/resources/login.conf" );
//      RootContainer rootContainer = RootContainer.getInstance();
//      PortalContainer manager = rootContainer.getPortalContainer("default");
//      PortalContainer.setInstance(manager) ;
//      //organizationService = (OrganizationService) manager.getComponentInstanceOfType(OrganizationService.class);
//   }
//   
//   public void testLogin() throws Exception {
//      OpenIDCallbackHandler callbackHandler = new OpenIDCallbackHandler("root");
//      LoginContext loginContext = new LoginContext("gatein-openid", callbackHandler);
//      loginContext.login();
//      //assertNotNull(loginContext.getSubject());      
//   }
}
