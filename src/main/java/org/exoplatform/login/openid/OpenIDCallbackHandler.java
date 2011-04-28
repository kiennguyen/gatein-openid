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

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * @author <a href="kien.nguyen@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public final class OpenIDCallbackHandler implements CallbackHandler
{
   
   /**
    * Name. 
    */
   private String login;

   /**
    * @param login name
    */
   public OpenIDCallbackHandler(String login) {
     this.login = login;
   }

   /**
    * {@inheritDoc}
    */
   public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
     for (int i = 0; i < callbacks.length; i++) {
       if (callbacks[i] instanceof NameCallback) {
         ((NameCallback) callbacks[i]).setName(login);
       } else {
         throw new UnsupportedCallbackException(callbacks[i], "Callback class not supported");
       }
     }
   }
}
