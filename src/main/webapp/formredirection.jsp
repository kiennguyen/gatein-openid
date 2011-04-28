<%--
  ~ Copyright 2006-2008 Sxip Identity Corporation
  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;" isELIgnored="false" import="java.util.Map, java.util.Iterator, org.openid4java.message.AuthRequest" %>
<%
	AuthRequest authReq = (AuthRequest) request.getAttribute("authReq");
	Map pm = (Map) authReq.getParameterMap();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>OpenID HTML FORM Redirection</title>
</head>
<body onload="document.forms['openid-form-redirection'].submit();">
    <form name="openid-form-redirection" action="<%=authReq.getOPEndpoint()%>" method="post" accept-charset="utf-8">        
        <%
                Iterator keyit=pm.keySet().iterator();

                Object key;
                Object value;

                while (keyit.hasNext())
                {
                    key=keyit.next();
                    value=pm.get(key);
            %>
        <input type="hidden" name="<%=key%>" value="<%=value%>"/>
        <%
                }
        %>
        <button type="submit">Continue...</button>
    </form>
</body>
</html>
