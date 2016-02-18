(function(){
  'use strict';

  angular
    .module('bookStoreApp')
    .controller('BookController', BookController);

  BookController.$inject = ['BookService', '$routeParams', 'action'];

  function BookController(BookService, $routeParams, action){

    var vm = this;

    vm.editForm = {};
    vm.createForm = {};
    vm.book = {};

    vm.get = get;
    vm.save = save;
    vm.deleteBook = deleteBook;
    vm.update = update;

    vm.cleanForm = cleanForm;
    vm.cleanEditForm = cleanEditForm;

    vm.initEditForm = initEditForm;
    vm.initShowPage = initShowPage;


    function get(){
      BookService.getAll().then(function(data) {
        vm.books = data;
      });
    };

    function save(){
      BookService.save(vm.createForm).then(function(data) {
        vm.get();
        vm.cleanForm();
      });
    };

    function deleteBook(id){
      BookService.deleteById(id).then(function(){
        vm.get();
      });
    };

    function update(){
      BookService.update(vm.editForm).then(function(){
        vm.get();
        vm.cleanEditForm();
      });
    };

    function cleanEditForm(){
      vm.editForm = {
        'id': '',
        'title': '',
        'description': '',
        'author': ''
      };
    };

    function initEditForm(id){
      BookService.find(id).then(function(data) {
        vm.editForm = data;
      });
    };

    function initShowPage(id){
      BookService.find(id).then(function(data) {
        vm.book = data;
      });
    };

    function cleanForm(){
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
