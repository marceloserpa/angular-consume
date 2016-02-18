(function(){
  'use strict';

  angular
    .module('bookStoreApp')
    .controller('BookController', BookController);

  BookController.$inject = ['BookService', '$scope', '$routeParams', 'action'];

  function BookController(BookService, $scope, $routeParams, action){

    $scope.editForm = {};

    $scope.get = function(){
      BookService.getAll().then(function(data) {
        $scope.books = data;
      });
    };

    $scope.save = function(){
      BookService.save($scope.createForm).then(function(data) {
        $scope.get();
        $scope.cleanForm();
      });
    };

    $scope.delete = function(id){
      BookService.deleteById(id).then(function(){
        $scope.get();
      });
    };

    $scope.update = function(){
      BookService.update($scope.editForm).then(function(){
        $scope.get();
        $scope.cleanEditForm();
      });
    };

    $scope.cleanEditForm = function(){
      $scope.editForm = {
        'id': '',
        'title': '',
        'description': '',
        'author': ''
      };
    };

    $scope.initEditForm = function(id){
      BookService.find(id).then(function(data) {
        $scope.editForm = data;
      });
    };

    $scope.initShowPage = function(id){
      BookService.find(id).then(function(data) {
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

  };
})();
