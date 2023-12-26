<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batch Form</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
        }
        .form-group {
            margin-bottom: 20px;
        }
        input[type="date"],
        input[type="text"],
        input[type="number"],
        textarea,
        select {
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ced4da;
            font-size: 16px;
            width: 100%;
            box-sizing: border-box;
        }
        .error {
            color: red;
            margin-top: 5px;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
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
        <form:form method="get" action="submitBatch" modelAttribute="batch">
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <form:input type="date" id="startDate" path="startDate" required="true" class="form-control"/>
                <form:errors path="startDate" cssClass="error" element="div"/>

            </div>

            <div class="form-group">
                <label for="endDate">End Date:</label>
                <form:input type="date" id="endDate" path="endDate" required="true" class="form-control"/>
                <form:errors path="endDate" cssClass="error" element="div"/>

            </div>

            <div class="form-group">
                <label for="maxTrainee">Max Trainee:</label>
                <form:input type="number" id="maxTrainee" path="maxTrainee" required="true" class="form-control"/>
                <form:errors path="maxTrainee" cssClass="error" element="div"/>

            </div>

            <div class="form-group">
                <label for="supervisedBy">Supervised By:</label>
                <form:input type="text" id="supervisedBy" path="supervisedBy" required="true" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="batchType">Batch Type:</label>
                <form:select path="batchType" required="true" class="form-control">
                    <form:option value="">--Please choose an option--</form:option>
                    <form:option value="Testing">Testing</form:option>
                    <form:option value="Production">Production</form:option>
                    <form:option value="Networking">Networking</form:option>
                </form:select>
            </div>

            <div class="form-group">
                <label for="batchStatus">Batch Status:</label>
                <form:select path="batchStatus" required="true" class="form-control">
                    <form:option value="Newly Created"></form:option>

                </form:select>
            </div>

            <div class="form-group">
                <label for="batchDescription">Batch Description:</label>
                <form:textarea id="batchDescription" path="batchDescription" rows="5" cols="30" required="true" class="form-control"></form:textarea>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
      <a href="./adminLogin" class="back-to-dashboard-link">Back To Dashboard</a>
    <!-- Include Bootstrap JS and jQuery scripts here if needed -->

</body>
</html>
