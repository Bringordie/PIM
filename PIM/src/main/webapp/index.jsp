<!DOCTYPE HTML>
<html>
    <%@page import="persistence.DBFacade"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.google.gson.Gson"%>
    <%@ page import="com.google.gson.JsonObject"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="index.css">
    <%
        DBFacade db = new DBFacade();
    //Minor
        String minorvalue = db.chartMinorCategory("/db.properties");
    // Minor

    //Main
        String mainvalue = db.chartMainCategory("/db.properties");
    //Main

    //PublishedStatusDataGraph
        String publishedStatus = db.chartPublishedStatusDiagram("/db.properties");
    //PublishedStatus
    
    //Count of all products
        String allProducts = db.getProductCountChart("/db.properties");
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
                           dataPoints: <%out.print(minorvalue);%>
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
                           dataPoints: <%out.print(mainvalue);%>
                        }]
                });
                chart2.render();

                var chart = new CanvasJS.Chart("publishedstatusData", {
                theme: "light2",
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
                            dataPoints: <%out.print(publishedStatus);%>
                        }]
                });
                chart.render();
                
                var chart = new CanvasJS.Chart("uniqueavailableproducts", {
                theme: "light2",
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
                            dataPoints: <%out.print(allProducts);%>
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