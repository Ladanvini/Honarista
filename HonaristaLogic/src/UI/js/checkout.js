var app = angular.module('myApp', []);
app.controller('post-ctrl', ['$scope', function($scope){

    $scope.pishtazPost = function() {
        $scope.post = "پست پیشتاز";
        $scope.postPay="2,000";
        $scope.postExp= "با انتخاب پست پیشتاز به عنوان روش ارسال، فروشنده محصولات خریداری شده شما را بین 2 تا 5 روز کاری ارسال خواهد کرد";
    };

    $scope.tipaxPost = function() {
        $scope.post = "پست تیپاکس";
        $scope.postPay="10,000";
        $scope.postExp= "با انتخاب پست تیپاکس به عنوان روش ارسال، فروشنده محصولات خریداری شده شما را بین 2 تا 3 روز کاری ارسال خواهد کرد";
    };

    $scope.sefareshiPost = function() {
        $scope.post = "پست سفارشی";
        $scope.postPay="1,000";
        $scope.postExp= "با انتخاب پست سفارشی به عنوان روش ارسال، فروشنده محصولات خریداری شده شما را بین 4 تا 5 روز کاری ارسال خواهد کرد";
    };

}]);


