(function(){
  'use strict'

  angular
    .module('books')
    .config(ConfigureRoutes);

  ConfigureRoutes.$inject = ['$routeProvider'];

  function ConfigureRoutes($routeProvider) {
    $routeProvider.
      when('/books', {
        templateUrl: 'app/books/view/list.html',
        controller: 'BookController',
        controllerAs: 'bookVm',
        resolve: {
          action: function(){
              return 'list';
          }
        }
      }).
      when('/books/new', {
        templateUrl: 'app/books/view/create.html',
        controller: 'BookController',
        controllerAs: 'bookVm',
        resolve: {
          action: function(){
              return 'new';
          }
        }
      }).
      when('/books/:id/edit', {
        templateUrl: 'app/books/view/edit.html',
        controller: 'BookController',
        controllerAs: 'bookVm',
        resolve: {
          action: function(){
              return 'edit';
          }
        }
      }).
      when('/books/:id/show', {
        templateUrl: 'app/books/view/show.html',
        controller: 'BookController',
        controllerAs: 'bookVm',
        resolve: {
          action: function(){
              return 'show';
          }
        }
      });
  };
})();
