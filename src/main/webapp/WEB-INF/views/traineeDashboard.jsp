<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Trainee Dashboard</title>
    <style>

    body {
                background-color: #f8f9fa;
            }

            .container {
                margin-top: 50px;
            }

            .head {
                background-color: #343a40;
                color: #fff;
                padding: 20px;
                border-radius: 5px;
            }

            .title {
                margin-bottom: 0;
            }

            table {
                width: 100%;
                margin-top: 20px;
                border-collapse: collapse;
                border-radius: 5px;
                overflow: hidden;
            }

            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #dee2e6;
            }

            th {
                background-color: #343a40;
                color: #fff;
            }

            tbody tr:hover {
                background-color: #f8f9fa;
            }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }



                .navbar {
                    background-color: #007bff;
                }

                .navbar-brand {
                    font-size: 1.5em;
                    font-weight: bold;
                }

                .navbar-nav .nav-link {
                    color: #fff;
                }

                .navbar-nav .nav-link:hover {
                    color: #f8f9fa; /* lighter shade on hover */
                }

                /* Move the "Logout" button to the right */
                .ml-auto {
                    margin-left: auto !important;
                }
    </style>
</head>
<body>
         <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
                <span class="navbar-brand">TRAINEE</span>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>

    <form action="fetchDetailsForTrainee" method="get">

        <button type="submit" name="action" value="showBatchDetails">Show Batch Details</button>
        <button type="submit" name="action" value="showAssessments">Show Assessments</button>
    </form>
    <c:if test="${not empty batch}">
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
                                 <th>Max Trainee</th>
                                 <th>Available Trainee</th>

                             </tr>
                         </thead>
                         <tbody>

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
                             </tbody>
                         </table>
                     </div>
                 </div>
              </c:if>

         <c:if test="${not empty assessmentList}">
             <div class="container">
                    <div class="head">
                        <h3 class="title">Assessments</h3>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Assessment ID</th>
                                <th>Assessment Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="assessment" items="${assessmentList}">
                                <tr>
                                    <td>${assessment.assessmentId}</td>
                                    <td>${assessment.assessmentName}</td>
                                     <td>
                                                <c:forEach var="question1" items="${assessment.questionList}">
                                                    ${question1.question}<br>
                                                </c:forEach>
                                                            </td>
                                    <td>
                                        <a href="" onclick="return confirm('Do you want to Edit this record??');">
                                            <button class="edit-button">Take Assessment</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

</body>
</html>
