<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Link to Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <title>Admin Dashboard</title>
     <style>
           body {
               font-family: Arial, sans-serif;
               background-color: #f0f0f0;
               margin: 0;
               padding: 0;
           }

           h2 {
               color: #333;
               text-align: center;
               padding: 20px 0;
           }

           a.link {
               text-decoration: none;
               padding: 10px 20px;
               background-color: #007BFF;
               color: #fff;
               border: none;
               border-radius: 5px;
               cursor: pointer;
           }

           a.link:hover {
               background-color: #0056b3;
           }

           table {
               width: 100%;
               border-collapse: collapse;
               margin: 20px 0;
               background-color: #fff;
               box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
           }

           th, td {
               padding: 10px;
               text-align: center;
           }

           th {
               background-color: #007BFF;
               color: #fff;
           }

           tr:nth-child(even) {
               background-color: #f2f2f2;
           }

           tr:hover {
               background-color: #ddd;
           }


           .custom-file-input {
               /* Add your custom styles here */
               border: 1px solid #ccc;
               padding: 10px;
               border-radius: 5px;
               background-color: #f9f9f9;
               color: #333;
           }

           /* Style the upload button */
           .custom-upload-button {
               /* Add your custom styles here */
               background-color: #007bff;
               color: #fff;
               border: none;
               border-radius: 5px;
               padding: 10px 20px;
               cursor: pointer;
           }

           /* Style the button on hover */
           .custom-upload-button:hover {
               background-color: #0056b3;
           }

           h2 {
                       text-align: center;
                        color: #008000;
                       padding: 20px 0;
                       font-size: 28px;
                       font-weight: bold;
                       text-transform: uppercase;
                   }
       </style>

</head>
<body>
    <!-- Add Bootstrap Navbar for navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        ADMIN
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- Page content -->
    <div class="container mt-4">

        <div class="row justify-content-center">
            <div class="col-md-4 mb-4">
                <a class="btn btn-primary btn-block" href="registerTrainee">Add new Trainee</a>
            </div>
            <div class="col-md-4 mb-4">
                <a class="btn btn-primary btn-block" href="registerBatch">Add new Batch</a>
            </div>
            <div class="col-md-4 mb-4">
                <a class="btn btn-primary btn-block" href="createAssessment">Add new Assessment</a>
            </div>

            <div class="col-md-4 mb-4">
                <a class="btn btn-primary btn-block" href="retrieveAssessments">All Assessments</a>
            </div>
             <div class="col-md-4 mb-4">
                <a class="btn btn-primary btn-block" href="retrieveTraineeDetails">List of Trainees</a>
             </div>

              <div class="col-md-4 mb-4">
                 <a class="btn btn-primary btn-block" href="batchDetails">All Batches</a>
              </div>
        </div>
        </div>
        <div class="data-table">
        <table id="example" class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Trainee ID</th>
                    <th>Assigned Batch Id </th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
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
                        <td>${trainee.batch.batchId}</td>
                        <td>${trainee.traineeName}</td>
                        <td>${trainee.emailId}</td>
                        <td>${trainee.contact}</td>
                        <td>${trainee.address}</td>
                        <td>${trainee.registrationDate}</td>
                        <td>${trainee.nationality}</td>
                        <td>
                            <a href="editTrainee/${trainee.traineeId}" class="btn btn-info btn-sm" onclick="return confirm('Do you want to Edit this record??');">
                            <button class="edit-button">Edit</button></a>
                            <a href="deleteTrainee/${trainee.traineeId}" class="btn btn-danger btn-sm" onclick="return confirm('Do you want to Delete this record??');"><button class="edit-button">Delete</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>

    <script>
        $(document).ready(function() {
            $('#example').DataTable({
                paging: true,
                searching: true,
                ordering: true,
                lengthMenu: [10, 25, 50, 100],
                order: [[0, 'asc']],
                columns: [
                    null,
                    null,
                    null,
                    { orderable: false },
                    { orderable: false },
                    null,
                    { orderable: false },
                    null,
                    { orderable: false },
                    null,
                    { orderable: false },
                    { orderable: false },
                ]
            });
        });
    </script>
</body>
</html>








