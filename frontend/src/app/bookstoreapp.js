'use strict';

var bookStoreApp = angular.module('bookStoreApp', ['ngRoute']);

bookStoreApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/books', {
        templateUrl: 'app/books/view/list.html',
        controller: 'BookController',
        resolve: {
          action: function(){
              return 'list';
          }
        }
      }).
      when('/books/new', {
        templateUrl: 'app/books/view/create.html',
        controller: 'BookController',
        resolve: {
          action: function(){
              return 'new';
          }
        }
      }).
      when('/books/:id/edit', {
        templateUrl: 'app/books/view/edit.html',
        controller: 'BookController',
        resolve: {
          action: function(){
              return 'edit';
          }
        }
      }).
      when('/books/:id/show', {
        templateUrl: 'app/books/view/show.html',
        controller: 'BookController',
        resolve: {
          action: function(){
              return 'show';
          }
        }
      });
  }]);
