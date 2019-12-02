<%@page import="persistence.ProductMapper"%>
<!DOCTYPE HTML>
<html>
<%@page import="persistence.CategoryMapper"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="index.css">
<%
//Minor
    Gson gsonObj = new Gson();
    CategoryMapper category = new CategoryMapper();
    List<Map<Object, Object>> list = category.chartMinorCategory("/db.properties");
    String dataPoints = gsonObj.toJson(list);
// Minor

//Main
    Gson gsonObj2 = new Gson();
    CategoryMapper category2 = new CategoryMapper();
    List<Map<Object, Object>> list2 = category.chartMainCategory("/db.properties");
    String dataPoints2 = gsonObj.toJson(list2);
//Main

//PublishedStatus
    Gson gsonObj3 = new Gson();
    ProductMapper product = new ProductMapper();
    List<Map<Object, Object>> list3 = product.chartPublishedStatus("/db.properties");
    String dataPoints3 = gsonObj.toJson(list3);
//PublishedStatus
%>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
       <script type="text/javascript">
            window.onload = function () {

                var chart = new CanvasJS.Chart("minorcategory", {
                    theme: "light2",
                    exportEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: "Minor categories"
                    },
                    data: [{
                            type: "pie",
                            toolTipContent: "<b>{label}</b>: {y}%",
                            indexLabelFontSize: 16,
                            indexLabel: "{label} - {y}%",
                            dataPoints: <%out.print(dataPoints);%>
                        }]
                });
                chart.render();
                
                var chart2 = new CanvasJS.Chart("maincategory", {
                    theme: "light2",
                    exportEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: "Main categories"
                    },
                    data: [{
                            type: "pie",
                            toolTipContent: "<b>{label}</b>: {y}%",
                            indexLabelFontSize: 16,
                            indexLabel: "{label} - {y}%",
                            dataPoints: <%out.print(dataPoints2);%>
                        }]
                });
                chart2.render();
                
               var chart2 = new CanvasJS.Chart("publishedstatus", {
                    theme: "light2",
                    exportEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: "Publish status"
                    },
                    data: [{
                            type: "pie",
                            toolTipContent: "<b>{label}</b>: {y}%",
                            indexLabelFontSize: 16,
                            indexLabel: "{label} - {y}%",
                            dataPoints: <%out.print(dataPoints3);%>
                        }]
                });
                chart2.render(); 
            };
        </script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
        <div class="roughcontainer">
        <div class="graph" id="minorcategory" style="height: 370px; width: 500px;"></div>
        <div class="graph" id="maincategory" style="height: 370px; width: 500px;"></div>
        </div>
        <div class="secondrow">
            <div class="graph" id="publishedstatus" style="height: 370px; width: 500px;"></div>
        </div>
    </body>
</html>                  