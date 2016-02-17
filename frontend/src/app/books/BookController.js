(function(){
  'use strict';
  
  angular.module('bookStoreApp').controller('BookController', ['$scope', '$http', '$routeParams', 'action', function ($scope, $http, $routeParams, action) {

    $scope.editForm = {};

    $scope.get = function(){
      $http.get("http://localhost:8080/api/books").success(function(data) {
        $scope.books = data;
      });
    };

    $scope.save = function(){
      var book = $scope.createForm;
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

    $scope.update = function(){
      var book = $scope.editForm;
      $http.put('http://localhost:8080/api/books/'+ book.id, book).success(function(){
        $scope.get();
        $scope.editForm = {
          'id': '',
          'title': '',
          'description': '',
          'author': ''
        };
      });
    };

    $scope.initEditForm = function(id){
      $http.get("http://localhost:8080/api/books/"+id).success(function(data) {
        $scope.editForm = data;
      });
    };

    $scope.initShowPage = function(id){
      $http.get("http://localhost:8080/api/books/"+id).success(function(data) {
        $scope.book = data;
      });
    };

    $scope.cleanForm = function(){
      $scope.createForm = {
        'title': '',
        'description': '',
        'author': ''
      };
    };

    if(action === 'list'){
      $scope.get();
    } else if(action === 'edit'){
      $scope.initEditForm($routeParams.id);
    } else if(action == 'new') {
      $scope.cleanForm();
    } else if(action == 'show'){
      $scope.initShowPage($routeParams.id);
    }

  }]);
})();
