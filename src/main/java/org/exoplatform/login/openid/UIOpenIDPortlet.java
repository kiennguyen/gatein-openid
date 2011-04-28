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
package org.exoplatform.login.openid;

import org.exoplatform.portal.application.PortalRequestContext;
import org.exoplatform.services.organization.User;
import org.exoplatform.webui.application.WebuiRequestContext;

import java.io.IOException;

import javax.jcr.LoginException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="kien.nguyen@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class UIOpenIDPortlet extends GenericPortlet
{
   @RenderMode(name = "VIEW")
   public void showOpenIDForm(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {
	   String identifier = null;
	   PortletContext portletContext = getPortletContext();
	   
	   identifier = OpenIDUtils.getCookieValue(request, OpenIDUtils.OPENID_IDENTIFIER_TOKEN);
	   if(identifier == null) {
		   portletContext.getRequestDispatcher("/openid.jsp").include(request, response);
	   } else { //Auto-login or register form
		   System.out.println("OpenID Identifier token: " + identifier);
		   OpenIDService service = new OpenIDServiceImpl();
		   //Check existing in GateIn account? auto-login : create user
		   User user = service.getAccount(identifier);
		   if(user != null) {
		      //Make auto-login for this openid identifier
		      //hard code root/gtn for demo auto-login
		      try {
		         service.login("root");
		      } catch (javax.security.auth.login.LoginException e) {
		         System.out.println("Login error: " + e);
		      }
		      System.out.println("Login sucessfully");
		      getPortletContext().getRequestDispatcher("/openid.jsp").include(request, response);
		   } else {
		      //Show register form
		      System.out.print("Show login form");
		      portletContext.getRequestDispatcher("/registerform.jsp").include(request, response);
		   }		   
	   }
   }
   
   @ProcessAction(name = "submitAction")
   public void submitAction(ActionRequest request, ActionResponse response)
         throws PortletException, IOException {
      PortalRequestContext context = (PortalRequestContext) WebuiRequestContext.getCurrentInstance();
      String openid_identifier = request.getParameter("openid_identifier");
      String openid_portlet_url = "http://localhost:8080" + context.getRequestURI();
      String servletUrl = "http://localhost:8080/openid/login?openid_identifier=" + openid_identifier 
      														+ "&openid_portlet_url=" + openid_portlet_url;
      response.sendRedirect(response.encodeURL(servletUrl));
   }
   
   @ProcessAction(name = "showMapformAction")
   public void showMapformAction(ActionRequest request, ActionResponse response)
         throws PortletException, IOException {
      PortletContext portletContext = getPortletContext();
      portletContext.getRequestDispatcher("/mapform.jsp").include(request, response);
   }
   
   @ProcessAction(name = "submitMapAction")
   public void submitMapAction(ActionRequest request, ActionResponse response)
         throws PortletException, IOException {
      //get username and password parameters
      
      //validate and make auto-login
   }
}
