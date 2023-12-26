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
         <form action="assignBatchToPreviousTrainee/${traineeId}" method="get" id="batchForm" onsubmit="return validateForm()">
             <table class="table table-bordered table-striped">
                 <thead class="thead-light">
                     <tr>
                         <th></th>
                         <th>Batch ID</th>
                         <th>Supervised By</th>
                         <th>Type</th>
                         <th>Start Date</th>
                         <th>End Date</th>
                         <th>Max Trainee</th>
                         <th>Seats Remaining</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach var="batch" items="${batchList}" varStatus="loop">
                     <c:if test="${batch.maxTrainee - batch.traineeList.size()>0}">
                         <tr>
                             <td>
                                 <input type="radio" name="selectedBatch" value="${batch.batchId}" id="batch${loop.index}">
                             </td>
                             <td>${batch.batchId}</td>
                             <td>${batch.supervisedBy}</td>
                             <td>${batch.batchType}</td>
                             <td>${batch.startDate}</td>
                             <td>${batch.endDate}</td>
                             <td>${batch.maxTrainee}</td>
                             <td>${batch.maxTrainee - batch.traineeList.size()}</td>
                         </tr>
                         </c:if>
                     </c:forEach>
                 </tbody>
             </table>
             <div id="errorMessage" style="color: red; display: none;">Please select a batch.</div>
             <button type="submit" class="btn btn-primary">Assign</button>
         </form>
     </div>

     <script>
         function validateForm() {
             var selectedBatch = document.querySelector('input[name="selectedBatch"]:checked');
             if (!selectedBatch) {
                 document.getElementById('errorMessage').style.display = 'block';
                 return false;
             } else {
                 document.getElementById('errorMessage').style.display = 'none';
                 return true;
             }
         }
     </script>
 </div>
    <!-- Include Bootstrap JavaScript and jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
