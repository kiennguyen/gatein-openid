<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false" import="java.util.*"%>


<div class="OpenIDMapForm">
  <div>Please input your existing account</div>
  <form action="<portlet:actionURL name="submitMapAction"/>" method="post" id="openid_form">
		<div class="openid_input_area">
			<input id="username" name="username" type="text" value="" />
			<input id="password" name="password" type="text" value="" />
			<input id="map" type="submit" value="Register"/>
		</div>
	</form>
</div>