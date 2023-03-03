<%--
  Created by IntelliJ IDEA.
  User: javohir
  Date: 10/02/2023
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Responsive Loginform</title>

    <link rel="stylesheet" href="/resources/css/user-style.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="row">


    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <%--            <!-- RECOVERY -->--%>
            <%--            <div class="recovery">--%>
            <%--                <h2>Password Recovery</h2>--%>
            <%--                <p>Enter either the <strong>email address</strong> or <strong>username</strong> on the account and <strong>click Submit</strong></p>--%>
            <%--                <p>We'll email instructions on how to reset your password.</p>--%>
            <%--                <form class="recovery-form" action="" method="post">--%>
            <%--                    <input type="text" class="input" id="user_recover" placeholder="Enter Email or Username Here">--%>
            <%--                    <input type="submit" class="button" value="Submit">--%>
            <%--                </form>--%>
            <%--                <p class="mssg">An email has been sent to you with further instructions.</p>--%>
            <%--            </div>--%>

            <div class="login-box">
                <div class="login-snip">
                    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label>
                    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign
                    Up</label>
                    <div class="login-space">
                        <form action="/login" method="post">
                            <div class="login">
                                <div class="group">
                                    <label for="login_email" class="label">Email</label>
                                    <input id="login_email" name="login_email" type="email" class="input"
                                           placeholder="Enter your email">
                                </div>
                                <div class="group">
                                    <label for="login_password" class="label">Password</label>
                                    <input id="login_password" name="login_password" type="password" class="input"
                                           data-type="password" placeholder="Enter your password">
                                </div>
                                <div class="group">
                                    <input id="check" type="checkbox" class="check" checked>
                                    <label for="check"><span class="icon"></span> Keep me Signed in</label>
                                </div>
                                <div class="group">
                                    <input type="submit" class="button" value="Sign In">
                                </div>


                                <div class="hr"></div>
                                <div class="forgot">
                                    <a href="#">Forgot Password?</a>
                                </div>
                            </div>
                        </form>
                        <form action="/register" method="post">
                            <div class="sign-up-form">
                                <div class="group">
                                    <label for="username" class="label">Username</label>
                                    <input name="username" id="username" type="text" class="input"
                                           placeholder="Create your Username">
                                </div>
                                <div class="group">
                                    <label for="password" class="label">Password</label>
                                    <input name="password" id="password" type="password" class="input"
                                           data-type="password" placeholder="Create your password">
                                </div>
                                <div class="group">
                                    <label for="confirmation_password" class="label">Repeat Password</label>
                                    <input name="confirmation_password" id="confirmation_password" type="password"
                                           class="input" data-type="password" placeholder="Repeat your password">
                                </div>
                                <div class="group">
                                    <label for="email" class="label">Email Address</label>
                                    <input name="email" id="email" type="text" class="input"
                                           placeholder="Enter your email address">
                                </div>
                                <div class="group">
                                    <input type="submit" class="button" value="Sign Up">
                                </div>
                                <div class="hr"></div>
                                <div class="foot">
                                    <label for="tab-1">Already Member?</label>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>