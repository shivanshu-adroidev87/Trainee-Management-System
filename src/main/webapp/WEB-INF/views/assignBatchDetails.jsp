<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign Batch</title>
        <style>
            *{
            box-sizing: border-box;
            margin: 0;
            }
            .head{
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
            }
            .title{
            font-style: italic;
            font-weight: bolder;
            font-size: 25px;
            margin-bottom: 10px;
            }
            th{
            background-color: rgb(208, 208, 248);
            border: 1px solid white;
            padding: 5px;
            }
            td{
            padding: 5px;
            border: 1px solid black;
            }
            table{
            margin-top: 20px;
            margin-bottom: 20px;
            width: calc(100% - 10px);
            }
            a{
            color: black;
            text-decoration: none;
            }
    </style>
  </head>
        <body>
            <div class="head">
            <h3 class="title">Batch Details: </h3>

            <p>${trainee.traineeName}</p>
            <table>
                  <thead>
                            <tr>
                               <th>Batch ID</th>
                                <th>Creation Date</th>
                                <th>Start Date</th>
                                <th>Max Trainee</th>
                                <th>Seats Remaining</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="batch" items="${batchList}">
                                <tr>
                                    <td>${batch.batchId}</td>
                                    <td>${batch.creationDate}</td>
                                    <td>${batch.startDate}</td>
                                    <td>${batch.maxTrainee}</td>
                                    <td>${batch.maxTrainee-batch.traineeList.size()}</td>
                                     <td>
                                      <a href="assignBatchToTrainee/${batch.batchId}" onclick="return confirm('Do you want to assign ??');">
                                      <button class="edit-button">Add Batch</button>
                                      </a>

                                    </td>
                                </tr>
                            </c:forEach>

            </table>


        </body>
</html>