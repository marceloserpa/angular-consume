bookStoreApp.controller('BookController', function ($scope, $http, $routeParams) {

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

  $scope.cleanForm = function(){
    $scope.createForm = {
      'title': '',
      'description': '',
      'author': ''
    };
  };
  if(typeof $routeParams.id !== undefined && typeof $routeParams.id !== 'undefined'){
    $scope.initEditForm($routeParams.id)
  }
  $scope.get();
});
