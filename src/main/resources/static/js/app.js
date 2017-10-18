var app = angular.module('myApp', []);


var dvdService = app.service('dvdService', function($http) {
  var API_SERVICE = 'http://localhost:8080/api/rest/v1/dvds';

    //获取dvd
  this.getDvds = function() {
    return $http.get(API_SERVICE);
  };

    //删除dvd
  this.deleteDvd = function(dvdId){
    return $http.delete(`${API_SERVICE}/${dvdId}`);
  };

    //添加dvd
  this.addDvd = function(dvd){
    return $http.post(`${API_SERVICE}`, dvd);
  }

});

app.controller('showDvdController', function($scope, dvdService){
    var refreshData = function(){
        dvdService.getDvds().then(function(response){
                $scope.dvds = response.data;
        });
    }

    refreshData();

    $scope.del = function(dvdId){
        dvdService.deleteDvd(dvdId).then(function(response){
            refreshData();
        });
    };

    $scope.addDvd = function(){
        dvdService.addDvd($scope.dvd).then(function(response){
            refreshData();
        });
    };


});
