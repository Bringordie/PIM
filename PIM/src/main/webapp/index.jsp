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

    //PublishedStatusDataGraph
        Gson gsonObj4 = new Gson();
        ProductMapper product = new ProductMapper();
        List<Map<Object, Object>> list4 = product.chartPublishedStatusDiagram("/db.properties");
        String dataPoints4 = gsonObj.toJson(list4);
    //PublishedStatus
    
    //Count of all products
        Gson gsonObj5 = new Gson();
        List<Map<Object, Object>> list5 = product.getProductCountChart("/db.properties");
        String dataPoints5 = gsonObj.toJson(list5);
    //Count of all products
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

                var chart = new CanvasJS.Chart("publishedstatusData", {
                    animationEnabled: true,
                    exportEnabled: true,
                    title: {
                        text: "Publish status of products"
                    },
                    data: [{
                            type: "column", //change type to bar, line, area, pie, etc
                            //indexLabel: "{y}", //Shows y value on all Data Points
                            indexLabelFontColor: "#5A5757",
                           indexLabelPlacement: "outside" ,
                            dataPoints: <%out.print(dataPoints4);%>
                        }]
                });
                chart.render();
                
                var chart = new CanvasJS.Chart("uniqueavailableproducts", {
                    animationEnabled: true,
                    exportEnabled: true,
                    title: {
                        text: "Unique products in stock"
                    },
                    data: [{
                            type: "column", //change type to bar, line, area, pie, etc
                            //indexLabel: "{y}", //Shows y value on all Data Points
                            indexLabelFontColor: "#5A5757",
                           indexLabelPlacement: "outside" ,
                            dataPoints: <%out.print(dataPoints5);%>
                        }]
                });
                chart.render();
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
            <div class="diagram" id="publishedstatusData" style="height: 370px; width: 500px;"></div>
            <div class="diagram" id="uniqueavailableproducts" style="height: 370px; width: 500px;"></div>
        </div>
    </body>
</html>                  