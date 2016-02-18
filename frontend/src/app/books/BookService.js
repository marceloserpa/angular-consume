(function(){
  'use strict'

  angular
    .module('bookStoreApp')
    .service('BookService', BookService);

  BookService.$inject = ['$http'];

  function BookService($http){

    return {
      getAll : getAll,
      save : save,
      deleteById : deleteById,
      update : update,
      find : find
    }

    function getAll(){
      return $http.get("http://localhost:8080/api/books")
          .then(function(response){
            return response.data;
          })
          .catch(function(error){
            console.log(error.data);
          });
    };

    function save(book){
      return $http.post('http://localhost:8080/api/books', book)
          .then(function(response){
            return response.data;
          })
          .catch(function(error){
            console.log(error.data);
          });
    }

    function deleteById(id){
      return $http.delete('http://localhost:8080/api/books/' + id)
          .then(function(response){
            return response.data;
          })
          .catch(function(error){
            console.log(error.data);
          });
    }

    function update(book){
      return $http.put('http://localhost:8080/api/books/'+ book.id, book)
          .then(function(response){
            return response.data;
          })
          .catch(function(error){
            console.log(error.data);
          });
    }

    function find(id){
      return $http.get("http://localhost:8080/api/books/"+id)
        .then(function(response){
          return response.data;
        })
        .catch(function(error){
          console.log(error.data);
        });
    }

  }
})();
