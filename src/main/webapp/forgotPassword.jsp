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
              <h3 class="login-heading mb-4">Forgot Password</h3>

              <!-- Sign In Form -->
<form action="login1" method="forgotPassword">
 					 
              
<div class="form-group">
				<label for="uname">User Name:</label> <input type="text"
					class="form-control" id="username" placeholder="username"
					name="username" required>
			</div>

			 
               <div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control" id="email" placeholder="***@gmail.com"
					
					name="email" required>
			</div>
 	<div class="form-group">
				<label for="password">New Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					
					name="password" required>
			</div>
 
  <div class="form-group">
				<label for="password">Confirm Password:</label> <input type="password"
					class="form-control" id="password1" placeholder="Password"
					
					name="password" required>
			</div>
			 
  </br>

                <div class="d-grid">
                  <button class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2" type="submit">Done</button>
                       
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