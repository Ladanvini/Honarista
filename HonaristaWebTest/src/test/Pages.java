package test;

import java.util.Stack;

import Service.*;
import entity.*;
public class Pages {
	private UserService _us;
	private User loggedIn;
	private ShopService _ss;
	public Pages()
	{
		_us = new UserService();
		_ss = new ShopService(_us);
	}
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
				"                    <input name=\"email\" type=\"email\"required autocomplete=\"off\"/>\n" + 
				"                </div>\n" + 
				"\n" + 
				"                <div class=\"field-wrap\" >\n" + 
				"                    <label>\n" + 
				"                        گذرواژه<span class=\"req\">*</span>\n" + 
				"                    </label>\n" + 
				"                    <input name=\"password\" type=\"password\"required autocomplete=\"off\"/>\n" + 
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
	public Boolean authenticate(String username, String password)
	{
		if(_us.login(username, password))
		{
			loggedIn = _us.getUser(username);
			_us.setUser(loggedIn);
			return true;
		}
		return false;
	}
	public String getProfilePage()
	{
		String profile=""
				+ "<!DOCTYPE html>\n" + 
				"<html ng-app=\"dashboardContent\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <title>Dashboard</title>\n" + 
				"    <link href=\"css/dashBoard.css\" rel=\"stylesheet\">\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
				"    <link href=\"css/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n" + 
				"    <script src=\"js/dashboardSinglePage.js\"></script>\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js\"></script>\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js\"></script>\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js\"></script>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<script type=\"text/ng-template\" id=\"/home.html\">\n" + 
				"    <h1>Home</h1>\n" + 
				"    <h3>{{message}}</h3>\n" + 
				"</script>\n" + 
				"\n" + 
				"<div>\n" + 
				"    <div class=\"col-md-10 content\">\n" + 
				"\n" + 
				"        <div class=\"col-md-2 news-events\">\n" + 
				"\n" + 
				"            <div class=\"last-event-text\">\n" + 
				"            <p>رویداد های اخیر</p>\n" + 
				"        </div>";
		String events = "            <div class=\"events\">\n" ;
		
		while(!_us.events.isEmpty())
		{
			events = events + "            <div class=\"single-events comment\">\n" + 
					"                <img class=\"img-responsive little-item-space\" src=\"Shop%20page/pens.jpg\">\n" + 
					"                <p class=\"inline-text pCm\">" +
					_us.events.pop() +
					"</p>\n" + 
					"                <p class=\"date\">اسفند 95</p>\n" + 
					"            </div>";
		}
		events = events + "\n" + 
				"        </div>\n" + 
				"\n" + 
				"            <hr/>";
		
		String news = "            <div class=\"news\">";
		
		news = news + "            <button class=\"all-posts-btn\">نمایش همه پست ها</button>\n" + 
				"\n";
		while(!_us.news.isEmpty())
				news = news + _us.newstitles.pop();
		news = news + "        </div>\n" + 
				"\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div ng-view class=\"col-md-10 verticalLine counts-bar\">\n" + 
				"        </div>\n" + 
				"\n" + 
				"    </div>\n" + 
				"";
		String panelOwner =
				"    <div class=\"col-md-2 panel-owner\">\n" + 
				"        <div class=\"image-owner\">\n" + 
				"            <img class=\"img-circle\" src=\"Shop%20page/seller.jpg\" alt=\"\" height=\"100\" width=\"100\">\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"name-owner\">\n" + 
				"            <p>" + loggedIn.getUserName()
				+ "</p>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div>\n" + 
				"            <div class=\"panel-group\" id=\"accordion\">\n" + 
				"                <div class=\"panel\">\n" + 
				"                    <div class=\"panel-heading\">\n" + 
				"                        <h4 class=\"panel-title\">\n" + 
				"                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-dashboard icon-1x icon-align\"></i>میز کار</a>\n" + 
				"                        </h4>\n" + 
				"                    </div>\n" + 
				"\n" + 
				"                    <div class=\"panel-collapse collapse in\">\n" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                    <div class=\"panel-heading\">\n" + 
				"                        <h4 class=\"panel-title\">\n" + 
				"                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#StocksManage\"><i class=\" icon-1x icon-align\"></i>مدیریت محصولات</a>\n" + 
				"                        </h4>\n" + 
				"                    </div>\n" + 
				"                    <div  id=\"StocksManage\" class=\"panel-collapse collapse\">\n" + 
				"                        <div class=\"sub-panel\">\n" + 
				"                            <i class=\"icon-plus-sign-alt icon-1x icon-align\"></i>\n" + 
				"                            <a href=\"#newStock\">محصول جدید</a>\n" + 
				"\n" + 
				"                        </div>\n" + 
				"                        <div class=\"sub-panel\">\n" + 
				"                            <a href=\"#vitrin\">ویترین ها</a>\n" + 
				"                            <i class=\"icon-reorder icon-1x icon-align\"></i>\n" + 
				"                        </div>\n" + 
				"                        <div class=\"sub-panel\">\n" + 
				"                            <a href=\"#customerComment\">دیدگاه مشتریان</a>\n" + 
				"                            <i class=\"icon-comment-alt icon-1x icon-align\"></i>\n" + 
				"                        </div>\n" + 
				"                        <div class=\"sub-panel\">\n" + 
				"                            <a href=\"#Sending\">روش های ارسال</a>\n" + 
				"                            <i class=\"icon-location-arrow icon-1x icon-align\"></i>\n" + 
				"                        </div>\n" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"";
		String panel = "                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-percent icon-1x icon-align\"></i>تخفیف ها</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-bar-chart icon-1x icon-align\"></i>آمار</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-credit-card icon-1x icon-align\"></i>امور مالی</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-rocket icon-1x icon-align\"></i>تبلیغات</a>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseThree\">راهنمای فروش</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-question-sign icon-1x icon-align\"></i>سوالات متداول</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                <div class=\"panel-heading\">\n" + 
				"                    <h4 class=\"panel-title\">\n" + 
				"                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-microphone icon-1x icon-align\"></i>گزارش خرابی</a>\n" + 
				"                    </h4>\n" + 
				"                </div>\n" + 
				"                <div class=\"panel-collapse collapse\">\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"                <div class=\"panel\">\n" + 
				"                    <div class=\"panel-heading\">\n" + 
				"                        <h4 class=\"panel-title\">\n" + 
				"                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\"><i class=\"icon-power-off icon-1x icon-align\"></i>خروج</a>\n" + 
				"                        </h4>\n" + 
				"                    </div>\n" + 
				"                    <div class=\"panel-collapse collapse\">\n" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"\n" + 
				"            </div>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"Honarista-connection\">\n" + 
				"            <button class=\"button tel-twitt-btn\"><i class=\"icon-location-arrow icon-1x icon-connection\"></i>کانال تلگرام هنریستا</button>\n" + 
				"            <button class=\"button insta-btn\"><i class=\"icon-instagram icon-1x icon-connection\"></i>اینستاگرام هنریستا</button>\n" + 
				"            <button class=\"button tel-twitt-btn\"><i class=\"icon-twitter icon-1x icon-connection\"></i>توییتر هنریستا</button>\n" + 
				"        </div>\n" + 
				"\n" + 
				"    </div>\n" + 
				"\n" + 
				"</div>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		return profile + events + news + panelOwner + panel;
	}
	public String viewAllShops()
	{
		String before = "<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <title>Honarista</title>\n" + 
				"    <meta charset=\"utf-8\">\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"    <link rel=\"stylesheet\" href=\"css/setting.css\">\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"<div class=\"first-fixed-nav-bar\">\n" + 
				"\n" + 
				"    <div class=\"btn-group inline pull-right\">\n" + 
				"        <a href=\"registerForm.html\"><div class=\"btn btn-space btn-success\">ورود به سایت</div></a>\n" + 
				"    </div>\n" + 
				"\n" + 
				"\n" + 
				"</div >\n" + 
				"\n" + 
				"<div class=\"scd-fixed-nav-bar\">\n" + 
				"    <div class=\"btn-group inline pull-right\">\n" + 
				"        <div class=\"btn btn-space\">هنر خلاق</div>\n" + 
				"        <div class=\"btn btn-space\">اسباب بازی</div>\n" + 
				"        <div class=\"btn btn-space\">چوب</div>\n" + 
				"        <div class=\"btn btn-space\">گیاه</div>\n" + 
				"        <div class=\"btn btn-space\">آنتیک</div>\n" + 
				"        <div class=\"btn btn-space\">پوشیدنی</div>\n" + 
				"        <div class=\"btn btn-space\">جواهرات</div>\n" + 
				"        <div class=\"btn btn-space\">دکوراسیون خانه</div>\n" + 
				"        <div class=\"btn btn-space\">تالار مشاهیر</div>\n" + 
				"    </div>\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"homepage-background\">\n" + 
				"\n" + 
				"    <div>\n" + 
				"        <p>با خرید هر یک از دست سازه های هنرمندان هنریستا، یک درخت به نام شما در ایران می کاریم! :)</p>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div></div>\n" + 
				"    <div></div>\n" + 
				"\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"orange-layer\"></div>\n" + 
				"\n" + 
				"<div class=\"gift-search\">\n" + 
				"\n" + 
				"    <div class=\"btn-group inline pull-left btn-group-justified\" data-toggle=\"buttons-checkbox\">\n" + 
				"        <div class=\"btn btn-warning btn-space\">نه، فعلا دارم چرخ میزنم!</div>\n" + 
				"        <div class=\"btn btn-primary btn-space\">اوهوم</div>\n" + 
				"        <div class=\"btn btn-space\">می گردی؟</div>\n" + 
				"\n" + 
				"        <div class=\"btn-group btn-space\">\n" + 
				"            <button type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\">\n" + 
				"                همکلاسی دخترت <span class=\"caret\"></span>\n" + 
				"            </button>\n" + 
				"            <ul class=\"dropdown-menu\" role=\"menu\">\n" + 
				"                <li><a href=\"#\" id=\"btn1\">دوست</a></li>\n" + 
				"                <li><a href=\"#\" id=\"btn2\">خانواده</a></li>\n" + 
				"                <li><a href=\"#\" id=\"btn3\">مادرت</a></li>\n" + 
				"            </ul>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"btn btn-space\">برای</div>\n" + 
				"\n" + 
				"        <div class=\"btn-group btn-space\">\n" + 
				"            <button type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\">\n" + 
				"                10 تا 50 تومانی  <span class=\"caret\"></span>\n" + 
				"            </button>\n" + 
				"            <ul class=\"dropdown-menu\" role=\"menu\">\n" + 
				"                <li><a href=\"#\" id=\"btn1\">50 تا 100 تومانی</a></li>\n" + 
				"                <li><a href=\"#\" id=\"btn2\">150 تا 200 تومانی</a></li>\n" + 
				"                <li><a href=\"#\" id=\"btn3\">200 به بالا</a></li>\n" + 
				"            </ul>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"btn btn-space\" >دنبال یک هدیه</div>\n" + 
				"\n" + 
				"\n" + 
				"    </div>\n" + 
				"\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"home-category\">\n" + 
				"\n" + 
				"    <div align=\"center\">\n" + 
				"        <h3>دسته بندی های منتخب</h3>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div class=\"row\">\n" + 
				"\n" + 
				"        <div class=\"col-md-1\"></div>\n" + 
				"";
		String after = "    </div>\n" + 
				"\n" + 
				"</div>\n" + 
				""
				+ "<div class=\"home-gallery\">\n" + 
				"\n" + 
				"    <div align=\"center\">\n" + 
				"        <h3>گالری های منتخب</h3>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div class=\"row\">\n" + 
				"\n" + 
				"        <div class=\"col-md-2\"></div>\n" + 
				"        <div class=\"col-md-2\">\n" + 
				"            <a href=\"\">\n" + 
				"                <img src=\"Photos/forest.jpg\" class=\"img-rounded\" alt=\"forest\" style=\"width:100%\">\n" + 
				"                <div class=\"caption\">\n" + 
				"                    <p>تراریوم مینی فارست</p>\n" + 
				"                </div>\n" + 
				"            </a>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"col-md-2\">\n" + 
				"            <a href=\"\">\n" + 
				"                <img src=\"Photos/wall.jpg\" class=\"img-rounded\" alt=\"wall\" style=\"width:100%\">\n" + 
				"                <div class=\"caption\">\n" + 
				"                    <p>دیوار چوب</p>\n" + 
				"                </div>\n" + 
				"            </a>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"col-md-2\">\n" + 
				"            <a href=\"\">\n" + 
				"                <img src=\"Photos/silver.jpg\" class=\"img-rounded\" alt=\"silver\" style=\"width:100%\">\n" + 
				"                <div class=\"caption\">\n" + 
				"                    <p>نقره آرت</p>\n" + 
				"                </div>\n" + 
				"            </a>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div class=\"col-md-2\">\n" + 
				"            <a href=\"\">\n" + 
				"                <img src=\"Photos/kaktoos.jpg\" class=\"img-rounded\" alt=\"kaktoos\" style=\"width:100%\">\n" + 
				"                <div class=\"caption\">\n" + 
				"                    <p>خانه کاکتوس</p>\n" + 
				"                </div>\n" + 
				"            </a>\n" + 
				"        </div>\n" + 
				"\n" + 
				"    </div>\n" + 
				"\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"home-icons\">\n" + 
				"    <img src=\"Home%20Page/Artistic%20Icons%20Row.png\" class=\"img-rounded\" alt=\"Icons\" style=\"width:100%\">\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"home-gap\">\n" + 
				"\n" + 
				"</div>\n" + 
				"\n" + 
				"<div class=\"home-footer\">\n" + 
				"    <div class=\"row\">\n" + 
				"\n" + 
				"    </div>\n" + 
				"</div>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		
		
		String shopView = "";
		for(int i=0; i<_ss.getAllShops().size(); i++)
		{
			shopView = shopView + "        <div class=\"col-md-2\">\n" + 
					"            <a href=\"\">\n" + 
					"                <img src=\""
					+ _ss.getAllShops().elementAt(i).getAdress()
					+ "\" class=\"img-rounded\" alt=\"art\" style=\"width:100%\">\n" + 
					"                <div class=\"caption\">\n" + 
					"                    <p>"
					+ _ss.getAllShops().elementAt(i).getName()
					+ 					 "</p>\n" + 
					"                </div>\n" + 
					"            </a>\n" + 
					"        </div> \n";
		}
		
		return before + shopView + after;
	}
}
