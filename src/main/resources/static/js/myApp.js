var app =angular.module('myBanqueApp',[]);
app.controller('myBanqueController',function ($scope,$http) {
    $scope.compte=null
    $scope.operation={type:"versement",montant:0}
    $scope.pageOperations=[];
    $scope.codeCompte=null;
    $scope.pageCourante=0;
    $scope.pageSize=3;
    $scope.pages=[];

    $scope.chargerCompte=function () {
        $scope.pageCourante=0;
        $http.get("/comptes/"+ $scope.codeCompte)
            .then(function(response) {
                $scope.compte= response.data;
                $scope.chargerOperations();
            });

    };


    $scope.chargerOperations=function () {

        $http.get("/operations?codeCompte="+ $scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
            .then(function(response) {
                $scope.pageOperations= response.data;
                $scope.pages=new Array(response.data.totalPages)
            });

    };


    $scope.goToPage=function (p) {
        $scope.pageCourante=p;
        $scope.chargerOperations();
        
    }


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