<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html:html>
    <head>
        <title><bean:message key="welcome.title"/></title>
        <html:base/>

        <link rel="stylesheet" href="<html:rewrite page="/css/main.css"/>" type="text/css"/>
    </head>
    <body bgcolor="white">

    <p>地震情報表示</p>

    <div class="container">
        先行するコンテンツ...

        <div class="block">
            <div class="block__element">
                <img src="img_01.png" alt="">
                見出しやテキストとテキスト
            </div>

            <div class="block__element">
                <img src="img_02.png" alt="">
                見出しやテキストとテキスト
            </div>

            <div class="block__element">
                <img src="img_03.png" alt="">
                見出しやテキストとテキストとテキストとテキストと...
            </div>
        </div>

        後続するコンテンツ...
    </div>

    <div class="container">
        <div class="block">
            <logic:iterate id="formEntry" name="EarthquakeFeedForm" property="entryList">
                <div class="block__element">
                    <bean:write name="formEntry" property="title"/>
                </div>
            </logic:iterate>
        </div>
    </div>
    </body>
</html:html>
