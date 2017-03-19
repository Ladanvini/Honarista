package test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class Pages {
	public String getRegistrationPage()
	{
		String temp="<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <title>Register</title>\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"    <link rel=\"stylesheet\" href=\"css/register.css\">\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
				"    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" + 
				"    <script src=\"js/index.js\"></script>\n" + 
				"\n" + 
				"</head>\n" + 
				"<body class=\"setBodyColor\">\n" + 
				"\n" + 
				"<div class=\"form\">\n" + 
				"\n" + 
				"    <a href=\"index.html\"><div class=\"btn btn-space btn-danger\">X</div></a>\n" + 
				"\n" + 
				"    <ul class=\"tab-group\">\n" + 
				"\n" + 
				"        <li class=\"tab active\"><a href=\"Ladan?Action=11\">ثبت نام</a></li>\n" + 
				"        <li class=\"tab\"><a href=\"Ladan?Action=10\">ورود</a></li>\n" + 
				"    </ul>\n" + 
				"\n" + 
				"    <div class=\"tab-content\">\n" + 
				"\n" + 
				"        <div id=\"signup\">\n" + 
				"\n" + 
				"            <form action=\"/\" method=\"post\">\n" + 
				"\n" + 
				"                <div class=\"top-row\">\n" + 
				"\n" + 
				"                    <div class=\"field-wrap\">\n" + 
				"                        <label>\n" + 
				"                            نام خانوادگی<span class=\"req\">*</span>\n" + 
				"                        </label>\n" + 
				"                        <input id=\"lastName\"type=\"text\"required autocomplete=\"off\"/>\n" + 
				"                    </div>\n" + 
				"\n" + 
				"                    <div class=\"field-wrap\">\n" + 
				"                        <label>\n" + 
				"                            نام<span class=\"req\">*</span>\n" + 
				"                        </label>\n" + 
				"                        <input id=\"firstName\" type=\"text\" required autocomplete=\"off\" />\n" + 
				"                    </div>\n" + 
				"\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        ایمیل<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regEmail\" type=\"email\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"        <div id=\"login\">\n" + 
				"\n" + 
				"            <form action=\"/\" method=\"post\">\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        Email Address<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"email\" type=\"email\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\" >\n" + 
				"                    <label>\n" + 
				"                        گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"password\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <button id=\"loginbtn\" class=\"button button-block\"/>ورود</button>\n" + 
				"\n" + 
				"                <p class=\"forgot\">رمز عبور خود را فراموش کرده اید؟ <a id=\"forgotPass\"href=\"#\">کلیک کنید</a></p>\n" + 
				"                <p class=\"forgot\"><a id=\"loginViaPhone\"href=\"#\">ورود</a> با شماره همراه</p>\n" + 
				"\n" + 
				"            </form>\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regPass\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        تکرار گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regPassRep\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"                <button id=\"regbtn\"type=\"submit\" class=\"button button-block\"/>ثبت</button>\n" + 
				"\n" + 
				"            </form>\n" + 
				"\n" + 
				"            <img src=\"Home%20Page/Artistic%20Icons%20Row.png\" class=\"img-rounded\" alt=\"Icons\" style=\"width:100%\">\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"    </div><!-- tab-content -->\n" + 
				"\n" + 
				"</div> <!-- /form -->\n" + 
				"<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" + 
				"\n" + 
				"<script src=\"js/index.js\"></script>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		return temp;
	}
	public String getLoginPage() {
		
		String temp=""
				+ "<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <title>Register</title>\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"    <link rel=\"stylesheet\" href=\"css/register.css\">\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
				"    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" + 
				"    <script src=\"js/index.js\"></script>\n" + 
				"\n" + 
				"</head>\n" + 
				"<body class=\"setBodyColor\">\n" + 
				"\n" + 
				"<div class=\"form\">\n" + 
				"\n" + 
				"    <a href=\"index.html\"><div class=\"btn btn-space btn-danger\">X</div></a>\n" + 
				"\n" + 
				"    <ul class=\"tab-group\">\n" + 
				"\n" + 
				"        <li class=\"tab\"><a href=\"Ladan?Action=11\">ثبت نام</a></li></a>\n" + 
				"        <li class=\"tab active\"><a href=\"Ladan?Action=10\">ورود</a></li></a>\n" + 
				"    </ul>\n" + 
				"\n" + 
				"    <div class=\"tab-content\">\n" + 
				"\n" + 
				"        <div id=\"login\">\n" + 
				"\n" + 
				"            <form action=\"Ladan?Action=1345\" method=\"post\">\n" + 
				"				<input type=\"hidden\" id=\"Action\" value=\"1345\"/>" +
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        Email Address<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"email\" type=\"email\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\" >\n" + 
				"                    <label>\n" + 
				"                        گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"password\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <button type=\"submit\" id=\"loginbtn\" class=\"button button-block\">ورود</button>\n" + 
				"\n" + 
				"                <p class=\"forgot\">رمز عبور خود را فراموش کرده اید؟ <a id=\"forgotPass\"href=\"Ladan?Action=13\">کلیک کنید</a></p>\n" + 
				"                <p class=\"forgot\"><a id=\"loginViaPhone\"href=\"Ladan?Action=14\">ورود</a> با شماره همراه</p>\n" + 
				"\n" + 
				"            </form>\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"\n" + 
				"        <div id=\"signup\">\n" + 
				"\n" + 
				"            <form action=\"/\" method=\"post\">\n" + 
				"\n" + 
				"                <div class=\"top-row\">\n" + 
				"\n" + 
				"                    <div class=\"field-wrap\">\n" + 
				"                        <label>\n" + 
				"                            نام خانوادگی<span class=\"req\">*</span>\n" + 
				"                        </label>\n" + 
				"                        <input id=\"lastName\"type=\"text\"required autocomplete=\"off\"/>\n" + 
				"                    </div>\n" + 
				"\n" + 
				"                    <div class=\"field-wrap\">\n" + 
				"                        <label>\n" + 
				"                            نام<span class=\"req\">*</span>\n" + 
				"                        </label>\n" + 
				"                        <input id=\"firstName\" type=\"text\" required autocomplete=\"off\" />\n" + 
				"                    </div>\n" + 
				"\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        ایمیل<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regEmail\" type=\"email\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regPass\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\">\n" + 
				"                    <label>\n" + 
				"                        تکرار گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input id=\"regPassRep\" type=\"password\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"                <button id=\"regbtn\"type=\"submit\" class=\"button button-block\"/>ثبت</button>\n" + 
				"\n" + 
				"            </form>\n" + 
				"\n" + 
				"            <img src=\"Home%20Page/Artistic%20Icons%20Row.png\" class=\"img-rounded\" alt=\"Icons\" style=\"width:100%\">\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"    </div><!-- tab-content -->\n" + 
				"\n" + 
				"</div> <!-- /form -->\n" + 
				"<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" + 
				"\n" + 
				"<script src=\"js/index.js\"></script>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		
		return temp;
	}

}
