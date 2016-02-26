(function(){
  'use strict'

  angular
    .module('books')
    .constant('URL_BOOK_API', 'http://localhost:8080/api/books/')
    .service('BookService', BookService);

  BookService.$inject = ['$http', '$q', 'URL_BOOK_API'];

  function BookService($http, $q, URL_BOOK_API){

    return {
      getAll : getAll,
      save : save,
      deleteById : deleteById,
      update : update,
      find : find
    }

    function getAll(){
      return $http.get(URL_BOOK_API)
        .then(handleCompleteHttpRequest)
        .catch(handleErrorHttpRequest);
    };

    function save(book){
      return $http.post(URL_BOOK_API, book)
        .then(handleCompleteHttpRequest)
        .catch(handleErrorHttpRequest);
    }

    function deleteById(id){
      return $http.delete(URL_BOOK_API + id)
        .then(handleCompleteHttpRequest)
        .catch(handleErrorHttpRequest);
    }

    function update(book){
      return $http.put(URL_BOOK_API+ book.id, book)
        .then(handleCompleteHttpRequest)
        .catch(handleErrorHttpRequest);
    }

    function find(id){
      return $http.get(URL_BOOK_API+id)
        .then(handleCompleteHttpRequest)
        .catch(handleErrorHttpRequest);
    }

    function handleCompleteHttpRequest(response){
      return response.data;
    }

    function handleErrorHttpRequest(error){
      var newMessage = 'XHR Failed for acess Book API'
      if (error && error.data && error.data.description) {
        newMessage = newMessage + '\n' + error.data.description;
      }
      error.data = newMessage;
      console.error(error.data);
      $q.reject(error);
    }

  }
})();
