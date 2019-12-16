var app =angular.module('myBanqueApp',[]);
app.controller('myBanqueController',function ($scope,$http) {
    $scope.compte=null
    $scope.operation={type:"versement",montant:0}
    $scope.pageOperations=[];
    $scope.codeCompte=null;

    $scope.chargerCompte=function () {
        $http.get("/comptes/"+ $scope.codeCompte)
            .then(function(response) {
                $scope.compte= response.data;
                $scope.chargerOperations();
            });

    };


    $scope.chargerOperations=function () {

        $http.get("/operations?codeCompte="+ $scope.codeCompte+"&page=0&size=3")
            .then(function(response) {
                $scope.pageOperations= response.data;
            });

    };


    


    $scope.saveOperation=function () {
        $http({
            method : 'PUT',
            url    :$scope.operation.type,
            data   :"codeCompte="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmploye=3",
            headers: {'Content-type':'application/x-www-form-urlencoded'}
        })
            .then(function(response) {
                $scope.chargerCompte();
            })

    }
    
});