<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment Details</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 30px auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .head {
            text-align: center;
            margin-bottom: 20px;
        }

        .title {
            font-style: italic;
            font-weight: bolder;
            font-size: 25px;
            margin-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        th,
        td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .edit-button {
            background-color: #4caf50;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .edit-button:hover {
            background-color: #45a049;
        }

        a {
            color: black;
            text-decoration: none;
        }

          .back-to-dashboard-link {
                    display: inline-block;
                    padding: 10px 20px;
                    text-decoration: none;
                    background-color: #3498db; /* Choose your preferred background color */
                    color: #fff; /* Choose your preferred text color */
                    border-radius: 5px;
                    transition: background-color 0.3s;
                }

                .back-to-dashboard-link:hover {
                    background-color: #2980b9; /* Change color on hover */
                }

    </style>
</head>

<body>
    <div class="container">
        <div class="head">
            <h3 class="title">Assessments</h3>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Assessment ID</th>
                    <th>Assessment Name</th>
                    <th>Questions</th>
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
                            <a href="batchDetails/${assessment.assessmentId}" onclick="return confirm('Do you want to Assign ??');">
                                <button class="edit-button">Assign to Batch</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

     <a href="./adminLogin" class="back-to-dashboard-link">Back To Dashboard</a>
</body>



</html>
