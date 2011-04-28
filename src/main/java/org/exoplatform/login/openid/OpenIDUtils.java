/**
 * 
 */
package org.exoplatform.login.openid;

import javax.portlet.PortletRequest;
import javax.servlet.http.Cookie;
/**
 * @author <a href="kien.nguyen@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public final class OpenIDUtils {
	   public static final String OPENID_IDENTIFIER_TOKEN = "openid_identifier_token";
	   
	   public static String getCookieValue(PortletRequest request, String name) {
		   Cookie[] cookies = request.getCookies();
		   if(cookies != null) {
			   for(Cookie c : cookies) {
				   if(c.getName().equals(name)) {
					   return c.getValue();
				   }
			   }
		   }
		   return null;
	   }
}
