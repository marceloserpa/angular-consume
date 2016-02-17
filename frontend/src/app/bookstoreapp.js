'use strict';

var bookStoreApp = angular.module('bookStoreApp', []);

bookStoreApp.config(function ( $httpProvider) {
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});
