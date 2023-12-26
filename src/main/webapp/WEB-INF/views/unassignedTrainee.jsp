<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainee Information</title>
    <link rel="stylesheet" href="path/to/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 30px;
        }

        .table-responsive {
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }

        thead {
            background-color: #343a40;
            color: #ffffff;
        }

        a.btn {
            margin-right: 5px;
        }

        @media (max-width: 576px) {
            table {
                overflow-x: auto;
                display: block;
            }

            th, td {
                white-space: nowrap;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <div class="table-responsive">
        <table id="example" class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Trainee ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Registration Date</th>
                    <th>Nationality</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="trainee" items="${traineeList}">
                    <tr>
                        <td><a href="traineeDetails/${trainee.traineeId}">${trainee.traineeId}</a></td>
                        <td>${trainee.traineeName}</td>
                        <td>${trainee.emailId}</td>
                        <td>${trainee.contact}</td>
                        <td>${trainee.gender}</td>
                        <td>${trainee.address}</td>
                        <td>
                           ${trainee.registrationDate}
                        </td>
                        <td>${trainee.nationality}</td>
                        <td>
                            <a href="fetchBatchForTrainee/${trainee.traineeId}" class="btn btn-info btn-sm" role="button" onclick="return confirm('Do you want to Assign batch ??');">Assign to Batch</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap JS and any additional scripts -->
<script src="path/to/bootstrap.min.js"></script>
<script>
    // Add any custom JavaScript here
</script>

</body>
</html>
