<%--
  Created by IntelliJ IDEA.
  User: javohir
  Date: 10/02/2023
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Responsive Loginform</title>
    <style>
        body {
            margin: 0;
            color: #6a6f8c;
            background: #c8c8c8;
            font: 600 16px/18px 'Open Sans', sans-serif;
        }

        .login-box {
            width: 100%;
            margin: auto;
            max-width: 525px;
            min-height: 670px;
            position: relative;
            background: url(https://images.unsplash.com/photo-1507208773393-40d9fc670acf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1268&q=80) no-repeat center;
            box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0 rgba(0, 0, 0, .19);
        }

        .login-snip {
            width: 100%;
            height: 100%;
            position: absolute;
            padding: 90px 70px 50px 70px;
            background: rgba(0, 77, 77, .9);
        }

        .login-snip .login,
        .login-snip .sign-up-form {
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            position: absolute;
            transform: rotateY(180deg);
            backface-visibility: hidden;
            transition: all .4s linear;
        }

        .login-snip .sign-in,
        .login-snip .sign-up,
        .login-space .group .check {
            display: none;
        }

        .login-snip .tab,
        .login-space .group .label,
        .login-space .group .button {
            text-transform: uppercase;
        }

        .login-snip .tab {
            font-size: 22px;
            margin-right: 15px;
            padding-bottom: 5px;
            margin: 0 15px 10px 0;
            display: inline-block;
            border-bottom: 2px solid transparent;
        }

        .login-snip .sign-in:checked + .tab,
        .login-snip .sign-up:checked + .tab {
            color: #fff;
            border-color: #1161ee;
        }

        .login-space {
            min-height: 345px;
            position: relative;
            perspective: 1000px;
            transform-style: preserve-3d;
        }

        .login-space .group {
            margin-bottom: 15px;
        }

        .login-space .group .label,
        .login-space .group .input,
        .login-space .group .button {
            width: 100%;
            color: #fff;
            display: block;
        }

        .login-space .group .input,
        .login-space .group .button {
            border: none;
            padding: 15px 20px;
            border-radius: 25px;
            background: rgba(255, 255, 255, .1);
        }

        .login-space .group input[data-type="password"] {
            text-security: circle;
            -webkit-text-security: circle;
        }

        .login-space .group .label {
            color: #aaa;
            font-size: 12px;
        }

        .login-space .group .button {
            background: #1161ee;
        }

        .login-space .group label .icon {
            width: 15px;
            height: 15px;
            border-radius: 2px;
            position: relative;
            display: inline-block;
            background: rgba(255, 255, 255, .1);
        }

        .login-space .group label .icon:before,
        .login-space .group label .icon:after {
            content: '';
            width: 10px;
            height: 2px;
            background: #fff;
            position: absolute;
            transition: all .2s ease-in-out 0s;
        }

        .login-space .group label .icon:before {
            left: 3px;
            width: 5px;
            bottom: 6px;
            transform: scale(0) rotate(0);
        }

        .login-space .group label .icon:after {
            top: 6px;
            right: 0;
            transform: scale(0) rotate(0);
        }

        .login-space .group .check:checked + label {
            color: #fff;
        }

        .login-space .group .check:checked + label .icon {
            background: #1161ee;
        }

        .login-space .group .check:checked + label .icon:before {
            transform: scale(1) rotate(45deg);
        }

        .login-space .group .check:checked + label .icon:after {
            transform: scale(1) rotate(-45deg);
        }

        .login-snip .sign-in:checked + .tab + .sign-up + .tab + .login-space .login {
            transform: rotate(0);
        }

        .login-snip .sign-up:checked + .tab + .login-space .sign-up-form {
            transform: rotate(0);
        }

        *, :after, :before {
            box-sizing: border-box
        }

        .clearfix:after, .clearfix:before {
            content: '';
            display: table
        }

        .clearfix:after {
            clear: both;
            display: block
        }

        a {
            color: inherit;
            text-decoration: none
        }


        .hr {
            height: 2px;
            margin: 60px 0 50px 0;
            background: rgba(255, 255, 255, .2);
        }

        .foot {
            text-align: center;
        }

        .card {
            width: 500px;
            left: 100px;
        }

        ::placeholder {
            color: #b3b3b3;
        }
    </style>
</head>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<script href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
                                    <%--                                <button type="submit" class="button" value="Sign Up"></button>--%>

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


</body>
</html>