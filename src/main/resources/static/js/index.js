var app = angular.module('myApp', []);

app.controller('myController',function($scope, $http){

    $http.get("http://localhost:8080/api/rest/v1/dvds").then(function (response) {
        $scope.dvds = response.data;
    });
});
