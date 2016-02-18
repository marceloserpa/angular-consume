(function(){
  'use strict';

  angular
    .module('bookStoreApp')
    .controller('BookController', BookController);

  BookController.$inject = ['BookService', '$routeParams', 'action'];

  function BookController(BookService, $routeParams, action){

    var vm = this;
    vm.editForm = {};

    vm.get = function(){
      BookService.getAll().then(function(data) {
        vm.books = data;
      });
    };

    vm.save = function(){
      BookService.save(vm.createForm).then(function(data) {
        vm.get();
        vm.cleanForm();
      });
    };

    vm.delete = function(id){
      BookService.deleteById(id).then(function(){
        vm.get();
      });
    };

    vm.update = function(){
      BookService.update(vm.editForm).then(function(){
        vm.get();
        vm.cleanEditForm();
      });
    };

    vm.cleanEditForm = function(){
      vm.editForm = {
        'id': '',
        'title': '',
        'description': '',
        'author': ''
      };
    };

    vm.initEditForm = function(id){
      BookService.find(id).then(function(data) {
        vm.editForm = data;
      });
    };

    vm.initShowPage = function(id){
      BookService.find(id).then(function(data) {
        vm.book = data;
      });
    };

    vm.cleanForm = function(){
      vm.createForm = {
        'title': '',
        'description': '',
        'author': ''
      };
    };

    if(action === 'list'){
      vm.get();
    } else if(action === 'edit'){
      vm.initEditForm($routeParams.id);
    } else if(action == 'new') {
      vm.cleanForm();
    } else if(action == 'show'){
      vm.initShowPage($routeParams.id);
    }

  };
})();
