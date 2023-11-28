<jsp:include page="../include/header.jsp"/>

<h1>Employee Form</h1>
<form action="/saveEmployee" method="post"><label for="first_name">First Name:</label>
    <input type="text" id="first_name" name="first_name" required> <br>
    <label for="last_name">Last Name:</label> <input type="text" id="last_name" name="last_name" required>
    <br> <label for="department_name">Department Name:</label>
    <input type="text" id="department_name"name="department_name" required> <br>
    <button type="submit">Submit</button>
</form>


<jsp:include page="../include/footer.jsp"/>
