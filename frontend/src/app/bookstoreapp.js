'use strict';

var bookStoreApp = angular.module('bookStoreApp', ['ngRoute']);

bookStoreApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/books', {
        templateUrl: 'app/books/view/list.html',
        controller: 'BookController'
      }).
      when('/books/new', {
        templateUrl: 'app/books/view/create.html',
        controller: 'BookController'
      }).
      when('/books/:id/edit', {
        templateUrl: 'app/books/view/edit.html',
        controller: 'BookController'
      });
  }]);
