<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Measurement Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h2 style="margin-left: 6rem; margin-top: 1rem;"><a href="index.jsp">Home</a></h2>

<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>Measurement Converter</h1>
            <p class="lead">Select the type of conversion you would like to perform and enter the measurement.
                <br />Press enter to see the result.</p>
            <form action="julien_measure_converter" method="post">
                <label for="measurement">Enter a measurement:</label>
                <input type="text" name="measurement" id="measurement">

                <label for="conversion">Select a unit:</label>
                <select name="conversion" id="conversion">
                    <option ${results.conversion == 'meters' ? 'selected' : ''} value="meters">Meters to Miles</option>
                    <option ${results.conversion == 'miles' ? 'selected' : ''} value="miles">Miles to Meters</option>
                    <option ${results.conversion == 'kilometers' ? 'selected' : ''} value="kilometers">Kilometers to Miles</option>
                </select>

                <button type="submit" class="btn btn-primary">Convert</button>
            </form>

            <c:if test="${not empty results}">
                <div>
                    <c:if test="${not empty results.measurementError}">
                        <p>${results.measurementError}</p>
                    </c:if>
                    <c:if test="${not empty results.conversionError}">
                        <p>${results.conversionError}</p>
                    </c:if>
                    <c:if test="${not empty results.convertedMeasurement}">
                        <p>${results.convertedMeasurement}</p>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>