var app =angular.module('myBanqueApp',[]);
app.controller('myBanqueController',function ($scope,$http) {
    $scope.compte=null
    $scope.operation={type:"versement",montant:0,codeCompte2:null}
    $scope.pageOperations=[];
    $scope.codeCompte=null;
    $scope.pageCourante=0;
    $scope.pageSize=3;
    $scope.pages=[];
    $scope.codeCompte1=null;
    $scope.errorMessage=null;


    $scope.chargerCompte=function () {
        $scope.pageCourante=0;
        $http.get("/comptes/"+ $scope.codeCompte)
            .then(function(response) {
                $scope.compte= response.data;
                $scope.chargerOperations();
            },function (response) {
                $scope.errorMessage=response.data.message;
            });

    };


    $scope.chargerOperations=function () {
        $scope.errorMessage=null;
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
        var params="";
        if ($scope.operation.type=='virement'){
            params=  "codeCompte1="+$scope.codeCompte+"&codeCompte2="+$scope.operation.codeCompte2+"&montant="+$scope.operation.montant+"&codeEmploye=3";

        }
        else
            params="codeCompte="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmploye=3";


        $http({
            method : 'PUT',
            url    :$scope.operation.type,
            data   :params,
            headers: {'Content-type':'application/x-www-form-urlencoded'}
        })
            .then(function(response) {
                $scope.chargerCompte();

            },function(response) {
            $scope.errorMessage=response.data.message;

            })
        ;

    }
    
});