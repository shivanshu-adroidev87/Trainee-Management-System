<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trainee Registration Form</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .error {
            color: red;
        }

        input[type="text"],
        input[type="email"],
        input[type="number"],
        textarea {
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        label {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        .modal-body {
            min-width: 40vw;
            background: #fff;
            max-width: 400px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
            margin-left: 50%;
            transform: translateX(-50%);
        }

        .modal .close-button {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }

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

        th {
            background-color: rgb(208, 208, 248);
            border: 1px solid white;
            padding: 10px;
        }

        td {
            padding: 10px;
            border: 1px solid black;
        }

        table {
            margin-top: 20px;
            margin-bottom: 20px;
            width: calc(100% - 10px);
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
  <form:form modelAttribute="trainee" action="traineeDetailsSubmit" method="post" id="form">

      <label for="traineeName"><spring:message code="lbl.name" text="Trainee Name" /></label>
      <form:input path="traineeName" id="traineeName" cssClass="form-control" required="true"/>
      <form:errors path="traineeName" cssClass="error" id="traineeNameError"/>

      <label for="emailId"><spring:message code="lbl.email" text="Email ID" /></label>
      <form:input path="emailId" id="emailId" cssClass="form-control" required="true"/>
      <form:errors path="emailId" cssClass="error" id="emailIdError"/>

      <label for="contact"><spring:message code="lbl.contact" text="Contact Number" /></label>
      <form:input path="contact" id="contact" cssClass="form-control" required="true"/>
      <form:errors path="contact" cssClass="error" id="contactError"/>


      <label for="address"><spring:message code="lbl.address" text="Address" /></label>
      <form:textarea path="address" id="address" rows="4" cols="50" cssClass="form-control" required="true"/>
      <form:errors path="address" cssClass="error"/>


      <label for="gender"><spring:message code="lbl.gender" text="Gender" /></label>
      <form:radiobutton path="gender" id="gender" value="male" required="true"/> Male
      <form:radiobutton path="gender" id="gender" value="female" required="true"/> Female

      <label for="nationality"><spring:message code="lbl.nationality" text="Nationality" /></label>
      <form:input path="nationality" id="nationality" cssClass="form-control" required="true"/>
      <form:errors path="nationality" cssClass="error"/>

      <label for="highestQualification"><spring:message code="lbl.highest" text="Highest Qualification" /></label>
      <form:input path="highestQualification" id="highestQualification" cssClass="form-control" required="true"/>
      <form:errors path="highestQualification" cssClass="error"/>


         <c:forEach var="error" items="${errors}">
                <div class="error">${error.defaultMessage}</div>
         </c:forEach>


      <button type="submit" id="submitForm" class="btn btn-primary" style="margin-bottom: 6px;" onclick="handleSaveData()">
          Submit
      </button>

  </form:form>

      <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#sectionModal" id="batchAssign">
        Assign Batch
    </button>

     <a href="./adminLogin" class="back-to-dashboard-link">Back To Dashboard</a>

   </div>




    <div class="modal-body">
        <table id="sectionTable" class="table">
            <thead>
                <tr>
                    <th>Assigned Batch Id</th>
                </tr>
            </thead>
            <tbody>
                <tr id="row"></tr>
            </tbody>
        </table>
    </div>

    <div class="modal fade" id="sectionModal" tabindex="-1" role="dialog" aria-labelledby="sectionModalLabel"
        aria-hidden="true" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="head">

                        <p>${trainee.traineeName}</p>
                        <table class="table table-striped">
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
                                  <c:if test="${batch.maxTrainee - batch.traineeList.size() > 0}">
                                      <tr>
                                          <td class="batchId">${batch.batchId}</td>
                                          <td>${batch.creationDate}</td>
                                          <td>${batch.startDate}</td>
                                          <td>${batch.maxTrainee}</td>
                                          <td>${batch.maxTrainee - batch.traineeList.size()}</td>
                                          <td>
                                              <button type="button" onclick="func('${batch.batchId}')" class="btn btn-primary" id="${batch.batchId}">Add to Batch</button>
                                          </td>
                                      </tr>
                                  </c:if>
                              </c:forEach>
                          </tbody>

                        </table>
                    </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="closeModalButton">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script>

        let form  = document.getElementById("form");
            form.addEventListener("submit", (event) => {
            event.preventDefault();
        });

        
        let tableBatchId = 0;
        function func(id) {
            console.log(id);
            tableBatchId = id;

            var newRow = '<tr class="tableBatchId">' +
                      '<td>' + id + '</td>' +
                      '</tr>';

            $('#sectionTable tbody tr:eq(0)').text(id);
            $('#sectionModal').modal('hide');

            // Clear modal fields after save
            $('#batchId').val('');
        }



        let dataObj={};
        function handleSaveData(){
        
        let traineeName = document.getElementById("traineeName").value;
        let emailId = document.getElementById("emailId").value;
        let contact = document.getElementById("contact").value;
        let address = document.getElementById("address").value;
        let gender = document.getElementById("gender").value;
        let nationality = document.getElementById("nationality").value;
        let highestQualification = document.getElementById("highestQualification").value;


        console.log("clicked")
        dataObj["traineeName"] = traineeName;
        dataObj["emailId"] = emailId;
        dataObj["contact"] = contact;
        dataObj["address"] = address;
        dataObj["gender"] = gender;
        dataObj["nationality"] = nationality;
        dataObj["highestQualification"] = highestQualification;
        dataObj["tableBatchId"]=tableBatchId;

        console.log(dataObj);
        console.log(typeof dataObj);



        if(dataObj.tableBatchId != null){
            console.log("present")
            sendData(dataObj);
        }else{
            console.log("Absent")

        }
     
        }
        
        
        
        
        function sendData(dataObj){
            console.log("gg",dataObj);
            fetch('traineeDetailsSubmit', {
                method: 'POST',
                headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(dataObj)
            })
            .then(response => {
                if (response.ok) {
                    // Form submitted successfully
                    console.log('Form submitted successfully.');
                    window.location.href = 'traineeSuccess';
                } else {
                    window.location.href = 'registerTrainee';
                    console.error('Form submission failed.');
                }
            })
            .catch(error => {

                console.error('Network error:', error);
            });
        }
    </script>
</body>
</html>





