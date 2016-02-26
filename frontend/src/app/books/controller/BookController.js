(function(){
  'use strict';

  angular
    .module('books')
    .controller('BookController', BookController);

  BookController.$inject = ['BookService', '$routeParams', 'action'];

  function BookController(BookService, $routeParams, action){

    var vm = this;
    vm.book = {};
    vm.books = [];

    vm.get = get;
    vm.save = save;
    vm.deleteBook = deleteBook;
    vm.update = update;

    vm.cleanModel = cleanModel;
    vm.initModel = initModel;

    function get(){
      BookService.getAll().then(function(data) {
        vm.books = data;
      });
    };

    function save(){
      BookService.save(vm.book).then(function(data) {
        vm.get();
        vm.cleanModel();
      });
    };

    function deleteBook(id){
      BookService.deleteById(id).then(function(){
        vm.get();
      });
    };

    function update(){
      BookService.update(vm.book).then(function(){
        vm.get();
        vm.cleanModel();
      });
    };

    function initModel(id){
      BookService.find(id).then(function(data) {
        vm.book = data;
      });
    };

    function cleanModel(){
      vm.book = {
        'id': '',
        'title': '',
        'description': '',
        'author': ''
      };
    };

    if(action === 'list'){
      vm.get();
    } else if(action === 'edit' || action == 'show'){
      vm.initModel($routeParams.id);
    } else if(action == 'new') {
      vm.cleanModel();
    }

  };
})();
