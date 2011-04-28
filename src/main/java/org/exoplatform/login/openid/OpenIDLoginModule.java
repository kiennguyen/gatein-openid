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

import org.exoplatform.container.ExoContainer;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.security.Authenticator;
import org.exoplatform.services.security.Identity;
import org.exoplatform.services.security.UsernameCredential;
import org.exoplatform.services.security.jaas.AbstractLoginModule;
import org.exoplatform.web.security.Credentials;
import org.exoplatform.web.security.security.CookieTokenService;
import org.exoplatform.web.security.security.TransientTokenService;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;

/**
 * @author <a href="kien.nguyen@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public final class OpenIDLoginModule extends AbstractLoginModule
{
   private static final Log LOG = ExoLogger.getLogger(OpenIDLoginModule.class.getName());
   
   protected Log getLogger() {
      return LOG;
   }

   public boolean login() throws LoginException {
      try
      {
         Callback[] callbacks = new Callback[1];
         callbacks[0] = new NameCallback("Username");
         callbackHandler.handle(callbacks);

         String username = new String(((NameCallback) callbacks[0])
               .getName());

         if (username == null)
         {
               return false;
         }            

         Authenticator authenticator = (Authenticator) getContainer()
               .getComponentInstanceOfType(Authenticator.class);

         if (authenticator == null)
         {
               throw new LoginException(
                  "No Authenticator component found, check your configuration");
         }

         Identity identity = authenticator.createIdentity(username);

         sharedState.put("exo.security.identity", identity);
         sharedState.put("javax.security.auth.login.name", username);
         subject.getPublicCredentials().add(new UsernameCredential(username));

         return true;
      }
      catch (final Throwable e)
      {
         throw new LoginException(e.getMessage());
      }
   }
   
   public boolean logout() throws LoginException {
      return true;
   }
   
   public boolean commit() throws LoginException {
      return true;
   }
   
   public boolean abort() throws LoginException {
      return true;
   }
}
