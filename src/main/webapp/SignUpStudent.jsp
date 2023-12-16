<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
.login {
  min-height: 100vh;
}

.bg-image {
  background-image: url('https://i.pinimg.com/564x/76/6e/5d/766e5d702bcb5063ef8459102aee2bea.jpg');
  background-size: cover;
  background-position: center;
}

.login-heading {
  font-weight: 300;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}
  .label1 {
  color: red;
  padding: 8px;
}
    </style>

</head>
<body>
<body>
 
 <div class="container-fluid ps-md-0">
  <div class="row g-0">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Sign up</h3>

              <!-- Sign In Form -->
<form action="SignUp" method="post">
 					 
 
      <div class="form-group">
<span class="label1">*</span>
				<label for="firstName">First Name:</label> <input type="text"
					class="form-control" id="firstName" placeholder="john"
					
					name="firstName" required>
			</div>
			 <div class="form-group">
			  				<span class="label1">*</span>
			 
				<label for="lastName">last Name:</label> <input type="text"
					class="form-control" id="lastName" placeholder="doe"
					
					name="lastName" required>
			</div>
			<div class="form-group">
			 				<span class="label1">*</span>
			
				<label for="email">Email  :</label> <input type="text"
					class="form-control" id="email" placeholder="**@gmail.com"
					
					name="email" required>
			</div>
            
<div class="form-group">
 				<span class="label1">*</span>

				<label for="username">User Name:</label> <input type="text"
					class="form-control" id="username" placeholder="username"
					name="username" required>
			</div>

			<div class="form-group">
			 				<span class="label1">*</span>
			
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="must be 6 characters long with atleast 1 number"
					
					name="password" required>
			</div>
		 </br>
                         <p for="category" style="font-size:15px" >Student Type: </p>

	<div class="form-group col-md-4">
                         <select id="category" class="form-control">
                            <option selected="">Select </option>
                            <option>Middle School Student</option>
					<option>High School Student</option>
										<option>Undergraduate</option>
										<option>PostGraduate</option>
                         </select>
                    </div>
</br>
 
<div> 

 

			<button type="submit" name="buttonPressed" class="btn btn-primary">SignUp</button>
			 <div>${userMessage}</div>
    <div style="color:red">${errorMessage}</div>
  
 			
                  </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
 </body>
</body>
</html>