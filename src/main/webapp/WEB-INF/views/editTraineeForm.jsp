<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trainee Updation Form</title>
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
    <form:form id="form" action="editTraineeSubmit" modelAttribute="trainee" method="get" class="container">
        <label for="traineeId">Trainee ID:</label>
        <form:input path="traineeId" id="traineeId" required="true" class="form-control" readonly="true"/>
        <form:errors path="traineeId" cssClass="error" element="div"/>

        <label for="traineeName">Trainee Name:</label>
        <form:input path="traineeName" id="traineeName" required="true" class="form-control"/>
        <form:errors path="traineeName" cssClass="error" element="div"/>


        <label for="emailId">Email ID:</label>
        <form:input path="emailId" id="emailId" type="text" required="true" class="form-control"/>
        <form:errors path="emailId" cssClass="error" element="div"/>

        <label for="contact">Contact Number:</label>
        <form:input path="contact" id="contact" type="number" required="true" class="form-control"/>
        <form:errors path="contact" cssClass="error" element="div"/>

        <label for="address">Address:</label>
        <form:textarea path="address" id="address" rows="4" cols="50" required="true" class="form-control"/>

        <label for="gender">Gender:</label>
        <form:radiobutton path="gender" id="gender" value="male" label="Male"/>
        <form:radiobutton path="gender" id="gender" value="female" label="Female"/>

        <label for="nationality">Nationality:</label>
        <form:input path="nationality" id="nationality" required="true" class="form-control"/>

        <label for="highestQualification">Highest Qualification:</label>
        <form:input path="highestQualification" id="highestQualification" required="true" class="form-control"/>

        <button type="submit"  class="btn btn-primary" style="margin-bottom: 6px;">
            Update
        </button>

    </form:form>

    <a href="../adminLogin" class="back-to-dashboard-link">Back To Dashboard</a>
</body>
</html>





