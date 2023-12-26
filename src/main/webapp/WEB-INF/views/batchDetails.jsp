<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batch Details</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .head {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
        }

        .title {
            font-style: italic;
            font-weight: bolder;
            font-size: 25px;
            margin-bottom: 10px;
        }

        table {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        a {
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="head">
            <h3 class="title">Batch Details:</h3>
            <table class="table table-bordered table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Batch ID</th>
                        <th>Supervised By</th>
                        <th>Type</th>
                        <th>Creation Date</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Max Capacity</th>
                        <th>Available Trainee</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="batch" items="${batchList}">
                        <tr>
                            <td>${batch.batchId}</td>
                            <td>${batch.supervisedBy}</td>
                            <td>${batch.batchType}</td>
                            <td>${batch.creationDate}</td>
                            <td>${batch.startDate}</td>
                            <td>${batch.endDate}</td>
                            <td>${batch.maxTrainee}</td>
                            <td>${batch.traineeList.size()}</td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
        <a href="./adminLogin">Back To Dashboard</a>
    <!-- Include Bootstrap JavaScript and jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
