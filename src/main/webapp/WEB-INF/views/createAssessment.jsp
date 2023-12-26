<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.nucleus.project.bean.Trainee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Assessment Form</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <form action="submitTrainee" modelAttribute="assessment" method="get">
            <div class="form-group">
                <label for="assessmentName">Assessment Name:</label>
                <input type="text" id="assessmentName" name="assessmentName" required class="form-control">
            </div>

            <div class="form-group">
                <label for="question">Question:</label>
                <textarea id="question" name="question" rows="4" required class="form-control"></textarea>
            </div>

            <button type="button" class="btn btn-primary" id="saveSection">Save Question</button>
        </form>

        
        <button type="button" class="btn btn-primary" onclick="submitQuestion()">Submit Question</button>

        <div class="modal-body container mt-5">
            <table id="sectionTable" class="table">
                <thead>
                    <tr>
                        <th>Question</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>


    <script>
        let questionList = [];
        $(document).ready(function () {
            $('#saveSection').on('click', function () {
                var question = $('#question').val();
                questionList.push(question);

                var newRow = '<tr>' +
                    '<td>' + question + '</td>' +
                    '</tr>';
                $('#sectionTable tbody').append(newRow);
                $('#question').val('');

                console.log(questionList);
            });
        });


        function submitQuestion() {
            let assessmentName = document.getElementById("assessmentName").value;

                console.log(assessmentName);
                console.log(questionList);
                let jsonObject ={
                    assessmentName:assessmentName,
                    questionList:questionList
                }
                console.log(jsonObject);

                fetch('questionSubmit', {
                method: 'POST',
                headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(jsonObject)
            })
            .then(response => {
                if (response.ok) {

                    console.log('Form submitted successfully.');
                    window.location.href = 'traineeSuccess';
                } else {

                    console.error('Form submission failed.');
                }
            })
            .catch(error => {
                // Handle network error
                console.error('Network error:', error);
            });
        }
    </script>
</body>
</html>

