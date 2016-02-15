'use strict';

var bookStoreApp = angular.module('bookStoreApp', []);

// define controllers
bookStoreApp.controller('BookCtrl', function ($scope, $http) {
  var controller = this;

  controller.get = function(){
    $http.get("http://localhost:8080/api/books").success(function(data) {
      $scope.books = data;
    });
  };

  controller.get();
});
