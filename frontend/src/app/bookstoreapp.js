'use strict';

var bookStoreApp = angular.module('bookStoreApp', []);

bookStoreApp.config(function ( $httpProvider) {
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
})
// define controllers
bookStoreApp.controller('BookController', function ($scope, $http) {

  $scope.get = function(){
    $http.get("http://localhost:8080/api/books").success(function(data) {
      $scope.books = data;
    });
  };

  $scope.save = function(){
    var book = $scope.book;
    $http.post('http://localhost:8080/api/books', book).success(function(){
      $scope.get();
      $scope.cleanForm();
    });
  };

  $scope.delete = function(id){
    $http.delete('http://localhost:8080/api/books/' + id).success(function(){
      $scope.get();
    });
  };

  $scope.cleanForm = function(){
    $scope.book = {
      'title': '',
      'description': '',
      'author': ''
    };
  };

  $scope.get();
});